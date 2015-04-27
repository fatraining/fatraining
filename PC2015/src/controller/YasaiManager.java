package controller;

import java.util.List;

import model.Yasai;
import model.Ryouri;

import org.hibernate.classic.Session;

public class YasaiManager extends HibernateUtil {

	//三つのメソッドで使用するため、フィールドで宣言
	private List<?> resultTable;

	public List<?> resultList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 野菜と料理テーブルを全件検索
		String select = "SELECT * FROM yasai y,ryouri r";
		// 野菜テーブルの調理idと料理テーブルのidが一緒という条件
		String where1 = "WHERE y.tyouriId=r.id";
		// select文とwhere文あわせたものをsqlに代入
		String sql = select + " " + where1;

		try {
			// 条件の結果がresultTableに代入される
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
			// 野菜の文字列を検索
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

	//
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

		return (Ryouri) resultTable.get(resultTable.size() - 1);
	}

}