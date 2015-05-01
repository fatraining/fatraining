package model;

import java.io.Serializable;

public class Result2Table implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String name ;
	private String genreNm;


	public Result2Table() { }

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenreNm() {
		return genreNm;
	}
	public void setGenreNm(String genreNm) {
		this.genreNm = genreNm;
	}

}
