package jp.co.futureantiques.webapptraining.model.doramasample;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * DoramaMainテーブルと対応するEntity
 *
 * @author hiraoka
 */
@Data
@Entity
public class DoramaMain {

	/** ドラマID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** ドラマタイトル */
	@Column(name = "dorama_title")
	private String doramaTitle;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 放送局ID */
	@Column(name = "tvstation_id")
	private Integer tvStationId;

	/** 公開年 */
	@Column(name = "release_year")
	private int releaseYear;


	/** 主演 */
	@Column(name = "star")
	@Size(max = 255)
	private String star;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：ドラマジャンル */
	@ManyToOne(targetEntity = DoramaGenre.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DoramaGenre doramaGenre;

	/** 外部キー設定：放送局 */
	@ManyToOne(targetEntity = TvStation.class)
	@JoinColumn(name = "tvstation_id", referencedColumnName = "id", insertable = false, updatable = false)
	private TvStation tvStation;
}