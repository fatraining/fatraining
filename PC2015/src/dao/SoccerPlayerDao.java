package dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import model.NationalTeam;
import model.NationalTeamPlayer;

public class SoccerPlayerDao {

	public List<?> resultList() {

		//検索結果用の変数
		List<?> resultTable = null;
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		// SQL文
		String select = "SELECT {t.*},{p.*} FROM nationalteam t, nationalteamplayer p";
		String where1 = "WHERE t.id = p.nationalteamid";
		String sql = select + " " + where1;
		try {
			resultTable = session.createSQLQuery(sql)
					// Resultテーブルにsql文を代入する。
					.addEntity("t", NationalTeam.class)
					.addEntity("p", NationalTeamPlayer.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// トランザクション終了
		session.getTransaction().commit();

		return resultTable;

	}

//　条件指定の検索
	// resultListメソッド
	public List<?> resultList(String name, String number) {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {

			if (StringUtils.isEmpty(name)) {
				name = "%";
			}

			// トランザクションを開始
			session.beginTransaction();

			String select = "SELECT {t.*}, {p.*} FROM nationalteam t,nationalteamplayer p";// テーブルを選択する。
			String where1 = "WHERE t.id = p.nationalteamid";
			String where2 = "AND t.name LIKE '%" + name + "%'";
			if (StringUtils.isNotEmpty(number)) {
				where2 += "  AND p.number = " + number;
			}

			// select文とwhere文をsqlに代入(結合)する。
			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql)
					// Resultテーブルにsql文を代入する。
					.addEntity("t",NationalTeam.class)
					.addEntity("p",NationalTeamPlayer.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	//Companiesの取得
	public List<?> getNationalTeamList() {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM nationalTeam")
					// Resultテーブルにsql文を代入する。
					.addEntity("nationalTeam", NationalTeam.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	// insertメソッド
	public void insert(String number, String name, int nationalTeamId, String position, String RegisteredUserID ) {
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();

		// registration_nameデータの作成
		NationalTeamPlayer soccerPlayer = new NationalTeamPlayer();

		soccerPlayer.setNumber(number);
		soccerPlayer.setName(name);
		soccerPlayer.setNationalTeamId(nationalTeamId);
		soccerPlayer.setPosition(position);
		soccerPlayer.setRegisteredUserId(RegisteredUserID);

		try {
			session.save(soccerPlayer);

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
				NationalTeamPlayer soccerPlayer = (NationalTeamPlayer) session.load(NationalTeamPlayer.class, Integer.parseInt(strAry[i].trim())) ;

				// 削除
				session.delete(soccerPlayer);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}

}
