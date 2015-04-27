package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Result5Table;
import controller.Result5Manager;
import controller.User_ProfileManager;

public class Main5Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String dwelling;
	public String name;
	public String result;
	public String do_search;
	public String update_id;
	public String delete;

	private Result5Manager linkController;
	private User_ProfileManager allController;
	public ArrayList<Result5Table> outputTable;

	private String getDefaultDwelling() {
		this.dwelling = "";
		return this.dwelling;
	}

	private String getDefaultName() {
		this.name = "";
		return this.name;
	}

	@Override
	public String execute() {
		this.dwelling = getDefaultDwelling();
		this.name = getDefaultName();
		this.delete = "faluse";
		return "success";
	}

	public String reset() {
		this.dwelling = getDefaultDwelling();
		this.name = getDefaultName();
		return "success";
	}

	public String search() {

		this.do_search = "true";
		if (this.dwelling.isEmpty() && this.name.isEmpty()) {
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			linkController = new Result5Manager();
			this.outputTable = linkController.resultList(this.dwelling,
					this.name);
		}
		this.delete = "true";
		return "success";
	}

	public String printall() {
		this.do_search = "true";
		allController = new User_ProfileManager();
		this.outputTable = allController.resultList();
		this.delete = "true";
		return "success";
	}

	public String update() {
		this.sessionMap.put("update_id", this.update_id);

		try {
			this.response.sendRedirect("/PC2015/update5.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
}