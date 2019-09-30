package jp.co.futureantiques.webapptraining.model.animeNagatake;

import java.sql.Timestamp;
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
 * StudioNagatakeテーブルに対応するEntity
 *
 * @author future
 * */

@Data
@Entity
public class StudioNagatake {

	/** スタジオID */
	@Id
	@GeneratedValue
	@Column(name = "studio_id")
	private Integer studioId;

	/** スタジオ */
	@Column(name = "studio")
	@Size(max = 256)
	private String studio;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定 :スタジオID */
	@Transient
	@OneToMany(targetEntity=AnimeMainNagatake.class, mappedBy="studioNagatake")
	@JoinColumn(name="studio_id", referencedColumnName="studio_id")
	private List<AnimeMainNagatake> animeMainNagatakeList;

}