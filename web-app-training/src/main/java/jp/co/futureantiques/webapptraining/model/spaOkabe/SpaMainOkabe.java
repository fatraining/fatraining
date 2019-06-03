package jp.co.futureantiques.webapptraining.model.spaOkabe;

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
 * SpaMainOkabeテーブルと対応するEntity
 *
 * @author SEIYA OKABE
 */
@Data
@Entity

public class SpaMainOkabe {

	/**温泉地ID */
	//主キーの指定
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	//自動採番
	@GeneratedValue(generator = "gen")
	private long id;

	/** 温泉地名 */
	//カラム名
	@Column(name = "spa_name")
	private String spaName;

	/** 都道府県ID */
	@Column(name = "area_id")
	private Integer areaId;

	/** 泉質ID */
	@Column(name = "quality_id")
	private Integer qualityId;


	/** 特徴 */
	@Column(name = "features")
	@Size(max = 50)
	private String features;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：都道府県 */
	//多対一関連定義
	@ManyToOne(targetEntity = AreaOkabe.class)
	//結合に用いるカラムを指定
	@JoinColumn(name = "area_id", referencedColumnName = "id", insertable = false, updatable = false)
	private AreaOkabe areaOkabe;

	/** 外部キー設定：泉質 */
	@ManyToOne(targetEntity = QualityOkabe.class)
	@JoinColumn(name = "quality_id", referencedColumnName = "id", insertable = false, updatable = false)
	private QualityOkabe qualityOkabe;
}

