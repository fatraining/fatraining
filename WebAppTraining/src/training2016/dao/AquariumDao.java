package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Aquarium;
import training2016.model.AquariumArea;



public class AquariumDao extends AbstractDao {


	/**
	 *
	 * 追加画面のエリア取得
	 */

	@SuppressWarnings("unchecked")
	public List<AquariumArea> getAquariumAreaList() {
		//SQLの検索結果変数
		List<AquariumArea> resultTable = null;
		//データベース接続
		Session session = this.getCurrentSession();
		try {
			//トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM AquariumArea")
					//ResultTableにsql文をいれる
					.addEntity("AquariumArea",AquariumArea.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクション終了
		session.getTransaction().commit(); //close
		return resultTable;
	}

	/**
	 *
	 * 検索結果(null)
	 */
	@SuppressWarnings("unchecked")
	public List<Aquarium> aquariumList() {
		List<Aquarium> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Aquarium a, AquariumArea aa";
		String where1 = "WHERE a.aquariumAreaId = aa.id";
		String sql = select + " " + where1;

		try{
			resultTable = session.createSQLQuery(sql).addEntity("a",Aquarium.class)
					.addEntity("aa",AquariumArea.class).list();
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
	public List<Aquarium> resultList(String aquariumAreaId, String name, String price) {
		List<Aquarium> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {a.*},{aa.*} FROM Aquarium a, AquariumArea aa";
			String where1 = "WHERE a.aquariumAreaId = aa.id";
			String where2 = "";

			if (!StringUtils.isEmpty(aquariumAreaId)) {
				where2 += "AND (aa.id = " + aquariumAreaId + " )"; //LIKEじゃないほうがいいよ
			}
			if (!StringUtils.isEmpty(name)) {
				where2 += "AND (a.name LIKE '%" + name + "%' )";
			}
			if (!StringUtils.isEmpty(price)) {
				where2 += "AND (a.price LIKE '%" + price + "%' )";
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable =session.createSQLQuery(sql)
					.addEntity("a",Aquarium.class)
					.addEntity("aa",AquariumArea.class)
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
	 * @param deleteId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Aquarium> selectForDelete(String[] deleteId) {
		List<Aquarium> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Aquarium a, AquariumArea aa";
		String where1 = "WHERE a.aquariumAreaId = aa.id";
		String where2 = "AND a.id in (";    //ANDが抜けてた
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += " , ";
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql)
					.addEntity("a",Aquarium.class)
					.addEntity("aa",AquariumArea.class)
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
		//文字列を分割する
		String[] strAry = delete.split(",");

		Session session = this.getCurrentSession();
		session.beginTransaction();

		//for文で処理を繰り返す
		for(int i = 0; i < strAry.length; i++) {

			try {
				//load = 主キーの検索
				Aquarium aquarium = (Aquarium) session.load(Aquarium.class, Integer.parseInt(strAry[i]));
				session.delete(aquarium);
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

	public void insert(String id,
			           String aquariumAreaId,
			           String name,
			           String price,
			           String hours,
			           String comment) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		Aquarium a = new Aquarium();
		a.setAquariumAreaId(Integer.parseInt(aquariumAreaId));
		a.setName(name);
		a.setPrice(price);
		a.setHours(hours);
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
	 * @param model
	 */

	public void update(Aquarium model) {
//		this.apply(model, (s, m) -> {s.update(m);});


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
