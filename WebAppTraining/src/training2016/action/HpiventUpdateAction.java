package training2016.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.SessionException;

import training2016.dao.HpiventDao;
import training2016.model.GroupName;

@Result(name = "hpiventSearch" , value = "hpiventSearch.action" , type = ServletRedirectResult.class)
public class HpiventUpdateAction extends AbstractAction {

	/** 画面タイトル */
	private String title = "H!Pイベント追加";

	private static final long serialVersionUID = 1L;
	public Map<Integer, String> groupNames = new HashMap<Integer, String>();
	public String ID;
	public String groupID;
	public String iventName;
	public String category;
	public String place;
	public String day;
	public String comment;
	public String msg;

	// エラー表示
	public String errormsg;
	// 削除画面時の表示項目
	public String delete;
	private Map<String,String> groupName;

	{
		this.setGroupName();
	}

	public String execute() throws Exception{
		//deleteを取り出し
		this.delete = (String) this.sessionMap.get("deleteID");
		return "success";
	}

	/* 削除メソッド */
	/*------------------------------------------------------*/
	public String delete() {
		this.delete = (String) this.sessionMap.get("deleteID");
		HpiventDao Hpivent = new HpiventDao();
		Hpivent.delete(this.delete);
		this.msg = "削除が完了しました。";
		this.sessionMap.put("msg",this.msg);
		return "hpiventSearch";
	}

	/* 追加メソッド */
	/*------------------------------------------------------*/
	public String insert() {
		if(this.isEmptyParam(this.iventName)) {
			addActionError("名称が未入力です。");
		}
		if(this.isEmptyParam(this.place)) {
			addActionError("場所が未入力です。");
		}
		if(this.isEmptyParam(this.day)) {
			addActionError("日時が未入力です。");
		}
		if (this.getActionErrors().size() > 0) {
			return "error";
		}
		//日時の書式を指定する
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		// 日時解析を厳密に行う設定にする
		df.setLenient(false);
		try {
			Date day = df.parse(this.day);
			HpiventDao insert = new HpiventDao();
			insert.insert(this.ID, this.groupID, this.category, this.iventName, this.place, this.day, this.comment);
		} catch (SessionException | NumberFormatException | ParseException e) {
			addActionError("日時が不正です。");
			return "error";
		}
		this.msg = "登録しました。";
		sessionMap.put("msg", this.msg);
		return "hpiventSearch";
	}

	private boolean isEmptyParam(String param) {
		return StringUtils.isEmpty(param);
	}

	private void setGroupName() {
		HpiventDao Hpivent = new HpiventDao();
		List<?> resultTable = Hpivent.getGroupnameList();
		this.groupName = tableTrans(resultTable);
	}

	public Map<String,String> getGroupName() {
		return groupName;
	}

	/* グループ名のプルダウン作成 */
	/*------------------------------------------------------*/
	public Map<String,String> tableTrans(List<?> resultTable) {
		Map<String, String> tempMap = new HashMap<String, String>();
		try {
			for (int j = 0; j < resultTable.size(); j++) {
				GroupName groupname = (GroupName) resultTable.get(j);
				tempMap.put(groupname.getGroupID(), groupname.getGroupName());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return tempMap;
	}
	/*------------------------------------------------------*/
	public String getTitle() {
		return this.title;
	}
}
