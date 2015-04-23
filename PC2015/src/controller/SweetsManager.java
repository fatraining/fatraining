package controller;

import java.util.ArrayList;
import java.util.List;

import model.Sweets;
import model.Genre;
import model.ResultTable;

import org.hibernate.classic.Session;

public class SweetsManager extends TaskUtil {

	public  List<?> resultTable;
	public  ArrayList<ResultTable> outputTable;

	public ArrayList<ResultTable> resultList(String genreNm, String name) {
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT * FROM sweets d,genre i";
		String where1 = "WHERE d.genre_id=i.id";
		String sql    = select + " "+where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("sweets", Sweets.class)
					.addEntity("genre", Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		this.outputTable = tableTrans(resultTable);

		return outputTable;
	}
	public ArrayList<ResultTable> tableTrans(List<?> resultTable){
		ArrayList<ResultTable> tempTable = new ArrayList<ResultTable>();
		Object[] obj;
		try {
			for(int i = 0 ; i < resultTable.size() ; i++){
				ResultTable temp = new ResultTable();
				obj = (Object[]) resultTable.get(i);
				Sweets sweets =  (Sweets)obj[0];
				Genre genreNm     = (Genre)obj[1];
				temp.setId(sweets.getId());
				temp.setName(sweets.getName());
				temp.setGenreNm(genreNm.getGenreNm());
				temp.setRecord_date(sweets.getRecord_date());
				temp.setReset_date(sweets.getReset_date());
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