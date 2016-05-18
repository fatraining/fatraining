package training2016.model;

import java.io.Serializable ;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity⇒データのまとまりを表す。データの実体
@Entity
//@Tableでテーブルとマッピングする
@Table(name = "rider")

//MVCモデルのM(Model)の部分
//データベースのデータを読み込む動作を行う⇒Serializable(直列化)
//(BikeTeam.javaも同じモデルクラス)
public class Rider implements Serializable {

	private static final long serialVersionUID = 1L ;

	private String ID ;
	private String number ;
	private String riderName ;
	private String teamID ;
	private String country ;
	private String age ;
	private String birthDay ;
	private String comment ;
	private String teamName;

	//アノテーションIdでSQLのテーブルの主キーを表す
	@Id
	//@Idを生成する方法をかくことができる
	@GeneratedValue
	//SQLのカラム
	@Column(name = "ID")
	public String getID(){
		return ID ;
	}
	@Column(name = "number")
	public String getNumber(){
		return number ;
	}
	@Column(name = "riderName")
	public String getRiderName(){
		return riderName ;
	}
	@Column(name = "teamID")
	public String getTeamID(){
		return teamID ;
	}
	@Column(name = "country")
	public String getCountry(){
		return country ;
	}
	@Column(name = "age")
	public String getAge(){
		return age ;
	}
	@Column(name = "birthDay")
	public String getBirthDay(){
		return birthDay ;
	}
	@Column(name = "comment")
	public String getComment(){
		return comment ;
	}
	public String getTeamName(){
		return teamName;
	}

	/*------------------------------------------------------*/
	public void setID(String ID ){
		this.ID = ID ;
	}
	public void setNumber(String number){
		this.number = number ;
	}
	public void setRiderName(String riderName){
		this.riderName = riderName ;
	}
	public void setTeamID(String teamID){
		this.teamID = teamID ;
	}
	public void setCountry(String country){
		this.country = country ;
	}
	public void setAge(String age){
		this.age = age ;
	}
	public void setBirthDay(String birthDay){
		this.birthDay = birthDay ;
	}
	public void setComment (String comment){
		this.comment = comment ;
	}
	public void setTeamName (String teamName){
		this.teamName = teamName ;
	}

}
