package training2016.action;

import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.RestaurantDao;
import training2016.model.Restaurant;
import training2016.model.RestaurantSearchCondition;

/**
 * 飲み屋削除Action
 *
 * @author harasan
 */
@Results({
	@Result(name = "backToSearch", value = "restaurantSearch!redisplay", type = ServletRedirectResult.class)
})
public class RestaurantDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String title = "いらん店削除";

	/** 検索結果リスト */
	private List<Restaurant> resultList;

	/**
	 * executeメソッド。
	 *
	 * @return 結果
	 */
	public String execute() throws Exception {
		String[] deleteId = this.getValueFromSession("deleteId");

		RestaurantDao dao = new RestaurantDao();
		RestaurantSearchCondition cond = new RestaurantSearchCondition();
		cond.setIds(deleteId);
		this.resultList = dao.select(cond);
		if (resultList == null || resultList.isEmpty()) {
			this.addActionError("なかった");
		}
		return "success";
	}

	/**
	 * deleteメソッド。
	 *
	 * @return 結果
	 */
	public String delete() {
		String[] deleteId = this.getValueFromSession("deleteId");

		// 取得して削除
		RestaurantDao dao = new RestaurantDao();
		RestaurantSearchCondition cond = new RestaurantSearchCondition();
		cond.setIds(deleteId);
		this.resultList = dao.select(cond);
		for (Restaurant target : this.resultList) {
			dao.delete(target);
		}

		// 削除し終わったらセッションから消す
		this.putValueToSession("deleteId", null);

		return "backToSearch";
	}

	/**
	 * 検索画面に戻る
	 *
	 * @return
	 */
	public String back() {
		return "backToSearch";
	}

	/**
	 * resultListを返す
	 *
	 * @return resultList
	 */
	public List<Restaurant> getResultList() {
		return this.resultList;
	}

	/**
	 * titleを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
}
