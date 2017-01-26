package training2016.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/*
 * CRYINGMOVIEテーブルと対応するモデル
 */
@Entity
@Proxy(lazy=false)  // おまじない
@Table(name = "cryingMovie")
public class CryingMovie implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "movieID")
	private int movieId;

	@Column(name = "countryFlg")
	private int countryFlg;

	@Column(name = "genre")
	private int genre;

	@Column(name = "title")
	private String title;

	@Column(name = "mainCast")
	private String mainCast;

	@Column(name = "story")
	private String story;

	private String movie;

	/** 映画idを返す
	 *
	 */
	public int getMovieId() {
		return this.movieId;
	}

	/**
	 * 映画idをセットする
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * 国内外フラグジャンルを返す
	 */
	public int getCountryFlg(){
		return this.countryFlg;
	}

	/**
	 * 国内外フラグをセット
	 */
	public void setCountryFlg(int countryFlg){
		this.countryFlg = countryFlg;
	}

	/**
	 * ジャンルを返す
	 */
	public int getGenre(){
		return this.genre;
	}

	/**
	 * ジャンルをセット
	 */
	public void setGenre(int genre){
		this.genre = genre;
	}

	/**
	 * 作品名を返す
	 */
	public String getTitle(){
		return this.title;
	}

	/**
	 * 作品名情報をセット
	 */
	public void setTitle(String story){
		this.story = story;
	}

	/**
	 * 出演者情報を返す
	 */
	public String getMainCast(){
		return this.mainCast;
	}

	/**
	 * 出演者情報をセット
	 */
	public void setMainCast(String mainCast){
		this.mainCast = mainCast;
	}

	/**
	 * あらすじを返す
	 */
	public String getStory(){
		return this.story;
	}

	/**
	 * あらすじをセット
	 */
	public void setStory(String story){
		this.story = story;
	}

}
