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
 * maiwaifuテーブルと対応するモデル
 */
@Entity
@Proxy(lazy=false)  //おまじない程度で
@Table(name = "maiwaifu")
public class Maiwaifu implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "maiwaifuAreaId")
	private int maiwaifuAreaId;

	@Column(name = "image")
	private String image;

	@Column(name = "name")
	private String name;

	@Column(name = "genre")
	private String genre;

	@Column(name = "age")
	private String age;

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
	 * maiwaifuAreaIdを返す
	 * @return maiwaifuAreaId
	 */
	public int getMaiwaifuAreaId() {
		return this.maiwaifuAreaId;
	}

	/**
	 * MaiwaifuAreaIdをセットする
	 * @param MaiwaifuAreaId セットする MaiwaifuAreaId
	 */
	public void setMaiwaifuAreaId(int maiwaifuAreaId) {
		this.maiwaifuAreaId = maiwaifuAreaId;
	}

	/** imageを返す
	 * @return image */
	public String getImage() {
		return this.image;
	}

	/** imageをセットする
	 * @param image セットする image */
	public void setImage(String image) {
		this.image = image;
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
	public String getGenre() {
		return this.genre;
	}

	/**
	 * genreをセットする
	 * @param genre セットする genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * hoursを返す
	 * @return hours
	 */
	public String getAge() {
		return this.age;
	}

	/**
	 * hoursをセットする
	 * @param hours セットする hours
	 */
	public void setAge(String age) {
		this.age = age;
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
