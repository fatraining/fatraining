package jp.co.futureantiques.webapptraining.model.teamNagashima;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/**
 * Regionテーブルと対応するEntity
 * @author future
 *
 */
@Data
@Entity
public class RegionNagashima {

	/**地域ID*/
	@Id
	@GeneratedValue
	@Column(name = "region_id")
	private int regionId;

	/**地域名*/
	@Column(name = "name")
	private String name;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定：地域ID*/
	@Transient
	@OneToMany(targetEntity = TeamMainNagashima.class, mappedBy = "regionNagashima")
	@JoinColumn(name = "region_id", referencedColumnName = "region_id")
	private List<TeamMainNagashima> teamMainNagashimaList;

}
