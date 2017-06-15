package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity // entity 必須
@Proxy(lazy=false)  //おまじない程度で 書かんと動かん
@Table(name = "skylinedata") // テーブル名
public class SkyLineData implements Serializable {

	@Id // 主キー 必須
	@GeneratedValue // 主キーの値の生成戦略

	@Column(name = "id")
	private int id;
	@Column(name = "date")
	private int date;
	@Column(name = "model")
	private String model;
	@Column(name = "nickname")
	private String nickname;
	@Column(name = "ageid")
	private int ageId;

	// getter setter


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getAgeId() {
		return ageId;
	}

	public void setAgeId(int ageId) {
		this.ageId = ageId;
	}

}
