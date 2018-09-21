package jp.co.futureantiques.webapptraining.model.Electronics;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/**
 * Categoryテーブルと対応するエンティティ
 * @author AIRI ITO
 */
@Data
@Entity
public class CategoryIto {

	/** カテゴリーID */
	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int id;

	/** カテゴリー */
	@Column(name = "category")
	private String category;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：カテゴリーID */
	@Transient
	@OneToMany(targetEntity = ElectronicsMainIto.class, mappedBy = "category")
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private List<ElectronicsMainIto> ElectricsMainList;

}
