package model;

import java.io.Serializable;

public class BandResultTable implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;//カラム名IDの変数、データ型int。(String型からint型に変更)→String型に戻す
	private String name;
	private String sex;
	private String age;
	private String school;
	private String favorite_song;
	private String part;
	private int band_id;//カラム名BAND_IDの変数、データ型int(String型からint型に変更)
	private String entry_date;
	private String renewal_date;
	private String entry_userid;
	private String renewal_userid;
	private int exclusion_flg; //カラム名EXCLUSION_FLGの変数、データ型int(String型からint型に修正)
	private int delete_flg; //カラム名DELETE_FLGの変数、データ型int(String型からint型に修正)
	private String band_name;
	
	public BandResultTable(){}
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getAge(){
		return age;
	}
	public void setAge(String age){
		this.age = age;
	}
	public String getSchool(){
		return school;
	}
	public void setSchool(String school){
		this.school = school;
	}
	public String getFavorite_song(){
		return favorite_song;
	}
	public void setFavorite_song(String favorite_song){
		this.favorite_song = favorite_song;
	}
	public String getPart(){
		return part;
	}
	public void setPart(String part){
		this.part = part;
	}
	public int getBand_id(){
		return band_id;
	}
	public void setBand_id(int band_id){
		this.band_id = band_id;
	}
	public String getEntry_date(){
		return entry_date;
	}
	public void setEntry_date(String entry_date){
		this.entry_date = entry_date;
	}
	public String getRenewal_date(){
		return renewal_date;
	}
	public void setRenewal_date(String renewal_date){
		this.renewal_date = renewal_date;
	}
	public String getEntry_userid(){
		return entry_userid;
	}
	public void setEntry_userid(String entry_userid){
		this.entry_userid = entry_userid;
	}
	public String getRenewal_userid(){
		return renewal_userid;
	}
	public void setRenewal_userid(String renewal_userid){
		this.renewal_userid = renewal_userid;
	}
	public int getExclusion_flg(){
		return exclusion_flg;
	}
	public void setExclusion_flg(int exclusion_flg){
		this.exclusion_flg = exclusion_flg;
	}
	public int getDelete_flg(){
		return delete_flg;
	}
	public void setDelete_flg(int delete_flg){
		this.delete_flg = delete_flg;
	}
	public String getBand_name(){
		return band_name;
	}
	public void setBand_name(String band_name){
		this.band_name = band_name;
	}
	
	
}
