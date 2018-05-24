package training2016.action;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.GeininDao;
import training2016.model.Geinin;

//actionにとぶように指定。
@Results({
	@Result(name = "update", value ="geininUpdate.action", type = ServletRedirectResult.class),
	@Result(name = "delete", value ="geininDelete.action", type = ServletRedirectResult.class)
})

public class GeininSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*画面タイトル*/
	private String title = "若手芸人検索";

	/*ブラウザからの入力項目*/
	private String id;
	private String image;
	private String name;
	private String work;

	public String userId;

	/*削除ID*/
	private String delete;

	/*更新ID*/
	private String updateId;

//	メッセージ
	private String message;

//	検索リスト
	public ArrayList<Geinin> geininList = new ArrayList<>();


	//～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	/*初期値の設定*/
	private String getDefaultId() {
		return "";
	}

	private String getDefaultImage() {
		return "";
	}

	private String getDefaultName() {
		return "";
	}

	private String getDefaultWork() {
		return "";
	}

	private String getDefaultMessage() {
		return "";
	}


//	はじめに実行される
	public String execute() throws Exception{
		this.id = getDefaultId();
		this.image = getDefaultImage();
		this.name = getDefaultName();
		this.work = getDefaultWork();
		this.userId = getUserID();
		this.message = this.getValueFromSession("message");
		return "success";
	}


	/*リセットボタンを押したとき*/
	public String reset () {
		this.id = getDefaultId();
		this.image = getDefaultImage();
		this.name = getDefaultName();
		this.work = getDefaultWork();
		this.message = getDefaultMessage();
		this.sessionMap.put("message", "");
		System.out.println("reset()");
		return "success";

	}

	/*検索ボタンを押したとき*/
	//データベース生成。
	public String search() {
		GeininDao dao = new GeininDao();
		ArrayList<Geinin> resultList = null;

		if(StringUtils.isEmpty(name)) {
			resultList = dao.allGeininList(); //nullのとき
		} else {
//			★フォームに入ったnameを入れる
			name = this.name.trim();
			resultList = dao.searchByName(name);
		}
		//thisで準備してる。
		this.sessionMap.put("message", "検索しました");
//		this.sessionMap.put("completeMessage", null);
		this.geininList = resultList;
		System.out.println("search()");
		return "success";
	}


	/*追加ボタンを押したとき*/
	public String update() {
		//セッションマップに指定されたキーでValueをputする
		this.putValueToSession("updateId", this.updateId);
		System.out.println("update() updateId:" + this.updateId);
		this.sessionMap.put("message", "");
		return "update";
	}

	/*削除ボタンを押したとき チェックアリならgeininDelete.actionにとばす*/
	public String delete() {
		this.sessionMap.put("deleteId", this.delete);
		if (delete == null) {
			addActionError("削除する項目を選択してください");
			search();
			System.out.println("Error: チェックされていない");
			return "error";
		} else {
			try {
				this.response.sendRedirect("geininDelete.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("delete() deleteId:" + this.delete);
			this.sessionMap.put("message", "");
			return "success";
		}
	}



//	setterやgetter
	/**
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return id
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return image
	 */
	public String getImage() {
		return this.image;
	}
	/**
	 * @param image セットする image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return work
	 */
	public String getWork() {
		return this.work;
	}
	/**
	 * @param work セットする work
	 */
	public void setWork(String work) {
		this.work = work;
	}

//	/**
//	 * @return userId
//	 */
//	public String getUserId() {
//		return this.userId;
//	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return delete
	 */
	public String getDelete() {
		return delete;
	}

	/**
	 * @param delete セットする delete
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * @return updateId
	 */
	public String getUpdateId() {
		return updateId;
	}

	/**
	 * @param updateId セットする updateId
	 */
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	/**
	 * @return geininList
	 */
	public ArrayList<Geinin> getGeininList() {
		return geininList;
	}

	/**
	 * @param geininList セットする geininList
	 */
	public void setGeininList(ArrayList<Geinin> geininList) {
		this.geininList = geininList;
	}

	/**
	 * @param message セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}


}