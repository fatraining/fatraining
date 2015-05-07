package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.DetailEat;
import model.IDofEat;
import model.Result10Table;
import controller.All10Manager;

public class Main10Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	// フィールドの宣言
	public String eat_year;// 年
	public String eat_month;// 月
	public String eat_day;// 日
	public String eat_hour;// 時間
	public String do_search;// 検索結果の表示・非表示フラグ
	public String delete_id;// 削除のチェックボックス
	public String delete;// 削除の表示・非表示フラグ
	public String userId;// ログインのuserID

	public ArrayList<Result10Table> outputTable;

	// eat_yearのデフォルト値は2015
	private String getDefaultEat_year() {
		return "2015";
	}

	// eat_monthのデフォルト値は1
	private String getDefaultEat_month() {
		return "1";
	}

	// eat_dayのデフォルト値は1
	private String getDefaultEat_day() {
		return "1";
	}

	// eat_hourのデフォルト値はAM
	private String getDefaultEat_hour() {
		return "AM";
	}

	@Override
	// オーバーライドする
	// executeメソッドを作る（始めにデフォルト値を検索欄に表示させておくため）
	public String execute() {
		this.userId = (String) this.sessionMap.get("userId"); // sessionMapに保存していたuserIDを取得
		this.eat_year = getDefaultEat_year(); // デフォルト値の取得
		this.eat_month = getDefaultEat_month(); // デフォルト値の取得
		this.eat_day = getDefaultEat_day(); // デフォルト値の取得
		this.eat_hour = getDefaultEat_hour(); // デフォルト値の取得
		this.delete = "false"; //
		return "success"; // Successが見つからないのでMain10Actionへ戻る
	}

	// resetメソッド（リセットボタンを押した時）
	public String reset() {
		this.userId = (String) this.sessionMap.get("userId"); // sessionMapに保存していたuserIDを取得
		this.eat_year = getDefaultEat_year(); // デフォルト値の取得
		this.eat_month = getDefaultEat_month(); // デフォルト値の取得
		this.eat_day = getDefaultEat_day(); // デフォルト値の取得
		this.eat_hour = getDefaultEat_hour(); // デフォルト値の取得
		return "success"; // Successが見つからないのでMain10Actionへ戻る
	}

	// searchメソッド（検索ボタンを押した時）
	public String search() {
		this.userId = (String) this.sessionMap.get("userId"); // sessionMapに保存していたuserIDを取得
		All10Manager allController = new All10Manager(); // インスタンスの生成
		List<?> result10Table;
		// もしすべて空だった場合は
		if (this.eat_year.isEmpty() && this.eat_month.isEmpty()
				&& this.eat_day.isEmpty() && this.eat_hour.isEmpty()) {

			result10Table = allController.resultList();
			// 空でなかったら 検索結果の表示をする
		} else {
			result10Table = allController.resultList(this.eat_year,
					this.eat_month, this.eat_day, this.eat_hour);
		}
		this.outputTable = tableTrans(result10Table);

		// 検索結果の表示
		this.do_search = "true";
		// 削除ボタンの表示
		this.delete = "true";

		return "success"; // Successが見つからないのでMain10Actionへ戻る
	}

	// updateメソッド（追加ボタンを押したとき）
	public String update() {
		this.sessionMap.put("delete_id", null);
		try {
			this.response.sendRedirect("/PC2015/update10.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success"; // Successが見つからないのでMain10Actionへ戻る
	}

	// deleteメソッド（削除ボタンを押したとき）
	public String delete() {
		this.sessionMap.put("delete_id", this.delete_id);// delete_idを取得する
		try {
			// 例外が発生するかもしれない処理
			this.response.sendRedirect("/PC2015/update10.action"); // Update10Actionに接続する
		} catch (IOException e) {
			// 例外をキャッチ
			e.printStackTrace();
		}

		return "success"; // SuccessActionが見つからないのでMain10Actionへ戻る
	}

	// TODO
	public ArrayList<Result10Table> tableTrans(List<?> result10Table) {
		ArrayList<Result10Table> tempTable = new ArrayList<Result10Table>();
		Object[] obj;
			for (int i = 0; i < result10Table.size(); i++) {
				// Result10Tableのインスタンスの生成
				Result10Table temp = new Result10Table();

				obj = (Object[]) result10Table.get(i);

				// 画面表示用に設定
				DetailEat detaileat = (DetailEat) obj[0];
				IDofEat idofeat = (IDofEat) obj[1];
				temp.setId(detaileat.getId());
				temp.setEat_year(detaileat.getEat_year());
				temp.setEat_month(detaileat.getEat_month());
				temp.setEat_day(detaileat.getEat_day());
				temp.setEat_hour(detaileat.getEat_hour());
				temp.setEatFood(idofeat.getEatFood());
				temp.setEatCalory(idofeat.getEatCalory());
				//画面表示用にリストに追加
				tempTable.add(temp);
			}

		return tempTable; // TODO
	}
}