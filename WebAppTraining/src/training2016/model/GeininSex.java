package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * geininsexテーブルと対応するモデル
 *
 *
 */

@Entity
@Table(name = "geininsex")
public class GeininSex implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "sex")
	private String sex;

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
	 * @return sex
	 */
	public String getSex() {
		return this.sex;
	}

	/**
	 * @param sex セットする sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}





}
