package training2016.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.GeininDao;
import training2016.model.Geinin;

@Results({ @Result(name = "geininSearch", value = "geininSearch.action", type = ServletRedirectResult.class) })

public class GeininDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/* タイトル */
	private String title = "削除画面";

	/* 削除ID */
	private String delete;

	/* メッセージ */
	private String deleteMessage;

	private List<Geinin> geininList = new ArrayList<>();

//	//	取得するパラメータ
//	private String id;
//	private String image;
//	private String name;
//	private String work;


	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}

	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	/* executeメソッド */
	public String execute() throws Exception {
		// セッションマップからdeleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// 削除IDはカンマ区切りで渡されるのでそれを分割、配列へと格納する
		String[] noTrimArray = this.delete.split(",");
		String[] deleteIdArray = new String[noTrimArray.length];
//		各要素の空白を除く
		for(int i = 0; i < noTrimArray.length; i++) {
			deleteIdArray[i] = noTrimArray[i].trim();
		}

//		deleteId配列からgeininListにデータを格納
		GeininDao dao = new GeininDao();
		this.geininList = dao.searchById(deleteIdArray);

		// 削除するデータが複数ある場合、表示する文を変更する
		if (this.geininList.size() == 1) {
			this.deleteMessage = "このデータを削除します";
		} else {
			this.deleteMessage = "これらのデータを削除します";
		}

		return "success";
	}


	// 削除ボタンクリック時
	/*----------------------------------------------
	*/

	public String delete() {
		// セッションマップからdeleteを取り出す
		this.delete = (String) this.sessionMap.get("deleteId");
		// 削除IDはカンマ区切りで渡されるのでそれを分割、配列へと格納する
		String[] noTrimArray = this.delete.split(",");
		String[] deleteIdArray = new String[noTrimArray.length];
//		各要素の空白を除く
		for(int i = 0; i < noTrimArray.length; i++) {
			deleteIdArray[i] = noTrimArray[i].trim();
		}

		GeininDao dao = new GeininDao();
		dao.delete(deleteIdArray);

		// 削除完了メッセージを入れる
		this.sessionMap.put("message", "削除しました");

//		// 削除アクションから来たことを設定
//		this.sessionMap.put("from", "delete");

		return "geininSearch";
	}

	// setter&getter
	/*----------------------------------------------
	*/

	public String getTitle() {
		return this.title;
	}

	/**
	 * @return delete
	 */
	public String getDelete() {
		return this.delete;
	}

	/**
	 * @param delete セットする delete
	 */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/**
	 * @return geininList
	 */
	public List<Geinin> getGeininList() {
		return this.geininList;
	}

	/**
	 * @param geininList セットする geininList
	 */
	public void setGeininList(List<Geinin> geininList) {
		this.geininList = geininList;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return deleteMessage
	 */
	public String getDeleteMessage() {
		return deleteMessage;
	}

	/**
	 * @param deleteMessage セットする deleteMessage
	 */
	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}





}
