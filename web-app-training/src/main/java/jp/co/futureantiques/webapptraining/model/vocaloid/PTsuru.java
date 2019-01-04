package jp.co.futureantiques.webapptraining.model.vocaloid;

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
 * Genreテーブルと対応するEntityクラス
 *
 * @author future
 */
@Data
@Entity
public class PTsuru {

	/** PID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** P名 */
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

	/** 外部キー設定：ジャンルID */
	@Transient
	@OneToMany(targetEntity = VocaloMain.class, mappedBy = "pTsuru")
	@JoinColumn(name = "id", referencedColumnName = "p_id")
	private List<VocaloMain> vocaloMainList;
}