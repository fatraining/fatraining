package apps.yamazaki;

import java.util.ArrayList;
import java.util.List;

import apps.AbstractAction;

/**
 * Servlet implementation class MoneyAction
 */
@SuppressWarnings("unchecked")
public class MoneyAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	public String date;
	public String item;
	public String memo;
	public int money;
	//	public String balance;
	public String flg;
	//	public String sum1;
	//	public String sum2;
	public String income;
	public String spending;
	public int[] check;
	public List<MoneyDto> dtoList = null;

	public String submit() throws Exception{
		this.dtoList = (List<MoneyDto>) this.sessionMap.get("dtoList");
		if (dtoList == null) {
			this.dtoList = new ArrayList<MoneyDto>();
		}

		MoneyDto dto = new MoneyDto();
		dto.date = this.date;
		dto.item = this.item;
		dto.memo = this.memo;
		dto.flg = this.flg;
		dto.money = this.money;

//		if ("income".equals(flg)) {
//			dto.income = this.money;
//		} else {
//			dto.spending = this.money;
//		}

		this.dtoList.add(dto);
		this.sessionMap.put("dtoList", this.dtoList);

		return "success";
	}

	public int getSum1() {
		int sum = 0;

		this.dtoList = (List<MoneyDto>) this.sessionMap.get("dtoList");
		if (dtoList == null || dtoList.size() == 0) {
			return 0;
		}

		for (MoneyDto dto : this.dtoList) {
			if (dto.flg.equals("income"))
			sum += dto.money;
		}
		return sum;
	}

	public int getSum2() {
		int sum = 0;

		this.dtoList = (List<MoneyDto>) this.sessionMap.get("dtoList");
		if (dtoList == null || dtoList.size() == 0) {
			return 0;
		}

		for (MoneyDto dto : this.dtoList) {
			if (dto.flg.equals("sending")) {
				sum += dto.money;
			}
		}
		return sum;
	}

	public int getBalance() {
		int balance = 0;
		balance = this.getSum1() - this.getSum2();
		return balance;
	}

	public String delete() {
		this.dtoList = (List<MoneyDto>) this.sessionMap.get("dtoList");
		if (dtoList == null || dtoList.size() == 0) {
			return "success";
		}

		for (int i = check.length - 1; i >= 0; i--) {
			int index = check[i];
			dtoList.remove(index);
		}

		return "success";
	}


	public String gotoEdit() throws Exception {
		this.dtoList = (List<MoneyDto>) this.sessionMap.get("dtoList");
		for (int i = check.length - 1; i >= 0; i--) {
			this.sessionMap.put("editIndex",check[i]);
			this.response.sendRedirect("/Challengers/yamazaki/edit.action");
		}
		return "success";
	}

	public String execute() throws Exception {
		this.dtoList = (List<MoneyDto>) this.sessionMap.get("dtoList");
		return "success";
	}



}