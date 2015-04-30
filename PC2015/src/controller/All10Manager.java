package controller;

import java.util.ArrayList;
import java.util.List;

import model.DetailEat;
import model.IDofEat;
import model.Result10Table;

import org.hibernate.classic.Session;

//HibernateUtilから継承されたAll10Managerクラス
public class All10Manager extends HibernateUtil{
	public List<?> result10Table;
	public ArrayList<Result10Table> outputTable;

	public ArrayList<Result10Table> resultList() {
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

		this.outputTable = tableTrans(result10Table);
		//todo(outputTableに2つのテーブルが結合したものを検索処理したものを代入する？)
		return outputTable;
	}
	
	
	public ArrayList<Result10Table> resultList(String eat_year, String eat_month,
			String eat_day, String eat_hour) {
		//データベースに接続する
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始
		session.beginTransaction();
		try {
			if (eat_year.isEmpty())
				eat_year = "%"; //eat_yearが入力されたものである
			if (eat_month.isEmpty())
				eat_month = "%";
			if (eat_day.isEmpty())
				eat_day = "%";
			if (eat_hour.isEmpty())
				eat_hour = "%";
			String select = "SELECT * FROM eat_detail d, eat_id i";
			String where1 = "WHERE d.id = i.id";
			String where2 = "AND (d.eat_year LIKE '" + eat_year + "' AND d.eat_month LIKE '"
					+ eat_month + "' AND d.eat_day LIKE '" + eat_day + "' AND d.eat_hour LIKE '" + eat_hour + "')";
			String sql = select + " " + where1+ " " + where2;
			result10Table = session.createSQLQuery(sql)
					.addEntity("DetailEat", DetailEat.class)
					.addEntity("IDofEat", IDofEat.class).list(); //todo(2つのテーブルを一つのものにする？)
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback(); //例外がキャッチされたらその前に戻る
		}
		session.getTransaction().commit();
		this.outputTable = tableTrans(result10Table); //todo(outputTableに2つが結合したものを検索処理したものを代入する？)
		
		return outputTable; //テーブルを表示させる
	}
	

	public ArrayList<Result10Table> tableTrans(List<?> result10Table) {
		ArrayList<Result10Table> tempTable = new ArrayList<Result10Table>();
		Object[] obj;
		try {
			for (int i = 0; i < result10Table.size(); i++) {
				Result10Table temp = new Result10Table();
				//インスタンスの生成
				obj = (Object[]) result10Table.get(i);
				//結合したテーブルを表示させる
				DetailEat detaileat = (DetailEat) obj[0];
				IDofEat idofeat = (IDofEat) obj[1];
				temp.setId(detaileat.getId());
				temp.setEat_year(detaileat.getEat_year());
				temp.setEat_month(detaileat.getEat_month());
				temp.setEat_day(detaileat.getEat_day());
				temp.setEat_hour(detaileat.getEat_hour());
				temp.setEntry_day(detaileat.getEntry_day());
				temp.setRenew_day(detaileat.getRenew_day());
				temp.setEntry_userid(detaileat.getEntry_userid());
				temp.setRenew_userid(detaileat.getRenew_userid());
				temp.setEatFood(idofeat.getEatFood());
				temp.setEatCalory(idofeat.getEatCalory());
				temp.setEntry_day(idofeat.getEntry_day());
				temp.setRenew_day(idofeat.getRenew_day());
				temp.setEntry_userid(idofeat.getEntry_userid());
				temp.setRenew_userid(idofeat.getRenew_userid());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace(); //todo（例外をキャッチする）

		}

		return tempTable; //todo
	}
}