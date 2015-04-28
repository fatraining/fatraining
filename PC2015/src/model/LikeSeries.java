package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="like_series")
public class LikeSeries implements Serializable{

	private static final long serialVersionUID = 1L;

	//カラム
	private String i;
	private String se ;
	private String u;
	private String upD;
	private String userI;
	private String upU;
	private String nonS ;
	private String d ;

	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name="i")
	public String getI() {
		return i;
	}
	@Column(name="se")
	public String getSe() {
		return se;
	}
	@Column(name="u")
	public String getU() {
		return u;
	}
	@Column(name="upD")
	public String getUpD() {
		return upD;
	}
	@Column(name="userI")
	public String getUserI() {
		return userI;
	}
	@Column(name="upU")
	public String getUpU() {
		return upU;
	}
	@Column(name="nonS")
	public String getNonS() {
		return nonS;
	}	
	@Column(name="d")
	public String getD() {
		return d;
	}
/*--------------------------------------------------*/
	public void setI(String i) {
		this.i = i;
	}
	public void setSe(String se) {
		this.se= se;
	}
	public void setU(String u) {
		this.u = u;
	}
	public void setUpD(String upD) {
		this.upD = upD;
	}
	public void setUserI(String userI) {
		this.userI = userI;
	}
	public void setUpU(String upU) {
		this.upU = upU;
	}
	public void setNonS(String nonS) {
		this.nonS = nonS;
	}
	public void setD(String d) {
		this.d = d;
	}
}
