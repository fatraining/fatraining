package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="like_game")
public class LikeGame implements Serializable{

	private static final long serialVersionUID = 1L;

	//カラム
	private String id;
	private String title ;
	private String series ;
	private String user;
	private String upDay;
	private String userId;
	private String upUser;
	private String nonStyle ;
	private String del ;
	
	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name="id")
	public String getId() {
		return id;
	}
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	@Column(name="series")
	public String getSeries() {
		return series;
	}
	@Column(name="user")
	public String getUser() {
		return user;
	}
	@Column(name="upDay")
	public String getUpDay() {
		return upDay;
	}
	@Column(name="userId")
	public String getUserId() {
		return userId;
	}
	@Column(name="upUser")
	public String getUpUser() {
		return upUser;
	}
	@Column(name="nonStyle")
	public String getNonStyle() {
		return nonStyle;
	}	
	@Column(name="del")
	public String getDel() {
		return del;
	}
/*--------------------------------------------------*/

	public void setId(String id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setUpDay(String upDay) {
		this.upDay = upDay;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUpUser(String upUser) {
		this.upUser = upUser;
	}
	public void setNonStyle(String nonStyle) {
		this.nonStyle = nonStyle;
	}
	public void setDel(String del) {
		this.del = del;
	}
}
