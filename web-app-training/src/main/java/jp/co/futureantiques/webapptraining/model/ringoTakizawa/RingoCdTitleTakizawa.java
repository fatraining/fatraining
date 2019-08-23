package jp.co.futureantiques.webapptraining.model.ringoTakizawa;

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
 * RingoCdTitleテーブルと対応するEntity
 *
 * @author Mai takizawa
 *
 */
@Data
@Entity
public class RingoCdTitleTakizawa {

	/** CD名ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** CD名　*/
	@Column(name = "cd_title")
	@Size(max = 256)
	private String cdTitle;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定 : CD名ID */
	@Transient
	@OneToMany(targetEntity = RingoMainTakizawa.class,mappedBy = "ringoCdTitleTakizawa")
	@JoinColumn(name = "id",referencedColumnName = "cd_title_id")
	private List<RingoMainTakizawa> ringoMainTakizawaList;

}
