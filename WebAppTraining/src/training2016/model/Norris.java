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
 * onsenテーブルと対応するモデル
 */
@Entity
@Proxy(lazy = false) // おまじない程度で
@Table(name = "norris")
public class Norris implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name="iine")
	private int iine;

	@Column(name = "seriesId")
	private int seriesId;

	@Column(name = "name")
	private String name;

	@Column(name = "year")
	private String year;


	@Column(name = "comment")
	private String comment;

	private String series;

	/**
	 * idを返す
	 *
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 *
	 * @param id
	 *            セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * onsenAreaIdを返す
	 *
	 * @return onsenAreaId
	 */
	public int getSeriesId() {
		return this.seriesId;
	}

	/**
	 * onsenAreaIdをセットする
	 *
	 * @param onsenAreaId
	 *            セットする osnenAreaId
	 */
	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}

	/**
	 * nameを返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * nameをセットする
	 *
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * effectを返す
	 *
	 * @return effect
	 */
	public String getYear() {
		return this.year;
	}

	/**
	 * effectをセットする
	 *
	 * @param efecte
	 *            セットする effect
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * commentを返す
	 *
	 * @return comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * commentをセットする
	 *
	 * @param comment
	 *            セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSeries() {
		return this.series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public int getIine() {
		return this.iine;
	}

	public void setIine(int iine) {
		this.iine = iine;
	}


}
