package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Onsen;
import training2016.model.OnsenArea;

public class OnsenDao extends AbstractDao {

	/**
	 *
	 * 追加画面のエリア取得
	 */

	@SuppressWarnings("unchecked")
	public List<OnsenArea> getOnsenAreaList() {
		// SQLの検索結果変数
		List<OnsenArea> resultTable = null;
		// データベース接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM OnsenArea")
					// ResultTableにsql文をいれる
					.addEntity("OnsenArea", OnsenArea.class).list();
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
	public List<Onsen> onsenList() {
		List<Onsen> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Onsen a, OnsenArea aa";
		String where1 = "WHERE a.onsenAreaId = aa.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("a", Onsen.class).addEntity("aa", OnsenArea.class)
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
	public List<Onsen> resultList(String onsenAreaId, String name) {
		List<Onsen> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {a.*},{aa.*} FROM Onsen a, OnsenArea aa";
			String where1 = "WHERE a.onsenAreaId = aa.id";
			String where2 = "";

			if (!StringUtils.isEmpty(onsenAreaId)) {
				where2 += "AND (aa.id = " + onsenAreaId + " )"; // LIKEじゃないほうがいいよ
			}
			if (!StringUtils.isEmpty(name)) {
				where2 += "AND (a.name LIKE '%" + name + "%' )";
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql).addEntity("a", Onsen.class).addEntity("aa", OnsenArea.class)
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
	 * @return resultList
	 */
	@SuppressWarnings("unchecked")
	public List<Onsen> selectForDelete(String[] deleteId) {
		List<Onsen> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Onsen a, OnsenArea aa";
		String where1 = "WHERE a.onsenAreaId = aa.id";
		String where2 = "AND a.id in ("; // ANDが抜けてた
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += " , "; // 2個目からカンマ区切りにするｓ
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql).addEntity("a", Onsen.class).addEntity("aa", OnsenArea.class)
					.list();
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
				Onsen onsen = (Onsen) session.load(Onsen.class, Integer.parseInt(strAry[i].trim()));
				session.delete(onsen);
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

	public void insert(String id, String onsenAreaId, String name, String effect, String comment, String link) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		Onsen a = new Onsen();
		// idはオートインクリメントなのでなくて大丈夫
		a.setOnsenAreaId(Integer.parseInt(onsenAreaId));
		a.setName(name);
		a.setEffect(effect);
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

	public void update(Onsen model) {
		// this.apply(model, (s, m) -> {s.update(m);});

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
