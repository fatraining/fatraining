package action;

import java.util.ArrayList;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import model.ResultGoodsList;

/**
 * 注文確認画面
 * @author t.makino
 *
 */
@Results( {
@Result(name = "next", value = "tmInputUserInfo.action", type = ServletRedirectResult.class),
@Result(name = "back", value = "goodsList.action", type = ServletRedirectResult.class)
})
public class TmOrderCheckAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 商品リスト
	 */
	private ArrayList<ResultGoodsList> goods = new ArrayList<ResultGoodsList>();
	/**
	 * 合計金額
	 */
	private int totalAmount;
	/**
	 * 会員ID
	 */
	private String memberId;

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
	/**
	 * @return memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId セットする memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	//=============================
	// パブリックメソッド
	//=============================
	/**
	 * execute()
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		this.setGoods((ArrayList<ResultGoodsList>)super.sessionMap.get("goodsList"));
		
		int price;
		int quantity;
		setTotalAmount(0);

		// 会員IDの設定
		if (super.sessionMap.get("memberId") == null) {
			memberId = "ゲスト";
		} else {
			memberId = (String)super.sessionMap.get("memberId");
		}
		
		// 選択した商品の合計金額を算出
		for (int i = 0; i < this.goods.size(); i++) {
			price = this.goods.get(i).getPrice();
			quantity = this.goods.get(i).getQuantity();
			setTotalAmount(getTotalAmount() + (price * quantity));
		}

		return "init";
	}

	/**
	 * 次へボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String nextPage() throws Exception {
		// 商品一覧画面へ
		return "next";
	}

	/**
	 * 戻るボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String back() throws Exception {
		// 顧客情報表示・入力画面へ
		return "back";
	}

}
