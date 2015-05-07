package controller;

import java.util.List;

import model.BandAccount;
import model.BandTable;

import org.hibernate.classic.Session;

//HibernateUtilクラスを継承したクラス
public class BandAllManager extends HibernateUtil {

	// bandSearchAllメソッド(引数なし)。検索時入力がなかったとき実行
	public List<?> bandSearchAll() {
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションを開始
		session.beginTransaction();

		// 検索した結果を表示させるためのsql文
		// band_accountテーブルとband_tableテーブルの全件を検索
		String select = "SELECT * FROM band_account a,band_table t ";
		// band_accountテーブルのIDとband_tableテーブルのIDが等しい
		String where1 = "WHERE a.band_id = t.id ";
		// select文とwhere文を合わせたものをsqlに代入
		String sql = select + " " + where1;

		// SQL文の実行(固定文言)
		List<?> bandResultTable = null; // SQLの検索結果用の変数
		try {
			bandResultTable = session.createSQLQuery(sql) // インスタンス生成
					// SQLQuery.addEntityメソッドで戻り値BandAccountの型設定
					.addEntity("BandAccount", BandAccount.class)
					// SQLQuery.addEntityメソッドで戻り値BandTableの型設定。SQLQuery.listメソッドでクエリの実行
					.addEntity("BandTable", BandTable.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了(固定文言)
		session.getTransaction().commit();

		return bandResultTable;
	}

	// bandSearchAllメソッド(引数あり)。検索時入力があったときに実行
	public List<?> bandSearchAll(String band_name, String name, String part) {

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクション開始
		session.beginTransaction();

		if (band_name.isEmpty()) {
			band_name = "%";
		} // band_nameが空の時はワイルドカード「%」を代入
		if (name.isEmpty()) {
			name = "%";
		} // nameが空の時はワイルドカード「%」を代入
		if (part.isEmpty()) {
			part = "%";
		} // partが空の時はワイルドカード「%」を代入

		// band_accountテーブルとband_tableテーブルの全件を検索
		String select = "SELECT * FROM band_account a,band_table t ";
		// band_accountテーブルのBAND_IDとband_tableテーブルのIDが等しいという条件
		String where1 = "WHERE a.band_id = t.id ";
		// 入力された値とそれぞれのテーブルにあるカラムの値が等しいという条件
		String where2 = "AND (t.BAND_NAME LIKE '" + band_name
				+ "' AND a.NAME LIKE '" + name + "' AND a.PART LIKE '" + part
				+ "')";
		// sqlにselect文、where文二つを代入
		String sql = select + " " + where1 + " " + where2;

		List<?> bandResultTable = null; // SQLの検索結果用の変数
		try {

			bandResultTable = session.createSQLQuery(sql)
			// SQLQuery.addEntityメソッドで戻り値BandAccountの型設定
					.addEntity("BandAccount", BandAccount.class)
					// SQLQuery.addEntityメソッドで戻り値BandTableの型設定。SQLQuery.listメソッドでクエリの実行
					.addEntity("BandTable", BandTable.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了(固定文言)
		session.getTransaction().commit();

		return bandResultTable;
	}
	
	//band_tableテーブル検索用のメソッド
	public BandTable bandTableList(){
		List<?> bandResultTable = null;
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try{
			//band_tableテーブルの全件検索
			String sql = "SELECT * FROM band_table t";
			bandResultTable = session.createSQLQuery(sql)
					//session.createSQLQuwey(sql)の戻り値をBandTableクラスに渡している
					.addEntity("BandTable",BandTable.class).list();
		}catch (Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		//bandResultTableの最終行を取得
		//自分で入力したものを取得したいため、最終行
		return (BandTable) bandResultTable.get(bandResultTable.size() - 1);
	}

}
