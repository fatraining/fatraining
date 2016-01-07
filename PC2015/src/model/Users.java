package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import model.Section;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	// テーブルのカラムに対応したプロパティ
	private int id;
	private String name;
	private String email;
	private String createdAt;
	private String updatedAt;
	private String passwordDigest;
	private String rememberToken;
	private int admin;
	private int sectionId;
	private int companyId;
	private int retirementFlg;
	private String imageFileName;
	private String imageContentType;
	private int imageFileSize;
	private String imageUpdatedAt;
	// テーブル間の結合を定義
	private Section section; //<--結合先のエンティティを追加
	
	/*-------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	@Column(name = "email")
	public String getEmail(){
		return email;
	}
	
	@Column(name = "created_at")
	public String getCreatedAt(){
		return createdAt;
	}
	
	@Column(name = "updated_at")
	public String getUpdatedAt(){
		return updatedAt;
	}
	
	@Column(name = "password_digest")
	public String getPasswordDigest(){
		return passwordDigest;
	}
	
	@Column(name = "remember_token")
	public String getRememberToken(){
		return rememberToken;
	}
	
	@Column(name = "admin")
	public int getAdmin(){
		return admin;
	}
	
	@Column(name = "section_id")
	public int getSectionId(){
		return sectionId;
	}
	
	@Column(name = "company_id")
	public int getCompanyId(){
		return companyId;
	}
	
	@Column(name = "retirement_flg")
	public int getRetirementFlg(){
		return retirementFlg;
	}
	
	@Column(name = "image_file_name")
	public String getImageFileName(){
		return imageFileName;
	}
	
	@Column(name = "image_content_type")
	public String getImageContentType(){
		return imageContentType;
	}
	
	@Column(name = "image_file_size")
	public int getImageFileSize(){
		return imageFileSize;
	}
	
	@Column(name = "image_updated_at")
	public String getImageUpdatedAt(){
		return imageUpdatedAt;
	}
	
	@ManyToOne( cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="section_id", insertable = false, updatable = false) //<--結合カラムを指定
	public Section getSection(){
		return section;
	}
	
	
	/*-------------------------------------*/
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}
	
	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}
	
	public void setPasswordDigest(String passwordDigest){
		this.passwordDigest = passwordDigest;
	}
	
	public void setRememberToken(String rememberToken){
		this.rememberToken = rememberToken;
	}
	
	public void setAdmin(int admin){
		this.admin = admin;
	}
	
	public void setSectionId(int sectionId){
		this.sectionId = sectionId;
	}
	
	public void setCompanyId(int companyId){
		this.companyId = companyId;
	}
	
	public void setRetirementFlg(int retirementFlg){
		this.retirementFlg = retirementFlg;
	}
	
	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}
	
	public void setImageContentType(String imageContentType){
		this.imageContentType = imageContentType;
	}
	
	public void setImageFileSize(int imageFileSize){
		this.imageFileSize = imageFileSize;
	}
	
	public void setImageUpdatedAt(String imageUpdatedAt){
		this.imageUpdatedAt = imageUpdatedAt;
	}
	
	public void setSection(Section section){
		this.section = section;
	}

}
