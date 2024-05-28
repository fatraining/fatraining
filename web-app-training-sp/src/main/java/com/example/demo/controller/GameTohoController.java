package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.form.game.GameTohoDeleteForm;
import com.example.demo.model.form.game.GameTohoInputForm;
import com.example.demo.model.form.game.GameTohoSearchForm;
import com.example.demo.model.game.GameEvaluationToho;
import com.example.demo.model.game.GameMainToho;
import com.example.demo.model.game.GenreToho;
import com.example.demo.service.GameTohoService;





/**
 * GameSampleのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/game")

public class GameTohoController {
	/** 映画のサービス */
	private final GameTohoService gameTohoService;

	/**
	 * コンストラクタ
	 *
	 * @param GameTohoSearvice gameTohoService
	 */
	public GameTohoController(final GameTohoService gameTohoService) {
		this.gameTohoService = gameTohoService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<GenreToho> getListGenreToho() {
		return gameTohoService.getListGenreToho();
	}

	/**
	 * 評価エンティティのリストを取得する
	 *
	 * @return GamerEvaluationTohoEntityのリスト
	 */
	@ModelAttribute
	public List<GameEvaluationToho> getListGameEvaluationToho() {
		return gameTohoService.getListGameEvaluationToho();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param GameTohoSearchForm gameTohoSearchForm
	 * @return 検索画面のパス
	 */
	@GetMapping(value = "")
	public String showSearchGame(@ModelAttribute final GameTohoSearchForm gameTohoSearchForm) {
		return "game/gameSearch";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param GameTohoSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@PostMapping(value = "gameSearch")
	public String searchGame(final GameTohoSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<GameMainToho> gameMainTohoList = gameTohoService.getPageGame(form, pageable);
		if (gameMainTohoList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", gameMainTohoList);
			model.addAttribute("gameMainTohoList", gameMainTohoList.getContent());
			model.addAttribute("url", "gameSearch");
		}
		return "game/gameSearch";
	}
	
	/**
	 * 追加画面に遷移する
	 *
	 * @param GameTohoInputForm GameTohoInputForm
	 * @return 追加画面のパス
	 */
	@GetMapping(value = "gameInsert")
	public String showInsertGame(@ModelAttribute final GameTohoInputForm gameTohoInputForm) {
		return "game/gameInsert";
	}

	/**
	 * GameMainTohoテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param GameTohoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "gameInsert")
	public String insertGame(@ModelAttribute @Validated final GameTohoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "game/gameInsert";
		}

		// データを登録する
		final GameMainToho gameMainToho = gameTohoService.insertGame(form);
		return "redirect:/game?result=insert&id=" + gameMainToho.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param GameTohoInputForm gamTohoInputForm
	 * @return 更新画面のパス
	 */
	@GetMapping(value = "gameUpdate")
	public String showUpdateGame(@RequestParam(name = "id") final long id,
			@ModelAttribute final GameTohoInputForm gameTohoInputForm) {

		// IDをキーにGameMainテーブルを検索する
		GameMainToho gameMainToho = gameTohoService.getGame(id);

		// フォームにレコードの値をセットする
		gameTohoInputForm.initWithGameMainToho(gameMainToho);
		return "game/gameUpdate";
	}

	/**
	 * GameMainTohoテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param GameTohoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "gameUpdate")
	public String updateGame(@Validated final GameTohoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "game/gameUpdate";
		}

		// データを更新する
		GameMainToho gameMainToho = gameTohoService.updateGame(form);
		if (gameMainToho == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/game?result=updatefailed";
		}
		return "redirect:/game?result=update&id=" + gameMainToho.getId();
	}

	/**
	 * GameMainTohoテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@GetMapping("gameDelete")
	public String deleteGame(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		gameTohoService.deleteGameById(id);
		return "redirect:/game?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param GameTohoSearchForm form
	 * @param GameTohoDeleteForm gameTohoDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@GetMapping(value = "gameDeletecomp")
	public String showDeleteCompGame(final GameTohoSearchForm form,
			@ModelAttribute final GameTohoDeleteForm gameTohoDeleteForm, final Model model) {

		// GameMainTohoテーブルから削除フラグが1のレコードを検索する
		final List<GameMainToho> gameMainTohoList = gameTohoService.getListGame(form);

		// Modelに検索結果を格納する
		model.addAttribute(gameMainTohoList);
		return "game/gameDeletecomp";
	}

	/**
	 * GameMainTohoテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param GameTohoDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "gameDeletecomp")
	public String deleteGameComp(@Validated final GameTohoDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			GameTohoSearchForm gameTohoSearchForm = new GameTohoSearchForm();
			gameTohoSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<GameMainToho> gameMainTohoList = gameTohoService.getListGame(gameTohoSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(gameMainTohoList);
			return "game/gameDeletecomp";
		}

		// データを完全削除する
		gameTohoService.deleteGameComp(form.getDeleteIds());
		return "redirect:/game?result=deletecomp";
	}
}
