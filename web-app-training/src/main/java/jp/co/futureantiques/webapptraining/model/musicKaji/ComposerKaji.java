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
 * MusicComposerテーブルと対応するEntity
 *
 * @author futute
 *
 */
@Data
@Entity
public class ComposerKaji {

	/** 作曲者ID **/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 名前 **/
	@Column(name = "name")
	@Size(max = 256)
	private String name;

	/** 削除フラグ **/
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 **/
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 **/
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：作曲者ID **/
	@Transient
	@OneToMany(targetEntity = MusicMainKaji.class,mappedBy = "composerkaji")
	@JoinColumn(name = "id", referencedColumnName = "composer_id")
	private List<MusicMainKaji> musicMainKajiList;
}
