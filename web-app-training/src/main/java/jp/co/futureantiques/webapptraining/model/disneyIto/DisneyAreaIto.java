package jp.co.futureantiques.webapptraining.model.disneyIto;

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
 * disney_area_itoテーブルと対応するEntity
 *
 * @author Ayaka Ito
 */
@Data
@Entity
public class DisneyAreaIto {

	/** エリアID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 名前 */
	@Column(name = "area")
	@Size(max = 256)
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

	/** 外部キー設定：エリアID */
	@Transient
	@OneToMany(targetEntity = DisneyMainIto.class, mappedBy = "area")
	@JoinColumn(name = "id", referencedColumnName = "area_id")
	private List<DisneyMainIto> disneyMainList;

}
