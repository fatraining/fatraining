package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Ryouri;
import model.Yasai;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import java.util.ArrayList;
import java.util.List;

import controller.YasaiManager;
import model.Result8Table;

@Result(name = "addyasai", value = "addyasai.action", type = ServletRedirectResult.class)
public class Main8Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String id;
	public String yasai;
	public int tyouriId;
	public String date_entry;
	public String date_up;
	public String userId;
	public String userId_up;
	public String control;
	public String delete;
	public String do_print;
	public String update_id;

	public ArrayList<Result8Table> outputTable;
	public List<?> resultTable;
	public List<?> resultTable2;

	private String getDefaultYasai() {
		this.yasai = "野菜";
		return this.yasai;
	}

	@Override
	public String execute() {
		this.userId = (String) this.sessionMap.get("userId");
		this.yasai = getDefaultYasai();
		// this.tyouriId = getDefaultTyouri();
		this.delete = "faluse";
		return "success";
	}

	public String reset() {
		this.userId = (String) this.sessionMap.get("userId");
		this.yasai = getDefaultYasai();
		// this.tyouriId = getDefaultTyouri();
		return "success";
	}

	public String search() {
		YasaiManager yasaimanager = new YasaiManager();
		this.userId = (String) this.sessionMap.get("userId");
		this.do_print = "true";
		if (this.yasai.isEmpty()) {
			try {
				resultTable = yasaimanager.resultList();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			resultTable = yasaimanager.resultList(yasai);
		}
		this.outputTable = tableTrans(resultTable);

		this.delete = "true";
		return "success";
	}

	public String update() {
		this.sessionMap.put("update_id", this.update_id);

		try {
			this.response.sendRedirect("/PC2015/addyasai.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String gotoaddyasai() {

		return "addyasai";
	}

	public ArrayList<Result8Table> tableTrans(List<?> resultTable) {
		ArrayList<Result8Table> tempTable = new ArrayList<Result8Table>();

		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result8Table temp = new Result8Table();

				obj = (Object[]) resultTable.get(i);
				Yasai yasai = (Yasai) obj[0];
				Ryouri ryouri = (Ryouri) obj[1];

				temp.setId(yasai.getId());
				temp.setYasai(yasai.getYasai());
				temp.setTyouriId(yasai.getTyouriId());
				temp.setDate_Entry(yasai.getDate_Entry());
				temp.setDate_Up(yasai.getDate_Up());
				temp.setUserId(yasai.getUserId());
				temp.setDate_Up(yasai.getUserId_Up());
				temp.setControl(yasai.getControl());
				temp.setDeleteFlg(yasai.getDeleteFlg());

				//int型をString型に変換
				temp.setId(String.valueOf(ryouri.getId()));
				temp.setTyouri(ryouri.getTyouri());
				temp.setRyouri(ryouri.getRyouri());
				temp.setDate_Entry(ryouri.getDate_Entry());
				temp.setDate_Up(ryouri.getDate_Up());
				temp.setUserId(ryouri.getUserId());
				temp.setDate_Up(ryouri.getUserId_Up());
				temp.setControl(ryouri.getControl());
				temp.setDeleteFlg(ryouri.getDeleteFlg());

				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}

}
