package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Character")
public class User_Character implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String personality;
	private String interest;
	private String day;
	private String newday;
	private String userid;
	private String newuserid;
//	private int delete;
//	private int flg;

	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "personality")
	public String getPersonality() {
		return personality;
	}

	@Column(name = "interest")
	public String getInterest() {
		return interest;
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
		return userid;
	}

//	@Column(name = "delete")
//	public int getDelete() {
//		return delete;
//	}
//
//	@Column(name = "flg")
//	public int getFlg() {
//		return flg;
//	}

	/*--------------------------------------------------*/
	public void setId(int id) {
		this.id = id;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public void setInterest(String interest) {
		this.interest = interest;
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

//	public void setDelete(int delete) {
//		this.delete = delete;
//	}
//
//	public void setFlg(int flg) {
//		this.flg = flg;
//	}
}
