package training2016.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import training2016.model.CryingMovie;

/*
 * データアクセスクラス
 */

@SuppressWarnings("unchecked")
public class CryingMovieDao extends AbstractDao{

	/*
	 * 指定条件なし検索
	 */
	public List<CryingMovie> getMovieList(){

		// SQLの検索結果変数
		List<CryingMovie> resultTable = null;

		// データベース接続
		Session session = this.getCurrentSession();//abstractにあるデータベースの接続

		try {
			// トランザクションを開始
			session.beginTransaction();
			resultTable = session.createSQLQuery("SELECT * FROM CRYINGMOVIE") //creatrSQLQ
				// ResultTableにsql文をいれる
				.addEntity("CRYINGMOVIE", CryingMovie.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		// トランザクション終了
		session.getTransaction().commit(); // close

		return resultTable;
	}

	/*
	 * 条件あり検索
	 * countryFlg:0 指定しない、1日本、2海外
	 * genreFlg:0 指定しない、1 恋愛、2 家族、3 ヒューマン
	 */
	@SuppressWarnings("unchecked")
	public List<CryingMovie> getMovieConditionList(int countryFlg, int genreFlg){

		// SQLの検索結果変数
		List<CryingMovie> resultTable = null;

		// データベース接続
		Session session = this.getCurrentSession();//abstractにあるデータベースの接続

		try {
			// トランザクションを開始
			session.beginTransaction();

			String select = "SELECT * FROM CRYINGMOVIE";
			String where1 = "WHERE ";
			String where2 = "";

			if(countryFlg == 1 || countryFlg == 2){
				where1 += ("countryFlg = " + countryFlg);
			}

			if(genreFlg != 0){
				where2 += "AND genreFlg = " + genreFlg;
			}

			String sql = select + where1 + where2;

			resultTable = session.createSQLQuery(sql) //creatrSQLQ
					// ResultTableにsql文をいれる
					.addEntity("CRYINGMOVIE", CryingMovie.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("停止");
		}
		// トランザクション終了
		session.getTransaction().commit(); // close

		return resultTable;
	}

	/*
	 * IDをキーにして削除対象のレコードを取得する
	 */
	@SuppressWarnings("unchecked")
	public List<CryingMovie> getDeleteList(String[] deleteId){
		List<CryingMovie> resultTable = null;
		Session session = this.getCurrentSession();
		session.beginTransaction();

		String select = "SELECT movieID FROM CRYINGMOVIE";
		String where1 = "WHERE movieID = aa.id";
		String where2 = "AND a.id in (";
		for (int i = 0; i < deleteId.length; i++) {
			if (i > 0) {
				where2 += ",";
			}
			where2 += deleteId[i];
		}
		where2 += ")";
		String sql = select + " " + where1 + " " + where2;

		try {
			resultTable = session.createSQLQuery(sql).addEntity("a", CryingMovie.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();

		return resultTable;
	}

	/*
	 * 削除時の接続
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
				CryingMovie cm = (CryingMovie) session.load(CryingMovie.class, Integer.parseInt(strAry[i].trim()));
				session.delete(cm);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}

	/*
	 * 登録時の接続
	 */
	public void insert(int movieId, int countryFlg, int ganre, String title, String mainCast, String story) {
		Session session = this.getCurrentSession();
		session.beginTransaction();

		CryingMovie cm = new CryingMovie();
		cm.setMovieId(movieId);
		cm.setCountryFlg(countryFlg);
		cm.setGenre(ganre);
		cm.setTitle(title);
		cm.setMainCast(mainCast);
		cm.setStory(story);

		try {
			session.save(cm);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	/*
	 * 更新時の接続
	 */
	public void update(CryingMovie model) {

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
