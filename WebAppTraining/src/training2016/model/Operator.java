package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@SuppressWarnings("unused")
@Entity
@Table(name = "operator")
public class Operator implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private  String operatorID;
	private  String operatorName;
	private String userID;
	
	@Id
	@GeneratedValue
	@Column(name = "operatorID")
	public String getOperatorID() {
		return operatorID;
	}
	@Column(name = "operatorName")
	public  String getOperatorName() {
		this.operatorName = operatorName.trim();
		return operatorName;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
}
