package model;

/**
 * 商品リスト
 * （画面表示用）
 * @author t.makino
 *
 */
public class ResultGoodsList {
	//===============================
	// フィールド宣言
	//===============================
	/**
	 * 購入有無
	 */
	private boolean isBuy;
	/**
	 * 商品コード
	 */
	private String code;
	/**
	 * 商品名
	 */
	private String name;
	/**
	 * 価格
	 */
	private int price;
	/**
	 * 個数
	 */
	private int quantity;
	/**
	 * 商品種別
	 */
	private String category;

	//===============================
	// コンストラクタ
	//===============================
	/**
	 * コンストラクタ
	 * 商品リストの初期化
	 */
	public ResultGoodsList() {
		// 処理なし
	}
	
	/**
	 * コンストラクタ
	 * 商品リストの初期化
	 */
	public ResultGoodsList(String code, String name, int price, String category) {
		this.isBuy = false;
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = 0;
		this.category = category;
	}

	//===============================
	// setter
	//===============================
	/**
	 * 購入有無
	 * @param isBuy
	 */
	public void setIsBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}

	/**
	 * 商品コード
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 商品名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 価格
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 個数
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 商品種別
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	//===============================
	// getter
	//===============================
	/**
	 * 購入有無
	 * @return isBuy
	 */
	public boolean getIsBuy() {
		return this.isBuy;
	}

	/**
	 * 商品コード
	 * @return 商品コード
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * 商品名
	 * @return 商品名
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 価格
	 * @return 価格
	 */
	public int getPrice() {
		return this.price;
	}

	/**
	 * 個数
	 * @return 個数
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * 商品種別
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

}
