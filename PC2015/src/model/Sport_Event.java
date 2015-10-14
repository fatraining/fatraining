package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sport_event")

public class Sport_Event implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String competition_number;
	private String sport;
	private String registered_person;
	private int registration_date;
	private String update_by;
	private int update_date;
	private int e_flag;
	private int d_flag;

	/*-------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "competition_number")
	public String getCompetition_number() {
		return competition_number;
	}

	@Column(name = "sport")
	public String getSport() {
		return sport;
	}

	@Column(name = "registered_person")
	public String getRegistered_person() {
		return registered_person;
	}

	@Column(name = "registration_date")
	public int getRegistration_date() {
		return registration_date;
	}

	@Column(name = "update_by")
	public String getUpdate_by() {
		return update_by;
	}

	@Column(name = "update_date")
	public int getUpdate_date() {
		return update_date;
	}

	@Column(name = "e_flag")
	public int getE_flag() {
		return e_flag;
	}

	@Column(name = "d_flag")
	public int getD_flag() {
		return d_flag;
	}

	/*-------------------------------------*/
	public void setId(int id) {
		this.id = id;
	}

	public void setCompetition_number(String competition_number) {
		this.competition_number = competition_number;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public void setRegistered_person(String registered_person) {
		this.registered_person = registered_person;
	}

	public void setRegistration_date(int registration_date) {
		this.registration_date = registration_date;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public void setUpdate_date(int update_date) {
		this.update_date = update_date;
	}

	public void setE_flag(int e_flag) {
		this.e_flag = e_flag;
	}

	public void setD_flag(int d_flag) {
		this.d_flag = d_flag;
	}

}
