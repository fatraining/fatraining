package action;

import java.io.IOException;
import java.util.ArrayList;

import action.AbstractAction;
import controller.ProfileManager;
import controller.Result1Manager;
import model.Result1Table;

public class Main1Action extends AbstractAction {

	private static final long serialVersionUID = 1L;
//テーブルで作ったカラム　検索画面にて検索をかけたいカラム名
	public String name; //String型の変数はname
	public String home; //String型の変数はhome
	public String hobby; //String型の変数はhobby
//メソッドを起こすための変数？	
	public String result;
	public String do_search;
	public String update_id;
	public String delete;
	public String errormsg;

	private Result1Manager linkController;
	private ProfileManager allController;
	public ArrayList<Result1Table> outputTable;
//変数に値を代入
	private String getDefaultName() {
		this.name = "";
		return this.name;
	}

	private String getDefaultHome() {
		this.home = "";
		return this.home;
	}

	private String getDefaultHobby() {
		this.hobby = "";
		return this.hobby;
	}
//execute
	@Override
	public String execute() {
		this.name = getDefaultName();
		this.home = getDefaultHome();
		this.hobby = getDefaultHobby();
		this.delete = "faluse";
		return "success";
	}
//resetメソッド
	public String reset() {
		this.name = getDefaultName();
		this.home = getDefaultHome();
		this.hobby = getDefaultHobby();
		return "success";
	}
//searchメソッド
	public String search() {

		this.do_search = "true";
		if (this.name.isEmpty() && this.home.isEmpty() && this.hobby.isEmpty()) {
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			linkController = new Result1Manager();
			this.outputTable = linkController.resultList(this.name, this.home,
					this.hobby);
		}
		this.delete = "true";
		return "success";
	}
//printallメソッド
	public String printall() {
		this.do_search = "true";
		allController = new ProfileManager();
		this.outputTable = allController.resultList();
		this.delete = "true";
		return "success";
	}
//updateメソッド
	public String update() {
		this.sessionMap.put("update_id", this.update_id);

		try {
			this.response.sendRedirect("/PC2015/update1.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
}