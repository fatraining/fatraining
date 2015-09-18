package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//　task_masteDBのテーブルtable_kaisya
@Entity
@Table(name = "table_kaisya")
public class Kaisya implements Serializable {

	private static final long serialVersionUID = 1L;
	// カラム名
	private String id;
	private String syamei;
	private String name;
	private String nyusyabi;
	private int busyo_id;
	private String comment;
	private String day_entry;
	private String day_up;
	private String userId;
	private String userId_up;

	 private int control;
	 private int deleteflg;
	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	public String getId() {
		return id;
	}

	@Column(name = "syamei")
	public String getSyamei() {
		return syamei;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "nyusyabi")
	public String getNyusyabi() {
		return nyusyabi;
	}

	@Column(name = "busyo_id")
	public int getBusyo_id() {
		return busyo_id;
	}

	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	@Column(name = "day_entry")
	public String getDay_entry() {
		return day_entry;
	}

	@Column(name = "day_up")
	public String getDay_up() {
		return day_up;
	}

	@Column(name = "userId")
	public String getUserId() {
		return userId;
	}

	@Column(name = "userId_up")
	public String getUserId_up() {
		return userId_up;
	}

	 @Column(name = "control")
	 public int getControl() {
	 return control;
	 }
	
	 @Column(name = "deleteflg")
	 public int getDeleteflg() {
	 return deleteflg;
	 }

	/*--------------------------------------------------*/

	public void setId(String id) {
		this.id = id;
	}

	public void setSyamei(String syamei) {
		this.syamei = syamei;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNyusyabi(String nyusyabi) {
		this.nyusyabi = nyusyabi;
	}

	public void setBusyo_id(int busyo_id) {
		this.busyo_id = busyo_id;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setDay_entry(String day_entry) {
		this.day_entry = day_entry;
	}

	public void setDay_up(String day_up) {
		this.day_up = day_up;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserId_up(String userId_up) {
		this.userId_up = userId_up;
	}

	 public void setControl(int control) {
	 this.control = control;
	 }
	
	 public void setDeleteflg(int deleteflg) {
	 this.deleteflg = deleteflg;
	 }
}
