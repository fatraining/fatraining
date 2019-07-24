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
 * TypeSakumaと対応するEntity
 *
 * @author Sakuma
 *
 */
@Data
@Entity
public class TypeSakuma {

	/** タイプID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** タイプ名 */
	@Column(name = "type_name")
	@Size(max = 256)
	private String typeName;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定:タイプ1ID*/
	@Transient
	@OneToMany(targetEntity = MobileLegendsMainSakuma.class, mappedBy = "typeSakuma1")
	@JoinColumn(name = "id", referencedColumnName = "type1_id")
	private List<MobileLegendsMainSakuma> mobileLegendsMainListType1;

	/** 外部キー設定:タイプ2ID*/
	@Transient
	@OneToMany(targetEntity = MobileLegendsMainSakuma.class, mappedBy = "typeSakuma2")
	@JoinColumn(name = "id", referencedColumnName = "type2_id")
	private List<MobileLegendsMainSakuma> mobileLegendsMainListType2;

}
