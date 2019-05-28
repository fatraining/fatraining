package jp.co.futureantiques.webapptraining.model.bandTaneichi;

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
 * bandMainテーブルと対応するEntity
 *
 *
 * @author future
 *
 */
@Data
@Entity
public class BandMainTaneichi {

	/** バンドID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** バンド名*/
	@Column(name = "band_name")
	private String bandName;

	/** メンバー数*/
	@Column(name = "member")
	private Integer member;

	/** 結成年*/
	@Column(name = "band_year")
	private Integer bandYear;

	/** ボーカル性別*/
	@Column(name = "band_sex")
	private Integer bandSex;

	/**ジャンル*/
	@Column(name = "genre_id")
	private Integer genreId;

	/**コメント*/
	@Column(name = "comment")
	@Size(max = 300)
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

	/**外部キー設定：ボーカル性別*/
	@ManyToOne(targetEntity = BandSexTaneichi.class)
	@JoinColumn(name = "band_sex", referencedColumnName = "id", insertable = false, updatable = false)
	private BandSexTaneichi bandSexTaneichi;

	/**外部キー設定：ジャンル*/
	@ManyToOne(targetEntity = GenreTaneichi.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreTaneichi genreTaneichi;

}
