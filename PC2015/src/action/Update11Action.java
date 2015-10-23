package action;

import java.util.Map;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.StaffDao;

@Result(name = "main11", value = "main11.action", type = ServletRedirectResult.class)
public class Update11Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	/**
	 * 追加画面の名前
	 */
	public String sName;
	/**
	 * 追加画面の都道府県(住所)
	 */
	public String sPrefecture;
	/**
	 * 追加画面の電話番号
	 */
	public String sPhonenumber;
	/**
	 * 追加画面の所属会社名
	 */
	public String cName;
	/**
	 * 追加画面の所属会社都道府県(住所）
	 */
	public String cPrefecture;
	/**
	 * 追加画面の所属会社電話番号
	 */
	public String cPhonenumber;
	/**
	 * 追加画面or削除画面表示フラグ
	 * （削除する行のIDを格納）
	 */
	public String delete_id;
	/**
	 * 表示するエラーメッセージ
	 */
	public String errormsg;
	
	/**
	 * update11.actionアクセス時の処理<br>
	 * 追加画面か削除画面のどちらを表示するかを選択して表示
	 */
	public String execute() throws Exception {
		this.delete_id = (String)this.sessionMap.get("delete_id");
		
//		Map<Integer, String> lockMap = (Map) this.sessionMap.get("lockMap");
		
		return "success";
	}
	/**
	 * 追加画面での追加ボタンの処理
	 */
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
		insert.insert(this.sName, this.sPrefecture, this.sPhonenumber, this.cName,
				this.cPrefecture, this.cPhonenumber,registeredPerson, updateBy);

		return "main11";
	}
	
	/**
	 * 削除画面での削除ボタンの処理
	 */
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		Map<Integer, String> lockMap = (Map) this.sessionMap.get("lockMap");
		
		StaffDao delete = new StaffDao();
		
//		delete.delete(this.delete_id);修正
		
		delete.delete(delete_id,lockMap);
		
		return "main11";
	}
	
	
}

