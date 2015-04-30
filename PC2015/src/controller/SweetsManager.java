package controller;

import java.util.ArrayList;
import java.util.List;

import model.Sweets;
import model.Genre;
import model.Result2Table;

import org.hibernate.classic.Session;

public class SweetsManager extends HibernateUtil {

	//全件のデータを検索
	public ArrayList<Result2Table> searchAll() {
		
		//DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始（固定文言）
		session.beginTransaction();

		//SQL文の作成
		String select = "SELECT * FROM sweets d,genre i";
		String where1 = "WHERE d.genre_id=i.id"; //d（sweets）テーブルのgenre_idは、i(genre)テーブルのidです　という意味
		String sql    = select + " "+where1;

		//SQL文の実行（固定文言）
		List<?> resultTable = null; //SQLの検索結果用の変数
		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("sweets", Sweets.class)
					.addEntity("genre", Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		//トランザクションの終了（固定文言）
		session.getTransaction().commit();

		ArrayList<Result2Table> outputTable = tableTrans(resultTable);

		return outputTable;
	}
	
	public ArrayList<Result2Table> resultList(String genreNm, String name){

		//DBへの接続処理（固定文言）
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//トランザクションの開始（固定文言）
		session.beginTransaction();
		
		//SQL文の作成
		if(genreNm.isEmpty())genreNm="%";
		if(name.isEmpty())name="%";
		
		//2つのテーブルを結合
		String select = "SELECT * FROM sweets d,genre i";
		String where1 = "WHERE d.genre_id=i.id";
		String where2 = "AND (d.name LIKE'"+ name + "' AND i.genreNm LIKE '" + genreNm + "')";
		String sql = select + " " + where1 + " " + where2;
		
		//SQL文の実行（固定文言）
		List<?> resultTable = null; //SQLの検索結果用の変数
		try {

			resultTable = session.createSQLQuery(sql)
					.addEntity("Sweets", Sweets.class)
					.addEntity("Genre", Genre.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		//トランザクションの終了（固定文言）
		session.getTransaction().commit();

		ArrayList<Result2Table> outputTable = tableTrans(resultTable);

		return outputTable;
	}
	

	//SQLの検索結果を画面表示用のListに入れ替えている
	public ArrayList<Result2Table> tableTrans(List<?> resultTable){
		
		// 画面表示用のリストをインスタンス化する。
		ArrayList<Result2Table> tempTable = new ArrayList<Result2Table>();

		// 変数の初期化
		Object[] obj;

		// SQLの検索結果の件数分ループする。
		for (int i = 0; i < resultTable.size(); i++) {
			// 画面表示用のレコードをインスタンス化する。
			Result2Table temp = new Result2Table();

			// SQLの検索結果を分解する。
			obj = (Object[]) resultTable.get(i);
			Sweets sweets = (Sweets) obj[0];
			Genre genre = (Genre) obj[1];

			// 画面表示用に設定する。
			temp.setId(sweets.getId());
			temp.setName(sweets.getName());
			temp.setGenreNm(genre.getGenreNm());
			// temp.setRecord_date(sweets.getRecord_date());
			// temp.setReset_date(sweets.getReset_date());
			temp.setEntry_userId(sweets.getEntry_userId());
			temp.setRecord_userId(sweets.getRecord_userId());
			temp.setExclusive_FLG(sweets.getExclusive_FLG());
			temp.setDelete_FLG(sweets.getDelete_FLG());

			// 画面表示用にリストに追加する。
			tempTable.add(temp);
		}

		return tempTable;
	}
}