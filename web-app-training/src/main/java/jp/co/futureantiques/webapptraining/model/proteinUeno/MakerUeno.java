package jp.co.futureantiques.webapptraining.model.proteinUeno;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
public class MakerUeno {

	/** メーカーID**/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	/** メーカー**/
	@Column(name = "maker")
	private String maker;

	/**削除フラグ**/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時**/
	@Column(name = "create_date")
	private String createDate;

	/**更新日時**/
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定：　メーカーID**/
	@Transient
	@OneToMany(targetEntity = ProteinMainUeno.class, mappedBy = "maker")
	@JoinColumn(name = "id", referencedColumnName = "maker_id")
	private List<ProteinMainUeno> proteinMainUenoList;

}
