package model;

import java.io.Serializable;

public class Result5Table implements Serializable {

	private static final long serialVersionUID = 1L;

	//表示させるカラム名
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
	//idを表示
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	//phonenumberを表示
	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	//zipcodeを表示
	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	//dwellingを表示
	public String getDwelling() {
		return dwelling;
	}
	
	public void setDwelling(String dwelling) {
		this.dwelling = dwelling;
	}
	//nameを表示
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	//personalityを表示
	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}
	//dayを表示
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	//newdayを表示
	public String getNewday() {
		return newday;
	}

	public void setNewday(String newday) {
		this.newday = newday;
	}
	//useridを表示
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	//newuseridを表示
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
	
	//interestを表示
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
}