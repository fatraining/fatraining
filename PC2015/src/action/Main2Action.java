package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Result2Table;
import controller.Result2Manager;
import controller.SweetsManager;
import action.AbstractAction;

public class Main2Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	//カラム名
	public String id;
	public String name;
	public String genreNm;
	//変数
	public String update_id;
	public String do_search;
	public String delete;

	private Result2Manager linkController;
	private SweetsManager allController;
	public ArrayList<Result2Table> outputTable;
	
	//値を入れる
	private String getDefaultName() {
		this.name = "";
		return this.name;
	}

	private String getDefaultGenreNm() {
		this.genreNm = "";
		return this.genreNm;
	}
	
	//executeメソッド
	@Override
	public String execute() {
		this.id = (String) this.sessionMap.get("id");
		this.name = getDefaultName();
		this.genreNm = getDefaultGenreNm();
		this.delete = "faluse";
		return "success";
	}
	
	//resetメソッド
	//初期値に戻す
	public String reset() {
		this.id = (String) this.sessionMap.get("id");
		this.name = getDefaultName();
		this.genreNm = getDefaultGenreNm();
		return "success";
	}
	
	//searchメソッド
	public String search() {

		this.do_search = "true";
		
		this.id = (String) this.sessionMap.get("id");
		if (this.genreNm.isEmpty() && this.name.isEmpty()) {
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			linkController = new Result2Manager();
//			Result2Manager linkController = new Result2Manager();
			this.outputTable = linkController.resultList(this.name, this.genreNm);
		}
		this.delete = "true";
		return "success";
	}
	
	//printallメソッド
	public String printall() {
		this.do_search = "true";
//		this.id = (String)this.sessionMap.get("id");
		allController = new SweetsManager();
		this.outputTable = allController.resultList(this.name, this.genreNm);
		this.delete = "true";
		return "success";
	}
	
	//updateメソッド
	public String update() {
		this.sessionMap.put("update_id", this.update_id);

		try {
			this.response.sendRedirect("/PC2015/update2.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
}