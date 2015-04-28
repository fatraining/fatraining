package model;

import java.io.Serializable;

public class ResultTableMovie implements Serializable{

	private static final long serialVersionUID = 1L;

	//検索結果を表示させるための変数とメソッド
	private int id;
	private String title ;
	private String genre ;
	private int exhibition_year ;
	private String registration_date;
	private String renewal_date;
	private String registration_userid;
	private String renewal_userid ;
//	private int control;
//	private int delete ;

	public ResultTableMovie() { }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getExhibition_year() {
		return exhibition_year;
	}
	public void setExhibition_year(int exhibition_year) {
		this.exhibition_year = exhibition_year;
	}
	public String getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	public String getRenewal_date() {
		return renewal_date;
	}
	public void setRenewal_date(String renewal_date) {
		this.renewal_date = renewal_date;
	}
	public String getRregistration_userid() {
		return registration_userid;
	}
	public void setRegistration_userid(String registration_userid) {
		this.registration_userid = registration_userid;
	}
	public String getRenewal_userid() {
		return renewal_userid;
	}
	public void setRenewal_userid(String renewal_userid) {
		this.renewal_userid = renewal_userid;
	}
//	public int getControl() {
//		return control;
//	}
//	public void setControl(int control) {
//		this.control = control;
//	}
//	public int getDelete() {
//		return delete;
//	}
//	public void setDelete(int delete) {
//		this.delete = delete;
//	}
}
