package model;

import java.io.Serializable;

public class Result11Table implements Serializable {
	private static final long serialVersionUID = 1L;
	// 画面に表示させたいカラム名
	public int id;
	public String sName;
	public String sPrefecture;
	public String sPhonenumber;
	public int companyID;
	public String cName;
	public String cPrefecture;
	public String cPhonenumber;
	
	/*-----------------getter------------------------*/
	public int getId() {
		return id;
	}
	public String getSName() {
		return sName;
	}
	public String getSPrefecture() {
		return sPrefecture;
	}
	public String getSPhonenumber() {
		return sPhonenumber;
	}
	public int getCompanyID() {
		return companyID;
	}
	public String getCName() {
		return cName;
	}
	public String getCPrefecture() {
		return cPrefecture;
	}
	public String getCPhonenumber() {
		return cPhonenumber;
	}
	
	
	/*-----------------setter------------------------*/
	public void setId(int id) {
		this.id = id;
	}
	
	public void setSName(String sName) {
		this.sName = sName;
	}
	public void setSPrefecture(String sPrefecture) {
		this.sPrefecture = sPrefecture;
	}
	public void setSPhonenumber(String sPhonenumber) {
		this.sPhonenumber = sPhonenumber;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public void setCName(String cName) {
		this.cName = cName;
	}
	public void setCPrefecture(String cPrefecture) {
		this.cPrefecture = cPrefecture;
	}
	public void setCPhonenumber(String cPhonenumber) {
		this.cPhonenumber = cPhonenumber;
	}

}
