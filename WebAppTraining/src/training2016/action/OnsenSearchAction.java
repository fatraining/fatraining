package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.OnsenDao;
import training2016.model.Onsen;
import training2016.model.OnsenArea;

@Results({ @Result(name = "update", value = "onsenUpdate.action", type = ServletRedirectResult.class),
		@Result(name = "delete", value = "onsenDelete.action", type = ServletRedirectResult.class) })

public class OnsenSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* 画面タイトル */
	private String title = "温泉検索";

	/** ブラウザからの入力項目 */

	/* エリア */
	private String area;
	/* 温泉名 */
	private String name;

	/* 削除ID */
	private String delete;

	/* 更新ID */
	private String updateId;

	/* エリアプルダウン用マップ */
	private Map<String, String> onsenAreaMap = new HashMap<String, String>();

	/* 検索リスト */
	public ArrayList<Onsen> onsenTable = new ArrayList<Onsen>();

	// ～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	// イニシャライザ
	{
		this.setOnsenAreaMap();
	}

	/* 初期値の設定 */
	private String getDefaultArea() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	/* executeメソッド */
	@Override
	public String execute() {
		this.area = getDefaultArea();
		this.name = getDefaultName();

		this.setOnsenAreaMap();

		return "success";
	}

	/* リセットボタンを押したとき */
	public String reset() {
		this.area = getDefaultArea();
		this.name = getDefaultName();
		this.setOnsenAreaMap();
		this.sessionMap.put("message", null);
		return "success";

	}

	/* 検索ボタンを押したとき */
	public String search() {
		OnsenDao Dao = new OnsenDao();
		List<?> resultTable = null; // ワイルドカード
		if (StringUtils.isEmpty(area) && StringUtils.isEmpty(name)) {
			resultTable = Dao.onsenList(); // nullのとき
		} else {
			area = this.area.trim();
			name = this.name.trim();

			resultTable = Dao.resultList(area, name); // 条件あり
		}
		this.sessionMap.put("message", null);
		this.onsenTable.addAll(resultTrans(resultTable));
		this.setOnsenAreaMap();

		this.setDelete("true"); // 消してみても大丈夫かも
		return "success";
	}

	/* テーブルの作成 */
	public ArrayList<Onsen> resultTrans(List<?> resultTable) {
		ArrayList<Onsen> tempTable = new ArrayList<Onsen>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Onsen temp = new Onsen();
				obj = (Object[]) resultTable.get(i);
				Onsen a = (Onsen) obj[0];
				OnsenArea aa = (OnsenArea) obj[1];
				temp.setId(a.getId());
				temp.setOnsenAreaId(a.getOnsenAreaId());
				temp.setArea(aa.getArea());
				temp.setName(a.getName());
				temp.setEffect(a.getEffect());
				temp.setComment(a.getComment());
				temp.setLink(a.getLink());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/* 追加ボタンを押したとき */
	public String update() {
		// セッションマップに指定されたキーでValueをputする
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("onsenUpdate.action"); // 追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/* 削除ボタンを押したとき チェックアリならonsenDelete.actionにとばす */
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("onsenDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/* setter・getter */
	/**
	 * エリアをセットする
	 *
	 * @param area
	 *            セットする area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * エリアを返す
	 *
	 * @return area
	 */
	public String getArea() {
		return this.area;
	}

	/**
	 * 温泉名をセットする
	 *
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 温泉名を返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 削除idをsetする
	 *
	 * @param delete
	 *            セットする delete
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * 削除idを返す
	 *
	 * @return delete
	 */
	public String getDelete() {
		return this.delete;
	}

	/**
	 * 更新idをセットする
	 *
	 * @param updateId
	 *            セットする update
	 */
	public void setUpdateId(String updateId) {

		this.updateId = updateId;
	}

	/**
	 * 更新idを返す
	 *
	 * @return update
	 */
	public String getUpdateId() {
		return this.updateId;
	}

	/**
	 * 画面タイトルを返す
	 *
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * エリアマップを返す
	 *
	 * @return OnsenAreaMap
	 */
	public Map<String, String> getOnsenAreaMap() {
		return this.onsenAreaMap;
	}

	/**
	 * エリアプルダウン用マップを返す
	 *
	 */
	public void setOnsenAreaMap() {
		OnsenDao dao = new OnsenDao();
		List<?> resultTable = dao.getOnsenAreaList();
		this.onsenAreaMap = tableTrans(resultTable);
	}

	/*------------------------------------------------*/
	// エリアプルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String, String> tableTrans(List<?> resultTable) {
		try {
			onsenAreaMap.put("", "");
			for (int i = 0; i < resultTable.size(); i++) {
				OnsenArea aa = (OnsenArea) resultTable.get(i);
				onsenAreaMap.put(aa.getId(), aa.getArea());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onsenAreaMap;
	}

}
