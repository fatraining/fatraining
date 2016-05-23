package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "guitarMaker")
public class GuitarMaker implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String userID;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public String getId(){
		return id;
	}
	@Column(name = "name")
	public String getName(){
		this.name = name.trim();
		return name;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}

}
