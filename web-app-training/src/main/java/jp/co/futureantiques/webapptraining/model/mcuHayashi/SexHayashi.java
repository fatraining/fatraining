package jp.co.futureantiques.webapptraining.model.mcuHayashi;

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
 * McuMainHayashiテーブルと対応するEntity
 *
 * @author 林 重樹
 */
@Data
@Entity
public class SexHayashi {

	/** 性別ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 性別 */
	@Column(name = "name")
	@Size(max = 255)
	private String name;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：性別ID */
	@Transient
	@OneToMany(targetEntity = McuMainHayashi.class, mappedBy = "SexHayashi")
	@JoinColumn(name = "id", referencedColumnName = "Sex_id")
	private List<McuMainHayashi> McuMainHayashiList;

}
