package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sim")
public class Sim implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ID;
	private String simService;
	private String charge;
	private String GB;
	private String comment;
	private String simOpeID;
	private String simOpeName;

	/*------------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}
	@Column(name = "simService")
	public String getSimService() {
		return simService;
	}
	@Column(name = "charge")
	public String getCharge() {
		return charge;
	}
	@Column(name = "GB")
	public String getGB() {
		return GB;
	}
	@Column(name = "comment")
	public String getComment() {
		return comment;
	}
	@Column(name = "simOpeID")
	public String getsimOpeID() {
		return simOpeID;
	}
	@Column(name = "SimOpeName")
	public String getSimOpeName() {
		return simOpeName;
	}
	//		@Column(name = "Date")
	//		public String getDate() {
	//			return date;
	//		}
	//
	//		public String getOperatorName() {
	//			return this.operatorName;
	//		}

	/*------------------------------------------------------*/
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setSimService(String simService) {
		this.simService = simService;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public void setGB(String GB) {
		this.GB = GB;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setSimOpeID(String simOpeID) {
		this.simOpeID = simOpeID;
	}
	public void setSimOpeName(String simOpeName) {
		this.simOpeName = simOpeName;
	}
	//		public void setDate(String date2) {
	//			this.date = date2;
	//		}
	//		public void setOperatorName(String operatorName) {
	//			this.operatorName = operatorName;

}


/*------------------------------------------------------*/




