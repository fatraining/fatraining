package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attendances")
public class Attendances implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int year;
	private int month;
	private int day;
	private String inTime;
	private String outTime;
	private String comment;
	private int userId;
	private String createdAt;
	private String updatedAt;
	private int status;
	
	/*-------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	@Column(name = "year")
	public int getYear() {
		return year;
	}
	
	@Column(name = "month")
	public int getMonth() {
		return month;
	}
	
	@Column(name = "day")
	public int getDay(){
		return day;
	}
	
	@Column(name = "in_time")
	public String getInTime(){
		return inTime;
	}
	
	@Column(name = "out_time")
	public String getOutTime(){
		return outTime;
	}
	
	@Column(name = "comment")
	public String getComment(){
		return comment;
	}
	
	@Column(name = "user_id")
	public int getUserId(){
		return userId;
	}
	
	@Column(name = "created_at")
	public String getCreatedAt(){
		return createdAt;
	}
	
	@Column(name = "updated_at")
	public String getUpdatedAt(){
		return updatedAt;
	}
	
	@Column(name = "status")
	public int getStatus(){
		return status;
	}
	
	/*-------------------------------------*/
	
	public void setId(int id) {
		this.id = id;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
