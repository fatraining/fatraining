package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.StaffDao;
import dao.StaffDao;

@Result(name = "main11", value = "main11.action", type = ServletRedirectResult.class)
public class Update11Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	
	public String sName;
	public String sPrefecture;
	public String sPhonenumber;
	public String cName;
	public String cPrefecture;
	public String cPhonenumber;
	
	public String delete_id;
	public String errormsg;
	
	
	public String execute() throws Exception {
		this.delete_id = (String)this.sessionMap.get("delete_id");
		return "success";
	}
	
	public String insert() {
		if (this.sName.isEmpty() && this.sPrefecture.isEmpty()
				&& this.sPhonenumber.isEmpty() && this.cName.isEmpty()
				&& this.cPrefecture.isEmpty() && this.cPhonenumber.isEmpty()) {
			this.errormsg = "未入力は登録できません";
			return "errormsg";
		}

		String registeredPerson = (String) this.sessionMap.get("userId");
		String updateBy = (String) this.sessionMap.get("userId");

		StaffDao insert = new StaffDao();
		// 　引数として値を取得し表示する
		insert.insert(this.sName, this.sPrefecture, this.sPhonenumber, this.cName,
				this.cPrefecture, this.cPhonenumber,registeredPerson, updateBy);

		return "main11";
	}
	
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		StaffDao delete = new StaffDao();
		// 　引数として値を取得し表示する
		delete.delete(this.delete_id);
		return "main11";
	}
	
	
}

