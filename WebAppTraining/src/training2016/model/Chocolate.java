package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
*
* chocolateテーブルと対応するモデル
*/
@Entity
@Proxy(lazy = false) // おまじない程度で
@Table(name = "chocolate") //ここでどのテーブルを使うのか指定してあげる

public class Chocolate implements Serializable{
	//serializeはsessionと似ていて、情報を保持する

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "countryid")
	private int countryid;

	@Column(name = "image")
	private String image;

	@Column(name = "shopname")
	private String shopName;

	@Column(name = "price")
	private String price;

	@Column(name = "chef")
	private String chef;

	@Column(name = "comment")
	private String comment;

	private String country;




	//setter & getter




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getChef() {
		return chef;
	}

	public void setChef(String chef) {
		this.chef = chef;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



}
