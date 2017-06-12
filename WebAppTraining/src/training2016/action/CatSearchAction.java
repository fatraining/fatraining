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

import training2016.dao.CatDao;
import training2016.model.CatFrom;
import training2016.model.CatInfo;

/* Actionクラスのreturn値と出力先を設定する */
@Results({
	@Result(name = "update", value ="catUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value ="catDelete.action", type = ServletRedirectResult.class)
})
public class CatSearchAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	/* 画面タイトル */
	private String title = "世界の猫検索";
	/* 原産国 */
	private String country;
	/* 更新ID */
	private String updateId;
	/* 削除ID */
	private String deleteId;// 変数名"delete"の方が分かりやすかった
	/* 原産国プルダウン用マップ */
	private Map<String, String> countryMap;
	/* 検索結果リスト */
	public ArrayList<CatInfo> resultTable = new ArrayList<CatInfo>();

	/* セッションの設定 */
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}
	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	/* イニシャライザ（初期化子） */
	{
		this.setCountryMap();
	}

	/* 初期値の設定 */
	private String getDefaultCountry() {
		return "";
	}

	/* executeメソッド（SQLTextプロパティに設定したSQL文をサーバプログラムに対して実行する） */
	@Override
	public String execute() {
		this.country = getDefaultCountry();
		this.setCountryMap();
		return "success";
	}

	/* リセット */
	public String reset() {
		this.country = getDefaultCountry();
		this.sessionMap.put("message", null);
		this.setCountryMap();
		return "success";
	}

	/* 検索 */
	public String search() {
		CatDao Dao = new CatDao();
		List<?> resultTable = null;
		if (StringUtils.isEmpty(country)) {
			resultTable = Dao.resultList();
		} else {
			country = this.country.trim();
			resultTable = Dao.resultList(country);
		}
		this.sessionMap.put("message", null);
		this.resultTable.addAll(resultTrans(resultTable));
		this.setDeleteId("true");
		this.setCountryMap();
		return "success";
	}

	/* テーブルの作成 */
	public ArrayList<CatInfo> resultTrans(List<?> resultTable) {
		ArrayList<CatInfo> tempTable = new ArrayList<CatInfo>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				CatInfo temp = new CatInfo();
				obj = (Object[]) resultTable.get(i);
				CatFrom f = (CatFrom) obj[0];
				CatInfo in = (CatInfo) obj[1];
				temp.setId(in.getId());
				temp.setFromId(in.getFromId());
				temp.setName(in.getName());
				temp.setComment(in.getComment());
				temp.setCountry(f.getCountry());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/* 追加 */
	public String update() {
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("catUpdate.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/* 削除 */
	public String delete() {
		this.sessionMap.put("deleteId", this.deleteId);
		if (deleteId == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("catDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/* get,setメソッド */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	public Map<String, String> getCountryMap() {
		return countryMap;
	}
	public void setCountryMap() {
		CatDao dao = new CatDao();
		List<?> resultTable = dao.getCatFromList();
		this.countryMap = tableTrans(resultTable);
	}

	/* 原産国プルダウン用マップを返す */
	public Map<String, String> tableTrans(List<?> resultTable) {
		Map<String, String> tempMap = new LinkedHashMap<String, String>();
		tempMap.put("", "にゃー(=^･ω･^=)");
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				CatFrom from = (CatFrom) resultTable.get(i);
				tempMap.put(from.getId(), from.getCountry());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempMap;
	}
	public ArrayList<CatInfo> getResultTable() {
		return resultTable;
	}
	public void setResultTable(ArrayList<CatInfo> resultTable) {
		this.resultTable = resultTable;
	}

}
