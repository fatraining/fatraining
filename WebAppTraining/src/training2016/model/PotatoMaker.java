package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "potatomaker")
public class PotatoMaker implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "makerName")
	private String makerName;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String name) {
		this.makerName = name;
	}

}
