package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ryouri")
public class Ryouri implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String tyouri;
	private String ryouri;
	private String date_entry;
	private String date_up;
	private String userId;
	private String userId_up;
	private int control;
	private int deleteflg;

	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "tyouri")
	public String getTyouri() {
		return tyouri;
	}

	@Column(name = "ryouri")
	public String getRyouri() {
		return ryouri;
	}

	@Column(name = "date_entry")
	public String getDate_Entry() {
		return date_entry;
	}

	@Column(name = "date_up")
	public String getDate_Up() {
		return date_up;
	}

	@Column(name = "userId")
	public String getUserId() {
		return userId;
	}

	@Column(name = "userId_up")
	public String getUserId_Up() {
		return userId_up;
	}

	@Column(name = "control")
	public int getControl() {
		return control;
	}

	@Column(name = "deleteflg")
	public int getDeleteFlg() {
		return deleteflg;
	}

	/*--------------------------------------------------*/

	public void setId(int id) {
		this.id = id;
	}

	public void setTyouri(String tyouri) {
		this.tyouri = tyouri;
	}

	public void setRyouri(String ryouri) {
		this.ryouri = ryouri;
	}

	public void setDate_Entry(String date_entry) {
		this.date_entry = date_entry;
	}

	public void setDate_Up(String date_up) {
		this.date_up = date_up;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserId_Up(String userId_up) {
		this.userId_up = userId_up;
	}

	public void setControl(int control) {
		this.control = control;
	}

	public void setDeleteFlg(int deleteflg) {
		this.deleteflg = deleteflg;
	}

}
