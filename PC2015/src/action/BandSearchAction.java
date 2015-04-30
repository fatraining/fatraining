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
		this.band_name = getDefaultValue(); //band_nameに初期値を代入する
		this.name = getDefaultValue(); //nameに初期値を代入する
		this.part = getDefaultValue(); //partに初期値を代入する
		this.delete = "false"; //deleteにfalseを代入し、削除ボタンを非表示に
		return "success";
	}

	// resetメソッド。入力した値を初期値に戻す。
	public String reset() {
		this.userId = (String) this.sessionMap.get("userId"); //USER名をuserIdに代入する
		this.band_name = getDefaultValue(); //band_nameの値を初期値に戻す
		this.name = getDefaultValue(); //nameの値を初期値に戻す
		this.part = getDefaultValue(); //partの値を初期値に戻す
		return "success";
	}

	// printメソッド。検索結果を表示させるための処理
	public String print() {
		//userIdの取得
		this.userId = (String) this.sessionMap.get("userId");
		//band_nameとnameとpartの値が空だったらif文内の処理を実行
		if (this.band_name.isEmpty() && this.name.isEmpty()
				&& this.part.isEmpty()) {
			//BandAllManagerクラスのインスタンス生成
			BandAllManager allController = new BandAllManager();
			//bandResultListメソッド(引数なし)をoutputTableに代入
			this.outputTable = allController.bandResultList();
		} else {
			//BandAllManagerクラスのインスタンス生成
			BandAllManager linkController = new BandAllManager();
			//bandResultListメソッド(引数あり)をoutputTableに代入
			this.outputTable = linkController.bandResultList(this.band_name,
					this.name, this.part);
		}
		this.do_print = "true"; //検索結果を表示させるためにtrueを代入している
		this.delete = "true"; //削除ボタンを表示させるためにtrueを代入している
		return "success";
	}

	// updateメソッド。追加で使用
	public String update() {
		//sessionMapのdelete_idの値をnullにする
		this.sessionMap.put("delete_id", null);
		try {
			//bandAdd.actionページに飛ぶ
			this.response.sendRedirect("/PC2015/bandAdd.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// deleteメソッド。行の削除に使用
	public String delete() {
		//sessionMapのdelete_idの値にdelete_idの値を代入
		this.sessionMap.put("delete_id", this.delete_id);

		try {
			//bandAdd.actionページに飛ぶ
			this.response.sendRedirect("/PC2015/bandAdd.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

}
