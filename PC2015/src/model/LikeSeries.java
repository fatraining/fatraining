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
	private String up_id;
	private String se ;
	private String us;
	private String upD;
	private String userI;
	private String upU;
	private String nonS ;
	private String de ;
	private int an_flg;
	private int del_flg;

	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name="up_id")
	public String getUp_id() {
		return up_id;
	}
	@Column(name="se")
	public String getSe() {
		return se;
	}
	@Column(name="us")
	public String getUs() {
		return us;
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
	@Column(name="de")
	public String getDe() {
		return de;
	}
	@Column(name="an_flg")
	public int getAn_flg() {
		return an_flg;
	}
	@Column(name="del_flg")
	public int getDel_flg() {
		return del_flg;
	}
/*--------------------------------------------------*/
	public void setUp_id(String up_id) {
		this.up_id = up_id;
	}
	public void setSe(String se) {
		this.se= se;
	}
	public void setUs(String us) {
		this.us = us;
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
	public void setDe(String de) {
		this.de = de;
	}
	public void setAn_flg(int an_flg) {
		this.an_flg = an_flg;
	}
	public void setDel_flg(int del_flg) {
		this.del_flg = del_flg;
	}
}
