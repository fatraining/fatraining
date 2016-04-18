package training2016.dao;

import java.util.List;

import org.hibernate.Query;

import training2016.model.AbstractSearchCondition;
import training2016.model.Area;
import training2016.model.AreaSearchCondition;

public class AreaDao extends AbstractDao {

	/**
	 * 全件取得
	 *
	 * @return
	 */
	public List<Area> getAll() {
		// 検索
		List<Area> areaList = this.select(new AreaSearchCondition());
		return areaList;
	}

	/**
	 * 検索条件Queryを生成して返す。<br>
	 * 現状、エリアに関しては全件取得以外しないので、検索条件モデルは見ない
	 *
	 * @param SearchConditionInterface 検索条件モデル
	 */
	protected Query generateQuery(AbstractSearchCondition cond) {
		return this.getSession().createQuery(" from training2016.model.Area ");
	}
}
