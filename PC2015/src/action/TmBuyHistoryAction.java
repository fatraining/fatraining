package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.CategoryMasterDao;
import dao.OrderInfoDao;
import model.Category;
import model.GoodsList;
import model.OrderInfo;
import model.ResultOrderInfo;
import util.TmNoDataFoundException;

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
	private ArrayList<ResultOrderInfo> orderInfo = new ArrayList<ResultOrderInfo>();
	/**
	 * 会員ID
	 */
	private String memberId;
	/**
	 * 検索条件　カテゴリ
	 */
	private String categorySelect = "";
	/**
	 * カテゴリリスト
	 */
	private HashMap<String, String> categoryList = new HashMap<String, String>();
	/**
	 * 検索条件　年
	 */
	private String year = "";
	/**
	 * 検索条件　月
	 */
	private String month = "";
	/**
	 * 検索条件　日
	 */
	private String day = "";
	/**
	 * 警告メッセージ
	 */
	private String warningMessage;

	//=============================
	// setter/getter
	//=============================	
	/**
	 * 注文情報
	 * @return orderInfo
	 */
	public ArrayList<ResultOrderInfo> getOrderInfo() {
		return orderInfo;
	}
	/**
	 * 注文情報
	 * @param orderInfo
	 */
	public void setOrderInfo(ArrayList<ResultOrderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}
	/**
	 * 会員ID
	 * @return memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * 会員ID
	 * @param memberId
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	 * 検索条件　年
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 検索条件　年
	 * @return year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 検索条件　月
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * 検索条件　月
	 * @return month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * 検索条件　日
	 * @param month
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * 検索条件　日
	 * @return month
	 */
	public String getDay() {
		return day;
	}
	/**
	 * 警告メッセージ
	 * @return warningMessage
	 */
	public String getWarningMessage() {
		return warningMessage;
	}
	/**
	 * 警告メッセージ
	 * @param warningMessage
	 */
	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
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
	 * 検索ボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String search() throws Exception {
		// 初期処理
		init();
		return "init";
	}

	/**
	 * 戻るボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String back() throws Exception {
		// 商品一覧画面へ
		return "back";
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * 初期処理
	 */
	private void init() throws Exception {
		// ユーザーIDの取得
		this.setMemberId((String)super.sessionMap.get("memberId"));

		// カテゴリリストの設定
		setCategoryList();

		// 購入履歴の設定
		setHistory();
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
	 * 購入履歴の設定
	 */
	private void setHistory() {
		// 検索条件の取得
		String orderDateCondition = "";
		String categoryCondition = "";
		if (dateInputCheck()) {
			// 注文日
			if (!this.year.isEmpty()) {
				orderDateCondition = this.year;
			}
			if (!this.month.isEmpty()) {
				if (this.month.length() == 1) {
					orderDateCondition += "/0" + this.month;
				} else {
					orderDateCondition += "/" + this.month;
				}
			}
			if (!this.day.isEmpty()) {
				if (this.day.length() == 1) {
					orderDateCondition += "/0" + this.day;
				} else {
					orderDateCondition += "/" + this.day;
				}
			}
		}

		// カテゴリ
		if (!this.categorySelect.isEmpty()) {
			categoryCondition = this.categorySelect;
		}

		// 注文情報の取得
		OrderInfoDao orderInfoDao = new OrderInfoDao();
		List<?> resultTable = orderInfoDao.orderInfoSelect(this.memberId, orderDateCondition, categoryCondition);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		if (resultTable.size() > 0) {
			for (int i = 0; i < resultTable.size(); i ++) {
				Object[] obj = (Object[])resultTable.get(i);

				OrderInfo orderInfo = (OrderInfo)obj[0];
				GoodsList goodsList = (GoodsList)obj[1];
				Category category = (Category)obj[2];

				// 注文日を YYYY/MM/DD形式へ変換
				String date = dateFormat.format(orderInfo.getOrderDate());
				ResultOrderInfo tmp = new ResultOrderInfo(date,
														  orderInfo.getOrderNo(),
														  orderInfo.getOrderGoodsCode(), 
														  goodsList.getName(),
														  category.getCategoryValue(),
														  goodsList.getPrice(),
														  orderInfo.getOrderQuantity());
				this.orderInfo.add(tmp);
			}
		}
	}

	/**
	 * 日付チェック
	 * @return
	 */
	private boolean dateInputCheck() {
		//-------------------
		// 未入力チェック
		//-------------------
		if (this.year.isEmpty() && this.month.isEmpty() && this.day.isEmpty()) {
			return false;
		}
		
		if (this.year.isEmpty() && (!this.month.isEmpty() || !this.day.isEmpty())) {
			// 年が未入力で月or日が入力されている場合
			this.setWarningMessage("注文日の検索条件が正しく入力されていないため、条件を無視しました。");
			return false;
		}

		if (this.month.isEmpty() && !this.day.isEmpty()) {
			// 月が未入力で日が入力されている場合
			this.setWarningMessage("注文日の検索条件が正しく入力されていないため、条件を無視しました。");
			return false;
		}

		//-------------------
		// 妥当性チェック
		//-------------------
		if (this.year.length() != 4) {
			// 月が1～12以外の数値の場合
			this.setWarningMessage("注文日の年が正しく入力されていないため、条件を無視しました。");
			return false;
		}

		if (!this.month.isEmpty() && (Integer.parseInt(this.month) < 1 || 12 < Integer.parseInt(this.month))) {
			// 月が1～12以外の数値の場合
			this.setWarningMessage("注文日の月が正しく入力されていないため、条件を無視しました。");
			return false;
		}

		if (!this.day.isEmpty() && (Integer.parseInt(this.day) < 1 || 31 < Integer.parseInt(this.day))) {
			// 日が1～31以外の数値の場合
			this.setWarningMessage("注文日の月が正しく入力されていないため、条件を無視しました。");
			return false;
		}

		if (!this.day.isEmpty()) {
			int madDay;
			if (checkUru(this.year)) {
				madDay = 29;
			} else {
				madDay = 28;
			}

			if (Integer.parseInt(this.month) == 2 && Integer.parseInt(this.day) > madDay) {
				// 2月の日付で28（閏年の場合は29）以上入力されている場合
				this.setWarningMessage("注文日の日が正しく入力されていないため、条件を無視しました。");
				return false;
			}

			if ((Integer.parseInt(this.month) == 4 || 
				 Integer.parseInt(this.month) == 6 || 
				 Integer.parseInt(this.month) == 9 || 
				 Integer.parseInt(this.month) == 11)
			 && (Integer.parseInt(this.day) < 1 || 30 < Integer.parseInt(this.month))) {
				// 日が1未満または30日までしかない月で31以上の数値の場合
				this.setWarningMessage("注文日の日が正しく入力されていないため、条件を無視しました。");
				return false;
			}
		}
		
		return true;
	}

	/**
	 * 閏年チェック
	 * @param year
	 * @return
	 */
	private boolean checkUru(String year) {
		if (Integer.parseInt(year) % 4 == 0
		 && Integer.parseInt(year) % 100 != 0
		 && Integer.parseInt(year) % 400 == 0) {
			// 閏年
			return true;
		} else {
			// 通常年
			return false;
		}
	}
}
