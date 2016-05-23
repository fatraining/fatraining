package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sakeInfo")
public class Sakeinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String areaId;
	private String area;
	private String shopName;
	private String hours;
	private String price;
	private String recommend;
	private String comment;

	/*------------------------------------------------------*/

	@Id
	@GeneratedValue
	@Column(name = "id")
	public String getId() {
		return id;
	}

	@Column(name = "areaId")
	public String getAreaId() {
		return areaId;
	}

	@Column(name = "area")
	public String getArea() {
		return area;
	}

	@Column(name = "shopName")
	public String getShopName() {
		return shopName;
	}

	@Column(name = "hours")
	public String getHours() {
		return hours;
	}

	@Column(name = "price")
	public String getPrice() {
		return price;
	}

	@Column(name = "recommend")
	public String getRecommend() {
		return recommend;
	}

	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	/*------------------------------------------------------*/

	public void setId(String id) {
		this.id = id;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

}
