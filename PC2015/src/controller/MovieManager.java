package controller;

import java.util.ArrayList;
import java.util.List;

import model.Movie;
import model.MovieGenre;
import model.ResultTableMovie;

import org.hibernate.classic.Session;

public class MovieManager extends HibernateUtil {

	public  List<?> resultTableMovie;
	public  ArrayList<ResultTableMovie> outputTableMovie;

	public ArrayList<ResultTableMovie> resultList(String genreId, String exhibition_year) {
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

		this.outputTableMovie = tableTrans(resultTableMovie);

		return outputTableMovie;
	}
	
	//表示結果の配列
	public ArrayList<ResultTableMovie> tableTrans(List<?> resultTable){
		ArrayList<ResultTableMovie> tempTable = new ArrayList<ResultTableMovie>();
		Object[] obj;
		try {
			for(int i = 0 ; i < resultTable.size() ; i++){
				ResultTableMovie temp = new ResultTableMovie();
				obj = (Object[]) resultTable.get(i);
				Movie movie =  (Movie)obj[0];
				MovieGenre movie_genre  = (MovieGenre)obj[1];
				temp.setGenre(movie_genre.getGenre());
				temp.setId(movie.getId());
				temp.setTitle(movie.getTitle());
				temp.setExhibition_year(movie.getExhibition_year());
//				temp.setRegistration_date(movie.getRegistration_date());
//				temp.setRenewal_date(movie.getRenewal_date());
//				temp.setRegistration_userid(movie.getRegistration_userid());
//				temp.setRenewal_userid(movie.getRenewal_userid());
//				temp.setControl(movie.getControl());
//				temp.setDelete(movie.getDelete());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}