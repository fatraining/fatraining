package action;

import java.io.IOException;
import java.util.ArrayList;

import model.BandResultTable;
import model.BandTable;
import controller.BandAllManager;

public class BandSearchAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	// フィールドの宣言
	public String band_name; //バンド名の値を入れる変数
	public String name; //名前の値を入れる変数
	public String part; //演奏楽器の値を入れる変数
	public String do_print; //検索結果の表示・非表示に関する変数
	public String delete_id; //削除に関する変数
	public String delete; //削除ボタンの表示・非表示に関する変数
	public String userId; //ログイン時のUSERに関する変数

	//
	public ArrayList<BandResultTable> outputTable;

	// getDefaultValueメソッド。値の初期化
	private String getDefaultValue() {
		return "";
	}

	// executeメソッド。
	@Override
	public String execute() {
		this.userId = (String) this.sessionMap.get("userId"); //USER名をuserIdに代入する
		this.band_name = getDefaultValue(); //
		this.name = getDefaultValue();
		this.part = getDefaultValue();
		this.delete = "false";
		return "success";
	}

	// resetメソッド。入力した値を初期値に戻す。
	public String reset() {
		this.userId = (String) this.sessionMap.get("userId");
		this.band_name = getDefaultValue();
		this.name = getDefaultValue();
		this.part = getDefaultValue();
		return "success";
	}

	// printメソッド。検索結果を表示させるための処理？
	public String print() {

		this.userId = (String) this.sessionMap.get("userId");
		if (this.band_name.isEmpty() && this.name.isEmpty()
				&& this.part.isEmpty()) {
			BandAllManager allController = new BandAllManager();
			this.outputTable = allController.bandResultList();
		} else {
			BandAllManager linkController = new BandAllManager();
			this.outputTable = linkController.bandResultList(this.band_name,
					this.name, this.part);
		}
		this.do_print = "true";
		this.delete = "true";
		return "success";
	}

	// updateメソッド。追加で使用
	public String update() {
		this.sessionMap.put("delete_id", null);
		try {
			this.response.sendRedirect("/PC2015/bandAdd.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// deleteメソッド。行の削除に使用
	public String delete() {

		this.sessionMap.put("delete_id", this.delete_id);

		try {
			this.response.sendRedirect("/PC2015/bandAdd.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

}
