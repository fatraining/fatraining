package action;

import java.io.IOException;
import java.util.ArrayList;

import model.BandResultTable;
import controller.BandAllManager;
import controller.BandResultManager;

public class BandSearchAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	public String user_name;
	public String band_name;
	public String name;
	public String part;
	public String result;
	public String do_print;
	public String update_id;
	public String delete;
	public String userId;

	private BandResultManager linkController;
	private BandAllManager allController;
	public  ArrayList<BandResultTable> outputTable;

	private String getDefaultBand_name(){
		this.band_name = "no-name";
		return this.band_name;
	}
	private String getDefaultName(){
		this.name = "名無し";
		return this.name;
	}
	private String getDefaultPart(){
		this.part = "なんでも";
		return this.part;
	}

	@Override
	public String execute() {
		this.userId = (String)this.sessionMap.get("userId");
		this.user_name = (String)this.sessionMap.get("user_name");
		this.band_name = getDefaultBand_name();
		this.name = getDefaultName();
		this.part = getDefaultPart();
		this.delete="faluse";
		return "success";
	}
	public String reset(){
		this.userId = (String)this.sessionMap.get("userId");
		this.user_name = (String)this.sessionMap.get("user_name");
		this.band_name = getDefaultBand_name();
		this.name = getDefaultName();
		this.part = getDefaultPart();
		return "success";
	}
	public String print(){

		/*this.band_name = checkcode(this.band_name);
		this.name = checkcode(this.name);
		this.part = checkcode(this.part);*/

		this.do_print = "true";
		this.userId = (String)this.sessionMap.get("userId");
		this.user_name = (String)this.sessionMap.get("user_name");
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
	public String printall(){
		this.do_print = "true";
		this.userId = (String)this.sessionMap.get("userId");
		this.user_name = (String)this.sessionMap.get("user_name");
		allController  = new BandAllManager();
		this.outputTable = allController.resultList(this.band_name,this.name,this.part);
		this.delete="true";
		return "success";
	}
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
