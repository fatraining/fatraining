package controller;

import java.util.List;

import model.Ryouri;
import model.Yasai;

import org.hibernate.classic.Session;

public class YasaiManager extends HibernateUtil {

	// 何も入力されなかったときのメソッド
	public List<?> resultList() {
		List<?> resultTable = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 野菜と料理テーブルを全件検索
		String select = "SELECT * FROM yasai y,ryouri r";

		// 野菜テーブルの調理idと料理テーブルのidが一緒という条件
		String where1 = "WHERE y.tyouriId=r.id";

		// select文とwhere文あわせたものをsqlに代入
		String sql = select + " " + where1;

		try {
			// SQLが実行され、結果がresultTableに代入される
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

	// yasaiが入力された場合のメソッド
	public List<?> resultList(String yasai) {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {

			String select = "SELECT * FROM yasai y,ryouri r";
			String where1 = "WHERE y.tyouriId=r.id";

			// 野菜の文字列を検索(部分一致)
			String where2 = "AND y.yasai LIKE '%" + yasai + "%'";

			// selectとwhere1,where2をつなげたものをsqlに代入
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

	// 料理テーブル検索用のメソッド
	public Ryouri ryouriList() {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			// 料理テーブルの全件検索
			String sql = "SELECT * FROM ryouri r";
			resultTable = session.createSQLQuery(sql)
					//session.createSQLQuery(sql)の戻り値をRyouriクラスに渡している
					.addEntity("Ryouri", Ryouri.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// resultTableの最終行を取得
		// 自分で入力したものを取得したいため、最終行
		return (Ryouri) resultTable.get(resultTable.size() - 1);
	}

}