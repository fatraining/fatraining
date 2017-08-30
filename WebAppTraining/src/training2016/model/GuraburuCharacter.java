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
@Table(name = "guraburu_character_info")
public class GuraburuCharacter  implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "sex")
	private String sex;


	@Column(name = "attribute")
	private String attribute;

	@Column(name = "raceId")
	private int raceId;

	@Column(name = "comment")
	private String comment;

	@Column(name = "registerdData")
	private String registerdData;

	@Column(name = "raceName")
	private String raceName;

	@Column(name = "dataUrl")
	private String dataUrl;

	/**
	 * idを返す
	 * @return
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 * @param id
	 */
	public void setId(Integer id) {
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

	/**
	 * sexを返す
	 * @return
	 */
	public String getSex() {
		return this.sex;
	}

	/**
	 * sexをセットする
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * attributeを返す
	 * @return
	 */
	public String getAttribute() {
		return this.attribute;
	}

	/**
	 * attributeをセットする
	 * @param attribute
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * raceIdを返す
	 * @return
	 */
	public Integer getRaceId() {
		return this.raceId;
	}

	/**
	 * raceIdをセットする
	 * @param raceId
	 */
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}

	/**
	 * commentを返す
	 * @return
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * commentをセットする
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * RegisterdDataを返す
	 * @return
	 */
	public String getRegisterdData() {
		return this.registerdData;
	}

	/**
	 * RegisterdDataをセットする
	 * @param registerdData
	 */
	public void setRegisterdData(String registerdData) {
		this.registerdData = registerdData;
	}
	/**
	 * raceNameを返す
	 * @return
	 */
	public String getRaceName() {
		return this.raceName;
	}
	/**
	 * raceNameをセットする
	 * @param raceName
	 */
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setRaceId(int raceId) {
		this.raceId = raceId;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}


}
