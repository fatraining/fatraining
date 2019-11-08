package jp.co.futureantiques.webapptraining.model.novelOkudaira;

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
 * NovelMainOkudairaテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class NovelMainOkudaira {

	/** 作品ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 作品名 */
	@Column(name = "novel_title")
	private String novelTitle;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 作者ID */
	@Column(name = "writer_id")
	private Integer writerId;

	/** 出版年 */
	@Column(name = "publication_year")
	private Integer publicationYear;

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
	@ManyToOne(targetEntity = GenreOkudaira.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreOkudaira genreOkudaira;

	/** 外部キー設定 : 作者 */
	@ManyToOne(targetEntity = WriterOkudaira.class)
	@JoinColumn(name = "writer_id", referencedColumnName = "id", insertable = false, updatable = false)
	private WriterOkudaira writerOkudaira;
}