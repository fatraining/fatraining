package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.form.game.GameTohoInputForm;
import com.example.demo.model.form.game.GameTohoSearchForm;
import com.example.demo.model.game.GameEvaluationToho;
import com.example.demo.model.game.GameMainToho;
import com.example.demo.model.game.GenreToho;

/**
 * Gameのサービスインターフェース
 *
 * @author future
 */

public interface GameTohoService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreTohoEntityのリスト
	 */
	List<GenreToho> getListGenreToho();

	/**
	 * ゲーム評価のエンティティのリストを取得する
	 *
	 * @return GameEvaluationTohoEntityのリスト
	 */
	List<GameEvaluationToho> getListGameEvaluationToho();

	/**
	 * 検索条件を元にGameMainTohoのレコードのリストを取得する(Paging)
	 *
	 * @param GameTohoSearchForm form
	 * @param Pageable pageable
	 * @return GameMainTohoのリスト
	 */
	Page<GameMainToho> getPageGame(final GameTohoSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にGameMainTohoのレコードのリストを取得する
	 *
	 * @param GameTohoSearchForm form
	 * @return GameMainTohoのリスト
	 */
	List<GameMainToho> getListGame(final GameTohoSearchForm form);

	/**
	 * IDをキーにGameMainTohoのレコードを取得する
	 *
	 * @param long id
	 * @return GameMainTohoのレコード
	 */
	GameMainToho getGame(final long id);

	/**
	 * GameMainTohoにレコードを新規登録する
	 *
	 * @param GameTohoInputForm form
	 * @return GameMainToho
	 */
	GameMainToho insertGame(final GameTohoInputForm form);

	/**
	 * GameMainTohoのレコードを更新する
	 *
	 * @param GameTohoInputForm form
	 * @return GameMainToho
	 */
	GameMainToho updateGame(final GameTohoInputForm form);

	/**
	 * GameMainTohoのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteGameById(final long id);

	/**
	 * GameMainTohoのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteGameComp(final ArrayList<Long> ids);

}
