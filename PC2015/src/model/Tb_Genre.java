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
		private String signup;
		private String updateDate;
		private String signupUSERID;
		private String updateUSERID;
		private int exclusiveFLG ;
		private int deleteFLG ;
		
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
		@Column(name="signup")
		public String getSignup() {
			return signup;
		}
		@Column(name="updateDate")
		public String getUpdateDate() {
			return updateDate;
		}
		@Column(name="signupUSERID")
		public String getSignupUSERID() {
			return signupUSERID;
		}
		@Column(name="updateUSERID")
		public String getUpdateUSERID() {
			return updateUSERID;
		}
		@Column(name="exclusiveFLG")
		public int getExclusiveFLG() {
			return exclusiveFLG;
		}	
		@Column(name="deleteFLG")
		public int getDeleteFLG() {
			return deleteFLG;
		}
		
	/*--------------------------------------------------*/

		public void setId(int id) {
			this.id = id;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public void setSignup(String signup) {
			this.signup = signup;
		}
		public void setUpdateDate(String updateDate) {
			this.updateDate = updateDate;
		}
		public void setSignupUSERID(String signupUSERID) {
			this.signupUSERID = signupUSERID;
		}
		public void setUpdateUSERID(String updateUSERID) {
			this.updateUSERID = updateUSERID;
		}
		public void setExclusiveFLG(int exclusiveFLG) {
			this.exclusiveFLG = exclusiveFLG;
		}
		public void setdeleteFLG(int deleteFLG) {
			this.deleteFLG = deleteFLG;
		}
		
	}



