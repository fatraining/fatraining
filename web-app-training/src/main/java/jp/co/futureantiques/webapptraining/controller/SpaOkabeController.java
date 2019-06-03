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
import jp.co.futureantiques.webapptraining.model.form.spaOkabe.SpaOkabeDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.spaOkabe.SpaOkabeInputForm;
import jp.co.futureantiques.webapptraining.model.form.spaOkabe.SpaOkabeSearchForm;
import jp.co.futureantiques.webapptraining.model.spaOkabe.AreaOkabe;
import jp.co.futureantiques.webapptraining.model.spaOkabe.QualityOkabe;
import jp.co.futureantiques.webapptraining.model.spaOkabe.SpaMainOkabe;
import jp.co.futureantiques.webapptraining.service.SpaOkabeService;

/**
 * SpaOkabeのコントローラークラス
 *
 * @author SEIYA OKABE
 */
@Controller
@RequestMapping(value = "/spaOkabe")

public class SpaOkabeController {

	/** 温泉地のサービス */
	private final SpaOkabeService spaOkabeService;

	/**
	 * コンストラクタ
	 *
	 * @param SpaOkabeService spaOkabeService
	 */
	@Autowired
	public SpaOkabeController(final SpaOkabeService spaOkabeService) {
		this.spaOkabeService = spaOkabeService;
	}

	/**
	 * 都道府県エンティティのリストを取得する
	 *
	 * @return AreaOkabeEntityのリスト
	 */
	@ModelAttribute
	public List<AreaOkabe> getListAreaOkabe() {
		return spaOkabeService.getListAreaOkabe();
	}

	/**
	 * 泉質エンティティのリストを取得する
	 *
	 * @return QualityOkabeEntityのリスト
	 */
	@ModelAttribute
	public List<QualityOkabe> getListQualityOkabe() {
		return spaOkabeService.getListQualityOkabe();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param SpaOkabeSearchForm spaOkabeSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchSpaOkabe(@ModelAttribute final SpaOkabeSearchForm spaOkabeSearchForm) {
		return "spaOkabe/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param SpaOkabeSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchSpaOkabe(final SpaOkabeSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<SpaMainOkabe> spaOkabeList = spaOkabeService.getPageSpa(form, pageable);
		if (spaOkabeList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", spaOkabeList);
			model.addAttribute("spaOkabeList", spaOkabeList.getContent());
			model.addAttribute("url", "search");
		}
		return "spaOkabe/search";

	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param SpaOkabeInputForm spaOkabeInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertSpa(@ModelAttribute final SpaOkabeInputForm spaOkabeInputForm) {
		return "spaOkabe/insert";
	}

	/**
	 * SpaMainOkabeテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param SpaOkabeInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertSpa(@ModelAttribute @Validated final SpaOkabeInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "spaOkabe/insert";
		}

		// データを登録する
		final SpaMainOkabe spaMainOkabe = spaOkabeService.insertSpa(form);
		return "redirect:/spaOkabe?result=insert&id=" + spaMainOkabe.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param SpaOkabeInputForm movieSampleInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateSpa(@RequestParam(name = "id") final long id,
			@ModelAttribute final SpaOkabeInputForm spaOkabeInputForm) {

		// IDをキーにMovieMainテーブルを検索する
		SpaMainOkabe spaMainOkabe = spaOkabeService.getSpaMainOkabe(id);

		// フォームにレコードの値をセットする
		spaOkabeInputForm.initWithSpaMainOkabe(spaMainOkabe);
		return "spaOkabe/update";
	}

	/**
	 * SpaMainOkabeテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param SpaOkabeInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateSpa(@Validated final SpaOkabeInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "spaOkabe/update";
		}

		// データを更新する
		SpaMainOkabe spaMainOkabe = spaOkabeService.updateSpa(form);
		if (spaMainOkabe == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/spaOkabe?result=updatefailed";
		}
		return "redirect:/spaOkabe?result=update&id=" + spaMainOkabe.getId();
	}

	/**
	 * SpaMainOkabeテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteSpa(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		spaOkabeService.deleteSpaById(id);
		return "redirect:/spaOkabe?result=delete&id" + id;
	}
	/**
	 * 完全削除画面に遷移する
	 *
	 * @param SpaOkabeSearchForm form
	 * @param SpaOkabeDeleteForm spaOkabeDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompSpa(final SpaOkabeSearchForm form,
			@ModelAttribute final SpaOkabeDeleteForm spaOkabeDeleteForm, final Model model) {

		// MovieMainテーブルから削除フラグが1のレコードを検索する
		final List<SpaMainOkabe> spaOkabeList = spaOkabeService.getListSpaMainOkabe(form);

		// Modelに検索結果を格納する
		model.addAttribute(spaOkabeList);
		return "spaOkabe/deletecomp";
	}
	/**
	 * SpaMainOkabeテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param SpaOkabeDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompSpa(@Validated final SpaOkabeDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			SpaOkabeSearchForm spaOkabeSearchForm = new SpaOkabeSearchForm();
			spaOkabeSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<SpaMainOkabe> spaOkabeList = spaOkabeService.getListSpaMainOkabe(spaOkabeSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(spaOkabeList);
			return "spaOkabe/deletecomp";
		}

		// データを完全削除する
		spaOkabeService.deleteSpaComp(form.getDeleteIds());
		return "redirect:/spaOkabe?result=deletecomp";
	}
}
