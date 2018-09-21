package jp.co.futureantiques.webapptraining.model.Electronics;

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
 * Brandテーブルと対応するエンティティ
 * @author AIRI ITO
 */
@Data
@Entity
public class BrandIto {

	/** ブランドID */
	@Id
	@GeneratedValue
	@Column(name = "brand_id")
	private int id;

	/** ブランド */
	@Column(name = "brand")
	@Size(max = 255)
	private String brand;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：ブランドID */
	@Transient
	@OneToMany(targetEntity = ElectronicsMainIto.class, mappedBy = "brand")
	@JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
	private List<ElectronicsMainIto> ElectronicsMainList;
}
