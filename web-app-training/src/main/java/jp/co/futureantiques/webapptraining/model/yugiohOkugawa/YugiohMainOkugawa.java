package jp.co.futureantiques.webapptraining.model.yugiohOkugawa;

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
 * YugiohMainOkugawaテーブルと対応するEntity
 *
 * @author Okugawa
 *
 */
@Data
@Entity
public class YugiohMainOkugawa {

	/** キャラクターID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** キャラクター名 */
	@Column(name = "name")
	private String name;

	/** 作品ID */
	@Column(name = "series_id")
	private Integer seriesId;

	/** デッキID */
	@Column(name = "deck_id")
	private Integer deckId;

	/** 召喚法 */
	@Column(name = "summons")
	private String summons;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 300)
	private String comment;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定:作品 */
	@ManyToOne(targetEntity = SeriesOkugawa.class)
	@JoinColumn(name = "series_id", referencedColumnName = "id", insertable = false, updatable = false)
	private SeriesOkugawa seriesOkugawa;

	/** 外部キー設定:デッキ */
	@ManyToOne(targetEntity = DeckOkugawa.class)
	@JoinColumn(name = "deck_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DeckOkugawa deckOkugawa;

}
