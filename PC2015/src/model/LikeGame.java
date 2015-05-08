package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="like_game")
public class LikeGame implements Serializable{

	private static final long serialVersionUID = 1L;

	// カラム

	private int id;
	private String title;
	private int seriesId;
	private String trump;
	private String origin;
	private String addDate;
	private String updateDate;
	private String addUserID;
	private String upUserID;
	private int another_flg;
	private int delete_flg;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	
	@Column(name="seriesId")
	public int getSeriesId() {
		return seriesId;
	}
	
	@Column(name="trump")
	public String getTrump() {
		return trump;
	}
	
	@Column(name="Origin")
	public String getOrigin() {
		return origin;
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
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}
	public void setTrump(String trump) {
		this.trump = trump;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
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
