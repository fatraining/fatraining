package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Country;
import training2016.model.Ships;

public class ShipDao extends AbstractDao {
	/*検索結果の表示  nullの場合 */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Ships> resultList() {
		// 検索結果用の変数
		List<Ships> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();				//DBとのマッピング
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();
		//テーブルの結合
		String select = "SELECT {o.*},{p.*} FROM country o, ship p";	//2つのテーブルの結合
		String where1 = "WHERE o.ID = p.countryID";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("o",Country.class).addEntity("p", Ships.class)
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
	public List<Ships> resultList(String countryID, String shipName, String shipClass) {
		// SQLの検索結果用の変数
		List<Ships> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			String select = "SELECT {o.*},{p.*} FROM country o, ship p";
			String where1 = "WHERE o.ID = p.countryID";         		//shipとcountryのテーブル結合
			String where2 = "";
			if (!StringUtils.isEmpty(countryID)) {																	//空じゃなかった場合に当てはまったモノを入れる
				where2 += " AND (o.ID =" +  countryID + ")";
			}
			if (!StringUtils.isEmpty(shipName)) {
				where2 += " AND (p.shipname LIKE '%" + shipName + "%' )";
			}
			if (!StringUtils.isEmpty(shipClass)) {
				where2 += " AND (p.shipClass LIKE '%" + shipClass + "%')";
			}
			resultTable = session.createSQLQuery(select + " " + where1 + " " + where2).addEntity("o", Country.class)
					.addEntity("p", Ships.class).list();
		} catch (Exception e) {

			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	//検索画面の国名リスト取得 //
	/*------------------------------------------------------*/
	public List<?> getCountryList() {
		// SQLの検索結果用の変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM country")
					// Resultテーブルにsql文を代入する。
					.addEntity("country", Country.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

//	//追加時の接続 (使ってない・・・)//
//	/*------------------------------------------------------*/
//	public void insert(String playerID ,String teamID, String playerName, String position, int age, String comment) {
//		// データベースに接続
//		Session session = this.getCurrentSession();
//
//		// トランザクションを開始
//		session.beginTransaction();
//		Ships s = new Ships();
//		s.setShipID(shipID);
//		s.setShipName(shipName);
//		s.setCountryID(countryID);
//		s.setYear(year);
//		s.setShipClass(shipClass);
//		s.setComment(comment);
//
//		try {
//			session.save(p);
//
//		} catch (HibernateException e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		// トランザクションの終了
//		session.getTransaction().commit();
//	}


	//解体時の接続 //
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
				Ships ship = (Ships) session.load(Ships.class,strAry[i]);
				session.delete(ship);

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
