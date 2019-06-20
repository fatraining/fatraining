package jp.co.futureantiques.webapptraining.model.kyarySahota;

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
 * CdTypeテーブルと対応するEntityクラス
 *
 * @author futureantiques
 *
 */
@Data
@Entity
public class CdTypeSahota {

	/** CD形態ID */
	@Id
	@GeneratedValue
	@Column(name = "type_id")
	private int typeId;

	/** CD形態 */
	@Column(name = "cd_type")
	@Size(max = 256)
	private String cdType;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delflg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：CD形態ID */
	@Transient
	@OneToMany(targetEntity = KyaryMainSahota.class,mappedBy = "type_name")
	@JoinColumn(name = "type_id",referencedColumnName = "type_id")
	private List<KyaryMainSahota> kyaryMainSahotaList;
}
