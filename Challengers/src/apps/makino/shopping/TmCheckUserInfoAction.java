package apps.makino.shopping;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import apps.AbstractAction;
import apps.makino.entity.UserInfo;

/**
 * 顧客情報確認画面
 * @author t.makino
 *
 */
@Results( {
@Result(name = "next", value = "tmOrderConfirm.action", type = ServletRedirectResult.class),
@Result(name = "back", value = "tmInputUserInfo.action", type = ServletRedirectResult.class)
})
public class TmCheckUserInfoAction extends AbstractAction {
	public static final long serialVersionUID = 1L;

	//=============================
	// フィールド宣言
	//=============================
	/**
	 * 顧客情報テーブルクラス
	 */
	private UserInfo userInfo;

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

	//=============================
	// パブリックメソッド
	//=============================
	/**
	 * execute
     * @return
     * @throws Exception
	 */
	public String execute() {
		// 顧客情報を取得
		setUserInfo((UserInfo)this.sessionMap.get("userInfo"));

		return "init";
	}

	/**
	 * 次へボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String nextPage() throws Exception {
		// 注文確定画面へ
		return "next";
	}

	/**
	 * 戻るボタン押下時
	 * @return
	 * @throws Exception
	 */
	public String back() throws Exception {
		// 顧客情報表示・入力画面へ
		return "back";
	}
}
