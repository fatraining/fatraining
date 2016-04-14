package training2016.action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.constant.Constants;

@Result(name = "menu", value = "menu.action", type = ServletRedirectResult.class)
public class LoginAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private String userId;
	private String errmsg;
	private String password;

	/** 画面タイトル */
	private String title = "ログイン";

	public String execute() throws Exception {
		// セッションマップからユーザIDを削除
		this.removeFromSession(Constants.SESSION_KEY_USERID);
		this.userId = "struts2";
		return "success";
	}

	public String login() throws Exception {
		if (this.password == null || !this.password.equals("pass")) {
			this.password = null;
			this.errmsg = "PASSWORDは「pass」と入力してください";
			return "error";
		}
		// ユーザIDをセッションマップへ格納
		super.putValueToSession(Constants.SESSION_KEY_USERID, this.userId);
		return "menu";
	}

	/**
	 * ユーザIDを返す
	 *
	 * @return
	 */
	@Override
	public String getUserId() {
		return this.userId;
	}

	/**
	 * ユーザIDをセットする
	 *
	 * @param userId ユーザID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * errmsgを返す
	 *
	 * @return errmsg
	 */
	public String getErrmsg() {
		return this.errmsg;
	}

	/**
	 * errmsgをセットする
	 *
	 * @param errmsg セットする errmsg
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	/**
	 * passwordを返す
	 *
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * passwordをセットする
	 *
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 画面タイトルを返す
	 *
	 * @return タイトル文字列
	 */
	public String getTitle() {
		return this.title;
	}
}