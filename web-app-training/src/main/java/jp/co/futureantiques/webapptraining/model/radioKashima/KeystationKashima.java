package jp.co.futureantiques.webapptraining.model.radioKashima;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class KeystationKashima {

	/** 放送局ID**/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	/** 放送局名**/
	@Column(name = "keystation")
	private String keystation;

	/**削除フラグ**/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時**/
	@Column(name = "create_date")
	private String createDate;

	/**更新日時**/
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定：　アルバムID**/
	@Transient
	@OneToMany(targetEntity = RadioMainKashima.class, mappedBy = "keystation")
	@JoinColumn(name = "id", referencedColumnName = "keystation_id")
	private List<RadioMainKashima> radioMainList;

}

