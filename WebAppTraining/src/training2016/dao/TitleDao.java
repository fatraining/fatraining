package training2016.dao;

import java.util.List;

import training2016.model.Title;
import training2016.model.TitleSearchCondition;

public class TitleDao extends AbstractDao {
	/**
	 * 全件取得
	 *
	 * @return
	 */
	public List<Title> getAll() {
		// 検索
		List<Title> titleList = this.select(new TitleSearchCondition());
		return titleList;
	}
}
