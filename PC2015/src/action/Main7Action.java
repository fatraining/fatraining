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

	public String userId; // ユーザーID
	public String genreId; // ジャンルID
	public String exhibition_year; // 公開年
	public String delete; // 削除ボタン
	public String do_print; // 結果表示
	public String delete_id; // 削除するID

	public ArrayList<ResultTableMovie> outputTableMovie;

	// 開かれた時に呼ばれる最初のメソッド
	@Override
	public String execute() {
		this.userId = (String) this.sessionMap.get("userId"); // ユーザーIDを取得
		this.delete = "false"; // 削除ボタン非表示
		return "success";
	}

	// リセットボタンを押した時のメソッド
	public String reset() {
		this.userId = (String) this.sessionMap.get("userId"); // ユーザーIDを取得
		this.genreId = ""; // ジャンルを空にする。
		this.exhibition_year = ""; // 公開年を空にする。
		return "success";
	}

	// 検索結果を表示させるためのメソッド
	public String print() {
		this.userId = (String) this.sessionMap.get("userId");// ユーザーIDの取得

		MovieManager moviemanager = new MovieManager(); // MovieManagerをインスタンス化
		List<?> resultTable; // リスト型の変数宣言
		
		// 未入力の場合
		if (this.genreId.isEmpty() && this.exhibition_year.isEmpty()) {
			resultTable = moviemanager.resultList(); // マネージャーのresultList()を呼ぶ
		// どちらかが入力された場合
		} else {
			resultTable = moviemanager.resultList(this.genreId,
					this.exhibition_year); // マネージャーのresultList(genreId,exhibition_year)を呼ぶ
		}

		this.outputTableMovie = tableTrans(resultTable);

		this.do_print = "true"; // 検索結果を表示する
		this.delete = "true"; // 削除ボタンを表示する
		return "success";
	}
	// 追加するメソッド
	public String update() {
		this.sessionMap.put("delete_id", null); // デリートIDをセッションマップに置く

		try {
			this.response.sendRedirect("/PC2015/update7.action"); //要求に応え、update7.actionに接続する
		// 例外を拾う,ストリームクラスを使用している間に発生する、ファイル入出力（IO）関係の例外のスーパークラス
		} catch (IOException e) {
			e.printStackTrace(); //例外元のクラスや説明原因、メソッド名などを出力する。例外が投げられた理由を簡単に取得できる。
		}

		return "success";
	}
	// 削除の確認をするメソッド
	public String delete() {
		this.sessionMap.put("delete_id", this.delete_id); // デリートIDをセッションマップに置く

		try {
			this.response.sendRedirect("/PC2015/update7.action"); // update7.actionに接続する
		// 例外を拾う
		} catch (IOException e) {
			e.printStackTrace();  // 例外を出力する
		}

		return "success";
	}

	// 表示結果の配列
	//可変長配列を実現するクラス。add()メソッドで追加でき、get()メソッドで取得する
	private ArrayList<ResultTableMovie> tableTrans(List<?> resultTable) {
		ArrayList<ResultTableMovie> tempTable = new ArrayList<ResultTableMovie>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				ResultTableMovie temp = new ResultTableMovie();
				obj = (Object[]) resultTable.get(i);
				Movie movie = (Movie) obj[0];
				MovieGenre movie_genre = (MovieGenre) obj[1];
				if(movie_genre.getGenre().isEmpty()){
					temp.setGenre("不明");
				}else{
					temp.setGenre(movie_genre.getGenre());
				}
				temp.setId(movie.getId());
				temp.setTitle(movie.getTitle());
				if (movie.getExhibition_year() == 0) {
					temp.setExhibition_year("不明");
				} else {
					temp.setExhibition_year(String.valueOf(movie
							.getExhibition_year()));
				}
				temp.setComment(movie.getComment());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}

}
