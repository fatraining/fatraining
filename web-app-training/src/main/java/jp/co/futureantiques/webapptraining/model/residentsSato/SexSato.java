package jp.co.futureantiques.webapptraining.model.residentsSato;

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
 * ResidentsSexテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class SexSato {

	/** 性別ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 性別 */
	@Column(name = "sex")
	@Size(max = 256)
	private String sex;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：俳優ID */
	@Transient
	@OneToMany(targetEntity = ResidentsMainSato.class, mappedBy = "sex")
	@JoinColumn(name = "id", referencedColumnName = "sex_id")
	private List<ResidentsMainSato> residentsMainList;
}