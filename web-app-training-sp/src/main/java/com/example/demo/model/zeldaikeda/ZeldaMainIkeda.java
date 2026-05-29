package com.example.demo.model.zeldaikeda;

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

/**
 * ZeldaMainテーブルと対応するEntity
 */
@Data
@Entity
public class ZeldaMainIkeda {
	
	/** ゼルダID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "zelda_id")
	private long zeldaId;

	/** ゼルダタイトル */
	@Column(name = "zelda_title")
	private String zeldaTitle;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 時系列ID */
	@Column(name = "time_series_id")
	private Integer timeSeriesId;

	/** 対応機種ID */
	@Column(name = "compatible_model_id")
	private Integer compatibleModelId;

	/** 発売年 */
	@Column(name = "release_year")
	private Integer releaseYear;
	
	/** コメント */
	@Column(name = "comment")
	@Size(max = 255)
	private String comment;

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
	@ManyToOne(targetEntity = GenreIkeda.class)
	@JoinColumn(name = "genre_id", insertable = false, updatable = false)
	private GenreIkeda genre;

	/** 外部キー設定：時系列 */
	@ManyToOne(targetEntity = TimeSeriesIkeda.class)
	@JoinColumn(name = "time_series_id", insertable = false, updatable = false)
	private TimeSeriesIkeda timeSeries;

	/** 外部キー設定：対応機種 */
	@ManyToOne(targetEntity = CompatibleModelIkeda.class)
	@JoinColumn(name = "compatible_model_id", insertable = false, updatable = false)
	private CompatibleModelIkeda compatibleModel;
}
