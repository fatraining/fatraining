package jp.co.futureantiques.webapptraining.model.gameMiura;

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
 * genre_miuraテーブルと対応するEntityクラス
 *
 * @author future
 */
@Data
@Entity
public class GameGenreMiura {

	/** ジャンルID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** ジャンル */
	@Column(name = "genre")
	@Size(max = 256)
	private String genre;

	/** 削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定 : ジャンルID */
	@Transient
	@OneToMany(targetEntity = GameMainMiura.class, mappedBy = "gamegenremiura")
	@JoinColumn(name = "id", referencedColumnName = "genre_id")
	private List<GameMainMiura> gameMainMiura;
}