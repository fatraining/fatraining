package jp.co.futureantiques.webapptraining.model.boowyWaki;

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
 * Songwriterテーブルと対応するEntityクラス
 *
 * @author future
 */
@Data
@Entity
public class SongwriterWaki {
	/** 作詞者ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 作詞者 */
	@Column(name = "songwriter")
	@Size(max = 20)
	private String songwriter;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：作詞者ID */
	@Transient
	@OneToMany(targetEntity = BoowyMainWaki.class, mappedBy = "songwriter")
	@JoinColumn(name = "id", referencedColumnName = "songwriter_id")
	private List<BoowyMainWaki> boowyMainWakiList;

}
