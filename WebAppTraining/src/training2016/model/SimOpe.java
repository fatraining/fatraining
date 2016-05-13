package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@SuppressWarnings("unused")
@Entity
@Table(name = "SimOpe")
public class SimOpe implements Serializable {
	private static final long serialVersionUID = 1L;

//	private  String operatorID;
//	private  String operatorName;
//	private String userID;
	private  String simOpeName;
	private String ID;


	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}
	@Column(name = "simOpeName")
	public  String getSimOpeName() {
		this.simOpeName = simOpeName.trim();
		return simOpeName;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
	public void setSimOpeName(String simOpeName) {
		this.simOpeName = simOpeName;
	}
	public String ID() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
