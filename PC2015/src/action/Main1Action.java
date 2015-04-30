package action;

import java.io.IOException;
import java.util.ArrayList;

import controller.ProfileManager;
import controller.Result1Manager;
import model.Result1Table;

public class Main1Action extends AbstractAction {

	private static final long serialVersionUID = 1L;
	// テーブルで作ったカラム　検索画面にて検索をかけたいカラム名
	public String name;
	public String home;
	public String hobby;
	// メソッドを起こすための変数
	public String delete_id;
	public String do_search;
	public String delete;
	// 使用する場所が違うソース　検索結果(サーバーのテーブルの内容)表示に必要
	public ArrayList<Result1Table> outputTable;

	// 変数に値を代入
	private String getDefaultName() {
		return "";
	}

	private String getDefaultHome() {
		return "";
	}

	private String getDefaultHobby() {
		return "";
	}

	// executeメソッド　メソッドが呼ばれたとき変数に代入した値が表示
	@Override
	public String execute() {
		this.name = getDefaultName();
		this.home = getDefaultHome();
		this.hobby = getDefaultHobby();
		this.delete = "faluse";// ボタンの役割　表示はされない
		return "success";
	}

	// resetメソッド　メソッドが呼ばれたとき最初の状態にする。(executeメソッドが呼ばれた時の状態)
	public String reset() {
		this.name = getDefaultName();
		this.home = getDefaultHome();
		this.hobby = getDefaultHobby();
		return "success";
	}

	// searchメソッド
	private String search() {
		if (this.name.isEmpty() && this.home.isEmpty() && this.hobby.isEmpty()) {
			try {
				ProfileManager allController = new ProfileManager();
				this.outputTable = allController.resultList();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Result1Manager linkController = new Result1Manager();// インスタンス化
			this.outputTable = linkController.resultList(this.name, this.home,
					this.hobby);
		}
		this.do_search = "true";
		this.delete = "true";
		return "success";
	}

	// delete_idメソッド
	public String update() {
		this.sessionMap.put("delete_id", this.delete_id);

		try {
			this.response.sendRedirect("/PC2015/update1.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
}