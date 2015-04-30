package controller;

import java.util.ArrayList;
import java.util.List;

import model.Movie;
import model.MovieGenre;
import model.ResultTableMovie;

import org.hibernate.classic.Session;

public class MovieManager extends HibernateUtil {

	public  List<?> resultTableMovie;

	public List<?> resultList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		//インサートするためのsql文
		String select = "SELECT * FROM movie m,movie_genre g";
		String where1 = "WHERE m.genreId=g.id";
		String sql    = select + " "+where1;

		try {
			resultTableMovie = session.createSQLQuery(sql)
					.addEntity("Movie", Movie.class)
					.addEntity("MovieGenre", MovieGenre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTableMovie;
	}
	
	public List<?> resultList(String genreId,String exhibition_year){

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
					.addEntity("Movie", Movie.class)
					.addEntity("MovieGenre", MovieGenre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTableMovie;
	}
}