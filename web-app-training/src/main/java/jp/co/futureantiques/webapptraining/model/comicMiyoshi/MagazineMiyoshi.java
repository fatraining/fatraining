package jp.co.futureantiques.webapptraining.model.comicMiyoshi;

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
 * MagazineMiyoshiテーブルと対応するEntityクラス
 * @author Miyoshi
 */
@Data
@Entity
public class MagazineMiyoshi {

	/** 連載雑誌ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 連載雑誌名*/
	@Column(name = "magazine")
	private String magazine;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時*/
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時*/
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：連載雑誌ID*/
	@Transient
	@OneToMany(targetEntity = ComicMainMiyoshi.class, mappedBy = "magazineMiyoshi")
	@JoinColumn(name = "id", referencedColumnName = "magazine_id")
	private List<ComicMainMiyoshi> comicMainMiyoshiList;


}
