package jp.co.futureantiques.webapptraining.model.novelOkudaira;

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
 * Writer_Okudairaテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class WriterOkudaira {

	/** 作者ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 作者 */
	@Column(name = "writer")
	@Size(max = 255)
	private String writer;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：作者ID */
	@Transient
	@OneToMany(targetEntity = NovelMainOkudaira.class, mappedBy = "writerOkudaira")
	@JoinColumn(name = "id", referencedColumnName = "writer_id")
	private List<NovelMainOkudaira> novelList;
}