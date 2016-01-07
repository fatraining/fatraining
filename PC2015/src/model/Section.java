package model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "section")
public class Section implements Serializable {

	private static final long serialVersionUID = 1L;
	// テーブルのカラムに対応したプロパティ
	private int id;
	private String name;
	// テーブル間の結合を定義
	private Collection<Users> users; //<--結合先のエンティティを追加
	
	/*-------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER ,mappedBy="section")
	@Fetch(FetchMode.JOIN)
    @JoinColumn(name = "section_id")
    public Collection<Users> getUsers() {
		return this.users;
	}
	
	/*-------------------------------------*/
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setUsers(Collection<Users> users ) {
		this.users = users;
	}

}
