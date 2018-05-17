package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * geininjimushoテーブルと対応するモデル
 *
 *
 */

@Entity
@Table(name = "geininjimusho")
public class GeininJimusho implements Serializable {
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
	 * @return jimusho
	 */
	public String getJimusho() {
		return this.jimusho;
	}

	/**
	 * @param jimusho セットする jimusho
	 */
	public void setJimusho(String jimusho) {
		this.jimusho = jimusho;
	}

	@Column(name = "jimusho")
	private String jimusho;



}
