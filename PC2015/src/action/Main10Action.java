package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Result10Table;
import controller.All10Manager;
import controller.Result10Manager;

public class Main10Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String eat_year;
	public String eat_month;
	public String eat_day;
	public String eat_hour;
	public String result;
	public String do_search;
	public String update_id;
	public String delete;
	public String userId;

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
		this.delete = "false"; // todo
		return "success";
	}

	public String search() { // searchメソッド
		this.do_search = "true"; // ボタンで処理する
		this.userId = (String) this.sessionMap.get("userId");
		if (this.eat_year.isEmpty() && this.eat_month.isEmpty()
				&& this.eat_day.isEmpty() && this.eat_hour.isEmpty()) {
			// もしすべて空だった場合は
			try {
				searchall(); // searchallメソッドを呼び出す
			} catch (Exception e) { // 例外キャッチ
				e.printStackTrace(); // todo
			}
		} else { // 空でなかったら 検索結果の表示をする
			Result10Manager linkController = new Result10Manager(); // インスタンスの生成
			this.outputTable = linkController.resultList(this.eat_year,
					this.eat_month, this.eat_day, this.eat_hour);
		}
		this.delete = "true"; // deleteボタンができる
		return "success"; // searchが成功する
	}

	public String searchall() { // searchallメソッド
		this.do_search = "true"; // do_searchのボタン機能（searchとは同じボタンでsearchallする）
		All10Manager allController = new All10Manager(); // todo
		this.outputTable = allController.resultList(); // searchよりsearchallは値が空のときについてなので引数なし
		this.delete = "true"; // deleteボタンができる
		return "success"; // 空欄での全検索ができるようになる
	}

	public String update() { // updateメソッド
		this.sessionMap.put("update_id", this.update_id);// update_idを取得する
		try {// 例外が発生するかもしれない処理
			this.response.sendRedirect("/PC2015/update10.action"); // UpdateActionに接続する
		} catch (IOException e) { // 例外をキャッチ
			e.printStackTrace();
		}

		return "success"; // updateができる
	}
}