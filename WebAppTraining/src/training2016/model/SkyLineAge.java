package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skylineage")
public class SkyLineAge implements Serializable {

	@Id // 主キー 必須
	@GeneratedValue // 主キーの値の生成戦略

	@Column(name = "id")
	private int id;
	@Column(name = "age")
	private int age;

	//getter
	public int getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	// setter
	public void setId(int id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
