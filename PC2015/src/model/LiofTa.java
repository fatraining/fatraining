package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_like")
public class LiofTa implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String food;
	private String drink;

//	private String date_of_registration;
//	private String update_date;
//	private String registration_userid;
//	private String update_userid;
//	private int time_stamp;
//	private int delete;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "food")
	public String getFood() {
		return food;
	}

	@Column(name = "drink")
	public String getDrink() {
		return drink;
	}
//	@Column(name = "date_of_registration")
//	public String getDate_of_registration() {
//		return date_of_registration;
//	}
//	
//	@Column(name = "update_date")
//	public String getUpdate_date() {
//		return update_date;
//	}
//
//	@Column(name = "registration_userid")
//	public String getRegistration_userid() {
//		return registration_userid;
//	}
//
//	@Column(name = "update_userid")
//	public String getUpdate_userid() {
//		return update_userid;
//	}
//
//	@Column(name = "time_stamp")
//	public int getTime_stamp() {
//		return time_stamp;
//	}
//
//	@Column(name = "delete")
//	public int getDelete() {
//		return delete;
//	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}


//	public void setDate_of_registration(String date_of_registration) {
//		this.date_of_registration = date_of_registration;
//	}
//
//	public void setUpdate_date(String update_date) {
//		this.update_date = update_date;
//	}
//
//	public void setRegistration_userid(String registration_userid) {
//		this.registration_userid = registration_userid;
//	}
//
//	public void setUpdate_userid(String update_userid) {
//		this.update_userid = update_userid;
//	}
//
//	public void setTime_stamp(int time_stamp) {
//		this.time_stamp = time_stamp;
//	}

//	public void setDelete(int delete) {
//		this.delete = delete;
//	}
}
