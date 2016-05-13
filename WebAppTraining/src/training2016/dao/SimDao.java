package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Sim;
import training2016.model.SimOpe;

public class SimDao extends AbstractDao {

	/*検索結果の表示  nullの場合 */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Sim> resultList() {
		// 検索結果用の変数
		List<Sim> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		String select = "SELECT {o.*},{s.*} FROM SimOpe o, Sim s";
		String where1 = "WHERE o.ID = s.simOpeID";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("o", SimOpe.class).addEntity("s", Sim.class)
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
	public List<Sim> resultList(String simService, String charge, String GB,String simOpeID) {
		// SQLの検索結果用の変数
		List<Sim> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			String select = "SELECT {o.*},{s.*} FROM SimOpe o, Sim s";
			String where1 = "WHERE o.ID = s.simOpeID";
			String where2 = "";
			if (!StringUtils.isEmpty(simOpeID)) {
				where2 += "AND (o.ID = " + simOpeID + " )";
			}
			if (!StringUtils.isEmpty(simService)) {
				where2 += " AND (s.simService LIKE '%" + simService + "%' )";
			}
			if (!StringUtils.isEmpty(charge)) {
				where2 += " AND (s.charge LIKE '%" + charge + "%' )";
			}
			if (!StringUtils.isEmpty(GB)) {
				where2 += " AND (s.GB LIKE '%" + GB + "%' )";
			}

			resultTable = session.createSQLQuery(select + " " + where1 + " " + where2).addEntity("o", SimOpe.class)
					.addEntity("s", Sim.class).list();
		} catch (Exception e) {

			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	//追加画面の事業者リスト取得 //
	/*------------------------------------------------------*/
	public List<?> getSimOpeNameList() {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM simOpe")
					// Resultテーブルにsql文を代入する。
					.addEntity("simOpe", SimOpe.class).list();

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
	public void insert(String ID ,String simService, String charge, String GB, String comment,String simOpeID) {
		// データベースに接続
		Session session = this.getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();
		Sim s = new Sim();
		s.setID(ID);
		s.setSimService(simService);
		s.setCharge(charge);
		s.setGB(GB);
		s.setComment(comment);
		s.setSimOpeID(simOpeID);

		try {
			session.save(s);

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
				Sim sim = (Sim) session.load(Sim.class,strAry[i]);
				session.delete(sim);

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				System.out.println("ハイバネエラ");
			}
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}
}
