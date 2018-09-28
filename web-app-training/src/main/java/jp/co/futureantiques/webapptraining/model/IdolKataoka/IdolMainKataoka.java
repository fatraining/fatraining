package jp.co.futureantiques.webapptraining.model.IdolKataoka;

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
 * IdolKataokaMainテーブルと対応するEntity
 *
 * @author skataoka
 */

@Data
@Entity
public class IdolMainKataoka {
	/** アイドルID 主キーとなるので＠の表記が違う */
	@Id
	@Column(name = "idol_id")
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private Integer idolId;

	/** アイドルの名前 */
	@Column(name = "idol_name")
	@Size(max = 256)
	private String idolName;

	/**メンバーカラーID */
	@Column(name = "color_id")
	private Integer colorId;

	/**  写真 */
	@Column(name = "photo")
	@Size(max = 256)
	private String photo;

	/**  所属グループID */
	@Column(name = "group_id")
	private Integer groupId;
//
//	/**  所属グループ名 */
//	@Column(name = "group_name")
//	private String groupName;

	/**  コメント */
	@Column(name = "comment")
	@Size(max = 256)
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

	/** 外部キー設定：メンバーカラー */
	@ManyToOne(targetEntity = ColorKataoka.class)
	@JoinColumn(name = "color_id", referencedColumnName = "color_id", insertable = false, updatable = false)
	private ColorKataoka colorKataoka;

	/** 外部キー設定：所属グループ */
	@ManyToOne(targetEntity = GroupKataoka.class)
	@JoinColumn(name = "group_id", referencedColumnName = "group_id", insertable = false, updatable = false)
	private GroupKataoka groupKataoka;

}
