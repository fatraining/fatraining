package jp.co.futureantiques.webapptraining.model.comicYanai;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/** ComicMainYanaiテーブルに対応するエンティティクラス
 *
 * @author yanai
 *
 */
@Data
@Entity
public class ComicMainYanai {
	/**漫画ID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	/** 漫画名*/
	@Column(name = "comic_title")
	private String comicTitle;
	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;
	/** 出版社ID */
	@Column(name = "pubco_id")
	private Integer pubcoId;
	/** 巻数 */
	@Column(name = "volume")
	private Integer volume;
	/**コメント*/
	@Column(name = "comment")
	private String comment;
	/** 削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;
	/**登録日時*/
	@Column(name = "create_date")
	private Timestamp createDate;
	/** 更新日時*/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部キー設定：ジャンル*/
	@ManyToOne(targetEntity = GenreYanai.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)

	/**外部キー設定：出版社*/
	private GenreYanai genre;
	@ManyToOne(targetEntity = PubcoYanai.class)
	@JoinColumn(name = "pubco_id", referencedColumnName = "id", insertable = false, updatable = false)
	private PubcoYanai pubco;

}
