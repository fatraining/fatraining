package model;

import java.io.Serializable;

public class Result10Table implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String eat_year;
	private String eat_month;
	private String eat_day;
	private String eat_hour;
	private String food_id;
	private String eatFood;
	private String eatCalory;
	private String entry_day;
	private String renew_day;
	private String entry_userid;
	private String renew_userid;
	private int renew_flg;
	private int delete_flg;

	public Result10Table() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEat_year() {
		return eat_year;
	}

	public void setEat_year(String eat_year) {
		this.eat_year = eat_year;
	}

	public String getEat_month() {
		return eat_month;
	}

	public void setEat_month(String eat_month) {
		this.eat_month = eat_month;
	}

	public String getEat_day() {
		return eat_day;
	}

	public void setEat_day(String eat_day) {
		this.eat_day = eat_day;
	}

	public String getEat_hour() {
		return eat_hour;
	}

	public void setEat_hour(String eat_hour) {
		this.eat_hour = eat_hour;
	}

	public String getFood_id() {
		return food_id;
	}

	public void setFood_id(String food_id) {
		this.food_id = food_id;
	}

	public String getEatFood() {
		return eatFood;
	}

	public void setEatFood(String eatFood) {
		this.eatFood = eatFood;
	}

	public String getEatCalory() {
		return eatCalory;
	}

	public void setEatCalory(String eatCalory) {
		this.eatCalory = eatCalory;
	}

	public String getEntry_day() {
		return entry_day;
	}

	public void setEntry_day(String entry_day) {
		this.entry_day = entry_day;
	}

	public String getRenew_day() {
		return renew_day;
	}

	public void setRenew_day(String renew_day) {
		this.renew_day = renew_day;
	}

	public String getEntry_userid() {
		return entry_userid;
	}

	public void setEntry_userid(String entry_userid) {
		this.entry_userid = entry_userid;
	}

	public String getRenew_userid() {
		return renew_userid;
	}

	public void setRenew_userid(String renew_userid) {
		this.renew_userid = renew_userid;
	}

	public int getRenew_flg() {
		return renew_flg;
	}

	public void setRenew_flg(int renew_flg) {
		this.renew_flg = renew_flg;
	}

	public int getDelete_flg() {
		return delete_flg;
	}

	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}
}
