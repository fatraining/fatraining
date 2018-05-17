package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Maiwaifu;
import training2016.model.MaiwaifuArea;



public class MaiwaifuDao extends AbstractDao {


	/**
	 *
	 * 追加画面のエリア取得
	 */

	@SuppressWarnings("unchecked")
	public List<MaiwaifuArea> getMaiwaifuAreaList() {
		//SQLの検索結果変数
		List<MaiwaifuArea> resultTable = null;
		//データベース接続
		Session session = this.getCurrentSession();
//		Session session = this.openSession();
		try {
			//トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM MaiwaifuArea")
					//ResultTableにsql文をいれる
					.addEntity("MaiwaifuArea",MaiwaifuArea.class).list();
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
	public List<Maiwaifu> maiwaifuList() {
		List<Maiwaifu> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Maiwaifu a, MaiwaifuArea aa";
		String where1 = "WHERE a.maiwaifuAreaId = aa.id";
		String sql = select + " " + where1;

		try{
			resultTable = session.createSQLQuery(sql).addEntity("a",Maiwaifu.class)
					.addEntity("aa",MaiwaifuArea.class).list();
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
	public List<Maiwaifu> resultList(String maiwaifuAreaId, String name, String genre) {
		List<Maiwaifu> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {a.*},{aa.*} FROM Maiwaifu a, MaiwaifuArea aa";
			String where1 = "WHERE a.maiwaifuAreaId = aa.id";
			String where2 = "";

			if (!StringUtils.isEmpty(maiwaifuAreaId)) {
				where2 += "AND (aa.id = " + maiwaifuAreaId + " )"; //LIKEじゃないほうがいいよ
			}
			if (!StringUtils.isEmpty(name)) {
				where2 += "AND (a.name LIKE '%" + name + "%' )";
			}
			if (!StringUtils.isEmpty(genre)) {
				where2 += "AND (a.genre LIKE '%" + genre + "%' )";
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable =session.createSQLQuery(sql)
					.addEntity("a",Maiwaifu.class)
					.addEntity("aa",MaiwaifuArea.class)
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
	public List<Maiwaifu> selectForDelete(String[] deleteId) {
		List<Maiwaifu> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Maiwaifu a, MaiwaifuArea aa";
		String where1 = "WHERE a.maiwaifuAreaId = aa.id";
		String where2 = "AND a.id in (";    //ANDが抜けてた
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += " , ";   //2個目からカンマ区切りにするｓ
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql)
					.addEntity("a",Maiwaifu.class)
					.addEntity("aa",MaiwaifuArea.class)
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
				Maiwaifu maiwaifu = (Maiwaifu) session.load(Maiwaifu.class, Integer.parseInt(strAry[i]));
				session.delete(maiwaifu);
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
			           String maiwaifuAreaId,
			           String image,
			           String name,
			           String genre,
			           String age,
			           String comment) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		Maiwaifu a = new Maiwaifu();
		//idはオートインクリメントなのでなくて大丈夫
		a.setMaiwaifuAreaId(Integer.parseInt(maiwaifuAreaId));
		a.setImage(image);
		a.setName(name);
		a.setGenre(genre);
		a.setAge(age);
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

	public void update(Maiwaifu model) {
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

