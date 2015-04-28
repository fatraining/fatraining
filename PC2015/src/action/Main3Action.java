package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Result3Table;
import controller.StoryManager;

public class Main3Action extends AbstractAction {
//変数にカラムを代入
	private static final long serialVersionUID = 1L;
	
	//入力項目
	public String title; //タイトル
	public String genre; //ジャンル
	public String delete_id; //削除チェックボックス
	//表示項目
	public String user_name;
	
	//検索結果の表示(データ)
	public  ArrayList<Result3Table> outputTable;
	
	//検索結果の表示フラグ
    public String do_print;
    
    //削除の表示フラグ
    public String delete;
  	
	//画面が表示時に実行
	@Override
	public String execute() {
		// ログインIDの表示
		this.user_name = (String)this.sessionMap.get("userId");
		
		//初期値の設定
		this.title = getDefaultTitle();
		this.genre = getDefaultGenre();

		return "success";
	}
	
	//初期値の設定（タイトル）
	private String getDefaultTitle(){
		return "";
	}
	
	//初期値の設定（ジャンル）
	private String getDefaultGenre(){
		return "";
	}
	
	//リセットボタンを押下時
	public String reset(){
		// ログインIDの表示
		this.user_name = (String)this.sessionMap.get("userId");
		
		//初期値の設定
		this.title = getDefaultTitle();
		this.genre = getDefaultGenre();
		
		return "success";
	}
	
	// 追加ボタンを押下時
	public String add() {

		try {
			//追加画面に遷移
			this.response.sendRedirect("/PC2015/update3.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
	
	//検索ボタンを押下時
	public String search(){
		
		//SQLの実行
		if(this.title.isEmpty() && this.genre.isEmpty()){
			//入力がない場合
			StoryManager allController  = new StoryManager();
	        this.outputTable = allController.resultList();
		}else{
			//入力された場合
			StoryManager linkController  = new StoryManager();
		    this.outputTable = linkController.resultList(this.title,this.genre);
		}

		//検索結果の表示
		this.do_print = "true";
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
			this.response.sendRedirect("/PC2015/update3.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "success";		
	}

}