package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/** sneakersMakerテーブルと対応するモデル */


@Entity
@Table(name = "sneakersmaker")
public class SneakersMaker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "maker")
	private String maker;


	/** idを返す
	 * @return id */
	public String getId() {
		return this.id;
	}

	/** idをセットする
	 * @param id セットする id */
	public void setId(String id) {
		this.id = id;
	}

	/** makerを返す
	 * @return maker */
	public String getMaker() {
		return this.maker;
	}

	/** makerをセットする
	 * @param maker セットする maker */
	public void setMaker(String maker) {
		this.maker = maker;
	}
}