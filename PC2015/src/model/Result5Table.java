package model;

import java.io.Serializable;

public class Result5Table implements Serializable {

	private static final long serialVersionUID = 1L;

	//表示させるカラム名
	private String name;
	private String personality;
	private String interest;
	private int zipcode;
	private String dwelling;
	private int phonenumber;
	private String id;
	
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
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
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
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}