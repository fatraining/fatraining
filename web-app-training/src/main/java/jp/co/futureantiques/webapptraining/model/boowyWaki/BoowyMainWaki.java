package jp.co.futureantiques.webapptraining.model.boowyWaki;

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
 * BoowyMainWakiテーブルと対応するEntity
 *
 * @author WAKI
 *
 */
@Data
@Entity
public class BoowyMainWaki {

	/** 曲名ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 曲名*/
	@Column(name = "name")
	private String name;

	/** リリース日*/
	@Column(name = "release_date")
	private String releaseDate;

	/** ジャンルID*/
	@Column(name = "genre_id")
	private Integer genreId;

	/** 曲の長さ*/
	@Column(name = "length")
	private String length;

	/** 作詞者ID*/
	@Column(name = "songwriter_id")
	private Integer songwriterId;

	/**コメント*/
	@Column(name = "comment")
	@Size(max = 200)
	private String comment;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時*/
	@Column(name = "create_date")
	private Timestamp createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部キー設定：ジャンル*/
	@ManyToOne(targetEntity = GenreWaki.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreWaki genreWaki;

	/**外部キー設定：作詞者*/
	@ManyToOne(targetEntity = SongwriterWaki.class)
	@JoinColumn(name = "songwriter_id", referencedColumnName = "id", insertable = false, updatable = false)
	private  SongwriterWaki songwriterWaki;
}