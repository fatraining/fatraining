package jp.co.futureantiques.webapptraining.model.residentsUriu;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/**
 * type_uriuテーブルと対応するEntity
 *
 */

@Data
@Entity
public class TypeUriu {

	/** 性格ID */
	@Id
	@Column(name="id")
	private int id;

	/** 性格タイプ */
	@Column(name="type")
	private String type;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：性格ID */
	@Transient
	//@OneToMany(targetEntity=ResidentsMainUriu.class,mappedBy="typeUriu")
	@OneToMany(targetEntity=ResidentsMainUriu.class,mappedBy="typeUriu")
	@JoinColumn(name="id",referencedColumnName="type_id")
	//@JoinColumn(name="type_id",referencedColumnName="id")
	private List<ResidentsMainUriu> residentsMainUriuList;

}
