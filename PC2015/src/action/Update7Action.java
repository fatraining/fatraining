package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import controller.MovieManager;

//リターンがmain7だったらmain7.actionに戻る
@Result(name = "main7", value = "main7.action", type = ServletRedirectResult.class)
public class Update7Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	// デリートに必要な変数
	public String delete_id; // 削除するID
	// テーブルにインサートするための変数
	public String title; // タイトル
	public int genreId; // ジャンル
	public int exhibition_year; // 公開年
	public String comment;
	public String errormsg; // エラーメッセージ

	// 登録画面の初期値設定
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		this.exhibition_year = 1980;

		return "success";
	}

	// 追加するメソッド
	public String insert() {

		// 未入力の項目があるときにエラーを返す
		if (this.title.isEmpty() || this.genreId == 0
				|| this.exhibition_year == 0) {
			this.errormsg = "全ての項目に入力してください";
			return "errormsg";
		}
		// 全項目入力済みの時
		else {

			String registration_userid = (String) this.sessionMap.get("userId");
			String renewal_userid = (String) this.sessionMap.get("userId");
			MovieManager moviemanager = new MovieManager(); // MovieManagerをインスタンス化

			moviemanager.insert(this.title, this.genreId, this.exhibition_year,
					this.comment, registration_userid, renewal_userid);
		}
		return "main7";

	}

	// デリートメソッド
	public String delete() {
		// delete_id=movieテーブルのidを取得
		this.delete_id = (String) this.sessionMap.get("delete_id");

		MovieManager moviemanager = new MovieManager(); // MovieManagerをインスタンス化

		// MovieManagerのdelete()の呼び出し
		moviemanager.delete(this.delete_id);

		return "main7";
	}

}