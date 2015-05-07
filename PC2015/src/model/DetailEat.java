package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eat_detail")
public class DetailEat implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String eat_year ;
	private String eat_month ;
	private String eat_day;
	private String eat_hour;
	private String entry_day;
	private String renew_day;
	private String entry_userid;
	private String renew_userid;
	private int food_id;
	private int renew_flg;
	private int delete_flg; 
	
	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	
	@Column(name="id")
	public int getId() {
		return id;
	}
	@Column(name="eat_year")
	public String getEat_year() {
		return eat_year;
	}
	@Column(name="eat_month")
	public String getEat_month() {
		return eat_month;
	}
	@Column(name="eat_day")
	public String getEat_day() {
		return eat_day;
	}
	@Column(name="eat_hour")
	public String getEat_hour() {
		return eat_hour;
	}
	
	@Column(name="food_id")
	public int getFood_id() {
		return food_id;
	}

	@Column(name="entry_day")
	public String getEntry_day() {
		return entry_day;
	}
	@Column(name="renew_day")
	public String getRenew_day() {
		return renew_day;
	}
	@Column(name="entry_userid")
	public String getEntry_userid() {
		return entry_userid;
	}
	@Column(name="renew_userid")
	public String getRenew_userid() {
		return renew_userid;
	}
	@Column(name="renew_flg")
	public int getRenew_flg() {
		return renew_flg;
	}
	@Column(name="delete_flg")
	public int getDelete_flg() {
		return delete_flg;
	}
/*--------------------------------------------------*/

	public void setId(int id) {
		this.id = id;
	}
	public void setEat_year(String eat_year) {
		this.eat_year = eat_year;
	}
	public void setEat_month(String eat_month) {
		this.eat_month = eat_month;
	}
	public void setEat_day(String eat_day) {
		this.eat_day = eat_day;
	}
	public void setEat_hour(String eat_hour) {
		this.eat_hour = eat_hour;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public void setEntry_day(String entry_day) {
		this.entry_day = entry_day;
	}
	public void setRenew_day(String renew_day) {
		this.renew_day = renew_day;
	}
	public void setEntry_userid(String entry_userid) {
		this.entry_userid = entry_userid;
	}
	public void setRenew_userid(String renew_userid) {
		this.renew_userid = renew_userid;
	}
	public void setRenew_flg(int renew_flg) {
		this.renew_flg = renew_flg;
	}
	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}

}
