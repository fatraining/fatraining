package com.example.demo.model.booknakano;

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
 * BookMainテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class BookMainNakano {

	/** 書籍ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/** 書籍名 */
	@Column(name = "book_title")
	private String bookTitle;

	/** 著者ID */
	@Column(name = "author_id")
	private Integer authorId;

	/** 分類ID */
	@Column(name = "classification_id")
	private Integer classificationId;

	/** 文字遣い種別ID */
	@Column(name = "character_orthography_id")
	private Integer characterOrthographyId;

	/** 初出 */
	@Column(name = "first_appearance")
	@Size(max = 255)
	private String firstAppearance;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：著者 */
	@ManyToOne(targetEntity = AuthorNakano.class)
	@JoinColumn(name = "author_id", insertable = false, updatable = false)
	private AuthorNakano author;

	/** 外部キー設定：分類 */
	@ManyToOne(targetEntity = ClassificationNakano.class)
	@JoinColumn(name = "classification_id", insertable = false, updatable = false)
	private ClassificationNakano classification;

	/** 外部キー設定：文字遣い種別 */
	@ManyToOne(targetEntity = CharacterOrthographyNakano.class)
	@JoinColumn(name = "character_orthography_id", insertable = false, updatable = false)
	private CharacterOrthographyNakano characterOrthography;
}
