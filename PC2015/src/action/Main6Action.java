package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.LikeGame;
import model.LikeSeries;
import model.ResultTable6;
import controller.LikeManager;

public class Main6Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	//表示したいカラムの呼び出し・検索、削除、追加を作成
	public String series;
	public String title;
	public String delete_id;
	//検索結果の表示フラグ
	public String do_search;
	//削除の表示フラグ
	public String add;
	public String userId; //ログイン時のUSERに関する変数

	//検索結果の表示
	public ArrayList<ResultTable6> outputTable;

	//検索画面
	//初期値の設定（シリーズID）
	private String getDefaultSeries() {
		this.series = "1";
		return "";
	}

	////初期値の設定（タイトル）
	private String getDefaultTitle() {
		this.title = "Fate/stay night";
		return "";
	}

	@Override
	//初期値の表示
	public String execute() {
		this.userId = (String) this.sessionMap.get("userId");
		this.delete_id = (String) this.sessionMap.get("delete_id");
		getDefaultSeries();
		getDefaultTitle();
		this.add = "false";
		return "success";
	}
	
	// 追加ボタンを押下時
		public String add() {
			try {
				//追加画面に遷移
				this.response.sendRedirect("/PC2015/update6.action");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}

	//リセットボタンを押下時
	public String reset() {
		this.userId = (String) this.sessionMap.get("userId");
		this.delete_id = (String) this.sessionMap.get("delete_id");
		getDefaultSeries();
		getDefaultTitle();
		return "success";
	}
	
	//検索ボタンを押下時
	public String search() {
		this.userId = (String) this.sessionMap.get("userId");
		//SQLの実行
		List<?> resultTable = null;
		if (this.title.isEmpty() && this.series.isEmpty()) {
			try {
				//未記入の場合
				LikeManager allController = new LikeManager();
				resultTable = allController.searchList();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			//記入された場合
			LikeManager linkController = new LikeManager();
			resultTable = linkController.searchList(this.title,this.series);
		}
		this.outputTable = tableTrans(resultTable);
		
		//検索結果の表示
		this.do_search = "true";
		//削除ボタンの表示
		this.add = "true";
		
		return "success";
	}
	
		// deleteメソッド。行の削除に使用
		public String delete() {
			//sessionMapのdelete_idの値にdelete_idの値を代入
			this.sessionMap.put("delete_id", this.delete_id);

			try {
				//update6.actionページに飛ぶ
				this.response.sendRedirect("/PC2015/update6.action");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "success";
		}
		
		//検索結果
		//SQLの検索結果を画面表示用のListに入れ替えている
		public ArrayList<ResultTable6> tableTrans(List<?> resultTable){
			//画面表示用のリストをインスタンス化する。
			ArrayList<ResultTable6> tempTable = new ArrayList<ResultTable6>();
			//変数の初期化
			Object[] obj;
			//SQLの検索結果の件数分ループする。
				for(int i = 0 ; i < resultTable.size() ; i++){
					ResultTable6 temp = new ResultTable6();
					obj = (Object[]) resultTable.get(i);
					LikeGame likegame = (LikeGame)obj[0];
					LikeSeries likeseries  = (LikeSeries)obj[1];
					temp.setId(likegame.getId());
					temp.setTitle(likegame.getTitle());
					temp.setSe(likeseries.getSe());
					temp.setUs(likeseries.getUs());
					temp.setUpDay(likegame.getUpDay());
					temp.setUserID(likegame.getUserID());
					temp.setUpUser(likegame.getUpUser());
					temp.setNonStyle(likegame.getNonStyle());
					temp.setDel(likegame.getDel());
					tempTable.add(temp);
				}
				
			return tempTable;
		}

}
