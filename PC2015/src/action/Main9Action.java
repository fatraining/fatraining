package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.LiofTaManager;
import model.CoofTa;
import model.LiofTa;
import model.Result9Table;

public class Main9Action extends AbstractAction {

	private static final long serialVersionUID = 1L;
	// カラム
	public String name;
	public String food;
	public String drink;
	// 変数
	public String delete_id;
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
		LiofTaManager allController = new LiofTaManager();
		List<?> resultTable;

		if (this.name.isEmpty() && this.food.isEmpty() && this.drink.isEmpty()) {
			try {
				resultTable = allController.resultList();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			LiofTaManager linkController = new LiofTaManager();
			resultTable = linkController.resultList(this.name, this.food,
					this.drink);
		}
		this.do_print = "true";
		this.delete = "true";
		return "success";
	}

	// delete_idメソッド
	public String delete_id() {
		this.sessionMap.put("delete_id", this.delete_id);
		try {
			this.response.sendRedirect("/PC2015/update9.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "success";
	}

	public ArrayList<Result9Table> tableTrans(List<?> result9Table) {
		ArrayList<Result9Table> tempTable = new ArrayList<Result9Table>();
		Object[] obj;
		try {
			for (int i = 0; i < result9Table.size(); i++) {
				Result9Table temp = new Result9Table();
				obj = (Object[]) result9Table.get(i);
				LiofTa liofta = (LiofTa) obj[0];
				CoofTa coofta = (CoofTa) obj[1];
				temp.setId(liofta.getId());
				temp.setName(liofta.getName());
				temp.setFood(liofta.getFood());
				temp.setDrink(liofta.getDrink());
				temp.setColorNm(coofta.getColorNm());
				temp.setTaste(coofta.getTaste());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}

}
