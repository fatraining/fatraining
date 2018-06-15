package jp.co.futureantiques.webapptraining.model.machoizawa;

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

@Data
@Entity
public class BodyIzawa {

	/** 部位ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 部位名 */
	@Column(name = "bodyname")
	@Size(max = 255)
	private String bodyname;

//	/** 削除フラグ */
//	@Column(name = "del_flg")
//	private String delFlg;
//
//	/** 登録日時 */
//	@Column(name = "create_date")
//	private String createDate;
//
//	/** 更新日時 */
//	@Column(name = "update_date")
//	private String updateDate;

	/** 外部キー設定：ジャンルID */
	@Transient
	@OneToMany(targetEntity = MuscleIzawa.class, mappedBy = "bodyizawa")
	@JoinColumn(name = "id", referencedColumnName = "body")
	private List<MuscleIzawa> muscleIzawaList;

}
