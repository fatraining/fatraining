package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "biketeam")

public class BikeTeam implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ID ;
	private String TeamName ;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID(){
		return ID ;
	}
	@Column(name = "TeamName")
	public String getTeamName(){
		return TeamName ;
	}

	public void setID(String ID){
		this.ID = ID ;
	}
	public void setTeamName(String TeamName){
		this.TeamName = TeamName ;
	}

}
