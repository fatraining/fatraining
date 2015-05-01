package controller;

import java.util.ArrayList;
import java.util.List;

import model.Sweets;
import model.Genre;
import model.Result2Table;

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


}