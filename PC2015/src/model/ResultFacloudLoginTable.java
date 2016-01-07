package model;

import java.io.Serializable;

import javax.persistence.Column;

public class ResultFacloudLoginTable implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getCreatedAt(){
		return createdAt;
	}
	
	public String getUpdatedAt(){
		return updatedAt;
	}
	
	public String getPasswordDigest(){
		return passwordDigest;
	}
	
	public String getRememberToken(){
		return rememberToken;
	}
	
	public int getAdmin(){
		return admin;
	}
	
	public int getSectionId(){
		return sectionId;
	}
	
	public int getCompanyId(){
		return companyId;
	}
	
	public int getRetirementFlg(){
		return retirementFlg;
	}
	
	public String getImageFileName(){
		return imageFileName;
	}
	
	public String getImageContentType(){
		return imageContentType;
	}
	
	public int getImageFileSize(){
		return imageFileSize;
	}
	
	public String getImageUpdatedAt(){
		return imageUpdatedAt;
	}
}
