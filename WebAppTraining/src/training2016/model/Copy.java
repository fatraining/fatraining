package training2016.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;;

@Entity
@Proxy(lazy=false)
@Table(name = "copy")
public class Copy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "image_path")
	private String img_path;

	@Column(name = "appearance")
	private int appearance;

	@Column(name = "title_id")
	private int title_id;

	@Column(name = "create_date")
	private Timestamp createdate;

	@Column(name = "create_user")
	private String createuser;

	@Column(name = "update_date")
	private Timestamp updatedate;

	@Column(name = "update_user")
	private String updateuser;

	@Column(name = "delete_flag")
	private boolean delete_flag;

	@Column(name = "exclusive_flag")
	private boolean exclusive_flag;

	@ManyToOne(targetEntity=Title.class)
	@JoinColumn(name="title_id", referencedColumnName="id", insertable=false, updatable=false)
	private Title title;

	/**
	 * @return title
	 */
	public Title getTitle() {
		return this.title;
	}

	/**
	 * @param title
	 */
	public void setTitle(Title title) {
		this.title = title;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** img_path
	 * @return
	 */
	public String getImg_path() {
		return this.img_path;
	}

	/**
	 * @param img_path
	 */
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	/**
	 * @return appearance
	 */
	public int getAppearance() {
		return this.appearance;
	}

	/**
	 * @param appearance
	 */
	public void setAppearance(int appearance) {
		this.appearance = appearance;
	}

	/** title_id
	 * @return
	 */
	public int getTitleid() {
		return this.title_id;
	}

	/**
	 * @param titleid
	 */
	public void setTitleid(int titleid) {
		this.title_id = titleid;
	}

	/**
	 * @return createdate
	 */
	public Timestamp getCreatedate() {
		return this.createdate;
	}

	/**
	 * @param createdate
	 */
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	/**
	 * @return createuser
	 */
	public String getCreateuser() {
		return this.createuser;
	}

	/**
	 * @param createuser
	 */
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	/**
	 * @return updatedate
	 */
	public Timestamp getUpdatedate() {
		return this.updatedate;
	}

	/**
	 * @param updatedate
	 */
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	/**
	 * @return updateuser
	 */
	public String getUpdateuser() {
		return this.updateuser;
	}

	/**
	 * @param updateuser
	 */
	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	/**
	 * @return delete_flag
	 */
	public boolean isDeleteflag() {
		return this.delete_flag;
	}

	/**
	 * @param deleteflag
	 */
	public void setDeleteflag(boolean deleteflag) {
		this.delete_flag = deleteflag;
	}

	/**
	 * @return exclusiveflag
	 */
	public boolean isExclusiveflag() {
		return this.exclusive_flag;
	}

	/**
	 * @param exclusiveflag
	 */
	public void setExclusiveflag(boolean exclusiveflag) {
		this.exclusive_flag = exclusiveflag;
	}
}
