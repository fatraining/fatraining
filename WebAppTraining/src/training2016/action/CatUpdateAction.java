package training2016.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.CatDao;
import training2016.model.CatFrom;
import training2016.model.CatInfo;

@Results({ @Result(name = "catSearch", value = "catSearch.action", type = ServletRedirectResult.class) })
public class CatUpdateAction extends AbstractAction {

	/* 画面タイトル */
	private String title = "追加";
	/* ボタンの表示名 */
	private String updateBtnTitle = "追加";
	/* ID */
	private String id;
	/* 原産国ID */
	private String fromId;
	/* 猫名 */
	private String name;
	/* 特徴 */
	private String comment;
	/* 原産国プルダウン用マップ */
	private Map<String, String> countryMap;
	/* メッセージ */
	private String message;
	/* エラーメッセージ */
	public String errorMsg;

	/* イニシャライザ */
	{
		this.setCountryMap();
	}

	/* executeメソッド */
	@Override
	public String execute() throws Exception {
		this.setCountryMap();
		// セッションマップから指定のキーでputされた更新対象のIDを取得する
		this.id = this.getValueFromSession("updateId");
		CatDao dao = new CatDao();
		CatInfo target = null;
		// 更新対象IDがあればデータの更新をする
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), CatInfo.class);
			if (target != null) {
				this.fromId = String.valueOf(target.getFromId());
				this.name = target.getName();
				this.comment = target.getComment();
				this.updateBtnTitle = "更新"; // ボタンのvalueを追加→更新
				this.title = "更新";
			}
		} else {
			// 新規
			this.id = "";
		}
		return "success";
	}

	/* 入力項目が全て入力済みか確認する */
	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	/* updateメソッド */
	public String update() {
		this.setCountryMap();
		if(this.isEmptyParam(fromId)) {
			addActionError("原産国を入力してください");
		}
		if(this.isEmptyParam(name)) {
			addActionError("名前を入力してください");
		}
		if(this.isEmptyParam(comment)) {
			addActionError("特徴を入力してください");
		}
		if (this.getActionErrors().size() > 0) {
			this.id = this.getValueFromSession("updateId");
			CatDao dao = new CatDao();
			CatInfo target = null;
			// 更新対象IDがあればデータの更新をする
			if (StringUtils.isNotEmpty(this.id)) {
				target = dao.select(Integer.parseInt(this.id), CatInfo.class);
				if (target != null) {
					this.updateBtnTitle = "更新"; // ボタンのvalueを追加→更新
					this.title = "更新";
				}
			}
			return "error";
		}
		CatDao dao = new CatDao();
		if (StringUtils.isNotEmpty(this.id)) {
			CatInfo target = dao.select(Integer.parseInt(this.id), CatInfo.class);
			dao.update(this.generateCatInfoModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else {
			dao.insert(this.id,this.fromId,this.name,this.comment);
			this.message = "追加しました";
			this.sessionMap.put("message", this.message);
		}
		return "catSearch";
	}

	/* フィールドに保持している値でCatInfoModelを生成して返す */
	private CatInfo generateCatInfoModel(CatInfo target) {
		target.setFromId(Integer.parseInt(this.fromId));
		target.setName(this.name);
		target.setComment(this.comment);
		return target;
	}

	/* get,setメソッド */
	public String getTitle() {
		return title;
	}
	public String getUpdateBtnTitle() {
		return updateBtnTitle;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Map<String, String> getCountryMap() {
		return countryMap;
	}
	public void setCountryMap() {
		CatDao dao = new CatDao();
		List<?> resultTable = dao.getCatFromList();
		this.countryMap = tableTrans(resultTable);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMsg() {
		return this.errorMsg;
	}

	/* 原産国プルダウン用マップを返す */
	public Map<String, String> tableTrans(List<?> resultTable) {
		Map<String, String> tempMap = new LinkedHashMap<String, String>();
		tempMap.put("", "にゃー(=^･ω･^=)");
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				CatFrom from = (CatFrom) resultTable.get(i);
				tempMap.put(from.getId(), from.getCountry());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempMap;
	}

}