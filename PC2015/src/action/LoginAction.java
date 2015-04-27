package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.*;

@Result(name = "menu", value = "menu.action", type = ServletRedirectResult.class)
public class LoginAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String errmsg;
	public String userId;
	public String password;

	public String execute() throws Exception {
		this.sessionMap.put("userId", null);
		this.userId = "Struts2";
		return "success";
	}

	public String login() throws Exception {
		if (this.password == null || !this.password.equals("pass")) {
			this.password = null;
			this.errmsg = "PASSWORDは「pass」と入力してください";
			return "error";
		}
		this.sessionMap.put("userId", this.userId);
		return "menu";
	}
}