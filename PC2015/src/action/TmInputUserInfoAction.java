package action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.MemberInfoDao;
import model.MemberInfo;
import model.ResultMemberInfo;

/**
 * 顧客情報入力・表示画面
 * @author t.makino
 *
 */
@Results( {
@Result(name = "next", value = "tmCheckUserInfo.action", type = ServletRedirectResult.class),
@Result(name = "back", value = "tmOrderCheck.action", type = ServletRedirectResult.class),
@Result(name = "goodsList", value = "goodsList.action", type = ServletRedirectResult.class)
})
public class TmInputUserInfoAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 顧客情報クラス（画面表示用）
	 */
	private ResultMemberInfo memberInfo;
	/**
	 * 顧客情報テーブルクラス
	 */
	private MemberInfo memberInfoTable;
	/**
	 * ボタンID
	 */
	private String buttonId;
	/**
	 * エラーメッセージ
	 */
	private String errMessage;

	//=============================
	// setter/getter
	//=============================
	/**
	 * 顧客情報クラス（画面表示用）
	 * @param memberInfo
	 */
	public void setMemberInfo(ResultMemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	/**
	 * 顧客情報クラス（画面表示用）
	 * @return memberInfo
	 */
	public ResultMemberInfo getMemberInfo() {
		return this.memberInfo;
	}
	/**
	 * 顧客情報テーブルクラス
	 * @param memberInfoTable
	 */
	public void setMemberInfoTable(MemberInfo memberInfoTable) {
		this.memberInfoTable = memberInfoTable;
	}
	/**
	 * 顧客情報テーブルクラス
	 * @return memberInfoTable
	 */
	public MemberInfo getMemberInfoTable() {
		return this.memberInfoTable;
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
	 * @param buttonId
	 */
	public void setButtonId(String buttonId) {
		this.buttonId = buttonId;
	}
	/**
	 * ボタンID
	 * @return buttonId
	 */
	public String getButtonId() {
		return buttonId;
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
		// 初期処理
		init();
		return "init";
	}

	/**
	 * 次へボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String nextPage() throws Exception {
		if (inputCheck()) {
			super.sessionMap.put("memberInfo", memberInfo);
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
		if ("buy".equals((String)super.sessionMap.get("buttonId"))) {
			// 注文確認画面へ
			return "back";
		}

		// 商品一覧画面へ
		return "goodsList";
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * 初期処理
	 * @throws Exception
	 */
	private void init() throws Exception {
		if (super.sessionMap.get("memberId") == null) {
			// ログインしていない場合はインスタンスの生成のみ実施
			memberInfo = new ResultMemberInfo();
			return;
		}

		// ボタンIDの取得
		setButtonId((String)super.sessionMap.get("buttonId"));

		// ユーザー情報の取得
		MemberInfoDao memberInfoDao = new MemberInfoDao();
		List<?> resultTable = memberInfoDao.memberInfoSelect((String)super.sessionMap.get("memberId"));

		if (resultTable.size() > 0) {
			// 取得した情報を画面表示
			formSet(resultTable);
		}


	}

	/**
	 * 画面表示処理
	 * @param resultTable
	 */
	private void formSet(List<?> resultTable) {
		MemberInfo info = (MemberInfo)resultTable.get(0);
		this.memberInfo = new ResultMemberInfo(info.getLastName()
											  ,info.getFirstName()
											  ,info.getLastNameKana()
											  ,info.getFirstNameKana()
											  ,info.getSex()
											  ,info.getBirthday()
											  ,info.getAge()
											  ,info.getPostalCode()
											  ,info.getAddress()
											  ,info.getBuilding()
											  ,info.getTelKind()
											  ,info.getTelNumber());

		// 取得した顧客情報を保持
		setMemberInfoTable(info);
		super.sessionMap.put("memberInfoTable", getMemberInfoTable());
	}

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
		if (memberInfo.getLastName() == null || memberInfo.getLastName().isEmpty()) {
			setErrMessage("「氏名」の「姓」が入力されていません！");
			return false;
		}
		// 名
		if (memberInfo.getFirstName() == null || memberInfo.getFirstName().isEmpty()) {
			setErrMessage("「氏名」の「名」が入力されていません！");
			return false;
		}
		// セイ
		if (memberInfo.getLastNameKana() == null || memberInfo.getLastNameKana().isEmpty()) {
			setErrMessage("「フリガナ」の「セイ」が入力されていません！");
			return false;
		}
		// メイ
		if (memberInfo.getFirstNameKana() == null || memberInfo.getFirstNameKana().isEmpty()) {
			setErrMessage("「フリガナ」の「メイ」が入力されていません！");
			return false;
		}
		// 誕生年
		if (memberInfo.getBornYear() == null || memberInfo.getBornYear().isEmpty()) {
			setErrMessage("「生年月日」の「西暦」が入力されていません！");
			return false;
		}
		// 誕生月
		if (memberInfo.getBornMonth() ==  null || memberInfo.getBornMonth().isEmpty()) {
			setErrMessage("「生年月日」の「月」が入力されていません！");
			return false;
		}
		// 誕生日
		if (memberInfo.getBornDay() == null || memberInfo.getBornDay().isEmpty()) {
			setErrMessage("「生年月日」の「日」が入力されていません！");
			return false;
		}
		// 年齢
		if (memberInfo.getAge() == null || memberInfo.getAge().isEmpty()) {
			setErrMessage("「年齢」が入力されていません！");
			return false;
		}
		// 郵便番号
		if ((memberInfo.getPostalCode1() == null || memberInfo.getPostalCode1().isEmpty()) ||
			(memberInfo.getPostalCode2() == null || memberInfo.getPostalCode2().isEmpty())) {
			setErrMessage("「郵便番号」が入力されていません！");
			return false;
		}
		// お届け先
		if (memberInfo.getAddress() == null || memberInfo.getAddress().isEmpty()) {
			setErrMessage("「お届け先」が入力されていません！");
			return false;
		}
		// 電話番号
		if ((memberInfo.getTelNumber1() == null || memberInfo.getTelNumber1().isEmpty()) ||
			(memberInfo.getTelNumber2() == null || memberInfo.getTelNumber2().isEmpty()) ||
			(memberInfo.getTelNumber3() == null || memberInfo.getTelNumber3().isEmpty())) {
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
		if (Integer.parseInt(memberInfo.getBornYear()) < 1900 || year < Integer.parseInt(memberInfo.getBornYear())) {
			errMessage = "「生年月日」の「西暦」を正しく入力してください！";
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
