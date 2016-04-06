package action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.MembersMasterDao;
import model.ResultMemberInfo;

@Results( {
@Result(name = "back", value = "tmLogin.action", type = ServletRedirectResult.class),
@Result(name = "next", value = "tmCheckRegistrationMember.action", type = ServletRedirectResult.class)
})
public class TmRegistrationMemberAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	//======================
	// フィールド宣言
	//======================
	/**
	 * 顧客情報クラス
	 */
	private ResultMemberInfo memberInfo;
	/**
	 * エラーメッセージ
	 */
	private String errMessage;
	/**
	 * エラーメッセージ（顧客情報用）
	 */
	private String errMessageInfo;

	//======================
	// setter/getter
	//======================
	/**
	 * 顧客情報クラス
	 * @param memberInfo
	 */
	public void setMemberInfo(ResultMemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	/**
	 * 顧客情報クラス
	 * @return memberInfo
	 */
	public ResultMemberInfo getMemberInfo() {
		return this.memberInfo;
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
	 * エラーメッセージ（顧客情報用）
	 * @param errMessageInfo
	 */
	public void setErrMessageInfo(String errMessageInfo) {
		this.errMessageInfo = errMessageInfo;
	}
	/**
	 * エラーメッセージ（顧客情報用）
	 * @return errMessageInfo
	 */
	public String getErrMessageInfo() {
		return this.errMessageInfo;
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
		memberInfo = (ResultMemberInfo)super.sessionMap.get("memberInfo");
		return "success";
	}

	/**
	 * 次へボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String nextPage() throws Exception {
		if (inputCheck()) {
			super.sessionMap.put("memberInfo", memberInfo);
			return "next";
		} else {
			return "warning";
		}
	}

	/**
	 * 戻るボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String back() throws Exception {
		super.sessionMap.put("memberInfo", null);
		return "back";
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * 入力チェック
	 * @return
	 */
	private boolean inputCheck() {
		// ログイン情報のチェック
		if (!checkLoginInfo()) {
			return false;
		}

		// 顧客情報のチェック
		if (!checkMemberInfo()) {
			return false;
		}
		return true;
	}
	
	/**
	 * ログイン情報の入力チェック
	 * @return
	 */
	private boolean checkLoginInfo() {
		String memberId = this.memberInfo.getMemberId();
		String password = this.memberInfo.getPassword();
		String password2 = this.memberInfo.getPassword2();

		//----------------------
		// 未入力チェック
		//----------------------
		// 会員ID
		if (!inputIsEmpty(memberId)) {
			this.setErrMessage("「会員ID」が入力されていません！");
			return false;
		}

		// パスワード
		if (!inputIsEmpty(password)) {
			this.setErrMessage("「パスワード」が入力されていません！");
			return false;
		}

		// パスワード確認用
		if (!inputIsEmpty(password2)) {
			this.setErrMessage("「パスワード確認用」が入力されていません！");
			return false;
		}

		//----------------------
		// 会員ID重複チェック
		//----------------------
		if (memberId.equals("ゲスト") || memberId.equals("********************")) {
			// システムで使用しているIDが入力された場合はエラー
			this.setErrMessage("ご入力の「会員ID」は他の会員によって使用済みです。別の会員IDを入力してください。");
			return false;
		}
		// 会員ID で会員マスタを検索
		MembersMasterDao dao = new MembersMasterDao();
		List<?> resultTable = dao.memberIdSelect("memberId");

		if (resultTable.size() > 0) {
			// 該当データが存在する場合は登録済みのため、エラー
			this.setErrMessage("ご入力の「会員ID」は他の会員によって使用済みです。別の会員IDを入力してください。");
			return false;
		}

		//----------------------
		// パスワード文字数チェック
		//----------------------
		if (password.length() < 4 || password.length() > 12) {
			this.setErrMessage("「パスワード」は半角英数字4文字以上12文字以内で入力してください。");
			return false;
		}

		//----------------------
		// パスワード整合性チェック
		//----------------------
		if (!password.equals(password2)) {
			this.setErrMessage("「パスワード」と「パスワード確認用」が一致していません。もう一度入力してください。");
			return false;
		}

		return true;
	}

	/**
	 * 顧客情報の入力チェック
	 * @return
	 */
	private boolean checkMemberInfo() {
		//----------------------
		// 未入力チェック
		//----------------------
		// 姓
		if (!inputIsEmpty(this.memberInfo.getLastName())) {
			this.setErrMessageInfo("「氏名」の「姓」が入力されていません！");
			return false;
		}

		// 名
		if (!inputIsEmpty(this.memberInfo.getFirstName())) {
			this.setErrMessageInfo("「氏名」の「名」が入力されていません！");
			return false;
		}

		// セイ
		if (!inputIsEmpty(this.memberInfo.getLastNameKana())) {
			this.setErrMessageInfo("「フリガナ」の「セイ」が入力されていません！");
			return false;
		}

		// メイ
		if (!inputIsEmpty(this.memberInfo.getFirstNameKana())) {
			this.setErrMessageInfo("「フリガナ」の「メイ」が入力されていません！");
			return false;
		}

		// 生年月日　西暦
		if (!inputIsEmpty(this.memberInfo.getBornYear())) {
			this.setErrMessageInfo("「生年月日」の「西暦」が入力されていません！");
			return false;
		}

		// 生年月日　月
		if (!inputIsEmpty(this.memberInfo.getBornMonth())) {
			this.setErrMessageInfo("「生年月日」の「月」が入力されていません！");
			return false;
		}

		// 生年月日　日
		if (!inputIsEmpty(this.memberInfo.getBornDay())) {
			this.setErrMessageInfo("「生年月日」の「日」が入力されていません！");
			return false;
		}

		// 年齢
		if (!inputIsEmpty(this.memberInfo.getAge())) {
			this.setErrMessageInfo("「年齢」が入力されていません！");
			return false;
		}

		// 郵便番号
		if (!inputIsEmpty(this.memberInfo.getPostalCode1()) || !inputIsEmpty(this.memberInfo.getPostalCode2())) {
			this.setErrMessageInfo("「郵便番号」が入力されていません！");
			return false;
		}

		// 住所
		if (!inputIsEmpty(this.memberInfo.getAddress())) {
			this.setErrMessageInfo("「住所」が入力されていません！");
			return false;
		}

		// 電話番号
		if (!inputIsEmpty(this.memberInfo.getTelNumber1())
		 || !inputIsEmpty(this.memberInfo.getTelNumber2())
		 || !inputIsEmpty(this.memberInfo.getTelNumber3())) {
			this.setErrMessageInfo("「電話番号」が入力されていません！");
			return false;
		}

		//----------------------
		// 生年月日チェック
		//----------------------
		if (!birthdayCheck()) {
			return false;
		}

		//----------------------
		// 数値チェック
		//----------------------
		if (!numberCheck()) {
			
		}
		return true;
	}

	/**
	 * 未入力チェック
	 * @param input
	 * @return true:入力あり　false:未入力
	 */
	private boolean inputIsEmpty(String input) {
		if (input == null || input.trim().isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * 生年月日チェック
	 * @return　true:エラーなし　false:エラーあり
	 */
	private boolean birthdayCheck() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		// 誕生年　範囲チェック
		if (Integer.parseInt(memberInfo.getBornYear()) < 1900 || year < Integer.parseInt(memberInfo.getBornYear())) {
			this.errMessageInfo = "「生年月日」の「西暦」を正しく入力してください！";
			return false;
		}
		// 妥当性チェック
		try {
			DateFormat format=new SimpleDateFormat("yyyy-M-d");
			format.setLenient(false);
			format.parse(String.valueOf(memberInfo.getBornYear()) + "-" + 
						 String.valueOf(memberInfo.getBornMonth()) + "-" +
						 String.valueOf(memberInfo.getBornDay()));			
		} catch (ParseException e) {
			this.errMessageInfo = "「生年月日」を正しく入力してください！";
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
			Integer.parseInt(memberInfo.getPostalCode1());
			Integer.parseInt(memberInfo.getPostalCode2());
			
		} catch (NumberFormatException e) {
			errMessage = "「郵便番号」は数値で入力してください！";
			return false;
		}

		// 電話番号
		try {
			Integer.parseInt(memberInfo.getTelNumber1());
			Integer.parseInt(memberInfo.getTelNumber2());
			Integer.parseInt(memberInfo.getTelNumber3());

		} catch (NumberFormatException e) {
			errMessage = "「電話番号」は数値で入力してください！";
			return false;
		}

		return true;
	}

}
