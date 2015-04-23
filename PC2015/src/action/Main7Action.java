package action;

import java.io.IOException;
import java.util.ArrayList;

import model.ResultTableMovie;
import controller.MovieManager;
import controller.Result7Manager;
import action.AbstractAction;

public class Main7Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String userId;
	public String title;
	public String genreId;
	public String exhibition_year;
	public String registration_date;
	public String renewal_date;
	public String registration_userid;
	public String renewal_userid;
	public String control;
	public String delete;
	public String do_print;
	public String update_id;
	
	private Result7Manager linkController;
	private MovieManager allController;
	public  ArrayList<ResultTableMovie> outputTableMovie;

//	private String getDefaultTitle(){
//		this.title = "";
//		return this.title;
//	}
	private String getDefaultGenre(){
		this.genreId = "";
		return this.genreId;
	}
	private String getDefaultExhibition_year(){
		this.exhibition_year = "";
		return this.exhibition_year;
	}

	@Override
	public String execute() {
		this.userId = (String)this.sessionMap.get("userId");
//		this.title = getDefaultTitle();
		this.genreId   = getDefaultGenre();
		this.exhibition_year = getDefaultExhibition_year();
		this.delete="faluse";
		return "success";
	}
	public String reset(){
		this.userId = (String)this.sessionMap.get("userId");
//		this.title = getDefaultTitle();
		this.genreId   = getDefaultGenre();
		this.exhibition_year = getDefaultExhibition_year();
		return "success";
	}
	public String print(){

//		this.title = checkcode(this.title);
		this.genreId = checkcode(this.genreId);
		this.exhibition_year = checkcode(this.exhibition_year);

		this.do_print = "true";
		this.userId = (String)this.sessionMap.get("userId");
//		if(this.title.isEmpty() && this.genre.isEmpty() && this.exhibition_year.isEmpty()){
		if(this.genreId.isEmpty() && this.exhibition_year.isEmpty()){
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			linkController  = new Result7Manager();
			this.outputTableMovie = linkController.resultList(this.genreId,this.exhibition_year);
		}
		this.delete="true";
		return "success";
	}
	public String printall(){
		this.do_print = "true";
		this.userId = (String)this.sessionMap.get("userId");
		allController  = new MovieManager();
		this.outputTableMovie = allController.resultList(this.genreId,this.exhibition_year);
		this.delete="true";
		return "success";
	}
	public String update(){
		this.sessionMap.put("update_id",this.update_id);

		try {
			this.response.sendRedirect("/PC2015/update7.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
	public String checkcode(String code) {
		String r = "[a-zA-Z0-9]{0,50}";
		if(code.matches(r)){
			return code;
		}
		return "";
	}
}
