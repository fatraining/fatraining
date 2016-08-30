package training2016.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.YokaiDao;
import training2016.model.Yokai;
import training2016.model.Yokaifrom;

/*
 * 講師追加・更新
 * ここでは妖怪サーチアクションを妖怪サーチとする
 */

@Results({ @Result(name = "yokaiSearch", value = "yokaiSearch.action", type = ServletRedirectResult.class) })
public class YokaiUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;


	/*ボタンの表示名 */
	private String updateBtnTitle = "追加";

	/* id(更新時のみ) */
	private String id;

	/* 生息地id */
	private String yokaifromId;
	/*妖怪の名前 */
	private String name;
	/*特徴 */
	private String type;
	/* コメント */
	private String comment;
	/*リンク */
	private String link;
	/*メッセージ */
	private String message;
	/* エラーメッセージ */
	private String errorMessage;

	/*生息地プルダウン用マップ */
	private Map<String, String> yokaifromMap = new HashMap<String, String>();

	/* 特徴プルダウン用マップ */
	private Map<String, String> typeMap = new LinkedHashMap<String, String>();

	// イニシャライザ
	//最初の入力項目をはずすために初期化
	{
		this.setYokaifromMap();
	}

	@Override // 更新
	public String execute() throws Exception {
		this.setYokaifromMap();
		this.setTypeMap();

		// セッションマップから指定のキーでputされた更新対象のidを取得
		this.id = this.getValueFromSession("updateId");

		//更新データを取得
		YokaiDao dao = new YokaiDao();
		Yokai target = null;
		// 更新対象idがあればデータの更新をする
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), Yokai.class);
			if (target != null) {
				this.yokaifromId = String.valueOf(target.getYokaifromId());
				this.name = target.getName();
				this.type = target.getType();
				this.comment = target.getComment();
				this.link = target.getLink();
				this.updateBtnTitle = "更新"; // ボタンのvalueを追加→更新

			}
		} else {
			// 新規
			this.id = "";

		}
		return "success";
	}




	/*
	 * 必須項目が全部入力済みか確認する
	 */
	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	/*
	 * updateメソッド idがあれば更新、なければ追加になる 更新・追加し終わったら検索画面にもどる
	 *
	 */
	public String update() {
		this.setYokaifromMap();
		this.setTypeMap();

		if (this.isEmptyParam(yokaifromId)) {
			addActionError("生息地を選択してください");
		}
		if (this.isEmptyParam(name)) {
			addActionError("妖怪の名前を入力してください");
		}
		if (this.isEmptyParam(type)) {
			addActionError("特徴を選択してください");
		}
		if (this.isEmptyParam(comment)) {
			addActionError("コメントを入力してください");
		}

		// 一つでもエラーがあればだめ
		if (this.getActionErrors().size() > 0) {

			//チェックされたIDを入れる
			//this.id = this.getValueFromSession("updateId");

			YokaiDao dao = new YokaiDao();
			Yokai target = null;
			// 更新対象idがあればデータの更新をする
			if (StringUtils.isNotEmpty(this.id)) {
				target = dao.select(Integer.parseInt(this.id), Yokai.class);
				if (target != null) {
					this.updateBtnTitle = "更新"; // ボタンのvalueを更新

				}
			}
			return "error";
		}


		YokaiDao dao = new YokaiDao();
		// idがあれば更新なので、一度取得したモデルに入力値をセットする
		if (StringUtils.isNotEmpty(this.id)) {//更新の場合
			Yokai target = dao.select(Integer.parseInt(this.id), Yokai.class);
			//更新したテーブル上書きする
			dao.update(this.generateYokaiModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);

		} else { //新規の場合は
			dao.insert(this.id, this.yokaifromId, this.name, this.type, this.comment, this.link);
			this.message = "妖怪が増えました";
			this.sessionMap.put("message", this.message);


		}

		return "yokaiSearch";
	}

	/*
	 * 今フィールドに保持している値で引数のモデルにセットして返す(更新用)
	 *
	 */
	private Yokai generateYokaiModel(Yokai target) {
		target.setYokaifromId(Integer.parseInt(this.yokaifromId));
		target.setName(this.name);
		target.setType(this.type);
		target.setComment(this.comment);
		target.setLink(this.link);

		return target;
	}

	/* setter・getter */

	/*
	 * idをセットする
	 *
	 * @param id
	 *            セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/*
	 * idを返す
	 *
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/*
	 * youkaifromIdをセットする
	 *
	 * @param youkaifromId
	 *            セットする youkaifromId
	 */
	public void setYokaifromId(String yokaifromId) {
		this.yokaifromId = yokaifromId;
	}

	/*
	 * youkaifromIdを返す
	 *
	 * @return youkaifromId
	 */
	public String getYokaifromId() {
		return this.yokaifromId;
	}

	/*
	 * nameをセットする
	 *
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * nameを返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * typeをセットする
	 *
	 * @param type
	 *            セットする type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/*
	 * typeを返す
	 *
	 * @return type
	 */
	public String getType() {
		return this.type;
	}

	/*
	 * コメントをセットする
	 *
	 * @param comment
	 *            セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/*
	 * コメントを返す
	 *
	 * @return comment セットする comment
	 */
	public String getComment() {
		return this.comment;
	}

	/*
	 * リンクをセットする
	 *
	 * @param link
	 *            セットする link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/*
	 * リンクを返す
	 *
	 * @return link セットする link
	 */
	public String getLink() {
		return this.link;
	}

	/* メッセージをセットする
	 * @param message
	 *    セットする messagge
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/* メッセージを返す

	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

	/*エラーメッセージを返す
	 *
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/*生息地プルダウン用マップをセットする
	 *
	 */
	public void setYokaifromMap() {
		YokaiDao dao = new YokaiDao();
		List<?> resultTable = dao.getYokaifromList();
		this.yokaifromMap = tableTrans(resultTable);
	}

	/*生息地マップを返す
	 *
	 * @return youkaifromMap
	 */
	public Map<String, String> getYokaifromMap() {
		return this.yokaifromMap;
	}

	/*特徴プルダウン用マップをセットする
	 *
	 */
	public void setTypeMap() {
		this.typeMap.put("", "特徴を選択");
		this.typeMap.put("無害", "無害");
		this.typeMap.put("危険", "危険");

	}

	/* 特徴マップを返す
	 *
	 * @return typeMap
	 */
	public Map<String, String> getTypeMap() {
		return this.typeMap;
	}

	/* @return updateBtnTitle
	 */
	public String getUpdateBtnTitle() {
		return updateBtnTitle;
	}

	/*-----------------------------------*/
	// 生息地プルダウン用マップを返す
	/*-----------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			yokaifromMap.put("", "生息地を選択");
			for (int i = 0; i < resultTable.size(); i++) {
				Yokaifrom aa = (Yokaifrom) resultTable.get(i);
				yokaifromMap.put(aa.getId(), aa.getYokaifrom());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return yokaifromMap;
	}
}
