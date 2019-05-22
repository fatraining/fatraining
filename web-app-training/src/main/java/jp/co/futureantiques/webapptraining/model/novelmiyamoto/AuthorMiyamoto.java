package jp.co.futureantiques.webapptraining.model.novelmiyamoto;

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
 * author_miyamotoテーブルと対応するEntity
 */
@Data
@Entity
public class AuthorMiyamoto {
	/** 作者ID */
	@Id
	@GeneratedValue
	@Column(name = "author_id")
	private int authorId;
	/** 作者名 */
	@Column(name = "author_name")
	@Size(max = 255)
	private String AuthorName;
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
	@OneToMany(targetEntity = BookMainMiyamoto.class, mappedBy = "authormiyamoto")
	@JoinColumn(name = "author_id", referencedColumnName = "author_id")
	private List<BookMainMiyamoto> novelMainList;
}