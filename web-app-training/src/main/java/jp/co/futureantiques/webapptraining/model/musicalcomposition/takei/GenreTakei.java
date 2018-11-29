package jp.co.futureantiques.webapptraining.model.musicalcomposition.takei;

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
 * GenreTakeiテーブルと対応するEntityクラス
 *
 * @author takei
**/
@Data
@Entity
public class GenreTakei {

	/** ジャンルID */
	@Id
	@GeneratedValue
	@Column(name = "genre_id")
	private int genreId;

	/** ジャンル */
	@Column(name = "genre")
	@Size(max = 256)
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
	@OneToMany(targetEntity = MusicalCompositionMainTakei.class, mappedBy = "genreTakei")
	@JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
	private List<MusicalCompositionMainTakei> MusicalCompositionMainTakeiList;
}
