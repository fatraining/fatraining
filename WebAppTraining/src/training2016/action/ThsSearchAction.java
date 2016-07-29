package training2016.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.ThsDao;
import training2016.model.Ths;
import training2016.model.ThsSubject;

@Results({
	@Result(name = "update", value ="thsUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value ="thsDelete.action", type = ServletRedirectResult.class)
})

public class ThsSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*画面タイトル*/
	private String title = "講師検索";

	/**ブラウザからの入力項目*/

	/*科目*/
	private String subject;

	/*講師名*/
	private String name;

	/*レベル*/
	private String level;

	/*削除ID*/
	private String delete;
	/*更新ID*/
	private String updateId;

	/*科目プルダウン用マップ*/
	private Map<String,String> thsSubjectMap = new HashMap<String,String>();
	/*レベルプルダウン用マップ*/
	private Map<String, String> levelMap = new LinkedHashMap<String, String>();
	/*検索リスト*/
	public ArrayList<Ths> thsTable = new ArrayList<Ths>();

	//～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}


	// イニシャライザ（初期化子）
	{
		this.setThsSubjectMap();
	}


	/*初期値の設定*/
	private String getDefaultSubject() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	private String getDefaultLevel() {
		return "";
	}

	/*executeメソッド*/
	@Override
	public String execute() {
		this.subject = getDefaultSubject();
		this.name = getDefaultName();
		this.level = getDefaultLevel();
		this.setThsSubjectMap();
		this.setLevelMap();
		return "success";
	}

	/*リセットボタンを押したとき*/
	public String reset () {
		this.subject = getDefaultSubject();
		this.name = getDefaultName();
		this.level = getDefaultLevel();
		this.setThsSubjectMap();
		this.setLevelMap();
		this.sessionMap.put("message", null);
		return "success";

	}

	/*検索ボタンを押したとき*/
	public String search() {
		ThsDao Dao = new ThsDao();
		List<?> resultTable = null;
		if(StringUtils.isEmpty(subject) &&
		   StringUtils.isEmpty(name) &&
		   StringUtils.isEmpty(level)) {
			resultTable = Dao.thsList(); //nullのとき
		} else {
			subject = this.subject.trim();
			name = this.name.trim();
			level = this.level.trim();
			resultTable = Dao.resultList(subject, name, level); //条件あり
		}
		this.sessionMap.put("message", null);
		this.thsTable.addAll(resultTrans(resultTable));
		this.setThsSubjectMap();
		this.setLevelMap();
		this.setDelete("true");  //消してみても大丈夫かも
		return "success";
	}

	/*テーブルの作成*/
	public ArrayList<Ths> resultTrans(List<?> resultTable) {
		ArrayList<Ths> tempTable = new ArrayList<Ths>();
		Object[] obj;
		try {
			for(int i = 0; i < resultTable.size(); i++) {
				Ths temp = new Ths();
				obj = (Object[]) resultTable.get(i);
				Ths a = (Ths) obj[0];
				ThsSubject aa = (ThsSubject) obj[1];
				temp.setId(a.getId());
				temp.setThsSubjectId(a.getThsSubjectId());
				temp.setSubject(aa.getSubject());
				temp.setName(a.getName());
				temp.setLevel(a.getLevel());
				temp.setComment(a.getComment());
				temp.setLink(a.getLink());
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
			this.response.sendRedirect("thsUpdate.action");  //追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/*削除ボタンを押したとき チェックアリならthsDelete.actionにとばす*/
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			return "error";
		} else {
			try {
				this.response.sendRedirect("thsDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	/*setter・getter*/
	/**
	 * 科目をセットする
	 * @param subject セットする subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 科目を返す
	 * @return subject
	 */
	public String getSubject(){
		return this.subject;
	}

	/**
	 * 講師名をセットする
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 講師名を返す
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * レベルをセットする
	 * @param level セットする level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * レベルを返す
	 * @return level
	 */
	public String getLevel() {
		return this.level;
	}

	/**
	 * 削除idをsetする
	 * @param delete セットする delete
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * 削除idを返す
	 * @return delete
	 */
	public String getDelete() {
		return this.delete;
	}

	/**
	 * 更新idをセットする
	 * @param updateId セットする update
	 */
	public void setUpdateId(String updateId) {

		this.updateId = updateId;
	}

	/**
	 * 更新idを返す
	 * @return update
	 */
	public String getUpdateId() {
		return this.updateId;
	}

	/**
	 * 画面タイトルを返す
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * ThsSubjectマップを返す
	 * @return ThsSubjectMap
	 */
	public Map<String, String> getThsSubjectMap() {
		return this.thsSubjectMap;
	}

	/**
	 * ThsSubjectプルダウン用マップを返す
	 *
	 */
	public void setThsSubjectMap() {
		ThsDao dao = new ThsDao();
		List<?> resultTable = dao.getThsSubjectList();
		this.thsSubjectMap = tableTrans(resultTable);
	}

	/**
	 *levelマップを返す
	 * @return levelMap
	 */
	public Map<String, String> getLevelMap() {
		return this.levelMap;
	}

	/**
	 * levelプルダウン用マップをセットする
	 *
	 */
	public void setLevelMap() {
		this.levelMap.put("", "レベルを選択");
		this.levelMap.put("基礎", "基礎");
		this.levelMap.put("普通", "普通");
		this.levelMap.put("応用", "応用");
	}

	/*------------------------------------------------*/
	// 科目プルダウン用マップを返す
	/*------------------------------------------------*/
	public Map<String,String> tableTrans(List<?> resultTable) {
		try {
			thsSubjectMap.put("","科目を選択");
			for(int i = 0; i < resultTable.size(); i++) {
				ThsSubject aa = (ThsSubject) resultTable.get(i);
				thsSubjectMap.put(aa.getId(), aa.getSubject());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thsSubjectMap;
	}

}
