package action;

import java.io.IOException;
import java.util.ArrayList;

import model.ResultTable6;
import controller.LikeManager;
import controller.ResultManager6;
import action.AbstractAction;

public class Main6Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String series;
	public String title;
	public String result;
	public String do_search;
	public String update_id;
	public String delete;

	private ResultManager6 linkController;
	private LikeManager allController;
	public ArrayList<ResultTable6> outputTable;

	private String getDefaultSeries() {
		this.series = "1";
		return this.series;
	}

	private String getDefaultTitle() {
		this.title = "Fate/stay night";
		return this.title;
	}

	@Override
	public String execute() {
		this.series = getDefaultSeries();
		this.title = getDefaultTitle();
		this.delete = "false";
		return "success";
	}

	public String reset() {
		this.series = getDefaultSeries();
		this.title = getDefaultTitle();
		return "success";
	}
	public String search() {

		this.do_search = "true";
		if (this.title.isEmpty() && this.series.isEmpty()) {
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			linkController = new ResultManager6();
			this.outputTable = linkController.resultList(this.title,this.series);
		}
		this.delete = "true";
		return "success";
	}

	public String printall() {
		this.do_search = "true";
		allController = new LikeManager();
		this.outputTable = allController.resultList();
		this.delete = "true";
		return "success";
	}

	public String update() {
		this.sessionMap.put("update_id", this.update_id);

		try {
			this.response.sendRedirect("/PC2015/update6.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
}
