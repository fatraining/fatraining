package controller;

import java.util.ArrayList;
import java.util.List;

import model.Story;
import model.Result3Table;
import model.Tb_Genre;
import model.User_Character;

import org.hibernate.classic.Session;

public class StoryManager extends HibernateUtil {

	// 全件のデータを検索
	public List<?> searchAll() {

		// DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始（固定文言）
		session.beginTransaction();

		// SQL文の作成
		String select = "SELECT * FROM story d,tb_genre i";
		String where1 = "WHERE d.genre_id = i.id";
		String sql = select + " " + where1;

		// SQL文の実行（固定文言）
		List<?> resultTable = null; // SQLの検索結果用の変数
		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("Story", Story.class)
					.addEntity("Tb_Genre", Tb_Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了（固定文言）
		session.getTransaction().commit();


		return resultTable;
	}

	// 条件指定のデータを検索
	public List<?> searchAll(String title, String genre) {

		// DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始（固定文言）
		session.beginTransaction();

		// SQL文の作成
		if (title.isEmpty()) {
			title = "%";
		}

		if (genre.isEmpty()) {
			genre = "%";
		}

		String select = "SELECT * FROM story d,tb_genre i";
		String where1 = "WHERE d.genre_id = i.id";
		String where2 = "AND (d.title LIKE '" + title + "' AND i.genre LIKE '"
				+ genre + "')";
		String sql = select + " " + where1 + " " + where2;

		List<?> resultTable = null; // SQLの検索結果用の変数
		try {

			resultTable = session.createSQLQuery(sql)
					.addEntity("Story", Story.class)
					.addEntity("Tb_Genre", Tb_Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// トランザクションの終了（固定文言）
		session.getTransaction().commit();

		return resultTable;
	}

	// Tb_Genreテーブル検索用のメソッド
	public Tb_Genre tb_GenreList() {
		List<?> resultTable = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			// user_charactrテーブルの全件検索
			String sql = "SELECT * FROM Tb_Genre i";
			resultTable = session.createSQLQuery(sql)
			// session.createSQLQuery(sql)の戻り値をUser_Profileクラスに渡している
					.addEntity("Tb_Genre", Tb_Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return (Tb_Genre) resultTable.get(resultTable.size() - 1);
	}
}