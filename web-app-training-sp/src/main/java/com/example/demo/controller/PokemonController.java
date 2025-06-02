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
import com.example.demo.model.form.pokemon.PokemonDeleteForm;
import com.example.demo.model.form.pokemon.PokemonInputForm;
import com.example.demo.model.form.pokemon.PokemonSearchForm;
import com.example.demo.model.pokemon.AppearanceSatoyoshi;
import com.example.demo.model.pokemon.PokemonMainSatoyoshi;
import com.example.demo.model.pokemon.Type1Satoyoshi;
import com.example.demo.model.pokemon.Type2Satoyoshi;
import com.example.demo.service.PokemonService;

/**
 * Pokemonのコントローラークラス
 *
 * @author satoyoshi
 */
@Controller
@RequestMapping(value = "/pokemon")
public class PokemonController {

	/** ポケモンのサービス */
	private final PokemonService pokemonService;

	/**
	 * コンストラクタ
	 *
	 * @param PokemonService pokemonService
	 */
	public PokemonController(final PokemonService pokemonService) {
		this.pokemonService = pokemonService;
	}

	/**
	 * タイプ1エンティティのリストを取得する
	 *
	 * @return Type1Entityのリスト
	 */
	@ModelAttribute
	public List<Type1Satoyoshi> getListType1() {
		return pokemonService.getListType1();
	}
	
	/**
	 * タイプ2エンティティのリストを取得する
	 *
	 * @return Type2Entityのリスト
	 */
	@ModelAttribute
	public List<Type2Satoyoshi> getListType2() {
		return pokemonService.getListType2();
	}

	/**
	 * 初登場シリーズエンティティのリストを取得する
	 *
	 * @return AppearanceEntityのリスト
	 */
	@ModelAttribute
	public List<AppearanceSatoyoshi> getListAppearance() {
		return pokemonService.getListAppearance();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param PokemonSearchForm pokemonSearchForm
	 * @return 検索画面のパス
	 */
	@GetMapping(value = "")
	public String showSearchPokemon(@ModelAttribute final PokemonSearchForm pokemonSearchForm) {
		return "pokemon/pokemonSearch";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param PokemonSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@PostMapping(value = "pokemonSearch")
	public String searchPokemon(final PokemonSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<PokemonMainSatoyoshi> pokemonList = pokemonService.getPagePokemon(form, pageable);
		if (pokemonList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", pokemonList);
			model.addAttribute("pokemonList", pokemonList.getContent());
			model.addAttribute("url", "pokemonSearch");
		}
		return "pokemon/pokemonSearch";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param PokemnoInputForm pokemonInputForm
	 * @return 追加画面のパス
	 */
	@GetMapping(value = "pokemonInsert")
	public String showInsertPokemon(@ModelAttribute final PokemonInputForm pokemonInputForm) {
		return "pokemon/pokemonInsert";
	}

	/**
	 * PokemonMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param pokemonInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "pokemonInsert")
	public String insertpokemon(@ModelAttribute @Validated final PokemonInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "pokemon/pokemonInsert";
		}

		// データを登録する
		final PokemonMainSatoyoshi pokemonMain = pokemonService.insertPokemon(form);
		return "redirect:/pokemon?result=insert&pokemonId=" + pokemonMain.getPokemonId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param PokemonInputForm pokemonInputForm
	 * @return 更新画面のパス
	 */
	@GetMapping(value = "pokemonUpdate")
	public String showUpdatePokemon(@RequestParam(name = "id") final long pokemonId,
			@ModelAttribute final PokemonInputForm pokemonInputForm) {

		// IDをキーにPokemonMainテーブルを検索する
		PokemonMainSatoyoshi pokemonMain = pokemonService.getPokemon(pokemonId);

		// フォームにレコードの値をセットする
		pokemonInputForm.initWithPokemonMain(pokemonMain);
		return "pokemon/pokemonUpdate";
	}

	/**
	 * PokemonMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param PokemonInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "pokemonUpdate")
	public String updatePokemon(@Validated final PokemonInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "pokemon/pokemonUpdate";
		}

		// データを更新する
		PokemonMainSatoyoshi pokemonMain = pokemonService.updatePokemon(form);
		if (pokemonMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/pokemon?result=updatefailed";
		}
		//updateのparam.idで+以降の値を受け取る
		return "redirect:/pokemon?result=update&id=" + pokemonMain.getPokemonId();
	}

	/**
	 * PokemonMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@GetMapping("pokemonDelete")
	public String deletePokemon(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		pokemonService.deletePokemonBypokemonId(id);
		return "redirect:/pokemon?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param PokemonSearchForm form
	 * @param PokemonDeleteForm pokemonDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@GetMapping(value = "pokemonDeletecomp")
	public String showDeleteCompPokemon(final PokemonSearchForm form,
			@ModelAttribute final PokemonDeleteForm pokemonDeleteForm, final Model model) {

		// PokemonMainテーブルから削除フラグが1のレコードを検索する
		final List<PokemonMainSatoyoshi> pokemonList = pokemonService.getListPokemon(form);

		// Modelに検索結果を格納する
		model.addAttribute(pokemonList);
		return "pokemon/pokemonDeletecomp";
	}

	/**
	 * PokemonMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param PokemonDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "pokemonDeletecomp")
	public String deleteCompPokemon(@Validated final PokemonDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			PokemonSearchForm pokemonSearchForm = new PokemonSearchForm();
			pokemonSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<PokemonMainSatoyoshi> pokemonList = pokemonService.getListPokemon(pokemonSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(pokemonList);
			return "pokemon/pokemonDeletecomp";
		}

		// データを完全削除する
		pokemonService.deletePokemonComp(form.getDeleteIds());
		return "redirect:/pokemon?result=deletecomp";
	}
}
