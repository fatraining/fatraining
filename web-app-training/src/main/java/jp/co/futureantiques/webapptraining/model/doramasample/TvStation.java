package jp.co.futureantiques.webapptraining.model.doramasample;

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
 * TvStationテーブルと対応するEntity
 *
 * @author hiraoka
 */
@Data
@Entity
public class TvStation {

	/** 放送局ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 名前 */
	@Column(name = "tv_station")
	@Size(max = 255)
	private String tvStation;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：放送局ID */
	@Transient
	@OneToMany(targetEntity = DoramaMain.class, mappedBy = "tvStation")
	@JoinColumn(name = "id", referencedColumnName = "tvstation_id")
	private List<DoramaMain> doramaMainList;
}