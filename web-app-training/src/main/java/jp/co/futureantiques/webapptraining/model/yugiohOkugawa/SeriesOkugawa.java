package jp.co.futureantiques.webapptraining.model.yugiohOkugawa;

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
 * Series_okugawaテーブルと対応するEntity
 * @author Okugawa
 *
 * */
@Data
@Entity
public class SeriesOkugawa {

	/** 作品ID */
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	/** 作品名 */
	@Column(name = "series_name")
	@Size(max = 30)
	private String seriesName;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name="update_date")
	private String updateDate;

	/** 外部キー設定:作品ID */
	@Transient
	@OneToMany(targetEntity = YugiohMainOkugawa.class, mappedBy = "seriesName")
	@JoinColumn(name = "id",referencedColumnName = "series_id")
	private List<YugiohMainOkugawa> yugiohMainOkugawa;
}
