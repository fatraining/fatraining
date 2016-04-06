package dao;

import java.util.List;

import org.hibernate.classic.Session;

import model.GoodsList;
import model.Category;

public class GoodsListDao extends HibernateUtil {

	/**
	 * 商品リストテーブル検索
	 * @return
	 */
	public List<?> resultList(String category, String sortAdd) {

		// 検索結果用の変数
		List<?> resultTable = null;
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		String conditions;
		if (category == null || category.isEmpty()) {
			conditions = "%";
		} else {
			conditions = category.replace("'", "''");
		}

		// SQL文
		String select = "SELECT {g.*}, {c.*} FROM GoodsList g, category_master c ";
		String where1 = "WHERE g.Category LIKE '" + conditions + "' "
						+ "AND g.Category = c.Category "
						+ "AND g.DeleteFlag = '0' "
						+ "AND c.DeleteFlag = '0' ";
		String sort = "ORDER BY ";
		String sort1 = "g.Category ASC, g.GoodsCode ASC";

		String sql = select + where1 + sort + sortAdd + sort1;

		try {
			resultTable = session.createSQLQuery(sql)
							// Resultテーブルにsql文を代入する。
							.addEntity("g", GoodsList.class)
							.addEntity("c", Category.class).list();

		} catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}
}
