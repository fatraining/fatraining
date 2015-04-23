package controller;

import java.util.ArrayList;
import java.util.List;

import model.Story;
import model.Tb_Genre;
import model.Result3Table;

import org.hibernate.classic.Session;

public class Result3Manager extends HibernateUtil {

	public  List<?> resultTable;
	public  ArrayList<Result3Table> outputTable;

	public ArrayList<Result3Table> resultList(String title,String genre){

		Session session = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		try {
			if(title.isEmpty())title="%";
			if(genre.isEmpty())genre="%";
			
			String select = "SELECT * FROM story d,tb_genre i";
			String where1 = "WHERE d.genre_id = i.id";
			String where2 = "AND (i.title LIKE '"+ title +"' AND i.genre LIKE '"
					+ genre + ")";
			String sql = select + " " + where1 + " " + where2;
			resultTable = session.createSQLQuery(sql)
					.addEntity("Story", Story.class)
					.addEntity("Genre", Story.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		this.outputTable = tableTrans(resultTable);
		return outputTable;
	}
	public ArrayList<Result3Table> tableTrans(List<?> resultTable){
		ArrayList<Result3Table> tempTable = new ArrayList<Result3Table>();
		Object[] obj;
		try {
			for(int i = 0 ; i < resultTable.size() ; i++){
				Result3Table temp = new Result3Table();
				obj = (Object[]) resultTable.get(i);
				Story story =  (Story)obj[0];
				Tb_Genre genre     = (Tb_Genre)obj[1];
				temp.setGenre(genre .getGenre());
				temp.setId(story.getId());
				temp.setTitle(story.getTitle());
//				temp.setSignup(story.getSignup());
//				temp.setUPdate(story.getUpdate());
//				temp.setSignupUSERID(story.getSignupUSERID());
//				temp.setUpdateUSERID(story.getUpdateUSERID());
//				temp.setExclusiveFLG(story.getExclusiveFLG());
//				temp.setDeleteFLG(story.getDeleteFLG());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempTable;
	}
}