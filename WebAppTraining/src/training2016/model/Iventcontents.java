package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "iventcontents")
public class Iventcontents implements Serializable{
	private static final long serialVersionUID = 1L;

	private String ID;
	private String groupID;
	private String category;
	private String iventName;
	private String place;
	private String day;
	private String comment;
	private String groupName;


	/*------------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}
	@Column(name = "groupID")
	public String getGroupID() {
		return groupID;
	}
	@Column(name = "category")
	public String getCategory() {
		return category;
	}
	@Column(name = "iventName")
	public String getIventName() {
		return iventName;
	}
	@Column(name = "place")
	public String getPlace() {
		return place;
	}
	@Column(name = "day")
	public String getDay() {
		return day;
	}
	@Column(name = "comment")
	public String getComment() {
		return comment;
	}
	public String getGroupName() {
		return this.groupName;
	}
	/*------------------------------------------------------*/

	public void setID(String ID){
		this.ID = ID;
	}
	public void setGroupID(String groupID){
		this.groupID = groupID;
	}
	public void setCategory(String category){
		this.category = category;
	}
	public void setIventName(String iventName){
		this.iventName = iventName;
	}
	public void setPlace(String place){
		this.place = place;
	}
	public void setDay(String day){
		this.day = day;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/*------------------------------------------------------*/

}


