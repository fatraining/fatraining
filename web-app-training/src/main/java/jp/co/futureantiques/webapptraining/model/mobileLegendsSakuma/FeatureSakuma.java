package jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma;

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
 * FeatureSakumaテーブルと対応するEntity
 * @author Sakuma
 *
 * */
@Data
@Entity
public class FeatureSakuma {

	/** 特徴ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 特徴名 */
	@Column(name = "feature_name")
	@Size(max = 256)
	private String featureName;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定:特徴1ID */
	@Transient
	@OneToMany(targetEntity = MobileLegendsMainSakuma.class, mappedBy = "featureSakuma1")
	@JoinColumn(name = "id", referencedColumnName = "feature1_id")
	private List<MobileLegendsMainSakuma> mobileLegendsMainListFeature1;

	/** 外部キー設定:特徴2ID */
	@Transient
	@OneToMany(targetEntity = MobileLegendsMainSakuma.class, mappedBy = "featureSakuma2")
	@JoinColumn(name = "id", referencedColumnName = "feature2_id")
	private List<MobileLegendsMainSakuma> mobileLegendsMainListFeature2;

}
