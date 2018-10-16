package jp.co.futureantiques.webapptraining.model.flowerNakai;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;
/**
 * SQL color_nakaiテーブルと対応しているエンティティ
 * @author Rieko Nakai
 */
@Data
@Entity
public class ColorNakai {
	/* 色ID */
	@Id
	@GeneratedValue
	@Column(name="color_id")
	private int colorId;

	/* 花の色 */
	@Column(name="color")
	private String color;

	/* 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/* 登録日時 */
	@Column(name="create_date")
	private Timestamp createDate;

	/* 更新日時 */
	@Column(name="update_date")
	private Timestamp updateDate;

	/* 外部キー設定：色ID */
	@Transient
	@OneToMany(targetEntity = FlowerMainNakai.class,mappedBy="colorNakai")
	@JoinColumn(name="color_id",referencedColumnName="color_id")
	private ColorNakai colorNakai;
}
