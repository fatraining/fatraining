package jp.co.futureantiques.webapptraining.model.comicMiyoshi;

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
 * ComicMainMiyoshiテーブルと対応するEntity
 * @author Miyoshi
 */
@Data
@Entity
public class ComicMainMiyoshi {

	/** 漫画ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 漫画タイトル */
	@Column(name = "comic_title")
	private String comicTitle;

	/** 連載雑誌ID */
	@Column(name = "magazine_id")
	private Integer magazineId;

	/** 原作者名 */
	@Column(name = "author")
	private String author;

	/** 巻数 */
	@Column(name = "volume")
	private Integer volume;

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

	/** 外部キー設定：連載雑誌名*/
	@ManyToOne(targetEntity = MagazineMiyoshi.class)
	@JoinColumn(name = "magazine_id", referencedColumnName = "id", insertable = false, updatable = false)
	private MagazineMiyoshi magazineMiyoshi;
}
