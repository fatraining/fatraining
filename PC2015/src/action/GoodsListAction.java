package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.CategoryMasterDao;
import dao.GoodsListDao;
import model.Category;
import model.GoodsList;
import model.ResultGoodsList;
import util.TmNoDataFoundException;


/**
 * 商品一覧画面
 * @author t.makino
 *
 */
@Results( {
@Result(name = "success", value = "tmOrderCheck.action", type = ServletRedirectResult.class),
@Result(name = "login", value = "tmLogin.action", type = ServletRedirectResult.class),
@Result(name = "change", value = "tmChangePassword.action", type = ServletRedirectResult.class),
@Result(name = "history", value = "tmBuyHistory.action", type = ServletRedirectResult.class),
@Result(name = "withdrawal", value = "tmWithdrawalMember.action", type = ServletRedirectResult.class),
@Result(name = "changeInfo", value = "tmInputUserInfo.action", type = ServletRedirectResult.class),
@Result(name = "menu", value = "menu.action", type = ServletRedirectResult.class)
})
public class GoodsListAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 商品リスト
	 */
	private ArrayList<ResultGoodsList> goods = new ArrayList<ResultGoodsList>();
	/**
	 * 会員ID
	 */
	private String memberId;
	/**
	 * エラーメッセージ
	 */
	private String errMessage;
	/**
	 * ボタンID
	 */
	private String buttonId;
	/**
	 * 検索条件　カテゴリ
	 */
	private String categorySelect;
	/**
	 * カテゴリリスト
	 */
	private HashMap<String, String> categoryList = new HashMap<String, String>();
	/**
	 * ソートキー
	 */
	private String sortKey = "0";
	/**
	 * ソートリスト
	 */
	private HashMap<String, String> sortList = new HashMap<String, String>();

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
	 * 会員ID
	 * @param memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * 会員ID
	 * @return memberId
	 */
	public String getMemberId() {
		return this.memberId;
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
	/**
	 * 検索条件　カテゴリ
	 * @param categorySelect
	 */
	public void setCategorySelect(String categorySelect) {
		this.categorySelect = categorySelect;
	}
	/**
	 * 検索条件　カテゴリ
	 * @return categorySelect
	 */
	public String getCategorySelect() {
		return categorySelect;
	}
	/**
	 * カテゴリリスト
	 * @param categoryList
	 */
	public void setCategoryList(HashMap<String, String> categoryList) {
		this.categoryList = categoryList;
	}
	/**
	 * カテゴリリスト
	 * @return categoryList
	 */
	public HashMap<String, String> getCategoryList() {
		return categoryList;
	}
	/**
	 * ソートキー
	 * @param sortKey
	 */
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}
	/**
	 * ソートキー
	 * @return sortKey
	 */
	public String getSortKey() {
		return sortKey;
	}
	/**
	 * ソートリスト
	 * @param sortList
	 */
	public void setSortList(HashMap<String, String> sortList) {
		this.sortList = sortList;
	}
	/**
	 * ソートリスト
	 * @return sortList
	 */
	public HashMap<String, String> getSortList() {
		return sortList;
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
	public String buyHistory() throws Exception {
		return "history";
	}

	/**
	 * パスワード変更ボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String changePassword() throws Exception {
		return "change";
	}
	
	/**
	 * ログアウトボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception {
		// 保持していたデータをクリア
		clear();

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
			// 会員IDの取得
			setUser();

			// カテゴリリストの設定
			setCategoryList();

			// ソートリストの設定
			setSortList();

			return "init";
		}

		super.sessionMap.put("buttonId", "buy");
		if (super.sessionMap.get("memberId") == null) {
			return "login";
		} else {
			return "success";
		}
	}

	/**
	 * 退会ボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String withdrawal() throws Exception {
		return "withdrawal";
	}

	/**
	 * 登録内容変更ボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String changeInfo() throws Exception {
		super.sessionMap.put("buttonId", "changeInfo");
		return "changeInfo";
	}

	/**
	 * 検索ボタン押下時
	 * @return
	 */
	public String search() throws Exception {
		// 共通初期処理
		initCommon();

		// 商品リストの取得
		getSortGoodsList();

		return "init";
	}

	/**
	 * 並び替えボタン押下時
	 * @return
	 */
	public String sort() throws Exception {
		// 共通初期処理
		initCommon();

		// ソートした商品リストを取得
		getSortGoodsList();

		return "init";
	}

	/**
	 * メニューへボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String backToMenu() throws Exception {
		// 保持していたデータをクリア
		clear();

		return "menu";
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * 初期処理
	 * @throws Exception 
	 */
	private void init() throws Exception {
		// 共通初期処理
		initCommon();

		// 商品一覧の設定
		initList();

		// 選択済みの商品がある商品リストの再設定
		goodsListSetAgain();
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * 共通初期処理
	 * @throws Exception 
	 */
	private void initCommon() throws Exception {
		// 会員IDの設定
		setUser();

		// ボタンIDの設定
		setButtonId((String)super.sessionMap.get("buttonId"));

		// カテゴリリストの設定
		setCategoryList();

		// ソートリストの設定
		setSortList();
	}

	/**
	 * 初期画面設定
	 * @throws Exception 
	 */
	private void initList() throws Exception {
		ArrayList<ResultGoodsList> list = (ArrayList<ResultGoodsList>)super.sessionMap.get("goodsList");
		String buttonId = (String)super.sessionMap.get("buttonId");

		// ------------------------------------------------
		// 前回の操作までに、選択した商品がない場合または、
		// 選択した商品があっても、購入ボタンまたは登録内容変更ボタン
		// を押されている場合、商品リストを初期設定する。
		// ------------------------------------------------
		if (list == null || list.size() == 0 || buttonId.equals("buy") || buttonId.equals("changeInfo")) {
			// 商品リストを取得
			getSortGoodsList();
		}
	}

	/**
	 * 会員IDの設定
	 */
	private void setUser() {
		if (super.sessionMap.get("memberId") == null) {
			setMemberId("ゲスト");
		} else {
			setMemberId((String)super.sessionMap.get("memberId"));
		}
	}

	/**
	 * 商品選択チェック
	 * @return　true：選択あり　false：選択なし
	 */
	private boolean isCheckGoods() {
		ArrayList<ResultGoodsList> list = new ArrayList<ResultGoodsList>();
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

	/**
	 * クリア処理
	 */
	private void clear() {
		// 使用したセッションマップのクリア
		// （.clearでクリアすると他の機能で使用しているものもクリアされるため、個別にクリア）
		super.sessionMap.put("memberId", null);
		super.sessionMap.put("goodsList", null);
		super.sessionMap.put("buttonId", null);
		super.sessionMap.put("memberInfo", null);
		super.sessionMap.put("memberInfoTable", null);
		goods.clear();
	}

	/**
	 * カテゴリリスト設定
	 */
	private void setCategoryList() throws TmNoDataFoundException {
		CategoryMasterDao dao = new CategoryMasterDao();
		List<?> list = dao.goodsCategorySelect();

		if (list.size() == 0) {
			// 該当データが存在しない場合はデータセットアップ例外をスロー
			String error = "区分マスタに商品種別が設定されていません。";
			Throwable throwable = new  Throwable();
			throw new TmNoDataFoundException(error, throwable.getCause());
		}

		for (int i = 0; i < list.size(); i++) {
			Category category = new Category();
			category = (Category)list.get(i);

			categoryList.put(category.getCategory(), category.getCategoryValue());
		}
	}

	/**
	 * ソートリスト設定
	 */
	private void setSortList() {
		this.sortList.put("1", "価格が安い順");
		this.sortList.put("2", "価格が高い順");
	}

	/**
	 * 商品リストの設定
	 */
	private void getSortGoodsList() throws Exception {
		String sortSql = "";
		switch(getSortKey()) {
		case "1":
			sortSql = " g.Price ASC, ";
			break;
		case "2":
			sortSql = " g.Price DESC, ";
			break;
		default:
			sortSql = " ";
		}

		// 商品リストの取得
		List<?> resultTable = goodsListSelect(getCategorySelect(), sortSql);
		createGoodsList(resultTable);
	}

	/**
	 * 商品リスト検索
	 * @param category
	 * @param sortAdd
	 * @return resultTable
	 * @throws Exception
	 */
	private List<?> goodsListSelect(String category, String sortAdd) throws Exception {
		GoodsListDao goodsListDao = new GoodsListDao();
		goods.clear();

		// 商品リストを取得
		List<?> resultTable = goodsListDao.resultList(category, sortAdd);

		if (resultTable.size() == 0) {
			// 該当データが存在しない場合はデータセットアップ例外をスロー
			String error = "商品マスタにデータが設定されていません。";
			Throwable throwable = new Throwable();
			throw new TmNoDataFoundException(error, throwable.getCause());
		}

		return resultTable;
	}

	/**
	 * 商品リストの作成
	 * @param resultTable
	 */
	private void createGoodsList(List<?> resultTable) {
		for (int i = 0; i < resultTable.size(); i++) {
			Object[] obj = (Object[])resultTable.get(i);

			GoodsList goodsList = (GoodsList)obj[0];
			Category category = (Category)obj[1];

			// 取得した情報を表示用の変数へ格納
			ResultGoodsList resultList = new ResultGoodsList(goodsList.getCode(),
															 goodsList.getName(),
															 goodsList.getPrice(),
															 category.getCategoryValue());
			goods.add(resultList);
		}
	}

	/**
	 * 選択済みの商品の再設定
	 */
	private void goodsListSetAgain() {
		ArrayList<ResultGoodsList> list = new ArrayList<ResultGoodsList>();
		list = (ArrayList<ResultGoodsList>)super.sessionMap.get("goodsList");

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
}
