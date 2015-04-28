package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Result5Table;
import controller.UserProfileManager;

public class Main5Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	//入力項目
	public String dwelling; //住所
	public String name; //名前
	public String delete_id; //削除チェックボックス
	
	//表示項目
	public String user_name;
	
	//検索結果の表示(データ)
	public ArrayList<Result5Table> outputTable;
	
	//検索結果の表示フラグ
	public String do_search;
	
    //削除の表示フラグ
	public String delete;
	
	//画面が表示時に実行
	@Override
	public String execute() {
		// ログインIDの表示
		this.user_name = (String) this.sessionMap.get("userId");

		//初期値の設定
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

	//リセットボタンを押下時
	public String reset() {
		// ログインIDの表示
		this.user_name = (String) this.sessionMap.get("userId");

		//初期値の設定
		this.dwelling = getDefaultDwelling();
		this.name = getDefaultName();
		
		return "success";
	}
	
	// 追加ボタンを押下時
	public String add() {

		try {
			//追加画面に遷移
			this.response.sendRedirect("/PC2015/update5.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	//検索ボタンを押下時
	public String search() {

		//SQLの実行
		if (this.dwelling.isEmpty() && this.name.isEmpty()) {
			//入力がない場合
			UserProfileManager allController = new UserProfileManager();
			this.outputTable = allController.resultList();
		}else{
			//入力された場合
			UserProfileManager linkController = new UserProfileManager();
			this.outputTable = linkController.resultList(this.dwelling,
					this.name);
		}
		
		//検索結果の表示
		this.do_search = "true";
		//削除ボタンの表示
		this.delete = "true";
		
		return "success";
	}
	
	//削除ボタンを押下時
	public String delete() {
		
		//削除チェックボックスの値を取得しセッション（delete_id）に設定
		this.sessionMap.put("delete_id",this.delete_id);
		
		//削除画面に遷移
		try {
			this.response.sendRedirect("/PC2015/update5.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";		
	}

}