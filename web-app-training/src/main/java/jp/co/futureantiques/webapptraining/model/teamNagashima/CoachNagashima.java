package jp.co.futureantiques.webapptraining.model.teamNagashima;

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

/**Coachテーブルと対応するEntity
 *
 * @author future
 *
 */
@Data
@Entity
public class CoachNagashima {

	/**監督国籍ID*/
	@Id
	@GeneratedValue
	@Column(name = "coach_id")
	private int coachId;

	/**国籍*/
	@Column(name = "country")
	@Size(max=50)
	private String country;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定：監督国籍ID*/
	@Transient
	@OneToMany(targetEntity = TeamMainNagashima.class, mappedBy = "coachNagashima")
	@JoinColumn(name = "coach_id", referencedColumnName = "coach_id")
	private List<TeamMainNagashima> teamMainNagashimaList;
}
