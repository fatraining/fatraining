package training2016.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class Phones implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String ID;
	private String phonesName;
	private String operatorID;
	private int price;
	private double size;
	private String comment;
	private String date;
	private String operatorName;

	
	/*------------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "ID")
	public String getID() {
		return ID;
	}
	@Column(name = "PhonesName")
	public String getPhoneName() {
		return phonesName;
	}
	@Column(name = "OperatorID")
	public String getOperatorID() {
		return operatorID;
	}
	@Column(name = "Price")
	public int getPrice() {
		return price;
	}
	@Column(name = "Size")
	public double getSize() {
		return size;
	}
	@Column(name = "Comment")
	public String getComment() {
		return comment;
	}
	@Column(name = "Date")
	public String getDate() {
		return date;
	}

	public String getOperatorName() {
		return this.operatorName;
	}
	
	/*------------------------------------------------------*/
	public void setID(String iD) {
		this.ID = iD;
	}
	public void setPhoneName(String PhoneName) {
		this.phonesName = PhoneName;
	}
	public void setOperatorID(String OperatorID) {
		this.operatorID = OperatorID;
	}
	public void setPrice(int price2) {
		this.price = price2;
	}
	public void setSize(double Size) {
		this.size = Size;
	}
	public void setComment(String Comment) {
		this.comment = Comment;
	}
	public void setDate(String date2) {
		this.date = date2;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
		
	}

	/*------------------------------------------------------*/

}
