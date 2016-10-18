package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * onsenareaテーブルと対応するモデル
 *
 *
 */

@Entity
@Table(name = "norrisseries")
public class NorrisSeries implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "series")
	private String series;

	/**
	 * idを返す
	 *
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 *
	 * @param id
	 *            セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * areaを返す
	 *
	 * @return area
	 */
	public String getSeries() {
		return this.series;
	}

	/**
	 * areaをセットする
	 *
	 * @param area
	 *            セットする area
	 */
	public void setSeries(String series) {
		this.series = series;
	}
}
