
package jp.co.futureantiques.webapptraining.model.riderSaito;

import java.sql.Timestamp;
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

/** AgeSaitoテーブルに対応するEntity
 *
 * @author future
 * */

@Data
@Entity
public class AgeSaito {

	/** 年代ID */
	@Id
	@GeneratedValue
	@Column(name = "age_id")
	private Integer ageId;

	/** 年代 */
	@Column(name = "age")
	@Size(max = 256)
	private String age;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録削除 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定 :年代ID */
	@Transient
	@OneToMany(targetEntity=RiderMainSaito.class, mappedBy="ageSaito")
	@JoinColumn(name="age_id", referencedColumnName="age_id")
	private List<RiderMainSaito> riderMainSaitoList;

}