package jp.co.futureantiques.webapptraining.model.playerKuramoto;

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
 * PlayerPositionKuramotoテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class PlayerPositionKuramoto {

	/** ポジションID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** ポジション名 */
	@Column(name = "position_name")
	@Size(max = 255)
	private String positionName;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：ポジションID */
	@Transient
	@OneToMany(targetEntity = PlayerMainKuramoto.class, mappedBy = "playerPosition")
	@JoinColumn(name = "id", referencedColumnName = "position_id")
	private List<PlayerMainKuramoto> playerMainKuramotoList;
}