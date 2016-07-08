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
 * aquariumテーブルと対応するモデル
 */
@Entity
@Proxy(lazy=false)  //おまじない程度で
@Table(name = "aquarium")
public class Aquarium implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "aquariumAreaId")
	private int aquariumAreaId;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private String price;

	@Column(name = "hours")
	private String hours;

	@Column(name = "comment")
	private String comment;

	private String area;


	/**
	 * idを返す
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * aquariumAreaIdを返す
	 * @return aquariumAreaId
	 */
	public int getAquariumAreaId() {
		return this.aquariumAreaId;
	}

	/**
	 * aquariumAreaIdをセットする
	 * @param aquariumAreaId セットする aquariumAreaId
	 */
	public void setAquariumAreaId(int aquariumAreaId) {
		this.aquariumAreaId = aquariumAreaId;
	}

	/**
	 * nameを返す
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * nameをセットする
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * priceを返す
	 * @return price
	 */
	public String getPrice() {
		return this.price;
	}

	/**
	 * priceをセットする
	 * @param price セットする price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * hoursを返す
	 * @return hours
	 */
	public String getHours() {
		return this.hours;
	}

	/**
	 * hoursをセットする
	 * @param hours セットする hours
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}

	/**
	 * commentを返す
	 * @return comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * commentをセットする
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
