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
import jp.co.futureantiques.webapptraining.model.cdKanayama.CdMainKanayama;
import jp.co.futureantiques.webapptraining.model.cdKanayama.GenreKanayama;
import jp.co.futureantiques.webapptraining.model.form.cdKanayama.CdKanayamaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.cdKanayama.CdKanayamaInputForm;
import jp.co.futureantiques.webapptraining.model.form.cdKanayama.CdKanayamaSearchForm;
import jp.co.futureantiques.webapptraining.service.CdKanayamaService;




/**
 * cdKanayamaのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/cdkanayama")

public class CdKanayamaController {


	/** CDのサービス */
	private final CdKanayamaService cdKanayamaService;

	/**
	 * コンストラクタ
	 *
	 * @param CdKanayamaService cdKanayamaService
	 */
	@Autowired
	public CdKanayamaController(final CdKanayamaService cdKanayamaService) {
		this.cdKanayamaService = cdKanayamaService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<GenreKanayama> getListGenreKanayama() {
		return cdKanayamaService.getListGenreKanayama();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param CdKanayamaSearchForm cdKanayamaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchCd(@ModelAttribute final CdKanayamaSearchForm cdKanayamaSearchForm) {
		return "cdkanayama/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param CdKanayamaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchCd(final CdKanayamaSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<CdMainKanayama> cdMainKanayamaList = cdKanayamaService.getPageCd(form, pageable);
		if (cdMainKanayamaList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", cdMainKanayamaList);
			model.addAttribute("cdMainKanayamaList", cdMainKanayamaList.getContent());
			model.addAttribute("url", "search");
		}
		return "cdkanayama/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param CdKanayamaInputForm cdKanayamaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertCd(@ModelAttribute final CdKanayamaInputForm cdKanayamaInputForm) {
		return "cdkanayama/insert";
	}

	/**
	 * CdMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param CdKanayamaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertCd(@ModelAttribute @Validated final CdKanayamaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "cdkanayama/insert";
		}

		// データを登録する
		final CdMainKanayama cdMain = cdKanayamaService.insertCd(form);
		return "redirect:/cdkanayama?result=insert&id=" + cdMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param CdKanayamaInputForm cdKanayamaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateCd(@RequestParam(name = "id") final long id,
			@ModelAttribute final CdKanayamaInputForm cdKanayamaInputForm) {

		// IDをキーにCdMainテーブルを検索する
		CdMainKanayama cdMain = cdKanayamaService.getCd(id);

		// フォームにレコードの値をセットする
		cdKanayamaInputForm.initWithCdMain(cdMain);
		return "cdkanayama/update";
	}

	/**
	 * CdMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param CdKanayamaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateCd(@Validated final CdKanayamaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "cdkanayama/update";
		}

		// データを更新する
		CdMainKanayama cdMain = cdKanayamaService.updateCd(form);
		if (cdMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/cdkanayama?result=updatefailed";
		}
		return "redirect:/cdkanayama?result=update&id=" + cdMain.getId();
	}

	/**
	 * CdMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCd(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		cdKanayamaService.deleteCdById(id);
		return "redirect:/cdkanayama?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param CdKanayamaSearchForm form
	 * @param CdKanayamaDeleteForm cdKanayamaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompCd(final CdKanayamaSearchForm form,
			@ModelAttribute final CdKanayamaDeleteForm cdKanayamaDeleteForm, final Model model) {

		// CdMainテーブルから削除フラグが1のレコードを検索する
		final List<CdMainKanayama> cdMainKanayamaList = cdKanayamaService.getListCd(form);

		// Modelに検索結果を格納する
		model.addAttribute(cdMainKanayamaList);
		return "cdkanayama/deletecomp";
	}

	/**
	 * CdMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param CdKanayamaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompCd(@Validated final CdKanayamaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			CdKanayamaSearchForm cdKanayamaSearchForm = new CdKanayamaSearchForm();
			cdKanayamaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<CdMainKanayama> cdMainKanayamaList = cdKanayamaService.getListCd(cdKanayamaSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(cdMainKanayamaList);
			return "cdkanayama/deletecomp";
		}

		// データを完全削除する
		cdKanayamaService.deleteCdComp(form.getDeleteIds());
		return "redirect:/cdkanayama?result=deletecomp";
	}

}
