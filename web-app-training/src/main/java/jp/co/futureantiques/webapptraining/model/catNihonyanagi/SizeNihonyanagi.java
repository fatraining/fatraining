package jp.co.futureantiques.webapptraining.model.catNihonyanagi;

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
 *
 *大きさテーブルと対応するEntityクラス
 *@author Nihonyanagi
 *
 */

@Data
@Entity
public class SizeNihonyanagi {

	/** 大きさID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 大きさ */
	@Column(name = "size")
	private String size;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定 */
	@Transient
	@OneToMany(targetEntity = CatMainNihonyanagi.class,mappedBy = "size")
	@JoinColumn(name = "id",referencedColumnName = "size_id")
	private List<CatMainNihonyanagi> CatMainNihonyanagiList;
}
