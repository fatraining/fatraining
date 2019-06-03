package jp.co.futureantiques.webapptraining.model.spaOkabe;

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
 * AreaOkabeテーブルと対応するEntityクラス
 *
 * @author SEIYA OKABE
 */
@Data
@Entity

public class AreaOkabe {

	/** 都道府県ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**　都道府県  */
	@Column(name = "area")
	@Size(max = 50)
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

	/** 外部キー設定：ジャンルID */
	@Transient
	@OneToMany(targetEntity = SpaMainOkabe.class, mappedBy = "areaOkabe")
	@JoinColumn(name = "id", referencedColumnName = "area_id")
	private List<SpaMainOkabe> spaMainOkabeList;

}
