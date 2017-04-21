package training2016.model;

import java.io.Serializable;
import java.sql.Date;
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

@Entity
@Table(name = "title")
public class Title implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "release_date")
	private Date releasedate;

	@Column(name = "create_date")
	private Timestamp createdate;

	@Column(name = "create_user")
	private String createuser;

	@Column(name = "update_date")
	private Timestamp updatedate;

	@Column(name = "update_user")
	private String updateuser;

	@Column(name = "delete_flag")
	private boolean deleteflag;

	@Column(name = "exclusive_flag")
	private boolean exclusiveflag;

	@Transient
	@OneToMany(targetEntity=Copy.class, mappedBy="title")//(cascade=CascadeType.ALL)
	@JoinColumn(name="id", referencedColumnName="title_id")
	private List<Copy> copyList;


	/**
	 * @return id
	 */
	public int getId() {
		return id;
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
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return releasedate
	 */
	public Date getReleasedate() {
		return releasedate;
	}
	/**
	 * @param releasedate
	 */
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	/**
	 * @return createdate
	 */
	public Timestamp getCreatedate() {
		return createdate;
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
		return createuser;
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
		return updatedate;
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
		return updateuser;
	}
	/**
	 * @param updateuser
	 */
	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
	/**
	 * @return deleteflag
	 */
	public boolean isDeleteflag() {
		return deleteflag;
	}
	/**
	 * @param deleteflag
	 */
	public void setDeleteflag(boolean deleteflag) {
		this.deleteflag = deleteflag;
	}
	/**
	 * @return exclisiveflag
	 */
	public boolean isExclusiveflag() {
		return exclusiveflag;
	}
	/**
	 * @param exclusiveflag
	 */
	public void setExclusiveflag(boolean exclusiveflag) {
		this.exclusiveflag = exclusiveflag;
	}

	/**
	 * @return copyList
	 */
	public List<Copy> getCopyList() {
		return this.copyList;
	}

	/**
	 * @param copyList
	 */
	public void setCopyList(List<Copy> copyList) {
		this.copyList = copyList;
	}

}
