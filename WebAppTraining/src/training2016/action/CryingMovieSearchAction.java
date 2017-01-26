package training2016.action;

import java.io.IOException;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;


@Results({
	@Result(name = "update", value = "cryingMovieEntryUpdate.action", type = ServletRedirectResult.class)
	})

public class CryingMovieSearchAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/*削除ID*/
	private String delete;

	/* 更新ID */
	private String updateId;

	// ～さんのところ
	public String getUserID() {
		return (String) this.sessionMap.get("userId");
	}

	public String getMessage() {
		return (String) this.sessionMap.get("message");
	}



	/*executeメソッド*/
	//jspから一番最初に実行する
	@Override
	public String execute() {

		return "success";
	}





	/* 登録ボタンを押したとき */
	public String update() {
		//セッションマップに指定されたキーでValueをputする
		this.putValueToSession("updateId", this.updateId);
		try {
			this.response.sendRedirect("cryingMovieEntryUpdate.action");	 // 登録追加画面へ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}



	/**
	 *  削除idをsetする
	 * @param delete セットする delete */
	public void setDelete(String delete) {
		this.delete = delete;
	}

	/** 削除idを返す
	 * @return delete */
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


}
