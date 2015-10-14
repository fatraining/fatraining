package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.SportDao;
import model.Registration_Name;
import model.Result12Table;
import model.Sport_Event;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

@Result(name = "update12", value = "update12.action", type = ServletRedirectResult.class)
public class Main12Action extends AbstractAction {

	private static final long serialVersionUID = 1L;
	// 入力項目
	public String competition_number; // 競技番号
	public String registration_number; // 登録番号
	public String name;
	public String sport;

	public String delete;
	public String do_search;
	public String errormsg;
	public String delete_id;

	public ArrayList<Result12Table> outputTable;

	// 初期値の設定
	private String getDefaultCompetition_number() {
		return "";
	}

	// 初期値の設定
	private String getDefaultRegistration_number() {
		return "";
	}

	// 初期値の設定
	private String getDefaultName() {
		return "";
	}

	// executeメソッド
	@Override
	public String execute() {
		this.competition_number = getDefaultCompetition_number();
		this.registration_number = getDefaultRegistration_number();
		this.competition_number = getDefaultName();
		this.delete = "false";
		return "success";
	}

	// resetメソッド
	public String reset() {
		this.competition_number = getDefaultCompetition_number();
		this.registration_number = getDefaultRegistration_number();
		this.competition_number = getDefaultName();
		return "success";
	}

	// 検索ボタンを押したとき
	public String search() {

		// インスタンス化
		SportDao sport = new SportDao();
		List<?> resultTable;

		if (StringUtils.isEmpty(this.competition_number) && StringUtils.isEmpty(this.registration_number)
				&& StringUtils.isEmpty(this.name) && StringUtils.isEmpty(this.sport)) {
			resultTable = sport.resultList();
		} else {
			resultTable = sport.resultList(this.competition_number, this.registration_number, this.name, this.sport);
		}
		this.outputTable = tableTrans(resultTable);

		this.do_search = "true";
		this.delete = "true";
		return "success";
	}

	// 追加ボタンを押したとき
	// updateメソッド
	public String update() {
		this.sessionMap.put("delete_id", null);

		try {
			this.response.sendRedirect("/PC2015/update12.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// 削除ボタンを押したとき
	// delete_idメソッド
	public String delete_id() {

		this.sessionMap.put("delete_id", this.delete_id);

		if (this.delete_id == null) {
			SportDao sport = new SportDao();
			this.competition_number = (String) this.sessionMap.get("competition_number");
			this.registration_number = (String) this.sessionMap.get("registration_number");
			List<?> resultTable;

			if (StringUtils.isEmpty(this.competition_number) && StringUtils.isEmpty(this.registration_number)
					&& StringUtils.isEmpty(this.name) && StringUtils.isEmpty(this.sport)) {
				resultTable = sport.resultList();
			} else {
				resultTable = sport.resultList(this.competition_number, this.registration_number, this.name,
						this.sport);
			}
			this.outputTable = tableTrans(resultTable);

			this.do_search = "true";
			this.delete = "true";
			this.errormsg = "true";
			return "success";
		}

		try {
			this.response.sendRedirect("/PC2015/update12.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	public String getCompetition_number() {
		return competition_number;
	}

	public void setCompetition_number(String competition_number) {
		this.competition_number = competition_number;
	}

	public String getRegistration_number() {
		return registration_number;
	}

	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getDo_search() {
		return do_search;
	}

	public void setDo_search(String do_search) {
		this.do_search = do_search;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getDelete_id() {
		return delete_id;
	}

	public void setDelete_id(String delete_id) {
		this.delete_id = delete_id;
	}

	public ArrayList<Result12Table> getOutputTable() {
		return outputTable;
	}

	public void setOutputTable(ArrayList<Result12Table> outputTable) {
		this.outputTable = outputTable;
	}

	private ArrayList<Result12Table> tableTrans(List<?> resultTable) {
		ArrayList<Result12Table> tempTable = new ArrayList<Result12Table>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result12Table temp = new Result12Table();
				obj = (Object[]) resultTable.get(i);
				Sport_Event sport_event = (Sport_Event) obj[1];
				Registration_Name registration_name = (Registration_Name) obj[0];

				temp.setRegistration_number(registration_name.getRegistration_number());
				temp.setCompetition_number(sport_event.getCompetition_number());
				temp.setName(registration_name.getName());
				temp.setSport(sport_event.getSport());
				temp.setId(registration_name.getId());

				tempTable.add(temp);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}

}
