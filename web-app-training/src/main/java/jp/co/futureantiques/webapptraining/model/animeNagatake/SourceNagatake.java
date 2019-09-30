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

/**
 * SourceNagatakeテーブルに対応するEntity
 *
 * @author future
 * */

@Data
@Entity
public class SourceNagatake {

		/** 出典ID */
		@Id
		@GeneratedValue
		@Column(name = "source_id")
		private Integer sourceId;

		/** 出典 */
		@Column(name = "source")
		@Size(max = 256)
		private String source;

		/** 削除フラグ */
		@Column(name = "del_flg")
		private String delFlg;

		/** 登録日時 */
		@Column(name = "create_date")
		private Timestamp createDate;

		/** 更新日時 */
		@Column(name = "update_date")
		private Timestamp updateDate;

		/** 外部キー設定 :出典ID */
		@Transient
		@OneToMany(targetEntity=AnimeMainNagatake.class, mappedBy="sourceNagatake")
		@JoinColumn(name="source_id", referencedColumnName="source_id")
		private List<AnimeMainNagatake> animeMainNagatakeList;

	}
