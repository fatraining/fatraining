package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_color")
public class CoofTa implements Serializable {
	private static final long serialVersionUID = 1L;
	// カラム
	private int id;
	private String colorNm;
	private String day;
	private String new_day;
	private String userid;
	private String new_userid;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "colorNm")
	public String getColorNm() {
		return colorNm;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setColorNm(String colorNm) {
		this.colorNm = colorNm;
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
}