package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import training2016.dao.CatcafeDao;
import training2016.model.Catarea;
import training2016.model.Catcafe;

public class CatcafeSearchAction extends AbstractAction{
	private static final long serialVersionUID = 1L;

	private String title = "猫カフェ検索";

	private Map<String, String> prefectureMap = new HashMap<String, String>();
	private String prefecture;
	private String station;
	private String catcafeName;
	private String hours;
	private String closed;
	private String delete;

	public ArrayList<Catcafe> catcafeTable = new ArrayList<Catcafe>();

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}
	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}


	@Override
	public String execute() {
		this.initial();
		return "success";
	}

	public void initial() {
		this.prefecture = "";
		this.station = "";
		this.catcafeName = "";
		this.hours = "";
		this.closed = "";
		CatcafeDao dao = new CatcafeDao();
		List<?> resultTable = dao.getCatareaList();
		this.tableTransPull(resultTable);
	}

	/**プルダウン**/
	public Map<String, String> tableTransPull(List<?> resultTable) {
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

	/**リセット**/
	public String reset() {
		this.initial();
		return "success";
	}

	/**検索**/
	public String search() {
		CatcafeDao dao = new CatcafeDao();
		List<?> resultTable  = null;
		if (StringUtils.isEmpty(prefecture)
				&& StringUtils.isEmpty(station)
				&& StringUtils.isEmpty(catcafeName)) {
			resultTable = dao.catcafeList();

		} else {
			prefecture = this.prefecture.trim();
			station = this.station.trim();
			catcafeName = this.catcafeName.trim();

			resultTable = dao.resultList(prefecture, station, catcafeName);
		}
		this.sessionMap.put("message", null);
		this.catcafeTable.addAll(tableTrans(resultTable));
		this.setDelete("true");
		this.initial();
		return "success";

	}

	/**テーブル**/
	public ArrayList<Catcafe> tableTrans(List<?> resultTable) {
		ArrayList<Catcafe> tempTable = new ArrayList<Catcafe>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Catcafe temp = new Catcafe();
				obj = (Object[]) resultTable.get(i);
				Catarea a = (Catarea) obj[0];
				Catcafe c = (Catcafe) obj[1];
				temp.setID(c.getID());
				temp.setPrefecture(a.getPrefecture());
				temp.setStation(c.getStation());
				temp.setCatcafeName(c.getCatcafeName());
				temp.setHours(c.getHours());
				temp.setClosed(c.getClosed());
				temp.setComment(c.getComment());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/**追加**/
	public String update() {
		this.sessionMap.put("deleteID", null);
		try {
			this.response.sendRedirect("catcafeUpdate.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/**削除**/
	public String delete() {
		this.sessionMap.put("deleteID", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選んでください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("catcafeUpdate.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/** getterとsetter**/
	public String getTitle() {
		return title;
	}

	public Map<String, String> getPrefectureMap() {
		return this.prefectureMap;
	}

	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
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

	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}

}
