package controller;

import java.util.List;

import model.LiofTa;
import model.CoofTa;
import model.Ryouri;

import org.hibernate.classic.Session;

public class LiofTaManager extends HibernateUtil {

	public List<?> resultList() {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT * FROM table_like d,table_color i";
		String where1 = "WHERE d.colorNm=i.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("table_like", LiofTa.class)
					.addEntity("table_color", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback(); // 障害が起こった時にその前の状態まで戻る
		}
		session.getTransaction().commit(); // Transaction処理が成功したとき結果を確立させる

		return resultTable;
	}

	public List<?> resultList(String name, String food, String drink) {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			if (name.isEmpty())
				name = "%";
			if (food.isEmpty())
				food = "%";
			if (drink.isEmpty())
				drink = "%";

			String select = "SELECT * FROM table_like d, table_color i";
			String where1 = "WHERE d.colorNm=i.id";
			String where2 = "AND (d.name LIKE '" + name + "' AND d.food LIKE '"
					+ food + "' AND d.drink LIKE '" + drink + "')";
			String sql = select + " " + where1 + " " + where2;
			resultTable = session.createSQLQuery(sql)
					.addEntity("LiofTa", LiofTa.class)
					.addEntity("CoofTa", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	public CoofTa cooftaList() {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			String sql = "SELECT * FROM  table_color i";
			resultTable = session.createSQLQuery(sql)
					.addEntity("CoofTa", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return (CoofTa) resultTable.get(resultTable.size() - 1);
	}

}