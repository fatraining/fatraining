package controller;

import java.util.ArrayList;
import java.util.List;

import model.Story;
import model.Result3Table;
import model.Tb_Genre;

import org.hibernate.classic.Session;

public class StoryManager extends TaskUtil {

	public  List<?> resultTable;
	public  ArrayList<Result3Table> outputTable;

	public ArrayList<Result3Table> resultList() {
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT * FROM story d,tb_genre i";
		String where1 = "WHERE d.genre_id = i.id";
		String sql    = select + " "+where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("Story", Story.class)
					.addEntity("Genre", Tb_Genre.class).list();
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
				temp.setGenre(genre.getGenre());
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