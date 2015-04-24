package model;

import java.io.Serializable;

public class Result5Table implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int phonenumber;
	private int zipcode;
	private String dwelling;
	private String name;
	private String day;
	private String newday;
	private String userid;
	private String newuserid;
	//private int delete;
	//private int flg;
	private String interest;
	private String personality;

	
	
	
	public Result5Table() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getDwelling() {
		return dwelling;
	}
	
	public void setDwelling(String dwelling) {
		this.dwelling = dwelling;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getNewday() {
		return newday;
	}

	public void setNewday(String newday) {
		this.newday = newday;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNewuserid() {
		return newuserid;
	}

	public void setNewuserid(String newuserid) {
		this.newuserid = newuserid;
	}

//	public int getDelete() {
//		return delete;
//	}
//
//	public void setDelete(int delete) {
//		this.delete = delete;
//	}
//
//	public int getFlg() {
//		return flg;
//	}
//
//	public void setFlg(int flg) {
//		this.flg = flg;
//	}
	
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
}