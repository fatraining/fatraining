package model;

	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="tb_genre")
	public class Tb_Genre implements Serializable{

		private static final long serialVersionUID = 1L;

		private int id;
		private String genre ;
//		private String signup;
//		private String update;
//		private String signupUSERID;
//		private String updateUSERID;
//		private String exclusiveFLG ;
//		private String deleteFLG ;
		
		/*--------------------------------------------------*/
		@Id
		@GeneratedValue
		@Column(name="id")
		public int getId() {
			return id;
		}
		
		@Column(name="genre")
		public String getGenre() {
			return genre;
		}
//		@Column(name="signup")
//		public String getSignup() {
//			return signup;
//		}
//		@Column(name="update")
//		public String getUpdate() {
//			return update;
//		}
//		@Column(name="signupUSERID")
//		public String getSignupUSERID() {
//			return signupUSERID;
//		}
//		@Column(name="updateUSERID")
//		public String getUpdateUSERID() {
//			return updateUSERID;
//		}
//		@Column(name="exclusiveFLG")
//		public String getExclusiveFLG() {
//			return exclusiveFLG;
//		}	@Column(name="deleteFLG")
//		public String getDeleteFLG() {
//			return deleteFLG;
//		}
		
	/*--------------------------------------------------*/

		public void setId(int id) {
			this.id = id;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
//		public void setSignup(String signup) {
//			this.signup = signup;
//		}
//		public void setUpdate(String update) {
//			this.update = update;
//		}
//		public void setSignupUSERID(String signupUSERID) {
//			this.signupUSERID = signupUSERID;
//		}
//		public void setUpdateUSERID(String updateUSERID) {
//			this.updateUSERID = updateUSERID;
//		}
//		public void setExclusiveFLG(String exclusiveFLG) {
//			this.exclusiveFLG = exclusiveFLG;
//		}
//		public void setdeleteFLG(String deleteFLG) {
//			this.deleteFLG = deleteFLG;
//		}
		
	}



