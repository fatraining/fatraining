package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.KaisyaDao;

@Result(name = "kaisyaSearch", value = "kaisyaSearch.action", type = ServletRedirectResult.class)
public class KaisyaAddAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// テーブルで作ったカラム　追加画面にて検索をかけたいカラム名
	public String syamei;
	public String name;
	public String nyusyabi;
	public String busyo;
	public String comment;
	// メソッドを起こすための変数
	public String delete_id;
	public String errormsg;

	// executeメソッド
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		this.nyusyabi = "年月日";
		return "success";
	}

	// insertメソッド
	public String insert() {
		if (this.syamei.isEmpty() && this.name.isEmpty()
				&& this.busyo.isEmpty() && this.comment.isEmpty()) {
			this.errormsg = "未入力は登録できません";
			return "errormsg";
		}

		String userId = (String) this.sessionMap.get("userId");
		String userId_up = (String) this.sessionMap.get("userId");

		KaisyaDao insert = new KaisyaDao();
		// 引数として値を取得し表示する
		insert.insert(this.syamei, this.name, this.nyusyabi, this.busyo,
				this.comment, userId, userId_up);

		return "kaisyaSearch";
	}

	// deleteメソッド
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		KaisyaDao delete = new KaisyaDao();
		// 引数として値を取得し表示する
		delete.delete(this.delete_id);
		return "kaisyaSearch";
	}
}