package model;

import java.io.Serializable;

public class Result13Table implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int ID;
	private String Name;
	private String Genre;
	private String Hardware;
	private String Comment;
	private String Company;
	
	public int getID(){
		return ID;
	}
	public void setID(int ID){
		this.ID = ID;
	}
	
	public String getName(){
		return Name;
	}
	public void setName(String Name){
		this.Name = Name;
	}
	
	public String getGenre(){
		return Genre;
	}
	public void setGenre(String Genre){
		this.Genre = Genre;
	}

	public String getHardware(){
		return Hardware;
	}
	public void setHardware(String Hardware){
		this.Hardware = Hardware;
	}
	
	public String getComment(){
		return Comment;
	}
	public void setComment(String Comment){
		this.Comment = Comment;
	}
	
	public String getCompany(){
		return Company;
	}
	public void setCompany(String Company){
		this.Company = Company;
	}
}
