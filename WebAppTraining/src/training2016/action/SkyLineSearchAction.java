package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.SkyLineDao;
import training2016.model.SkyLineAge;
import training2016.model.SkyLineData;

@Results({ @Result(name = "update", value = "skyLineUpdate.action", type = ServletRedirectResult.class),
		@Result(name = "delete", value = "skyLineDelete.action", type = ServletRedirectResult.class) })

public class SkyLineSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* 画面タイトル */
	private String title = "スカイライン";

	private String age; /* 年代 */
	private String delete; /* 削除ID */
	private String updateId; /* 更新ID */

	/* 年代プルダウン用マップ */
	private Map<String, String> skyLineAgeMap = new HashMap<String, String>();
	//検索リスト
	public ArrayList<SkyLineData> skyLineTable = new ArrayList<SkyLineData>();

	// ユーザー名
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}
	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	// イニシャライザ
	{
		this.setSkyLineAgeMap();
	}

	// 初期値
	private String getDefaultAge() {
		return "";
	}

	// executeメソッド
	public String execute() {
		this.age = getDefaultAge();
		this.setSkyLineAgeMap();
		return "success";
	}

	// 検索
	public String search() {
		SkyLineDao dao = new SkyLineDao();
		List<?> resultTable = dao.resultList(age);
		this.sessionMap.put("message", null);
		this.skyLineTable.addAll(resultTrans(resultTable));
		this.setSkyLineAgeMap();
		this.setDelete("true");
		return "success";
	}

	// テーブル作成
	public ArrayList<SkyLineData> resultTrans(List<?> resultTable) {
		ArrayList<SkyLineData> tempTable = new ArrayList<SkyLineData>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				SkyLineData temp = new SkyLineData();
				obj = (Object[]) resultTable.get(i);
				SkyLineAge a = (SkyLineAge) obj[0];     //値入力の順番気を付ける
				SkyLineData d =  (SkyLineData) obj[1];
				temp.setId(d.getId());
				temp.setDate(d.getDate());
				temp.setModel(d.getModel());
				temp.setNickname(d.getNickname());
				temp.setAgeId(a.getAge());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/*追加ボタンを押したとき*/
	public String update() {
		//セッションマップに指定されたキーでValueをputする
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("skyLineUpdate.action");  //追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	// リセットボタンを押したとき
	public String reset() {
		this.age = getDefaultAge();
		this.setSkyLineAgeMap();
		this.sessionMap.put("message", null);
		return "success";
	}

	/*削除ボタンを押したとき チェックアリならskyLineDelete.actionにとばす*/
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("skyLineDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	// Ageのgetter setter
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	// タイトルget
	public String getTitle() {
		return title;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * SkyLineAgeMap
	 */
	public Map<String, String> getSkyLineAgeMap() {
		return this.skyLineAgeMap;
	}

	 //skyLineAgeプルダウン用マップをセットする

	public void setSkyLineAgeMap() {
		this.skyLineAgeMap.put("1950", "1950");
		this.skyLineAgeMap.put("1960", "1960");
		this.skyLineAgeMap.put("1970", "1970");
		this.skyLineAgeMap.put("1980", "1980");
		this.skyLineAgeMap.put("1990", "1990");
		this.skyLineAgeMap.put("2000", "2000");
		this.skyLineAgeMap.put("2010", "2010");
	}

}
