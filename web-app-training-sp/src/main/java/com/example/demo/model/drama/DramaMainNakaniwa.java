package com.example.demo.model.drama;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

/*
 * DramaMainテーブルと対応するEntity
 * 
 */
//lombok settergetterを自動生成
@Data
@Entity
public class DramaMainNakaniwa {
	/** ドラマID*/
	@Id
	//主キー値を生成
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/** ドラマ名*/
	@Column(name = "drama_title")
	private String dramaTitle;

	/** ジャンルID*/
	@Column(name = "genre_id")
	private Integer genreId;

	/** 製作国ID*/
	@Column(name = "country_id")
	private Integer countryId;

	/** 公開年*/
	@Column(name = "release_year")
	private Integer releaseYear;

	/** シーズン*/
	@Column(name = "season")
	private Integer season;

	/** あらすじ*/
	@Column(name = "summary")
	@Size(max = 255)
	private String summary;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：ジャンル */
	@ManyToOne(targetEntity = GenreNakaniwa.class)
	@JoinColumn(name = "genre_id", insertable = false, updatable = false)
	private GenreNakaniwa genreNakaniwa;

	/** 外部キー設定：製作国 */
	@ManyToOne(targetEntity = CountryNakaniwa.class)
	//@JoinColumn(name = "country_id", referencedColumnName = "id", insertable = false, updatable = false)
	@JoinColumn(name = "country_id", insertable = false, updatable = false)
	private CountryNakaniwa countryNakaniwa;

}
