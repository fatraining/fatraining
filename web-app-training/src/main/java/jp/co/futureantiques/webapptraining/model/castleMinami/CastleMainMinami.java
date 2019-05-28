package jp.co.futureantiques.webapptraining.model.castleMinami;

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
 * CastleMainMinamiテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class CastleMainMinami {

		/** お城ID */
		@Id
		@GenericGenerator(name = "gen", strategy = "increment")
		@GeneratedValue(generator = "gen")
		private long id;

		/** お城名 */
		@Column(name = "castle_name")
		private String castleName;

		/** 城主 */
		@Column(name = "cashu_name")
		private String cashuName;

		/** 所在地ID */
		@Column(name = "prefecture_id")
		private Integer prefectureId;

		/** 築城年 */
		@Column(name = "castle_year")
		private int castleYear;

		/** 天守ID */
		@Column(name = "tenshu_id")
		private Integer tenshuId;

		/** コメント */
		@Column(name = "comment")
		@Size(max = 300)
		private String comment;

		/** 削除フラグ */
		@Column(name = "del_flg")
		private String delFlg;

		/** 登録日時 */
		@Column(name = "create_date")
		private Timestamp createDate;

		/** 更新日時 */
		@Column(name = "update_date")
		private Timestamp updateDate;

		/** 外部キー設定：所在地 */
		@ManyToOne(targetEntity = PrefectureMinami.class)
		@JoinColumn(name = "prefecture_id", referencedColumnName = "id", insertable = false, updatable = false)
		private PrefectureMinami prefecture;

		/** 外部キー設定：天守 */
		@ManyToOne(targetEntity = TenshuMinami.class)
		@JoinColumn(name = "tenshu_id", referencedColumnName = "id", insertable = false, updatable = false)
		private TenshuMinami tenshu;
}
