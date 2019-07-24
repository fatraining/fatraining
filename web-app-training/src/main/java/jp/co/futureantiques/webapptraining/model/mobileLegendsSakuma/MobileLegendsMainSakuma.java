package jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma;

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

/*
 * MobileLegendsMainSakumaテーブルと対応するEntity
 *
 * @author Sakuma
 */
@Data
@Entity
public class MobileLegendsMainSakuma {

	//PRIMARY KEY = キャラクターID

	/**キャラクターID*/
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	//以下、Mappingさせるカラム名の指定

	/**キャラクター名*/
	@Column(name = "mobale_chara")
	private String mobaleChara;

	/**タイプ1ID*/
	@Column(name = "type1_id")
	private Integer type1Id;

	/**タイプ2ID*/
	@Column(name = "type2_id")
	private Integer type2Id;

	/**特徴1ID*/
	@Column(name = "feature1_id")
	private Integer feature1Id;

	/**特徴2ID*/
	@Column(name = "feature2_id")
	private Integer feature2Id;

	/**コメント*/
	@Column(name = "comment")
	@Size(max = 256)
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

	/** 外部キー設定:タイプ1 */
	@ManyToOne(targetEntity = TypeSakuma.class)
	@JoinColumn(name = "type1_id", referencedColumnName = "id", insertable = false, updatable = false)
	private TypeSakuma typeSakuma1;

	/** 外部キー設定:タイプ2 */
	@ManyToOne(targetEntity = TypeSakuma.class)
	@JoinColumn(name = "type2_id", referencedColumnName = "id", insertable = false, updatable = false)
	private TypeSakuma typeSakuma2;

	/** 外部キー設定:特徴1 */
	@ManyToOne(targetEntity = FeatureSakuma.class)
	@JoinColumn(name = "feature1_id", referencedColumnName = "id", insertable = false, updatable = false)
	private FeatureSakuma featureSakuma1;

	/** 外部キー設定:特徴2 */
	@ManyToOne(targetEntity = FeatureSakuma.class)
	@JoinColumn(name = "feature2_id", referencedColumnName = "id", insertable = false, updatable = false)
	private FeatureSakuma featureSakuma2;

}
