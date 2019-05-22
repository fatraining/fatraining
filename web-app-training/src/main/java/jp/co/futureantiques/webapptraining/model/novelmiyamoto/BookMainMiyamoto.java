package jp.co.futureantiques.webapptraining.model.novelmiyamoto;

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
 * NovelMainテーブルと対応するEntity
 */
@Data
@Entity
public class BookMainMiyamoto {
	/** 本ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;
	/** 本名 */
	@Column(name = "book_title")
	private String bookTitle;
	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;
	/** 作者ID */
	@Column(name = "author_id")
	private Integer authorId;
	/** 発行年 */
	@Column(name = "year")
	private int year;
	/** ページ数 */
	@Column(name = "page")
	private Integer page;
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
	@ManyToOne(targetEntity = GenreMiyamoto.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "genre_id", insertable = false, updatable = false)
	private GenreMiyamoto genreMiyamoto;
	/** 外部キー設定：作者 */
	@ManyToOne(targetEntity = AuthorMiyamoto.class)
	@JoinColumn(name = "author_id", referencedColumnName = "author_id", insertable = false, updatable = false)
	private AuthorMiyamoto authorMiyamoto;
}