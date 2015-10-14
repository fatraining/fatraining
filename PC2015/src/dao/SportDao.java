package dao;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import model.Sport_Event;
import model.Registration_Name;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

public class SportDao extends HibernateUtil {

	public List<?> resultList() {

		//検索結果用の変数
		List<?> resultTable = null;
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		// SQL文
		String select = "SELECT * FROM registration_name r, sport_event s";
		String where1 = "WHERE r.competition_number = s.competition_number";
		String sql = select + " " + where1;
		try {
			resultTable = session.createSQLQuery(sql)
					// Resultテーブルにsql文を代入する。
					.addEntity("Registration_Name", Registration_Name.class)
					.addEntity("Sport_Event", Sport_Event.class).list();
					
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
	public List<?> resultList(String competition_number, String registration_number, String name, String sport) {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			
			if (StringUtils.isEmpty(competition_number)) {
				competition_number = "%";
			}
			if (StringUtils.isEmpty(sport)) {
				sport = "%";
			}
			if (StringUtils.isEmpty(registration_number)) {
				registration_number = "%";
			}
			if (StringUtils.isEmpty(name)) {
				name = "%";
			}
			// トランザクションを開始
			session.beginTransaction();

			String select = "SELECT * FROM registration_name r,sport_event s";// テーブルを選択する。
			String where1 = "WHERE r.competition_number = s.competition_number";
			String where2 = "AND (r.registration_number LIKE '" + registration_number
					+ "' AND s.competition_number LIKE '" + competition_number + "'AND r.name LIKE '" + name + "'AND s.sport LIKE '" + sport + "')";

			// select文とwhere文をsqlに代入(結合)する。
			String sql = select + " " + where1 + " " + where2;
			
			resultTable = session.createSQLQuery(sql)
					// Resultテーブルにsql文を代入する。
					.addEntity("Registration_Name", Registration_Name.class)
					.addEntity("Sport_Event", Sport_Event.class).list();
					
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	// sport_eventの検索用メソッド
	public Sport_Event sport_eventList() {
		// SQLの検索結果用の変数
		List<?> resultTable = null;

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();

		try {

			// sport_eventを全件検索して昇順化させる
			String sql = "SELECT * FROM competition_number r ORDER BY sport_event s";
			resultTable = session.createSQLQuery(sql)
					.addEntity("Sport_Event", Sport_Event.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return (Sport_Event) resultTable.get(resultTable.size() - 1);
	}

	// insertメソッド
	public void insert(String competition_number, String registration_number, String sport, String name,
			String registered_person,String update_by) {
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();
		// 日時を取得
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");

		// registration_nameデータの作成
		Registration_Name insert_registration_name_table = new Registration_Name();

		insert_registration_name_table.setRegistration_number(registration_number);
		insert_registration_name_table.setName(name);
		insert_registration_name_table.setCompetition_number(competition_number);
		insert_registration_name_table.setE_flag(0);
		insert_registration_name_table.setD_flag(0);
		try {
			session.save(insert_registration_name_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了
		session.getTransaction().commit();
	}

	// deleteメソッド
	public void delete(String delete_id) {
		

		if (StringUtils.isEmpty(delete_id)) {
		}
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
//				Sport_Event sport_event = (Sport_Event) session.load(Sport_Event.class, Integer.parseInt(strAry[i]));
				Registration_Name registration_name = (Registration_Name) session.load(Registration_Name.class, Integer.parseInt(strAry[i].trim())) ;
				
				// 削除
//				session.delete(sport_event);
				session.delete(registration_name);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}
}
