package training2016.dao;

import java.util.List;

import training2016.model.AbstractSearchCondition;
import training2016.model.Copy;
import training2016.model.CopySearchCondition;

public class CopyDao extends AbstractDao {
	/**
	 * 全件表示
	 *
	 */
	public List<Copy> getAll() {
		// 検索
		List<Copy> copyList = this.select(new CopySearchCondition());
		return copyList;
	}

	/**
	 * 検索
	 *
	 * @param cond
	 */
	public List<Copy> getByCondition(AbstractSearchCondition cond) {
		// 検索
		List<Copy> copyList = this.select(cond);
		System.out.println(copyList);
		return copyList;
	}

	/**
	 * 登録
	 *
	 * @param model
	 */
	public void insert(Copy model) {
		this.apply(model, (s, m) -> {s.save(m);});
	}

	/**
	 * 更新
	 *
	 * @param model
	 */
	public void update(Copy model) {
		this.apply(model, (s, m) -> {s.update(m);});
	}

}
