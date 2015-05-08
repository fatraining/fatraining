package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import controller.ProfileManager;

@Result(name = "main1", value = "main1.action", type = ServletRedirectResult.class)
public class Update1Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// テーブルで作ったカラム　追加画面にて検索をかけたいカラム名
	public String name;
	public String personality;
	public String home;
	public int birthday;
	public int hobby_id;
	public String hobby;
	// メソッドを起こすための変数
	public String delete_id;

	// executeメソッド
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド
	public String insert() {

		String userid = (String) this.sessionMap.get("userId");
		String new_userid = (String) this.sessionMap.get("userId");

		ProfileManager insert = new ProfileManager();
		insert.insert(this.hobby, this.name, this.personality, this.home,
				this.birthday, userid, new_userid);

		return "main1";
	}

	// deleteメソッド
	// 検索結果の内容を削除のため
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		
		ProfileManager delete = new ProfileManager();
		
		delete.delete(this.delete_id);
		return "main1";
	}
}