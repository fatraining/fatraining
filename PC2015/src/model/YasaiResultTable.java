package model;

import java.io.Serializable;

public class YasaiResultTable implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String yasai ;
	private String tyouri ;
	private int tyouriId;
	private String ryouri;
	private String date_entry;
	private String date_up;
	private String userId;


	public YasaiResultTable() { }

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYasai() {
		return yasai;
	}
	public void setYasai(String yasai) {
		this.yasai = yasai;
	}
	public int getTyouriId() {
		return tyouriId;
	}
	public void setTyouriId(int tyouriId) {
		this.tyouriId = tyouriId;
	}
	public String getTyouri() {
		return tyouri;
	}
	public void setTyouri(String tyouri) {
		this.tyouri = tyouri;
	}
	public String getRyouri() {
		return ryouri;
	}
	public void setRyouri(String ryouri) {
		this.ryouri = ryouri;
	}
	public String getDate_Entry() {
		return date_entry;
	}
	public void setDate_Entry(String date_entry) {
		 this.date_entry = date_entry;
	}
	public String getDate_Up() {
		return date_up;
	}
	public void setDate_Up(String date_up) {
		 this.date_up = date_up;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	}
