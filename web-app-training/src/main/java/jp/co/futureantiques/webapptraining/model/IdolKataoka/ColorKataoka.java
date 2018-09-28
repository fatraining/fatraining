package jp.co.futureantiques.webapptraining.model.IdolKataoka;

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
 * ColorKataokaテーブルと対応するEntityクラス
 *
 *
 */
@Data
@Entity

public class ColorKataoka {

	/** メンバーカラーID */
	@Id
	@GeneratedValue
	@Column(name = "color_id")
	private int colorId;

	/** メンバーカラー */
	@Column(name = "color_name")
	@Size(max = 256)
	private String colorName;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：メンバーカラーID */
	@Transient
	@OneToMany(targetEntity = IdolMainKataoka.class, mappedBy = "color_id")
	@JoinColumn(name = "color_id", referencedColumnName = "color_id")
	private List<IdolMainKataoka> idolMainKataokaList;
}