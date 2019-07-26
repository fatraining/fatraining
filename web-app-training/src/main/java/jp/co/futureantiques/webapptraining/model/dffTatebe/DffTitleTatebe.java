package jp.co.futureantiques.webapptraining.model.dffTatebe;

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
 * DFF_Title_Tatebeテーブルと対応するEntity
 * @author Tatebe
 *
 * */
@Data
@Entity
public class DffTitleTatebe {
	/** 作品名ID */
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	/** 作品名 */
	@Column(name = "title")
	@Size(max = 30)
	private String titleName;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name="update_date")
	private String updateDate;

	/** 外部キー設定:作品名ID */
	@Transient
	@OneToMany(targetEntity = DffMainTatebe.class, mappedBy = "titleName")
	@JoinColumn(name = "id",referencedColumnName = "title_id")
	private List<DffMainTatebe> dffMainTatebe;
}
