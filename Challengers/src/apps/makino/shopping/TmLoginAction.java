package apps.makino.shopping;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import apps.AbstractAction;

/**
 * ログイン画面
 * @author t.makino
 *
 */
@Results( {
@Result(name = "back", value = "goodsList.action", type = ServletRedirectResult.class),
@Result(name = "orderCheck", value = "tmOrderCheck.action", type = ServletRedirectResult.class)
})
public class TmLoginAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	//======================
	// フィールド宣言
	//======================
	/**
	 * エラーメッセージ
	 */
	private String errMessage;
	/**
	 * ユーザーID
	 */
	private String userId;
	/**
	 * パスワード
	 */
	private String password;
	/**
	 * ボタンID
	 */
	private String buttonId;

	//======================
	// setter/getter
	//======================
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
	 * ユーザーID
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * ユーザーID
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	/**
	 * パスワード
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * パスワード
	 * @return password
	 */
	public String getPassword() {
		return this.password;
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
		super.sessionMap.put("userId", null);
		setButtonId(String.valueOf(super.sessionMap.get("buttonId")));
		return "success";
	}

	/**
	 * ログインボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		// 入力チェック
		if(!inputCheck()){
			return "error";
		}

		//　ユーザーIDを保持
		super.sessionMap.put("userId", this.userId);

		// 遷移先の判定
		String buttonId = (String)super.sessionMap.get("buttonId");
		if (buttonId.equals("login")) {
			// 注文一覧画面
			return "back";
		} else {
			// 注文確認画面
			return "orderCheck";
		}
	}

	/**
	 * 戻るボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String back() throws Exception {
		// 注文一覧画面
		return "back";
	}

	/**
	 * ログインせずにお買い物ボタン押下時
	 * @return
	 */
	public String notLogin() {
		// 注文確認画面
		return "orderCheck";
	}

	//=============================
	// プライベートメソッド
	//=============================
	/**
	 * 入力チェック
	 * @return true:エラーなし　false:エラーあり
	 */
	private boolean inputCheck() {
		// 会員ID未入力チェック
		if (this.userId == null || this.userId.isEmpty()) {
			this.errMessage = "「会員ID」が未入力です";
			return false;
		}

		// パスワード未入力チェック
		if (this.password == null || this.password.isEmpty()) {
			this.errMessage = "「パスワード」が未入力です";
			return false;
		}

		// パスワード整合性チェック
		if (!this.password.equals("pass")){
			this.password = null;
			this.errMessage = "「会員ID」または「パスワード」が正しくありません";
			return false;
		}

		return true;
	}
}
