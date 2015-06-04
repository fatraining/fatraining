package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Result5Table;
import model.User_Character;
import model.User_Profile;
import dao.UserProfileDao;

public class Main5Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	// 入力項目
	public String dwelling; // 住所
	public String name; // 名前
	public String delete_id; // 削除チェックボックス

	// 表示項目
	public String user_name;

	// 検索結果の表示(データ)
	public ArrayList<Result5Table> outputTable;

	// 検索結果の表示フラグ
	public String do_search;

	// 削除の表示フラグ
	public String delete;

	// 画面が表示時に実行
	@Override
	public String execute() {
		// ログインIDの表示
		this.user_name = (String) this.sessionMap.get("userId");

		// 初期値の設定
		this.dwelling = getDefaultDwelling();
		this.name = getDefaultName();

		return "success";
	}

	// 住所の変数に値を代入(空白)
	private String getDefaultDwelling() {
		return "";
	}

	// 名前の変数に値を代入(空白)
	private String getDefaultName() {
		return "";
	}

	// リセットボタンを押下時
	public String reset() {
		// ログインIDの表示
		this.user_name = (String) this.sessionMap.get("userId");

		// 初期値の設定
		this.dwelling = getDefaultDwelling();
		this.name = getDefaultName();

		return "success";
	}

	// 追加ボタンを押下時
	public String add() {
		this.sessionMap.put("delete_id", null);
		try {
			// 追加画面に遷移
			this.response.sendRedirect("/PC2015/update5.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	// 検索ボタンを押下時
	public String search() {

		// SQLの実行
		List<?> resultTable = null;
		if (this.dwelling.isEmpty() && this.name.isEmpty()) {
			// 入力がない場合
			UserProfileDao allController = new UserProfileDao();
			resultTable = allController.searchAll();
		} else {
			// 入力された場合
			UserProfileDao linkController = new UserProfileDao();
			resultTable = linkController.searchAll(this.dwelling, this.name);
		}
		this.outputTable = tableTrans(resultTable);

		// 検索結果の表示
		this.do_search = "true";
		// 削除ボタンの表示
		this.delete = "true";

		return "success";
	}

	// 削除ボタンを押下時
	public String delete() {

		// 削除チェックボックスの値を取得しセッション（delete_id）に設定
		this.sessionMap.put("delete_id", this.delete_id);

		// 削除画面に遷移
		try {
			this.response.sendRedirect("/PC2015/update5.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	// SQLの検索結果を画面表示用のListに入れ替えている
	private ArrayList<Result5Table> tableTrans(List<?> resultTable) {

		// 画面表示用のリストをインスタンス化する。
		ArrayList<Result5Table> tempTable = new ArrayList<Result5Table>();

		// 変数の初期化
		Object[] obj;

		// SQLの検索結果の件数分ループする。
		for (int i = 0; i < resultTable.size(); i++) {

			// 画面表示用のレコードをインスタンス化する。
			Result5Table temp = new Result5Table();

			// SQLの検索結果を分解する。
			obj = (Object[]) resultTable.get(i);
			User_Profile user_profile = (User_Profile) obj[0];
			User_Character user_character = (User_Character) obj[1];
			
			// 画面表示用に設定する。
			temp.setName(user_profile.getName()); // 名前
			temp.setPersonality(user_character.getPersonality()); // 性格
			temp.setInterest(user_character.getInterest()); // 趣味
			temp.setZipcode(user_profile.getZipcode()); // 郵便番号
			temp.setDwelling(user_profile.getDwelling()); // 住所
			temp.setPhonenumber(user_profile.getPhonenumber()); // 電話番号
			temp.setId(user_profile.getId()); // 削除チェックボックス

			// 画面表示用にリストに追加する。
			tempTable.add(temp);
		}

		return tempTable;
	}
}