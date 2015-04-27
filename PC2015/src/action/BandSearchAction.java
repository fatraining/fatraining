package action;

import java.io.IOException;
import java.util.ArrayList;

import model.BandResultTable;
import model.BandTable;
import controller.BandAllManager;
import controller.BandResultManager;

public class BandSearchAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	//フィールドの宣言
	public String user_name;
	public String band_name;
	public String name;
	public String part;
	public String result;
	public String do_print;
	public String update_id; //String型からint型に修正→再びString型に戻す。
	public String delete;
	public String userId;

	private BandResultManager linkController;
	private BandAllManager allController;
	public  ArrayList<BandResultTable> outputTable;

	//getDefaultBand_nameメソッド。バンド名の値の初期化
	private String getDefaultBand_name(){
		this.band_name = "";
		return this.band_name;
	}
	//getDefaultNameメソッド。名前の値の初期化
	private String getDefaultName(){
		this.name = "";
		return this.name;
	}
	//getDefaultpartメソッド。演奏楽器の値の初期化
	private String getDefaultPart(){
		this.part = "";
		return this.part;
	}

	//executeメソッド。
	@Override
	public String execute() {
		this.userId = (String)this.sessionMap.get("userId");
		//this.user_name = (String)this.sessionMap.get("user_name");
		this.band_name = getDefaultBand_name();
		this.name = getDefaultName();
		this.part = getDefaultPart();
		this.delete="faluse";
		return "success";
	}
	//resetメソッド。入力した値を初期値に戻す。
	public String reset(){
		this.userId = (String)this.sessionMap.get("userId");
		//this.user_name = (String)this.sessionMap.get("user_name");
		this.band_name = getDefaultBand_name();
		this.name = getDefaultName();
		this.part = getDefaultPart();
		return "success";
	}
	//printメソッド。検索結果を表示させるための処理？
	public String print(){

		/*this.band_name = checkcode(this.band_name);
		this.name = checkcode(this.name);
		this.part = checkcode(this.part);*/

		this.do_print = "true";
		this.userId = (String)this.sessionMap.get("userId");
		//this.user_name = (String)this.sessionMap.get("user_name");
		if(this.band_name.isEmpty() && this.name.isEmpty() && this.part.isEmpty()){
			//PC1007ならtryはスルーしている。これはスルーで来ていない。
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			linkController  = new BandResultManager();
			this.outputTable = linkController.bandResultList(this.band_name,this.name,this.part);
		}
		this.delete="true";
		return "success";
	}
	//printallメソッド。
	public String printall(){
		this.do_print = "true";
		this.userId = (String)this.sessionMap.get("userId");
		//this.user_name = (String)this.sessionMap.get("user_name");
		allController  = new BandAllManager();
		this.outputTable = allController.resultList(this.band_name,this.name,this.part);
		this.delete="true";
		return "success";
	}
	//updateメソッド。追加と削除で使用？
	public String update(){
		
		this.sessionMap.put("update_id",this.update_id);

		try {
			this.response.sendRedirect("/PC2015/bandAdd.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
	/*public String checkcode(String code) {
		String r = "[a-zA-Z0-9]{0,50}";
		if(code.matches(r)){
			return code;
		}
		return "";
	}*/
	
}
