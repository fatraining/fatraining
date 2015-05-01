package controller;

import java.util.List;

import model.Movie;
import model.MovieGenre;

import org.hibernate.classic.Session;

public class MovieManager extends HibernateUtil {//HibernateUtilを継承


	//検索項目未入力の場合のメソッド
	public List<?> resultList() {
		  List<?> resultTableMovie = null;//リスト型の変数宣言

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();//DB接続
		session.beginTransaction();//トランザクション(?)開始

		//インサートするためのsql文
		String select = "SELECT * FROM movie m,movie_genre g";
		String where1 = "WHERE m.genreId=g.id";
		String sql    = select + " "+where1;

		try {
			resultTableMovie = session.createSQLQuery(sql)//Queryインターフェイスのインスタンスを取得(?)
					.addEntity("Movie", Movie.class)//ネイティブ SQL クエリからエンティティオブジェクトを取得する
					.addEntity("MovieGenre", MovieGenre.class).list();//クエリの実行(?)
		} catch (Exception e) {//例外がeに代入される
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTableMovie;
	}
	
	//検索項目入力済みの場合のメソッド
	public List<?> resultList(String genreId,String exhibition_year){
		  List<?> resultTableMovie = null;//リスト型の変数宣言

		Session session = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		try {
			if(genreId.isEmpty())genreId="%";
			if(exhibition_year.isEmpty())exhibition_year="%";
			String select = "SELECT * FROM movie m,movie_genre g";
			String where1 = "WHERE m.genreId=g.id";
			String where2 = "AND (m.genreId LIKE '"+ genreId +"' AND m.exhibition_year LIKE '"
					+ exhibition_year+ "')";
			String sql = select + " " + where1 + " " + where2;
			resultTableMovie = session.createSQLQuery(sql)
					.addEntity("Movie", Movie.class)//ネイティブ SQL クエリからエンティティオブジェクトを取得する
					.addEntity("MovieGenre", MovieGenre.class).list();//ネイティブ SQL クエリからエンティティオブジェクトを取得する
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTableMovie;
	}
}