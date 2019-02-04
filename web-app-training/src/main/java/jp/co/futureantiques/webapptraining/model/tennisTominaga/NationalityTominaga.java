package jp.co.futureantiques.webapptraining.model.tennisTominaga;

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
 * Nationalityテーブルと対応するEntityクラス
 *
 * @author future
 */
@Data
@Entity //エンティティクラス
public class NationalityTominaga {

	/** 国籍ID */
	@Id //主キーを設定するアノテーション
	@GeneratedValue //自動で番号を増やしてるアノテーション？
	@Column(name = "nationality_id") //カラムの名前を指定するアノテーション
	private Integer nationalityId;

	/** 国籍 */
	@Column(name = "nationality")
	@Size(max = 256)
	private String nationality;

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
	//他でPlayerMainTominagaテーブルと対応させる？
	@Transient
	@OneToMany(targetEntity = PlayerMainTominaga.class, mappedBy = "nationality")
	@JoinColumn(name = "nationality_id", referencedColumnName = "nationality_id")
	private List<PlayerMainTominaga> playerMainTominagaList;

}