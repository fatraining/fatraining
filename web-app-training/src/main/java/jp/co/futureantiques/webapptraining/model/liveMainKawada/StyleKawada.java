package jp.co.futureantiques.webapptraining.model.liveMainKawada;

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
 * StyleKawadaテーブルと対応するエンティティ
 * @author future
 *
 */
@Data
@Entity
public class StyleKawada {

	/**スタイルID */
	@Id
	@GeneratedValue
	@Column(name = "style_id")
	private int styleId;

	/**スタイル */
	@Column(name = "style")
	@Size(max = 255)
	private String style;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：スタイルID */
	@Transient
	@OneToMany(targetEntity = LiveMainKawada.class, mappedBy = "StyleKawada")
	@JoinColumn(name = "style_id", referencedColumnName = "style_id")
	private List<LiveMainKawada> liveMainKawada;
}
