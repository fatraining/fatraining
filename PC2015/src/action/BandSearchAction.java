package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.BandResultTable;
import model.BandTable;
import model.BandAccount;

import org.apache.struts2.config.Result;//Main3Actionには書かれていない
import org.apache.struts2.dispatcher.ServletRedirectResult;//Main3Actionには書かれていない

import dao.BandDao;

@Result(name = "bandAdd", value = "bandAdd.action", type = ServletRedirectResult.class)
public class BandSearchAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	// フィールドの宣言
	public String band_name; // バンド名
	public String name; // 名前
	public String part; // 演奏楽器
	public String do_search; // 検索結果の表示フラグ
	public String delete_id; // 削除チェックボックス
	public String delete; // 削除ボタンの表示フラグ
	public String userId; // ログイン時のUSERに関する変数
	public String errorMsg; // エラーメッセージ表示フラグ

	// 検索結果の表示(データ)
	public ArrayList<BandResultTable> outputTable;

	// executeメソッド。
	@Override
	public String execute() {
		this.userId = (String) this.sessionMap.get("userId"); // USER名をuserIdに代入する
		this.delete = "false"; // deleteにfalseを代入し、削除ボタンを非表示に
		return "success";
	}

	// resetメソッド。入力した値を初期値に戻す。
	public String reset() {
		this.userId = (String) this.sessionMap.get("userId"); // USER名をuserIdに代入する
		this.band_name = ""; // band_nameの値を初期値に戻す
		this.name = ""; // nameの値を初期値に戻す
		this.part = ""; // partの値を初期値に戻す
		return "success";
	}

	// searchメソッド。検索結果を表示させるための処理
	public String search() {

		// 入力項目に入力された値をsessionMapで保持する。
		this.sessionMap.put("band_name", this.band_name); // sessionMap"band_name"にband_nameを代入し保持
		this.sessionMap.put("name", this.name); // sessionMap"name"にnameを代入し保持
		this.sessionMap.put("part", this.part); // sessionMap"part"にpartを代入し保持

		// BandAllManagerをインスタンス化
		BandDao bandAllManager = new BandDao();

		// userIdの取得
		this.userId = (String) this.sessionMap.get("userId");

		// list<?>型のresultTableを宣言
		List<?> bandResultTable;

		// band_nameとnameとpartの値が空だったらif文内の処理を実行
		if (this.band_name.isEmpty() && this.name.isEmpty()
				&& this.part.isEmpty()) {

			bandResultTable = bandAllManager.bandSearchAll();

		} else {

			bandResultTable = bandAllManager.bandSearchAll(this.band_name,
					this.name, this.part);

		}

		// bandResultTableを引数にbandTableTransメソッドを呼び出し、outputTableに代入
		this.outputTable = bandTableTrans(bandResultTable);

		this.do_search = "true"; // 検索結果を表示させるためにtrueを代入している
		this.delete = "true"; // 削除ボタンを表示させるためにtrueを代入している
		return "success";
	}

	// updateメソッド。追加で使用
	public String update() {

		// sessionMapのdelete_idの値をnullにする
		this.sessionMap.put("delete_id", null);

		try {
			// bandAdd.actionページに飛ぶ
			this.response.sendRedirect("/PC2015/bandAdd.action");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// deleteメソッド。行の削除に使用
	public String delete() {

		// sessionMapのdelete_idの値にdelete_idの値を代入
		this.sessionMap.put("delete_id", this.delete_id);

		// delete_idの値が空の時、エラーメッセージを表示
		if (this.delete_id == null) {

			// BandAllManagerをインスタンス化
			BandDao bandAllManager = new BandDao();

			// userIdの取得
			this.userId = (String) this.sessionMap.get("userId");

			// sessionMapを使って、入力された値を受け取る。
			this.band_name = (String) this.sessionMap.get("band_name"); // sessionMap"band_name"の値を代入
			this.name = (String) this.sessionMap.get("name"); // sessionMap"name"の値を代入
			this.part = (String) this.sessionMap.get("part"); // sessionMap"part"の値を代入

			// list<?>型のresultTableを宣言
			List<?> bandResultTable;

			// band_nameとnameとpartの値が空だったらif文内の処理を実行
			if (this.band_name.isEmpty() && this.name.isEmpty()
					&& this.part.isEmpty()) {

				bandResultTable = bandAllManager.bandSearchAll();

			} else {

				bandResultTable = bandAllManager.bandSearchAll(this.band_name,
						this.name, this.part);

			}

			// bandResultTableを引数にbandTableTransメソッドを呼び出し、outputTableに代入
			this.outputTable = bandTableTrans(bandResultTable);

			this.errorMsg = "true"; // エラーメッセージを表示させるためにtrueを代入
			this.do_search = "true"; // 検索結果を表示させるためにtrueを代入している
			this.delete = "true"; // 削除ボタンを表示させるためにtrueを代入している
			return "success";
		}

		try {
			// bandAdd.actionページに飛ぶ
			this.response.sendRedirect("/PC2015/bandAdd.action");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// SQLの検索結果を画面表示用のListに入れ替えている
	private ArrayList<BandResultTable> bandTableTrans(List<?> bandResultTable) {

		// 画面表示用のリストをインスタンス化
		ArrayList<BandResultTable> tempTable = new ArrayList<BandResultTable>();

		// 変数の初期化
		Object[] obj;

		// SQLの検索結果の件数分ループ
		for (int i = 0; i < bandResultTable.size(); i++) {

			// 画面表示用のレコードをインスタンス化
			BandResultTable temp = new BandResultTable();

			// SQLの検索結果を分解
			obj = (Object[]) bandResultTable.get(i);
			BandAccount bandaccount = (BandAccount) obj[0];
			BandTable bandtable = (BandTable) obj[1];

			// 画面表示用に設定
			temp.setId(bandaccount.getId());
			temp.setName(bandaccount.getName());
			temp.setSex(bandaccount.getSex());
			temp.setAge(bandaccount.getAge());
			temp.setSchool(bandaccount.getSchool());
			temp.setFavorite_song(bandaccount.getFavorite_song());
			temp.setPart(bandaccount.getPart());
			temp.setBand_name(bandtable.getBand_name());

			// 画面表示用にリストに追加
			tempTable.add(temp);
		}

		return tempTable;
	}
}
