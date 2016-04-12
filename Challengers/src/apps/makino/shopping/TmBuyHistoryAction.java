package apps.makino.shopping;

import java.util.ArrayList;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import apps.AbstractAction;
import apps.makino.entity.BuyHistory;

/**
 * 購入履歴画面
 * @author t.makino
 *
 */
@Result(name = "back", value = "goodsList.action", type = ServletRedirectResult.class)
public class TmBuyHistoryAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 商品リスト
	 */
	private ArrayList<BuyHistory> history = new ArrayList<BuyHistory>();
	/**
	 * ユーザID
	 */
	private String userId;

	//=============================
	// setter/getter
	//=============================
	/**
	 * @return history
	 */
	public ArrayList<BuyHistory> getHistory() {
		return history;
	}
	/**
	 * @param history セットする history
	 */
	public void setHistory(ArrayList<BuyHistory> history) {
		this.history = history;
	}
	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
		// 初期処理
		init();
		return "init";
	}

	public String back() throws Exception {
		return "back";
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * 初期処理
	 */
	private void init() {
		// ユーザーIDの取得
		this.setUserId((String)super.sessionMap.get("userId"));

		// 購入履歴の設定
		setHistory();
	}

	/**
	 * 購入履歴の設定
	 */
	private void setHistory() {
		BuyHistory History1 = new BuyHistory("2015/04/05", "100001", "すごくよく消える消しゴム", 300, 1);
		BuyHistory History2 = new BuyHistory("2015/04/05", "100003", "すごく消しやすい鉛筆 （2B）", 130, 4);
		BuyHistory History3 = new BuyHistory("2015/04/05", "881212", "一人お花見セット（寝袋付き）", 20500, 1);
		BuyHistory History4 = new BuyHistory("2014/12/23", "900222", "超豪華　一人用クリスマスケーキ", 5300, 1);
		BuyHistory History5 = new BuyHistory("2014/10/01", "777766", "とても暖かい靴下５組セット", 300, 10);
		BuyHistory History6 = new BuyHistory("2014/10/01", "542312", "すごくいい感じの万年筆", 2800, 1);
		BuyHistory History7 = new BuyHistory("2013/07/11", "554542", "一人バーベキューセット", 10800, 1);
		BuyHistory History8 = new BuyHistory("2013/02/22", "126020", "子供用ワイングラス", 600, 2);
		history.clear();
		history.add(History1);
		history.add(History2);
		history.add(History3);
		history.add(History4);
		history.add(History5);
		history.add(History6);
		history.add(History7);
	}
}
