package jp.co.futureantiques.webapptraining.model.ringoTakizawa;

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
 * RingoSongImageテーブルと対応するEntityクラス
 *
 * @author Mai Takizawa
 */
@Data
@Entity

public class RingoSongImageTakizawa {

	/** 聞きたい気分ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**　聞きたい気分  */
	@Column(name = "song_image")
	@Size(max = 256)
	private String songImage;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：聞きたい気分ID */
	@Transient
	///一対多関連定義
	@OneToMany(targetEntity = RingoMainTakizawa.class, mappedBy = "ringoSongImageTakizawa")
	@JoinColumn(name = "id", referencedColumnName = "song_image_id")
	private List<RingoMainTakizawa> ringoMainTakizawaList;

}
