package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "baseballplayer")
public class BaseballPlayer implements Serializable{
	private static final long serialVersionUID = 1L;

	private String ID;
	private String teamID;
	private String team;
	private String baseballplayer;
	private String comment;
	private String target;
	private String date;
	private String note;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}

	@Column(name = "teamID")
	public String getTeamID() {
		return teamID;
	}

	@Column(name = "baseballplayer" )
	public String getBaseballPlayer() {
		return baseballplayer;
	}

	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	@Column(name = "target")
	public String getTarget() {
		return target;
	}

	@Column(name = "date")
	public String getDate() {
		return date;
	}

	@Column(name = "note")
	public String getNote() {
		return note;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setBaseballPlayer(String baseballplayer) {
		this.baseballplayer = baseballplayer;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setNote(String note){
		this.note = note;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
