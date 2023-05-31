package jp.co.futureantiques.webapptraining.model.mangaKawada;

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
 * anime_kawadaテーブルと対応するEntityクラス
 * @author Kawada
 */

@Data
@Entity
public class AnimeKawada {
	/** アニメID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** アニメ化 */
	@Column(name = "anime")
	@Size(max = 256)
	private String anime;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：アニメID */
	@Transient
	@OneToMany(targetEntity = MangaMainKawada.class, mappedBy = "animekawada")
	@JoinColumn(name = "id", referencedColumnName = "anime_id")
	private List<MangaMainKawada> mangaMainKawadaList;
}
