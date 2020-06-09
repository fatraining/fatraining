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
 * Makerテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class MakerOhkubo {

	/** メーカーID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** メーカー名 */
	@Column(name = "maker")
	@Size(max = 255)
	private String maker;

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
	@OneToMany(targetEntity = DrinkMainOhkubo.class, mappedBy = "maker")
	@JoinColumn(name = "id", referencedColumnName = "maker_id")
	private List<DrinkMainOhkubo> drinkMainList;
}
