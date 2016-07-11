package training2016.action;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.AquariumDao;
import training2016.model.Aquarium;
import training2016.model.AquariumArea;

/**
 * 水族館追加・更新のあくしょん
 *
 */
@Results({
@Result(name = "aquariumSearch", value ="aquariumSearch.action", type = ServletRedirectResult.class)
})
public class AquariumUpdateAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/**画面タイトル*/
	private String title ="水族館追加";
	/**ボタンの表示名*/
	private String updateBtnTitle = "追加";

	/**id(更新時のみ)*/
	private String id;
	/**エリアid*/
	private String aquariumAreaId;
	/**店名*/
	private String name;
	/**入場料*/
	private String price;
	/**営業時間*/
	private String hours;
	/**コメント*/
	private String comment;
	/**メッセージ*/
	private String message;
	/**エラーメッセージ*/
	private String errorMessage;

	/**エリアプルダウン用マップ*/
	private Map<String, String> aquariumAreaMap = new HashMap<String, String>();

	/**入場料プルダウン用マップ*/
	private Map<String, String> priceMap = new LinkedHashMap<String, String>();

	// イニシャライザ
	{
		this.setAquariumAreaMap();
	}

	@Override //更新
	public String execute() throws Exception {
		this.setAquariumAreaMap();
		this.setPriceMap();
		//セッションマップから指定のキーでputされた更新対象のidを取得
		this.id = this.getValueFromSession("updateId");

		AquariumDao dao = new AquariumDao();
		Aquarium target = null;
		//更新対象idがあればデータの更新をする
		if(StringUtils.isNotEmpty(this.id)) {
			target = dao.select(Integer.parseInt(this.id), Aquarium.class);
			if(target != null) {
				this.aquariumAreaId = String.valueOf(target.getAquariumAreaId());
				this.name = target.getName();
				this.price = target.getPrice();
				this.hours = target.getHours();
				this.comment = target.getComment();
				this.updateBtnTitle = "更新";  //ボタンのvalueを追加→更新
				this.title ="水族館を更新";
			}
		} else {
			//新規
			this.id = "";
		}
		return "success";
	}

//	/**
//	 * 追加メソッド
//	 * 追加し終わったら検索画面に戻る
//	 *
//	 */
//	public String insert() {
//		this.setAquariumAreaMap();
//		this.setPriceMap();
//
//		if(this.isEmptyParam(aquariumAreaId)) {
//			addActionError("エリアを入力してください");
//		}
//		if(this.isEmptyParam(name)) {
//			addActionError("水族館名を入力してください");
//		}
//		if(this.isEmptyParam(price)) {
//			addActionError("入場料を入力してください");
//		}
//		if(this.isEmptyParam(hours)) {
//			addActionError("営業時間を入力してください");
//		}
//		if(this.isEmptyParam(comment)) {
//			addActionError("コメントを入力してください");
//		}
//		//一つでもエラーがあればだめ
//		if(this.getActionErrors().size() > 0) {
//			return "error";
//		}
//
//		AquariumDao dao = new AquariumDao();
////		dao.insert(this.id,
////				   this.aquariumAreaId,  //Daoのinsertメソッドと一致させる
////				   this.name,
////				   this.price,
////				   this.hours,
////				   this.comment);
//		dao.save(this.generateAquariumModel());
//		this.message = "登録しました";
//		this.sessionMap.put("message", this.message);
//		return "aquariumSearch";
//	}

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
		this.setAquariumAreaMap();
		this.setPriceMap();

		if(this.isEmptyParam(aquariumAreaId)) {
			addActionError("エリアを入力してください");
		}
		if(this.isEmptyParam(name)) {
			addActionError("水族館名を入力してください");
		}
		if(this.isEmptyParam(price)) {
			addActionError("入場料を入力してください");
		}
		if(this.isEmptyParam(hours)) {
			addActionError("営業時間を入力してください");
		}
		if(this.isEmptyParam(comment)) {
			addActionError("コメントを入力してください");
		}
		//一つでもエラーがあればだめ
		if(this.getActionErrors().size() > 0) {
			return "error";
		}

		//idがあれば更新なので、一度取得したモデルに入力値をセットする
		AquariumDao dao = new AquariumDao();
		if(StringUtils.isNotEmpty(this.id)) {
			Aquarium target = dao.select(Integer.parseInt(this.id), Aquarium.class);
			dao.update(this.generateAquariumModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else {
			dao.insert(this.id,
					   this.aquariumAreaId,
					   this.name,
					   this.price,
					   this.hours,
					   this.comment);
			this.message = "登録しました";
			this.sessionMap.put("message", this.message);
		}

		return "aquariumSearch";
	}

	/**
	 * 今フィールドに保持している値で引数のモデルにセットして返す(更新用)
	 *
	 */
	private Aquarium generateAquariumModel(Aquarium target) {
		target.setAquariumAreaId(Integer.parseInt(this.aquariumAreaId));
		target.setName(this.name);
		target.setPrice(this.price);
		target.setHours(this.hours);
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
	 * aquariumAreaIdをセットする
	 * @param aquariumAreaId セットする aquariumAreaId
	 */
	public void setAquariumAreaId(String aquariumAreaId) {
		this.aquariumAreaId = aquariumAreaId;
	}

	/**
	 * aquariumAreaIdを返す
	 * @return aquariumAreaId
	 */
	public String getAquariumAreaId() {
		return this.aquariumAreaId;
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
	 * 入場料をセットする
	 * @param price セットする price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * 入場料を返す
	 * @return price
	 */
	public String getPrice() {
		return this.price;
	}

	/**
	 * 営業時間をセットする
	 * @param hours セットする hours
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}

	/**
	 * 営業時間を返す
	 * @return hours
	 */
	public String getHours() {
		return this.hours;
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
	public String gegtComment() {
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
	public void setAquariumAreaMap() {
		AquariumDao dao = new AquariumDao();
		List<?> resultTable = dao.getAquariumAreaList();
		this.aquariumAreaMap = tableTrans(resultTable);
	}

	/**
	 * エリアマップを返す
	 * @return aquariumAreaMap
	 */
	public Map<String, String> getAquariumAreaMap() {
		return this.aquariumAreaMap;
	}

	/**
	 * 入場料プルダウン用マップをセットする
	 *
	 */
	public void setPriceMap() {
		this.priceMap.put("", "");
		this.priceMap.put("300", "300円");
		this.priceMap.put("500", "500円");
		this.priceMap.put("1000", "1000円");
		this.priceMap.put("1200", "1200円");
		this.priceMap.put("1400", "1400円");
		this.priceMap.put("1600", "1600円");
		this.priceMap.put("1800", "1800円");
		this.priceMap.put("2800", "2800円");
		this.priceMap.put("3000", "3000円");
	}

	/**
	 * 入場料マップを返す
	 * @return priceMap
	 */
	public Map<String, String> getPriceMap() {
		return this.priceMap;
	}

	/*-----------------------------------*/
	//エリアプルダウン用マップを返す
	/*-----------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			aquariumAreaMap.put("", "");
			for(int i = 0; i < resultTable.size(); i++) {
				AquariumArea aa = (AquariumArea) resultTable.get(i);
				aquariumAreaMap.put(aa.getId(), aa.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aquariumAreaMap;
	}
}
