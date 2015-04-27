package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Result10Table;
import controller.All10Manager;
import controller.Result10Manager;

public class Main10Action extends AbstractAction {


	private static final long serialVersionUID = 1L;

	public String eat_year;
	public String eat_month;
	public String eat_day;
	public String eat_hour;
	public String result;
	public String do_search;
	public String update_id;
	public String delete;
	public String userId;

	private Result10Manager linkController;
	private All10Manager allController;
	public  ArrayList<Result10Table> outputTable;

	private String getDefaultEat_year(){//eat_yearのデフォルト値は2015
		this.eat_year = "2015";
		return this.eat_year;
	}
	private String getDefaultEat_month(){//eat_monthのデフォルト値は1
		this.eat_month = "1";
		return this.eat_month;
	}
	private String getDefaultEat_day(){//eat_dayのデフォルト値は1
		this.eat_month = "1";
		return this.eat_month;
	}
	private String getDefaultEat_hour(){//eat_hourのデフォルト値はAM
		this.eat_hour = "AM";
		return this.eat_hour;
	}

	@Override//スーパークラスのメソッドをサブクラスで書きなおすこと（これにより検索画面でデフォルト値が出力される）
	public String execute() { //executeメソッドを作る（始めにデフォルト値を検索欄に表示させておくという記述をする）
		this.userId = (String)this.sessionMap.get("userId"); // sessionMapに保存していたuserIDを取得
		this.eat_year = getDefaultEat_year(); //デフォルト値の取得
		this.eat_month   = getDefaultEat_month(); //デフォルト値の取得
		this.eat_day = getDefaultEat_day(); //デフォルト値の取得
		this.eat_hour = getDefaultEat_hour(); //デフォルト値の取得
		this.delete="faluse"; //deleteボタンの生成はない
		return "success";
	}
	
	public String reset(){ //resetメソッドを作る
		this.userId = (String)this.sessionMap.get("userId"); //userIdの取得
		this.eat_year = getDefaultEat_year(); //デフォルト値の取得
		this.eat_month   = getDefaultEat_month(); //デフォルト値の取得
		this.eat_day = getDefaultEat_day(); //デフォルト値の取得
		this.eat_hour = getDefaultEat_hour(); //デフォルト値の取得
		return "success";
	}
	
	public String search(){ //searchメソッド
		this.do_search = "true"; //ボタン表示
		this.userId = (String)this.sessionMap.get("userId");
		if(this.eat_year.isEmpty() && this.eat_month.isEmpty() && this.eat_day.isEmpty() && this.eat_hour.isEmpty()){
			//もしすべて空だった場合は
			try {/*IOE例外が発生するかもしれない処理*/
				searchall(); //searchallすること
			} catch (Exception e) { //IOE例外キャッチ
				e.printStackTrace();
			}
		}else{ //空でなかったら 検索結果の表示をする
			linkController  = new Result10Manager();
			this.outputTable = linkController.resultList(this.eat_year,this.eat_month,this.eat_day,this.eat_hour);
		}
		this.delete="true"; //deleteボタンができる
		return "success";
	}
	
	public String searchall(){ //searchallメソッド
		this.do_search = "true"; //ボタン表示（searchとは同じボタンでsearchallする）
		allController  = new All10Manager(); //todo
		this.outputTable = allController.resultList(); //searchよりsearchallは値が空のときについてなので引数なし
		this.delete="true"; //deleteボタンができる
		return "success";
	}
	
	public String update(){
		this.sessionMap.put("update_id",this.update_id);//update_idを取得する
		try {//IOE例外が発生するかもしれない処理
			this.response.sendRedirect("/PC2015/update10.action"); //UpdateActionに接続する
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
}