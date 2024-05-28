package com.example.demo.repository.game;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.game.GameMainToho;

/**
 *GameMainTohoリポジトリのインターフェース
 *
 * @author future
 */
public interface GameMainTohoRepository extends JpaRepository<GameMainToho, Long>, JpaSpecificationExecutor<GameMainToho> {

	/**
	 * 対象のレコードの削除フラグを1にする
	 *
	 * @param long id
	 */
	@Transactional
	@Modifying
	@Query("UPDATE GameMainToho SET delFlg = '1' WHERE id = :id")
	void gameDelete(@Param("id") final long id);

	/**
	 * 対象のレコードを削除する
	 * @param ArrayList<Long> ids
	 */
	@Transactional
	@Modifying
	@Query("DELETE FROM GameMainToho WHERE id IN(:ids)")
	void gameDeleteComp(@Param("ids") final ArrayList<Long> ids);
}
