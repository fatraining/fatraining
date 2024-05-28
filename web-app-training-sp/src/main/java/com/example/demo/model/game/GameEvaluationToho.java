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
 * MovieActorテーブルと対応するEntity
 *
 * @author future
 */

@Data
@Entity
public class GameEvaluationToho {

	/** 評価ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 評価 */
	@Column(name = "evaluation")
	@Size(max = 256)
	private String evaluation;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：評価ID */
	
	@OneToMany(targetEntity = GameMainToho.class, mappedBy = "gameEvaluationToho")
	//@JoinColumn(name = "id", referencedColumnName = "evaluation_id")
	private List<GameMainToho> gameMainTohoList;
}
