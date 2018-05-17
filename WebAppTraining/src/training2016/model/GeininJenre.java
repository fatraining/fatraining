package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * geininjenreテーブルと対応するモデル
 *
 *
 */

@Entity
@Table(name = "geininjenre")
public class GeininJenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	/**
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return jenre
	 */
	public String getJenre() {
		return this.jenre;
	}

	/**
	 * @param jenre セットする jenre
	 */
	public void setJenre(String jenre) {
		this.jenre = jenre;
	}

	@Column(name = "jenre")
	private String jenre;



}
