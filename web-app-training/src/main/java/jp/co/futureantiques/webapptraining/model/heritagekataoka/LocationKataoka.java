package jp.co.futureantiques.webapptraining.model.heritagekataoka;
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
 * Locationテーブルと対応するエンティティ
 * @author MIKI KATAOKA
 *
 */
@Data
@Entity
public class LocationKataoka {

	/** 所在地ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 所在地 */
	@Column(name = "location")
	@Size(max = 50)
	private String location;//varcharはStringになる

//	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;
//
//	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

//	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：所在地ID */
	@Transient
	@OneToMany(targetEntity = HeritageMainKataoka.class,mappedBy = "location")
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<HeritageMainKataoka> HeritageMainList;

}
