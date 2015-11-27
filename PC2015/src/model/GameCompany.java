package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gamecompany")
public class GameCompany implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private int ID;
	private String Company;
	
	/*-------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public int getID() {
		return ID;
	}
	
	@Column(name = "CompanyName")
	public String getCompany() {
		return Company;
	}

	/*-------------------------------------*/
	
	public void setID(int ID) {
		this.ID = ID;
	}

	public void setCompany(String Company) {
		this.Company = Company;
	}

}
