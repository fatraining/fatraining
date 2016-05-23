package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="guitarInfo")
public class GuitarInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String guitarMakerId;
	private String typeName;
	private int price;
	private String comment;
	private String name;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public String getId(){
		return id;
	}

	@Column(name = "guitarMakerId")
	public String getGuitarMakerId(){
		return guitarMakerId;
	}

	@Column(name = "typeName")
	public String getTypeName(){
		return typeName;
	}

	@Column(name = "price")
	public int getPrice(){
		return price;
	}

	@Column(name = "comment")
	public String getComment(){
		return comment;
	}

	public String getName(){
		return name;
	}


	public void setId(String id) {
		this.id = id;
	}

	public void setGuitarMakerId(String guitarMakerId) {
		this.guitarMakerId = guitarMakerId;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setName(String name) {
		this.name = name;
	}



}
