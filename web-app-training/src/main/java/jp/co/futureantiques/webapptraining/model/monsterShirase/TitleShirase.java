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
 * TitleShiraseテーブルと対応するEntity
 * @author Shirase
 */

@Data
@Entity
public class TitleShirase {

	/** 作品ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	/** 作品名 */
	@Column(name = "title")
	private String title;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private Integer delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：作品ID */
	@Transient
	@OneToMany(targetEntity = MonsterMainShirase.class, mappedBy = "titleShirase")
	@JoinColumn(name = "id", referencedColumnName = "title_id")
	private List<MonsterMainShirase> monsterMainList;

}
