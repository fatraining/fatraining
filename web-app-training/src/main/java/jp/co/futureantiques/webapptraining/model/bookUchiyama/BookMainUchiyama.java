package jp.co.futureantiques.webapptraining.model.bookUchiyama;

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
 * book_main_uchiyamaテーブルと対応するEntity
 *
 * @author FutureAntiques
 */
@Data
@Entity
public class BookMainUchiyama {

	/** 本ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 本タイトル */
	@Column(name = "book_title")
	private String bookTitle;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 作家ID */
	@Column(name = "writer_id")
	private Integer writerId;

	/** 刊行年 */
	@Column(name = "release_year")
	private Integer releaseYear;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 255)
	private String comment;

	/** 削除フラグ 0:有効,1:削除 */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：ジャンルID */
	@ManyToOne(targetEntity = GenreUchiyama.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreUchiyama genreUchiyama;

	/** 外部キー設定：作家ID */
	@ManyToOne(targetEntity = WriterUchiyama.class)
	@JoinColumn(name = "writer_id", referencedColumnName = "id", insertable = false, updatable = false)
	private WriterUchiyama writerUchiyama;

}
