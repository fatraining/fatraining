package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//task_masteDBのテーブルtable_profile
@Entity
@Table(name = "table_profile")
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
//カラム名
	private int id;
	private String name;
	private String personality;
	private String home;
	private int birthday;
	private String day;
	private String new_day;
	private String userid;
	private String new_userid;
//	private int time_stamp;
//	private int delete;

	/*--------------------------------------------------*/
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

	@Column(name = "personality")
	public String getPersonality() {
		return personality;
	}

	@Column(name = "home")
	public String getHome() {
		return home;
	}

	@Column(name = "birthday")
	public int getBirthday() {
		return birthday;
	}

	@Column(name = "day")
	public String getDay() {
		return day;
	}

	@Column(name = "new_day")
	public String getNew_day() {
		return new_day;
	}

	@Column(name = "userid")
	public String getUserid() {
		return userid;
	}

	@Column(name = "new_userid")
	public String getNew_userid() {
		return new_userid;
	}

//	@Column(name = "time_stamp")
//	public int getTime_stamp() {
//		return time_stamp;
//	}
//
//	@Column(name = "delete")
//	public int getDelete() {
//		return delete;
//	}

	/*--------------------------------------------------*/

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setNew_day(String new_day) {
		this.new_day = new_day;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setNew_userid(String new_userid) {
		this.new_userid = new_userid;
	}

//	public void setTime_stamp(int time_stamp) {
//		this.time_stamp = time_stamp;
//	}
//
//	public void setDelete(int delete) {
//		this.delete = delete;
//	}
}
