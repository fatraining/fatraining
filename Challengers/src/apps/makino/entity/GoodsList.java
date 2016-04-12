package apps.makino.entity;

/**
 * 商品一覧テーブル
 * @author makinotakuya
 *
 */
public class GoodsList {
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

	//===============================
	// setter/getter
	//===============================
	/**
	 * 購入有無
	 * @param isBuy
	 */
	public void setIsBuy(boolean isBuy) {
		this.isBuy = isBuy;
	}
	/**
	 * 購入有無
	 * @return isBuy
	 */
	public boolean getIsBuy() {
		return this.isBuy;
	}
	/**
	 * 商品コード
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
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
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * 個数
	 * @return 個数
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	//===============================
	// コンストラクタ
	//===============================
	/**
	 * コンストラクタ
	 * 商品リストの初期化
	 */
	public GoodsList() {
		// 処理なし
	}
	/**
	 * コンストラクタ
	 * 商品リストの初期化
	 */
	public GoodsList(boolean isBuy, String code, String name, int price, int quantity) {
		this.isBuy = isBuy;
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

}
