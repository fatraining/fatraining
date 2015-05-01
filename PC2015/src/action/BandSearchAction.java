package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.BandResultTable;
import model.BandTable;
import controller.BandAllManager;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

@Result(name = "bandAdd", value = "bandAdd.action", type = ServletRedirectResult.class)
public class BandSearchAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	// フィールドの宣言
	public String band_name; //バンド名
	public String name; //名前
	public String part; //演奏楽器
	public String do_search; //検索結果の表示フラグ
	public String delete_id; //削除チェックボックス
	public String delete; //削除ボタンの表示フラグ
	public String userId; //ログイン時のUSERに関する変数

	//検索結果の表示(データ)
	public ArrayList<BandResultTable> outputTable;

	// executeメソッド。
	@Override
	public String execute() {
		this.userId = (String) this.sessionMap.get("userId"); //USER名をuserIdに代入する
		this.band_name = ""; //band_nameに初期値を代入する
		this.name = ""; //nameに初期値を代入する
		this.part = ""; //partに初期値を代入する
		this.delete = "false"; //deleteにfalseを代入し、削除ボタンを非表示に
		return "success";
	}

	// resetメソッド。入力した値を初期値に戻す。
	public String reset() {
		this.userId = (String) this.sessionMap.get("userId"); //USER名をuserIdに代入する
		this.band_name = ""; //band_nameの値を初期値に戻す
		this.name = ""; //nameの値を初期値に戻す
		this.part = ""; //partの値を初期値に戻す
		return "success";
	}

	// printメソッド。検索結果を表示させるための処理→printメソッドからsearchメソッドに名前の変更
	public String search() {
		
		//BandAllManagerをインスタンス化
		BandAllManager bandAllManager = new BandAllManager();
		
		//userIdの取得
		this.userId = (String) this.sessionMap.get("userId");
		
		//list<?>型のresultTableを宣言
		List<?> bandResultTable;
		
		//band_nameとnameとpartの値が空だったらif文内の処理を実行
		if (this.band_name.isEmpty() && this.name.isEmpty()
				&& this.part.isEmpty()) {
			
			//bandResultTable = bandAllManager.bandResultList();
			this.outputTable = bandAllManager.bandResultList();
			
		} else {
			
			//bandResultTable = bandAllManager.bandResultList(this.band_name,this.name,this.part);
			this.outputTable = bandAllManager.bandResultList(this.band_name,this.name,this.part);
			
		}
		
		this.do_search = "true"; //検索結果を表示させるためにtrueを代入している
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
