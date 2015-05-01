package model;

import java.io.Serializable;

public class ResultTableMovie implements Serializable{

	private static final long serialVersionUID = 1L;

	//検索結果を表示させるための変数とメソッド
	private String id;
	private String title ;
	private String genre ;
	private int exhibition_year ;

	public ResultTableMovie() { }

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getExhibition_year() {
		return exhibition_year;
	}
	public void setExhibition_year(int exhibition_year) {
		this.exhibition_year = exhibition_year;
	}
}
