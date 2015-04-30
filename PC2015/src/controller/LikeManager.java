package controller;

import java.util.ArrayList;
import java.util.List;

import model.LikeGame;
import model.LikeSeries;
import model.ResultTable6;

import org.hibernate.classic.Session;

public class LikeManager extends HibernateUtil {

	public  List<?> resultTable;
	public  ArrayList<ResultTable6> outputTable;

	public ArrayList<ResultTable6> resultList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		//表示条件
		String select = "SELECT * FROM like_game g,like_series s ";
		String where1 = "WHERE g.series=s.i";
		String sql    = select + " " +where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("LikeGame", LikeGame.class)
					.addEntity("LikeSeries", LikeSeries.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		this.outputTable = tableTrans(resultTable);

		return outputTable;
	}
	
	public ArrayList<ResultTable6> resultList(String title, String series){

		Session session = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		try {
			if(title.isEmpty())title="%";
			if(series.isEmpty())series="%";
			String select = "SELECT * FROM like_game g,like_series s";
			String where1 = "WHERE g.series=s.i";
			String where2 = "AND (g.title LIKE '"+ title +"' AND g.series LIKE '"
					+ series + "')";
			String sql = select + " "  + where1 + " " + where2 ;
			resultTable = session.createSQLQuery(sql)
					.addEntity("LikeGame", LikeGame.class)
					.addEntity("LikeSeries", LikeSeries.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		this.outputTable = tableTrans(resultTable);
		return outputTable;
	}
	
	//検索結果
	//リスト内のどこに各要素が挿入されるかを精密に制御できます
	public ArrayList<ResultTable6> tableTrans(List<?> resultTable){
		ArrayList<ResultTable6> tempTable = new ArrayList<ResultTable6>();
		Object[] obj;
		try {
			for(int i = 0 ; i < resultTable.size() ; i++){
				ResultTable6 temp = new ResultTable6();
				obj = (Object[]) resultTable.get(i);
				LikeGame likegame = (LikeGame)obj[0];
				LikeSeries likeseries  = (LikeSeries)obj[1];
				temp.setId(likegame.getId());
				temp.setTitle(likegame.getTitle());
				temp.setSe(likeseries.getSe());
				temp.setU(likeseries.getU());
				temp.setUpDay(likegame.getUpDay());
				temp.setUserId(likegame.getUserId());
				temp.setUpUser(likegame.getUpUser());
				temp.setNonStyle(likegame.getNonStyle());
				temp.setDel(likegame.getDel());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}