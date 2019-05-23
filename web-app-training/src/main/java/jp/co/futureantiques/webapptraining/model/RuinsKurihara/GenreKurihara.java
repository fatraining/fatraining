package jp.co.futureantiques.webapptraining.model.RuinsKurihara;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Genreテーブルと対応するEntityクラス
 *
 * @author M.Kurihara
 */
@Data
@Entity
public class GenreKurihara {

	/** 種別ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 種別 */
	@Column(name = "genre")
	@Size(max = 255)
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

	/** 外部キー設定：種別ID */
	@Transient
	@OneToMany(targetEntity = RuinsMainKurihara.class, mappedBy = "genre")
	@JoinColumn(name = "id", referencedColumnName = "genre_id")
	private List<RuinsMainKurihara> RuinsMainKuriharaList;
}