package endpoint;

import java.time.LocalDateTime;

public class Contents {

	private String name;
	private String toDo;
	private String who;
	private int num;
	private String time;
	private LocalDateTime limit;
	private String limitText;
	private String ex;
	private int flg;
	private String yattal;
	// YatteMainでIDふってあげてね
	private int No;

	// getter,setter類//
	public String getToDo() {
		return toDo;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getYattal() {
		return yattal;
	}

	public void setYattal(String yattal) {
		this.yattal = yattal;
	}

	public int getFlg() {
		return flg;
	}

	public void setFlg(int flg) {
		this.flg = flg;
	}

	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public LocalDateTime getLimit() {
		return limit;
	}

	public void setLimit(LocalDateTime localTime) {
		this.limit = localTime;
	}

	public String getLimitText() {
		return limitText;
	}

	public void setLimitText(String limitText) {
		this.limitText = limitText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
