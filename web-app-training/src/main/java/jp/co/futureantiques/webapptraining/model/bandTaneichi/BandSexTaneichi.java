package jp.co.futureantiques.webapptraining.model.bandTaneichi;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * BandSexTaneichiテーブルと対応するEntity
 *
 * @author future
 *
 */
@Data
@Entity
public class BandSexTaneichi {

	/** 性別ID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 性別*/
	@Column(name = "sex")
	@Size(max = 20)
	private String sex;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時*/
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時*/
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定:性別ID*/
	@Transient
	@OneToMany(targetEntity = BandMainTaneichi.class, mappedBy = "bandSex")
	@JoinColumn(name = "id", referencedColumnName = "band_sex")
	private List<BandMainTaneichi> bandMainTaneichiList;
}
