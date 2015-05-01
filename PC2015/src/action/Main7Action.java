package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Movie;
import model.MovieGenre;
import model.ResultTableMovie;
import controller.MovieManager;

public class Main7Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String userId;//ユーザーID
	public String genreId;//ジャンルID
	public String exhibition_year;//公開年
	public String delete;//削除ボタン
	public String do_print;//結果表示
	public String delete_id;//削除するID

	public ArrayList<ResultTableMovie> outputTableMovie;

//	private String getDefaultGenre() {
//		return "";
//	}
//
//	private String getDefaultExhibition_year() {
//		return "";
//	}

	@Override
	public String execute() {
		this.userId = (String) this.sessionMap.get("userId");
//		this.genreId = getDefaultGenre();
//		this.exhibition_year = getDefaultExhibition_year();
		this.delete = "false";
		return "success";
	}

	public String reset() {//リセットボタンを押した時のメソッド
		this.userId = (String) this.sessionMap.get("userId");//ユーザーIDを取ってくる
		this.genreId = "";//ジャンルを空にする。
		this.exhibition_year = "";//公開年を空にする。
		return "success";
	}

	public String print() {//検索結果を表示させるためのメソッド
		MovieManager moviemanager = new MovieManager();//MovieManagerをインスタンス化
		 List<?> resultTable;//リスト型の変数宣言
		this.userId = (String) this.sessionMap.get("userId");//ユーザーIDの取得

		if (this.genreId.isEmpty() && this.exhibition_year.isEmpty()) {//未入力の場合
			resultTable = moviemanager.resultList();//マネージャーのresultList()を呼ぶ
		} else {//どちらかが入力された場合
			resultTable = moviemanager.resultList(this.genreId,
					this.exhibition_year);//マネージャーのresultList(genreId,exhibition_year)を呼ぶ
		}

		this.outputTableMovie = tableTrans(resultTable);

		this.do_print = "true";
		this.delete = "true";
		return "success";
	}

	public String update() {
		this.sessionMap.put("delete_id", null);

		try {
			this.response.sendRedirect("/PC2015/update7.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	public String delete() {
		this.sessionMap.put("delete_id", this.delete_id);

		try {
			this.response.sendRedirect("/PC2015/update7.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// 表示結果の配列
	public ArrayList<ResultTableMovie> tableTrans(List<?> resultTable) {
		ArrayList<ResultTableMovie> tempTable = new ArrayList<ResultTableMovie>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				ResultTableMovie temp = new ResultTableMovie();
				obj = (Object[]) resultTable.get(i);
				Movie movie = (Movie) obj[0];
				MovieGenre movie_genre = (MovieGenre) obj[1];
				temp.setGenre(movie_genre.getGenre());
				temp.setId(movie.getId());
				temp.setTitle(movie.getTitle());
				temp.setExhibition_year(movie.getExhibition_year());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}

}
