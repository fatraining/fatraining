package jp.co.futureantiques.webapptraining.model.okashiotani;

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
 * TypeOtaniテーブルと対応するEntityクラス
 *
 * @author future
 */

@Data
@Entity
public class TypeOtani {

	/** 種類ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 種類 */
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

	/** 外部キー設定：種類ID */
	@Transient
	@OneToMany(targetEntity = OkashiMainOtani.class, mappedBy = "TypeOtani")
	@JoinColumn(name = "id", referencedColumnName = "type_id")
	private List<OkashiMainOtani> okashiMainList;

}
