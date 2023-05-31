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
 * ElementShiraseテーブルと対応するEntity
 * @author shirase
 */

@Data
@Entity
public class ElementShirase {

	/** 属性ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	/** 属性名 */
	@Column(name = "element")
	private String element;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private Integer delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：属性ID */
	@Transient
	@OneToMany(targetEntity = MonsterMainShirase.class, mappedBy = "elementShirase")
	@JoinColumn(name = "id", referencedColumnName = "element_id")
	private List<MonsterMainShirase> monsterMainList;

}
