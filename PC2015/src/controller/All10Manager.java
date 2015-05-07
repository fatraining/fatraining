package controller;

import java.util.List;

import model.DetailEat;
import model.IDofEat;

import org.hibernate.classic.Session;

//HibernateUtilを継承したAll10Managerクラス
public class All10Manager extends HibernateUtil{

	//引数なしのsearchallList（検索欄入力なしの場合）
	public List<?> searchallList() {
		//データベースに接続する
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始
		session.beginTransaction();

		//全件検索
		String select = " SELECT * FROM eat_detail d,eat_id i";
		//detail_eatのfood_idとeat_idのidを紐づける
		String where1 = " WHERE d.food_id = i.id";
		// select文とwhere文を合わせたものをsqlに代入
		String sql = select + " " + where1;
		// SQL文の実行
				List<?>result10Table = null; // SQLの検索結果用の変数

		try {
			result10Table = session.createSQLQuery(sql) //SQLの実行結果がresult10Tableに代入される
					.addEntity("eat_detail", DetailEat.class)
					// SQLQuery.addEntityメソッドで戻り値DetailEatの型設定
					.addEntity("eat_id", IDofEat.class).list();
					// SQLQuery.addEntityメソッドで戻り値IDofEatの型設定、SQLQuery.listメソッドでクエリの実行
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		// トランザクションの終了
		session.getTransaction().commit();

		return result10Table;
	}
	
	//引数ありのsearchallList（検索欄入力ありの場合）
	public List<?> searchallList(String eat_year, String eat_month,
			String eat_day, String eat_hour) {
		//データベースに接続する
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始
		session.beginTransaction();
		
			if (eat_year.isEmpty()){
				eat_year = "%"; 
			}//eat_yearに入力された値が空の場合はeat_yearはなんでも
			if (eat_month.isEmpty()){
				eat_month = "%"; 
			}//eat_monthに入力された値が空の場合eat_monthはなんでも
			if (eat_day.isEmpty()){
				eat_day = "%";
			}//eat_dayに入力された値が空の場合eat_dayはなんでも
			if (eat_hour.isEmpty()){
				eat_hour = "%";  
			}//eat_hourに入力された値が空の場合はeat_hourはなんでも
			
			//eat_detailとeat_idのテーブルを全件選択
			String select = "SELECT * FROM eat_detail d, eat_id i";
			//eat_detailのfood_idとeat_idのidを紐づける
			String where1 = "WHERE d.food_id = i.id";
			//あいまい検索
			String where2 = "AND (d.eat_year LIKE '" + eat_year + "' AND d.eat_month LIKE '"
					+ eat_month + "' AND d.eat_day LIKE '" + eat_day + "' AND d.eat_hour LIKE '" + eat_hour + "')";
			// select文とwhere文を合わせたものをsqlに代入
			String sql = select + " " + where1+ " " + where2;
			
			List<?> result10Table = null; // SQLの検索結果用の変数
			
		try{
			result10Table = session.createSQLQuery(sql) //SQLの実行結果がresult10Tableに代入される
					.addEntity("DetailEat", DetailEat.class)
					// SQLQuery.addEntityメソッドで戻り値DetailEatの型設定
					.addEntity("IDofEat", IDofEat.class).list();
					// SQLQuery.addEntityメソッドで戻り値IDofEatの型設定、SQLQuery.listメソッドでクエリの実行
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback(); 
		}
		// トランザクションの終了
		session.getTransaction().commit();
		
		return result10Table; //テーブルを表示させる
		}
	
	// eat_idテーブル検索用のメソッド
	public IDofEat eat_idList() {
		List<?> result10Table = null;
		//データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションを開始する
		session.beginTransaction();
		
		try {
			
			// eat_idテーブルの全件検索
			String sql = "SELECT * FROM eat_id i";
			
			//SQLの実行結果がresult10Tableに代入される
			result10Table = session.createSQLQuery(sql)
					
					// SQLQuery.addEntityメソッドで戻り値IDofEatの型設定、SQLQuery.listメソッドでクエリの実行
					.addEntity("IDofEat", IDofEat.class).list();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// result10Tableの最終行を取得
		// 自分で入力したものを取得したいため、最終行
		return (IDofEat) result10Table.get(result10Table.size() - 1);
	}

}