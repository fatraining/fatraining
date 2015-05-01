package action;

import java.io.IOException;
import java.util.ArrayList;

import model.ResultTable6;
import controller.LikeManager;

public class Main6Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	//表示したいカラムの呼び出し・検索、削除、追加を作成
	public String series;
	public String title;
	public String do_search;
	public String delete_id;
	public String delete;

	//検索結果の表示に必要なもの
	public ArrayList<ResultTable6> outputTable;

	//検索画面
	//シリーズID
	private String getDefaultSeries() {
		this.series = "1";
		return this.series;
	}

	//タイトル
	private String getDefaultTitle() {
		this.title = "Fate/stay night";
		return this.title;
	}

	@Override
	//代入した変数の値の表示
	public String execute() {
		getDefaultSeries();
		getDefaultTitle();
		this.delete = "false";
		return "success";
	}

	//executeを初期状態に戻す。
	public String reset() {
		getDefaultSeries();
		getDefaultTitle();
		return "success";
	}
	
	//検索結果
	public String search() {
		if (this.title.isEmpty() && this.series.isEmpty()) {
			try {
				LikeManager allController = new LikeManager();
				this.outputTable = allController.resultList();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			LikeManager linkController = new LikeManager();
			this.outputTable = linkController.resultList(this.title,this.series);
		}
		this.do_search = "true";
		this.delete = "true";
		return "success";
	}
	
    //追加
	public String delete() {
		this.sessionMap.put("delete_id", this.delete_id);

		try {
			this.response.sendRedirect("/PC2015/update6.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
}
