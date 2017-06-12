package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.CatFrom;
import training2016.model.CatInfo;

public class CatDao extends AbstractDao {

	/* 検索結果の表示 */
	// nullの場合
	@SuppressWarnings("unchecked")
	public List<CatInfo> resultList() {
		// SQLの検索結果用変数
		List<CatInfo> resultTable = null;
		// データベース接続
		Session session = this.getCurrentSession();
		// トランザクション（複数の処理を連結した処理）開始
		session.beginTransaction();
		String select = "SELECT {f.*}, {i.*} FROM catfrom f, catinfo i";
		String where1 = "WHERE f.id = i.fromId";
		String sql = select + " " + where1;
		try {
			resultTable = session.createSQLQuery(sql).addEntity("f", CatFrom.class).addEntity("i", CatInfo.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		// トランザクション終了
		session.getTransaction().commit();
		return resultTable;
	}

	// 条件ありの場合
	@SuppressWarnings("unchecked")
	public List<CatInfo> resultList(String fromId) {
		List<CatInfo> resultTable = null;
		Session session = this.getCurrentSession();
		try {
			session.beginTransaction();
			String select = "SELECT {f.*}, {i.*} FROM catfrom f, catinfo i";
			String where1 = "WHERE f.id = i.fromId";
			String where2 = "";
			if (!StringUtils.isEmpty(fromId)) {
				where2 += "AND (i.fromId = " + fromId + ")";
			}
			resultTable = session.createSQLQuery(select + " " + where1 + " " + where2).addEntity("f", CatFrom.class)
					.addEntity("i", CatInfo.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/* 追加画面の原産国リスト取得 */
	public List<CatFrom> getCatFromList() {
		List<CatFrom> resultTable = null;
		Session session = this.getCurrentSession();
		try {
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM catfrom").addEntity("catfrom", CatFrom.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/* 追加時の接続 */
	public void insert(String id, String fromId, String name, String comment) {
		Session session = this.getCurrentSession();
		session.beginTransaction();
		CatInfo info = new CatInfo();
		info.setFromId(Integer.parseInt(fromId));
		info.setName(name);
		info.setComment(comment);
		try {
			session.save(info);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	/* 更新時の接続 */
	public void update(CatInfo model) {
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

	/* IDをキーにして削除対象のレコードを取得する */
	@SuppressWarnings("unchecked")
	public List<CatInfo> selectForDelete(String[] deleteId) {
		List<CatInfo> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();
		String select = "SELECT {i.*},{f.*} FROM catinfo i, catfrom f";
		String where1 = "WHERE i.fromId = f.id";
		String where2 = "AND i.id in (";
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += ",";
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;
		try {
			resultList = session.createSQLQuery(sql).addEntity("i", CatInfo.class).addEntity("f", CatFrom.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultList;
	}

	/* 削除時の接続 */
	public void delete(String deleteId) {
		//文字列を分割する
		String[] strAry = deleteId.split(", ");
		Session session = this.getCurrentSession();
		session.beginTransaction();
		//for文で処理を繰り返す
		for(int i = 0; i < strAry.length; i++) {
			try {
				//load = 主キーの検索
				CatInfo info = (CatInfo)session.load(CatInfo.class, Integer.parseInt(strAry[i]));
				session.delete(info);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}

}