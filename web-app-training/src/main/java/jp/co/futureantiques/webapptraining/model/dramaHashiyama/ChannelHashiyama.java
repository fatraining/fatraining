package jp.co.futureantiques.webapptraining.model.dramaHashiyama;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/**
 * ChannelHashiyamaテーブルと対応するEntity
 *
 * @author hashiyama
 */
@Data
@Entity

public class ChannelHashiyama {

	/** テレビ局ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 局名 */
	@Column(name = "name")
	private String name;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：テレビ局ID */
	@Transient
	@OneToMany(targetEntity = DramaMainHashiyama.class, mappedBy = "channelhashiyama")
	@JoinColumn(name = "id", referencedColumnName = "channel_id")
	private List<DramaMainHashiyama> dramaMainHashiyamaList;
}


