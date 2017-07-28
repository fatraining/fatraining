package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.GalgameMaker;
import training2016.model.GalgameProduct;

public class GalgameDao extends AbstractDao {

	@SuppressWarnings("unchecked")
	public List<GalgameMaker> getMakerNameList() {

		List<GalgameMaker> resultTable = null;

		// DB接続
		Session session = this.getCurrentSession();

		try {
			// トランザクション開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM galgamemaker ORDER BY id")
					// 要素がGalgameMakerエンティティであるものを返す
					.addEntity("GalgameMaker", GalgameMaker.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.beginTransaction().commit();
		return resultTable;
	}

	// 検索結果表示
	/*----------------------------------------------
	*/

	/* 条件なし */

	@SuppressWarnings("unchecked")
	public List<GalgameProduct> galgameList() {
		List<GalgameProduct> resultTable = null;
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		String select = "SELECT {gp.*},{gm.*} FROM GalgameProduct gp, GalgameMaker gm";
		String where1 = "WHERE gp.makerId = gm.id ORDER BY makerId,year";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("gp", GalgameProduct.class)
					.addEntity("gm", GalgameMaker.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/* 条件あり */

	@SuppressWarnings("unchecked")
	public List<GalgameProduct> resultList(String makerId, String name) {
		List<GalgameProduct> resultTable = null;
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		String select = "SELECT {gp.*},{gm.*} FROM GalgameProduct gp, GalgameMaker gm";
		String where1 = "WHERE gp.makerId = gm.id ";
		String order = "ORDER BY makerId,year";
		StringBuilder sb = new StringBuilder();
		sb.append("");

		if (!StringUtils.isEmpty(makerId)) {
			sb.append("AND (gp.makerId = ").append(makerId).append(" )");
		}
		if (!StringUtils.isEmpty(name)) {
			sb.append("AND (gp.name LIKE '%").append(name).append("%' )");
		}
		String where2 = sb.toString();
		String sql = select + " " + where1 + " " + where2 + " "+order;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("gp", GalgameProduct.class)
					.addEntity("gm", GalgameMaker.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	// 削除表示
	/*----------------------------------------------
	*/

	/* 削除するテーブルの一覧表示 */

	@SuppressWarnings("unchecked")
	public List<GalgameProduct> selectForDelete(String[] deleteId) {
		List<GalgameProduct> resultTable = null;
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		String select = "SELECT {gp.*},{gm.*} FROM GalgameProduct gp, GalgameMaker gm";
		String where1 = "WHERE gp.makerId = gm.id ";
		String where2 = "AND gp.id in (";
		String order = "ORDER BY makerId,year";

		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += ","; // 2個目以降の削除IDを指定するときにカンマを追加する
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2 + " "+order;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("gp",GalgameProduct.class)
					.addEntity("gm",GalgameMaker.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/* 削除の実行 */

	public void delete(String delete) {
		Session session = this.getCurrentSession();
		// 削除IDはカンマ区切りで渡されるのでそれを分割、配列へと格納する
		String[] deleteId = delete.split(",");

		// トランザクション開始
		session.beginTransaction();

		for (int i = 0; i < deleteId.length; i++) {
			int id = Integer.parseInt(deleteId[i].trim());
			try {
				GalgameProduct galgameProduct = (GalgameProduct) session.load(GalgameProduct.class, id);
				session.delete(galgameProduct);
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		// 必ずすること
		session.getTransaction().commit();
	}

	/* 追加の実行 */

	public void insert(String makerId, String name, String year, String score, String comment) {
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		GalgameProduct gp = new GalgameProduct();
		// idはオートインクリメントで自動に設定
		gp.setMakerId(Integer.parseInt(makerId));
		gp.setName(name);
		gp.setYear(Integer.parseInt(year));
		gp.setScore(Integer.parseInt(score));
		gp.setComment(comment);

		try {
			session.save(gp);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	/* 更新の実行 */
	public void updata(GalgameProduct model) {
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		try {
			session.update(model);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}
}
