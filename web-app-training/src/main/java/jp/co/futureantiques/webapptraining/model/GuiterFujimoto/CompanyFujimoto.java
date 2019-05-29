package jp.co.futureantiques.webapptraining.model.GuiterFujimoto;

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

/**companyテーブルと対応するEntityクラス
 *
 * @author futureFUJIMOTO
 *
 */
@Data
@Entity
public class CompanyFujimoto {
	/**会社ID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**会社*/
	@Column(name = "company")
	@Size(max = 256)
	private String company;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String DelFlg;

	/**登録日時*/
	@Column(name = "create_date")
	private String createDate;

	//更新日時
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定：ジャンルID*/
	@Transient
	@OneToMany(targetEntity = GuiterMainFujimoto.class, mappedBy = "company_id")
	@JoinColumn(name = "id", referencedColumnName = "company_id")
	private List<GuiterMainFujimoto> guiterMainFujimotoList;

}
