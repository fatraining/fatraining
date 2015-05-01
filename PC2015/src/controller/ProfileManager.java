package controller;

import java.util.List;

import model.My_hobby;
import model.Profile;

import org.hibernate.classic.Session;

public class ProfileManager extends HibernateUtil {

	public List<?> resultTable;

	public List<?> resultList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT * FROM table_profile i, table_hobby d";
		String where1 = "WHERE i.id = d.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("table_hobby", My_hobby.class)
					.addEntity("table_profile", Profile.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return resultTable;
	}
	public List<?> resultList(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {

			String select = "SELECT * FROM table_profile i, table_hobby d";
			String where1 = "WHERE i.id = d.id";
			String where2 = "AND i.name LIKE '" + name + "'";
			String sql = select + " " + where1 + " " + where2;
			resultTable = session.createSQLQuery(sql)
					.addEntity("My_hobby", My_hobby.class)
					.addEntity("Profile", Profile.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}
}