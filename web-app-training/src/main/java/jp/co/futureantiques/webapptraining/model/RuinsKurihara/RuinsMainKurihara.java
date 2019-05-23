package jp.co.futureantiques.webapptraining.model.RuinsKurihara;

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
 * RuinsMainKuriharaテーブルと対応するEntity
 *
 * @author M.Kurihara
 */
@Data
@Entity
public class RuinsMainKurihara {

	/** 廃墟ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 廃墟名 */
	@Column(name = "ruins_name")
	private String ruinsName;

	/** 種別ID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 地域ID */
	@Column(name = "area_id")
	private Integer areaId;

	/** 年代 */
	@Column(name = "since")
	private String since;

	/** 概要 */
	@Column(name = "backstory")
	private String backStory;

	/** 備考 */
	@Column(name = "rem")
	@Size(max = 255)
	private String rem;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：種別 */
	@ManyToOne(targetEntity = GenreKurihara.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreKurihara genre;

	/** 外部キー設定：地域 */
	@ManyToOne(targetEntity = AreaKurihara.class)
	@JoinColumn(name = "area_id", referencedColumnName = "id", insertable = false, updatable = false)
	private AreaKurihara area;
}