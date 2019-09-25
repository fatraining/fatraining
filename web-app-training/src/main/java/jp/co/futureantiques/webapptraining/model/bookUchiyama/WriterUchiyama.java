package jp.co.futureantiques.webapptraining.model.bookUchiyama;

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
 * writer_uchiyamaテーブルと対応するEntity
 *
 * @author FutureAntiques
 */
@Data
@Entity
public class WriterUchiyama {

	/** 作家ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 作家名 */
	@Column(name = "name")
	private String name;

	/** 作家国籍 */
	@Column(name = "country")
	private String country;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：作家ID */
	@Transient
	@OneToMany(targetEntity = BookMainUchiyama.class, mappedBy = "writer")
	@JoinColumn(name = "id", referencedColumnName = "writer_id")
	private List<WriterUchiyama> writerUchiyamaList;
}
