package model;

import java.io.Serializable;

public class ResultTable implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String name ;
	private String genreNm;
	private String record_date;
	private String reset_date;
	private String entry_userId;
	private String record_userId;
	private String exclusive_FLG;
	private String delete_FLG;

	public ResultTable() { }

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
	public String getGenreNm() {
		return genreNm;
	}
	public void setGenreNm(String genreNm) {
		this.genreNm = genreNm;
	}
	public String getRecord_date() {
		return record_date;
	}
	public void setRecord_date(String record_date) {
		this.record_date = record_date;
	}
	public String getReset_date() {
		return reset_date;
	}
	public void setReset_date(String reset_date) {
		this.reset_date = reset_date;
	}
	public String getEntry_userId() {
		return entry_userId;
	}
	public void setEntry_userId(String entry_userId) {
		this.entry_userId = entry_userId;
	}
	public String getRecord_userId() {
		return record_userId;
	}
	public void setRecord_userId(String record_userId) {
		this.record_userId = record_userId;
	}
	public String getExclusive_FLG() {
		return exclusive_FLG;
	}
	public void setExclusive_FLG(String exclusive_FLG) {
		this.exclusive_FLG = exclusive_FLG;
	}
	public String getDelete_FLG() {
		return delete_FLG;
	}
	public void setDelete_FLG(String delete_FLG) {
		this.delete_FLG = delete_FLG;
	}
}
