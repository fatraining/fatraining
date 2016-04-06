package model;

public class ResultOrderInfo {

	//===============================
	// フィールド宣言
	//===============================
	/**
	 * 注文日
	 */
	private String orderDate;
	/**
	 * 注文番号
	 */
	private String orderNo;
	/**
	 * 商品コード
	 */
	private String goodsCode;
	/**
	 * 商品名
	 */
	private String goodsName;
	/**
	 * 商品種別
	 */
	private String category;
	/**
	 * 価格
	 */
	private int orderPrice;
	/**
	 * 個数
	 */
	private int orderQuantity;
	
	//===============================
	// コンストラクタ
	//===============================
	/**
	 * コンストラクタ
	 * （処理なし）
	 */
	public ResultOrderInfo () {
		// 処理なし
	}

	/**
	 * コンストラクタ
	 * 初期データ設定
	 * @param orderDate
	 * @param orderNo
	 * @param goodsCode
	 * @param goodsName
	 * @param category
	 * @param orderPrice
	 * @param orderQuantity
	 */
	public ResultOrderInfo (String orderDate, String orderNo, String goodsCode, String goodsName, 
							String category, int orderPrice, int orderQuantity) {
		this.orderDate = orderDate;
		this.orderNo = orderNo;
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.category = category;
		this.orderPrice = orderPrice;
		this.orderQuantity = orderQuantity;
	}

	//===============================
	// setter
	//===============================
	/**
	 * 注文日
	 * @param orderDate
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * 注文番号
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * 商品コード
	 * @param goodscode
	 */
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	/**
	 * 商品名
	 * @param goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * 商品種別
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * 価格
	 * @param orderPrice
	 */
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	/**
	 * 個数
	 * @param orderQuantity
	 */
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	//===============================
	// getter
	//===============================
	/**
	 * 注文日
	 * @return orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * 注文番号
	 * @return orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * 商品コード
	 * @return goodsCode
	 */
	public String getGoodsCode() {
		return goodsCode;
	}

	/**
	 * 商品名
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * 商品種別
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 価格
	 * @return orderPrice
	 */
	public int getOrderPrice() {
		return orderPrice;
	}

	/**
	 * 個数
	 * @return orderQuantity
	 */
	public int getOrderQuantity() {
		return orderQuantity;
	}

}
