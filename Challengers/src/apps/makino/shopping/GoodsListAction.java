package apps.makino.shopping;

import java.util.ArrayList;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import apps.AbstractAction;
import apps.makino.entity.GoodsList;


/**
 * 商品一覧画面
 * @author t.makino
 *
 */
@Results( {
@Result(name = "success", value = "tmOrderCheck.action", type = ServletRedirectResult.class),
@Result(name = "login", value = "tmLogin.action", type = ServletRedirectResult.class),
@Result(name = "history", value = "tmBuyHistory.action", type = ServletRedirectResult.class)
})
public class GoodsListAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 商品リスト
	 */
	private ArrayList<GoodsList> goods = new ArrayList<GoodsList>();
	/**
	 * ユーザID
	 */
	private String userId;
	/**
	 * エラーメッセージ
	 */
	private String errMessage;
	/**
	 * ボタンID
	 */
	private String buttonId;

	//=============================
	// setter/getter
	//=============================
	/**
	 * 商品リスト
	 * @param goods
	 */
	public void setGoods(ArrayList<GoodsList> goods) {
		this.goods = goods;
	}
	/**
	 * 商品リスト
	 * @return goods
	 */
	public ArrayList<GoodsList> getGoods() {
		return this.goods;
	}
	/**
	 * ユーザID
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * ユーザID
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	/**
	 * エラーメッセージ
	 * @param errMessage
	 */
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	/**
	 * エラーメッセージ
	 * @return errMessage
	 */
	public String getErrMessage() {
		return this.errMessage;
	}
	/**
	 * ボタンID
	 * @param buttonID
	 */
	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}
	/**
	 * ボタンID
	 * @return buttonId
	 */
	public String getButtonId() {
		return this.buttonId;
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

	/**
	 * ログインボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		super.sessionMap.put("buttonId", "login");
		super.sessionMap.put("goodsList", goods);
		return "login";
	}

	/**
	 * 購入履歴ボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String buyHistory() {
		// 初期処理
		init();
		return "history";
	}

	/**
	 * ログアウトボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		super.sessionMap.clear();

		// 初期処理
		init();

		return "init";
	}

	/**
	 * 購入ボタン押下時
	 * @return
	 */
	public String goodsBuy() throws Exception {
		// 商品リストから選択された商品があるかチェックする
		if (!isCheckGoods()) {
			setUser();
			return "init";
		}

		super.sessionMap.put("buttonId", "buy");
		if (super.sessionMap.get("userId") == null) {
			return "login";
		} else {
			return "success";
		}
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * 初期処理
	 */
	private void init() {
		// ユーザIDの設定
		setUser();

		// ボタンIDの設定
		setButtonId((String)super.sessionMap.get("buttonId"));

		// 商品一覧の設定
		initList();

		// 選択済みの商品がある場合
		ArrayList<GoodsList> list = new ArrayList<GoodsList>();
		list = (ArrayList<GoodsList>)super.sessionMap.get("goodsList");

		if (list == null || list.size() == 0) {
			return;
		}

		if (goods.size() == 0) {
			// --------------------------------------------
			// ログインボタン押下により、ログイン画面から戻ったときに
			// 入力中だった情報を復元
			// --------------------------------------------
			goods = list;
			return;
		}

		// --------------------------------------------
		// 購入ボタン押下により、他画面から戻ったときに
		// 入力中だった情報を復元
		// --------------------------------------------
		// 選択された商品の数分繰り返し
		for (int i = 0; i < list.size(); i++) {
			// 全商品の中から、選択された商品を検索
			for (int j = 0; j < goods.size(); j++) {
				// 選択された商品が存在する場合
				if (goods.get(j).getCode().equals(list.get(i).getCode())) {
					// 選択されたときの内容で書き換える
					goods.remove(j);
					goods.add(j, list.get(i));
				}
			}
		}
	}

	/**
	 * 初期画面設定
	 */
	private void initList() {
		ArrayList<GoodsList> list = (ArrayList<GoodsList>)super.sessionMap.get("goodsList");
		String buttonId = (String)super.sessionMap.get("buttonId");
		// ---------------------------------------------
		// 前回の操作までに、選択した商品がない場合または、
		// 選択した商品があっても、購入ボタンを押されている場合、
		// 商品リストを初期設定する。
		// ---------------------------------------------
		if (list == null || list.size() == 0 || buttonId.equals("buy")) {
			GoodsList goods1 = new GoodsList(false, "100001", "すごくよく消える消しゴム", 300, 0);
			GoodsList goods2 = new GoodsList(false, "100002", "すごく消しやすい鉛筆 （HB）", 130, 0);
			GoodsList goods3 = new GoodsList(false, "200201", "超特盛　オージービーフ ４０００ｇ", 8380, 0);
			GoodsList goods4 = new GoodsList(false, "200202", "幸運を呼ぶ招き猫", 7777, 0);
			GoodsList goods5 = new GoodsList(false, "200203", "色んなスポーツのボール詰め合わせ", 9800, 0);
			GoodsList goods6 = new GoodsList(false, "315001", "すごく握りやすい３色ボールペン", 324, 0);
			GoodsList goods7 = new GoodsList(false, "315002", "見た目以上によく物が入るエコバック", 540, 0);
			GoodsList goods8 = new GoodsList(false, "315003", "斬新な三輪車", 29800, 0);
			GoodsList goods9 = new GoodsList(false, "404010", "職人手作り　竹とんぼ", 438000, 0);
			GoodsList goods10 = new GoodsList(false, "404100", "割りばし ３０００本", 2980, 0);
			GoodsList goods11 = new GoodsList(false, "446038", "電子レンジ機能付き洗濯機", 56700, 0);
			GoodsList goods12 = new GoodsList(false, "510007", "水にすぐ溶けるポケットティッシュ6個入り", 98, 0);
			GoodsList goods13 = new GoodsList(false, "510007", "見た目がいまいちなＴシャツ", 216, 0);
			goods.clear();
			goods.add(goods1);
			goods.add(goods2);
			goods.add(goods3);
			goods.add(goods4);
			goods.add(goods5);
			goods.add(goods6);
			goods.add(goods7);
			goods.add(goods8);
			goods.add(goods9);
			goods.add(goods10);
			goods.add(goods11);
			goods.add(goods12);
			goods.add(goods13);
		}
	}

	/**
	 * ユーザIDの設定
	 */
	private void setUser() {
		if (super.sessionMap.get("userId") == null) {
			setUserId("ゲスト");
		} else {
			setUserId((String)super.sessionMap.get("userId"));
		}
	}

	/**
	 * 商品選択チェック
	 * @return　true：選択あり　false：選択なし
	 */
	private boolean isCheckGoods() {
		ArrayList<GoodsList> list = new ArrayList<GoodsList>();
		// 選択された商品のみを取得
		for (int i = 0; i < this.goods.size(); i++) {
			if (this.goods.get(i).getIsBuy()) {
				list.add(this.goods.get(i));
			}
		}

		// 選択された商品がない場合
		if (list.size() == 0) {
			setErrMessage("商品が１つも選択されていません。");
			return false;
		}

		// 選択された商品の個数が0個の場合
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getQuantity() == 0) {
				setErrMessage("選択した商品の購入個数を選択してください。");
				return false;
			}
		}

		super.sessionMap.put("goodsList", list);
		return true;
	}
}
