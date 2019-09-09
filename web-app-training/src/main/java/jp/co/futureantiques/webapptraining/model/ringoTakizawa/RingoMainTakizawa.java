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
	//@Size(max = 4)（nullがOKの時、sizeは使えない）（入力制限の定義をmodel.formのInputFormで行っている）
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
	// （メインのレコードはCD名 の複数のレコードと関連する可能性があるが、CD名のレコードは メインのレコードと最大一件のみ関連する）
	@ManyToOne(targetEntity = RingoCdTitleTakizawa.class)
	//結合に用いるカラムを指定
	//詳細　http://itdoc.hitachi.co.jp/manuals/link/cosmi_v0870/APR4/EU260076.HTM
	@JoinColumn(name = "cd_title_id", referencedColumnName = "id", insertable = false, updatable = false)
	private RingoCdTitleTakizawa ringoCdTitleTakizawa;


	/** 外部キー設定：聞きたい気分 */
	//多対一関連定義　（どちらが多？どちらが一？）
	//→例）聞きたい気分「ふわふわ」の場合、メインにはふわふわが複数ある（幸福論、シドと白昼夢とか）ふわふわの項目が含まれているレコードを消しても問題ない→多
	//聞きたい気分テーブルの「ふわふわ」は一つしかない（レコード消せない）→一
	@ManyToOne(targetEntity = RingoSongImageTakizawa.class)
	@JoinColumn(name = "song_image_id", referencedColumnName = "id", insertable = false, updatable = false)
	private  RingoSongImageTakizawa ringoSongImageTakizawa;


}

