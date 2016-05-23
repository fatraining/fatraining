package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.BaseballPlayer;
import training2016.model.BaseballTeam;

/*検索結果の表示  nullの場合 */
/*------------------------------------------------------*/
@SuppressWarnings("unchecked")
public class BaseballDao extends AbstractDao {
	public List<Object[]> BaseballPlayerList() {

		// 検索結果用の変数
		List<Object[]> resultTable = null;

		// DB接続
		Session session = this.getCurrentSession();

		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		String select = "SELECT {a.*},{c.*} FROM baseballteam a, baseballplayer c";
		String where1 = "WHERE a.ID = c.teamID";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("a", BaseballTeam.class)
					.addEntity("c", BaseballPlayer.class)
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
	public List<Object[]> resultList(String teamID, String baseballPlayer, String comment, String target, String date, String note) {

		// SQLの検索結果用の変数
		List<Object[]> resultTable = null;

		// DB接続
		Session session = this.getCurrentSession();

		try {
			// トランザクションを開始
			session.beginTransaction();
			String select = "SELECT {a.*},{c.*} FROM baseballteam a, baseballplayer c";
			String where1 = "WHERE a.ID = c.teamID";
			String where2 = "";
			if (!StringUtils.isEmpty(teamID)) {
				where2 += " AND (a.ID = "  + teamID + ")";
			}
			if (!StringUtils.isEmpty(baseballPlayer)) {
				where2 += " AND (c.baseballplayer LIKE '%" + baseballPlayer + "%' )";
			}
			if (!StringUtils.isEmpty(comment)) {
				where2 += " AND (c.comment LIKE '%" + comment + "%' )";
			}
			if (!StringUtils.isEmpty(target)) {
				where2 += " AND (c.target LIKE '%" + target + "%' )";
			}
			if (!StringUtils.isEmpty(date)) {
				where2 += " AND (c.date LIKE '%" + date + "%' )";
			}
			if (!StringUtils.isEmpty(note)) {
				where2 += " AND (c.note LIKE '%" + note + "%' )";
			}
			resultTable = session.createSQLQuery(select + " " + where1 + " " +  where2)
					.addEntity("a", BaseballTeam.class)
					.addEntity("c", BaseballPlayer.class)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;

	}

	//追加画面のチームリスト取得 //
	/*------------------------------------------------------*/
	public List<?> getBaseballTeamList() {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = this.getCurrentSession();

		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM baseballteam")
					// Resultテーブルにsql文を代入する
					.addEntity("baseballteam", BaseballTeam.class)
					.list();

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
	public void insert(String ID,
			String teamID,
			String baseballPlayer,
			String comment,
			String target,
			String date,
			String note) {

		// データベースに接続
		Session session = this.getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();
		BaseballPlayer c = new BaseballPlayer();
		c.setID(ID);
		c.setTeamID(teamID);
		c.setBaseballPlayer(baseballPlayer);
		c.setComment(comment);
		c.setTarget(target);
		c.setDate(date);
		c.setNote(note);

		try {
			session.save(c);
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

		session.beginTransaction();

		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {

			try {
				// load = 主キーの検索
				BaseballPlayer baseballplayer = (BaseballPlayer) session.load(BaseballPlayer.class, strAry[i]);
				session.delete(baseballplayer);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}


}
