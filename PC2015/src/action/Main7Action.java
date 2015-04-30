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

	public String userId;
	public String genreId;
	public String exhibition_year;
	public String delete;
	public String do_print;
	public String update_id;

	public ArrayList<ResultTableMovie> outputTableMovie;

	private String getDefaultGenre() {
		return "";
	}

	private String getDefaultExhibition_year() {
		return "";
	}

	@Override
	public String execute() {
		this.userId = (String) this.sessionMap.get("userId");
		this.genreId = getDefaultGenre();
		this.exhibition_year = getDefaultExhibition_year();
		this.delete = "false";
		return "success";
	}

	public String reset() {
		this.userId = (String) this.sessionMap.get("userId");
		this.genreId = getDefaultGenre();
		this.exhibition_year = getDefaultExhibition_year();
		return "success";
	}

	public String print() {
		MovieManager allController = new MovieManager();
		List<?> resultTableMovie;
		this.userId = (String) this.sessionMap.get("userId");

		if (this.genreId.isEmpty() && this.exhibition_year.isEmpty()) {
			resultTableMovie = allController.resultList();
		} else {
			resultTableMovie = allController.resultList(this.genreId,
					this.exhibition_year);
		}

		this.outputTableMovie = tableTrans(resultTableMovie);

		this.do_print = "true";
		this.delete = "true";
		return "success";
	}

	public String update() {
		this.sessionMap.put("update_id", null);

		try {
			this.response.sendRedirect("/PC2015/update7.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	public String delete() {
		this.sessionMap.put("update_id", this.update_id);

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
