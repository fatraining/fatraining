package jp.co.futureantiques.webapptraining.model.disneyIto;

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
 * disney_park_itoテーブルと対応するEntityクラス
 *
 * @author Ayaka Ito
 */
@Data
@Entity

public class DisneyParkIto {

	/** パークID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** パーク */
	@Column(name = "park")
	@Size(max = 256)
	private String park;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：パークID */
	@Transient
	@OneToMany(targetEntity = DisneyMainIto.class, mappedBy = "park")
	@JoinColumn(name = "id", referencedColumnName = "park_id")
	private List<DisneyMainIto> disneyMainList;
}
