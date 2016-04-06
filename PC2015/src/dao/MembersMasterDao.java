package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.classic.Session;

import model.MemberInfo;
import model.MembersMaster;

public class MembersMasterDao extends HibernateUtil {

	/**
	 * 会員ID と パスワードに一致する会員を検索
	 * @param memberId
	 * @param password
	 * @return
	 */
	public List<?> memberSelect(String memberId, String password) {

		// 検索結果用の変数
		List<?> resultTable = null;
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		// SQL文
		String select = "SELECT * FROM members_master ";
		String where1 = "WHERE MemberID = '" + memberId.replace("'", "''").trim() + "' "
						+ "AND Password = '" + password.replace("'", "''").trim() + "' "
						+ "AND DeleteFlag = '0'";

		String sql = select + where1;

		try {
			resultTable = session.createSQLQuery(sql)
							// Resultテーブルにsql文を代入する。
							.addEntity("members_master", MembersMaster.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	/**
	 * 会員ID に一致する会員を検索
	 * @param memberId
	 * @param password
	 * @return
	 */
	public List<?> memberIdSelect(String memberId) {

		// 検索結果用の変数
		List<?> resultTable = null;
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		// SQL文
		String select = "SELECT * FROM members_master ";
		String where1 = "WHERE MemberID = '" + memberId.replace("'", "''").trim() + "' "
						+ "AND DeleteFlag = '0'";

		String sql = select + where1;

		try {
			resultTable = session.createSQLQuery(sql)
							// Resultテーブルにsql文を代入する。
							.addEntity("members_master", MembersMaster.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	/**
	 * 顧客を登録
	 * （同時に顧客情報の登録も行う）
	 * @param membersMaster
	 * @param memberInfo
	 */
	public void insert(MembersMaster membersMaster, MemberInfo memberInfo) {
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		try {
			// 顧客登録
			session.save(membersMaster);
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// 顧客情報テーブルの登録も同時に行う
		MemberInfoDao infoDao = new MemberInfoDao();
		if (!infoDao.insert(session, memberInfo)) {
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
	}

	/**
	 * パスワードの更新
	 * @param membersMaster
	 */
	public void updatePassword(MembersMaster membersMaster) {
		Date date = new Date();
		
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();
		
		try {
			// パスワードの更新
			session.update(membersMaster);
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
	}

	/**
	 * 顧客を論理削除
	 * （同時に顧客情報の論理削除も行う）
	 * @param membersMaster
	 * @param memberInfo
	 */
	public void updateDeleteFlag(MembersMaster membersMaster, MemberInfo memberInfo) {
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		try {
			// 顧客論理削除
			session.update(membersMaster);
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// 顧客情報テーブルの論理削除も同時に行う
		MemberInfoDao infoDao = new MemberInfoDao();
		if (!infoDao.updateDeleteFlag(session, memberInfo)) {
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
	}

}
