package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false) // おまじない程度で
@Table(name = "potatoproduct")
public class PotatoProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "makerId")
	private int makerId;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "volume")
	private int volume;

	@Column(name = "price")
	private int price;

	@Column(name = "comment")
	private String comment;

	private String makerName;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMakerId() {
		return this.makerId;
	}

	public void setMakerId(int makerId) {
		this.makerId = makerId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

}
