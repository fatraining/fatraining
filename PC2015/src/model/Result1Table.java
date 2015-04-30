package model;

import java.io.Serializable;

public class Result1Table implements Serializable {

	private static final long serialVersionUID = 1L;
//画面に表示させたいカラム名
	private String id;
	private String name;
	private String personality;
	private String home;
	private int birthday;
	private String hobby;
	private String day;
	private String new_day;
	private String userid;
	private String new_userid;
//	private int time_stamp;
//	private int delete;

	public Result1Table() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
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

//	public int getTime_stamp() {
//		return time_stamp;
//	}
//
//	public void setTime_stamp(int time_stamp) {
//		this.time_stamp = time_stamp;
//	}
//
//	public int getDelete() {
//		return delete;
//	}
//
//	public void setDelete(int delete) {
//		this.delete = delete;
//	}
}
