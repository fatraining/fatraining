package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Beerbrands;
import training2016.model.Birthplace;

@SuppressWarnings("unchecked")
public class BeerbrandsDao extends AbstractDao {

	/**検索結果(null)**/
	public List<Object[]> beerbrandsList() {

		List<Object[]> resultTable = null;

		Session session = this.getCurrentSession();
		session.beginTransaction();
		//結合
		String select = "SELECT {a.*},{c.*} FROM birthplace a, beerbrands c";
		String where1 = "WHERE a.ID = c.countryID";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("a", Birthplace.class)
					.addEntity("c", Beerbrands.class)
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
	public List<Object[]> resultList(String countryID,String beerbrands, String categories) {
		List<Object[]> resultTable = null;

		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{c.*} FROM birthplace a, beerbrands c";
		String where1 = "WHERE a.ID = c.countryID";
		String where2 = "";

		if (!StringUtils.isEmpty(countryID)) {
			where2 += "AND (a.ID = " + countryID +" )";
		}
		if (!StringUtils.isEmpty(beerbrands)) {
			where2 += " AND (c.beerbrands LIKE '%" + beerbrands + "%' )";
		}
		if (!StringUtils.isEmpty(categories)) {
			where2 += " AND (c.categories LIKE '%" + categories + "%' )";
		}

		try {
			resultTable = session.createSQLQuery(select + " " + where1 + " " +  where2)
					.addEntity("a", Birthplace.class)
					.addEntity("c", Beerbrands.class)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;

	}

	/**追加画面のエリア取得**/
	public List<?> getBirthplaceList() {
		List<?> resultTable = null;
		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM birthplace")
					.addEntity("birthplace", Birthplace.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/**追加時の接続**/
	public void insert(
			String ID,
			String countryID,
			String beerbrands,
			String categories,
			String comment) {
		Session session = this.getCurrentSession();

		session.beginTransaction();
		Beerbrands c = new Beerbrands();
		c.setID(ID);
		c.setCountryID(countryID);
		c.setBeerbrands(beerbrands);
		c.setCategories(categories);
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
				Beerbrands beerbrands = (Beerbrands) session.load(Beerbrands.class, strAry[i]);
				session.delete(beerbrands);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}

}
