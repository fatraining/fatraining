package action;

import java.io.IOException;
import java.util.ArrayList;

import model.ResultTable;
import controller.User_ProfileManager;
import controller.ResultManager;

public class Main5Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

//	public String user_name;
	public String dwelling;
	public String name;
	public String result;
	public String do_print;
	public String update_id;
	public String delete;

	private ResultManager linkController;
	private User_ProfileManager allController;
	public ArrayList<ResultTable> outputTable;

	private String getDefaultDwelling() {
		this.dwelling = "千葉";
		return this.dwelling;
	}

	private String getDefaultName() {
		this.name = "田中";
		return this.name;
	}

	@Override
	public String execute() {
//		this.user_name = (String) this.sessionMap.get("user_name");

		this.dwelling = getDefaultDwelling();
		this.name = getDefaultName();
		this.delete = "faluse";
		return "success";
	}

	public String reset() {
//		this.user_name = (String) this.sessionMap.get("user_name");
		this.dwelling = getDefaultDwelling();
		this.name = getDefaultName();
		return "success";
	}

	public String search() {

		// this.dwelling = checkcode(this.dwelling);
		// this.name = checkcode(this.name);

		this.do_print = "true";
//		this.user_name = (String) this.sessionMap.get("user_name");
		if (this.dwelling.isEmpty() && this.name.isEmpty()) {
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			linkController = new ResultManager();
			this.outputTable = linkController.resultList(this.dwelling,
					this.name);
		}
		this.delete = "true";
		return "success";
	}

	public String printall() {
		this.do_print = "true";
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

	// public String checkcode(String code) {
	// String r = "[a-zA-Z0-9]{0,50}";
	// if (code.matches(r)) {
	// return code;
	// }
	// return "";
	// }
}