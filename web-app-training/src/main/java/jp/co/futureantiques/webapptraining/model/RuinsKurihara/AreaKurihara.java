package jp.co.futureantiques.webapptraining.model.RuinsKurihara;

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
 * Areaテーブルと対応するEntity
 *
 * @author M.Kurihara
 */
@Data
@Entity
public class AreaKurihara {

	/** 地域ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 地域 */
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

	/** 外部キー設定：地域ID */
	@Transient
	@OneToMany(targetEntity = RuinsMainKurihara.class, mappedBy = "area")
	@JoinColumn(name = "id", referencedColumnName = "area_id")
	private List<RuinsMainKurihara> RuinsMainKuriharaList;
}