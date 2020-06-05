package jp.co.futureantiques.webapptraining.model.comicYanai;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/** Pubcoテーブルに対応するエンティティクラス
 * @author yanai
 *
 */
@Entity
@Data
public class PubcoYanai {
	/**出版社ID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**出版社*/
	@Column(name = "pubco")
	private String pubco;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "createDate")
	private Timestamp createDate;

	/**更新日時*/
	@Column(name = "updateDate")
	private Timestamp updateDate;

	/** 外部キー設定：出版社ID */
	@Transient
	@OneToMany(targetEntity = ComicMainYanai.class, mappedBy = "pubco")
	@JoinColumn(name = "id", referencedColumnName = "pubco_id")
	private List<ComicMainYanai> comicMainYanaiList;
}
