package action;

import java.io.IOException;
import java.util.ArrayList;

import model.ResultTableMovie;
import controller.MovieManager;
import controller.Result7Manager;
import action.AbstractAction;

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

		this.userId = (String) this.sessionMap.get("userId");
		if (this.genreId.isEmpty() && this.exhibition_year.isEmpty()) {
				this.outputTableMovie = allController.resultList(this.genreId,
						this.exhibition_year);
		} else {
			Result7Manager linkController = new Result7Manager();
			this.outputTableMovie = linkController.resultList(this.genreId,
					this.exhibition_year);
		}
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
}
