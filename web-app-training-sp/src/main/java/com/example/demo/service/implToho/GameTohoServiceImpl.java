package com.example.demo.service.implToho;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
//import java.awt.print.Pageable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.form.game.GameTohoInputForm;
import com.example.demo.model.form.game.GameTohoSearchForm;
import com.example.demo.model.game.GameEvaluationToho;
import com.example.demo.model.game.GameMainToho;
import com.example.demo.model.game.GenreToho;
import com.example.demo.repository.game.GameEvaluationTohoRepository;
import com.example.demo.repository.game.GameMainTohoRepository;
import com.example.demo.repository.game.GenreTohoRepository;
import com.example.demo.repository.specification.GameTohoSpecification;
import com.example.demo.service.GameTohoService;

/**
 * Gameのサービス実装クラス
 *
 * @author future
 */

@Service
public class GameTohoServiceImpl implements GameTohoService {
	/** GameMainTohoリポジトリ */
	private final GameMainTohoRepository gameMainTohoRepository;

	/** GenreTohoリポジトリ */
	private final GenreTohoRepository genreTohoRepository;

	/** GameEvaluationTohoリポジトリ */
	private final GameEvaluationTohoRepository gameEvaluationTohoRepository;

	/**
	 * コンストラクタ
	 *
	 * @param GameMainTohoRepository gameMainTohoRepository
	 * @param GenreTohoRepository genreTohoRepository
	 * @param GameEvaluationTohoRepository gameEvaluationRepository
	 */
	public GameTohoServiceImpl(GameMainTohoRepository gameMainTohoRepository, GenreTohoRepository genreTohoRepository,
			GameEvaluationTohoRepository gameEvaluationTohoRepository) {
		this.gameMainTohoRepository = gameMainTohoRepository;
		this.genreTohoRepository = genreTohoRepository;
		this.gameEvaluationTohoRepository = gameEvaluationTohoRepository;
	}

	@Override
	public List<GenreToho> getListGenreToho() {

		// GenreTohoテーブルのレコードをID順に取得する TO:DO
		return genreTohoRepository.findAll();
	}

	@Override
	public List<GameEvaluationToho> getListGameEvaluationToho() {

		// gameEvaluationTohoテーブルのレコードをID順に取得するTO:DO
		return gameEvaluationTohoRepository.findAll();
	}

	@Override
	public Page<GameMainToho> getPageGame(final GameTohoSearchForm form, final Pageable pageable) {

		// 検索条件を生成しGameMainTohoテーブルのレコードを取得する
		return gameMainTohoRepository.findAll(GameTohoSpecification.generateGameTohoSpecification(form), pageable);
	}

	@Override
	public List<GameMainToho> getListGame(final GameTohoSearchForm form) {

		// 検索条件を生成しGameMainTohoテーブルのレコードを取得する
		return gameMainTohoRepository.findAll(GameTohoSpecification.generateGameTohoSpecification(form));
	}

	@Override
	public GameMainToho getGame(final long id) {

		// GameMainTohoテーブルを主キー検索する
		GameMainToho gameMainToho = gameMainTohoRepository.findById(id).get();
		return gameMainToho;
	}

	@Override
	public GameMainToho insertGame(final GameTohoInputForm form) {

		// GameMainTohoテーブルに新規でデータを登録する
		final GameMainToho gameMainToho = form.convertToGameMainTohoForInsert();
		return gameMainTohoRepository.saveAndFlush(gameMainToho);
	}

	@Override
	public GameMainToho updateGame(final GameTohoInputForm form) {

		// 更新対象のレコードを取得する
		Optional<GameMainToho> gameMainTohoOp = gameMainTohoRepository.findById((long) form.getId());

		GameMainToho gameMainToho = gameMainTohoOp.get();
		if (gameMainToho != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(gameMainToho.getUpdateDate()))) {

				// チェックOKの場合、更新
				gameMainToho = form.convertToGameMainTohoForUpdate(gameMainToho);
				return gameMainTohoRepository.saveAndFlush(gameMainToho);
			}
		}
		return null;
	}

	@Override
	public void deleteGameById(final long id) {

		// 更新対象のレコードを取得する
		Optional<GameMainToho> gameMainTohoOp = gameMainTohoRepository.findById(id);
		GameMainToho gameMainToho = gameMainTohoOp.get();
		if (gameMainToho != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			gameMainTohoRepository.gameDelete(id);
		}
	}

	@Override
	public void deleteGameComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		gameMainTohoRepository.gameDeleteComp(ids);
	}
}
