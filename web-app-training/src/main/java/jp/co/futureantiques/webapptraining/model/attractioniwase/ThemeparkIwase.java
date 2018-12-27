package jp.co.futureantiques.webapptraining.model.attractioniwase;

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
 * ThemeparkIwaseテーブルと対応するEntityクラス
 *
 * @author iwase
 */
@Data
@Entity
public class ThemeparkIwase {

	/** ジャンルID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** ジャンル */
	@Column(name = "themepark")
	@Size(max = 255)
	private String themepark;

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
	@OneToMany(targetEntity = AttractionMainIwase.class, mappedBy = "themepark")
	@JoinColumn(name = "id", referencedColumnName = "themepark_id")
	private List<AttractionMainIwase> attractionMainIwaseList;
}