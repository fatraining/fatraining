package jp.co.futureantiques.webapptraining.model.musickichise;

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
 * Janruテーブルと対応するEntityクラス
 * @author future
 *
 */
@Data
@Entity
public class Janru {

	/** ジャンルのID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "janru")
	@Size(max = 255)
	private String janru;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日付 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日付 */
	@Column(name = "update_date")
	private String updateDate;

	@Transient
	@OneToMany(targetEntity = MusicKichiseMain.class, mappedBy = "janru")
	@JoinColumn(name = "id", referencedColumnName = "janru_id")
	private List<MusicKichiseMain> MusicKichiseMainList;
}
