package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ship")
public class Ships implements Serializable {
	private static final long serialVersionUID = 1L;

	private String shipID;
	private String countryName;
	private String shipName;
	private String countryID;
	private String shipClass;
	private int year;
	private String comment;
	private String imagePath;

	/*------------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "shipID")
	public String getShipID() {
		return shipID;
	}

	@Column(name = "countryName")
	public String getCountryName() {
		return countryName;
	}

	@Column(name = "shipName")
	public String getShipName() {
		return shipName;
	}
	@Column(name = "countryID")
	public String getCountryID() {
		return countryID;
	}
	@Column(name = "shipClass")
	public String getShipClass() {
		return shipClass;
	}
	@Column(name = "year")
	public int getYear() {
		return year;
	}
	@Column(name = "Comment")
	public String getComment() {
		return comment;
	}
	@Column(name = "imagePath")
	public String getImagePath() {
		return imagePath;
	}
	/*------------------------------------------------------*/
	public void setShipID(String iD) {
		this.shipID = iD;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public void setShipName(String shipname) {
		this.shipName = shipname;
	}
	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}
	public void setShipClass(String shipClass) {
		this.shipClass = shipClass;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setComment(String Comment) {
		this.comment = Comment;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/*------------------------------------------------------*/

}
