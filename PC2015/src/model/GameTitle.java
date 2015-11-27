package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gametitle")
public class GameTitle implements Serializable {

	private static final long serialVersionUID = 1L;

	private int ID;
	private String Name;
	private int CompanyID;
	private String Genre;
	private String Hardware;
	private String Comment;
	private String RegisteredUserID;
	
	/*-------------------------------------*/
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public int getID() {
		return ID;
	}

	@Column(name = "Name")
	public String getName() {
		return Name;
	}

	@Column(name = "CompanyID")
	public int getCompanyID() {
		return CompanyID;
	}

	@Column(name = "Genre")
	public String getGenre() {
		return Genre;
	}

	@Column(name = "Hardware")
	public String getHardware() {
		return Hardware;
	}

	@Column(name = "Comment")
	public String getComment() {
		return Comment;
	}
	
	@Column(name = "RegistrationUserID")
	public String getRegisteredUserID() {
		return RegisteredUserID;
	}

	/*-------------------------------------*/
	
	public void setID(int ID) {
		this.ID = ID;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setCompanyID(int CompanyID) {
		this.CompanyID = CompanyID;
	}

	public void setGenre(String Genre) {
		this.Genre = Genre;
	}

	public void setHardware(String Hardware) {
		this.Hardware = Hardware;
	}

	public void setComment(String Comment) {
		this.Comment = Comment;
	}
	
	public void setRegisteredUserID(String RegisteredUserID){
		this.RegisteredUserID = RegisteredUserID;
	}

}
