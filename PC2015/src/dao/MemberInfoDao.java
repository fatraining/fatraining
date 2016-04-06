package dao;

import java.util.List;

import org.hibernate.classic.Session;

import model.MemberInfo;
import model.MembersMaster;

public class MemberInfoDao extends HibernateUtil {

	/**
	 * 会員ID に一致する会員情報を検索
	 * @param memberId
	 * @return
	 */
	public List<?> memberInfoSelect(String memberId) {

		// 検索結果用の変数
		List<?> resultTable = null;
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		// SQL文
		String select = "SELECT {i.*} FROM member_info i, members_master m ";
		String where1 = "WHERE i.MemberID = '" + memberId.replace("'", "''") + "' "
						+ "AND i.SequenceNo = m.SequenceNo "
						+ "AND i.MemberID = m.MemberID "
						+ "AND i.DeleteFlag = '0' "
						+ "AND m.DeleteFlag = '0' ";
		String sql = select + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					// Resultテーブルにsql文を代入する。
					.addEntity("i", MemberInfo.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	/**
	 * 顧客情報登録
	 * （顧客マスタと併せて登録）
	 * @param session
	 * @param memberInfo
	 */
	public boolean insert(Session session, MemberInfo memberInfo) {

		try {
			// 顧客情報登録
			session.save(memberInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * 顧客情報の論理削除
	 * （顧客マスタと併せて論理削除）
	 * @param session
	 * @param memberInfo
	 */
	public boolean updateDeleteFlag(Session session, MemberInfo memberInfo) {

		try {
			// 顧客情報の論理削除
			session.update(memberInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * 顧客情報の更新
	 * @param memberInfo
	 */
	public void update(MemberInfo memberInfo) {
		// DB(データベース)への接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		try {
			// 顧客情報の更新
			session.update(memberInfo);
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
	}
}
