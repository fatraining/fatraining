package training2016.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.BaseballDao;
import training2016.model.BaseballTeam;

@Result(name = "baseballSearch", value = "baseballSearch.action", type = ServletRedirectResult.class)
public class BaseballUpdateAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	private String title = "新規データ登録";

	private Map<String, String> teamMap = new LinkedHashMap<String, String>();
	private String ID;
	private String teamID;
	private String baseballPlayer;
	private String target;
	private String date;
	private String comment;
	private String note;
	private String errorMessage;
	private String message;
	private String delete;

	private boolean isEmptyParam(String param){
		return StringUtils.isEmpty(param);
	}

	/**イニシャライズ**/
	{
		this.setTeamMap();
	}

	/**プルダウン**/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			teamMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				BaseballTeam baseballteam = (BaseballTeam) resultTable.get(i);
				teamMap.put(baseballteam.getID(), baseballteam.getTeam());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teamMap;
	}

	/**削除**/
	public String execute() throws Exception {
		this.delete = (String) this.sessionMap.get("deleteID");
		return "success";
	}

	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteID");
		BaseballDao dao = new BaseballDao();
		dao.delete(this.delete);
		this.message = "削除が完了しました";
		this.sessionMap.put("message", this.message);
		return "baseballSearch";
	}

	/**追加**/
	public String insert() {
		if(this.isEmptyParam(teamID)) {
			addActionError("球団名が未入力です");
		}
		if(this.isEmptyParam(baseballPlayer)) {
			addActionError("発言者名が未入力です");
		}
		if(this.isEmptyParam(comment)) {
			addActionError("語録が未入力です");
		}
		if (this.getActionErrors().size() > 0) {
			return "error";
		}
		if (comment.indexOf("\r\n") != -1) { //booleanを判定（戻り値が-1でないなら…）
			this.comment = this.comment.replaceAll("\r\n", "<br/>");
		}

		BaseballDao insert = new BaseballDao();
		insert.insert(
				this.ID,
				this.teamID,
				this.baseballPlayer,
				this.comment,
				this.target,
				this.date,
				this.note);

		this.message = "登録しました";
		this.sessionMap.put("message", this.message);
		return "baseballSearch";
	}

	/**getとset**/
	public String getTitle(){
		return title;
	}

	public Map<String, String> getTeamMap() {
		return teamMap;
	}

	public void setTeamMap() {
		BaseballDao dao = new BaseballDao();
		List<?> resultTable = dao.getBaseballTeamList();
		this.teamMap = tableTrans(resultTable);
	}

	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}

	public String getTeamID() {
		return teamID;
	}
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public String getBaseballPlayer() {
		return baseballPlayer;
	}
	public void setBaseballPlayer(String baseballPlayer) {
		this.baseballPlayer = baseballPlayer;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}

}
