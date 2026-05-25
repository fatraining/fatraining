package com.example.demo.model.analogNoguchi;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * AnalogMainNoguchiテーブルに対応するEntity
 * 
 * @author future
 */

@Data
@Entity
@Table(name = "analog_main_noguchi")
public class AnalogMainNoguchi {

	/**ゲームID	 */
	@Id
	//主キー値を生成
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	/**ゲーム名	 */
	@Column(name = "analog_title")
	@Size(max = 256)
	private String analogTitle;

	/**種類ID */
	@Column(name = "type_id")
	private Integer typeId;

	/**対象年齢	 */
	@Column(name = "target_years")
	private Integer targetYears;

	/**ジャンル1 ID	 */
	@Column(name = "genre1_id")
	private Integer genre1Id;

	/**ジャンル2 ID	 */
	@Column(name = "genre2_id")
	private Integer genre2Id;

	/**プレイ人数 */
	@Column(name = "play_person")
	@Size(max = 256)
	private String playPerson;

	/**プレイ時間 */
	@Column(name = "play_time")
	@Size(max = 256)
	private String playTime;

	/**内容	 */
	@Column(name = "content")
	private String content;

	/**削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時	 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/**更新日時  */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：種類 */
	@ManyToOne(targetEntity = TypeNoguchi.class)
	//@JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
	@JoinColumn(name = "type_id", insertable = false, updatable = false)
	private TypeNoguchi type;

	/** 外部キー設定：ジャンル1 */
	@ManyToOne(targetEntity = Genre1Noguchi.class)
	@JoinColumn(name = "genre1_id", insertable = false, updatable = false)
	private Genre1Noguchi genre1;

	/** 外部キー設定：ジャンル2 */
	@ManyToOne(targetEntity = Genre2Noguchi.class)
	@JoinColumn(name = "genre2_id", insertable = false, updatable = false)
	private Genre2Noguchi genre2;

}
