package com.example.demo.model.game;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;
/**
 * Genreテーブルと対応するEntityクラス
 * 
 * @author future
 */

@Data
@Entity
public class GenreToho {

	/** ジャンルID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** ジャンル */
	@Column(name = "genre")
	@Size(max = 255)
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

	/** 外部キー設定：ジャンルID */
	@OneToMany(targetEntity = GameMainToho.class, mappedBy = "genreToho")
	//@JoinColumn(name = "id", referencedColumnName = "genre_id")
	//@JoinColumn(name = "id")
	private List<GameMainToho> gameMainTohoList;
}
