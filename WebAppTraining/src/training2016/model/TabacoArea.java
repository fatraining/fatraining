package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TabacoAreaテーブルと対応する場所
 * @author otawaratomoki
 *
 */
@Entity
@Table(name = "tabacoarea")
public class TabacoArea implements Serializable{
	private static final long serialVerionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;
	
	@Column(name = "area")
	private String area;
	
	/**
	 * idを返してセット以下
	 */
	
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
	/**
	 * areaを返してセット
	 * @return
	 */
	public String getArea(){
		return this.area;
	}
	public void setArea(String area){
		this.area = area;
	}
}
