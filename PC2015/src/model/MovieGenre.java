package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie_genre")
public class MovieGenre implements Serializable{

	private static final long serialVersionUID = 1L;

	//検索結果を表示させるためにデータを取り出すための変数とメソッド
	private int id; // ID
	private String genre ; // ジャンル

	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	@Column(name="genre")
	public String getGenre() {
		return genre;
	}

/*--------------------------------------------------*/
	public void setId(int id) {
		this.id = id;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	}
