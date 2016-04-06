package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

/**
 * 顧客登録完了画面
 * @author t.makino
 *
 */
@Result(name = "back", value = "goodsList.action", type = ServletRedirectResult.class)
public class TmRegistrationConfirmAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// パブリックメソッド
	//=============================
	/**
	 * execute
	 * @return
	 * @throws Exception
	 */
	public String execute() throws Exception {
		return "init";
	}

	/**
	 * 商品一覧へボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String backToTop() throws Exception {
		// 商品一覧画面へ
		return "back";
	}
}
