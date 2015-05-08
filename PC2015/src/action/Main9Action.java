package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.LiofTaManager;
import model.CoofTa;
import model.LiofTa;
import model.Result9Table;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

@Result(name = "update9", value = "update9.action", type = ServletRedirectResult.class)
public class Main9Action extends AbstractAction {

	private static final long serialVersionUID = 1L;
	// カラム
	public String name;
	public String food;
	public String drink;
	// 変数
	public String delete_id;
	public String delete;
	public String do_search;

	public ArrayList<Result9Table> outputTable;

	// 初期値の設定
	private String getDefaultName() {
		return "";
	}
	
	// 初期値の設定
	private String getDefaultFood() {
		return "";
	}
	
	// 初期値の設定
	private String getDefaultDrink() {
		return "";
	}

	// executeメソッド
	@Override
	public String execute() {
		this.name = getDefaultName();
		this.food = getDefaultFood();
		this.drink = getDefaultDrink();
		this.delete = "false";
		return "success";
	}

	// resetメソッド 初期値に返す
	public String reset() {
		this.name = getDefaultName();
		this.food = getDefaultFood();
		this.drink = getDefaultDrink();
		return "success";
	}

	// searchメソッド 検索
	public String search() {
		
		// インスタンス化
		LiofTaManager lioftamamager = new LiofTaManager();
		List<?> resultTable;

		if (this.name.isEmpty() && this.food.isEmpty() && this.drink.isEmpty()) {
			resultTable = lioftamamager.resultList();
		} else {
			resultTable = lioftamamager.resultList(this.name, this.food,
					this.drink);
		}
		this.outputTable = tableTrans(resultTable);

		this.do_search = "true";
		this.delete = "true";
		return "success";
	}
	
	//updateメソッド
	public String update() {
		this.sessionMap.put("delete_id", null);

		try {
			this.response.sendRedirect("/PC2015/update9.action");
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	private ArrayList<Result9Table> tableTrans(List<?> resultTable) {
		ArrayList<Result9Table> tempTable = new ArrayList<Result9Table>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result9Table temp = new Result9Table();
				obj = (Object[]) resultTable.get(i);
				LiofTa liofta = (LiofTa) obj[0];
				CoofTa coofta = (CoofTa) obj[1];
				temp.setId(liofta.getId());
				temp.setName(liofta.getName());
				temp.setFood(liofta.getFood());
				temp.setDrink(liofta.getDrink());
				temp.setColorNm(coofta.getColorNm());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}
