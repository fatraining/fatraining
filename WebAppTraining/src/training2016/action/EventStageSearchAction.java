package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.EventStageDao;
import training2016.model.EventArea;
import training2016.model.EventStage;

@Results({
	@Result(name = "update", value ="eventUpdate.action",type = ServletRedirectResult.class),
	@Result(name = "delete", value ="eventDelete.action",type = ServletRedirectResult.class)})
public class EventStageSearchAction  extends AbstractAction{
	private static final long serialVersionUID = 1L;

		private String title = "リリイベ会場検索";

/**ブラウザからの入力項目*/

		private String area;
		private String record;
		private String name;
		private String delete;
		private String updateId;

//エリアプルダウン用マップ
		private Map<String,String> eventAreaMap = new LinkedHashMap<String,String>();
//レコード店プルダウン用マップ
		private Map<String, String> recordMap = new LinkedHashMap<String, String>();
//検索リストをテーブルに
		public ArrayList<EventStage>eventStageTable = new ArrayList<EventStage>();

//ユーザ名
		public String getUserID() {
			return (String) this.sessionMap.get("userId");
		}
		public String getMessage() {
			return (String) this.sessionMap.get("message");
		}


//初期値
		private String getDefaultArea() {		return "";		}
		private String getDefaultRecord() {	return "";		}
		private String getDefaultName() {		return "";		}


//execute
	@Override
	  public String execute() {
		this.area = getDefaultArea();
		this.record = getDefaultRecord();
		this.name =  getDefaultName();
		this.setEventAreaMap();
		this.setRecordMap();
		return "success";
	}
//リセット
	  public String reset () {
		this.area = getDefaultArea();
		this.record = getDefaultRecord();
		this.name = getDefaultName();
		this.sessionMap.put("message", null);
		this.setEventAreaMap();
		this.setRecordMap();
		return "success";
	}

//検索
	public String search() {
		EventStageDao dao = new EventStageDao();
		List<?> resultTable  = null;
		if (StringUtils.isEmpty(area) &&
			StringUtils.isEmpty(record) &&
			StringUtils.isEmpty(name)) {
		resultTable = dao.resultList();
		} else {
			area = this.area.trim();
			record = this.record.trim();
			name = this.name.trim();
			resultTable = dao.resultList(area, record, name);
		}
		this.sessionMap.put("message", null);
		this.eventStageTable.addAll(resultTrans(resultTable));
		this.setEventAreaMap();
		this.setRecordMap();
		return "success";
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

//追加
	public String update(){
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("eventStageUpdate.action"); //追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

//削除 deleteに飛ばす
	public String delete() {
		this.sessionMap.put("deleteID", this.delete);
		if (delete == null) {
			addActionError("削除するデータを選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("eventStageDelete.action"); //削除画面へ
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

//getter / setter
/** @return */
	public String getTitle() {
		return title;
	}
/** @return */
	public String getArea() {
		return area;
	}
/** @param */
	public void setArea(String area) {
		this.area = area;
	}
/** @return */
	public String getRecord() {
		return record;
	}
/** @param */
	public void setRecord(String record) {
		this.record = record;
	}
/** @return */
	public String getName() {
		return name;
	}
/** @param */
	public void setName(String name) {
		this.name = name;
	}
/** @return */
	public String getDelete() {
		return delete;
	}
/** @param */
	public void setDelete(String delete) {
		this.delete = delete;
	}
/** @return */
	public String getUpdateId() {
		return this.updateId;
	}
/** @param */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}



/**	@return eventAreaMap	 */
//エリアマップ
	public Map<String, String> getEventAreaMap(){
			return this.eventAreaMap;
		}

//エリアプルダウン用マップ
	public void setEventAreaMap() {
		EventStageDao dao = new EventStageDao();
		List<?> resultTable = dao.getEventAreaList();
		this.eventAreaMap = tableTrans(resultTable);
	}

/**	@return recordMap	 */
//レコード店マップ
	public Map<String, String> getRecordMap() {
		return this.recordMap;
	}

//レコードプルダウン用マップ
	public void setRecordMap() {
		this.recordMap.put("", "すべて");
		this.recordMap.put("HMV", "HMV");
		this.recordMap.put("TW", "タワーレコード");
		this.recordMap.put("SN", "新星堂");
		this.recordMap.put("etc", "その他");

	}


/*------------------------------------------------------*/
// エリアプルダウン用マップを返す //
/*------------------------------------------------------*/
public Map<String, String> tableTrans(List<?> resultTable) {
//	Map<String, String> tempMap = new LinkedHashMap<String, String>();
	eventAreaMap.put("", "すべて");
	try {
		for (int i = 0; i < resultTable.size(); i++) {
			EventArea area = (EventArea) resultTable.get(i);
			eventAreaMap.put(area.getId(), area.getArea());
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return eventAreaMap;
}

}
