package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nationalteamplayer")
public class NationalTeamPlayer implements Serializable {

	private static final long serialVersionUID = 1L;


	private int id;
	private String number;
	private String name;
	private int nationalTeamId;
	private String position;
	private String RegisteredUserId;

	/*-------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "number")
	public String getNumber() {
		return number;
	}

	@Column(name ="name")
	public String getName() {
		return name;
	}

	@Column(name = "nationalteamid")
	public int getNationalTeamId() {
		return nationalTeamId;
	}

	@Column(name = "position")
	public String getPosition() {
		return position;
	}

	@Column(name = "RegisteredUserId")
	public String getRegisteredUserId() {
		return RegisteredUserId;
	}

	/*-------------------------------------*/

	public void setId(int id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNationalTeamId(int nationalTeamId) {
		this.nationalTeamId = nationalTeamId;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setRegisteredUserId(String RegisteredUserId) {
		this.RegisteredUserId = RegisteredUserId;
	}

}
