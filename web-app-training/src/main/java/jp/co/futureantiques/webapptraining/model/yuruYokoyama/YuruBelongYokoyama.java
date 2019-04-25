package jp.co.futureantiques.webapptraining.model.yuruYokoyama;

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
 * Genreテーブルと対応するEntityクラス
 *
 * @author future
 */
@Data
@Entity
public class YuruBelongYokoyama {

	/** 所属ID */
	@Id
	@GeneratedValue
	@Column(name = "belong_id")
	private int belongId;

	/** 所属 */
	@Column(name = "belong")
	@Size(max = 255)
	private String belong;

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
	@OneToMany(targetEntity = YuruDataYokoyama.class, mappedBy = "yuruBelongYokoyama")
	@JoinColumn(name = "belong_id", referencedColumnName = "belong_id")
	private List<YuruDataYokoyama> yuruDataYokoyamaList;
}