package model;

import java.io.Serializable;

public class Result9Table implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String food;
	private String drink;
	private String colorNm;
	private String taste;
	private String day;
	private String new_day;
	private String userid;
	private String new_userid;
//	private int time_stamp;
//	private int delete;

	public Result9Table() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getColorNm() {
		return colorNm;
	}

	public void setColorNm(String colorNm) {
		this.colorNm = colorNm;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getNew_day() {
		return new_day;
	}

	public void setNew_day(String new_day) {
		this.new_day = new_day;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNew_userid() {
		return new_userid;
	}

	public void setNew_userid(String new_userid) {
		this.new_userid = new_userid;
	}
//
//	public int getTime_stamp() {
//		return time_stamp;
//	}
//
//	public void setTime_stamp(int time_stamp) {
//		this.time_stamp = time_stamp;
//	}

//	public int getDelete() {
//		return delete;
//	}
//
//	public void setDelete(int delete) {
//		this.delete = delete;
//	}
}
