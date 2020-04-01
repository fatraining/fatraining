package jp.co.futureantiques.webapptraining.model.bandIto;

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
 * AreaItoテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class AreaIto {
	/** 出身地ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 出身地 */
	@Column(name = "area")
	@Size(max = 255)
	private String area;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：出身地ID */
	@Transient
	@OneToMany(targetEntity = BandMainIto.class, mappedBy = "areaIto")
	@JoinColumn(name = "id", referencedColumnName = "area_id")
	private List<BandMainIto> areaItoMainList;

}