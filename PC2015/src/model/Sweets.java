package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sweets")
public class Sweets implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String genre_id;
//	private String record_date;
//	private String reset_date;
//	private String entry_userId;
//	private String record_userId;
//	private String exclusive_FLG;
//	private String delete_FLG;

	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name="id")
	public String getId() {
		return id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	@Column(name="genre_id")
	public String getGenre_id() {
		return genre_id;
	}
//	@Column(name="record_date")
//	public String getRecord_date() {
//		return record_date;
//	}
//	@Column(name="reset_date")
//	public String getReset_date() {
//		return reset_date;
//	}
//	@Column(name="entry_userId")
//	public String getEntry_userId() {
//		return entry_userId;
//	}
//	@Column(name="record_userId")
//	public String getRecord_userId() {
//		return record_userId;
//	}
//	@Column(name="exclusive_FLG")
//	public String getExclusive_FLG() {
//		return exclusive_FLG;
//	}
//	@Column(name="delete_FLG")
//	public String getDelete_FLG() {
//		return delete_FLG;
//	}
/*--------------------------------------------------*/

	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}
//	public void setRecord_date(String record_date) {
//		this.record_date = record_date;
//	}
//	public void setReset_date(String reset_date) {
//		this.reset_date = reset_date;
//	}
//	public void setEntry_userId(String entry_userId) {
//		this.entry_userId = entry_userId;
//	}
//	public void setRecord_userId(String record_userId) {
//		this.record_userId = record_userId;
//	}
//	public void setExclusive_FLG(String exclusive_FLG) {
//		this.exclusive_FLG = exclusive_FLG;
//	}
//	public void setDelete_FLG(String delete_FLG) {
//		this.delete_FLG = delete_FLG;
//	}
	
}
