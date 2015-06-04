package dao;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import model.LiofTa;
import model.CoofTa;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

// HibernateUtilクラスを継承したクラス
public class LiofTaDao extends HibernateUtil {

	// resultListメソッド
	public List<?> resultList() {

		// SQLの検索結果用の変数
		List<?> resultTable = null;

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// table_likeとtable_colorを全件検索
		String select = "SELECT * FROM table_like d,table_color i";
		// table_likeのcolorとtable_colorのidは等しい
		String where1 = "WHERE d.color = i.id";
		// select文とwhere文をsqlに代入
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("table_color", LiofTa.class)
					.addEntity("table_like", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションの終了
		session.getTransaction().commit();

		return resultTable;
	}

	// resultListメソッド
	public List<?> resultList(String name, String food, String drink) {

		// SQLの検索結果用の変数
		List<?> resultTable = null;

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		// トランザクションを開始
		session.beginTransaction();

		try {
			if (name.isEmpty()) {
				name = "%";
			}
			if (food.isEmpty()) {
				food = "%";
			}
			if (drink.isEmpty()) {
				drink = "%";
			}

			// table_likeとtable_colorを全件検索
			String select = "SELECT * FROM table_like d, table_color i";
			// table_likeのcolorとtable_colorのidは等しい
			String where1 = "WHERE d.color = i.id";
			String where2 = "AND (d.name LIKE '" + name + "' AND d.food LIKE '"
					+ food + "' AND d.drink LIKE '" + drink + "')";
			// select文とwhere文をsqlに代入
			String sql = select + " " + where1 + " " + where2;
			
			// SQLが実行され、結果がresultTableに代入される
			resultTable = session.createSQLQuery(sql)
					.addEntity("CoofTa", LiofTa.class)
					.addEntity("LiofTa", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションの終了
		session.getTransaction().commit();
		return resultTable;
	}

	// table_colorの検索用メソッド
	public CoofTa cooftaList() {

		// SQLの検索結果用の変数
		List<?> resultTable = null;

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		// トランザクションを開始
		session.beginTransaction();
		
		try {
			// table_colorを全件検索して昇順化している
			String sql = "SELECT * FROM table_color i ORDER BY id";
			resultTable = session.createSQLQuery(sql)
					.addEntity("CoofTa", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return (CoofTa) resultTable.get(resultTable.size() - 1);
	}

	// insertメソッド（挿入）
	public void insert(String name, String food, String drink, String color,
			String colorNm, String userid, String new_userid) {

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();

		// 日時を取得
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");

		// インスタンス化
		CoofTa insert_color_table = new CoofTa();

		// データを挿入
		insert_color_table.setColorNm(colorNm);
		insert_color_table.setDay(String.valueOf(sdf.format(date)));
		insert_color_table.setNew_day(String.valueOf(sdf.format(date)));
		insert_color_table.setUserid(userid);
		insert_color_table.setNew_userid(new_userid);
		insert_color_table.setTime_stamp(0);
		insert_color_table.setDeleteFlg(0);

		// color_tableテーブルに追加
		try {
			session.save(insert_color_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// color_tableテーブルのデータ検索
		LiofTaDao lioftamanager = new LiofTaDao();
		insert_color_table = lioftamanager.cooftaList();

		// like_tableデータの作成
		LiofTa insert_like_table = new LiofTa();
		insert_like_table.setColor(insert_color_table.getId());
		insert_like_table.setName(name);
		insert_like_table.setFood(food);
		insert_like_table.setDrink(drink);
		insert_like_table.setDay(String.valueOf(sdf.format(date)));
		insert_like_table.setNew_day(String.valueOf(sdf.format(date)));
		insert_like_table.setUserid(userid);
		insert_like_table.setNew_userid(new_userid);
		insert_like_table.setTime_stamp(0);
		insert_like_table.setDeleteFlg(0);

		// like_tableテーブルに追加
		try {
			session.save(insert_like_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		// トランザクションの終了
		session.getTransaction().commit();
	}

	// deleteメソッド
	public void delete(String delete_id) {

		if (delete_id.isEmpty()) {
		}
		// 分割
		String[] strAry = delete_id.split(",");

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// トランザクションを開始
		session.beginTransaction();

		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {

			try {
				// load = 主キーの検索
				LiofTa liofta = (LiofTa) session.load(LiofTa.class, strAry[i]);
				CoofTa coofta = (CoofTa) session.load(CoofTa.class,
						liofta.getColor());

				// 削除
				session.delete(coofta);
				session.delete(liofta);
				
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		// トランザクションの終了
		session.getTransaction().commit();
	}
}