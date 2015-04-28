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
	public String name;
	public String home;
	public String hobby;
//メソッドを起こすための変数
	public String update_id;
	public String result;
	public String do_search;
	public String delete;
	public String errormsg;
//使用する場所が違うソース　検索結果(サーバーのテーブルの内容)表示に必要
	public Result1Manager linkController;
	public ProfileManager allController;
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
//executeメソッド　メソッドが呼ばれたとき変数に代入した値が表示
	@Override
	public String execute() {
		this.name = getDefaultName();
		this.home = getDefaultHome();
		this.hobby = getDefaultHobby();
		this.delete = "faluse";//ボタンの役割
		return "success";
	}
//resetメソッド　メソッドが呼ばれたとき最初の状態にする。(executeメソッドが呼ばれた時の状態)
	public String reset() {
		this.name = getDefaultName();
		this.home = getDefaultHome();
		this.hobby = getDefaultHobby();
		return "success";
	}
//searchメソッド
	public String search() {//検索をするための

		this.do_search = "true";//ボタンの役割
		if (this.name.isEmpty() && this.home.isEmpty() && this.hobby.isEmpty()) {
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
//linkController前にResult1Managerを追加
			Result1Manager linkController = new Result1Manager();//インスタンス化
			this.outputTable = linkController.resultList(this.name, this.home,
					this.hobby);
		}
		this.delete = "true";//ボタンの役割
		return "success";
	}
//printallメソッド
	public String printall() {//サーバーのテーブル内容を表示
		this.do_search = "true";//ボタンの役割
		allController = new ProfileManager();//インスタンス化
		this.outputTable = allController.resultList();
		this.delete = "true";//ボタンの役割
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