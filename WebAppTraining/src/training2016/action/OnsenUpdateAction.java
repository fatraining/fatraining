package training2016.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.OnsenDao;
import training2016.model.Onsen;
import training2016.model.OnsenArea;

/**
 * 温泉追加・更新のアクション
 *
 */
@Results({ @Result(name = "onsenSearch", value = "onsenSearch.action", type = ServletRedirectResult.class) })
public class OnsenUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "温泉追加";
	/** ボタンの表示名 */
	private String updateBtnTitle = "追加";

	/** id(更新時のみ) */
	private String id;
	/** エリアid */
	private String onsenAreaId;
	/** 温泉名 */
	private String name;
	/** 効能 */
	private String effect;

	/** リンク */
	private String link;
	/** コメント */
	private String comment;

	/** メッセージ */
	private String message;
	/** エラーメッセージ */
	private String errorMessage;

	/** エリアプルダウン用マップ */
	private Map<String, String> onsenAreaMap = new HashMap<String, String>();

	// イニシャライザ 最初の入力項目をはずす
	{
		this.setOnsenAreaMap();
	}

	@Override // 更新
	public String execute() throws Exception {
		this.setOnsenAreaMap();

		// セッションマップから指定のキーでputされた更新対象のidを取得
		this.id = this.getValueFromSession("updateId");

		OnsenDao dao = new OnsenDao();
		Onsen target = null; // 更新対象
		// 更新対象idがあればデータの更新をする
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), Onsen.class); // idを引数にして更新対象のobjectを持ってくる
			if (target != null) {
				this.onsenAreaId = String.valueOf(target.getOnsenAreaId()); // IDをStringに
				this.name = target.getName();
				this.effect = target.getEffect();
				this.comment = target.getComment();
				this.link = target.getLink();

				this.updateBtnTitle = "更新"; // ボタンのvalueを追加→更新
				this.title = "温泉を更新";
			}
		} else {
			// 新規
			this.id = "";
		}
		return "success";
	}

	// /**
	// * 追加メソッド
	// * 追加し終わったら検索画面に戻る
	// *
	// */
	// public String insert() {
	// this.setOnsenAreaMap();
	// this.setEffectMap();
	//
	// if(this.isEmptyParam(onsenAreaId)) {
	// addActionError("エリアを入力してください");
	// }
	// if(this.isEmptyParam(name)) {
	// addActionError("温泉名を入力してください");
	// }
	// if(this.isEmptyParam(effect)) {
	// addActionError("効能を入力してください");
	// }
	// if(this.isEmptyParam(comment)) {
	// addActionError("コメントを入力してください");
	// }
	// if(this.isEmptyParam(link)) {
	// addActionError("リンクを入力してください");
	// }
	// //一つでもエラーがあればだめ
	// if(this.getActionErrors().size() > 0) {
	// return "error";
	// }
	//
	// OnsenDao dao = new OnsenDao();
	//// dao.insert(this.id,
	//// this.onsenAreaId, //Daoのinsertメソッドと一致させる
	//// this.name,
	//// this.effect,
	//// this.comment,
	//// this.link);
	// dao.save(this.generateOnsenModel());
	// this.message = "登録しました";
	// this.sessionMap.put("message", this.message);
	// return "onsenSearch";
	// }

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
		this.setOnsenAreaMap();

		if (this.isEmptyParam(onsenAreaId)) {
			addActionError("エリアを入力してください");
		}
		if (this.isEmptyParam(name)) {
			addActionError("温泉名を入力してください");
		}
		if (this.isEmptyParam(effect)) {
			addActionError("効能を入力してください");
		}
		if (this.isEmptyParam(comment)) {
			addActionError("コメントを入力してください");
		}
		if (this.isEmptyParam(link)) {
			addActionError("リンクを入力してください");
		}

		// 一つでもエラーがあればだめ
		if (this.getActionErrors().size() > 0) {
			return "error";
		}

		// idがあれば更新なので、一度取得したモデルに入力値をセットする
		OnsenDao dao = new OnsenDao();
		if (StringUtils.isNotEmpty(this.id)) {
			Onsen target = dao.select(Integer.parseInt(this.id), Onsen.class);
			// 更新したテーブルを上書き
			dao.update(this.generateOnsenModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else { // 新規の場合
			dao.insert(this.id, this.onsenAreaId, this.name, this.effect, this.link, this.comment);
			this.message = "追加しました";
			this.sessionMap.put("message", this.message);
		}

		return "onsenSearch";
	}

	/**
	 * 今フィールドに保持している値で引数のモデルにセットして返す(更新用)
	 *
	 */
	private Onsen generateOnsenModel(Onsen target) {
		target.setOnsenAreaId(Integer.parseInt(this.onsenAreaId));
		target.setName(this.name);
		target.setEffect(this.effect);
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
	 * onsenAreaIdをセットする
	 *
	 * @param onsenAreaId
	 *            セットする onsenAreaId
	 */
	public void setOnsenAreaId(String onsenAreaId) {
		this.onsenAreaId = onsenAreaId;
	}

	/**
	 * onsenAreaIdを返す
	 *
	 * @return onsenAreaId
	 */
	public String getOnsenAreaId() {
		return this.onsenAreaId;
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
	public void setEffect(String effect) {
		this.effect = effect;
	}

	/**
	 * 効能を返す
	 *
	 * @return effect
	 */
	public String getEffect() {
		return this.effect;
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
	 * リンクをセットする
	 *
	 * @param link
	 *            セットする l
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * リンクを返す
	 *
	 * @return link
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
	 * エリアプルダウン用マップをセットする
	 *
	 */
	public void setOnsenAreaMap() {
		OnsenDao dao = new OnsenDao();
		List<?> resultTable = dao.getOnsenAreaList();
		this.onsenAreaMap = tableTrans(resultTable);
	}

	/**
	 * エリアマップを返す
	 *
	 * @return onsenAreaMap
	 */
	public Map<String, String> getOnsenAreaMap() {
		return this.onsenAreaMap;
	}

	/*-----------------------------------*/
	// エリアプルダウン用マップを返す
	/*-----------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			onsenAreaMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				OnsenArea aa = (OnsenArea) resultTable.get(i);
				onsenAreaMap.put(aa.getId(), aa.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onsenAreaMap;
	}
}
