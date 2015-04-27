package action;

import java.io.IOException;
import java.util.ArrayList;

import model.ResultTable6;
import controller.LikeManager;
import controller.Result6Manager;
import action.AbstractAction;

public class Main6Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String series;
	public String title;
	public String result;
	public String do_search;
	public String update_id;
	public String delete;

	private Result6Manager linkController;
	private LikeManager allController;
	public ArrayList<ResultTable6> outputTable;

	//検索画面
	//シリーズID
	private String getDefaultSeries() {
		this.series = "1";
		return this.series;
	}

	//タイトル
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
	
	//検索結果
	public String search() {
		this.do_search = "true";
		if (this.title.isEmpty() && this.series.isEmpty()) {
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			linkController = new Result6Manager();
			this.outputTable = linkController.resultList(this.title,this.series);
		}
		this.delete = "true";
		return "success";
	}

	//検索結果・表
	public String printall() {
		this.do_search = "true";
		allController = new LikeManager();
		this.outputTable = allController.resultList();
		this.delete = "true";
		return "success";
	}
	
    //削除
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
