package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import controller.LiofTaManager;

@Result(name = "main9", value = "main9.action", type = ServletRedirectResult.class)
public class Update9Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	// カラム名
	public String name;
	public String food;
	public String drink;
	public String color;
	public String colorNm;
	public String delete_id;

	// executeメソッド
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド（挿入）
	public String insert() {
		String userid = (String) this.sessionMap.get("userId");
		String new_userid = (String) this.sessionMap.get("userId");

		// インスタンス化
		LiofTaManager insert = new LiofTaManager();

		// LiofTaManagerのinsertメソッドを参照
		insert.insert(this.name, this.food, this.drink, this.color,
				this.colorNm, userid, new_userid);

		return "main9";

	}

	// deleteメソッド
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		// インスタンス化
		LiofTaManager delete = new LiofTaManager();

		// LiofTaManagerのdeleteメソッドを参照
		delete.delete(this.delete_id);

		return "main9";
	}
}
