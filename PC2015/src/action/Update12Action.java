package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import dao.SportDao;

@Result(name = "main12", value = "main12.action", type = ServletRedirectResult.class)
public class Update12Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	// 追加画面時の入力項目
	public String competition_number; // 競技番号
	public String registration_number; // 登録番号
	public String name; // 氏名
	public String sport;
	// エラー表示
	public String errormsg;
	// 削除画面時の表示項目
	public String delete_id;

	
	public String execute() throws Exception {

		// Main12Actionのdelete_idを呼び出し
		this.delete_id = (String) this.sessionMap.get("delete_id");

		return "success";
	}
// 追加ボタンを押したとき
	
	public String insert() {
		// 未入力の項目があるときにエラーを返す
		if (this.competition_number.isEmpty() || this.registration_number.isEmpty() || this.name.isEmpty()) {
			this.errormsg = "全項目入力してください。";
			
			
			return "errormsg";
		}
		String registered_person = (String) this.sessionMap.get("registered_person");
		String update_by = (String) this.sessionMap.get("update_by");

		// インスタンス化
		SportDao insert = new SportDao();

		// SportDaoのinsertメソッドを参照
		insert.insert(this.competition_number, this.registration_number,this.sport, this.name
				, registered_person, update_by);

		return "main12";
	}

	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		// インスタンス化
		SportDao delete = new SportDao();

		// deleteのdeleteメソッドを参照
		delete.delete(this.delete_id);

		return "main12";
	}
}
