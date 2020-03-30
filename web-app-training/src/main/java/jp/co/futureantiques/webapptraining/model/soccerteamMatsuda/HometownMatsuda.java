package jp.co.futureantiques.webapptraining.model.soccerteamMatsuda;

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
 * hometown_matsudaテーブルと対応するEntityクラス
 *
 * @author future
 */
@Data
@Entity
public class HometownMatsuda {

	/** ホームタウンID */
	@Id
	@GeneratedValue
	@Column(name = "hometown_id")
	private int hometownId;

	/** ホームタウン */
	@Column(name = "hometown")
	@Size(max = 256)
	private String hometown;

	/** 削除フラグ */
	@Column(name = "del_flag")
	private String delFlag;

	/** 登録日時 */
	@Column(name = "create_flag")
	private String createFlag;

	/** 更新日時 */
	@Column(name = "update_flag")
	private String updateFlag;

	/** 外部キー設定：ジャンルID */
	@Transient
	@OneToMany(targetEntity = TeamMainMatsuda.class, mappedBy = "hometown")
	@JoinColumn(name = "hometown_id", referencedColumnName = "hometown_id")
	private List<TeamMainMatsuda> TeamMainMatsudaList;
}