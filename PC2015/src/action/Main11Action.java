package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.StaffDao;
import model.Company;
import model.Result11Table;
import model.Staff;

public class Main11Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// 検索画面の各フィールドに対応するカラム名
	public String sName;
	public String prefecture;
	public String cName;

	public String delete_id;
	public String errormsg;
	public String do_search;
	public String delete;

	public ArrayList<Result11Table> outputTable;

	public String getDefaultSName() {
		return "";
	}

	public String getDefaultPrefecture() {
		return "";
	}

	public String getDefaultCName() {
		return "";
	}

	public String execute() {
		this.sName = getDefaultSName();
		this.prefecture = getDefaultPrefecture();
		this.cName = getDefaultCName();
		return "success";
	}

	public String reset() {
		this.sName = getDefaultSName();
		this.prefecture = getDefaultPrefecture();
		this.cName = getDefaultCName();
		return "success";
	}

	public String search() {
		 this.sessionMap.put("sName",this.sName);
		 this.sessionMap.put("prefecture",this.prefecture);
		 this.sessionMap.put("cName",this.cName);

		List<?> resultTable = null;
		StaffDao StaffController = new StaffDao();
		if (this.sName.isEmpty() && this.prefecture.isEmpty() && this.cName.isEmpty()) {
			resultTable = StaffController.searchResult();
		} else {
			resultTable = StaffController.searchResult(this.sName, this.prefecture, this.cName);
		}

		this.outputTable = tableTrans(resultTable);

		this.do_search = "true";
		this.delete = "true";
		return "success";
	}

	public String update() {
		this.sessionMap.put("delete_id", null);

		try {
			this.response.sendRedirect("/PC2015/update11.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	public String delete_id() {
		this.sessionMap.put("delete_id", this.delete_id);

		if (this.delete_id == null) {

			this.sName = (String) this.sessionMap.get("sName");
			this.prefecture = (String) this.sessionMap.get("prefecture");
			this.cName = (String) this.sessionMap.get("cName");

			List<?> resultTable = null;
			StaffDao StaffController = new StaffDao();
			if (this.sName.isEmpty() && this.prefecture.isEmpty() && this.cName.isEmpty()) {
				resultTable = StaffController.searchResult();
			} else {
				resultTable = StaffController.searchResult(this.sName, this.prefecture, this.cName);
			}

			this.outputTable = tableTrans(resultTable);
			this.errormsg = "true";
			this.do_search = "true";
			this.delete = "true";
			return "success";
		}
		try {
			this.response.sendRedirect("/PC2015/update11.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	private ArrayList<Result11Table> tableTrans(List<?> resultTable) {
		ArrayList<Result11Table> tempTable = new ArrayList<Result11Table>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result11Table temp = new Result11Table();
				obj = (Object[]) resultTable.get(i);
				Staff staff = (Staff) obj[0];
				Company company = (Company) obj[1];
				temp.setId(staff.getId());
				temp.setSName(staff.getName());
				temp.setSPrefecture(staff.getPrefecture());
				temp.setSPhonenumber(staff.getPhoneNumber());
				temp.setCName(company.getName());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

}
