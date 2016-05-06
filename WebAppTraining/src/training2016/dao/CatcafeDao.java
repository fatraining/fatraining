package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Catarea;
import training2016.model.Catcafe;

@SuppressWarnings("unchecked")
public class CatcafeDao extends AbstractDao {

	/**検索結果(null)**/
	public List<Object[]> catcafeList() {

		List<Object[]> resultTable = null;

		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{c.*} FROM catarea a, catcafe c";
		String where1 = "WHERE a.ID = c.prefectureID";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("a", Catarea.class)
					.addEntity("c", Catcafe.class)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}

		session.getTransaction().commit();
		return resultTable;
	}

	/**検索結果(条件あり)**/
	public List<Object[]> resultList(String prefectureID, String station, String catcafeName) {
		List<Object[]> resultTable = null;

		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{c.*} FROM catarea a, catcafe c";
		String where1 = "WHERE a.ID = c.prefectureID";
		String where2 = "";

		if (!StringUtils.isEmpty(prefectureID)) {
			where2 += "AND (a.ID LIKE '%" + prefectureID + "%' )";
		}
		if (!StringUtils.isEmpty(station)) {
			where2 += " AND (c.station LIKE '%" + station + "%' )";
		}
		if (!StringUtils.isEmpty(catcafeName)) {
			where2 += " AND (c.catcafeName LIKE '%" + catcafeName + "%' );";
		}

		try {
			resultTable = session.createSQLQuery(select + " " + where1 + " " +  where2)
					.addEntity("a", Catarea.class)
					.addEntity("c", Catcafe.class)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;

	}

	/**追加画面のエリア取得**/
	public List<?> getCatareaList() {
		List<?> resultTable = null;
		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM catarea")
					.addEntity("catarea", Catarea.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/**追加時の接続**/
	public void insert(String ID,
			String prefectureID,
			String station,
			String catcafeName,
			String hours,
			String closed,
			String comment) {
		Session session = this.getCurrentSession();

		session.beginTransaction();
		Catcafe c = new Catcafe();
		c.setID(ID);
		c.setPrefectureID(prefectureID);
		c.setStation(station);
		c.setCatcafeName(catcafeName);
		c.setHours(hours);
		c.setClosed(closed);
		c.setComment(comment);

		try {
			session.save(c);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

	}

	/**削除**/
	public void delete(String delete) {

		String[] strAry = delete.split(",");

		Session session = this.getCurrentSession();

		session.beginTransaction();

		for (int i = 0; i < strAry.length; i++) {
			try {
				Catcafe catcafe = (Catcafe) session.load(Catcafe.class, strAry[i]);
				session.delete(catcafe);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}


}
