package training2016.dao;

import java.util.List;

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
}
