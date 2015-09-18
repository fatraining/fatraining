package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//　task_masteDBのテーブルtable_profile
@Entity
@Table(name = "table_profile")
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	// カラム名
	private String id;
	private String name;
	private String personality;
	private String home;
	private String birthday;
	private int hobby_id;
	private String day;
	private String new_day;
	private String userid;
	private String new_userid;

	 private int dbflg;
	 private int deleteflg;
	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	public String getId() {
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
	public String getBirthday() {
		return birthday;
	}

	@Column(name = "hobby_id")
	public int getHobby_id() {
		return hobby_id;
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

	 @Column(name = "dbflg")
	 public int getDbflg() {
	 return dbflg;
	 }
	
	 @Column(name = "deleteflg")
	 public int getDeleteflg() {
	 return deleteflg;
	 }

	/*--------------------------------------------------*/

	public void setId(String id) {
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

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setHobby_id(int hobby_id) {
		this.hobby_id = hobby_id;
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

	 public void setDbflg(int dbflg) {
	 this.dbflg = dbflg;
	 }
	
	 public void setDeleteflg(int deleteflg) {
	 this.deleteflg = deleteflg;
	 }
}
