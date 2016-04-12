package apps.yamazaki;

import java.util.List;

import apps.AbstractAction;

public class EditAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	public String date;
	public String item;
	public String memo;
	public int money;
	public String income;
	public String spending;
	public Integer index;
	public String flg;
	public List<MoneyDto> dtoList;

	public String execute() throws Exception {
		this.dtoList = (List<MoneyDto>) this.sessionMap.get("dtoList");
		this.index = (Integer) this.sessionMap.get("editIndex");
		MoneyDto dto = dtoList.get(this.index);
		this.date = dto.date;
		this.money = dto.money;
		this.income = String.valueOf(dto.income);
		this.spending = String.valueOf(dto.spending);
		this.item = dto.item;
		this.memo = dto.memo;
		this.flg = dto.flg;
		return "success";
	}

	public String submit() throws Exception {

		this.dtoList = (List<MoneyDto>) this.sessionMap.get("dtoList");

		MoneyDto dto = new MoneyDto();
		dto.date = this.date;
		dto.item = this.item;
		dto.memo = this.memo;
		dto.flg = this.flg;
		dto.money = this.money;

		this.index = (int)this.sessionMap.get("editIndex");
		this.dtoList.set(this.index, dto);

		this.response.sendRedirect("/Challengers/yamazaki/money.action");

		return "success";
	}

}