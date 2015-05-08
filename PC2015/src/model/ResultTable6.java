package model;

import java.io.Serializable;

public class ResultTable6 implements Serializable {

	private static final long serialVersionUID = 1L;

	//カラム
	private String id;
	private String title;
	private String series;
	private String trump;
	private String origin;
	
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getSeries() {
		return series;
	}
	public String getTrump() {
		return trump;
	}
	public String getOrigin() {
		return origin;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public void setTrump(String trump) {
		this.trump = trump;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}



}