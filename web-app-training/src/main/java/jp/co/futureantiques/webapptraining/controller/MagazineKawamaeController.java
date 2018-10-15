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

import jp.co.futureantiques.webapptraining.model.form.magazineKawamae.MagazineKawamaeDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.magazineKawamae.MagazineKawamaeInputForm;
import jp.co.futureantiques.webapptraining.model.form.magazineKawamae.MagazineKawamaeSearchForm;
import jp.co.futureantiques.webapptraining.model.magazinekawamae.MagazineGenreKawamae;
import jp.co.futureantiques.webapptraining.model.magazinekawamae.MagazineMainKawamae;
import jp.co.futureantiques.webapptraining.service.MagazineKawamaeService;

/**
 * Magazineのコントローラークラス
 *
 * @author kawamae wataru
 */
@Controller
@RequestMapping(value = "/magazine")
public class MagazineKawamaeController {

	/** 雑誌のサービス */
	private final MagazineKawamaeService magazineKawamaeService;

	/**
	 * コンストラクタ
	 *
	 * @param magazineKawamaeService magazineKawamaeService
	 */
	@Autowired
	public MagazineKawamaeController(final MagazineKawamaeService magazineKawamaeService) {
		this.magazineKawamaeService = magazineKawamaeService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<MagazineGenreKawamae> getListMagazineGenre() {
		return magazineKawamaeService.getListMagazineGenre();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param MagazineKawamaeSearchForm magazineKawamaeSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchMagazine(@ModelAttribute final MagazineKawamaeSearchForm magazineKawamaeSearchForm) {
		return "magazineKawamae/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param MagazineKawamaeSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchMagazine(final MagazineKawamaeSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<MagazineMainKawamae> magazineMainListKawamae = magazineKawamaeService.getPageMagazine(form, pageable);
		if (magazineMainListKawamae.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", magazineMainListKawamae);
			model.addAttribute("magazineList", magazineMainListKawamae.getContent());
			model.addAttribute("url", "search");
		}
		return "magazineKawamae/search";
	}


	/**
	 * 追加画面に遷移する
	 *
	 * @param MagazineKawamaeInputForm magazineInputForm
	 * @return 追加画面のパス
	 */

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertMagazine(@ModelAttribute final MagazineKawamaeInputForm magazineInputForm) {
		return "magazineKawamae/insert";
	}

	/**
	 * MagazineMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MagazineKawamaeInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertMagazine(@ModelAttribute @Validated final MagazineKawamaeInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			// 入力エラーがある場合自画面に戻る
			return "magazineKawamae/insert";
		}

		// データを登録する
		final MagazineMainKawamae magazineMainKawamae = magazineKawamaeService.insertMagazine(form);
		return "redirect:/magazine?result=insert&id=" + magazineMainKawamae.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param MagazineKawamaeInputForm magazineInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateMagazine(@RequestParam(name = "id") final long id,
			@ModelAttribute final MagazineKawamaeInputForm magazineInputForm) {

		// IDをキーにMagazineMainテーブルを検索する
		MagazineMainKawamae magazineMainKawamae = magazineKawamaeService.getMagazine(id);

		// フォームにレコードの値をセットする
		magazineInputForm.initWithMagazineMain(magazineMainKawamae);
		return "magazineKawamae/update";
	}

	/**
	 * MagazineMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param MagazineKawamaeInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMagazine(@Validated final MagazineKawamaeInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "magazineKawamae/update";
		}

		// データを更新する
		MagazineMainKawamae magazineMainKawamae = magazineKawamaeService.updateMagazine(form);
		if (magazineMainKawamae == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/magazine?result=updatefailed";
		}
		return "redirect:/magazine?result=update&id=" + magazineMainKawamae.getId();
	}

	/**
	 * MagazineMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteMagazine(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		magazineKawamaeService.deleteMagazineById(id);
		return "redirect:/magazine?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param MagazineKawamaeSearchForm form
	 * @param MagazineDeleteForm magazineDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */

	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompMagazine(final MagazineKawamaeSearchForm form,
			@ModelAttribute final MagazineKawamaeDeleteForm magazineDeleteForm, final Model model) {

		// MagazineMainテーブルから削除フラグが1のレコードを検索する
		final List<MagazineMainKawamae> magazineMainListKawamae = magazineKawamaeService.getListMagazine(form);

		// Modelに検索結果を格納する
		model.addAttribute(magazineMainListKawamae);
		return "magazineKawamae/deletecomp";
	}

	/**
	 * MagazineMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param MagazineDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompMagazine(@Validated final MagazineKawamaeDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			MagazineKawamaeSearchForm magazineSearchForm = new MagazineKawamaeSearchForm();
			magazineSearchForm.setIsDelete(1);
			final List<MagazineMainKawamae> magazineMainListKawamae = magazineKawamaeService.getListMagazine(magazineSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(magazineMainListKawamae);
			return "magazineKawamae/deletecomp";
		}

		// データを完全削除する
		magazineKawamaeService.deleteMagazineComp(form.getDeleteIds());
		return "redirect:/magazine?result=deletecomp";
	}


}
