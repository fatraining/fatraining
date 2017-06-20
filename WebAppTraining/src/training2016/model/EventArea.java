package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventarea")
public class EventArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "area")
	private String area;

//ID
	public String getId() {	return this.id;	}
	public void setId(String id) {		this.id = id;	}
//area
	public String getArea() {	return this.area;	}
	public void setArea(String area) {		this.area = area;	}
}
