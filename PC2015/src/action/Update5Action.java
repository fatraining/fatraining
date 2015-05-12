package action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import controller.UserProfileManager;

@Result(name = "main5", value = "main5.action", type = ServletRedirectResult.class)
public class Update5Action extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// 入力項目（追加画面）
	public String name; // 名前
	public String personality; // 性格
	public String interest; // 趣味
	public String zipcode; // 郵便番号
	public String dwelling; // 住所
	public String phonenumber; // 電話番号

	// エラーメッセージ表示
	public String errormsg;
	
	// 表示項目（削除画面）
	public String delete_id;

	// 画面が表示時に実行
	public String execute() throws Exception {
		// 削除ボタンが押下　or 追加画面の判定
		this.delete_id = (String) this.sessionMap.get("delete_id");

		// 初期値の設定
		this.name = "田中進";
		this.personality = "穏やか";
		this.interest = "けん玉";
		this.zipcode = "1111234";
		this.dwelling = "千葉県印旛郡栄町矢口";
		this.phonenumber = "0124551334";

		return "success";
	}

	// 追加ボタンを押下時
	public String insert() {

		if(this.zipcode.isEmpty()  || this.zipcode.trim().length() == 0){
			this.errormsg = "郵便番号を入力して下さい";
			return "err";
		}
		
		if(!this.isNumber(this.zipcode)){
			this.errormsg = "郵便番号に数字を入力して下さい";
			return "err";
		}
		
		if(this.phonenumber.isEmpty()  || this.phonenumber.trim().length() == 0){
			this.errormsg = "電話番号を入力して下さい";
			return "err";
		}
		
		if(!this.isNumber(this.phonenumber)){
			this.errormsg = "電話番号に数字を入力して下さい";
			return "err";
		}
		
		UserProfileManager linkController = new UserProfileManager();
		linkController.insert(this.personality, this.interest, this.name,
				this.zipcode, this.dwelling, this.phonenumber,
				(String) this.sessionMap.get("userId"));

		return "main5";
	}

	// 検索結果内の値を削除
	public String delete() {

		this.delete_id = (String) this.sessionMap.get("delete_id");

		if (this.delete_id.isEmpty()) {
			return "main5";
		}

		UserProfileManager linkController = new UserProfileManager();
		linkController.delete(this.delete_id);

		return "main5";
	}
	
	private boolean isNumber(String val) {
		String regex = "\\A[-]?[0-9]+\\z";
		Pattern p = Pattern.compile(regex);
		Matcher m1 = p.matcher(val);
		return m1.find();
	}
}
