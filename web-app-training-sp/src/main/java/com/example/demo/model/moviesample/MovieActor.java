package com.example.demo.model.moviesample;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * MovieActorテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class MovieActor {

	/** 俳優ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 名前 */
	@Column(name = "name")
	@Size(max = 255)
	private String name;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：俳優ID */
	
	@OneToMany(targetEntity = MovieMain.class, mappedBy = "movieActor")
	//@JoinColumn(name = "id", referencedColumnName = "actor_id")
	private List<MovieMain> movieMainList;
}