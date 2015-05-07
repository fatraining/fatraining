package controller;

import java.util.ArrayList;
import java.util.List;

import model.LikeGame;
import model.LikeSeries;
import model.ResultTable6;

import org.hibernate.classic.Session;

public class LikeManager extends HibernateUtil {

	//全件のデータを検索
	public List<?> searchList() {
		//DBへの接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始
		session.beginTransaction();

		//SQL文
		String select = "SELECT * FROM like_game g,like_series s ";
		String where1 = "WHERE g.series=s.i";
		String sql    = select + " " +where1;
		
		//SQL文の実行
		List<?> resultTable = null; //SQLの検索結果用の変数

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("LikeGame", LikeGame.class)
					.addEntity("LikeSeries", LikeSeries.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//トランザクションの終了
		session.getTransaction().commit();


		return resultTable;
	}
	
	public List<?> searchList(String title, String series){

		// DBへの接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始
		session.beginTransaction();
		
			if(title.isEmpty()){
				title="%";
			}
			
			if(series.isEmpty()){
				series="%";
			}
			String select = "SELECT * FROM like_game g,like_series s";
			String where1 = "WHERE g.series=s.i";
			String where2 = "AND (g.title LIKE '"+ title +"' AND g.series LIKE '"
					+ series + "')";
			String sql = select + " "  + where1 + " " + where2 ;
			
			List<?> resultTable = null; // SQLの検索結果用の変数
			
			try {
				resultTable = session.createSQLQuery(sql)
					.addEntity("LikeGame", LikeGame.class)
					.addEntity("LikeSeries", LikeSeries.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションの終了
		session.getTransaction().commit();
		
		return resultTable;
	}
	
	
}