package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Genre")
public class Genre implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String genreNm;
//	
	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name="id")
	public String getId() {
		return id;
	}
	@Column(name="genreNm")
	public String getGenreNm() {
		return genreNm;
	}
	
/*--------------------------------------------------*/
	public void setId(String id) {
		this.id = id;
	}
	public void setGenreNm(String genreNm) {
		this.genreNm = genreNm;
	}

}
