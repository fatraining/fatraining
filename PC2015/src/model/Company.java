package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company implements Serializable{
	private static final long serialVersionUID=1L;
	
	//カラム名
	private int id;
	private String name;
	private String prefecture;
	private String phoneNumber;
	private String registeredPerson;
	private String registrationDate;
	private String updateBy;
	private String updateDate;
	
	private int e_flag;
	private int d_flag;

	/*-----------------getter------------------------*/
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	
	@Column(name="prefecture")
	public String getPrefecture() {
		return prefecture;
	}
	
	@Column(name="phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@Column(name="registeredPerson")
	public String getRegisteredPerson() {
		return registeredPerson;
	}
	
	@Column(name="registrationDate")
	public String getRegistrationDate() {
		return registrationDate;
	}
	
	@Column(name="updateBy")
	public String getUpdateBy() {
		return updateBy;
	}
	
	@Column(name="updateDate")
	public String getUpdateDate() {
		return updateDate;
	}
	
	@Column(name="e_flag")
	public int isE_flag() {
		return e_flag;
	}
	
	@Column(name="d_flag")
	public int isD_flag() {
		return d_flag;
	}
	
	/*-----------------setter------------------------*/
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setRegisteredPerson(String registeredPerson) {
		this.registeredPerson = registeredPerson;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public void setE_flag(int e_flag) {
		this.e_flag = e_flag;
	}
	public void setD_flag(int d_flag) {
		this.d_flag = d_flag;
	}
}
	