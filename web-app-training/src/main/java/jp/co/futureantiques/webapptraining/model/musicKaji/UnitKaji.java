package jp.co.futureantiques.webapptraining.model.musicKaji;

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
 * Unitテーブルと対応するEntityクラス
 * コミットテスト1.7
 * コミットテスト1.7(競合)
 * @author futute
 *
 */
@Data
@Entity
public class UnitKaji {

	/** ユニットID **/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** ユニット **/
	@Column(name = "unit")
	@Size(max = 256)
	private String unit;

	/** 削除フラグ **/
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 **/
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 **/
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：ユニットID **/
	@Transient
	@OneToMany(targetEntity = MusicMainKaji.class, mappedBy = "unitkaji")
	@JoinColumn(name = "id", referencedColumnName = "unit_id")
	private List<MusicMainKaji> musicMainKajiList;

}
