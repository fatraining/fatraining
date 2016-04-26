package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ID;
	private String teamname;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}

	@Column(name = "teamname")
	public String getTeamName() {
		this.teamname = teamname.trim();
		return teamname;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setTeamName(String teamname) {
		this.teamname = teamname;
	}
}
