package action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import dao.StoryDao;

@Result(name = "main3", value = "main3.action", type = ServletRedirectResult.class)
public class Update3Action extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	
	//入力項目
	public String title; //タイトル
	public String genre; //ジャンル
	
	//表示項目（削除画面）
	public String delete_id;
	
	//画面が表示時に実行
	public String execute() throws Exception {
		//削除ボタンが押下　or 追加画面の判定
		this.delete_id = (String) this.sessionMap.get("delete_id");
		
		//初期値の設定
		this.title = "黒い家";
		this.genre = "ホラー";

		return "success";
	}
	
	//追加ボタンを押下時
	public String insert() {
		
		StoryDao storyManager = new StoryDao();
		storyManager.insert(this.genre, this.title, (String) this.sessionMap.get("userId"));
		
		return "main3";
	}
	
	// 削除ボタンを押下時
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");

		if (this.delete_id.isEmpty()) {
			return "main5";
		}

		StoryDao storyManager = new StoryDao();
		storyManager.delete(this.delete_id);

		return "main3";
	}
	

}
