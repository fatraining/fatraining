package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.Story;
import model.Sweets;
import model.Tb_Genre;

import org.hibernate.HibernateException;
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
	
	//追加ボタンを押下時
	public void insert(String genre,String title,String userId) {

		// 登録、更新日時設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		String day = String.valueOf(sdf.format(date));
		String newday = String.valueOf(sdf.format(date));
		
		// 登録更新ID設定
		String userid = userId;
		String newuserid = userId;
		
		// インスタンス化
		Tb_Genre ｔbGenre = new Tb_Genre();
		ｔbGenre.setGenre(genre); //ジャンル
		ｔbGenre.setSignup(day); //登録日付
		ｔbGenre.setUpdateDate(newday); //更新日付
		ｔbGenre.setSignupUSERID(userid); //登録ユーザID
		ｔbGenre.setUpdateUSERID(newuserid); //更新ユーザID
		ｔbGenre.setExclusiveFLG(0); //排他フラグ
		ｔbGenre.setdeleteFLG(0); //削除フラグ
		
		// DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// トランザクションの開始（固定文言）
		session.beginTransaction();
		
		// Tb_Genreテーブルに追加
		try {
			session.save(ｔbGenre);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		// Tb_Genreテーブルのデータ検索
		StoryManager linkController  = new StoryManager();
		Tb_Genre tmpTbGenre = linkController.tb_GenreList();
		
		Story insert_story_table = new Story();
		insert_story_table.setTitle(title); //タイトル
//		insert_story_table.setGenre_id(tmpTbGenre.getId()); //ジャンル
		insert_story_table.setSignup(day); //登録日付
		insert_story_table.setUpdateDate(newday); //更新日付
		insert_story_table.setSignupUSERID(userid); //登録ユーザID
		insert_story_table.setUpdateUSERID(newuserid); //更新ユーザID
//		insert_story_table.setExclusiveFLG(0); //排他フラグ
//		insert_story_table.setdeleteFLG(0); //削除フラグ
		
		try {
			session.save(insert_story_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		
	}
	
	public void delete(String deleteId) {

		// 複数選択の削除
		String str = new String(deleteId);
		// 文字列の分割
		String[] strAry = str.split(",");

		// DBとの接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 処理の繰り返し
		for (int i = 0; i < strAry.length; i++) {

			try {
				Story story = (Story) session.load(Story.class, strAry[i]);
				Tb_Genre tbGenre = (Tb_Genre) session.load(Tb_Genre.class,
						story.getGenre_id());
				session.delete(story);
				session.delete(tbGenre);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}

		}

		session.getTransaction().commit();
	}

}