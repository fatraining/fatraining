package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Result5Table;
import controller.Result5Manager;
import controller.User_ProfileManager;

public class Main5Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	// 表示させるカラム名
	// public String user_name;
	public String dwelling;
	public String name;

	//検索結果の変数
	public String do_search;
	public String update_id;
	//削除ボタンの変数
	public String delete;

	//検索結果の表示
	private Result5Manager linkController;
	private User_ProfileManager allController;
	public ArrayList<Result5Table> outputTable;
	
	public List<?> resultTable;


	// 郵便番号の変数に値を代入(空白)
	private String getDefaultDwelling() {
		this.dwelling = "";
		return this.dwelling;
	}

	// 名前の変数に値を代入(空白)
	private String getDefaultName() {
		this.name = "";
		return this.name;
	}

	@Override
	public String execute() {
		// user_nameを表示させる為にsessionMapから呼び出している
		// this.user_name = (String) this.sessionMap.get("user_name");

		this.dwelling = getDefaultDwelling();
		this.name = getDefaultName();

		// 削除ボタン
		this.delete = "faluse";
		return "success";
	}

	// リセットメソッド 値を表示させないようにする為、getDefaultDwellingとgetDefaultNameを代入
	public String reset() {
		// this.user_name = (String) this.sessionMap.get("user_name");
		this.dwelling = getDefaultDwelling();
		this.name = getDefaultName();
		return "success";
	}

	// 検索メソッド
	public String search() {

		this.do_search = "true";
		// this.user_name = (String) this.sessionMap.get("user_name");
		//入力した値が空だった場合、値を全て表示させる
		if (this.dwelling.isEmpty() && this.name.isEmpty()) {
			//
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//入力した値が空ではない場合、Result5Manager内のdwellingとnameを表示させる
			Result5Manager linkController = new Result5Manager();
			this.outputTable = linkController.resultList(this.dwelling,
					this.name);
		}
		//削除ボタンの表示
		this.delete = "true";
		return "success";
	}

	public String printall() {
		//検索結果の表示
		this.do_search = "true";
		allController = new User_ProfileManager();
		this.outputTable = allController.resultList();
		//削除ボタンの表示
		this.delete = "true";
		return "success";
	}

	public String update() {
		this.sessionMap.put("update_id", this.update_id);

		try {
			//update5Actionに進む
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