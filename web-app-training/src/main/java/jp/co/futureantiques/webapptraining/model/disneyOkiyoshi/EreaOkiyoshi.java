package jp.co.futureantiques.webapptraining.model.disneyOkiyoshi;

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
public class EreaOkiyoshi {

	
	/** エリアID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** エリア */
	@Column(name = "erea")
	@Size(max = 255)
	private String erea;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：エリアID */
	@Transient
	@OneToMany(targetEntity = DisneyMainOkiyoshi.class, mappedBy = "ereaokiyoshi")
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<DisneyMainOkiyoshi> disneyMainList;
}
