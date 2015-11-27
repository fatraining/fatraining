package dao;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import model.GameTitle;
import model.GameCompany;

public class GameDao extends HibernateUtil {

	public List<?> resultList() {

		//検索結果用の変数
		List<?> resultTable = null;
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		// SQL文
		String select = "SELECT {t.*},{c.*} FROM gametitle t, gamecompany c";
		String where1 = "WHERE t.CompanyID = c.ID";
		String sql = select + " " + where1;
		try {
			resultTable = session.createSQLQuery(sql)
					// Resultテーブルにsql文を代入する。
					.addEntity("c", GameCompany.class)
					.addEntity("t", GameTitle.class).list();
					
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		
		return resultTable;

	}

//　条件指定の検索
	// resultListメソッド
	public List<?> resultList(String Name, String Genre, String Hardware) {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			
			if (StringUtils.isEmpty(Name)) {
				Name = "%";
			}
			if (StringUtils.isEmpty(Genre)) {
				Genre = "%";
			}
			if (StringUtils.isEmpty(Hardware)) {
				Hardware = "%";
			}

			// トランザクションを開始
			session.beginTransaction();

			String select = "SELECT {t.*}, {c.*} FROM gametitle t,gamecompany c";// テーブルを選択する。
			String where1 = "WHERE t.CompanyID = c.ID";
			String where2 = "AND (t.Name LIKE '" + Name
					+ "' AND t.Genre LIKE '" + Genre + "' AND t.Hardware LIKE '" + Hardware + "')";

			// select文とwhere文をsqlに代入(結合)する。
			String sql = select + " " + where1 + " " + where2;
			
			resultTable = session.createSQLQuery(sql)
					// Resultテーブルにsql文を代入する。
					.addEntity("c", GameCompany.class)
					.addEntity("t", GameTitle.class).list();
					
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}
	
	//Companiesの取得
	public List<?> CompanyList() {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM gamecompany")
					// Resultテーブルにsql文を代入する。
					.addEntity("GameCompany", GameCompany.class).list();
					
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}
	
	// insertメソッド
	public void insert(String Name, int CompanyID, String Genre, String Hardware, String Comment, String RegisteredUserID ) {
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();

		// registration_nameデータの作成
		GameTitle gametitle = new GameTitle();

		gametitle.setName(Name);
		gametitle.setCompanyID(CompanyID);
		gametitle.setGenre(Genre);
		gametitle.setHardware(Hardware);
		gametitle.setComment(Comment);
		gametitle.setRegisteredUserID(RegisteredUserID);

		try {
			session.save(gametitle);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		// トランザクションの終了
		session.getTransaction().commit();
	}

	// deleteメソッド
	public void delete(String delete_id) {
		
		// 分割
		String[] strAry = delete_id.split(",");
		
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();

		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {

			try {
				// load = 主キーの検索
				GameTitle gametitile = (GameTitle) session.load(GameTitle.class, Integer.parseInt(strAry[i].trim())) ;
				
				// 削除
				session.delete(gametitile);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}
	
}
