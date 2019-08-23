package jp.co.futureantiques.webapptraining.model.ringoTakizawa;

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
 * RingoMaintakizawaテーブルと対応するEntity
 *
 * @author Mai Takizawa
 */
@Data
@Entity

public class RingoMainTakizawa {

	/**曲名ID */
	//主キーの指定
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	//自動採番
	@GeneratedValue(generator = "gen")
	private long id;

	/** 曲名 */
	//カラム名
	@Column(name = "song_title")
	@Size(max = 256)
	private String songTitle;

	/** CD名ID */
	@Column(name = "cd_title_id")
	private Integer cdTitleId;

	/** リリース年 */
	@Column(name = "release_year")
	//@Size(max = 4)
	private Integer releaseYear;

	/** 聞きたい気分ID */
	@Column(name = "song_image_id")
	private Integer songImageId;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：CD名 */
	//多対一関連定義
	@ManyToOne(targetEntity = RingoCdTitleTakizawa.class)
	//結合に用いるカラムを指定
	@JoinColumn(name = "cd_title_id", referencedColumnName = "id", insertable = false, updatable = false)
	private RingoCdTitleTakizawa ringoCdTitleTakizawa;

	/** 外部キー設定：聞きたい気分 */
	@ManyToOne(targetEntity = RingoSongImageTakizawa.class)
	@JoinColumn(name = "song_image_id", referencedColumnName = "id", insertable = false, updatable = false)
	private  RingoSongImageTakizawa ringoSongImageTakizawa;


}

