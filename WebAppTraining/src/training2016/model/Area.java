package training2016.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * areaテーブルと対応するモデル
 *
 * @author harasan
 */
@Entity
@Table(name = "area")
public class Area {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "create_date")
	private Timestamp createDate;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "update_date")
	private Timestamp updateDate;

	@Column(name = "update_user")
	private String updateUser;

	@Version
	@Column(name = "version")
	private int version;

	@Transient
	@OneToMany(targetEntity=Restaurant.class, mappedBy="area")//(cascade=CascadeType.ALL)
	@JoinColumn(name="id", referencedColumnName="area_id")
	private List<Restaurant> restaurantList;

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
	 * restaurantListを返す
	 *
	 * @return restaurantList
	 */
	public List<Restaurant> getRestaurantList() {
		return this.restaurantList;
	}

	/**
	 * restaurantListをセットする
	 *
	 * @param restaurantList セットする restaurantList
	 */
	public void setRestaurantList(List<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}
}
