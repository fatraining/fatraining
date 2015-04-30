package controller;

import java.util.ArrayList;
import java.util.List;

import model.Story;
import model.Result3Table;
import model.Tb_Genre;

import org.hibernate.classic.Session;

public class StoryManager extends HibernateUtil {

	//全件のデータを検索
	public ArrayList<Result3Table> searchAll() {
		
		//DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始（固定文言）
		session.beginTransaction();

		//SQL文の作成
		String select = "SELECT * FROM story d,tb_genre i";
		String where1 = "WHERE d.genre_id = i.id";
		String sql = select + " " + where1;

		//SQL文の実行（固定文言）
		List<?> resultTable = null; //SQLの検索結果用の変数
		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("Story", Story.class)
					.addEntity("Tb_Genre", Tb_Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		//トランザクションの終了（固定文言）
		session.getTransaction().commit();

		ArrayList<Result3Table> outputTable = tableTrans(resultTable);

		return outputTable;
	}

	public ArrayList<Result3Table> resultList(String title, String genre) {

		//DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始（固定文言）
		session.beginTransaction();
		
		//SQL文の作成
		if (title.isEmpty())
			title = "%";
		if (genre.isEmpty())
			genre = "%";

		String select = "SELECT * FROM story d,tb_genre i";
		String where1 = "WHERE d.genre_id = i.id";
		String where2 = "AND (d.title LIKE '" + title
				+ "' AND i.genre LIKE '" + genre + "')";
		String sql = select + " " + where1 + " " + where2;
		
		List<?> resultTable = null; //SQLの検索結果用の変数
		try {

			resultTable = session.createSQLQuery(sql)
					.addEntity("Story", Story.class)
					.addEntity("Tb_Genre", Tb_Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		//トランザクションの終了（固定文言）
		session.getTransaction().commit();

		ArrayList<Result3Table> outputTable = tableTrans(resultTable);

		return outputTable;
	}

	//SQLの検索結果を画面表示用のListに入れ替えている
	private ArrayList<Result3Table> tableTrans(List<?> resultTable) {
		
		//画面表示用のリストをインスタンス化する。
		ArrayList<Result3Table> tempTable = new ArrayList<Result3Table>();
		
		//変数の初期化
		Object[] obj;

		//SQLの検索結果の件数分ループする。
		for (int i = 0; i < resultTable.size(); i++) {
			//画面表示用のレコードをインスタンス化する。
			Result3Table temp = new Result3Table();
			
			//SQLの検索結果を分解する。
			obj = (Object[]) resultTable.get(i);
			Story story = (Story) obj[0];
			Tb_Genre genre = (Tb_Genre) obj[1];
			
			//画面表示用に設定する。
			temp.setGenre(genre.getGenre());
			temp.setId(story.getId());
			temp.setTitle(story.getTitle());
			
			//画面表示用にリストに追加する。
			tempTable.add(temp);
		}

		return tempTable;
	}
}