package jp.co.futureantiques.webapptraining.model.kpoptateishi;

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
 * Idolテーブルと対応するEntityクラス
 * コミットテスト1.7
 * コミットテスト1.7(競合)
 * @author future
 */
@Data
@Entity
public class Idol {

	/** 楽曲ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** アイドル */
	@Column(name = "idol")
	@Size(max = 255)
	private String idol;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：ジャンルID */
	@Transient
	@OneToMany(targetEntity = KpopMain.class, mappedBy = "idol")
	@JoinColumn(name = "id", referencedColumnName = "idol_id")
	private List<KpopMain> kpopMainList;
}