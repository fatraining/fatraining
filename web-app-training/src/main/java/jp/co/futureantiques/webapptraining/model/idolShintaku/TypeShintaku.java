package jp.co.futureantiques.webapptraining.model.idolShintaku;

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
 * type_shintakuテーブルと対応するEntityクラス
 *
 * @author shintaku
 */
@Data
@Entity
public class TypeShintaku {

	//属性ID
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	//属性
	@Column(name = "type")
	private String type;

	//削除フラグ
	@Column(name = "del_flg")
	private String delFlg;

	//登録日時
	@Column(name = "create_date")
	private String createDate;

	//更新日時
	@Column(name = "update_date")
	private String updateDate;

	//外部キー設定：属性ID
	@Transient
	@OneToMany(targetEntity = IdolMainShintaku.class, mappedBy = "type")
	@JoinColumn(name = "id", referencedColumnName = "type_id")
	private List<IdolMainShintaku> idolMainShintakuList;
}