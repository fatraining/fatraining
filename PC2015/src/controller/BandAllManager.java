package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.BandAccount;
import model.BandTable;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

@Result(name = "bandsearch", value = "bandSearch.action", type = ServletRedirectResult.class)
// HibernateUtilクラスを継承したクラス
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

		// band_nameが空の時はワイルドカード「%」を代入
		if (band_name.isEmpty()) {
			band_name = "%";
		}
		// nameが空の時はワイルドカード「%」を代入
		if (name.isEmpty()) {
			name = "%";
		}
		// partが空の時はワイルドカード「%」を代入
		if (part.isEmpty()) {
			part = "%";
		}

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

	// band_tableテーブル検索用のメソッド
	public BandTable bandTableList() {
		List<?> bandResultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			// band_tableテーブルの全件検索
			String select = "SELECT * FROM band_table t ";
			String where1 = "WHERE id ORDER BY id ASC ";
			String sql = select + "" + where1;
			bandResultTable = session.createSQLQuery(sql)
			// session.createSQLQuwey(sql)の戻り値をBandTableクラスに渡している
					.addEntity("BandTable", BandTable.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// bandResultTableの最終行を取得
		// 自分で入力したものを取得したいため、最終行
		return (BandTable) bandResultTable.get(bandResultTable.size() - 1);
	}

	// insertメソッド。データベースに値を入れる。
	public void insert(String band_name, String name, String sex, String age,
			String school, String favorite_song, String part,
			String entry_userid, String renewal_userid) {

		// 日付の設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		String entry_date = String.valueOf(sdf.format(date));
		String renewal_date = String.valueOf(sdf.format(date));

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションを開始
		session.beginTransaction();

		// インスタンス化。band_tableのデータ作成
		BandTable insert_band_table = new BandTable();
		insert_band_table.setBand_name(band_name);
		insert_band_table.setEntry_date(entry_date);
		insert_band_table.setRenewal_date(renewal_date);
		insert_band_table.setEntry_userid(entry_userid);
		insert_band_table.setRenewal_userid(renewal_userid);

		// band_tableテーブルに追加
		try {
			session.save(insert_band_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// band_tableテーブルのデータ検索
		BandAllManager bandAllManager = new BandAllManager();
		insert_band_table = bandAllManager.bandTableList();

		// band_accountデータの作成
		BandAccount insert_band_account = new BandAccount();
		insert_band_account.setName(name);
		insert_band_account.setSex(sex);
		insert_band_account.setAge(age);
		insert_band_account.setSchool(school);
		insert_band_account.setFavorite_song(favorite_song);
		insert_band_account.setPart(part);
		// band_tableテーブルのIDを取得し、band_accountテーブルのBAND_IDに代入
		insert_band_account.setBand_id(insert_band_table.getId());
		insert_band_account.setEntry_date(entry_date);
		insert_band_account.setRenewal_date(renewal_date);
		insert_band_account.setEntry_userid(entry_userid);
		insert_band_account.setRenewal_userid(renewal_userid);

		// band_accountテーブルに追加
		try {
			session.save(insert_band_account);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();

	}

	// deleteメソッド。削除するときの処理
	public String delete(String delete_id) {

		// 複数選択の削除のために文字列の分割
		String str = new String(delete_id);
		String[] strAry = str.split(",");

		if (delete_id.isEmpty()) {
			return "bandsearch";
		}
		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {
			// データベースに接続
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			// トランザクションを開始
			session.beginTransaction();
			try {
				BandAccount bandaccount = (BandAccount) session.load(
						BandAccount.class, strAry[i]);
				BandTable bandtable = (BandTable) session.load(BandTable.class,
						bandaccount.getBand_id());
				session.delete(bandaccount); // band_accountテーブルの選択された行を削除
				session.delete(bandtable); // band_tableテーブルの選択された行を削除
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.getTransaction().commit();
		}
		return "bandsearch";

	}

}