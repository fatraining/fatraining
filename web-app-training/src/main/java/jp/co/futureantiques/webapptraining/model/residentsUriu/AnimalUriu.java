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
 * animal_uriuテーブルと対応するEntity
 *
 */

@Data
@Entity
public class AnimalUriu {

	/** どうぶつID */
	@Id
	@Column(name="id")
	private int id;

	/** どうぶつ */
	@Column(name="animal")
	private String animal;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name="update_date")
	private Timestamp updateDate;

	/** 外部キー設定：どうぶつID */
	@Transient
	//@OneToMany(targetEntity=ResidentsMainUriu.class,mappedBy="animalUriu")
	@OneToMany(targetEntity=ResidentsMainUriu.class,mappedBy="animalUriu")
	@JoinColumn(name="id",referencedColumnName="animal_id")
	//@JoinColumn(name="animal_id",referencedColumnName="id")
	private List<ResidentsMainUriu> residentsMainUriuList;

}
