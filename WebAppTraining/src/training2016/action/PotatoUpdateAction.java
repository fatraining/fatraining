package training2016.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.PotatoDao;
import training2016.model.PotatoMaker;
import training2016.model.PotatoProduct;

@Results({ @Result(name = "potatoSearch", value = "potatoSearch.action", type = ServletRedirectResult.class) })
public class PotatoUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// タイトル及びボタンの表示名は追加更新ボタンによって変化
	/* タイトル */
	private String title = "ポテトチップス追加";

	/* ボタン表示 */
	private String btn = "追加";

	/* id */
	private String id;

	/* メーカー名 */
	private String makerName;

	/* メーカーID */
	private String makerId;

	/* 商品名 */
	private String name;

	/* 商品タイプ */
	private String type;

	/* 内容量 */
	private String volume;

	/* 価格 */
	private String price;

	/* コメント */
	private String comment;

	// プルダウン用マップ
	/* メーカー */
	private Map<String, String> makerMap = new HashMap<>(); // DBからマッピング

	/* 商品タイプ */
	private Map<String, String> typeMap = new LinkedHashMap<>(); // 配列を取得

	/* 検索リスト */
	public List<PotatoProduct> potatoTable = new ArrayList<>();

	// 初期値の設定
	/*----------------------------------------------
	*/


	/* execute */
	@Override
	public String execute() {
		this.setMakerMap();
		this.setTypeMap();
		// セッションマップから指定のキーでputされた更新対象のIDを取得
		this.id = this.getValueFromSession("updateId");

		PotatoDao dao = new PotatoDao();
		PotatoProduct target = null;
		if (StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), PotatoProduct.class);
			if (target != null) {
				this.makerId = String.valueOf(target.getMakerId());
				this.name = target.getName();
				this.type = target.getType();
				this.volume = String.valueOf(target.getVolume());
				this.price = String.valueOf(target.getPrice());
				this.comment = target.getComment();
				this.title = "ポテトチップス更新";
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
		this.setTypeMap();

		// 全ての値が入っているかの判定
		if (this.isEmpty(this.makerId) || this.isEmpty(this.name) || this.isEmpty(this.type)
				|| this.isEmpty(this.volume) || this.isEmpty(this.price) || this.isEmpty(this.comment)) {
			addActionError("全ての項目を入力してください");
			return "error";
		}

		// 内容量と価格が数字であるかの判定
		if (this.isNotNumber(this.volume) || this.isNotNumber(price)) {
			addActionError("内容量と価格は数字で入力してください");
			return "error";
		}

		PotatoDao dao = new PotatoDao();
		if (StringUtils.isNotEmpty(this.id)) {
			PotatoProduct target = dao.select(Integer.parseInt(this.id), PotatoProduct.class);
			dao.updata(this.updatePotatoModel(target));
			this.sessionMap.put("completeMessage", "更新しました");
		} else {
			dao.insert(this.makerId, this.name, this.type, this.volume, this.price, this.comment);
			this.sessionMap.put("completeMessage", "追加しました");
		}
		this.sessionMap.put("from", "update");
		return "potatoSearch";
	}

	private boolean isEmpty(String param) {
		return StringUtils.isEmpty(param);
	}

	/* 内容量と価格が数字であるかの判定 */
	private boolean isNotNumber(String str) {
		try {
			Integer.parseInt(str);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	/* 追加or更新する値をセットする */
	private PotatoProduct updatePotatoModel(PotatoProduct target) {
		target.setMakerId(Integer.parseInt(this.makerId));
		target.setName(this.name);
		target.setType(this.type);
		target.setVolume(Integer.parseInt(this.volume));
		target.setPrice(Integer.parseInt(this.price));
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
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
		PotatoDao dao = new PotatoDao();
		List<?> resultTable = dao.getMakerNameList();
		this.makerMap = tableTrans(resultTable);
	}

	public Map<String, String> getTypeMap() {
		return this.typeMap;
	}

	// 商品タイププルダウン用マップをセット
	private void setTypeMap() {
		this.typeMap.put("", "");
		this.typeMap.put("通常販売", "通常販売");
		this.typeMap.put("地域限定", "地域限定");
		this.typeMap.put("期間限定", "期間限定");
		this.typeMap.put("その他", "その他");
	}

	// メーカープルダウン用マップを返す
	/*----------------------------------------------
	*/

	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			this.makerMap.put("", "");

			for (int i = 0; i < resultTable.size(); i++) {
				PotatoMaker pm = (PotatoMaker) resultTable.get(i);
				this.makerMap.put(pm.getId(), pm.getMakerName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.makerMap;
	}
}
