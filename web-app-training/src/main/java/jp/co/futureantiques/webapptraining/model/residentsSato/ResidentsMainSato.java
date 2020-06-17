package jp.co.futureantiques.webapptraining.model.residentsSato;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * ResidentsMainテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class ResidentsMainSato {

	/** 住民ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 住民名 */
	@Column(name = "residents_name")
	private String residentsName;

	/** 動物ID */
	@Column(name = "animal_id")
	private Integer animalId;

	/** 性別ID */
	@Column(name = "sex_id")
	private Integer sexId;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 256)
	private String comment;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：動物 */
	@ManyToOne(targetEntity = AnimalSato.class)
	@JoinColumn(name = "animal_id", referencedColumnName = "id", insertable = false, updatable = false)
	private AnimalSato animalSato;

	/** 外部キー設定：性別 */
	@ManyToOne(targetEntity = SexSato.class)
	@JoinColumn(name = "sex_id", referencedColumnName = "id", insertable = false, updatable = false)
	private SexSato sexSato;
}
