package controller;

import java.util.ArrayList;
import java.util.List;

import model.Result8Table;
import model.Yasai;
import model.Ryouri;

import org.hibernate.classic.Session;

import action.Main8Action;

public class YasaiManager extends HibernateUtil {

	// アクセス修飾子変える（public→private）
	public List<?> resultTable;
	public ArrayList<Result8Table> outputTable;

	// 引数いらない
	public List<?> resultList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT * FROM yasai y,ryouri r";
		String where1 = "WHERE y.tyouriId=r.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("Yasai", Yasai.class)
					.addEntity("Ryouri", Ryouri.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		// this.outputTable = tableTrans(resultTable);

		return resultTable;
	}

	public List<?> resultList(String yasai) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {

			String select = "SELECT * FROM yasai y,ryouri r";
			String where1 = "WHERE y.tyouriId=r.id";
			String where2 = "AND y.yasai LIKE '" + yasai + "'";
			String sql = select + " " + where1 + " " + where2;
			resultTable = session.createSQLQuery(sql)
					.addEntity("Yasai", Yasai.class)
					.addEntity("Ryouri", Ryouri.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return resultTable;
	}

	public Ryouri ryouriList() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			// 料理テーブルの全件検索
			String sql = "SELECT * FROM ryouri r";
			resultTable = session.createSQLQuery(sql)
					.addEntity("Ryouri", Ryouri.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return (Ryouri)resultTable.get(resultTable.size()-1);
	}

}