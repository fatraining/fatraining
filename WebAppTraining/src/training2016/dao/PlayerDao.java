package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Players;
import training2016.model.Team;

public class PlayerDao extends AbstractDao {
	/*検索結果の表示  nullの場合 */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Players> resultList() {
		// 検索結果用の変数
		List<Players> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		String select = "SELECT {o.*},{p.*} FROM team o, player p";
		String where1 = "WHERE o.ID = p.teamID";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("o",Team.class).addEntity("p", Players.class)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/*検索結果の表示  条件ありの場合 */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Players> resultList(String teamID, String playerName, String position) {
		// SQLの検索結果用の変数
		List<Players> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			String select = "SELECT {o.*},{p.*} FROM team o, player p";
			String where1 = "WHERE o.ID = p.teamID";
			String where2 = "";
			if (!StringUtils.isEmpty(teamID)) {
				where2 += " AND (o.ID =" +  teamID + ")";
			}
			if (!StringUtils.isEmpty(playerName)) {
				where2 += " AND (p.playername LIKE '%" + playerName + "%' )";
			}
			if (!StringUtils.isEmpty(position)) {
				where2 += " AND (p.position LIKE '%" + position + "%')";
			}
			resultTable = session.createSQLQuery(select + " " + where1 + " " + where2).addEntity("o", Team.class)
					.addEntity("p", Players.class).list();
		} catch (Exception e) {

			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	//検索画面のチーム名リスト取得 //
	/*------------------------------------------------------*/
	public List<?> getTeamList() {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM team")
					// Resultテーブルにsql文を代入する。
					.addEntity("team", Team.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	//追加時の接続//
	/*------------------------------------------------------*/
	public void insert(String playerID ,String teamID, String playerName, String position, int age, String comment) {
		// データベースに接続
		Session session = this.getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();
		Players p = new Players();
		p.setPlayerID(playerID);
		p.setPlayerName(playerName);
		p.setTeamID(teamID);
		p.setAge(age);
		p.setPosition(position);
		p.setComment(comment);

		try {
			session.save(p);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}


	//削除時の接続 //
	/*------------------------------------------------------*/
	public void delete(String delete) {

		// 分割
		String[] strAry = delete.split(",");

		// データベースに接続
		Session session = this.getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();

		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {

			try {
				// load = 主キーの検索
				Players player = (Players) session.load(Players.class,strAry[i]);
				session.delete(player);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				System.out.println("ハイバネエラー");
			}
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}
}
