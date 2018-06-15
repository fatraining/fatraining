package jp.co.futureantiques.webapptraining.model.machoizawa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class MuscleIzawa {

	/** 筋肉ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/**  画像 */
	@Column(name = "photo")
	private String photo;

	/** メニュー */
	@Column(name = "menu")
	private String menu;

	/** 部位ID */
	@Column(name = "body")
	private Integer body;

	/** 公開年 */
	@Column(name = "com")
	@Size(max = 255)
	private String com;

//	/** 上映時間 */
//	@Column(name = "run_time")
//	private Integer runTime;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

//	/** 登録日時 */
//	@Column(name = "create_date")
//	private Timestamp createDate;
//
//	/** 更新日時 */
//	@Column(name = "update_date")
//	private Timestamp updateDate;

	/** 外部キー設定：ジャンル */
	@ManyToOne(targetEntity = BodyIzawa.class)
	@JoinColumn(name = "body", referencedColumnName = "id", insertable = false, updatable = false)
	private BodyIzawa bodyIzawa;

}
