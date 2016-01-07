package dao;

import org.hibernate.classic.Session;

import model.Section;
import model.Users;

/**
 * usersテーブル操作用クラス
 * @author miyamoto
 *
 */
public class FacloudUsersDao extends HibernateUtil {

	/**
	 * 引数のemailと一致するレコードをusersテーブルから取得します。
	 * 
	 * @param email 入力されたemail
	 * @return usersData 一致したレコードをUsersインスタンスに保持したもの
	 */
	public Users findUsers(String email) {
		
		Users usersData = new Users();
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			
			// SQL文の作成
			String select = "SELECT * FROM users";
			String where = "WHERE email = '" + email + "'";
			String sql = select + " " + where;
					
			usersData = (Users) session.createSQLQuery(sql)
					.addEntity("users", Users.class).uniqueResult();
			/* ここまでdao */
			
			// トランザクション終了
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return usersData;
	}

}
