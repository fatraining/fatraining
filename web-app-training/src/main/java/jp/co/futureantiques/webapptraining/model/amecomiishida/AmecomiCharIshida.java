package jp.co.futureantiques.webapptraining.model.amecomiishida;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author ishida
 * AmecomiCharIshidaテーブルに対応するEntityクラス
 */
@Data
@Table(name="amecomi_char_ishida")
@Entity
public class AmecomiCharIshida {

	/** idカラムに対応するフィールド */
	@Id
	@GenericGenerator(name ="gen", strategy="increment")
	@GeneratedValue(generator ="gen")
	@Column
	private long id;


	/** キャラクター名 */
	@Column(name="char_name")
	private String charName;

	/** 出版社ID */
	@Column(name="company_id")
	private int companyId;

	/** サイドID */
	@Column(name="side_id")
	private int sideId;

	/** 初登場年 */
	@Column(name="debut_year")
	private Integer debutYear;

	/** コメント */
	@Column(name="comment")
	private String comment;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name="update_date")
	private Timestamp updateDate;


	/** 外部キー設定 */
	@ManyToOne(targetEntity = CompanyIshida.class)
	@JoinColumn(name="company_id",referencedColumnName="id",insertable=false,updatable=false)
	private CompanyIshida companyIshida;

	@ManyToOne(targetEntity = SideIshida.class)
	@JoinColumn(name="side_id",referencedColumnName="id",insertable=false,updatable=false)
	private SideIshida sideIshida;

}