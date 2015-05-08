package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import controller.LikeManager;

@Result(name = "main6", value = "main6.action", type = ServletRedirectResult.class)
public class Update6Action extends AbstractAction {
	private static final long serialVersionUID = 1L;
	// カラムの呼び出し
	// 表示項目
	public String delete_id; // 削除画面
	// 入力項目
	public String id; // ID
	public String series; // シリーズ名
	public String se; // シリーズID
	public String title; // タイトル
	public String us; // 登録日
	public String upDay; // 更新日
	public String userID; // ユーザー名
	public String upUser; // ユーザーID
	public String nonStyle; // 切り札
	public String del; // 起源

	// executeメソッド
	// 画面が表示時に実行
	public String execute() throws Exception {
		// 削除ボタンが押下　or 追加画面の判定
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド
	// 追加画面
	public String insert() {

		// 登録useridにuserIdの値を入れる。
		String userID = (String) this.sessionMap.get("userId");
		// 更新useridにuserIdの値を入れる。
		String upUser = (String) this.sessionMap.get("userId");
		//インスタンスを生成
		LikeManager insert = new LikeManager();
		
		insert.insert(this.series, this.se, this.title, this.nonStyle ,this.del,
				userID, upUser);
		
	    return "main6";

	}
	
	/************************************************************/
	// 削除動作
	// 検索結果の内容を削除
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		//LikeManagerのインスタンスを生成
		LikeManager delete = new LikeManager();
		
		// LikeManagerのdeleteメソッドを参照
		delete.delete(delete_id);
		
		return "main6";
	}
}