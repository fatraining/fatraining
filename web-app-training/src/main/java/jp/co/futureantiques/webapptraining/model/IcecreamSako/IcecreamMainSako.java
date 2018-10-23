package jp.co.futureantiques.webapptraining.model.IcecreamSako;

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
 * IcecreamSakoMainテーブルと対応するEntity
 *
 * @author MINAMI SAKO
 */
  @Data
@Entity
public class IcecreamMainSako {
	/** ID 主キーとなるので＠の表記が違う */
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 名前 */
	@Column(name = "name")
	@Size(max = 256)
	private String name;

	/**ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/**  写真 */
	@Column(name = "photo")
	@Size(max = 256)
	private String photo;

	/**  メーカーID */
	@Column(name = "maker_id")
	private Integer makerId;
//
//	/**  メーカー名 */
//	@Column(name = "maker")
//	private String maker;

	/**  コメント */
	@Column(name = "comment")
	@Size(max = 256)
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
	@ManyToOne(targetEntity = GenreSako.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "genre_id", insertable = false, updatable = false)
	private GenreSako genreSako;

	/** 外部キー設定：メーカー */
	@ManyToOne(targetEntity = MakerSako.class)
	@JoinColumn(name = "maker_id", referencedColumnName = "maker_id", insertable = false, updatable = false)
	private MakerSako makerSako;

}
