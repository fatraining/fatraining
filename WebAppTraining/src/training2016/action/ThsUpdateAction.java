package training2016.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.ThsDao;
import training2016.model.Ths;
import training2016.model.ThsSubject;

/**
 * 講師追加・更新
 *
 */
@Results({ @Result(name = "thsSearch", value = "thsSearch.action", type = ServletRedirectResult.class) })
public class ThsUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "おススメの東進講師を入力してください！";
	/** ボタンの表示名 */
	private String updateBtnTitle = "追加";

	/** id(更新時のみ) */
	private String id;
	/** 科目id */
	private String thsSubjectId;
	/** 講師名 */
	private String name;
	/** レベル */
	private String level;
	/** コメント */
	private String comment;
	/** リンク **/
	private String link;
	/** メッセージ */
	private String message;
	/** エラーメッセージ */
	private String errorMessage;

	/** 科目プルダウン用マップ */
	private Map<String, String> thsSubjectMap = new HashMap<String, String>();

	/** レベルプルダウン用マップ */
	private Map<String, String> levelMap = new LinkedHashMap<String, String>();

	// イニシャライザ
	{
		this.setThsSubjectMap();
	}

	@Override // 更新
	public String execute() throws Exception {
		this.setThsSubjectMap();
		this.setLevelMap();
		// セッションマップから指定のキーでputされた更新対象のidを取得
		this.id = this.getValueFromSession("updateId");

		ThsDao dao = new ThsDao();
		Ths target = null;
		// 更新対象idがあればデータの更新をする
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), Ths.class);
			if (target != null) {
				this.thsSubjectId = String.valueOf(target.getThsSubjectId());
				this.name = target.getName();
				this.level = target.getLevel();
				this.comment = target.getComment();
				this.link = target.getLink();
				this.updateBtnTitle = "更新"; // ボタンのvalueを追加→更新
				this.title = "講師情報を更新";
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
	 * updateメソッド idがあれば更新、なければ追加になる 更新・追加し終わったら検索画面にもどる
	 *
	 */
	public String update() {
		this.setThsSubjectMap();
		this.setLevelMap();

		if (this.isEmptyParam(thsSubjectId)) {
			addActionError("科目を選択してください");
		}
		if (this.isEmptyParam(name)) {
			addActionError("講師名を入力してください");
		}
		if (this.isEmptyParam(level)) {
			addActionError("レベルを選択してください");
		}
		if (this.isEmptyParam(comment)) {
			addActionError("コメントを入力してください");
		}
		if (this.isEmptyParam(link)) {
			addActionError("URLを入力してください");
		}
		// 一つでもエラーがあればだめ
		if (this.getActionErrors().size() > 0) {

			this.id = this.getValueFromSession("updateId");

			ThsDao dao = new ThsDao();
			Ths target = null;
			// 更新対象idがあればデータの更新をする
			if (StringUtils.isNotEmpty(this.id)) {
				target = dao.select(Integer.parseInt(this.id), Ths.class);
				if (target != null) {
					this.updateBtnTitle = "更新"; // ボタンのvalueを追加→更新
					this.title = "講師情報を更新";
				}
			}
			return "error";
		}

		// idがあれば更新なので、一度取得したモデルに入力値をセットする
		ThsDao dao = new ThsDao();
		if (StringUtils.isNotEmpty(this.id)) {
			Ths target = dao.select(Integer.parseInt(this.id), Ths.class);
			dao.update(this.generateThsModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else {
			dao.insert(this.id, this.thsSubjectId, this.name, this.level, this.comment, this.link);
			this.message = "登録しました";
			this.sessionMap.put("message", this.message);
		}

		return "thsSearch";
	}

	/**
	 * 今フィールドに保持している値で引数のモデルにセットして返す(更新用)
	 *
	 */
	private Ths generateThsModel(Ths target) {
		target.setThsSubjectId(Integer.parseInt(this.thsSubjectId));
		target.setName(this.name);
		target.setLevel(this.level);
		target.setComment(this.comment);
		target.setLink(this.link);

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
	 * thsSubjectIdをセットする
	 *
	 * @param thsSubjectId
	 *            セットする thsSubjectId
	 */
	public void setThsSubjectId(String thsSubjectId) {
		this.thsSubjectId = thsSubjectId;
	}

	/**
	 * thsSubjectIdを返す
	 *
	 * @return thsSubjectId
	 */
	public String getThsSubjectId() {
		return this.thsSubjectId;
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
	 * levelをセットする
	 *
	 * @param level
	 *            セットする level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * levelを返す
	 *
	 * @return level
	 */
	public String getLevel() {
		return this.level;
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
	 * @return comment セットする comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * リンクをセットする
	 *
	 * @param link
	 *            セットする link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * リンクを返す
	 *
	 * @return link セットする link
	 */
	public String getLink() {
		return this.link;
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
	 * 科目プルダウン用マップをセットする
	 *
	 */
	public void setThsSubjectMap() {
		ThsDao dao = new ThsDao();
		List<?> resultTable = dao.getThsSubjectList();
		this.thsSubjectMap = tableTrans(resultTable);
	}

	/**
	 * 科目マップを返す
	 *
	 * @return thsSubjectMap
	 */
	public Map<String, String> getThsSubjectMap() {
		return this.thsSubjectMap;
	}

	/**
	 * レベルプルダウン用マップをセットする
	 *
	 */
	public void setLevelMap() {
		this.levelMap.put("", "レベルを選択");
		this.levelMap.put("基礎", "基礎");
		this.levelMap.put("普通", "普通");
		this.levelMap.put("応用", "応用");
	}

	/**
	 * レベルマップを返す
	 *
	 * @return levelMap
	 */
	public Map<String, String> getLevelMap() {
		return this.levelMap;
	}

	/*-----------------------------------*/
	// 科目プルダウン用マップを返す
	/*-----------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			thsSubjectMap.put("", "科目を選択");
			for (int i = 0; i < resultTable.size(); i++) {
				ThsSubject aa = (ThsSubject) resultTable.get(i);
				thsSubjectMap.put(aa.getId(), aa.getSubject());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thsSubjectMap;
	}
}
