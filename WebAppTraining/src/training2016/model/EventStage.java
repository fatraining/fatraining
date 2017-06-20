package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
@Table(name = "eventstage")
public class EventStage implements Serializable{
	private static final long serialVersionUID = 1L;

	private int ID;
	private String name;
	private String area;
	private int areaID;
	private String station;
	private String record;
	private String comment;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public int getID() {
		return ID;
	}

	@Column(name = "station")
	public String getStation() {
		return station;
	}

	@Column(name = "name" )
	public String getName() {
		return name;
	}

	@Column(name = "areaID")
	public int getAreaID() {
		return areaID;
	}

	@Column(name = "record")
	public String getRecord() {
		return record;
	}

	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	@Column(name = "area")
	public String getArea() {
		return area;
	}

	public void setID(Integer integer) {
		this.ID = integer;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public void setArea(String area) {
		this.area = area;
	}


}
