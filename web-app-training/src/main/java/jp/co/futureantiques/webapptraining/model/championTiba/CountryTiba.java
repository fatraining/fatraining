package jp.co.futureantiques.webapptraining.model.championTiba;

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

/** Countryテーブルと対応するEntity */

@Data
@Entity
public class CountryTiba {

	/** 国名ID */
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	/** 国名 */
	@Column(name="country")
	@Size(max=4)
	private String country;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name="update_date")
	private String updateDate;

	/** 外部キー設定：国名ID */
	@Transient
	@OneToMany(targetEntity=ChampionMainTiba.class, mappedBy="country")
	@JoinColumn(name="id", referencedColumnName="country_id")
	private List<ChampionMainTiba> ChampionMainTibaList;
}
