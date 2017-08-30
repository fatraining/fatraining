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

import training2016.dao.GuraburuDao;
import training2016.model.GuraburuCharacter;
import training2016.model.GuraburuRace;

@Results({
	@Result(name = "update", value ="guraburuCharacterUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value ="guraburuCharacterDekete.action", type = ServletRedirectResult.class)
})
public class GuraburuCharacterSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	//タイトル
	private String title = "グラブルキャラ検索";

	/*------------------------------------------------*/
	// ブラウザからの入力項目
	/*------------------------------------------------*/

	/* キャラクター名 */
	private String name;

	/* 性別 */

	private String sex;

	/* 属性 */
	private String attribute;

	/* 種族 */
	private String race;

	/* 更新ID */
	private String updateId;

	/* 削除ID */
	private String delete;

	/* 種族プルダウン用マップ */
	private Map<String,String> raceMap = new LinkedHashMap<String,String>();

	/* 検索リスト */
	public List<GuraburuCharacter> guraburuCharacterTable = new ArrayList<GuraburuCharacter>();

	//ユーザー名
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	// イニシャライザ
	{
		this.setRaceMap();
	}

	/*------------------------------------------------*/
	// 初期値の設定
	/*------------------------------------------------*/

	private String getDefaultName() {
		return "";
	}

	private String getDefaultSex() {
		return "";
	}

	private String getDefaultAttribute() {
		return "";
	}

	private String getDefaultRace() {
		return "";
	}

	/*------------------------------------------------*/
	// excuteメソッド
	/*------------------------------------------------*/
	@Override
	public String execute() {
		this.name = getDefaultName();
		this.sex = getDefaultSex();
		this.attribute = getDefaultAttribute();
		this.race = getDefaultRace();
		this.setRaceMap();
		return "success";
	}
	/*------------------------------------------------*/
	// 各種ボタンクリック時
	/*------------------------------------------------*/
	// リセットボタン
	public String reset() {
		this.name = getDefaultName();
		this.sex = getDefaultSex();
		this.attribute = getDefaultAttribute();
		this.race = getDefaultRace();
		this.sessionMap.put("message", null);
		this.setRaceMap();
		return "success";
	}
	//検索
	public String search() {
		GuraburuDao dao = new GuraburuDao();
		List<?> resultTable = null; //ワイルドカード

		if (StringUtils.isEmpty(name) &&
				StringUtils.isEmpty(sex) &&
				StringUtils.isEmpty(attribute) &&
				StringUtils.isEmpty(race)) {
			resultTable = dao.guraburuList(); // nullのとき
		} else {
			name = this.name.trim();
			sex = this.sex.trim();
			attribute = this.attribute.trim();
			race = this.race.trim();
			resultTable = dao.resultList(name,sex,attribute,race);
			// 条件が指定されているとき
		}
		this.sessionMap.put("message", null);
		this.guraburuCharacterTable.addAll(resultTrans(resultTable));
		this.setRaceMap();
		return "success";
	}
	//追加
	public String update() {
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("guraburuCharacterUpdate.action"); //追加画面へ
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	//削除
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if ( delete == null) {
			addActionError("削除するデータを選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("guraburuCharacterDelete.action");//削除画面へ
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/*------------------------------------------------*/
	// テーブルの作成
	/*------------------------------------------------*/
	public ArrayList<GuraburuCharacter> resultTrans(List<?> resultTable) {
		ArrayList<GuraburuCharacter> tempTable = new ArrayList<>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				GuraburuCharacter temp = new GuraburuCharacter();
				obj = (Object[]) resultTable.get(i);
				GuraburuCharacter c = (GuraburuCharacter) obj[0];
				GuraburuRace r = (GuraburuRace) obj[1];
				temp.setId(c.getId());
				temp.setName(c.getName());
				temp.setSex(c.getSex());
				temp.setAttribute(c.getAttribute());
				temp.setRaceName(r.getName());
				temp.setComment(c.getComment());
				temp.setRegisterdData(c.getRegisterdData());
				temp.setDataUrl(c.getDataUrl());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempTable;
	}

	/*------------------------------------------------*/
	// getter,setter
	/*------------------------------------------------*/

	public String getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Map<String, String> getRaceMap() {
		return this.raceMap;
	}
	public void setRaceMap() {
		GuraburuDao dao = new GuraburuDao();
		List<?> resultTable = dao.getRaceList();
		this.raceMap = tableTrans(resultTable);
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setRaceMap(Map<String, String> raceMap) {
		this.raceMap = raceMap;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	/*------------------------------------------------*/
	// エラーメッセージ
	/*------------------------------------------------*/
	public boolean getHasActionErrors() {
		if (hasActionErrors()) {
			return true;
		} else {
			return false;
		}
	}
	/*------------------------------------------------*/
	// 種族プルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String,String> tableTrans(List<?> resultTable) {
		try {
			this.raceMap.put("","");
			for(int i = 0; i < resultTable.size()-1; i++) {
				GuraburuRace r = (GuraburuRace) resultTable.get(i);
				this.raceMap.put(r.getId(), r.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return raceMap;
	}




}
