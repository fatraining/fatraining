package jp.co.futureantiques.webapptraining.model.heritagekataoka;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/**
 * Genreテーブルと対応するエンティティ
 * @author MIKI KATAOKA
 *
 */

@Data
@Entity
public class GenreKataoka {

	/** ジャンルID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** ジャンル */
	@Column(name = "genre")
	private String genre;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：ジャンルID */
	@Transient
	@OneToMany(targetEntity = HeritageMainKataoka.class,mappedBy = "genre")
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<HeritageMainKataoka> HeritageMainList;


}
