package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.EventStageDao;
import training2016.model.EventArea;
import training2016.model.EventStage;

@Result(name = "EventStageSearch", value = "eventStageSearch.action",
type = ServletRedirectResult.class)
public class EventStageDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	private String title = "リリイベ会場検索";

	private String delete;
	private String message;

//検索リストをテーブルに
		public ArrayList<EventStage>eventStageTable = new ArrayList<EventStage>();

//ユーザ名
		public String getUserID() {
			return (String) this.sessionMap.get("userId");
		}

//テーブル
	public ArrayList<EventStage> resultTrans(List<?> resultTable) {
		ArrayList<EventStage> tempTable = new ArrayList<EventStage>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				EventStage temp = new EventStage();
				obj = (Object[]) resultTable.get(i);
				EventArea a = (EventArea) obj[0];
				EventStage s = (EventStage) obj[1];
				temp.setID(s.getID());
				temp.setAreaID(s.getAreaID());
				temp.setArea(a.getArea());
				temp.setName(s.getName());
				temp.setStation(s.getStation());
				temp.setRecord(s.getRecord());
				temp.setComment(s.getComment());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

//削除するデータを表示
	@Override
	public String execute() throws Exception {
		this.delete = (String) this.sessionMap.get("deleteID");
		String[] deleteId = this.delete.split(" , ");
		EventStageDao dao = new EventStageDao();
		List<?> resultTable = dao.selectForDelete(deleteId);
		this.eventStageTable.addAll(resultTrans(resultTable));
		return "success";
	}

//削除メソッド
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteID");
		EventStageDao dao = new EventStageDao();
		dao.delete(this.delete);
		this.message = "削除しました";
		this.sessionMap.put("message", this.message);
		return "EventStageSearch";
	}


//getter setter

	public String getTitle() {
		return this.title;
	}

	public List<EventStage> getEventStageTable() {
		return this.eventStageTable;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getDelete() {
		return this.delete;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage1() {
		return this.message;
	}

}
