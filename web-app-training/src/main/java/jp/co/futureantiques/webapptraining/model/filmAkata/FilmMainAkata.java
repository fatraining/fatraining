package jp.co.futureantiques.webapptraining.model.filmAkata;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * FilmMainテーブルと対応するEntity
 *
 * @author future
 */

@Data
@Entity
public class FilmMainAkata {

	/** フィルムID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** タイトル */
	@Column(name = "film_title")
	private String filmTitle;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 主演ID */
	@Column(name = "actor_id")
	private Integer actorId;

	/** 公開年 */
	@Column(name = "release_year")
	private int releaseYear;

	/** 上映時間 */
	@Column(name = "run_time")
	private Integer runTime;

	/** おすすめ度 */
	@Column(name = "recommend")
	@Size(max = 10)
	private String recommend;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：ジャンル*/
	@ManyToOne(targetEntity = FilmGenreAkata.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private FilmGenreAkata filmGenreAkata;

	/** 外部キー設定：主演 */
	@ManyToOne(targetEntity = FilmActorAkata.class)
	@JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false)
	private FilmActorAkata filmActorAkata;

}
