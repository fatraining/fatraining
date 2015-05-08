package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Genre;
import model.Result2Table;
import model.Sweets;
import controller.SweetsManager;

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
	
	public String add_id;

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

	
	
	
	
	//追加ボタンを押下時
	public String add() {
		
		//削除チェックボックスの値を取得しセッション（add_id）に設定
		this.sessionMap.put("delete_id",null);
		
		//削除画面に遷移
		try {
			this.response.sendRedirect("/PC2015/update2.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "success";		
	}


	//検索ボタンを押下時
	public String search() {

		//SQLの実行
		List<?> resultTable = null;
		if (this.name.isEmpty() && this.genreNm.isEmpty()) {
			//入力がない場合
			SweetsManager allController = new SweetsManager();
			resultTable = allController.searchAll();
		}else{
			//入力された場合
			SweetsManager linkController = new SweetsManager();
			resultTable = linkController.searchAll(this.genreNm, this.name);
		}
		this.outputTable = tableTrans(resultTable);
		
		
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
	
	// SQLの検索結果を画面表示用のListに入れ替えている
	private ArrayList<Result2Table> tableTrans(List<?> resultTable) {

		// 画面表示用のリストをインスタンス化する。
		ArrayList<Result2Table> tempTable = new ArrayList<Result2Table>();

		// 変数の初期化
		Object[] obj;

		// SQLの検索結果の件数分ループする。
		for (int i = 0; i < resultTable.size(); i++) {
			// 画面表示用のレコードをインスタンス化する。
			Result2Table temp = new Result2Table();

			// SQLの検索結果を分解する。
			obj = (Object[]) resultTable.get(i);
			Sweets sweets = (Sweets) obj[0];
			Genre genre = (Genre) obj[1];

			// 画面表示用に設定する。
			temp.setName(sweets.getName()); // 名前
			temp.setGenreNm(genre.getGenreNm()); // ジャンル
			temp.setId(sweets.getId()); // 削除チェックボックス

			// 画面表示用にリストに追加する。
			tempTable.add(temp);
		}

		return tempTable;
	}

}