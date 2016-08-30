package training2016.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * maiwaifuareaテーブルと対応するモデル
 *
 *
 */

@Entity
@Table(name = "maiwaifuarea")
public class MaiwaifuArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "area")
	private String area;


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
	 * areaを返す
	 * @return area
	 */
	public String getArea() {
		return this.area;
	}

	/**
	 * areaをセットする
	 * @param area セットする area
	 */
	public void setArea(String area) {
		this.area = area;
	}
}
