package training2016.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.EventStageDao;
import training2016.model.EventArea;
import training2016.model.EventStage;

@Result(name = "EventStageSearch", value = "eventStageSearch.action",
		type = ServletRedirectResult.class)

public class EventStageUpdateAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

//タイトル
	private String title;
//送信ボタン
	private String updateBtnTitle;

	private String ID;	//更新時のみ
	private String areaID;
	private String name;
	private String station;
	private String record;
	private String comment;
	private String errorMessage;
	private String message;



///エリアプルダウン用マップ
			private Map<String,String> eventAreaMap = new LinkedHashMap<String,String>();
//レコード店プルダウン用マップ
			private Map<String, String> recordMap = new LinkedHashMap<String, String>();
//ユーザ名
			public String getUserID() {
				return (String) this.sessionMap.get("userId");
			}

//イニシャライザ
		{
			this.setEventAreaMap();
		}

//更新
@Override
public String execute() throws Exception {
	this.setEventAreaMap();
	this.setRecordMap();

	//更新対象のIDを取得
	this.ID = this.getValueFromSession("updateId");

	EventStageDao dao = new EventStageDao();
	EventStage target = null;
	//更新対象IDがあればデータの更新をする
	if(StringUtils.isNotEmpty(this.ID)){
		target = dao.select(Integer.parseInt(this.ID), EventStage.class);

		if(target != null){
			this.areaID = String.valueOf(target.getAreaID());
			this.name = target.getName();
			this.record = target.getRecord();
			this.station = target.getStation();
			this.comment = target.getComment();
			this.updateBtnTitle = "更新"; //ボタンラベルを「更新」に
			this.title = "リリイベ会場検索＜更新＞";
		}
	} else {
		//新規
		this.ID = "";
		this.title = "リリイベ会場検索＜追加＞";
		this.updateBtnTitle = "追加";

	}
	return "success";
}

//必須項目が入力済みか確認する
	private boolean isEmptyParam(String param){
		return StringUtils.isEmpty(param);
	}


//追加（更新、追加し終わったら検索画面にもどるはず？）
	public String update() {
		this.setEventAreaMap();
		this.setRecordMap();

		if(this.isEmptyParam(name)) {
			addActionError("会場名称が未入力です");
		}
		if(this.isEmptyParam(station)) {
			addActionError("最寄り駅名が未入力です");
		}
		if(this.isEmptyParam(areaID)) {
			addActionError("エリアが未選択です");
		}
		if(this.isEmptyParam(record)) {
			addActionError("レコード店が未選択です");
		}
		if(this.isEmptyParam(comment)) {
			addActionError("コメントが未入力です");
		}
//１つでもエラーがあったらだめ
			if (this.getActionErrors().size() > 0) {
			return "error";
		}
		EventStageDao dao = new EventStageDao();
		if(StringUtils.isNotEmpty(this.ID)){
			EventStage target = dao.select(Integer.parseInt(this.ID), EventStage.class);
			dao.update(this.generateEventStageModel(target));
			this.message = "更新しました";
			this.sessionMap.put("message", this.message);
		} else {
			dao.insert(this.ID,this.name,this.station,this.record,this.comment,this.areaID);

		this.message = "登録しました";
		this.sessionMap.put("message", this.message);
		}

		return "EventStageSearch";
	}

	private EventStage generateEventStageModel(EventStage target) {
		target.setName(this.name);
		target.setStation(this.station);
		target.setRecord(this.record);
		target.setComment(this.comment);
		target.setAreaID(Integer.parseInt(this.areaID));


		return target;
	}



/** getter/setter etc */

	public String getTitle(){
		return title;
	}

/** @return */
	public String getUpdateBtnTitle() {
		return this.updateBtnTitle;
	}
/** @return */
		public String getID() {
			return ID;
		}
/** @param */
		public void setID(String ID) {
			this.ID = ID;
		}
/** @return */
		public String getAreaID() {
			return areaID;
		}
/** @param */
		public void setAreaID(String areaID) {
			this.areaID = areaID;
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
		public String getStation() {
			return station;
		}
/** @param */
		public void setStation(String station) {
			this.station = station;
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
		public String getComment() {
			return comment;
		}
/** @param */
		public void setComment(String comment) {
			this.comment = comment;
		}
/** @return */
		public String getErrorMessage() {
			return errorMessage;
		}
/** @param */
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
/** @return */
		public String getMessage() {
			return message;
		}
/** @param */
		public void setMessage(String message) {
			this.message = message;
		}

/**	@return areaMap	 */
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

/**	@return recordMap	 */
//レコードプルダウン用マップ
	public void setRecordMap() {
		this.recordMap.put("", "選択してください");
		this.recordMap.put("HMV", "HMV");
		this.recordMap.put("TW", "タワーレコード");
		this.recordMap.put("SN", "新星堂");
		this.recordMap.put("etc", "その他");

	}

/*------------------------------------------------------*/
// エリアプルダウン用マップを返す //
/*------------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {

		try {
			eventAreaMap.put("", "選択してください");
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
