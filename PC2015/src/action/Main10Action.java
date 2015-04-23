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
	public String eatFood;
	public String eatCalory;
//	public String entry_day;
//	public String renew_day;
//	public String entry_userrid;
	public String renew_userid;
	public String result;
	public String do_search;
	public String update_id;
	public String delete;
	public String userId;

	private Result10Manager linkController;
	private All10Manager allController;
	public  ArrayList<Result10Table> outputTable;

	private String getDefaultEat_year(){
		this.eat_year = "2015";
		return this.eat_year;
	}
	private String getDefaultEat_month(){
		this.eat_month = "1";
		return this.eat_month;
	}
	private String getDefaultEat_day(){
		this.eat_month = "1";
		return this.eat_month;
	}
	private String getDefaultEat_hour(){
		this.eat_hour = "AM";
		return this.eat_hour;
	}

	@Override
	public String execute() {
		this.userId = (String)this.sessionMap.get("userId");
		this.eat_year = getDefaultEat_year();
		this.eat_month   = getDefaultEat_month();
		this.eat_day = getDefaultEat_day();
		this.eat_hour = getDefaultEat_hour();
		this.delete="faluse";
		return "success";
	}
	public String reset(){
		this.userId = (String)this.sessionMap.get("userId");
		this.eat_year = getDefaultEat_year();
		this.eat_month   = getDefaultEat_month();
		this.eat_day = getDefaultEat_day();
		this.eat_hour = getDefaultEat_hour();
		return "success";
	}
	public String search(){

		this.do_search = "true";
		this.userId = (String)this.sessionMap.get("userId");
		if(this.eat_year.isEmpty() && this.eat_month.isEmpty() && this.eat_day.isEmpty() && this.eat_hour.isEmpty()){
			try {
				searchall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			linkController  = new Result10Manager();
			this.outputTable = linkController.resultList(this.eat_year,this.eat_month,this.eat_day,this.eat_hour);
		}
		this.delete="true";
		return "success";
	}
	public String searchall(){
		this.do_search = "true";
		this.userId = (String)this.sessionMap.get("userId");
		allController  = new All10Manager();
		this.outputTable = allController.resultList();
		this.delete="true";
		return "success";
	}
	
	public String update(){
		this.sessionMap.put("update_id",this.update_id);

		try {
			this.response.sendRedirect("/PC2015/update10.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
//	public String checkcode(String code) {
//		String r = "[a-zA-Z0-9]{0,50}";
//		if(code.matches(r)){
//			return code;
//		}
//		return "";
//	}
}