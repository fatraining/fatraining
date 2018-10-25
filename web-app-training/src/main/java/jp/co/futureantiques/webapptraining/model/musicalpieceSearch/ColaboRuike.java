package jp.co.futureantiques.webapptraining.model.musicalpieceSearch;

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
 * colabo_ruike テーブルと対応するエンティティ
 *
 * @author future
 */
@Data
@Entity
public class ColaboRuike {

	/** コラボアーティストID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int colaboId;

	/** コラボアーティスト名 */
	@Column(name = "colabo_name")
	@Size(max = 256)
	private String colaboName;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー： コラボアーティストID */
	@Transient
	@OneToMany(targetEntity = ArianaMainRuike.class, mappedBy = "colaboRuike")
	@JoinColumn(name = "id", referencedColumnName = "colabo_id")
	private List<ArianaMainRuike> arianaMainRuikeList;

}
