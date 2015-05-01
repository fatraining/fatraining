package model;

import java.io.Serializable;

public class Result3Table implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String genre;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

}
