package training2016.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nail")
public class Nail {
	private int id;
	private String date;
	private String KisetuID;
	private String maincolor;
	private String handmodel;
//	private byte[] image;
	private String comment;
	private String imageFileName;

	@Id
	@GeneratedValue
	//IdとGeneratedValueはAutoIncrement(この場合ID)に紐づく
	@Column(name = "ID")
	public int getId() {
		return this.id;
	}

	@Column(name = "date")
	public String getDate(){
		return date;
	}
	@Column(name = "KisetuID")
	public String getKisetuID(){
		return KisetuID;
	}
	@Column(name = "maincolor")
	public String getMaincolor(){
		return maincolor;
	}
	@Column(name = "handmodel")
	public String getHandmodel(){
		return handmodel;
	}
//	@Column(name = "image")
//	public byte[] getImage(){
//		return image;
//	}
	@Column(name = "comment")
	public String getComment(){
		return comment;
	}
	@Column(name = "imageFileName")
	public String imageFileName(){
		return imageFileName;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setDate(String Date){
		this.date = Date;
	}
	public void setKisetuID(String kisetuID){
		this.KisetuID = kisetuID;
	}
	public void setMaincolor(String mainColor){
		this.maincolor = mainColor;
	}
	public void setHandmodel(String handmodel){
		this.handmodel = handmodel;
	}
//	public void setImage(byte[] Image){
//		this.image = Image;
//	}
	public void setComment(String Comment){
		this.comment = Comment;
	}

	/**
	 * @return imageFileName
	 */
	public String getImageFileName() {
		return this.imageFileName;
	}
	/**
	 * @param imageFileName セットする imageFileName
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}



}
