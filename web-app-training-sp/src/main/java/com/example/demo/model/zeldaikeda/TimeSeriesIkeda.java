
package com.example.demo.model.zeldaikeda;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * TimeSeriesIkedaテーブルと対応するEntity
 */
@Data
@Entity
public class TimeSeriesIkeda {
	
	/** 時系列ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 時系列名 */
	@Column(name = "time_series")
	@Size(max = 255)
	private String timeSeries;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：著者ID */
	@OneToMany(targetEntity = ZeldaMainIkeda.class, mappedBy = "timeSeries")
	private List<ZeldaMainIkeda> zeldaMainIkedaList;
}
