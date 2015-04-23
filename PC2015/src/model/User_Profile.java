package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class User_Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int phonenumber;
	private int zipcode;
	private String dwelling;

	private String name;
	private int personality2;
	private String day;
	private String newday;

	private String userid;
	private String newuserid;
	private int delete;
	private int flg;

	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "phonenumber")
	public int getPhonenumber() {
		return phonenumber;
	}

	@Column(name = "zipcode")
	public int getZipcode() {
		return zipcode;
	}

	@Column(name = "dwelling")
	public String getDwelling() {
		return dwelling;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "personality2")
	public int getPersonality2() {
		return personality2;
	}

	@Column(name = "day")
	public String getDay() {
		return day;
	}

	@Column(name = "newday")
	public String getNewday() {
		return newday;
	}

	@Column(name = "userid")
	public String getUserid() {
		return userid;
	}

	@Column(name = "newuserid")
	public String getNewuserid() {
		return newuserid;
	}

	@Column(name = "delete")
	public int getDelete() {
		return delete;
	}

	@Column(name = "flg")
	public int getFlg() {
		return flg;
	}

	/*--------------------------------------------------*/
	public void setId(int id) {
		this.id = id;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public void setDwelling(String dwelling) {
		this.dwelling = dwelling;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPersonality2(int personality2) {
		this.personality2 = personality2;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setNewday(String newday) {
		this.newday = newday;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setNewuserid(String newuserid) {
		this.newuserid = newuserid;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public void setFlg(int flg) {
		this.flg = flg;
	}

}
