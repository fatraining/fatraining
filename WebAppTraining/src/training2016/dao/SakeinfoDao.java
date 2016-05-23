package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Sakearea;
import training2016.model.Sakeinfo;

public class SakeinfoDao extends AbstractDao {

	/* 検索結果の表示 nullの場合 */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Sakeinfo> resultList() {
		// SQLの検索結果用変数
		List<Sakeinfo> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();
		// トランザクション（複数の処理を連結した処理）の開始
		session.beginTransaction();

		String select = "SELECT {a.*}, {i.*} FROM Sakearea a, Sakeinfo i";
		String where1 = "WHERE a.ID = i.areaId";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("a", Sakearea.class).addEntity("i", Sakeinfo.class)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/* 検索結果の表示 条件ありの場合 */
	/*------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public List<Sakeinfo> resultList(String areaId, String price) {
		// SQLの検索結果用変数
		List<Sakeinfo> resultTable = null;
		// DB接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			String select = "SELECT {a.*}, {i.*} FROM Sakearea a, Sakeinfo i";
			String where1 = "WHERE a.id = i.areaId";
			String where2 = "";
			if (!StringUtils.isEmpty(areaId)) {
				where2 += "AND (a.Id = " + areaId + ")";
			}
			if(!StringUtils.isEmpty(price)) {
				where2 += "AND(i.price LIKE '%" + price + "%')";
			}
			resultTable = session.createSQLQuery(select + " " + where1 + " " + where2).addEntity("a", Sakearea.class)
					.addEntity("i", Sakeinfo.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	// 追加画面のエリアリスト取得 //
	/*------------------------------------------------------*/
	public List<?> getResultList() {
		// SQLの検索結果変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = this.getCurrentSession();
		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM Sakearea")
					// Resultテーブルにsql文を入れる
					.addEntity("sakearea", Sakearea.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションを終了
		session.getTransaction().commit();
		return resultTable;
	}

	// 検索画面のエリアリスト取得 //
	/*------------------------------------------------------*/
	public List<?> getSakeareaList() {
		// SQL検索結果変数
		List<?> resultTable = null;
		// データベースに接続
		Session session = this.getCurrentSession();
		try {
			// トランザクション開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM sakearea") // DBのクラス名を記載する
					// Resultテーブルにsql文を代入
					.addEntity("Sakearea", Sakearea.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	// 追加時の接続//
	/*------------------------------------------------------*/
	public void insert(String id, String areaId, String area, String shopName, String hours, String price, String recommend, String comment) {
		// データベースに接続
		Session session = this.getCurrentSession();
		// トランザクションを開始
		session.beginTransaction();
		Sakeinfo i = new Sakeinfo();
		i.setId(id);
		i.setAreaId(areaId);
		i.setArea(area);
		i.setShopName(shopName);
		i.setHours(hours);
		i.setPrice(price);
		i.setRecommend(recommend);
		i.setComment(comment);

		try {
			session.save(i);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションを終了
		session.getTransaction().commit();
	}

	// 削除時の接続 //
	/*------------------------------------------------------*/
	public void delete(String delete) {
		// 分割
		String[] strAry = delete.split(",");
		// データベースに接続
		Session session = this.getCurrentSession();
		// トランザクション開始
		session.beginTransaction();
		// forで処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {
			try {
				// load = 主キーの検索
				Sakeinfo info = (Sakeinfo) session.load(Sakeinfo.class, strAry[i]);
				session.delete(info);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				System.out.println("削除");
			}
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}
}