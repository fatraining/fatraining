package action;

import java.math.BigInteger;
import java.security.MessageDigest;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import dao.FacloudUsersDao;
import model.Users;
import util.ValidateUtil;

/**
 * ログイン画面
 * @author miyamoto
 *
 */
@Result(name = "facloudTimecard", value = "facloudTimecard.action", type = ServletRedirectResult.class)
public class FacloudLoginAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private String titleTxt;
	private String email;
	private String password;
	private String errMsg;
	
	/**
	 * 画面表示時に実行します。
	 */
	@Override
	public String execute() {
		this.titleTxt = "ログイン";
		this.errMsg = (String)this.sessionMap.get("errMsg");
		this.sessionMap.clear();
		return "success";
	}

	/**
	 * ログイン処理を行います。
	 * @return 成功で"facloudTimecard"、失敗で"failed"
	 */
	public String login(){
		
		// 未入力チェック
		if(this.email.isEmpty() || this.password.isEmpty()){
			// エラーメッセージ
			errBoth();
			return "failed";
		}

		// emailの妥当性チェック
		if(!ValidateUtil.isValidEmail(this.email)){
			errEmail();
			return "failed";
		}
		
		// emailと登録ユーザーが一致するかチェック
		FacloudUsersDao facloudLogin = new FacloudUsersDao();
		Users usersData = facloudLogin.findUsers( this.email );
		if(usersData == null){
			errBoth();
			return "failed";
		}
		
		// passwordがユーザーと一致するかチェック
		if(!isPasswordMatched(usersData)){
			errBoth();
			return "failed";
		}
		
		//ログイン成功
		this.sessionMap.put("errMsg", null);
		this.sessionMap.put("usersData", usersData);
		return "facloudTimecard";
	}
	
	/**
	 * メールアドレスが正しくない場合のerrMsg
	 */
	private void errEmail(){
		this.errMsg = "メールアドレスちょっとおかしない？";
	}
	
	/**
	 * メールアドレス、パスワードが未入力か誤っている場合のerrMsg
	 */
	private void errBoth(){
		this.errMsg = "メールアドレスとパスワードちゃんと入力してーな";
	}
	
	/**
	 * 入力されたパスワードとユーザーのパスワードが一致するかチェックするで
	 * @param userData
	 * @return boolean
	 */
	private boolean isPasswordMatched(Users userData){
		
		//データベースのハッシュされたパスワード
		String userPassword = userData.getPasswordDigest();
		//入力されたパスワードをハッシュ
		String hashedPass = null;
		try {
		    byte[] str_bytes = password.getBytes("UTF-8");
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    byte[] md5_bytes = md.digest(str_bytes);
		    BigInteger big_int = new BigInteger(1, md5_bytes);
		    hashedPass = big_int.toString(16);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//パスワードの一致チェック
		if(userPassword.equals(hashedPass)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * フィールドのtitleTxtに引数を格納するやで。
	 * @param titleTxt 
	 */
	public void setTitleTxt(String titleTxt) {
		this.titleTxt = titleTxt;
	}
	
	/**
	 * titleTxtを取得する。
	 * @return titleTxt
	 */
	public String getTitleTxt(){
		return this.titleTxt;
	}
	
	/**
	 * フィールドのemailに引数を格納する。
	 * @param email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * emailを取得する。
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * フィールドのpasswordに引数を格納する。
	 * @param password 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * passwordを取得する。
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * フィールドのerrMsgに引数を格納する。
	 * @param errMsg 
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * errMsgを取得する。
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	public String passwordReset(){
		this.errMsg = "そんなん言われても困るわ…思い出してーな";
		return "success";
	}

}
