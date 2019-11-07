package jp.co.futureantiques.webapptraining.model.crKawanaka;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/**
 * SQL category_kawanakaテーブルと対応しているエンティティ
 * @author Misato Kawanaka
 */
@Data
@Entity
public class CategoryKawanaka {

	/**カテゴリーID*/
	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int categoryId;

	/**カテゴリー*/
	@Column(name = "category")
	private String category;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "create_date")
	private Timestamp createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部主キー設定：カテゴリーID*/
	@Transient
	@OneToMany(targetEntity = CrMainKawanaka.class, mappedBy = "categoryKawanaka")
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private CategoryKawanaka categoryKawanaka;
}
