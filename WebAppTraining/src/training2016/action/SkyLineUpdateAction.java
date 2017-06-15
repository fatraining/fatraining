package training2016.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.SkyLineDao;
import training2016.model.SkyLineData;

@Result(name = "skyLineSearch", value = "skyLineSearch.action", type = ServletRedirectResult.class)
public class SkyLineUpdateAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private String title = "スカイライン追加";
	private String updateBtnTitle = "追加";

	private String id; // 更新
	private String age; // 年代
	private String ageId; // 年代id
	private String date; // 販売年
	private String model; // 型番
	private String nickname; // ニックネーム
	/** メッセージ */
	private String message;
	/** エラーメッセージ */
	private String errorMessage;

	// プルダウン
	private Map<String, String> skyLineAgeMap = new HashMap<String, String>();
	// イニシャライザ
	{
		this.setSkyLineAgeMap();
	}

	@Override // 更新
	public String execute() throws Exception {
		this.setSkyLineAgeMap();
		// セッションマップから指定のキーでputされた更新対象のidを取得
		this.id = this.getValueFromSession("updateId");

		SkyLineDao dao = new SkyLineDao();
		SkyLineData target = null;
		// 更新対象idがあればデータの更新をする
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), SkyLineData.class);
			if (target != null) {
				this.ageId = String.valueOf(target.getAgeId());
				this.date = String.valueOf(target.getDate());
				this.model = target.getModel();
				this.nickname = target.getNickname();
				this.updateBtnTitle = "更新"; // ボタンのvalueを追加→更新
				this.title = "スカイラインを更新";
			}
		} else {
			// 新規
			this.id = "";
		}
		return "success";
	}

	// 必須項目が全部入力済みか確認
	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	// updateメソッド idがあれば更新、なければ追加になる 更新・追加し終わったら検索画面にもどる
	public String update() {
		this.setSkyLineAgeMap();

		if (this.isEmptyParam(date)) {
			addActionError("販売開始年を入力してください");
		}
		if (this.isEmptyParam(model)) {
			addActionError("型番を入力してください");
		}
		if (this.isEmptyParam(nickname)) {
			addActionError("キャッチコピーを入力してください");
		}
		// 一つでもエラーがあればだめ
		if (this.getActionErrors().size() > 0) {

			this.id = this.getValueFromSession("updateId");

			SkyLineDao dao = new SkyLineDao();
			SkyLineData target = null;
			// 更新対象idがあればデータの更新をする
			if (StringUtils.isNotEmpty(this.id)) {
				target = dao.select(Integer.parseInt(this.id), SkyLineData.class);
				if (target != null) {
					this.updateBtnTitle = "更新"; // ボタンのvalueを追加→更新
					this.title = "スカイライン情報を更新";
				}
			}
			return "error";
		}

		// idがあれば更新なので、一度取得したモデルに入力値をセットする
		SkyLineDao dao = new SkyLineDao();
		if (StringUtils.isNotEmpty(this.id)) {
			SkyLineData target = dao.select(Integer.parseInt(this.id), SkyLineData.class);
			dao.update(this.generateSkyLineModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else {
			dao.insert(this.id, this.ageId, this.date, this.model, this.nickname);
			this.message = "追加しました";
			this.sessionMap.put("message", this.message);
		}
		return "skyLineSearch";
	}

	// 今フィールドに保持している値で引数のモデルにセットして返す(更新用)
	private SkyLineData generateSkyLineModel(SkyLineData target) {
		target.setAgeId(Integer.parseInt(this.ageId));
		target.setModel(this.model);
		target.setNickname(this.nickname);
		return target;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUpdateBtnTitle() {
		return updateBtnTitle;
	}

	public void setUpdateBtnTitle(String updateBtnTitle) {
		this.updateBtnTitle = updateBtnTitle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAgeId() {
		return ageId;
	}

	public void setAgeId(String ageId) {
		this.ageId = ageId;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * SkyLineAgeMap
	 */
	public Map<String, String> getSkyLineAgeMap() {
		return this.skyLineAgeMap;
	}

	// skyLineAgeプルダウン用マップをセットする
	public void setSkyLineAgeMap() {
		this.skyLineAgeMap.put("1", "1950");
		this.skyLineAgeMap.put("2", "1960");
		this.skyLineAgeMap.put("3", "1970");
		this.skyLineAgeMap.put("4", "1980");
		this.skyLineAgeMap.put("5", "1990");
		this.skyLineAgeMap.put("6", "2000");
		this.skyLineAgeMap.put("7", "2010");
	}
}
