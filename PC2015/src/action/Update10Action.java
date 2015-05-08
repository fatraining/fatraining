package action;

import model.IDofEat; //モデルのインポート

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import controller.All10Manager;

@Result(name = "main10", value = "main10.action", type = ServletRedirectResult.class)
public class Update10Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// フィールドの宣言
	public String eatFood; // 食べ物名
	public String eatCalory; // カロリー
	public String eat_year; // 年
	public String eat_month; // 月
	public String eat_day; // 日
	public String eat_hour; // 時間
	public String delete_id; // 削除に使うレコードのID

	// 画面表示時に実行
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		return "success";
	}

	// insertメソッド、追加の処理 データベースに値を入れる
	public String insert() {

		// 登録、更新UAER表示
		String entry_userid = (String) this.sessionMap.get("userId");
		String renew_userid = (String) this.sessionMap.get("userId");// セッションマップからuserIDを取得

		// インスタンス化、id_tableにレコードを挿入する
		IDofEat insert_id_table = new IDofEat();
		
		insert_id_table.setEntry_userid(entry_userid);
		insert_id_table.setRenew_userid(renew_userid);

		All10Manager insert = new All10Manager();
		
		//insertメソッドを参照
		insert.insert(this.eat_year,this.eat_month,this.eat_day, this.eat_hour,this.eatFood,this.eatCalory,entry_userid,renew_userid);

		return "main10";
	}

	// 検索結果内の値の削除
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");// セッションマップからdelete_idを取得

All10Manager delete = new All10Manager();
		
		//insertメソッドを参照
		delete.delete(delete_id);
		
		return "main10"; // Main10Actionへ
	}

}