package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Sneakers;
import training2016.model.SneakersMaker;

public class SneakersDao extends AbstractDao {

	/** 追加画面のエリア取得 */

	@SuppressWarnings("unchecked")
	public List<SneakersMaker> getSneakersMakerList() {
		// SQLの検索結果用の変数
		List<SneakersMaker> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();
		try {
			// トランザクション(複数の処理を連結した処理)の開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM SneakersMaker")
					// ResultTableにsql文をいれる
					.addEntity("SneakersMaker", SneakersMaker.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit(); // close
		return resultTable;
	}


	/** 検索結果(nullの場合) */
	@SuppressWarnings("unchecked")
	public List<Sneakers> sneakersList() {
		List<Sneakers> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();
		String select = "SELECT {a.*},{aa.*} FROM Sneakers a, SneakersMaker aa";
		String where1 = "WHERE a.sneakersMakerId = aa.id";
		String sql = select + " " + where1;
		try {
			resultTable = session.createSQLQuery(sql).addEntity("a", Sneakers.class)
					.addEntity("aa", SneakersMaker.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}



	/** 検索結果(条件あり) */
	@SuppressWarnings("unchecked")
	public List<Sneakers> resultList(String sneakersMakerId, String series, String year) {
		List<Sneakers> resultTable = null;
		Session session = this.getCurrentSession();
		try {
			session.beginTransaction();
			String select = "SELECT {a.*},{aa.*} FROM Sneakers a, Sneakersmaker aa";
			String where1 = "WHERE a.sneakersMakerId = aa.id";
			String where2 = "";
			if (!StringUtils.isEmpty(sneakersMakerId)) {
				where2 += "AND (aa.id = " + sneakersMakerId + " )";
			}
			if (!StringUtils.isEmpty(series)) {
				where2 += "AND (a.series LIKE '%" + series + "%' )";
			}
			if (!StringUtils.isEmpty(year)) {
				where2 += "AND (a.year LIKE '%" + year + "%' )";
			}
			String sql = select + " " + where1 + " " + where2;
			resultTable = session.createSQLQuery(sql)
					.addEntity("a", Sneakers.class)
					.addEntity("aa", SneakersMaker.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}



	/** IDをキーにして削除対象のレコードを取得する
	 * @param deleteId
	 * @return resultList */
	@SuppressWarnings("unchecked")
	public List<Sneakers> selectForDelete(String[] deleteId) {
		List<Sneakers> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Sneakers a, Sneakersmaker aa";
		String where1 = "WHERE a.sneakersMakerId = aa.id";
		String where2 = "AND a.id in (";
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += " , "; // 2個目からカンマ区切りにする
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;
		try {
			resultList = session.createSQLQuery(sql).addEntity("a", Sneakers.class).addEntity("aa", SneakersMaker.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultList;
	}



	/** 削除時の接続 */
	public void delete(String delete) {
		// 文字列を分割する
		String[] strAry = delete.split(",");
		Session session = this.getCurrentSession();
		session.beginTransaction();
		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {
			try {
				// load = 主キーの検索
				Sneakers sneakers = (Sneakers) session.load(Sneakers.class, Integer.parseInt(strAry[i].trim()));
				session.delete(sneakers);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}



	/** 追加時の接続 */
	public void insert(String id, String sneakersMakerId, String name, String series, String year,
			String comment, String image) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		Sneakers a = new Sneakers();
		/** idはオートインクリメントなので不要 */
		a.setSneakersMakerId(Integer.parseInt(sneakersMakerId));
		a.setName(name);
		a.setSeries(series);
		a.setYear(year);
		a.setComment(comment);
		a.setImage(image);
		try {
			session.save(a);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}



	/** 更新時の接続
	 * @param model */
	public void update(Sneakers model) {
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