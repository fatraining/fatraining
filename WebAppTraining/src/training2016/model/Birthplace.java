package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "birthplace")
public class Birthplace implements Serializable{
	private static final long serialVersionUID = 1L;

	private String ID;
	private String country;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}
