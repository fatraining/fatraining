package training2016.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.MaiwaifuDao;
import training2016.model.Maiwaifu;
import training2016.model.MaiwaifuArea;

/**
 * 追加・更新のあくしょん
 *
 */
@Results({
@Result(name = "maiwaifuSearch", value ="maiwaifuSearch.action", type = ServletRedirectResult.class)
})
public class MaiwaifuUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/**画面タイトル*/
	private String title ="嫁追加";
	/**ボタンの表示名*/
	private String updateBtnTitle = "追加";

	/**id(更新時のみ)*/
	private String id;
	/**エリアid*/
	private String maiwaifuAreaId;
	/* イメージ */
	private String image;
	/**名前*/
	private String name;
	/**ジャンル*/
	private String genre;
	/***/
	private String age;
	/**コメント*/
	private String comment;
	/**メッセージ*/
	private String message;
	/**エラーメッセージ*/
	private String errorMessage;

	/**エリアプルダウン用マップ*/
	private Map<String, String> maiwaifuAreaMap = new HashMap<String, String>();

	/**入場料プルダウン用マップ*/
	private Map<String, String> genreMap = new LinkedHashMap<String, String>();

	// イニシャライザ（初期化して持ってくる。）
	//検索入力の箱の初期設定でvalueでなにかいれてたら、それを初期化する必要がある。
	{
		this.setMaiwaifuAreaMap();
	}

	@Override //更新
	public String execute() throws Exception {
		this.setMaiwaifuAreaMap();
		this.setGenreMap();
		//セッションマップから指定のキーでputされた更新対象のidを取得
		this.id = this.getValueFromSession("updateId");

		MaiwaifuDao dao = new MaiwaifuDao();
		Maiwaifu target = null;
		//更新対象idがあればデータの更新をする
		if(StringUtils.isNotEmpty(this.id)) {

			target = dao.select(Integer.parseInt(this.id), Maiwaifu.class);
			if(target != null) {
				this.maiwaifuAreaId = String.valueOf(target.getMaiwaifuAreaId());
				this.image = target.getImage();
				this.name = target.getName();
				this.genre = target.getGenre();
				this.age = target.getAge();
				this.comment = target.getComment();
				this.updateBtnTitle = "更新";  //ボタンのvalueを追加→更新
				this.title ="更新";
			}
		} else {
			//新規
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
	 * updateメソッド
	 * idがあれば更新、なければ追加になる
	 * 更新、追加し終わったら検索画面にもどる
	 *
	 */
	public String update() {
		this.setMaiwaifuAreaMap();
		this.setGenreMap();

		if(this.isEmptyParam(maiwaifuAreaId)) {
			addActionError("エリアを入力してください");
		}
		if(this.isEmptyParam(image)) {
			addActionError("ファイルパスを入力してください！");
		}
		if(this.isEmptyParam(name)) {
			addActionError("名前を入力してください");
		}
		if(this.isEmptyParam(genre)) {
			addActionError("ジャンルを入力してください");
		}
		if(this.isEmptyParam(age)) {
			addActionError("年齢を入力してください");
		}
		if(this.isEmptyParam(comment)) {
			addActionError("コメントを入力してください");
		}
		//一つでもエラーがあればだめ
		if(this.getActionErrors().size() > 0) {
			return "error";
		}

		//idがあれば更新なので、一度取得したモデルに入力値をセットする
		//更新データを上書きする。
		MaiwaifuDao dao = new MaiwaifuDao();
		if(StringUtils.isNotEmpty(this.id)) {
			Maiwaifu target = dao.select(Integer.parseInt(this.id), Maiwaifu.class);
			dao.update(this.generateMaiwaifuModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else {
			dao.insert(this.id,
					   this.maiwaifuAreaId,
					   this.image,
					   this.name,
					   this.genre,
					   this.age,
					   this.comment);
			this.message = "追加しました";
			this.sessionMap.put("message", this.message);
		}

		return "maiwaifuSearch";
	}

	/**
	 * 今フィールドに保持している値で引数のモデルにセットして返す(更新用)
	 *
	 */
	private Maiwaifu generateMaiwaifuModel(Maiwaifu target) {
		target.setMaiwaifuAreaId(Integer.parseInt(this.maiwaifuAreaId));
		target.setImage(this.image);
		target.setName(this.name);
		target.setGenre(this.genre);
		target.setAge(this.age);
		target.setComment(this.comment);

		return target;
	}

	/*setter・getter*/
	/**
	 * updateBtnTitleを返す
	 * @return updateBtnTitle
	 */
	public String getUpdateBtnTitle() {
		return this.updateBtnTitle;
	}

	/**
	 * titleを返す
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * idをセットする
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * idを返す
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * maiwaifuAreaIdをセットする
	 * @param maiwaifuAreaId セットする maiwaifuAreaId
	 */
	public void setMaiwaifuAreaId(String maiwaifuAreaId) {
		this.maiwaifuAreaId = maiwaifuAreaId;
	}

	/**
	 * maiwaifuAreaIdを返す
	 * @return maiwaifuAreaId
	 */
	public String getMaiwaifuAreaId() {
		return this.maiwaifuAreaId;
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




	/**
	 * nameをセットする
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * nameを返す
	 * @return name
	 */
	public String getName() {
		return  this.name;
	}

	/**
	 * ジャンルをセットする
	 * @param genre セットする genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * ジャンルを返す
	 * @return genre
	 */
	public String getGenre() {
		return this.genre;
	}

	/**
	 * 年齢をセットする
	 * @param age セットする age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * 年齢を返す
	 * @return age
	 */
	public String getAge() {
		return this.age;
	}

	/**
	 * コメントをセットする
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * コメントを返す
	 * @return comment セットする comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * メッセージをセットする
	 * @param message セットする messagge
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * メッセージを返す
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * エラーメッセージを返す
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/**
	 * エリアプルダウン用マップをセットする
	 *
	 */
	public void setMaiwaifuAreaMap() {
		MaiwaifuDao dao = new MaiwaifuDao();
		List<?> resultTable = dao.getMaiwaifuAreaList();
		this.	maiwaifuAreaMap = tableTrans(resultTable);
	}

	/**
	 * エリアマップを返す
	 * @return maiwaifuAreaMap
	 */
	public Map<String, String> getMaiwaifuAreaMap() {
		return this.maiwaifuAreaMap;
	}

	/**
	 * ジャンルプルダウン用マップをセットする
	 *
	 */
	public void setGenreMap() {
		this.genreMap.put("", "");
		this.genreMap.put("cute", "cute");
		this.genreMap.put("beauty", "beauty");
		this.genreMap.put("sexy", "sexy");
		this.genreMap.put("cool", "cool");
		this.genreMap.put("mako", "mako");
		this.genreMap.put("married woman", "marrid woman");
		this.genreMap.put("maniac", "maniac");

	}

	/**
	 * 入場料マップを返す
	 * @return genreMap
	 */
	public Map<String, String> getGenreMap() {
		return this.genreMap;
	}

	/*-----------------------------------*/
	//エリアプルダウン用マップを返す
	/*-----------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			maiwaifuAreaMap.put("", "");
			for(int i = 0; i < resultTable.size(); i++) {
				MaiwaifuArea aa = (MaiwaifuArea) resultTable.get(i);
				maiwaifuAreaMap.put(aa.getId(), aa.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maiwaifuAreaMap;
	}
}
