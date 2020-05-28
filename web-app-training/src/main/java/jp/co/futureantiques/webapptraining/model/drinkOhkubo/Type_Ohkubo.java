package jp.co.futureantiques.webapptraining.model.drinkOhkubo;

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
 * 種類テーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class Type_Ohkubo {
	/** 種類ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 種類 */
	@Column(name = "type")
	@Size(max = 255)
	private String type;

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
	@OneToMany(targetEntity = DrinkMain_Ohkubo.class, mappedBy = "type")
	@JoinColumn(name = "id", referencedColumnName = "type_id")
	private List<DrinkMain_Ohkubo> drinkMainList;
}
