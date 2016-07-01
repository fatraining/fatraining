package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beerbrands")
public class Beerbrands implements Serializable{
	private static final long serialVersionUID = 1L;

	private String ID;
	private String country;
	private String beerbrands;
	private String countryID;
	private String categories;
	private String comment;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}

	@Column(name = "beerbrands" )
	public String getBeerbrands() {
		return beerbrands;
	}

	@Column(name = "countryID")
	public String getCountryID() {
		return countryID;
	}

	@Column(name = "categories")
	public String getCategories() {
		return categories;
	}

	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setBeerbrands(String beerbrands) {
		this.beerbrands = beerbrands;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public void setComment(String comment){
		this.comment = comment;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
