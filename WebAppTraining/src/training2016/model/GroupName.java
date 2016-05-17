package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groupName")
public class GroupName implements Serializable{
	private static final long serialVersionUID = 1L;


	private String GroupID;
	private String groupName;

	@Id
	@GeneratedValue
	@Column(name = "GroupID")
	public String getGroupID(){
		return GroupID;
	}
	@Column(name = "groupName")
	public String getGroupName(){
		this.groupName = groupName.trim();
		return groupName;
	}

	public void setGroupID(String GroupID){
		this.GroupID = GroupID;
	}
	public void setGroupName(String groupName){
		this.groupName = groupName;
	}
}
