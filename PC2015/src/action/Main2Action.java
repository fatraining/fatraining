package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Result2Table;
import controller.SweetsManager;
import action.AbstractAction;

public class Main2Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	//入力項目
	public String name; //お菓子の名前:
	public String genreNm; //ジャンル:
	public String delete_id; //削除チェックボックス
	
	//検索結果の表示(データ)
	public ArrayList<Result2Table> outputTable;
	
	//検索結果の表示フラグ
	public String do_search;
	
    //削除の表示フラグ
	public String delete;
	
	//画面が表示時に実行
	@Override
	public String execute() {

		//初期値の設定
		this.name = getDefaultName();
		this.genreNm = getDefaultGenreNm();
		
		return "success";
	}
	
	//初期値の設定（お菓子の名前）
	private String getDefaultName() {
		return "";
	}

	//初期値の設定（ジャンル）
	private String getDefaultGenreNm() {
		return "";
	}
	
	//リセットボタンを押下時
	public String reset() {
		//初期値に戻す
		this.name = getDefaultName();
		this.genreNm = getDefaultGenreNm();
		return "success";
	}
	
	// 追加ボタンを押下時
	public String add() {

		try {
			//追加画面に遷移
			this.response.sendRedirect("/PC2015/update2.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	//検索ボタンを押下時
	public String search() {

		//SQLの実行
		if (this.genreNm.isEmpty() && this.name.isEmpty()) {
			//入力がない場合
			SweetsManager allController = new SweetsManager();
			this.outputTable = allController.resultList();
		}else{
			//入力された場合
			SweetsManager linkController = new SweetsManager();
			this.outputTable = linkController.resultList(this.genreNm, this.name);
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
			this.response.sendRedirect("/PC2015/update2.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "success";		
	}

}