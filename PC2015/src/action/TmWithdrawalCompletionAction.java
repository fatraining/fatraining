package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

@Result(name = "back", value = "menu.action", type = ServletRedirectResult.class)
public class TmWithdrawalCompletionAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// パブリックメソッド
	//=============================
	/**
	 * execute()
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		return "init";
	}

	/**
	 * 閉じるボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String close() throws Exception {
		return "back";
	}

}
