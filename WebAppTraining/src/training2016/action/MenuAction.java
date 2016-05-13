package training2016.action;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

@Results({
	@Result(name = "tosaka", value = "phoneFinder.action", type = ServletRedirectResult.class),
	@Result(name = "harasan", value = "restaurantSearch.action", type = ServletRedirectResult.class),
	@Result(name = "yamazaki", value = "catcafeSearch.action", type = ServletRedirectResult.class),
	@Result(name = "yamamoto", value = "playerFinder.action", type = ServletRedirectResult.class),
	@Result(name = "gotoSimSearch", value = "simFinder.action", type = ServletRedirectResult.class),
	@Result(name = "kasashima", value = "nailSearch.action", type = ServletRedirectResult.class),
})
public class MenuAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "めにう";

	/**
	 * 画面タイトルを返す
	 *
	 * @return
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * executeメソッド
	 * メソッド指定がなかった場合デフォルトで実行される
	 *
	 * @return 結果
	 */
	public String execute() throws Exception {
		return "sccess";
	}

	/**
	 * 登坂さんの標準的Webアプリ画面へ遷移する
	 *
	 * @return 結果
	 */
	public String gotoPhoneSearch() {
		return "tosaka";
	}

	/**
	 * 原さんの悪魔的Webアプリ画面へ遷移する
	 *
	 * @return 結果
	 */
	public String gotoHarasan() {
		return "harasan";
	}

	/**
	 * 山崎晴佳パン祭リ画面へ遷移する
	 *
	 * @return 結果
	 */
	public String gotoCatcafeSearch() {
		return "yamazaki";
	}

	/**
	 * 山本さんのWebアプリ画面へ遷移する
	 *
	 * @return 結果
	 */
	public String gotoPlayerSearch() {
		return "yamamoto";
	}

	/**
	 * 萩原
	 *
	 * @return 結果
	 */
	public String gotoSimSearch() {
		return "gotoSimSearch";
	}

	/**
	 * 笠嶋のネイル検索へ遷移する
	 *
	 * @return 結果
	 */
	public String gotoNailSearch() {
		return "kasashima";
	}
}