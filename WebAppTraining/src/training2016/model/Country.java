package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ID;
	private String countryName;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}

	@Column(name = "countryName")
	public String getCountryName() {
		this.countryName = countryName.trim();
		return countryName;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
