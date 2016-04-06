package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

/**
 * パスワード変更完了画面
 * @author t.makino
 *
 */
@Result(name = "back", value = "goodsList.action", type = ServletRedirectResult.class)
public class TmChangePasswordConfirmAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 会員ID
	 */
	private String memberId;

	//=============================
	// setter/getter
	//=============================	
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

	//=============================
	// パブリックメソッド
	//=============================
	/**
	 * execute
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		this.setMemberId((String)super.sessionMap.get("memberId"));
		return "init";
	}

	/**
	 * 戻るボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String back() throws Exception {
		return "back";
	}
}
