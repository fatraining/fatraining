package model;

import java.io.Serializable;

public class Result3Table implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String title ;
	private String genre ;
//	private String signup;
//	private String update;
//	private String signupUSERID;
//	private String updateUSERID;
//	private String exclusiveFLG ;
//	private String deleteFLG ;
	
	public Result3Table() { }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.title = genre;
	
	}
//	public String getSignup() {
//		return signup;
//	}
//	public void setSignup(String signup) {
//		this.signup = signup;
//	}
//	public String getUpdate() {
//		return update;
//	}
//	public void setUPdate(String update) {
//		this.update = update;
//	}
//	public String getSignupUSERID() {
//		return signupUSERID;
//	}
//	public void setSignupUSERID(String signupUSERID) {
//		this.signupUSERID = signupUSERID;
//	}
//	public String getUpdateUSERID() {
//		return updateUSERID;
//	}
//	public void setUpdateUSERID(String updateUSERID) {
//		this.updateUSERID = updateUSERID;
//	}
//	public String getExclusiveFLG() {
//		return exclusiveFLG;
//	}
//	public void setExclusiveFLG(String exclusiveFLG) {
//		this.exclusiveFLG = exclusiveFLG;
//	}
//	public String getDeleteFLG() {
//		return deleteFLG;
//	}
//	public void setDeleteFLG(String deleteFLG) {
//		this.deleteFLG = deleteFLG;
//	}
}
