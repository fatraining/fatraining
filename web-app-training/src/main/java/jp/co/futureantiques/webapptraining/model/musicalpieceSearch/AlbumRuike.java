package jp.co.futureantiques.webapptraining.model.musicalpieceSearch;

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
 * AlbumRuikeに対応するエンティティ
 *
 * @author future
 */
@Data
@Entity
public class AlbumRuike {


	/** アルバムID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int albumId;

	/** アルバム名 */
	@Column(name = "album_name")
	@Size(max = 256)
	private String albumName;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：  コラボアーティストID */
	@Transient
	@OneToMany(targetEntity = ArianaMainRuike.class, mappedBy = "albumRuike")
	@JoinColumn(name = "id", referencedColumnName = "album_id")
	private List<ArianaMainRuike> arianaMainRuikeList;

}
