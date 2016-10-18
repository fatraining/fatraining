package training2016.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.NorrisDao;
import training2016.model.Norris;
import training2016.model.NorrisSeries;

/**
 * 温泉追加・更新のアクション
 *
 */
@Results({ @Result(name = "norrisSearch", value = "norrisSearch.action", type = ServletRedirectResult.class) })
public class NorrisUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "情報追加";
	/** ボタンの表示名 */
	private String updateBtnTitle = "追加";

	/** id(更新時のみ) */
	private String id;
	/** シリーズid */
	private String seriesId;
	/** 作品名 */
	private String name;
	/** 公開年 */
	private String year;


	/** コメント */
	private String comment;

	/** メッセージ */
	private String message;
	/** エラーメッセージ */
	private String errorMessage;

	/** エリアプルダウン用マップ */
	private Map<String, String> norrisSeriesMap = new HashMap<String, String>();

	// イニシャライザ 最初の入力項目をはずす
	{
		this.setNorrisSeriesMap();
	}

	@Override // 更新
	public String execute() throws Exception {
		this.setNorrisSeriesMap();

		// セッションマップから指定のキーでputされた更新対象のidを取得
		this.id = this.getValueFromSession("updateId");

		NorrisDao dao = new NorrisDao();
		Norris target = null; // 更新対象
		// 更新対象idがあればデータの更新をする
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), Norris.class); // idを引数にして更新対象のobjectを持ってくる
			if (target != null) {
				this.seriesId = String.valueOf(target.getSeriesId()); // IDをStringに
				this.name = target.getName();
				this.year = target.getYear();
				this.comment = target.getComment();

				this.updateBtnTitle = "更新"; // ボタンのvalueを追加→更新
				this.title = "情報をを更新";
			}
		} else {
			// 新規
			this.id = "";
		}
		return "success";
	}



	/**
	 * 必須項目が全部入力済みか確認する
	 *
	 */
	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	/**
	 * updateメソッド idがあれば更新、なければ追加になる 更新、追加し終わったら検索画面にもどる
	 *
	 */
	public String update() {
		this.setNorrisSeriesMap();
		if(this.isEmptyParam(seriesId)){
			addActionError("シリーズを入力してください");
		}
		if(this.isEmptyParam(comment)){
			addActionError("コメントを入力してください");
		}
		if (this.isEmptyParam(name)) {
			addActionError("作品名を入力してください");
		}
		if (this.isEmptyParam(year)) {
			addActionError("公開年を入力してください");
		}if(!year.matches("^[0-9]*$")||year.length()!=4){
			addActionError("公開年には4桁の半角数字（西暦）を入力してください");
		}


		// 一つでもエラーがあればだめ
		if (this.getActionErrors().size() > 0) {
			return "error";
		}

		// idがあれば更新なので、一度取得したモデルに入力値をセットする
		NorrisDao dao = new NorrisDao();
		if (StringUtils.isNotEmpty(this.id)) {
			Norris target = dao.select(Integer.parseInt(this.id), Norris.class);
			// 更新したテーブルを上書き
			dao.update(this.generateNorrisModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else { // 新規の場合
			dao.insert(this.id, this.seriesId, this.name, this.year,this.comment);
			this.message = "追加しました";
			this.sessionMap.put("message", this.message);
		}

		return "norrisSearch";
	}

	/**
	 * 今フィールドに保持している値で引数のモデルにセットして返す(更新用)
	 *
	 */
	private Norris generateNorrisModel(Norris target) {
		target.setSeriesId(Integer.parseInt(this.seriesId));
		target.setName(this.name);
		target.setYear(this.year);
		target.setComment(this.comment);
		return target;
	}

	/* setter・getter */
	/**
	 * updateBtnTitleを返す
	 *
	 * @return updateBtnTitle
	 */
	public String getUpdateBtnTitle() {
		return this.updateBtnTitle;
	}

	/**
	 * titleを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * idをセットする
	 *
	 * @param id
	 *            セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * idを返す
	 *
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * onsenAreaIdをセットする
	 *
	 * @param onsenAreaId
	 *            セットする onsenAreaId
	 */
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}

	/**
	 * onsenAreaIdを返す
	 *
	 * @return onsenAreaId
	 */
	public String getSeriesId() {
		return this.seriesId;
	}

	/**
	 * nameをセットする
	 *
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * nameを返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 効能をセットする
	 *
	 * @param effect
	 *            セットする effect
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 効能を返す
	 *
	 * @return effect
	 */
	public String getYear() {
		return this.year;
	}

	/**
	 * コメントをセットする
	 *
	 * @param comment
	 *            セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * コメントを返す
	 *
	 * @return hours
	 */
	public String getComment() {
		return this.comment;
	}



	/**
	 * メッセージをセットする
	 *
	 * @param message
	 *            セットする messagge
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * メッセージを返す
	 *
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * エラーメッセージを返す
	 *
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/**
	 * エリアプルダウン用マップをセットする
	 *
	 */
	public void setNorrisSeriesMap() {
		NorrisDao dao = new NorrisDao();
		List<?> resultTable = dao.getNorrisSeriesList();
		this.norrisSeriesMap = tableTrans(resultTable);
	}

	/**
	 * エリアマップを返す
	 *
	 * @return onsenAreaMap
	 */
	public Map<String, String> getNorrisSeriesMap() {
		return this.norrisSeriesMap;
	}

	/*-----------------------------------*/
	// エリアプルダウン用マップを返す
	/*-----------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			norrisSeriesMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				NorrisSeries aa = (NorrisSeries) resultTable.get(i);
				norrisSeriesMap.put(aa.getId(), aa.getSeries());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return norrisSeriesMap;
	}
}
