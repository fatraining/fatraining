package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catcafe")
public class Catcafe implements Serializable{
	private static final long serialVersionUID = 1L;

	private String ID;
	private String station;
	private String catcafeName;
	private String prefecture;
	private String prefectureID;
	private String hours;
	private String closed;
	private String comment;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}

	@Column(name = "station")
	public String getStation() {
		return station;
	}

	@Column(name = "catcafeName" )
	public String getCatcafeName() {
		return catcafeName;
	}

	@Column(name = "prefectureID")
	public String getPrefectureID() {
		return prefectureID;
	}

	@Column(name = "hours")
	public String getHours() {
		return hours;
	}

	@Column(name = "closed")
	public String getClosed() {
		return closed;
	}

	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public void setCatcafeName(String catcafeName) {
		this.catcafeName = catcafeName;
	}

	public void setPrefectureID(String prefectureID) {
		this.prefectureID = prefectureID;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

}
