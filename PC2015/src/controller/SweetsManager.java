package controller;

import java.util.ArrayList;
import java.util.List;

import model.Sweets;
import model.Genre;
import model.Result2Table;

import org.hibernate.classic.Session;

public class SweetsManager extends HibernateUtil {

	public  List<?> result2Table;
	public  ArrayList<Result2Table> outputTable;

	public ArrayList<Result2Table> resultList(String name, String genreNm) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		
		String select = "SELECT * FROM sweets d,genre i";
		
		//d（sweets）テーブルのgenre_idは、i(genre)テーブルのidです　という意味
		String where1 = "WHERE d.genre_id=i.id";
		String sql    = select + " "+where1;

		try {
			result2Table = session.createSQLQuery(sql)
					.addEntity("sweets", Sweets.class)
					.addEntity("genre", Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		this.outputTable = tableTrans(result2Table);

		return outputTable;
	}
	//検索結果
	public ArrayList<Result2Table> tableTrans(List<?> resultTable){
		ArrayList<Result2Table> tempTable = new ArrayList<Result2Table>();
		Object[] obj;
		try {
			for(int i = 0 ; i < resultTable.size() ; i++){
				Result2Table temp = new Result2Table();
				obj = (Object[]) resultTable.get(i);
				Sweets sweets =  (Sweets)obj[0];
				Genre genre    = (Genre)obj[1];
				temp.setId(sweets.getId());
				temp.setName(sweets.getName());
				temp.setGenreNm(genre.getGenreNm());
//				temp.setRecord_date(sweets.getRecord_date());
//				temp.setReset_date(sweets.getReset_date());
				temp.setEntry_userId(sweets.getEntry_userId());
				temp.setRecord_userId(sweets.getRecord_userId());
				temp.setExclusive_FLG(sweets.getExclusive_FLG());
				temp.setDelete_FLG(sweets.getDelete_FLG());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}