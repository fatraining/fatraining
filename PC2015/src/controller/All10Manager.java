package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.DetailEat;
import model.IDofEat;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

//HibernateUtilを継承したAll10Managerクラス
public class All10Manager extends HibernateUtil {

	// 引数なしのsearchallList（検索欄入力なしの場合）
	public List<?> searchallList() {
		// データベースに接続する
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始
		session.beginTransaction();

		// 全件検索
		String select = " SELECT * FROM eat_detail d,eat_id i";
		// detail_eatのfood_idとeat_idのidを紐づける
		String where1 = " WHERE d.food_id = i.id";
		// select文とwhere文を合わせたものをsqlに代入
		String sql = select + " " + where1;

		List<?> result10Table = null; // SQLの検索結果用の変数

		try {
			result10Table = session.createSQLQuery(sql)
			// SQLQuery.addEntityメソッドで戻り値DetailEatの型設定
					.addEntity("eat_detail", DetailEat.class)
					// SQLQuery.addEntityメソッドで戻り値IDofEatの型設定、SQLQuery.listメソッドでクエリの実行（結果をresult10Tableに代入）
					.addEntity("eat_id", IDofEat.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了
		session.getTransaction().commit();

		return result10Table;
	}

	// 引数ありのsearchallList（検索欄入力ありの場合）
	public List<?> searchallList(String eat_year, String eat_month,
			String eat_day, String eat_hour) {
		// データベースに接続する
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始
		session.beginTransaction();

		// eat_yearに入力された値が空の場合はeat_yearはなんでも
		if (eat_year.isEmpty()) {
			eat_year = "%";
		}
		// eat_monthに入力された値が空の場合eat_monthはなんでも
		if (eat_month.isEmpty()) {
			eat_month = "%";
		}
		// eat_dayに入力された値が空の場合eat_dayはなんでも
		if (eat_day.isEmpty()) {
			eat_day = "%";
		}
		// eat_hourに入力された値が空の場合はeat_hourはなんでも
		if (eat_hour.isEmpty()) {
			eat_hour = "%";
		}

		// eat_detailとeat_idのテーブルを全件選択
		String select = "SELECT * FROM eat_detail d, eat_id i";
		// eat_detailのfood_idとeat_idのidを紐づける
		String where1 = "WHERE d.food_id = i.id";
		// あいまい検索
		String where2 = "AND (d.eat_year LIKE '" + eat_year
				+ "' AND d.eat_month LIKE '" + eat_month
				+ "' AND d.eat_day LIKE '" + eat_day
				+ "' AND d.eat_hour LIKE '" + eat_hour + "')";
		// select文とwhere文を合わせたものをsqlに代入
		String sql = select + " " + where1 + " " + where2;

		List<?> result10Table = null; // SQLの検索結果用の変数

		try {
			// （実行結果をresult10Tableに代入）
			result10Table = session.createSQLQuery(sql)
			// SQLQuery.addEntityメソッドで戻り値DetailEatの型設定
					.addEntity("DetailEat", DetailEat.class)
					// SQLQuery.addEntityメソッドで戻り値IDofEatの型設定、SQLQuery.listメソッドでクエリの実行
					.addEntity("IDofEat", IDofEat.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションの終了
		session.getTransaction().commit();

		return result10Table;
	}

	// eat_idテーブル検索用のメソッド
	public IDofEat eat_idList() {
		List<?> result10Table = null;
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションを開始する
		session.beginTransaction();

		try {
			// eat_idテーブルの全件検索
			String sql = "SELECT * FROM eat_id i ORDER BY id ASC";

			// SQLの実行結果がresult10Tableに代入される
			result10Table = session.createSQLQuery(sql)

			// SQLQuery.addEntityメソッドで戻り値IDofEatの型設定、SQLQuery.listメソッドでクエリの実行
					.addEntity("IDofEat", IDofEat.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// result10Tableの最終行を取得（0からなのでマイナス1する）
		return (IDofEat) result10Table.get(result10Table.size() - 1);
	}

	public String insert(String eat_year, String eat_month, String eat_day,
			String eat_hour, String eatFood, String eatCalory,
			String entry_userid, String renew_userid) {
		// 変数に日付を設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		String entry_day = String.valueOf(sdf.format(date));
		String renew_day = String.valueOf(sdf.format(date));

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始
		session.beginTransaction();

		// インスタンス化、id_tableにレコードを挿入する
		IDofEat insert_id_table = new IDofEat();
		insert_id_table.setEatFood(eatFood);
		insert_id_table.setEatCalory(eatCalory);
		insert_id_table.setEntry_day(entry_day);
		insert_id_table.setRenew_day(renew_day);
		insert_id_table.setEntry_userid(entry_userid);
		insert_id_table.setRenew_userid(renew_userid);

		try {
			session.save(insert_id_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// データ検索（レコードを取ってくるため）
		All10Manager all10manager = new All10Manager();
		insert_id_table = all10manager.eat_idList();

		// インスタンス化、detail_tableにレコードを挿入する
		DetailEat insert_detail_table = new DetailEat();
		insert_detail_table.setEat_year(eat_year);
		insert_detail_table.setEat_month(eat_month);
		insert_detail_table.setEat_day(eat_day);
		insert_detail_table.setEat_hour(eat_hour);
		insert_detail_table.setFood_id(insert_id_table.getId());
		insert_detail_table.setEntry_day(entry_day);
		insert_detail_table.setRenew_day(renew_day);
		insert_detail_table.setEntry_userid(entry_userid);
		insert_detail_table.setRenew_userid(renew_userid);

		// detail_tableに追加
		try {
			session.save(insert_detail_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションの終了
		session.getTransaction().commit();
		return "main10";
	}

	public String delete(String delete_id) {

		// 複数選択の削除のために文字列の分割
		String str = new String(delete_id);
		String[] strAry = str.split(",");

		// delete_idが空である場合
		if (delete_id.isEmpty()) {
			return "main10"; // Main10Actionへ
		}

		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {

			// データベースに接続
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			// トランザクションの開始
			session.beginTransaction();
			try {
				DetailEat detaileat = (DetailEat) session.load(DetailEat.class,
						strAry[i]);
				IDofEat idofeat = (IDofEat) session.load(IDofEat.class,
						detaileat.getFood_id());

				session.delete(detaileat); // detail_tableの指定した行を削除する
				session.delete(idofeat); // id_tableの指定した行を削除する

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			// トランザクションの終了
			session.getTransaction().commit();
		}
		return "main10"; // Main10Actionへ
	}
}