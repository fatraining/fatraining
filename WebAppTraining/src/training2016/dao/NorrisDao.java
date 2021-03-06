package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Norris;
import training2016.model.NorrisSeries;

public class NorrisDao extends AbstractDao {

	/**
	 *
	 * 追加画面のエリア取得
	 */

	@SuppressWarnings("unchecked")
	public List<NorrisSeries> getNorrisSeriesList() {
		// SQLの検索結果変数
		List<NorrisSeries> resultTable = null;
		// データベース接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始 整合性を保証するために1つの作業単位として処理する概念
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM norrisseries") // SQL実行
					// ResultTableにsql文をいれる
					.addEntity("NorrisSeries", NorrisSeries.class).list(); // 温泉エリアのリストを取得
		} catch (Exception e) {
			e.printStackTrace(); // 例外が投げられた理由を簡単に取得できる
			session.getTransaction().rollback(); // 元のいい状態（エラーのない）に戻す
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
	public List<Norris> norrisList() {
		List<Norris> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Norris a, NorrisSeries aa";
		String where1 = "WHERE a.seriesId = aa.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("a", Norris.class).addEntity("aa", NorrisSeries.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit(); // トランザクションclose
		return resultTable;
	}

	/**
	 *
	 * 検索結果(条件あり)
	 */
	@SuppressWarnings("unchecked")
	public List<Norris> resultList(String seriesId, String name) {
		List<Norris> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {a.*},{aa.*} FROM Norris a, NorrisSeries aa";
			String where1 = "WHERE a.seriesId = aa.id";
			String where2 = "";

			if (!StringUtils.isEmpty(seriesId)) {
				where2 += "AND (aa.id = " + seriesId + " )"; // LIKEじゃないほうがいいよ
			}
			if (!StringUtils.isEmpty(name)) {
				where2 += "AND (a.name LIKE '%" + name + "%' )";
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql).addEntity("a", Norris.class).addEntity("aa", NorrisSeries.class)
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
	public List<Norris> selectForDelete(String[] deleteId) {
		List<Norris> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Norris a, NorrisSeries aa";
		String where1 = "WHERE a.seriesId = aa.id";
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
			resultList = session.createSQLQuery(sql).addEntity("a", Norris.class).addEntity("aa", NorrisSeries.class)
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
				Norris norris = (Norris) session.load(Norris.class, Integer.parseInt(strAry[i].trim()));
				session.delete(norris);
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

	public void insert(String id, String seriesId, String name, String year, String comment) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		Norris a = new Norris();
		// idはオートインクリメントなのでなくて大丈夫
		a.setSeriesId(Integer.parseInt(seriesId));
		a.setName(name);
		a.setYear(year);
		a.setComment(comment);

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

	public void update(Norris model) {
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
