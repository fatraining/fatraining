package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Result10Table;
import controller.All10Manager;

public class Main10Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	//フィールドの宣言
	public String eat_year;//年
	public String eat_month;//月
	public String eat_day;//日
	public String eat_hour;//時間
	public String do_search;//検索結果の表示・非表示フラグ
	public String delete_id;//削除のチェックボックス
	public String delete;//削除の表示・非表示フラグ
	public String userId;//ログインのuserID

	public ArrayList<Result10Table> outputTable;

	private String getDefaultEat_year() {// eat_yearのデフォルト値は2015
		return "2015";
	}

	private String getDefaultEat_month() {// eat_monthのデフォルト値は1
		return "1";
	}

	private String getDefaultEat_day() {// eat_dayのデフォルト値は1
		return "1";
	}

	private String getDefaultEat_hour() {// eat_hourのデフォルト値はAM
		return "AM";
	}

	@Override
	// スーパークラスのメソッドをサブクラスで書きなおすこと
	public String execute() { // executeメソッドを作る（始めにデフォルト値を検索欄に表示させておくため）
		this.userId = (String) this.sessionMap.get("userId"); // sessionMapに保存していたuserIDを取得
		this.eat_year = getDefaultEat_year(); // デフォルト値の取得
		this.eat_month = getDefaultEat_month(); // デフォルト値の取得
		this.eat_day = getDefaultEat_day(); // デフォルト値の取得
		this.eat_hour = getDefaultEat_hour(); // デフォルト値の取得
		this.delete = "false"; //
		return "success"; //SuccessActionが見つからないので戻る
	}
	
	//resetメソッド（リセットボタンを押した時）
	public String reset(){
		this.userId = (String) this.sessionMap.get("userId"); // sessionMapに保存していたuserIDを取得
		this.eat_year = getDefaultEat_year(); // デフォルト値の取得
		this.eat_month = getDefaultEat_month(); // デフォルト値の取得
		this.eat_day = getDefaultEat_day(); // デフォルト値の取得
		this.eat_hour = getDefaultEat_hour(); // デフォルト値の取得
		return "success"; //SuccessActionが見つからないのでMain10Actionへ戻る
	}
	
	
	//searchメソッド（検索ボタンを押した時）	
	public String search() {
		this.userId = (String) this.sessionMap.get("userId");
		// もしすべて空だった場合は
		if (this.eat_year.isEmpty() && this.eat_month.isEmpty()
				&& this.eat_day.isEmpty() && this.eat_hour.isEmpty()) {
			All10Manager allController = new All10Manager(); // インスタンスの生成
			this.outputTable = allController.resultList();
		// 空でなかったら 検索結果の表示をする
		} else { 
			All10Manager allController = new All10Manager(); // インスタンスの生成
			this.outputTable = allController.resultList(this.eat_year,
					this.eat_month, this.eat_day, this.eat_hour);
		}
		//検索結果の表示
		this.do_search = "true";
		//削除ボタンの表示
		this.delete = "true"; 
		return "success"; //SuccessActionが見つからないのでMain10Actionへ戻る
	}
	
	// updateメソッド。追加で使用
	public String update() {
		this.sessionMap.put("delete_id", null);
		try {
			this.response.sendRedirect("/PC2015/update10.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";  //SuccessActionが見つからないのでMain10Actionへ戻る
	}


	public String delete() { // deleteメソッド
		this.sessionMap.put("delete_id", this.delete_id);// update_idを取得する
		try {
			// 例外が発生するかもしれない処理
			this.response.sendRedirect("/PC2015/update10.action"); // UpdateActionに接続する
		} catch (IOException e) { 
			// 例外をキャッチ
			e.printStackTrace();
		}

		return "success";  //SuccessActionが見つからないのでMain10Actionへ戻る
	}
}