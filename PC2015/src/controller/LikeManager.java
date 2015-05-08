package controller;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import model.LikeGame;
import model.LikeSeries;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

@Result(name = "main6", value = "main6.action", type = ServletRedirectResult.class)
// HibernateUtilクラスを継承したクラス
public class LikeManager extends HibernateUtil {
	// 検索時入力がなかったとき実行
	public List<?> searchList() {
		// DBへの接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始
		session.beginTransaction();

		// SQL文
		// テーブルの全件を検索
		String select = "SELECT * FROM like_game g,like_series s ";
		// gameのseriesとseriesのidが等しい
		String where1 = "WHERE g.series=s.up_id";
		// select文とwhere文を合わせたものをsqlに代入
		String sql = select + " " + where1;

		// SQL文の実行
		List<?> resultTable6 = null; // SQLの検索結果用の変数

		try {
			// インスタンス生成
			resultTable6 = session.createSQLQuery(sql)
			// SQLQuery.addEntityメソッドで戻り値を設定
					.addEntity("LikeGame", LikeGame.class)
					// SQLQuery.addEntityメソッドで戻り値を設定 listメソッドでクエリの実行
					.addEntity("LikeSeries", LikeSeries.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションの終了
		session.getTransaction().commit();

		return resultTable6;
	}

	public List<?> searchList(String title, String series) {

		// DBへの接続処理
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始
		session.beginTransaction();

		if (title.isEmpty()) {
			title = "%";
			// titleが空の場合、%でランダム検索
		}

		if (series.isEmpty()) {
			series = "%";
			// titleが空の場合、%でランダム検索
		}
		// テーブルの全件を検索
		String select = "SELECT * FROM like_game g,like_series s";
		// gameのseriesとseriesのidが等しい
		String where1 = "WHERE g.series=s.up_id";
		// 入力された値とそれぞれのテーブルにあるカラムの値が等しいという条件
		String where2 = "AND (g.title LIKE '" + title + "' AND g.series LIKE '"
				+ series + "')";
		String sql = select + " " + where1 + " " + where2;

		List<?> resultTable = null; // SQLの検索結果用の変数

		try {
			resultTable = session.createSQLQuery(sql)
			// SQLQuery.addEntityメソッドで戻り値を設定
					.addEntity("LikeGame", LikeGame.class)
					// SQLQuery.addEntityメソッドで戻り値を設定 listメソッドでクエリの実行
					.addEntity("LikeSeries", LikeSeries.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		// トランザクションの終了
		session.getTransaction().commit();

		return resultTable;
	}

	public LikeGame like_gameList() {
		List<?> resultTable6 = null;
		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションを開始
		session.beginTransaction();

		try {

			// like_gameテーブルの全件検索
			String sql = "SELECT * FROM like_game g";
//			String where1 = "WHERE id ORDER BY id ASC ";
//			String sql = select + "" + where1;

			// SQLの実行結果がresult10Tableに代入される
			resultTable6 = session.createSQLQuery(sql)

			// SQLQuery.addEntityメソッドで戻り値IDofEatの型設定、SQLQuery.listメソッドでクエリの実行
					.addEntity("LikeGame", LikeGame.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// result10Tableの最終行を取得
		// 自分で入力したものを取得したいため、最終行
		return (LikeGame) resultTable6.get(resultTable6.size() - 1);
	}

	public void insert(String series, String se, String title, String nonStyle,
			String del, String userID, String upUser) {

		// 日付の設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		String us = String.valueOf(sdf.format(date));
		String upDay = String.valueOf(sdf.format(date));

		// データベースに接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションを開始
		session.beginTransaction();

		// インスタンス化。like_gameのデータ作成
		LikeGame insert_game_table = new LikeGame();
		insert_game_table.setTitle(title);
		insert_game_table.setSeries(series);
		insert_game_table.setUpDay(upDay);
		insert_game_table.setUserID(userID);
		insert_game_table.setUpUser(upUser);
		insert_game_table.setNonStyle(nonStyle);
		insert_game_table.setDel(del);

		// like_gameに追加
		try {
			session.save(insert_game_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// like_gameのテーブのルデータ検索
		LikeManager likeManager = new LikeManager();
		insert_game_table = likeManager.like_gameList();

		// インスタンス化。like_seriesのデータ作成
		LikeSeries insert_series_table = new LikeSeries();
		insert_series_table.setUs(us);
		insert_series_table.setSe(se);
		insert_series_table.setUp_id(insert_game_table.getId());

		try {
			session.save(insert_series_table);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了
		session.getTransaction().commit();
		// return "main6";
	}

	public String delete(String delete_id) {

		// 複数選択の削除のために文字列の分割
		String str = new String(delete_id);
		String[] strAry = str.split(",");

		if (delete_id.isEmpty()) {
			return "main6";
		}

		// for文で処理を繰り返す
		for (int i = 0; i < strAry.length; i++) {
			// データベースに接続
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			// トランザクション開始
			session.beginTransaction();

			try {
				LikeGame likegame = (LikeGame) session.load(LikeGame.class,
						strAry[i]);
				LikeSeries likeseries = (LikeSeries) session.load(
						LikeSeries.class, likegame.getId());

				session.delete(likegame);// 指定したIDを削除する
				session.delete(likeseries);// 指定したIDを削除する

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			// トランザクションの終了
			session.getTransaction().commit();

		}
		return "main6";
	}
}