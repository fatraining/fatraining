package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Players implements Serializable {
	private static final long serialVersionUID = 1L;

	private String playerID;
	private String teamName;
	private String playerName;
	private String teamID;
	private String position;
	private int age;
	private String comment;

	/*------------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "playerID")
	public String getPlayerID() {
		return playerID;
	}

	@Column(name = "teamName")
	public String getTeamName() {
		return teamName;
	}

	@Column(name = "playerName")
	public String getPlayerName() {
		return playerName;
	}
	@Column(name = "teamID")
	public String getTeamID() {
		return teamID;
	}
	@Column(name = "position")
	public String getPosition() {
		return position;
	}
	@Column(name = "age")
	public int getAge() {
		return age;
	}
	@Column(name = "Comment")
	public String getComment() {
		return comment;
	}
	/*------------------------------------------------------*/
	public void setPlayerID(String iD) {
		this.playerID = iD;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public void setPlayerName(String playername) {
		this.playerName = playername;
	}
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setComment(String Comment) {
		this.comment = Comment;
	}

	/*------------------------------------------------------*/

}
