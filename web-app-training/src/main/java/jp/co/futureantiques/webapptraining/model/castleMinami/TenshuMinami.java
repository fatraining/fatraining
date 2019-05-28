package jp.co.futureantiques.webapptraining.model.castleMinami;

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
* TenshuMinamiと対応するEntityクラス
*
* @author future
*/
@Data
@Entity
public class TenshuMinami {

	/** 天守ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 天守 */
	@Column(name = "tenshu")
	@Size(max = 10)
	private String tenshu;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：所在地ID */
	@Transient
	@OneToMany(targetEntity = CastleMainMinami.class, mappedBy = "tenshu")
	@JoinColumn(name = "id", referencedColumnName = "tenshu_id")
	private List<CastleMainMinami> castleMainMinamiList;
}
