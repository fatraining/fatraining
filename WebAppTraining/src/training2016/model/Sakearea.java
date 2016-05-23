package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sakearea")
public class Sakearea implements Serializable {
	private static final long setialVersionUID = 1L;

	private String ID;
	private String area;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}
	@Column(name ="area")
	public String getArea() {
		this.area = area.trim();
		return area;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setArea(String area) {
		this.area = area;
	}
}