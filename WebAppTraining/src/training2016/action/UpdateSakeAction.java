package training2016.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.SakeinfoDao;
import training2016.model.Sakearea;
import training2016.model.Sakeinfo;

@Result(name = "sakeSearch", value = "sakeSearch.action", type = ServletRedirectResult.class)
public class UpdateSakeAction extends AbstractAction {

	/** 画面タイトル **/
	private String title = "おススメ日本酒店登録";
	/** エリアID */
	private String areaId;
	/** 店名 */
	private String shopName;
	/** 予約時間 */
	private String hours;
	/** 予算 */
	private String price;
	/** おススメ */
	private String recommend;
	/** コメント */
	private String comment;
	/** 削除ID */
	private String delete;
	/** 時間プルダウン用マップ */
	private Map<String, String> priceMap = new LinkedHashMap<String, String>();
	/** エリアプルダウン用マップ */
	private Map<String, String> areaMap;

	/** メッセージ */
	private String message;
	/** エラーメッセージ */
	public String errorMsg;

	/**
	 * executeメソッド
	 *
	 * @return 結果
	 */
	@Override
	public String execute() {
		// delete取り出す
		this.setDelete((String) this.sessionMap.get("deleteID"));
		System.out.println("おさけくれめんす");
		this.setAreaMap();
		this.setPriceMap();
		return "success";
	}

	/**
	 * 削除メソッド
	 *
	 * @return sakeSearch
	 */
	public String delete() {
		this.setDelete((String) this.sessionMap.get("deleteID"));
		SakeinfoDao dao = new SakeinfoDao();
		dao.delete(this.getDelete());
		this.errorMsg = "削除が完了しました。";
		this.sessionMap.put("message", this.errorMsg);
		return "sakeSearch";
	}

	/**
	 * insertメソッド 画面の初期表示に戻す
	 *
	 * @return
	 */
	public String insert() {
		this.setPriceMap();
		this.setAreaMap();

		// 未入力の項目があるときにエラーを返す
		if (!this.isValidate()) {
			this.errorMsg = "必須項目を入力してください。";
			return "error";
		}
		SakeinfoDao dao = new SakeinfoDao();
		dao.save(this.generalSakeinfoModel());
		this.message = "登録しました。";
		sessionMap.put("message", this.message);
		return "sakeSearch";
	}

	/**
	 * フィールドに保持している値でSakeinfoModelを生成して返す
	 *
	 * @return Sakeinfo
	 */
	private Sakeinfo generalSakeinfoModel() {
		Sakeinfo model = new Sakeinfo();
		model.setAreaId(this.areaId);
		model.setShopName(this.shopName);
		model.setHours(this.hours);
		model.setPrice(this.price);
		model.setRecommend(this.recommend);
		model.setComment(this.comment);
		return model;
	}

	/**
	 * 必須項目が全て入力済みか確認する
	 *
	 * @return 無問題ならtrue, 問題ありならfalse
	 */
	private boolean isValidate() {
		if (StringUtils.isEmpty(this.areaId) || StringUtils.isEmpty(this.shopName) || StringUtils.isEmpty(this.hours)
				|| StringUtils.isEmpty(this.price) || StringUtils.isEmpty(this.recommend)
				|| StringUtils.isEmpty(this.comment)) {
			return false;
		}
		return true;
	}

	// 登録時に必要な項目をsetter getterにて取得
	/**
	 * titleを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return PriceMap
	 */
	public Map<String, String> getPriceMap() {
		return priceMap;
	}

	/**
	 * @param priceMap セットする priceMap
	 */
	public void setPriceMap() {
		this.priceMap.put("","予算を選択");
		this.priceMap.put("3000円","3000円");
		this.priceMap.put("4000円","4000円");
		this.priceMap.put("5000円","5000円");
		this.priceMap.put("6000円","6000円");
		this.priceMap.put("7000円","7000円");
		this.priceMap.put("8000円","8000円");
	}

	/**
	 * @return areaMap
	 */
	public Map<String, String> getAreaMap() {
		return areaMap;
	}

	/**
	 * @param areaMap
	 *            areaMap セットする
	 */
	public void setAreaMap() {
		SakeinfoDao dao = new SakeinfoDao();
		List<?> resultTable = dao.getSakeareaList();
		this.areaMap = tableTrans(resultTable);
	}

	/**
	 * @return delete
	 */
	public String getDelete() {
		return delete;
	}

	/**
	 *
	 * @param delete
	 *            セットする
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * @return areaId
	 */
	public String getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId
	 *            セットする
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * @return shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName
	 *            セットする
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return hours
	 */
	public String getHours() {
		return hours;
	}

	/**
	 * @param hours
	 *            セットする
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}

	/**
	 * @return price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            セットする
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return recommend
	 */
	public String getRecommend() {
		return recommend;
	}

	/**
	 * @param recommend
	 *            セットする
	 */
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	/**
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            セットする
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * errorMsgを返す
	 *
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return this.errorMsg;
	}

	/*------------------------------------------------------*/
	// エリアプルダウン用マップを返す //
	/*------------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		Map<String, String> tempMap = new LinkedHashMap<String, String>();
		tempMap.put("", "エリアを選択");
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Sakearea area = (Sakearea) resultTable.get(i);
				tempMap.put(area.getID(), area.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempMap;
	}
}

