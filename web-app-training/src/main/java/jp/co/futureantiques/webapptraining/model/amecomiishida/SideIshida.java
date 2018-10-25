package jp.co.futureantiques.webapptraining.model.amecomiishida;

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
 * @author user
 * side_ishidaテーブルに対応するフィールド
 */
@Data
@Entity
public class SideIshida {

	/** サイドID */
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	/** サイド名 */
	@Column(name="side")
	private String side;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name="update_date")
	private String updateDate;

	/** 外部キー設定 サイドID */
	@Transient
	@OneToMany(targetEntity=AmecomiCharIshida.class,mappedBy="sideIshida")
	@JoinColumn(name="id",referencedColumnName="side_id")
	private List<AmecomiCharIshida> amecomiCharList;
}
