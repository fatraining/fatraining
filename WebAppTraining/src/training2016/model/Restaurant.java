package training2016.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Proxy;

/**
 * restaurantテーブルと対応するモデル
 *
 * @author harasan
 */
@Entity
@Proxy(lazy=false)
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "stars")
	private short stars;

	@Column(name = "comment")
	private String comment;

	@Column(name = "area_id")
	private int areaId;

	@Column(name = "create_date")
	private Timestamp createDate;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "update_date")
	private Timestamp updateDate;

	@Column(name = "update_user")
	private String updateUser;

	@Column(name = "version")
	@Version
	private int version;

	@ManyToOne(targetEntity=Area.class)
	@JoinColumn(name="area_id", referencedColumnName="id", insertable=false, updatable=false)
	private Area area;

	/**
	 * idを返す
	 *
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * idをセットする
	 *
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * nameを返す
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * nameをセットする
	 *
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * starsを返す
	 *
	 * @return stars
	 */
	public short getStars() {
		return this.stars;
	}

	/**
	 * starsをセットする
	 *
	 * @param stars セットする stars
	 */
	public void setStars(short stars) {
		this.stars = stars;
	}

	/**
	 * commentを返す
	 *
	 * @return comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * commentをセットする
	 *
	 * @param comment セットする comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * areaIdを返す
	 *
	 * @return areaId
	 */
	public int getAreaId() {
		return this.areaId;
	}

	/**
	 * areaIdをセットする
	 *
	 * @param areaId セットする areaId
	 */
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	/**
	 * createDateを返す
	 *
	 * @return createDate
	 */
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	/**
	 * createDateをセットする
	 *
	 * @param createDate セットする createDate
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	/**
	 * createUserを返す
	 *
	 * @return createUser
	 */
	public String getCreateUser() {
		return this.createUser;
	}

	/**
	 * createUserをセットする
	 *
	 * @param createUser セットする createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * updateDateを返す
	 *
	 * @return updateDate
	 */
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * updateDateをセットする
	 *
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * updateUserを返す
	 *
	 * @return updateUser
	 */
	public String getUpdateUser() {
		return this.updateUser;
	}

	/**
	 * updateUserをセットする
	 *
	 * @param updateUser セットする updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * versionを返す
	 *
	 * @return version
	 */
	public int getVersion() {
		return this.version;
	}

	/**
	 * versionをセットする
	 *
	 * @param version セットする version
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * areaを返す
	 *
	 * @return area
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * areaをセットする
	 *
	 * @param area セットする area
	 */
	public void setArea(Area area) {
		this.area = area;
	}


}
