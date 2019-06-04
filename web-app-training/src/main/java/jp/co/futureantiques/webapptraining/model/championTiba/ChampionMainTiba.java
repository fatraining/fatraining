package jp.co.futureantiques.webapptraining.model.championTiba;

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

/** ChampionMainTibaテーブルと対応するEntity */
@Data
@Entity
public class ChampionMainTiba {

	/** チャンピオンID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** チャンピオン名 */
	@Column(name = "champion_name")
	private String championName;

	/** クラスID */
	@Column(name = "class_id")
	private Integer classId;

	/** 国名ID */
	@Column(name = "country_id")
	private Integer countryId;

	/** 戦績 */
	@Column(name = "achievement")
	private String achievement;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 255)
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

	/** 外部キー設定：階級 */
	@ManyToOne(targetEntity = ClassTiba.class)
	@JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ClassTiba classTiba;

	/** 外部キー設定：国名 */
	@ManyToOne(targetEntity = CountryTiba.class)
	@JoinColumn(name = "country_id", referencedColumnName = "id", insertable = false, updatable = false)
	private CountryTiba countryTiba;

}
