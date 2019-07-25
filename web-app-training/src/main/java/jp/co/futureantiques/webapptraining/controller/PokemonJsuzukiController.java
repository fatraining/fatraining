package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.pokemonJsuzuki.PokemonJsuzukiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.pokemonJsuzuki.PokemonJsuzukiInputForm;
import jp.co.futureantiques.webapptraining.model.form.pokemonJsuzuki.PokemonJsuzukiSearchForm;
import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.AreaIdJsuzuki;
import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.PokemonMainJsuzuki;
import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.TypeIdJsuzuki;
import jp.co.futureantiques.webapptraining.service.PokemonJsuzukiService;

@Controller
@RequestMapping(value = "/pokemonJsuzuki")
public class PokemonJsuzukiController {
	/**ポケモンのサービス */
	private final PokemonJsuzukiService pokemonJsuzukiService;

	/**コンストラクタ
	 *
	 * @param PokemonJsuzukiService pokemonJsuzukiService
	 */
	@Autowired
	public PokemonJsuzukiController(final PokemonJsuzukiService pokemonJsuzukiService) {
		this.pokemonJsuzukiService = pokemonJsuzukiService;
	}

	/**
	 * タイプエンティティのリストを取得する
	 *
	 * @return TypeIdEntityのリスト
	 */
	@ModelAttribute
	public List<TypeIdJsuzuki> getListTypeId(){
		return pokemonJsuzukiService.getListTypeId();
	}

	/**
	 * 登場地方エンティティのリストを取得する
	 *
	 * @return AreaIdEntityのリスト
	 */
	@ModelAttribute
	public List<AreaIdJsuzuki> getListAreaId(){
		return pokemonJsuzukiService.getListAreaId();
	}

	/**
	 * 検索画面に遷移する
	 *
	 *@param pokemonJsuzukiSearchForm pokemonJsuzukiSearchFrom
	 *@param 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearch(@ModelAttribute final PokemonJsuzukiSearchForm pokemonJsuzukiSearchForm) {
		return "pokemonJsuzuki/search";
	}

	/**
	 *検索結果を取得して検索画面に遷移する
	 *
	 *@param PokemonJsuzukiSearchForm
	 *@param Model model
	 *@param Pageable pageable
	 *@param 検索画面のパス
	 */
	@RequestMapping(value = "search",method = RequestMethod.POST)
	public String searchPokemon(final PokemonJsuzukiSearchForm form,final Model model,final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<PokemonMainJsuzuki>pokemonJsuzukiList = pokemonJsuzukiService.getPagePokemon(form, pageable);
		if(pokemonJsuzukiList.getTotalElements()!= 0) {

			//検索結果がある場合はModelに結果をセットする
			model.addAttribute("page",pokemonJsuzukiList);
			model.addAttribute("pokemonJsuzukiList",pokemonJsuzukiList.getContent());
			model.addAttribute("url","search");
		}
		return  "pokemonJsuzuki/search";
	}

	/**
	 *
	 * @param PokemonJsuzukiInputForm pokemonJsuzukiInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert",method = RequestMethod.GET)
	public String showInsertPokemon(@ModelAttribute final PokemonJsuzukiInputForm pokemonJsuzukiInputForm) {
		return "pokemonJsuzuki/insert";
	}

	/**
	 *
	 * @param PokemonJsuzukiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合は検索画面のパス
	 */
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	public String insertPokemon(@ModelAttribute @Validated final PokemonJsuzukiInputForm form,
			final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "pokemonJsuzuki/insert";
		}

		//データを登録する
		final PokemonMainJsuzuki pokemonMainJsuzuki = pokemonJsuzukiService.insertPokemon(form);
		return "redirect:/pokemonJsuzuki?result=insert&id=" + pokemonMainJsuzuki.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param PokemonJsuzukiInputForm pokemonJsuzukiInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update",method = RequestMethod.GET)
	public String showUpdatePokemon(@RequestParam(name = "id")final long id,
			@ModelAttribute final PokemonJsuzukiInputForm pokemonJsuzukiInputForm) {

		//IDをキーにPokemonMainJsuzukiテーブルを検索する
		PokemonMainJsuzuki pokemonMainJsuzuki = pokemonJsuzukiService.getPokemon(id);

		//フォームにレコードの値をセットする
		pokemonJsuzukiInputForm.initWithPokemonMainJsuzuki(pokemonMainJsuzuki);
		return "pokemonJsuzuki/update";
	}

	/**
	 * PokemonMainJsuzukiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param PokemonJsuzukiInputFormform
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public String updatePokemon(@Validated final PokemonJsuzukiInputForm form,
			final BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "pokemonJsuzuki/update";
		}

		//データを更新する
		PokemonMainJsuzuki pokemonMainJsuzuki = pokemonJsuzukiService.updatePokemon(form);
		if(pokemonMainJsuzuki == null) {

			//更新が失敗した場合、検索画面にメッセージを表示をする
			return "redirect:/pokemonJsuzuki?result=updatefailed";
		}
		return"redirect:/pokemonJsuzuki?result=update&id=" + pokemonMainJsuzuki.getId();
	}

	/**PokemonMainJsuzukiテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public String deletePokemon(@RequestParam(name="id") final long id){

		//IDをキーにレコードを論理削除する
		pokemonJsuzukiService.deletePokemonById(id);
		return"redirect:/pokemonJsuzuki?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param PokemonJsuzukiSearchForm form
	 * @param PokemonJsuzukiDeleteForm pokemonJsuzukiDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp",method = RequestMethod.GET)
	public String showDeleteCompPokemon(final PokemonJsuzukiSearchForm form,
			@ModelAttribute final PokemonJsuzukiDeleteForm pokemonJsuzukiDeleteForm,final Model model) {

		//PokemonJsuzukiテーブルから削除フラグが1のレコードを検索する
		final List<PokemonMainJsuzuki> pokemonList = pokemonJsuzukiService.getListPokemon(form);

		//Modelに検索結果を格納する
		model.addAttribute(pokemonList);
		return "pokemonJsuzuki/deletecomp";
	}

	/**
	 * PokemonMainJsuzukiテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param PokemonJsuzukiDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */

	@RequestMapping(value = "deletecomp",method = RequestMethod.POST)
	public String deleteCompPokemon(@Validated final PokemonJsuzukiDeleteForm form,
			final BindingResult bindingResult,final Model model) {
		if(bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			PokemonJsuzukiSearchForm pokemonJsuzukiSearchForm = new PokemonJsuzukiSearchForm();
			pokemonJsuzukiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<PokemonMainJsuzuki> pokemonList = pokemonJsuzukiService.getListPokemon(pokemonJsuzukiSearchForm);

			//Modelに検索結果を格納する
			model.addAttribute(pokemonList);
			return "pokemonJsuzuki/deletecomp";
		}

		//データを完全削除する
		pokemonJsuzukiService.deletePokemonComp(form.getDeleteIds());
		return "redirect:/pokemonJsuzuki?result=deletecomp";
	}

}
