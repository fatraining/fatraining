package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "season")
public class Season implements Serializable{
	private static final long serialVersionUID = 1L;

	private String KisetuID;
	private String Kisetu;

	@Id
	@GeneratedValue

	@Column(name = "KisetuID")
	public String getKisetuID(){
		return KisetuID;
	}

	@Column(name = "Kisetu")
	public String getKisetu(){
		this.Kisetu = Kisetu.trim();
		return Kisetu;
	}
	public void setKisetuID(String KisetuID){
		this.KisetuID = KisetuID;
	}
	public void setKisetu(String Kisetu){
		this.Kisetu = Kisetu;
	}



}
