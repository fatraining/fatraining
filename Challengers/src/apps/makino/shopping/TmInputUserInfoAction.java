package apps.makino.shopping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import apps.AbstractAction;
import apps.makino.entity.UserInfo;

/**
 * 顧客情報入力・表示画面
 * @author t.makino
 *
 */
@Results( {
@Result(name = "next", value = "tmCheckUserInfo.action", type = ServletRedirectResult.class),
@Result(name = "back", value = "tmOrderCheck.action", type = ServletRedirectResult.class)
})
public class TmInputUserInfoAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 顧客情報テーブルクラス
	 */
	private UserInfo userInfo;
	/**
	 * エラーメッセージ
	 */
	private String errMessage;

	//=============================
	// setter/getter
	//=============================
	/**
	 * 顧客情報テーブルクラス
	 * @param userInfo
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	/**
	 * 顧客情報テーブルクラス
	 * @return
	 */
	public UserInfo getUserInfo() {
		return this.userInfo;
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

	//=============================
	// パブリックメソッド
	//=============================
	/**
	 * execute()
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		if (super.sessionMap.get("userInfo") == null) {
			if (String.valueOf(super.sessionMap.get("userId")).equals("yamada")) {
				userInfo = new UserInfo(
								"山田",
								"太郎",
								"ヤマダ",
								"タロウ",
								0,
								"1989",
								"07",
								"07",
								"26",
								"987",
								"1234",
								"東京都×××××区○○○○５丁目３－１２",
								"▲▲▲▲▲▲ハイツ８０６号室",
								1,
								"090",
								"7777",
								"0000",
								"特になし"
						   );
			} else {
				userInfo = new UserInfo();
			}
		} else {
			userInfo = (UserInfo)super.sessionMap.get("userInfo");
		}

		return "init";
	}

	/**
	 * 次へボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String nextPage() throws Exception {
		if (inputCheck()) {
			super.sessionMap.put("userInfo", userInfo);
			// 顧客情報確認画面へ
			return "next";
		} else {
			return "init";
		}
	}

	/**
	 * 戻るボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String back() throws Exception {
		// 注文確認画面へ
		return "back";
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * 入力チェック
	 * @return　true:エラーなし　false:エラーあり
	 */
	private boolean inputCheck() {
		setErrMessage("");

		// 必須入力チェック
		if (!requiredCheck()) {
			return false;
		}

		// 生年月日妥当性チェック
		if (!birthdayCheck()) {
			return false;
		}

		// 数値チェック
		if (!numberCheck()) {
			return false;
		}

		return true;
	}

	/**
	 * 必須入力チェック
	 * @return　true:エラーなし　false:エラーあり
	 */
	private boolean requiredCheck() {
		// 姓
		if (userInfo.getLastName() == null || userInfo.getLastName().isEmpty()) {
			setErrMessage("「氏名」の「姓」が入力されていません！");
			return false;
		}
		// 名
		if (userInfo.getFirstName() == null || userInfo.getFirstName().isEmpty()) {
			setErrMessage("「氏名」の「名」が入力されていません！");
			return false;
		}
		// セイ
		if (userInfo.getLastNameKana() == null || userInfo.getLastNameKana().isEmpty()) {
			setErrMessage("「フリガナ」の「セイ」が入力されていません！");
			return false;
		}
		// メイ
		if (userInfo.getFirstNameKana() == null || userInfo.getFirstNameKana().isEmpty()) {
			setErrMessage("「フリガナ」の「メイ」が入力されていません！");
			return false;
		}
		// 誕生年
		if (userInfo.getBornYear() == null || userInfo.getBornYear().isEmpty()) {
			setErrMessage("「生年月日」の「西暦」が入力されていません！");
			return false;
		}
		// 誕生月
		if (userInfo.getBornMonth() ==  null || userInfo.getBornMonth().isEmpty()) {
			setErrMessage("「生年月日」の「月」が入力されていません！");
			return false;
		}
		// 誕生日
		if (userInfo.getBornDay() == null || userInfo.getBornDay().isEmpty()) {
			setErrMessage("「生年月日」の「日」が入力されていません！");
			return false;
		}
		// 年齢
		if (userInfo.getAge() == null || userInfo.getAge().isEmpty()) {
			setErrMessage("「年齢」が入力されていません！");
			return false;
		}
		// 郵便番号
		if ((userInfo.getPostalCode1() == null || userInfo.getPostalCode1().isEmpty()) ||
			(userInfo.getPostalCode2() == null || userInfo.getPostalCode2().isEmpty())) {
			setErrMessage("「郵便番号」が入力されていません！");
			return false;
		}
		// 住所
		if (userInfo.getAddress() == null || userInfo.getAddress().isEmpty()) {
			setErrMessage("「住所」が入力されていません！");
			return false;
		}
		// 電話番号
		if ((userInfo.getTelNumber1() == null || userInfo.getTelNumber1().isEmpty()) ||
			(userInfo.getTelNumber2() == null || userInfo.getTelNumber2().isEmpty()) ||
			(userInfo.getTelNumber3() == null || userInfo.getTelNumber3().isEmpty())) {
			setErrMessage("「電話番号」が入力されていません！");
			return false;
		}

		return true;
	}

	/**
	 * 生年月日妥当性チェック
	 * @return　true:エラーなし　false:エラーあり
	 */
	private boolean birthdayCheck() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		// 誕生年　範囲チェック
		if (Integer.parseInt(userInfo.getBornYear()) < 1900 || year < Integer.parseInt(userInfo.getBornYear())) {
			errMessage = "「生年月日」の「西暦」を正しく入力してください！";
			return false;
		}
		// 妥当性チェック
		try {
			DateFormat format=new SimpleDateFormat("yyyy-M-d");
			format.setLenient(false);
			format.parse(String.valueOf(userInfo.getBornYear()) + "-" +
						 String.valueOf(userInfo.getBornMonth()) + "-" +
						 String.valueOf(userInfo.getBornDay()));
		} catch (ParseException e) {
			errMessage = "「生年月日」を正しく入力してください！";
			return false;
		}

		return true;
	}

	/**
	 * 数値チェック
	 * @return true:エラーなし　false:エラーあり
	 */
	private boolean numberCheck() {
		// 郵便番号
		try {
			Integer.parseInt(userInfo.getPostalCode1());
			Integer.parseInt(userInfo.getPostalCode2());

		} catch (NumberFormatException e) {
			errMessage = "「郵便番号」は数値で入力してください！";
			return false;
		}

		// 電話番号
		try {
			Integer.parseInt(userInfo.getTelNumber1());
			Integer.parseInt(userInfo.getTelNumber2());
			Integer.parseInt(userInfo.getTelNumber3());

		} catch (NumberFormatException e) {
			errMessage = "「電話番号」は数値で入力してください！";
			return false;
		}

		return true;
	}
}
