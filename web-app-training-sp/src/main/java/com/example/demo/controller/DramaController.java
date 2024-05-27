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
import com.example.demo.model.drama.CountryNakaniwa;
import com.example.demo.model.drama.DramaMainNakaniwa;
import com.example.demo.model.drama.GenreNakaniwa;
import com.example.demo.model.form.drama.DramaDeleteForm;
import com.example.demo.model.form.drama.DramaInputForm;
import com.example.demo.model.form.drama.DramaSearchForm;
import com.example.demo.service.DramaService;

/**
 * Dramaのコントローラークラス
 */
@Controller
@RequestMapping(value = "/drama")
public class DramaController {

	/** ドラマのサービス */
	private final DramaService dramaService;

	/**
	 * コンストラクタ
	 *
	 * @param DramaService dramaService
	 */
	public DramaController(final DramaService dramaService) {
		this.dramaService = dramaService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreNakaniwaEntityのリスト
	 */
	@ModelAttribute
	public List<GenreNakaniwa> getListGenreNakaniwa() {
		return dramaService.getListGenreNakaniwa();

	}

	/**
	 * 製作国エンティティのリストを取得する
	 *
	 * @return CountryNakaniwaEntityのリスト
	 */
	@ModelAttribute
	public List<CountryNakaniwa> getListCountryNakaniwa() {
		return dramaService.getListCountryNakaniwa();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param DramaSearchForm dramaSearchForm
	 * @return 検索画面のパス
	 */
	@GetMapping(value = "")
	public String showSearchDrama(@ModelAttribute final DramaSearchForm dramaSearchForm) {
		//表示対象のHTMLのパスを記述（templatesから下)
		return "drama/dramasearch";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param DramaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@PostMapping(value = "search")
	public String searchDrama(final DramaSearchForm form, final Model model, final Pageable pageable) {
		// 入力された検索条件を元にレコードを取得する
		final Page<DramaMainNakaniwa> dramaList = dramaService.getPageDrama(form, pageable);
		if (dramaList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", dramaList);
			model.addAttribute("dramaList", dramaList.getContent());
			model.addAttribute("url", "search");

		}
		return "drama/dramasearch";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param DramaInputForm dramaInputForm
	 * @return 追加画面のパス
	 */
	@GetMapping(value = "insert")
	public String showInsertDrama(@ModelAttribute final DramaInputForm dramaInputForm) {
		return "drama/dramainsert";
	}

	/**
	 * DramaMainNakaniwaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param DramaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "insert")
	public String insertDrama(@ModelAttribute @Validated final DramaInputForm form, final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "drama/dramainsert";
		}

		// データを登録する
		final DramaMainNakaniwa dramaMainNakaniwa = dramaService.insertDrama(form);
		return "redirect:/drama?result=insert&id=" + dramaMainNakaniwa.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param DramaInputForm dramaInputForm
	 * @return 更新画面のパス
	 */
	@GetMapping(value = "update")
	public String showUpdateDrama(@RequestParam(name = "id") final long id,
			@ModelAttribute final DramaInputForm dramaInputForm) {

		// IDをキーにDramaMainNakaniwaテーブルを検索する
		DramaMainNakaniwa dramaMainNakaniwa = dramaService.getDrama(id);

		// フォームにレコードの値をセットする
		dramaInputForm.initWithDramaMainNakaniwa(dramaMainNakaniwa);
		return "drama/dramaupdate";
	}

	/**
	 * DramaMainNakaniwaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param DramaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "update")
	public String updateDrama(@Validated final DramaInputForm form, final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "drama/dramaupdate";
		}

		// データを更新する
		DramaMainNakaniwa dramaMainNakaniwa = dramaService.updateDrama(form);
		if (dramaMainNakaniwa == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/drama?result=updatefailed";
		}
		return "redirect:/drama?result=update&id=" + dramaMainNakaniwa.getId();
	}

	/**
	 * DramaMainNakaniwaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@GetMapping("delete")
	public String deleteDrama(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		dramaService.deleteDramaById(id);
		return "redirect:/drama?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param DramaSearchForm form
	 * @param DramaDeleteForm dramaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@GetMapping(value = "deletecomp")
	public String showDeleteCompDrama(final DramaSearchForm form,
			@ModelAttribute final DramaDeleteForm dramaDeleteForm, final Model model) {

		// DramaMainNakaniwaテーブルから削除フラグが1のレコードを検索する
		final List<DramaMainNakaniwa> dramaList = dramaService.getListDrama(form);

		// Modelに検索結果を格納する
		model.addAttribute(dramaList);
		return "drama/dramadeletecomp";
	}

	/**
	 * DramaMainNakaniwaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param DramaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "deletecomp")
	public String deleteCompDrama(@Validated final DramaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			DramaSearchForm dramaSearchForm = new DramaSearchForm();
			dramaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<DramaMainNakaniwa> dramaList = dramaService.getListDrama(dramaSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(dramaList);
			return "drama/dramadeletecomp";
		}

		// データを完全削除する
		dramaService.deleteDramaComp(form.getDeleteIds());
		return "redirect:/drama?result=deletecomp";
	}

}
