package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Result2Table;
import controller.Result2Manager;
import controller.SweetsManager;

public class Main2Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String id;
	public String name;
	public String genreNm;
	public String record_date;
	public String reset_date;
	public String entry_userId;
	public String record_userId;
	public String exclusive_FLG;
	public String delete_FLG;
	public String update_id;
	public String do_search;

	private Result2Manager linkController;
	private SweetsManager allController;
	public ArrayList<Result2Table> outputTable;

	private String getDefaultName() {
		this.name = "";
		return this.name;
	}

	private String getDefaultGenreNm() {
		this.genreNm = "";
		return this.genreNm;
	}

	@Override
	public String execute() {
		this.id = (String) this.sessionMap.get("id");
		this.name = getDefaultName();
		this.genreNm = getDefaultGenreNm();

		return "success";
	}

	public String reset() {
		this.name = getDefaultName();
		this.genreNm = getDefaultGenreNm();

		return "success";
	}

	public String search() {

		this.do_search = "true";
		printall();
		this.id = (String) this.sessionMap.get("id");
		if (this.genreNm.isEmpty()&& this.name.isEmpty()) {
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			linkController = new Result2Manager();
			this.outputTable = linkController.resultList(this.genreNm, this.name);
		}
		this.delete_FLG = "true";
		return "success";
	}

	public String printall() {
		this.do_search = "true";
		this.id = (String) this.sessionMap.get("id");
		allController = new SweetsManager();
		this.outputTable = allController.resultList(this.genreNm, this.name);
		this.delete_FLG = "true";
		return "success";
	}
	public String update(){
		this.sessionMap.put("update_id",this.update_id);

		try {
			this.response.sendRedirect("/PC2015/update.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
}
