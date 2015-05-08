package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Genre;
import model.Sweets;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

public class SweetsManager extends HibernateUtil {

	// 全件のデータを検索
	public List<?> searchAll() {

		// DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始（固定文言）
		session.beginTransaction();

		// SQL文の作成
		String select = "SELECT * FROM sweets d,genre i";
		String where1 = "WHERE d.genre_id=i.id"; // d（sweets）テーブルのgenre_idは、i(genre)テーブルのidです　という意味
		String sql = select + " " + where1;

		// SQL文の実行（固定文言）
		List<?> resultTable = null; // SQLの検索結果用の変数
		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("sweets", Sweets.class)
					.addEntity("genre", Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了（固定文言）
		session.getTransaction().commit();

		return resultTable;
	}

	// 条件指定のデータを検索
	public List<?> searchAll(String genreNm, String name) {

		// DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始（固定文言）
		session.beginTransaction();

		// SQL文の作成
		if (genreNm.isEmpty()) {
			genreNm = "%";
		}
		if (name.isEmpty()) {
			name = "%";
		}

		// 2つのテーブルを結合
		String select = "SELECT * FROM sweets d,genre i";
		String where1 = "WHERE d.genre_id=i.id";
		String where2 = "AND (d.name LIKE'" + name + "' AND i.genreNm LIKE '"
				+ genreNm + "')";
		String sql = select + " " + where1 + " " + where2;

		// SQL文の実行（固定文言）
		List<?> resultTable = null; // SQLの検索結果用の変数
		try {

			resultTable = session.createSQLQuery(sql)
					.addEntity("Sweets", Sweets.class)
					.addEntity("Genre", Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了（固定文言）
		session.getTransaction().commit();

		return resultTable;
	}

	public void insert(String name, String genreNm, String userId) {
		// 登録、更新日時設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");

		// インスタンス化
		Sweets insert_sweets = new Sweets();
		insert_sweets.setName(name); // お菓子の名前
		insert_sweets.setGenre_id(genreNm); // ジャンルID
		insert_sweets.setRecord_date(String.valueOf(sdf.format(date))); // 登録日付
		insert_sweets.setReset_date(String.valueOf(sdf.format(date))); // 更新日付
		insert_sweets.setEntry_userId(userId); // 登録ユーザID
		insert_sweets.setRecord_userId(userId); // 更新ユーザID
		insert_sweets.setExclusive_FLG(0); // 排他フラグ
		insert_sweets.setDelete_FLG(0); // 削除フラグ

		// DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始（固定文言）
		session.beginTransaction();

		try {
			session.save(insert_sweets);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		}
		session.getTransaction().commit();

	}

	public void delete(String deleteId) {

		String str = new String(deleteId);
		String[] strAry = str.split(",");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		for (int i = 0; i < strAry.length; i++) {

			try {
				Sweets sweets = (Sweets) session.load(Sweets.class, strAry[i]);
				session.delete(sweets);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}

		}
		session.getTransaction().commit();

	}

}