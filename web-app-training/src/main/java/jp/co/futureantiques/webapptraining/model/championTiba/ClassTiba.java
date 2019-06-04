package jp.co.futureantiques.webapptraining.model.championTiba;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/** Classテーブルと対応するEntity */

@Data
@Entity
public class ClassTiba {

	/** チャンピオンID */
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	/** 階級 */
	@Column(name="class")
	private String classtiba;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name="update_date")
	private String updateDate;

	/** 外部キー設定：階級ID */
	@Transient
	@OneToMany(targetEntity=ChampionMainTiba.class, mappedBy="classtiba")
	@JoinColumn(name="id", referencedColumnName="class_id")
	private List<ChampionMainTiba> championMainTibaList;
	}
