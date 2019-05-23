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

/** jojo_appearance_shirasakaテーブルと対応するEntity */

@Data
@Entity
public class JojoAppearanceShirasaka {

	/** 登場部ID */
	@Id
	@GeneratedValue
	@Column(name = "appearance_id")
	private int appearanceId;

	/** 登場部 */
	@Column(name = "appearance")
	@Size(max = 256)
	private String appearance;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：登場部ID */
	@Transient
	@OneToMany(targetEntity = JojoMainShirasaka.class, mappedBy = "jojoAppearanceShirasaka")
	@JoinColumn(name = "appearance_id", referencedColumnName = "appearance_id")
	private List<JojoMainShirasaka> JojoMainShirasaka;
}
