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
 * dramaテーブルと対応するモデル
 */
@Entity
@Proxy(lazy=false)  //おまじない程度で
@Table(name = "drama")
public class Drama implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "dramaGenreId")
	private int dramaGenreId;

	@Column(name = "name")
	private String name;

	@Column(name = "cast")
	private String cast;

	@Column(name = "tvStation")
	private String tvStation;

	@Column(name = "comment")
	private String comment;

	private String genre;


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
	 * dramaGenreIdを返す
	 * @return dramaGenreId
	 */
	public int getDramaGenreId() {
		return this.dramaGenreId;
	}

	/**
	 * dramaGenreIdをセットする
	 * @param dramaGenreId セットする dramaGenreId
	 */
	public void setDramaGenreId(int dramaGenreId) {
		this.dramaGenreId = dramaGenreId;
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
	 * castを返す
	 * @return cast
	 */
	public String getCast() {
		return this.cast;
	}

	/**
	 * castをセットする
	 * @param cast セットする cast
	 */
	public void setCast(String cast) {
		this.cast = cast;
	}

	/**
	 * tvStationを返す
	 * @return tvStation
	 */
	public String getTvStation() {
		return this.tvStation;
	}

	/**
	 * tvStationをセットする
	 * @param tvStation セットする tvStation
	 */
	public void setTvStation(String tvStation) {
		this.tvStation = tvStation;
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

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
