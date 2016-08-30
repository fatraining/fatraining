package training2016.action;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

@Results({ @Result(name = "tosaka", value = "phoneFinder.action", type = ServletRedirectResult.class),
		@Result(name = "harasan", value = "restaurantSearch.action", type = ServletRedirectResult.class),
		@Result(name = "matsufuji", value = "hpiventSearch.action", type = ServletRedirectResult.class),
		@Result(name = "yamazaki", value = "catcafeSearch.action", type = ServletRedirectResult.class),
		@Result(name = "yamamoto", value = "playerFinder.action", type = ServletRedirectResult.class),
		@Result(name = "sakeSearch", value = "sakeSearch.action", type = ServletRedirectResult.class),
		@Result(name = "baseballSearch", value = "baseballSearch.action", type = ServletRedirectResult.class),
		@Result(name = "riderSearch", value = "riderSearch.action", type = ServletRedirectResult.class),
		@Result(name = "gotoSimSearch", value = "simFinder.action", type = ServletRedirectResult.class),
		@Result(name = "kasashima", value = "nailSearch.action", type = ServletRedirectResult.class),
		@Result(name = "guitarSearch", value = "guitarSearch.action", type = ServletRedirectResult.class),
		@Result(name = "aquariumSearch", value = "aquariumSearch.action", type = ServletRedirectResult.class),
		@Result(name = "gotoBeerbrandsSearch", value = "beerbrandsSearch.action", type = ServletRedirectResult.class),
		@Result(name = "dramaSearch", value = "dramaSearch.action", type = ServletRedirectResult.class),
		@Result(name = "thsSearch", value = "thsSearch.action", type = ServletRedirectResult.class),
		@Result(name = "sneakersSearch", value = "sneakersSearch.action", type = ServletRedirectResult.class),
	@Result(name = "maiwaifuSearch", value = "maiwaifuSearch.action", type = ServletRedirectResult.class),

		@Result(name = "onsenSearch", value = "onsenSearch.action", type = ServletRedirectResult.class), })
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
	 * executeメソッド メソッド指定がなかった場合デフォルトで実行される
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
	 * まつふじ
	 *
	 * @return 結果
	 */
	public String gotoHpiventSearch() {
		return "matsufuji";
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
	 * 山花さんのWebアプリ画面へ遷移する
	 *
	 * @return 結果
	 */
	public String gotoSakeSearch() {
		return "sakeSearch";
	}

	/**
	 * 新宮
	 *
	 * @return 結果
	 */
	public String gotoRiderSearch() {
		return "riderSearch";
	}

	/**
	 * 木村さんのWebアプリ画面へ遷移する
	 *
	 * @return 結果
	 */
	public String gotoBaseballSearch() {
		return "baseballSearch";
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

	/**
	 * 鈴木のギター検索へ遷移する
	 *
	 * @return 結果
	 */
	public String guitarSearch() {
		return "guitarSearch";
	}

	/**
	 * 柴田の水族館検索へ遷移する
	 *
	 * @return 結果
	 */
	public String aquariumSearch() {
		return "aquariumSearch";
	}

	/**
	 * きどのビール銘柄検索へ遷移する
	 *
	 * @return 結果
	 */
	public String gotoBeerbrandsSearch() {
		return "gotoBeerbrandsSearch";
	}

	/**
	 * 菅原の韓国ドラマ検索へ遷移する
	 *
	 * @return 結果
	 */
	public String dramaSearch() {
		return "dramaSearch";
	}

	/**
	 * 藤川の講師検索へ遷移する
	 *
	 * @return 結果
	 */
	public String thsSearch() {
		return "thsSearch";
	}

	/**
	 * セキグチのスニーカー検索へ遷移する
	 *
	 * @return 結果
	 */
	public String sneakersSearch() {
		return "sneakersSearch";
	}

	/**
	 * 坂井の温泉検索へ遷移する
	 *
	 * @return 結果
	 */
	public String onsenSearch() {
		return "onsenSearch";
	}

}