package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/** sneakersテーブルと対応するモデル */

@Entity
@Proxy(lazy=false)
@Table(name = "sneakers")
public class Sneakers implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "sneakersMakerId")
	private int sneakersMakerId;

	@Column(name = "name")
	private String name;

	@Column(name = "series")
	private String series;

	@Column(name = "year")
	private String year;

	@Column(name = "comment")
	private String comment;

	@Column(name = "image")
	private String image;

	private String maker;


	/** idを返す
	 *  @return id */
	public int getId() {
		return this.id;
	}

	/** idをセットする
	 * @param id セットする id */
	public void setId(int id) {
		this.id = id;
	}

	/** sneakersMakerIdを返す
	 * @return SneakersMakerId */
	public int getSneakersMakerId() {
		return this.sneakersMakerId;
	}

	/** SneakersMakerIdをセットする
	 * @param SneakersMakerId セットする SneakersMakerId */
	public void setSneakersMakerId(int sneakersMakerId) {
		this.sneakersMakerId = sneakersMakerId;
	}

	/** seriesを返す
	 * @return series */
	public String getSeries() {
		return this.series;
	}

	/** seriesをセットする
	 * @param series セットする series */
	public void setSeries(String series) {
		this.series = series;
	}

	/** yearを返す
	 * @return year */
	public String getYear() {
		return this.year;
	}

	/** yearをセットする
	 * @param year セットする year */
	public void setYear(String year) {
		this.year = year;
	}

	/** nameを返す
	 * @return name */
	public String getName() {
		return this.name;
	}

	/** nameをセットする
	 * @param name セットする name */
	public void setName(String name) {
		this.name = name;
	}

	/** commentを返す
	 * @return comment */
	public String getComment() {
		return this.comment;
	}

	/** commentをセットする
	 * @param comment セットする comment */
	public void setComment(String comment) {
		this.comment = comment;
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

	public String getMaker() {
		return this.maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}
}