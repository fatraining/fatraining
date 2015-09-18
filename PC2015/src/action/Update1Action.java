package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.ProfileDao;

@Result(name = "main1", value = "main1.action", type = ServletRedirectResult.class)
public class Update1Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// テーブルで作ったカラム　追加画面にて検索をかけたいカラム名
	public String name;
	public String personality;
	public String home;
	public String birthday;
	public String hobby;
	// メソッドを起こすための変数
	public String delete_id;
	public String errormsg;

	// executeメソッド
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド
	public String insert() {
		if (this.name.isEmpty() && this.personality.isEmpty()
				&& this.home.isEmpty() && this.hobby.isEmpty()) {
			this.errormsg = "未入力は登録できません";
			return "errormsg";
		}

		String userid = (String) this.sessionMap.get("userId");
		String new_userid = (String) this.sessionMap.get("userId");

		ProfileDao insert = new ProfileDao();
		// 　引数として値を取得し表示する
		insert.insert(this.hobby, this.name, this.personality, this.home,
				this.birthday, userid, new_userid);

		return "main1";
	}

	// deleteメソッド
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		ProfileDao delete = new ProfileDao();
		// 　引数として値を取得し表示する
		delete.delete(this.delete_id);
		return "main1";
	}
}