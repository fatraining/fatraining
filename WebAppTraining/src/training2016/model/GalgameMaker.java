package training2016.model;
//galgamemakerテーブルに対応するモデル
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
@Entity
@Proxy(lazy=false)  //おまじない程度で
@Table(name = "galgamemaker")
public class GalgameMaker implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "makerName")
	private String makerName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}



}
