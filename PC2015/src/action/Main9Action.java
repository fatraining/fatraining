package action;

import java.io.IOException;
import java.util.ArrayList;

import controller.LiofTaManager;
import model.Result9Table;

public class Main9Action extends AbstractAction {

	private static final long serialVersionUID = 1L;
	// カラム
	public String name;
	public String food;
	public String drink;
	// 変数
	public String update_id;
	public String delete;
	public String do_print;

	public ArrayList<Result9Table> outputTable;

	// 変数に値を代入する（この場合空白）
	private String getDefaultName() {
		return "";
	}

	// 変数に値を代入する（この場合空白）
	private String getDefaultFood() {
		return "";
	}

	// 変数に値を代入する（この場合空白）
	private String getDefaultDrink() {
		return "";
	}

	// executeメソッド
	@Override
	public String execute() {
		this.name = getDefaultName();
		this.food = getDefaultFood();
		this.drink = getDefaultDrink();
		this.delete = "faluse";
		return "success";
	}

	// resetメソッド
	public String reset() {
		this.name = getDefaultName();
		this.food = getDefaultFood();
		this.drink = getDefaultDrink();
		return "success";
	}

	// searchメソッド
	public String search() {
		if (this.name.isEmpty() && this.food.isEmpty() && this.drink.isEmpty()) {
			try {
				LiofTaManager allController = new LiofTaManager();
				this.outputTable = allController.resultList();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			LiofTaManager linkController = new LiofTaManager();
			this.outputTable = linkController.resultList(this.name, this.food,
					this.drink);
		}
		this.do_print = "true";
		this.delete = "true";
		return "success";
	}

	// updateメソッド
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
