
package jp.co.futureantiques.webapptraining.model.animeNagatake;

import java.sql.Timestamp;
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

/** GenreNagatakeテーブルに対応するEntity
 *
 * @author future
 * */

@Data
@Entity
public class GenreNagatake {

	/** ジャンルID */
	@Id
	@GeneratedValue
	@Column(name = "genre_id")
	private Integer genreId;

	/** ジャンル */
	@Column(name = "genre")
	@Size(max = 256)
	private String genre;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録削除 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定 :ジャンルID */
	@Transient
	@OneToMany(targetEntity=AnimeMainNagatake.class, mappedBy="genreNagatake")
	@JoinColumn(name="genre_id", referencedColumnName="genre_id")
	private List<AnimeMainNagatake> animeMainNagatakeList;

}