package action;

import java.util.ArrayList;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import model.GoodsList;
import model.ResultGoodsList;
import model.ResultMemberInfo;

/**
 * 注文確定画面
 * @author t.makino
 *
 */
@Result(name = "goodsList", value = "goodsList.action", type = ServletRedirectResult.class)
public class TmOrderConfirmAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 商品リスト
	 */
	private ArrayList<ResultGoodsList> goods = new ArrayList<ResultGoodsList>();
	/**
	 * 顧客情報テーブルクラス
	 */
	private ResultMemberInfo memberInfo;
	/**
	 * 合計金額
	 */
	private int totalAmount;

	//=============================
	// setter/getter
	//=============================
	/**
	 * 商品リスト
	 * @param goods
	 */
	public void setGoods(ArrayList<ResultGoodsList> goods) {
		this.goods = goods;
	}
	/**
	 * 商品リスト
	 * @return goods
	 */
	public ArrayList<ResultGoodsList> getGoods() {
		return this.goods;
	}
	/**
	 * 顧客情報テーブルクラス
	 * @param userInfo
	 */
	public void setMemberInfo(ResultMemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	/**
	 * 顧客情報テーブルクラス
	 * @return
	 */
	public ResultMemberInfo getMemberInfo() {
		return this.memberInfo;
	}
	/**
	 * @param totalAmount セットする totalAmount
	 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return totalAmount
	 */
	public int getTotalAmount() {
		return totalAmount;
	}

	//=============================
	// パブリックメソッド
	//=============================
	/**
	 * execute
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		// 購入した商品を取得
		setGoods((ArrayList<ResultGoodsList>)super.sessionMap.get("goodsList"));

		// 選択した商品の合計金額を算出
		int price;
		int quantity;
		setTotalAmount(0);
		for (int i = 0; i < this.goods.size(); i++) {
			price = this.goods.get(i).getPrice();
			quantity = this.goods.get(i).getQuantity();
			setTotalAmount(getTotalAmount() + (price * quantity));
		}

		// 顧客情報を表示
		setMemberInfo((ResultMemberInfo)super.sessionMap.get("memberInfo"));
		return "init";
	}

	/**
	 * 商品一覧へ戻るボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String backToTop() throws Exception {
		// 選択した商品をクリア
		super.sessionMap.put("goodsList", null);
		
		// 商品一覧画面へ
		return "goodsList";
	}
}
