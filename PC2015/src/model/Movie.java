package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie implements Serializable{

	private static final long serialVersionUID = 1L;

	//｛入力した値をテーブルに挿入するため、検索結果を表示させるためにデータを取り出すため｝の変数とメソッド
	private String id; // ID
	private String title ; // タイトル
	private int genreId ; // ジャンルID
	private int exhibition_year ; // 公開年
	private String comment ; // コメント
	private String registration_date; // 登録日時
	private String renewal_date; // 更新日時
	private String registration_userid; // 登録ユーザーID
	private String renewal_userid ; // 更新ユーザーID
	/*--------------------------------------------------*/
	@Id
	@GeneratedValue
	@Column(name="id")
	public String getId() {
		return id;
	}
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	@Column(name="genreId")
	public int getGenreId() {
		return genreId;
	}
	@Column(name="exhibition_year")
	public int getExhibition_year() {
		return exhibition_year;
	}
	@Column(name="comment")
	public String getComment() {
		return comment;
	}
	@Column(name="registration_date")
	public String getRegistration_date() {
		return registration_date;
	}
	@Column(name="renewal_date")
	public String getRenewal_date() {
		return renewal_date;
	}
	@Column(name="registration_userid")
	public String getRegistration_userid() {
		return registration_userid;
	}
	@Column(name="renewal_userid")
	public String getRenewal_userid() {
		return renewal_userid;
	}
/*--------------------------------------------------*/

	public void setId(String id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	public void setExhibition_year(int exhibition_year) {
		this.exhibition_year = exhibition_year;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	public void setRenewal_date(String renewal_date) {
		this.renewal_date = renewal_date;
	}
	public void setRegistration_userid(String registration_userid) {
		this.registration_userid = registration_userid;
	}
	public void setRenewal_userid(String renewal_userid) {
		this.renewal_userid = renewal_userid;
	}	
	}
