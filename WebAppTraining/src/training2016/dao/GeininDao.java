package training2016.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.Geinin;
import training2016.model.GeininJenre;
import training2016.model.GeininJimusho;
import training2016.model.GeininNumber;
import training2016.model.GeininSex;



public class GeininDao extends AbstractDao {
	/**
	 *
	 * 追加画面のエリア取得
	 */

	@SuppressWarnings("unchecked")
	public List<GeininJimusho> getGeininJimushoList() {
		//SQLの検索結果変数
		List<GeininJimusho> resultTable = null;
		//データベース接続
		Session session = this.getCurrentSession();
		try {
			//トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM GeininJimusho")
					//ResultTableにsql文をいれる
					.addEntity("GeininJimusho",GeininJimusho.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクション終了
		session.getTransaction().commit(); //close
		return resultTable;
	}

	@SuppressWarnings("unchecked")
	public List<GeininSex> getGeininSexList() {
		//SQLの検索結果変数
		List<GeininSex> resultTable = null;
		//データベース接続
		Session session = this.getCurrentSession();
		try {
			//トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM GeininSex")
					//ResultTableにsql文をいれる
					.addEntity("GeininSex",GeininSex.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクション終了
		session.getTransaction().commit(); //close
		return resultTable;
	}

	@SuppressWarnings("unchecked")
	public List<GeininNumber> getGeininNumberList() {
		//SQLの検索結果変数
		List<GeininNumber> resultTable = null;
		//データベース接続
		Session session = this.getCurrentSession();
		try {
			//トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM GeininNumber")
					//ResultTableにsql文をいれる
					.addEntity("GeininNumber",GeininNumber.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクション終了
		session.getTransaction().commit(); //close
		return resultTable;
	}

	@SuppressWarnings("unchecked")
	public List<GeininJenre> getGeininJenreList() {
		//SQLの検索結果変数
		List<GeininJenre> resultTable = null;
		//データベース接続
		Session session = this.getCurrentSession();
		try {
			//トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM GeininJenre")
					//ResultTableにsql文をいれる
					.addEntity("GeininJenre",GeininJenre.class).list();
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
	public List<Geinin> geininList() {
		List<Geinin> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {g.*},{gn.*},{gs.*},{gji.*},{gje.*} FROM Geinin g, GeininNumber gn, GeininSex gs, GeininJimusho gji, GeininJenre gje";
		String where1 = "WHERE g.numberId = gn.id AND g.sexId = gs.id AND g.jimushoId = gji.id AND g.jenreId = gje.id";
		String sql = select + " " + where1;

		try{
			resultTable = session.createSQLQuery(sql).addEntity("g",Geinin.class)
					.addEntity("gn",GeininNumber.class)
					.addEntity("gs",GeininSex.class)
					.addEntity("gji",GeininJimusho.class)
					.addEntity("gje",GeininJenre.class).list();
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
	public List<Geinin> resultList(String name, String numberId, String sexId, String jimushoId, String year, String jenreId) {
		List<Geinin> resultTable = null;

		Session session = this.getCurrentSession();

		try {
			session.beginTransaction();

			String select = "SELECT {g.*},{gn.*},{gs.*},{gji.*},{gje.*} FROM Geinin g, GeininNumber gn, GeininSex gs, GeininJimusho gji, GeininJenre gje";
			String where1 = "WHERE g.numberId = gn.id AND g.sexId = gs.id AND g.jimushoId = gji.id AND g.jenreId = gje.id";
			String where2 = "";

			if (!StringUtils.isEmpty(name)) {
				where2 += "AND (g.name LIKE '%" + name + "%' )";
			}
			if (!StringUtils.isEmpty(numberId)) {
				where2 += "AND (gn.id = " + numberId + " )"; //LIKEじゃないほうがいいよ
			}
			if (!StringUtils.isEmpty(sexId)) {
				where2 += "AND (gs.id = " + sexId + " )"; //LIKEじゃないほうがいいよ
			}
			if (!StringUtils.isEmpty(jimushoId)) {
				where2 += "AND (gji.id = " + jimushoId + " )"; //LIKEじゃないほうがいいよ
			}
			if (!StringUtils.isEmpty(year)) {
				where2 += "AND (g.year = " + year + " )"; //LIKEじゃないほうがいいよ
			}
			if (!StringUtils.isEmpty(jenreId)) {
				where2 += "AND (gje.id = " + jenreId + " )"; //LIKEじゃないほうがいいよ
			}

			String sql = select + " " + where1 + " " + where2;

			resultTable = session.createSQLQuery(sql).addEntity("g",Geinin.class)
					.addEntity("gn",GeininNumber.class)
					.addEntity("gs",GeininSex.class)
					.addEntity("gji",GeininJimusho.class)
					.addEntity("gje",GeininJenre.class).list();
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
	public List<Geinin> selectForDelete(String[] deleteId) {
		List<Geinin> resultList = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {g.*},{gn.*},{gs.*},{gji.*},{gje.*} FROM Geinin g, GeininNumber gn, GeininSex gs, GeininJimusho gji, GeininJenre gje";
		String where1 = "WHERE g.numberId = gn.id AND g.sexId = gs.id AND g.jimushoId = gji.id AND g.jenreId = gje.id";
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
			resultList = session.createSQLQuery(sql).addEntity("g",Geinin.class)
					.addEntity("gn",GeininNumber.class)
					.addEntity("gs",GeininSex.class)
					.addEntity("gji",GeininJimusho.class)
					.addEntity("gje",GeininJenre.class).list();
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
				Geinin geinin = (Geinin) session.load(Geinin.class, Integer.parseInt(strAry[i]));
				session.delete(geinin);
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
						String image,
			           String name,
			           String numberId,
			           String sexId,
			           String jimushoId,
			           String year,
			           String jenreId,
			           String work,
			           String movieUrl) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		Geinin g = new Geinin();
		//idはオートインクリメントなのでなくて大丈夫
		g.setImage(image);
		g.setJenreId(Integer.parseInt(jenreId));
		g.setJimushoId(Integer.parseInt(jimushoId));
		g.setMovieUrl(movieUrl);
		g.setNumberId(Integer.parseInt(numberId));
		g.setSexId(Integer.parseInt(sexId));
		g.setWork(work);
		g.setYear(Integer.parseInt(year));

		try {
			session.save(g);
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

	public void update(Geinin model) {
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
