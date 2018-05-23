package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.PotatoMaker;
import training2016.model.PotatoProduct;

public class PotatoDao extends AbstractDao {

	@SuppressWarnings("unchecked")
	public List<PotatoMaker> getMakerNameList() {

		List<PotatoMaker> resultTable = null;

		// DB接続
		Session session = this.getCurrentSession();

		try {
			// トランザクション開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM potatomaker ORDER BY id")
					// 要素がPotatoMakerエンティティであるものを返す
					.addEntity("PotatoMaker", PotatoMaker.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクション終了
		session.beginTransaction().commit();
		return resultTable;
	}

	// 検索結果表示
	/*----------------------------------------------
	*/

	/* 条件なし */

	@SuppressWarnings("unchecked")
	public List<PotatoProduct> potatoList() {
		List<PotatoProduct> resultTable = null;
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		String select = "SELECT {pp.*},{pm.*} FROM PotatoProduct pp, PotatoMaker pm";
		String where1 = "WHERE pp.makerId = pm.id";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("pp", PotatoProduct.class)
					.addEntity("pm", PotatoMaker.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/* 条件あり */

	@SuppressWarnings("unchecked")
	public List<PotatoProduct> resultList(String makerId, String name, String type) {
		List<PotatoProduct> resultTable = null;
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		String select = "SELECT {pp.*},{pm.*} FROM PotatoProduct pp, PotatoMaker pm";
		String where1 = "WHERE pp.makerId = pm.id";
		StringBuilder sb = new StringBuilder();
		sb.append("");

		if (!StringUtils.isEmpty(makerId)) {
			sb.append("AND (pp.makerId = ").append(makerId).append(" )");
		}
		if (!StringUtils.isEmpty(name)) {
			sb.append("AND (pp.name LIKE '%").append(name).append("%' )");
		}
		if (!StringUtils.isEmpty(type)) {
			sb.append("AND (pp.type = '").append(type).append("' )");
		}
		String where2 = sb.toString();
		String sql = select + " " + where1 + " " + where2;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("pp", PotatoProduct.class)
					.addEntity("pm", PotatoMaker.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	// 削除表示
	/*----------------------------------------------
	*/

	/* 削除するテーブルの一覧表示 */

	@SuppressWarnings("unchecked")
	public List<PotatoProduct> selectForDelete(String[] deleteId) {
		List<PotatoProduct> resultTable = null;
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		String select = "SELECT {pp.*},{pm.*} FROM PotatoProduct pp, PotatoMaker pm";
		String where1 = "WHERE pp.makerId = pm.id";
		String where2 = "AND pp.id in (";

		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += ","; // 2個目以降の削除IDを指定するときにカンマを追加する
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("pp", PotatoProduct.class)
					.addEntity("pm", PotatoMaker.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		session.getTransaction().commit();
		return resultTable;
	}

	/* 削除の実行 */

	public void delete(String delete) {
		Session session = this.getCurrentSession();
		// 削除IDはカンマ区切りで渡されるのでそれを分割、配列へと格納する
		String[] deleteId = delete.split(",");

		// トランザクション開始
		session.beginTransaction();

		for (int i = 0; i < deleteId.length; i++) {
			int id = Integer.parseInt(deleteId[i].trim());
			try {
				PotatoProduct potatoProduct = (PotatoProduct) session.load(PotatoProduct.class, id);
				session.delete(potatoProduct);
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		// 必ずすること
		session.getTransaction().commit();
	}

	/* 追加の実行 */

	public void insert(String makerId, String name, String type, String volume, String price, String comment) {
		Session session = this.getCurrentSession();

		// トランザクション開始
		session.beginTransaction();

		PotatoProduct pp = new PotatoProduct();
		// idはオートインクリメントで自動に設定
		pp.setMakerId(Integer.parseInt(makerId));
		pp.setName(name);
		pp.setType(type);
		pp.setVolume(Integer.parseInt(volume));
		pp.setPrice(Integer.parseInt(price));
		pp.setComment(comment);

		try {
			session.save(pp);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}


	/* 更新の実行 */
	public void updata(PotatoProduct model) {
		Session session = this.getCurrentSession();

		// トランザクション開始
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
