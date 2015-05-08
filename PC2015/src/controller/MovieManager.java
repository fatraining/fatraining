package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Movie;
import model.MovieGenre;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

@Result(name = "main7", value = "main7.action", type = ServletRedirectResult.class)
public class MovieManager extends HibernateUtil { // HibernateUtilを継承

	public ArrayList<MovieGenre> expression() {
		ArrayList<MovieGenre> resultTableMovie = null; // リスト型の変数宣言

		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); // DB接続
		session.beginTransaction(); // トランザクション(?)開始

		String select = "SELECT * FROM movie_genre";
		String sql = select;

		try {
			resultTableMovie = (ArrayList<MovieGenre>)session.createSQLQuery(sql) // Queryインターフェイスのインスタンスを取得(?)
					.addEntity("MovieGenre", MovieGenre.class).list(); // クエリの実行(?)
			// 例外がeに代入される
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit(); // トランザクション(?)終了
		return resultTableMovie;

	}

	// 検索項目未入力の場合のメソッド
	public List<?> resultList() {
		List<?> resultTableMovie = null; // リスト型の変数宣言

		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); // DB接続
		session.beginTransaction(); // トランザクション(?)開始

		// 表示させるためのためのsql文
		String select = "SELECT * FROM movie m,movie_genre g";
		String where1 = "WHERE m.genreId=g.id";
		String sql = select + " " + where1;

		try {
			resultTableMovie = session.createSQLQuery(sql) // Queryインターフェイスのインスタンスを取得(?)
					.addEntity("Movie", Movie.class) // ネイティブ
														// SQLクエリからエンティティオブジェクトを取得する
					.addEntity("MovieGenre", MovieGenre.class).list(); // クエリの実行(?)
			// 例外がeに代入される
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit(); // トランザクション(?)終了
		return resultTableMovie;
	}

	// 検索項目入力済みの場合のメソッド
	public List<?> resultList(String genreId, String exhibition_year) {
		List<?> resultTableMovie = null;// リスト型の変数宣言

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();// DB接続
		session.beginTransaction(); // トランザクション(?)開始

		try {
			// もしgenreIdが空だったらワイルドカード(%)を入れる
			if (genreId.isEmpty()) {
				genreId = "%";
			}
			// 　もしexhibition_yearが空だったらワイルドカード(%)を入れる
			if (exhibition_year.isEmpty()) {
				exhibition_year = "%";
			}

			// 表示させるためのsql文
			String select = "SELECT * FROM movie m,movie_genre g ";
			String where1 = "WHERE m.genreId=g.id ";
			String where2 = "AND (m.genreId LIKE '" + genreId
					+ "' AND m.exhibition_year LIKE '" + exhibition_year + "')";
			String sql = select + where1 + where2;
			resultTableMovie = session.createSQLQuery(sql) // Queryインターフェイスのインスタンスを取得(?)
					.addEntity("Movie", Movie.class)// ネイティブ
													// SQL。クエリからエンティティオブジェクトを取得する
					.addEntity("MovieGenre", MovieGenre.class).list(); // クエリの実行(?)
			// 例外がeに代入される
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit(); // トランザクション(?)終了
		return resultTableMovie;
	}

	// Update7Actionから呼ばれるinsertメソッド
	public void insert(String title, int genreId, int exhibition_year,
			String comment, String registration_userid, String renewal_userid) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();// DB接続
		session.beginTransaction();// トランザクション(?)開始

		// 日付を自動で入力
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");

		// 登録するテーブルとカラムを指定
		Movie insert_movie_table = new Movie();
		insert_movie_table.setTitle(title); // タイトル
		insert_movie_table.setGenreId(genreId); //ジャンルID
		insert_movie_table.setExhibition_year(exhibition_year); // 公開年
		insert_movie_table.setComment(comment); // コメント
		insert_movie_table
				.setRegistration_date(String.valueOf(sdf.format(date))); // 日付を入力
		insert_movie_table.setRenewal_date(String.valueOf(sdf.format(date))); // 日付を入力
		insert_movie_table.setRegistration_userid(registration_userid); // ユーザーIDを指定
		insert_movie_table.setRenewal_userid(renewal_userid); // ユーザーIDを指定
		insert_movie_table.setControl(0); // ユーザーIDを指定
		insert_movie_table.setDeleteflg(0); // ユーザーIDを指定

		// テーブルにインサートする
		try {
			session.save(insert_movie_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
	}

	// Update7Actionから呼ばれるdeleteメソッド
	public String delete(String delete_id) {
		String[] deleteId = delete_id.split(","); // 取得したdelete_idの分割

		if (deleteId.length == 0) { // 取得、分割したデリートIDの長さが0の時
			return "main7";
		}
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		for (int i = 0; i < deleteId.length; i++) { // 　取得、分割したデリートIDの長さが0より大きい時

			try {
				Movie movie = (Movie) session.load(Movie.class, deleteId[i]);
				session.delete(movie);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}

		session.getTransaction().commit();
		return "main7";
	}
}