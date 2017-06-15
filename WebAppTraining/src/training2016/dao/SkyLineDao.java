package training2016.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.SkyLineAge;
import training2016.model.SkyLineData;

public class SkyLineDao extends AbstractDao {

	// 追加画面
	@SuppressWarnings("unchecked")
	public List<SkyLineData> getSkyLineDataList() {
		// SQLの検索結果変数
		List<SkyLineData> resultTable = null;
		// データベース接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM skyLineData")
					// ResultTableにsql文をいれる
					.addEntity("SkyLineData", SkyLineData.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit(); // close
		return resultTable;
	}

	// 検索結果
	@SuppressWarnings("unchecked")
	// 必要な情報
	public List<SkyLineAge> resultList(String age) {
		List<SkyLineAge> resultTable = null;
		Session session = this.getCurrentSession();
		try {
			// トランザクション
			session.beginTransaction();
			String select = "SELECT {d.*}, {a.*} FROM SkyLineData d, SkyLineAge a";
			String where1 = "WHERE d.ageid = a.id";
			String where2 = "AND (a.age=" + age + ")";

			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql).addEntity("a", SkyLineAge.class).addEntity("d", SkyLineData.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}
	/**
	 * 追加時の接続
	 *
	 */
	public void insert( String id,
                          String ageId,
                          String date,
                          String modele,
                          String nickname) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		SkyLineData a = new SkyLineData();
		// idはオートインクリメントなのでなくて大丈夫

		a.setDate(Integer.parseInt(date));
		a.setModel(modele);
		a.setNickname(nickname);
		a.setAgeId(Integer.parseInt(ageId));

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
	public void update(SkyLineData model) {
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

	/**
	 * IDをキーにして削除対象のレコードを取得する
	 *
	 * @param deleteId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SkyLineData> selectForDelete(String[] deleteId) {
		List<SkyLineData> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {d.*}, {a.*} FROM SkyLineData d, SkyLineAge a";
		String where1 = "WHERE d.ageid = a.id";
		String where2 ="AND d.id in (";
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += ",";
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql).addEntity("d", SkyLineData.class).addEntity("a", SkyLineAge.class).list();
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
				SkyLineData data = (SkyLineData) session.load(SkyLineData.class, Integer.parseInt(strAry[i].trim()));
				session.delete(data);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}

}
