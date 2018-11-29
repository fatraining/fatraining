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
 * AlbumTakeiテーブルと対応するEntity
 *
 * @author takei
 */
@Data
@Entity
public class AlbumTakei {

	/** 収録アルバムID */
	@Id
	@GeneratedValue
	@Column(name = "album_id")
	private int albumId;

	/** 収録アルバム */
	@Column(name = "album")
	@Size(max = 255)
	private String album;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：俳優ID */
	@Transient
	@OneToMany(targetEntity =  MusicalCompositionMainTakei.class, mappedBy = "albumTakei")
	@JoinColumn(name = "album_id", referencedColumnName = "album_id")
	private List<MusicalCompositionMainTakei> MusicalCompositionMainTakeiList;
}

