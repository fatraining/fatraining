package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.YasaiResultTable;
import model.Ryouri;
import model.Yasai;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import controller.YasaiManager;

@Result(name = "yasaiAdd", value = "yasaiAdd.action", type = ServletRedirectResult.class)
public class YasaiSearchAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	// 入力項目
	public String yasai; // 野菜
	public String delete_id; // 削除ボックス

	// 表示
	public String userId; // ユーザーID

	// 削除ボタンフラグ
	public String delete;

	// 検索結果表示フラグ
	public String do_search;

	// 検索結果の表示(データ)
	public ArrayList<YasaiResultTable> outputTable;

	// 画面表示時に実行
	@Override
	public String execute() {

		// ユーザーIDの表示
		this.userId = (String) this.sessionMap.get("userId");

		// 初期値の設定
		this.yasai = getDefaultYasai();

		return "success";
	}

	// 野菜の変数に値を代入(野菜)
	private String getDefaultYasai() {
		return "野菜";
	}

	// リセットボタン押下時
	public String reset() {
		// ユーザーIDの表示
		this.userId = (String) this.sessionMap.get("userId");

		// 初期値の設定
		this.yasai = getDefaultYasai();

		return "success";
	}

	// 検索ボタン押下時
	public String search() {

		// yasaimanagerをインスタンス化
		YasaiManager yasaimanager = new YasaiManager();

		// ユーザーIDの表示
		this.userId = (String) this.sessionMap.get("userId");

		// list<?>型のresultTableを宣言
		List<?> resultTable;

		if (this.yasai.isEmpty()) {
			// 入力されなかった場合、yasaimanagerのresultList()を呼び出す
			resultTable = yasaimanager.resultList();
			this.outputTable = tableTrans(resultTable);

			this.do_search = "true";
			this.delete = "true";

		} else {
			// 入力された場合、yasaimanagerのresultList(yasai)を呼び出す
			resultTable = yasaimanager.resultList(this.yasai);

			// 入力された値の検索結果がなかったとき（ｓｑｌ）
			if (resultTable.size() == 0) {
				// 結果を表示しない
				this.do_search = "表示するな";
				// 削除ボタンを表示しない
				this.delete = "表示するな";

			} else {
				this.outputTable = tableTrans(resultTable);

				this.do_search = "true";
				this.delete = "true";
			}

		}

		return "success";
	}

	// 追加ボタンを押下時
	public String add() {

		// 削除チェックボックスの値をnullに設定
		this.sessionMap.put("delete_id", null);
		try {
			// 追加画面に遷移
			this.response.sendRedirect("/PC2015/yasaiAdd.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// 削除ボタン押下時
	public String delete() {

		// 削除チェックボックスの値を取得しセッション（delete_id）に設定
		this.sessionMap.put("delete_id", this.delete_id);

		try {
			// 削除画面に遷移
			this.response.sendRedirect("/PC2015/yasaiAdd.action");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// ArrayListのYasaiResultTable型で返す（引数はresultTable(sql)）
	private ArrayList<YasaiResultTable> tableTrans(List<?> resultTable) {

		// YasaiResultTableをtempTableでインスタンス化
		ArrayList<YasaiResultTable> tempTable = new ArrayList<YasaiResultTable>();

		// objectの配列を宣言
		Object[] obj;

		try {
			// SQLの検索結果の件数分ループ
			for (int i = 0; i < resultTable.size(); i++) {
				// Result8Tableをインスタンス化
				YasaiResultTable temp = new YasaiResultTable();

				// resultTableのインデックスを全て取得して、objectに代入
				// リスト型を配列に変換（キャスト）
				obj = (Object[]) resultTable.get(i);

				Yasai yasai = (Yasai) obj[0];
				Ryouri ryouri = (Ryouri) obj[1];

				// 画面表示用に設定
				temp.setId(yasai.getId());
				temp.setYasai(yasai.getYasai());
				temp.setTyouriId(yasai.getTyouriId());
				temp.setTyouri(ryouri.getTyouri());
				temp.setRyouri(ryouri.getRyouri());

				// tempTableにtempを加える
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}

}
