package training2016.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.GalgameDao;
import training2016.model.GalgameMaker;
import training2016.model.GalgameProduct;

@Results({ @Result(name = "galgameSearch", value = "galgameSearch.action", type = ServletRedirectResult.class) })
public class GalgameUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// タイトル及びボタンの表示名は追加更新ボタンによって変化
	/* タイトル */
	private String title = "ゲームタイトル追加";


	/* ボタン表示 */
	private String btn = "追加";

	/* id */
	private String id;

	/* メーカー名 */
	private String makerName;

	/* メーカーID */
	private String makerId;

	/* ゲーム名 */
	private String name;

	/* 発売年 */
	private String year;

	/* 評価点 */
	private String score;

	/* コメント */
	private String comment;

	// プルダウン用マップ
	/* メーカー */
	private Map<String, String> makerMap = new HashMap<>(); // DBからマッピング
	/* 検索リスト */
	public List<GalgameProduct> galgameTable = new ArrayList<>();

	// 初期値の設定
	/*----------------------------------------------
	 */


	/* execute */
	@Override
	public String execute() {
		this.setMakerMap();
		// セッションマップから指定のキーでputされた更新対象のIDを取得
		this.id = this.getValueFromSession("updateId");

		GalgameDao dao = new GalgameDao();
		GalgameProduct target = null;
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), GalgameProduct.class);
			if (target != null) {
				this.makerId = String.valueOf(target.getMakerId());
				this.name = target.getName();
				this.year = String.valueOf(target.getYear());
				this.score = String.valueOf(target.getScore());
				this.comment = target.getComment();
				this.title = "ゲームタイトル更新";
				this.btn = "更新";
			}
		} else {
			this.id = "";
		}

		return "success";
	}
	/* 追加or更新ボタンクリック時 */
	public String update() {
		this.setMakerMap();

		// 全ての値が入っているかの判定
		if (this.isEmpty(this.makerId) || this.isEmpty(this.name) || this.isEmpty(this.year)
				|| this.isEmpty(this.score) || this.isEmpty(this.comment)) {
			addActionError("全ての項目を入力してください");
			this.title = "ゲーム更新";
			this.btn = "更新";
			return "error";
		}

		// 内容量と価格が数字であるかの判定
		if (this.isNotNumber(this.year) || this.isNotNumber(this.score)) {
			addActionError("発売年と評価点は数字で入力してください");
			this.title = "ゲーム更新";
			this.btn = "更新";
			return "error";
		}

		GalgameDao dao = new GalgameDao();
		if (StringUtils.isNotEmpty(this.id)) {
			GalgameProduct target = dao.select(Integer.parseInt(this.id), GalgameProduct.class);
			dao.updata(this.updateGalgameModel(target));
			this.sessionMap.put("completeMessage", "更新しました");
		} else {
			dao.insert(this.makerId, this.name,  this.year, this.score, this.comment);
			this.sessionMap.put("completeMessage", "追加しました");
		}
		this.sessionMap.put("from", "update");
		return "galgameSearch";
	}

	private boolean isEmpty(String param) {
		return StringUtils.isEmpty(param);
	}

	/* 発売年と評価点が数字であるかの判定 */
	private boolean isNotNumber(String str) {
		try {
			Integer.parseInt(str);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	/* 追加or更新する値をセットする */
	private GalgameProduct updateGalgameModel(GalgameProduct target) {
		target.setMakerId(Integer.parseInt(this.makerId));
		target.setName(this.name);
		target.setYear(Integer.parseInt(this.year));
		target.setScore(Integer.parseInt(this.score));
		target.setComment(this.comment);

		return target;

	}

	/* エラーメッセージ */
	public boolean getHasActionErrors() {
		if (hasActionErrors()) {
			return true;
		} else {
			return false;
		}
	}

	// setter&getter
	/*----------------------------------------------
	 */

	public String getTitle() {
		return this.title;
	}

	public String getBtn() {
		return btn;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getMakerId() {
		return this.makerId;
	}

	public void setMakerId(String makerId) {
		this.makerId = makerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Map<String, String> getMakerMap() {
		return this.makerMap;
	}

	private void setMakerMap() {
		GalgameDao dao = new GalgameDao();
		List<?> resultTable = dao.getMakerNameList();
		this.makerMap = tableTrans(resultTable);
	}
	// メーカープルダウン用マップを返す
	/*----------------------------------------------
	 */

	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			this.makerMap.put("", "");

			for (int i = 0; i < resultTable.size(); i++) {
				GalgameMaker gm = (GalgameMaker) resultTable.get(i);
				this.makerMap.put(gm.getId(), gm.getMakerName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.makerMap;
	}
}

