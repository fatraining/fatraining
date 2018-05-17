package training2016.action;

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


//	はじめに実行される
	@Override //★
	public String execute() throws Exception{
		this.id = getDefaultId();
		this.image = getDefaultImage();
		this.name = getDefaultName();
		this.work = getDefaultWork();
		return "success";
	}


	/*リセットボタンを押したとき*/
	public String reset () {
		this.id = getDefaultId();
		this.image = getDefaultImage();
		this.name = getDefaultName();
		this.work = getDefaultWork();
		this.sessionMap.put("message", null);
		return "success";

	}

	/*検索ボタンを押したとき*/
	//データベース生成。
	public String search() {
		GeininDao dao = new GeininDao();
		ArrayList<Geinin> resultList = null;  //ワイルドカード(曖昧な文字列)

		if(StringUtils.isEmpty(name)) {
			resultList = dao.allGeininList(); //nullのとき
		} else {
//			★フォームに入ったnameを入れる
			resultList = dao.searchByName(name);
		}
		//thisで準備してる。

		this.sessionMap.put("message", null);
		this.geininList = resultList;
		return "success";
	}


//	/*追加ボタンを押したとき*/
//	public String update() {
//		//セッションマップに指定されたキーでValueをputする
//		this.putValueToSession("updateId", this.updateId);
//		try {
//			this.response.sendRedirect("maiwaifuUpdate.action");  //追加画面へ
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "success";
//	}
//
//	/*削除ボタンを押したとき チェックアリならmaiwaifuDelete.actionにとばす*/
//	public String delete() {
//		this.sessionMap.put("deleteId", this.delete);
//		if (delete == null) {
//			addActionError("削除する項目を選択してください");
//			search();
//			return "error";
//		} else {
//			try {
//				this.response.sendRedirect("maiwaifuDelete.action");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return "success";
//		}
//	}




	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
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
		return id;
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
		return image;
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
		return name;
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
		return work;
	}
	/**
	 * @param work セットする work
	 */
	public void setWork(String work) {
		this.work = work;
	}



}