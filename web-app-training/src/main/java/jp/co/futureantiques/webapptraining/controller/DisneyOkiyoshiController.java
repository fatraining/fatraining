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
import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.DisneyMainOkiyoshi;
import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.EreaOkiyoshi;
import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.GenreOkiyoshi;
import jp.co.futureantiques.webapptraining.model.form.disneyOkiyoshi.DisneyOkiyoshiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.disneyOkiyoshi.DisneyOkiyoshiInputForm;
import jp.co.futureantiques.webapptraining.model.form.disneyOkiyoshi.DisneyOkiyoshiSearchForm;
import jp.co.futureantiques.webapptraining.service.DisneyOkiyoshiService;

/**
 * Disneyのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/disneyokiyoshi")
public class DisneyOkiyoshiController {

	/** Disneyのサービス */
	private final DisneyOkiyoshiService disneyOkiyoshiService;

	/**
	 * コンストラクタ
	 *
	 * @param DisneyOkiyoshiService disneyService
	 */
	@Autowired
	public DisneyOkiyoshiController(final DisneyOkiyoshiService disneyOkiyoshiService) {
		this.disneyOkiyoshiService = disneyOkiyoshiService;
	}

	/**
	 * エリアエンティティのリストを取得する
	 *
	 * @return EreaEntityのリスト
	 */
	@ModelAttribute
	public List<EreaOkiyoshi> getListEreaOkiyoshi() {
		return disneyOkiyoshiService.getListEreaOkiyoshi();
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<GenreOkiyoshi> getListGenreOkiyoshi() {
		return disneyOkiyoshiService.getListGenreOkiyoshi();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param SearchForm SearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchDisneyOkiyoshi(@ModelAttribute final DisneyOkiyoshiSearchForm disneyOkiyoshiSearchForm) {
		return "disneyokiyoshi/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param DisneyOkiyoshiSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchDisneyOkiyoshi(final DisneyOkiyoshiSearchForm form, final Model model,
			final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<DisneyMainOkiyoshi> disneyList = disneyOkiyoshiService.getPageDisneyOkiyoshi(form, pageable);
		if (disneyList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", disneyList);
			model.addAttribute("disneyList", disneyList.getContent());
			model.addAttribute("url", "search");
		}
		return "disneyokiyoshi/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param DisneyOkiyoshiInputForm InputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertDisneyOkiyoshi(@ModelAttribute final DisneyOkiyoshiInputForm InputForm) {
		return "disneyokiyoshi/insert";
	}

	/**
	 * MovieMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param DisneyOkiyoshiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertDisneyOkiyoshi(@ModelAttribute @Validated final DisneyOkiyoshiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "disneyokiyoshi/insert";
		}

		// データを登録する
		final DisneyMainOkiyoshi disneyMainOkiyoshi = disneyOkiyoshiService.insertDisneyOkiyoshi(form);
		return "redirect:/disneyokiyoshi?result=insert&id=" + disneyMainOkiyoshi.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param InputForm InputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateDisneyOkiyoshi(@RequestParam(name = "id") final long id,
			@ModelAttribute final DisneyOkiyoshiInputForm DisneyOkiyoshiInputForm) {

		// IDをキーにDisneyMainテーブルを検索する
		DisneyMainOkiyoshi disneyMainOkiyoshi = disneyOkiyoshiService.getDisneyOkiyoshi(id);

		// フォームにレコードの値をセットする
		DisneyOkiyoshiInputForm.initWithDisneyMain(disneyMainOkiyoshi);
		return "disneyokiyoshi/update";
	}

	/**
	 * DisneyMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param DisneyOkiyoshiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateDisneyOkiyoshi(@Validated final DisneyOkiyoshiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "disneyokiyoshi/update";
		}

		// データを更新する
		DisneyMainOkiyoshi disneyMainOkiyoshi = disneyOkiyoshiService.updateDisneyOkiyoshi(form);
		if (disneyMainOkiyoshi == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/disneyokiyoshi?result=updatefailed";
		}
		return "redirect:/disneyokiyoshi?result=update&id=" + disneyMainOkiyoshi.getId();
	}

	/**
	 * DisneyMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteDisenyOkiyoshi(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		disneyOkiyoshiService.deleteDisneyOkiyoshiById(id);
		return "redirect:/disneyokiyoshi?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param DisneyOkiyoshiSearchForm form
	 * @param DeleteForm DeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompDisneyOkiyoshi(final DisneyOkiyoshiSearchForm form,
			@ModelAttribute final DisneyOkiyoshiDeleteForm DeleteForm, final Model model) {

		// DisneyMainテーブルから削除フラグが1のレコードを検索する
		final List<DisneyMainOkiyoshi> disneyList = disneyOkiyoshiService.getListDisneyOkiyoshi(form);

		// Modelに検索結果を格納する
		model.addAttribute(disneyList);
		return "disneyokiyoshi/deletecomp";
	}

	/**
	 * DisneyMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param DisneyDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompDisneyOkiyoshi(@Validated final DisneyOkiyoshiDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			DisneyOkiyoshiSearchForm disneyOkiyoshiSearchForm = new DisneyOkiyoshiSearchForm();
			disneyOkiyoshiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<DisneyMainOkiyoshi> disneyList = disneyOkiyoshiService
					.getListDisneyOkiyoshi(disneyOkiyoshiSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(disneyList);
			return "disneyokiyoshi/deletecomp";
		}

		// データを完全削除する
		disneyOkiyoshiService.deleteDisneyOkiyoshiComp(form.getDeleteIds());
		return "redirect:/disneyokiyoshi?result=deletecomp";
	}
}
