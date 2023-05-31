package jp.co.futureantiques.webapptraining.model.monsterShirase;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/**
 * GenreShiraseテーブルと対応するEntity
 * @author Shirase
 */

@Data
@Entity
public class GenreShirase {

	/** ジャンルID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	/** ジャンル名 */
	@Column(name = "genre")
	private String genre;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private Integer delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：ジャンルID */
	@Transient
	@OneToMany(targetEntity = MonsterMainShirase.class, mappedBy = "genreShirase")
	@JoinColumn(name = "id", referencedColumnName = "genre_id")
	private List<MonsterMainShirase> monsterMainList;

}
