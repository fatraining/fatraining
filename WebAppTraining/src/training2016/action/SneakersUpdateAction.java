package training2016.action;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.SneakersDao;
import training2016.model.Sneakers;
import training2016.model.SneakersMaker;

/** スニーカー追加・更新のアクション*/

@Results({
@Result(name = "sneakersSearch", value ="sneakersSearch.action", type = ServletRedirectResult.class)
})
public class SneakersUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* 画面タイトル */
	private String title ="スニーカー追加"; //このページのタイトルの初期値は"追加"
	/* ボタンの表示名 */
	private String updateBtnTitle = "追加";

	/* id(更新時のみ) */
	private String id;
	/* メーカーid */
	private String sneakersMakerId;
	/* 製品名 */
	private String name;
	/* シリーズ */
	private String series;
	/* 発売年 */
	private String year;
	/* コメント */
	private String comment;
	/* イメージ */
	private String image;
	/* メッセージ */
	private String message;
	/* エラーメッセージ */
	private String errorMessage;

	/* メーカープルダウン用マップ */
	private Map<String, String> sneakersMakerMap = new HashMap<String, String>();

	/* 発売年プルダウン用マップ */
	private Map<String, String> sneakersYearMap = new LinkedHashMap<String, String>();

	/* イニシャライザ */
	{
		this.setSneakersMakerMap();
	}



	@Override // executeメソッド (更新)
	public String execute() throws Exception {
		this.setSneakersMakerMap();
		this.setSneakersYearMap();
		/* セッションマップから指定のキーでputされた更新対象のidを取得 */
		this.id = this.getValueFromSession("updateId");

		SneakersDao dao = new SneakersDao();
		Sneakers target = null;
		/* 更新対象idがあればデータの更新をする */
		if(StringUtils.isNotEmpty(this.id)) {
			this.title ="スニーカー更新";  //タイトルを"追加"→"更新"
			target = dao.select(Integer.parseInt(this.id), Sneakers.class);
			if(target != null) {
				this.sneakersMakerId = String.valueOf(target.getSneakersMakerId());
				this.name = target.getName();
				this.series = target.getSeries();
				this.year = target.getYear();
				this.comment = target.getComment();
				this.image = target.getImage();
				this.updateBtnTitle = "更新";  //ボタンのvalueを新規登録→更新

			}
		} else {  //新規
			this.id = "";
		}
		return "success";
	}

	/* 必須項目が全部入力済みか確認する */
	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	/**
	 * updateメソッド
	 * （idがあれば更新、なければ追加、
	 * 更新、追加し終わったら検索画面にもどる）
	 */
	public String update() {
		this.setSneakersMakerMap();
		this.setSneakersYearMap();

		if(StringUtils.isNotEmpty(this.id)) {
			this.title ="スニーカー更新";  //idがあればタイトルを"追加"→"更新"
			this.updateBtnTitle = "更新";  //idがあればボタンのvalueを新規登録→更新
		}

		if(this.isEmptyParam(sneakersMakerId)) {
			addActionError("メーカーを入力してください！");
		}
		if(this.isEmptyParam(name)) {
			addActionError("製品名を入力してください！");
		}
		if(this.isEmptyParam(series)) {
			addActionError("シリーズを入力してください！");
		}
		if(this.isEmptyParam(year)) {
			addActionError("発売年を入力してください！");
		}
		if(this.isEmptyParam(comment)) {
			addActionError("コメントを入力してください！");
		}
		if(this.isEmptyParam(image)) {
			addActionError("ファイルパスを入力してください！");
		}

		/*1つでもエラーがあればNG */
		if(this.getActionErrors().size() > 0) {
			return "error";
		}

		/* idがあれば更新なので、一度取得したモデルに入力値をセットする */
		SneakersDao dao = new SneakersDao();
		if(StringUtils.isNotEmpty(this.id)) {  //更新
			Sneakers target = dao.select(Integer.parseInt(this.id), Sneakers.class);
			dao.update(this.generateSneakersModel(target));
			this.message = "更新完了！";
			this.sessionMap.put("message", this.message);
		} else {  //新規
			dao.insert(this.id,
					   this.sneakersMakerId,
					   this.name,
					   this.series,
					   this.year,
					   this.comment,
					   this.image);
			this.message = "登録完了！";
			this.sessionMap.put("message", this.message);
		}
		return "sneakersSearch"; //メイン画面へ遷移
	}

	/* 今フィールドに保持している値で引数のモデルにセットして返す(更新用) */
	private Sneakers generateSneakersModel(Sneakers target) {
		target.setSneakersMakerId(Integer.parseInt(this.sneakersMakerId));
		target.setName(this.name);
		target.setSeries(this.series);
		target.setYear(this.year);
		target.setComment(this.comment);
		target.setImage(this.image);
		return target;
	}

	/*セッター・ゲッター*/
	/** updateBtnTitleを返す
	 *  @return updateBtnTitle */
	public String getUpdateBtnTitle() {
		return this.updateBtnTitle;
	}

	/** titleを返す
	 * @return title */
	public String getTitle() {
		return this.title;
	}

	/** idをセットする
	 * @param id セットする id */
	public void setId(String id) {
		this.id = id;
	}

	/** idを返す
	 * @return id */
	public String getId() {
		return this.id;
	}

	/** sneakersMakerIdをセットする
	 * @param sneakersMakerId セットする sneakersMakerId */
	public void setSneakersMakerId(String sneakersMakerId) {
		this.sneakersMakerId = sneakersMakerId;
	}

	/** sneakersMakerIdを返す
	 * @return sneakersMakerId */
	public String getSneakersMakerId() {
		return this.sneakersMakerId;
	}

	/** 製品名をセットする
	 * @param name セットする name */
	public void setName(String name) {
		this.name = name;
	}

	/** 製品名を返す
	 * @return name */
	public String getName() {
		return this.name;
	}

	/** シリーズをセットする
	 * @param series セットする series */
	public void setSeries(String series) {
		this.series = series;
	}

	/** シリーズを返す
	 * @return series */
	public String getSeries() {
		return this.series;
	}

	/** yearをセットする
	 * @param year セットする year */
	public void setYear(String year) {
		this.year = year;
	}

	/** yearを返す
	 * @return year */
	public String getYear() {
		return  this.year;
	}

	/** コメントをセットする
	 * @param comment セットする comment */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/** コメントを返す
	 * @return comment セットする comment */
	public String getComment() {
		return this.comment;
	}

	/** イメージをセットする
	 * @param image セットする image */
	public void setImage(String image) {
		this.image = image;
	}

	/** イメージを返す
	 * @return image セットする image */
	public String getImage() {
		return this.image;
	}

	/** メッセージをセットする
	 * @param message セットする messagge */
	public void setMessage(String message) {
		this.message = message;
	}

	/** メッセージを返す
	 * @return message */
	public String getMessage() {
		return this.message;
	}

	/** エラーメッセージを返す
	 * @return errorMessage */
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/** メーカープルダウン用マップをセットする */
	public void setSneakersMakerMap() {
		SneakersDao dao = new SneakersDao();
		List<?> resultTable = dao.getSneakersMakerList();
		this.sneakersMakerMap = tableTrans(resultTable);
	}

	/** メーカーマップを返す
	 * @return SneakersMakerMap */
	public Map<String, String> getSneakersMakerMap() {
		return this.sneakersMakerMap;
	}

	/** 発売年プルダウン用マップをセットする */
	public void setSneakersYearMap() {
		this.sneakersYearMap.put("", "");
		this.sneakersYearMap.put("1917", "1917年");
		this.sneakersYearMap.put("1957", "1957年");
		this.sneakersYearMap.put("1966", "1966年");
		this.sneakersYearMap.put("1968", "1968年");
		this.sneakersYearMap.put("1969", "1969年");
		this.sneakersYearMap.put("1970", "1970年");
		this.sneakersYearMap.put("1971", "1971年");
		this.sneakersYearMap.put("1972", "1972年");
		this.sneakersYearMap.put("1973", "1973年");
		this.sneakersYearMap.put("1974", "1974年");
		this.sneakersYearMap.put("1975", "1975年");
		this.sneakersYearMap.put("1976", "1976年");
		this.sneakersYearMap.put("1977", "1977年");
		this.sneakersYearMap.put("1978", "1978年");
		this.sneakersYearMap.put("1979", "1979年");
		this.sneakersYearMap.put("1980", "1980年");
		this.sneakersYearMap.put("1981", "1981年");
		this.sneakersYearMap.put("1982", "1982年");
		this.sneakersYearMap.put("1983", "1983年");
		this.sneakersYearMap.put("1984", "1984年");
		this.sneakersYearMap.put("1985", "1985年");
		this.sneakersYearMap.put("1986", "1986年");
		this.sneakersYearMap.put("1987", "1987年");
		this.sneakersYearMap.put("1988", "1988年");
		this.sneakersYearMap.put("1989", "1989年");
		this.sneakersYearMap.put("1990", "1990年");
		this.sneakersYearMap.put("1991", "1991年");
		this.sneakersYearMap.put("1992", "1992年");
		this.sneakersYearMap.put("1993", "1993年");
		this.sneakersYearMap.put("1994", "1994年");
		this.sneakersYearMap.put("1995", "1995年");
		this.sneakersYearMap.put("1996", "1996年");
		this.sneakersYearMap.put("1997", "1997年");
		this.sneakersYearMap.put("1998", "1998年");
		this.sneakersYearMap.put("1999", "1999年");
		this.sneakersYearMap.put("2000", "2000年");
	}

	/** 入場料マップを返す
	 * @return sneakersSeriesMap */
	public Map<String, String> getSneakersYearMap() {
		return this.sneakersYearMap;
	}

	/** メーカープルダウン用マップを返す */
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			sneakersMakerMap.put("", "");
			for(int i = 0; i < resultTable.size(); i++) {
				SneakersMaker aa = (SneakersMaker) resultTable.get(i);
				sneakersMakerMap.put(aa.getId(), aa.getMaker());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sneakersMakerMap;
	}
}