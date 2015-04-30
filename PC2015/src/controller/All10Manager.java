package controller;

import java.util.List;

import model.DetailEat;
import model.IDofEat;

import org.hibernate.classic.Session;

//HibernateUtilから継承されたAll10Managerクラス
public class All10Manager extends HibernateUtil{
	public List<?> result10Table;

	public List<?> resultList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = " SELECT * FROM eat_detail d,eat_id i";
		String where1 = " WHERE d.id=i.id";
		String sql = select + " " + where1;

		try {
			result10Table = session.createSQLQuery(sql)
					.addEntity("eat_detail", DetailEat.class)
					.addEntity("eat_id", IDofEat.class).list();  //テーブルを結合し、result10Tableにする。

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback(); //例外を検出したらその前に戻る
		}
		session.getTransaction().commit();

		return result10Table;
	}
	
	
	public List<?> resultList(String eat_year, String eat_month,
			String eat_day, String eat_hour) {
		//データベースに接続する
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始
		session.beginTransaction();
		try {
			if (eat_year.isEmpty())
				eat_year = "%"; //eat_yearに入力された値が空の場合はeat_yearはなんでも
			if (eat_month.isEmpty())
				eat_month = "%";  //eat_monthに入力された値が空の場合eat_monthはなんでも
			if (eat_day.isEmpty())
				eat_day = "%";  //eat_dayに入力された値が空の場合eat_dayはなんでも
			if (eat_hour.isEmpty())
				eat_hour = "%";  //eat_hourに入力された値が空の場合はeat_hourはなんでも
			//テーブルの選択
			String select = "SELECT * FROM eat_detail d, eat_id i";
			//eat_detailのidとeat_idのidが同じ
			String where1 = "WHERE d.id = i.id";
			String where2 = "AND (d.eat_year LIKE '" + eat_year + "' AND d.eat_month LIKE '"
					+ eat_month + "' AND d.eat_day LIKE '" + eat_day + "' AND d.eat_hour LIKE '" + eat_hour + "')";
			String sql = select + " " + where1+ " " + where2;
			result10Table = session.createSQLQuery(sql)
					.addEntity("DetailEat", DetailEat.class)
					.addEntity("IDofEat", IDofEat.class).list(); //TODO(2つのテーブルを一つのものにする？)
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback(); //例外がキャッチされたらその前に戻る
		}
		session.getTransaction().commit();
		
		return result10Table; //テーブルを表示させる
	}
	


}