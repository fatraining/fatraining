package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="like_series")
public class LikeSeries implements Serializable{

	private static final long serialVersionUID = 1L;

	private int up_id;
	private String seriesNm;
	private String addDate;
	private String updateDate;
	private String addUserID;
	private String upUserID;
	private int another_flg;
	private int delete_flg;
	
	@Id
	@GeneratedValue
	@Column(name="up_id")
	public int getUp_id() {
		return up_id;
	}
	
	@Column(name="seriesNm")
	public String getSeriesNm() {
		return seriesNm;
	}
	
	@Column(name="addDate")
	public String getAddDate() {
		return addDate;
	}
	
	@Column(name="updateDate")
	public String getUpdateDate() {
		return updateDate;
	}
	
	@Column(name="addUserID")
	public String getAddUserID() {
		return addUserID;
	}
	
	@Column(name="upUserID")
	public String getUpUserID() {
		return upUserID;
	}
	
	@Column(name="another_flg")
	public int getAnother_flg() {
		return another_flg;
	}
	
	@Column(name="delete_flg")
	public int getDelete_flg() {
		return delete_flg;
	}
	
	
	public void setUp_id(int up_id) {
		this.up_id = up_id;
	}
	public void setSeriesNm(String seriesNm) {
		this.seriesNm = seriesNm;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public void setAddUserID(String addUserID) {
		this.addUserID = addUserID;
	}
	public void setUpUserID(String upUserID) {
		this.upUserID = upUserID;
	}
	public void setAnother_flg(int another_flg) {
		this.another_flg = another_flg;
	}
	public void setDelete_flg(int delete_flg) {
		this.delete_flg = delete_flg;
	}
	
	
}
