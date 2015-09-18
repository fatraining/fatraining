package model;

import java.io.Serializable;

public class KaisyaResultTable implements Serializable {

	private static final long serialVersionUID = 1L;
	// 画面に表示させたいカラム名
	private String id;
	private String syamei;
	private String name;
	private String nyusyabi;
	private String busyo;
	private String comment;
	private int busyo_id;

	public KaisyaResultTable() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSyamei() {
		return syamei;
	}

	public void setSyamei(String syamei) {
		this.syamei = syamei;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNyusyabi() {
		return nyusyabi;
	}

	public void setNyusyabi(String nyusyabi) {
		this.nyusyabi = nyusyabi;
	}

	public String getBusyo() {
		return busyo;
	}

	public void setBusyo(String busyo) {
		this.busyo = busyo;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getBusyo_id() {
		return busyo_id;
	}

	public void setBusyo_id(int busyo_id) {
		this.busyo_id = busyo_id;
	}

}
