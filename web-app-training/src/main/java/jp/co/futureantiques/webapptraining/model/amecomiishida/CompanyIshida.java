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
 * CompanyIshidaテーブルと対応するEntityクラス
 */
@Data
@Entity
public class CompanyIshida {

	/** 出版社ID 主キー */
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	/** 出版社 */
	@Column(name="company")
	private String company;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name="update_date")
	private String updateDate;

	/** 外部キー設定 出版社ID */
	@Transient
	@OneToMany(targetEntity=AmecomiCharIshida.class,mappedBy="companyIshida")
	@JoinColumn(name="id",referencedColumnName="company_id")
	private List<AmecomiCharIshida> amecomiCharList;
}
