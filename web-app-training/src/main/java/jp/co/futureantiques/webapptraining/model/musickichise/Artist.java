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

@Data
@Entity
public class Artist {

	/** アーティストID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** アーティスト名 */
	@Column(name = "artist")
	@Size(max = 255)
	private String artist;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/**
	 * 外部キー設定 アーティストID
	 */
	@Transient
	@OneToMany(targetEntity = MusicKichiseMain.class, mappedBy = "artist")
	@JoinColumn(name = "id", referencedColumnName = "artist_id")
	private List<MusicKichiseMain> musicKichiseMainList;

}
