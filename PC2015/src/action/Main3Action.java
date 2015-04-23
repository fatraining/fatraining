package action;

import java.io.IOException;
import java.util.ArrayList;

import model.Result3Table;
import controller.StoryManager;
import controller.Result3Manager;

public class Main3Action extends AbstractAction {

	private static final long serialVersionUID = 1L;
	public String user_name;
	public int ID;
	public String title;
	public String genre;
//	public String signup;
//	public String update;
//	public String signupUSERID;
//	public String updateUSERID;
//	public String exclusiveFLG;
//    public String deleteFLG;
    public String do_print;
	public String update_id;
	public String delete;

    private Result3Manager linkController;
	private StoryManager allController;
	public  ArrayList<Result3Table> outputTable;

	private String getDefaultTitle(){
		this.title = "";
		return this.title;
	}
	private String getDefaultGenre(){
		this.genre = "";
		return this.genre;
	}
	
	

	@Override
	public String execute() {
		this.user_name = (String)this.sessionMap.get("user_name");
		this.title = getDefaultTitle();
		this.genre = getDefaultGenre();
		this.delete="faluse";

		return "success";
	}
	public String reset(){
		this.title = getDefaultTitle();
		this.genre = getDefaultGenre();
		
		return "success";
	}
	public String print(){
		
		this.do_print = "true";
		if(this.title.isEmpty() && this.genre.isEmpty()){
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			linkController  = new Result3Manager();
       this.outputTable = linkController.resultList(this.title,this.genre);
		}
		this.do_print="true";
		return "success";
	}
	public String printall(){
		this.do_print = "true";
        allController  = new StoryManager();
        this.outputTable = allController.resultList();
		this.do_print="true";
		return "success";
	}
	public String update(){
		this.sessionMap.put("update_id",this.update_id);

		try {
			this.response.sendRedirect("/PC2015/update3.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}
	
}