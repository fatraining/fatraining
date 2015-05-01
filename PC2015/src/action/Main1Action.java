package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.ProfileManager;
import model.My_hobby;
import model.Profile;
import model.Result1Table;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

@Result(name = "update", value = "update.action", type = ServletRedirectResult.class)
public class Main1Action extends AbstractAction {

	private static final long serialVersionUID = 1L;
	// テーブルで作ったカラム　検索画面にて検索をかけたいカラム名
	//名前
	public String name;
	//出身地
	public String home;
	//趣味
	public String hobby;
	// メソッドを起こすための宣言
	public String delete_id;
	public String do_search;
	public String delete;

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
		this.delete = "false";
		return "success";
	}

	// resetメソッド　メソッドが呼ばれたとき最初の画面の状態にする
	public String reset() {
		this.name = getDefaultName();
		this.home = getDefaultHome();
		this.hobby = getDefaultHobby();
		return "success";
	}

	// searchメソッド
	public String search() {
		ProfileManager profileManager = new ProfileManager();
		List<?> resultTable;
		
		if (this.name.isEmpty() && this.home.isEmpty() && this.hobby.isEmpty()) {
				resultTable = profileManager.resultList();

		} else {
			resultTable = profileManager.resultList(this.name, this.home,
					this.hobby);
		}
		this.outputTable = tableTrans(resultTable);
		
		this.do_search = "true";
		this.delete = "true";
		return "success";
	}
	//updateメソッド
	public String update() {
		this.sessionMap.put("delete_id", null);

		try {
			this.response.sendRedirect("/PC2015/update1.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// delete_idメソッド
	public String delete_id() {
		this.sessionMap.put("delete_id", this.delete_id);

		try {
			this.response.sendRedirect("/PC2015/update1.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
	//検索結果時の値を表示
	public ArrayList<Result1Table> tableTrans(List<?> resultTable) {
		ArrayList<Result1Table> tempTable = new ArrayList<Result1Table>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result1Table temp = new Result1Table();
				obj = (Object[]) resultTable.get(i);
				My_hobby my_hobby = (My_hobby) obj[0];
				Profile profile = (Profile) obj[1];
				temp.setId(profile.getId());
				temp.setName(profile.getName());
				temp.setPersonality(profile.getPersonality());
				temp.setHome(profile.getHome());
				temp.setBirthday(profile.getBirthday());
				temp.setHobby(my_hobby.getHobby());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}