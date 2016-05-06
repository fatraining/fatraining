package training2016.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.CatcafeDao;
import training2016.model.Catarea;

@Result(name = "catcafeSearch", value = "catcafeSearch.action", type = ServletRedirectResult.class)
public class CatcafeUpdateAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	private String title = "猫カフェ追加";

	private Map<String, String> prefectureMap = new HashMap<String, String>();
	private String ID;
	private String prefectureID;
	private String station;
	private String catcafeName;
	private String hours;
	private String closed;
	private String comment;
	private String errorMessage;
	private String message;
	private String delete;

	private boolean isEmptyParam(String param){
		return StringUtils.isEmpty(param);
	}

	/**イニシャライズ**/
	{
		this.setPrefectureMap();
	}

	/**プルダウン**/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			prefectureMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				Catarea catarea = (Catarea) resultTable.get(i);
				prefectureMap.put(catarea.getID(), catarea.getPrefecture());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prefectureMap;
	}

	/**削除**/
	public String execute() throws Exception {
		this.delete = (String) this.sessionMap.get("deleteID");
		return "success";
	}

	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteID");
		CatcafeDao dao = new CatcafeDao();
		dao.delete(this.delete);
		this.message = "削除が完了しました";
		this.sessionMap.put("message", this.message);
		return "catcafeSearch";
	}

	/**追加**/
	public String insert() {

		if(this.isEmptyParam(prefectureID)) {
			addActionError("都道府県名が未入力です");
		}
		if(this.isEmptyParam(station)) {
			addActionError("駅名が未入力です");
		}
		if(this.isEmptyParam(catcafeName)) {
			addActionError("店名が未入力です");
		}
		if(this.isEmptyParam(hours)) {
			addActionError("営業時間が未入力です");
		}
		if(this.isEmptyParam(closed)) {
			addActionError("定休日が未入力です");
		}
		// 一つでもエラーがあればだめええええ
		if (this.getActionErrors().size() > 0) {
			return "error";
		}

		CatcafeDao insert = new CatcafeDao();
		insert.insert(this.ID,
				this.prefectureID,
				this.station,
				this.catcafeName,
				this.hours,
				this.closed,
				this.comment);

		this.message = "登録しました";
		this.sessionMap.put("message", this.message);
		return "catcafeSearch";
	}

	/**getとset**/
	public String getTitle(){
		return title;
	}

	public Map<String, String> getPrefectureMap() {
		return prefectureMap;
	}

	public void setPrefectureMap() {
		CatcafeDao dao = new CatcafeDao();
		List<?> resultTable = dao.getCatareaList();
		this.prefectureMap = tableTrans(resultTable);
	}

	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}

	public String getPrefectureID() {
		return prefectureID;
	}
	public void setPrefectureID(String prefectureID) {
		this.prefectureID = prefectureID;
	}

	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}

	public String getCatcafeName() {
		return catcafeName;
	}
	public void setCatcafeName(String catcafeName) {
		this.catcafeName = catcafeName;
	}

	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getClosed() {
		return closed;
	}
	public void setClosed(String closed) {
		this.closed = closed;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
