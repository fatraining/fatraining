package com.example.demo.model.drama;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * CountryNakaniwaテーブルと対応するEntity
 */

@Data
@Entity
public class CountryNakaniwa {

	/** 製作国ID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 国名*/
	@Column(name = "country_name")
	@Size(max = 255)
	private String countryName;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：製作国ID */

	@OneToMany(targetEntity = DramaMainNakaniwa.class, mappedBy = "countryNakaniwa")
	//@JoinColumn(name = "id", referencedColumnName = "country_id")
	private List<DramaMainNakaniwa> dramaMainNakaniwaList;

}
