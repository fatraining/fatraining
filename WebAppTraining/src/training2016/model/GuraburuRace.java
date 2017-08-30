package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
/**
 * guraburu_character_infoテーブルと対応するモデル
 *
 */
@Entity
@Proxy(lazy=false)  //おまじない程度で
@Table(name = "guraburu_race")
public class GuraburuRace  implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;


	/**
	 * idを返す
	 * @return
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * nameを返す
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * nameをセットする
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}



}
