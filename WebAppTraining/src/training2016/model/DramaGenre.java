package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * dramaGenreテーブルと対応するモデル
 *
 *
 */

@Entity
@Table(name = "dramagenre")
public class DramaGenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "genre")
	private String genre;


	/**
	 * idを返す
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * genreを返す
	 * @return genre
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
}
