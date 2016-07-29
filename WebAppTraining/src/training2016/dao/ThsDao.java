package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Ths;
import training2016.model.ThsSubject;

public class ThsDao extends AbstractDao {

	/**
	 *
	 * 追加画面の科目取得
	 */

	@SuppressWarnings("unchecked")
	public List<ThsSubject> getThsSubjectList() {
		// SQLの検索結果変数
		List<ThsSubject> resultTable = null;
		// データベース接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM ThsSubject")
					// ResultTableにsql文をいれる
					.addEntity("ThsSubject", ThsSubject.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit(); // close
		return resultTable;
	}

	/**
	 *
	 * 検索結果(null)
	 */
	@SuppressWarnings("unchecked")
	public List<Ths> thsList() {
		List<Ths> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Ths a, ThsSubject aa";
		String where1 = "WHERE a.thsSubjectId = aa.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("a", Ths.class).addEntity("aa", ThsSubject.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/**
	 *
	 * 検索結果(条件あり)
	 */
	@SuppressWarnings("unchecked")
	public List<Ths> resultList(String thsSubjectId, String name, String level) {
		List<Ths> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {a.*},{aa.*} FROM Ths a, ThsSubject aa";
			String where1 = "WHERE a.thsSubjectId = aa.id";
			String where2 = "";

			if (!StringUtils.isEmpty(thsSubjectId)) {
				where2 += "AND (aa.id = " + thsSubjectId + " )";
			}
			if (!StringUtils.isEmpty(name)) {
				where2 += "AND (a.name LIKE '%" + name + "%' )";
			}
			if (!StringUtils.isEmpty(level)) {
				where2 += "AND (a.level LIKE '%" + level + "%' )";
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql).addEntity("a", Ths.class).addEntity("aa", ThsSubject.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/**
	 * IDをキーにして削除対象のレコードを取得する
	 *
	 * @param deleteId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Ths> selectForDelete(String[] deleteId) {
		List<Ths> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Ths a, ThsSubject aa";
		String where1 = "WHERE a.thsSubjectId = aa.id";
		String where2 = "AND a.id in (";
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += ",";
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql).addEntity("a", Ths.class).addEntity("aa", ThsSubject.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		return resultList;
	}

	/**
	 * 削除時の接続
	 *
	 */
	public void delete(String delete) {
		// 文字列を分割する
		String[] strAry = delete.split(",");

		Session session = this.getCurrentSession();
		session.beginTransaction();

		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {

			try {
				// load = 主キーの検索
				Ths ths = (Ths) session.load(Ths.class, Integer.parseInt(strAry[i].trim()));
				session.delete(ths);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}

	/**
	 * 追加時の接続
	 *
	 */

	public void insert(String id, String thsSubjectId, String name, String level, String comment , String link) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		Ths a = new Ths();
		a.setThsSubjectId(Integer.parseInt(thsSubjectId));
		a.setName(name);
		a.setLevel(level);
		a.setComment(comment);
		a.setLink(link);

		try {
			session.save(a);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	/**
	 * 更新時の接続
	 *
	 * @param model
	 */

	public void update(Ths model) {

		Session session = this.getCurrentSession();
		session.beginTransaction();

		try {
			session.update(model);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

	}

}