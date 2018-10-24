package jp.co.futureantiques.webapptraining.model.IcecreamSako;
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
 * MakerSakoテーブルと対応するEntity
 *
 * @author MINAMI SAKO
 */
@Data
@Entity
public class MakerSako {

	/** メーカーID */
	@Id
	@GeneratedValue
	@Column(name = "maker_id")
	private int makerId;

	/** メーカー */
	@Column(name = "maker")
	@Size(max = 256)
	private String maker;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：所属グループID */
	@Transient
	@OneToMany(targetEntity = IcecreamMainSako.class, mappedBy = "maker_id")
	@JoinColumn(name = "maker_id", referencedColumnName = "maker_id")
	private List<IcecreamMainSako> IcecreamMainSakoList;
}