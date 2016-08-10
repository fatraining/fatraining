package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Drama;
import training2016.model.DramaGenre;



public class DramaDao extends AbstractDao {


	/**
	 *
	 * 追加画面のエリア取得
	 */

	@SuppressWarnings("unchecked")
	public List<DramaGenre> getDramaGenreList() {
		//SQLの検索結果変数
		List<DramaGenre> resultTable = null;
		//データベース接続
		Session session = this.getCurrentSession();
		try {
			//トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM DramaGenre")
					//ResultTableにsql文をいれる
					.addEntity("DramaGenre",DramaGenre.class).list();
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
	public List<Drama> dramaList() {
		List<Drama> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Drama a, DramaGenre aa";
		String where1 = "WHERE a.dramaGenreId = aa.id";
		String sql = select + " " + where1;

		try{
			resultTable = session.createSQLQuery(sql).addEntity("a",Drama.class)
					.addEntity("aa",DramaGenre.class).list();
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
	public List<Drama> resultList(String dramaGenreId, String name, String cast) {
		List<Drama> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {a.*},{aa.*} FROM Drama a, DramaGenre aa";
			String where1 = "WHERE a.dramaGenreId = aa.id";
			String where2 = "";

			if (!StringUtils.isEmpty(dramaGenreId)) {
				where2 += "AND (aa.id = " + dramaGenreId + " )"; //LIKEじゃないほうがいいよ
			}
			if (!StringUtils.isEmpty(name)) {
				where2 += "AND (a.name LIKE '%" + name + "%' )";
			}
			if (!StringUtils.isEmpty(cast)) {
				where2 += "AND (a.cast LIKE '%" + cast + "%' )";
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable =session.createSQLQuery(sql)
					.addEntity("a",Drama.class)
					.addEntity("aa",DramaGenre.class)
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
	public List<Drama> selectForDelete(String[] deleteId) {
		List<Drama> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {a.*},{aa.*} FROM Drama a, DramaGenre aa";
		String where1 = "WHERE a.dramaGenreId = aa.id";
		String where2 = "AND a.id in ("; 
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += ",";   //2個目からカンマ区切りにする
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultList = session.createSQLQuery(sql)
					.addEntity("a",Drama.class)
					.addEntity("aa",DramaGenre.class)
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
				Drama drama = (Drama) session.load(Drama.class, Integer.parseInt(strAry[i].trim()));
				session.delete(drama);
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
			           String dramaGenreId,
			           String name,
			           String cast,
			           String tvStation,
			           String comment) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		Drama a = new Drama();
		//idはオートインクリメントなのでなくて大丈夫
		a.setDramaGenreId(Integer.parseInt(dramaGenreId));
		a.setName(name);
		a.setCast(cast);
		a.setTvStation(tvStation);
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

	public void update(Drama model) {
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
