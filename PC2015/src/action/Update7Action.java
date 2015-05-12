package action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.MovieGenre;

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
	public String exhibition_year; // 公開年
	public String comment;
	public String errormsg; // エラーメッセージ
	public ArrayList<MovieGenre> values; // エラーメッセージ

	// 登録画面の初期値設定
	public String execute() throws Exception {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		this.exhibition_year = "";

		this.listBox();

		return "success";
	}

	// 追加するメソッド
	public String insert() {
		// 未入力の項目があるときにエラーを返す
		if (this.title.isEmpty()) {
			this.listBox();
			this.errormsg = "タイトルは必須入力項目です";
			return "errormsg";
		}
		if (!this.exhibition_year.isEmpty() && !isNumber(exhibition_year)) {
			this.listBox();
			this.errormsg = "公開年は半角数字（西暦）で入力してください";
			return "errormsg";

		}
		// 全項目入力済みの時

		String registration_userid = (String) this.sessionMap.get("userId");
		String renewal_userid = (String) this.sessionMap.get("userId");
		MovieManager moviemanager = new MovieManager(); // MovieManagerをインスタンス化
		if (exhibition_year.isEmpty()) {
			exhibition_year = "0";
		}

		moviemanager.insert(this.title, this.genreId,
				Integer.valueOf(this.exhibition_year), this.comment,
				registration_userid, renewal_userid);
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

	private void listBox() {
		MovieManager moviemanager = new MovieManager(); // MovieManagerをインスタンス化
		values = moviemanager.expression();
	}

	private boolean isNumber(String val) {
		String regex = "\\A[-]?[0-9]+\\z";
		Pattern p = Pattern.compile(regex);
		Matcher m1 = p.matcher(val);
		return m1.find();
	}
}