package dao;

import java.util.List;

import org.hibernate.classic.Session;

import model.Category;

public class CategoryMasterDao extends HibernateUtil {

	/**
	 * 商品種別を検索
	 * @return
	 */
	public List<?> goodsCategorySelect() {

		//検索結果用の変数
		List<?> resultTable = null;
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		// SQL文
		String select = "SELECT * FROM category_master ";
		String where1 = "WHERE Category LIKE 'GL%' "
						+ "AND DeleteFlag = '0' ";
		String sort = "ORDER BY Category, SubCategory";

		String sql = select + where1 + sort;

		try {
			resultTable = session.createSQLQuery(sql)
							.addEntity(Category.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		return resultTable;
	}

}
