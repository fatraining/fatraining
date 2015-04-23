package action;

import java.io.IOException;
import java.util.ArrayList;

import controller.LiofTaManager;
import controller.Result9Manager;
import model.Result9Table;

public class Main9Action extends AbstractAction {

	private static final long serialVersionUID = 1L;

	public String name;
	public String food;
	public String drink;
	public String search;
	public String result;
	public String update_id;
	public String delete;
	public String do_print;

	private Result9Manager linkController;
	private LiofTaManager allController;
	public ArrayList<Result9Table> outputTable;


	private String getDefaultName() {
		this.name = "";
		return this.name;
	}

	private String getDefaultFood() {
		this.food = "";
		return this.food;
	}

	private String getDefaultDrink() {
		this.drink = "";
		return this.drink;
	}

	@Override
	public String execute() {
		this.name = getDefaultName();
		this.food = getDefaultFood();
		this.drink = getDefaultDrink();
		this.delete = "faluse";
		return "success";
	}

	public String reset() {
		this.name = getDefaultName();
		this.food = getDefaultFood();
		this.drink = getDefaultDrink();
		return "success";
	}

	public String search() {
		this.do_print = "true";
		if (this.name.isEmpty() && this.food.isEmpty() && this.drink.isEmpty()) {
			try {
				printall();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			linkController = new Result9Manager();
			this.outputTable = linkController.resultList(this.name, this.food,
					this.drink);
		}
		this.delete = "true";
		return "success";
	}

	public String printall() {
		this.do_print = "true";
		allController = new LiofTaManager();
		this.outputTable = allController.resultList();
		this.delete = "true";
		return "success";
	}

	public String update() {
		this.sessionMap.put("update_id", this.update_id);
		try {
			this.response.sendRedirect("/PC2015/update9.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

}
