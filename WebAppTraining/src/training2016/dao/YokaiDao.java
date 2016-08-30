package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Yokai;
import training2016.model.Yokaifrom;
public class YokaiDao extends AbstractDao {

	/*
	 * 追加画面の生息地取得
	 */

	@SuppressWarnings("unchecked")
	public List<Yokaifrom> getYokaifromList() {
		// SQLの検索結果変数
		List<Yokaifrom> resultTable = null;
		// データベース接続
		Session session = this.getCurrentSession();//abstractにあるデータベースの接続
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM Yokaifrom")//creatrSQLQ
					// ResultTableにsql文をいれる
					.addEntity("Yokaifrom", Yokaifrom.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit(); // close
		return resultTable;
	}

	/*
	 * 検索結果(null)
	 */
	@SuppressWarnings("unchecked")
	public List<Yokai> YokaiList() {
		List<Yokai> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM yokai a, yokaifrom aa";
		String where1 = "WHERE a.yokaifromId = aa.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("a", Yokai.class).addEntity("aa", Yokaifrom.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/*
	 * 検索結果(条件あり)
	 */
	@SuppressWarnings("unchecked")
	public List<Yokai> resultList(String yokaifromId, String name, String type) {
		List<Yokai> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {a.*},{aa.*} FROM Yokai a, Yokaifrom aa";
			String where1 = "WHERE a.yokaifromId = aa.id";
			String where2 = "";

			if (!StringUtils.isEmpty(yokaifromId)) {
				where2 += "AND (aa.id = " + yokaifromId + " )";
			}
			if (!StringUtils.isEmpty(name)) {
				where2 += "AND (a.name LIKE '%" + name + "%' )";
			}
			if (!StringUtils.isEmpty(type)) {
				where2 += "AND (a.type LIKE '%" + type + "%' )";
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql).addEntity("a", Yokai.class).addEntity("aa", Yokaifrom.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/*
	 * IDをキーにして削除対象のレコードを取得する
	 *
	 * @param deleteId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Yokai> selectForDelete(String[] deleteId) {
		List<Yokai> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Yokai a, Yokaifrom aa";
		String where1 = "WHERE a.yokaifromId = aa.id";
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
			resultList = session.createSQLQuery(sql).addEntity("a", Yokai.class).addEntity("aa", Yokaifrom.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		return resultList;
	}


	/*
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
				Yokai yokai = (Yokai) session.load(Yokai.class, Integer.parseInt(strAry[i].trim()));
				session.delete(yokai);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}

	/*
	 * 追加時の接続
	 *
	 */

	public void insert(String id, String yokaifromId, String name, String type, String comment , String link) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		Yokai a = new Yokai();
		a.setYokaifromId(Integer.parseInt(yokaifromId));
		a.setName(name);
		a.setType(type);
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

	/*
	 * 更新時の接続
	 * @param model
	 */

	public void update(Yokai model) {

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
