package jp.co.futureantiques.webapptraining.model.jojoShirasaka;
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

/** jojo_sex_shirasakaテーブルと対応するEntity */

@Data
@Entity
public class JojoSexShirasaka {

	/** 性別ID */
	@Id
	@GeneratedValue
	@Column(name = "sex_id")
	private int sexId;

	/** 性別 */
	@Column(name = "sex")
	@Size(max = 256)
	private String sex;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：性別ID */
	@Transient
	@OneToMany(targetEntity = JojoMainShirasaka.class, mappedBy = "jojoSexShirasaka")
	@JoinColumn(name = "sex_id", referencedColumnName = "sex_id")
	private List<JojoMainShirasaka> JojoMainShirasaka;
}