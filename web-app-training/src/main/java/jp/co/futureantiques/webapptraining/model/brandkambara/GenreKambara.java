package jp.co.futureantiques.webapptraining.model.brandkambara;

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
	 * GenreKambaraテーブルと対応するEntity
	 *
	 * @author Yuki Kambara
	 *
	 */
	@Data
	@Entity
	public class GenreKambara {

		/** ジャンルID */
		@Id
		@GeneratedValue
		@Column(name = "genre_id")
		private int id;

		/** ジャンル */
		@Column(name = "genre")
		@Size(max = 256)
		private String genre;

		/** 削除フラグ */
		@Column(name = "del_flg")
		private String delFlg;

		/** 登録日時 */
		@Column(name = "create_date")
		private String createDate;

		/** 更新日時 */
		@Column(name = "update_date")
		private String updateDate;

		@Transient
		///一対多関連定義
		@OneToMany(targetEntity = BrandMainKambara.class,mappedBy = "brandGenreKambara")
		@JoinColumn(name = "genre_id",referencedColumnName = "genre")
		private List<BrandMainKambara> brandMainKambaraList;

}
