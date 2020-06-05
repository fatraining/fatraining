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

/** Genreテーブルに対応するエンティティクラス
 * @author yanai
 *
 */
@Data
@Entity
public class GenreYanai {
	/**ジャンルID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**ジャンル*/
	@Column(name = "genre")
	private String genre;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "createDate")
	private Timestamp createDate;

	/**更新日時*/
	@Column(name = "updateDate")
	private Timestamp updateDate;

	/** 外部キー設定：ジャンルID */
	@Transient
	@OneToMany(targetEntity = ComicMainYanai.class, mappedBy = "genre")
	@JoinColumn(name = "id", referencedColumnName = "genre_id")
	private List<ComicMainYanai> comicMainYanaiList;

}
