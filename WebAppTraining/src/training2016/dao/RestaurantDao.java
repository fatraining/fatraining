package training2016.dao;

import java.util.List;

import training2016.model.AbstractSearchCondition;
import training2016.model.Restaurant;
import training2016.model.RestaurantSearchCondition;

public class RestaurantDao extends AbstractDao {

	/**
	 * 全件取得
	 *
	 * @return 検索結果リスト
	 */
	public List<Restaurant> getAll() {
		// 検索
		List<Restaurant> restaurantList = this.select(new RestaurantSearchCondition());
		return restaurantList;
	}

	/**
	 * 検索条件を満たすモデルのリストを取得する
	 *
	 * @param cond
	 * @return 検索結果リスト
	 */
	public List<Restaurant> getByCondition(AbstractSearchCondition cond) {
		// 検索
		List<Restaurant> restaurantList = this.select(cond);
		return restaurantList;
	}

	public void insert(Restaurant model) {
		this.save(model);
	}
}
