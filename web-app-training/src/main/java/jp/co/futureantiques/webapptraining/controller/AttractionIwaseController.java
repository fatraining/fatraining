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
import jp.co.futureantiques.webapptraining.model.attractioniwase.AttractionMain;
import jp.co.futureantiques.webapptraining.model.attractioniwase.Themeparkiwase;
import jp.co.futureantiques.webapptraining.model.form.attractioniwase.AttractionIwaseDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.attractioniwase.AttractionIwaseInputForm;
import jp.co.futureantiques.webapptraining.model.form.attractioniwase.AttractionIwaseSearchForm;
import jp.co.futureantiques.webapptraining.service.AttractionIwaseService;
/**
 * AttractionIwase
 * のコントローラークラス
 *
 * @author future
 */

@Controller
@RequestMapping(value = "/attractioniwase")
public class AttractionIwaseController {

	/** アトラクションのサービス */
	private final AttractionIwaseService attractionIwaseService;

	/**
	 * コンストラクタ
	 *
	 * @param AttractionIwaseService attractionIwaseService
	 */
	@Autowired
	public AttractionIwaseController(final AttractionIwaseService attractionIwaseService) {
		this.attractionIwaseService = attractionIwaseService;
	}

	/**
	 * テーマパークエンティティのリストを取得する
	 *
	 * @return ThemeparkEntityのリスト
	 */
	@ModelAttribute
	public List<Themeparkiwase> getListThemepark() {
		return attractionIwaseService.getListThemepark();
	}


	/**
	 * 検索画面に遷移する
	 *
	 * @param AttractionIwaseSearchForm attractionIwaseSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchAttraction(@ModelAttribute final AttractionIwaseSearchForm attractionIwaseSearchForm) {
		return "attractionIwase/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param AttractionIwaseSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchAttraction(final AttractionIwaseSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<AttractionMain> attractionList = attractionIwaseService.getPageAttraction(form, pageable);
		if (attractionList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", attractionList);
			model.addAttribute("attractionList", attractionList.getContent());
			model.addAttribute("url", "search");
		}
		return "attractioniwase/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param AttractionIwaseInputForm attractionIwaseInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertAttraction(@ModelAttribute final AttractionIwaseInputForm attractionIwaseInputForm) {
		return "attractioniwase/insert";
	}

	/**
	 * MovieMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param AttractionIwaseInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertAttraction(@ModelAttribute @Validated final AttractionIwaseInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "attractioniwase/insert";
		}

		// データを登録する
		final AttractionMain attractionMain = attractionIwaseService.insertAttraction(form);
		return "redirect:/attractioniwase?result=insert&id=" + attractionMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param AttractionIwaseInputForm attractionIwaseInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateAttraction(@RequestParam(name = "id") final long id,
			@ModelAttribute final AttractionIwaseInputForm attractionIwaseInputForm) {

		// IDをキーにAttractionMainテーブルを検索する
		AttractionMain attractionMain = attractionIwaseService.getAttraction(id);

		// フォームにレコードの値をセットする
		attractionIwaseInputForm.initWithAttractionMain(attractionMain);
		return "attractioniwase/update";
	}

	/**
	 * AttractionMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param AttractionIwaseInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateAttraction(@Validated final AttractionIwaseInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "attractioniwase/update";
		}

		// データを更新する
		AttractionMain attractionMain = attractionIwaseService.updateAttraction(form);
		if (attractionMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/attractioniwase?result=updatefailed";
		}
		return "redirect:/attractioniwase?result=update&id=" + attractionMain.getId();
	}

	/**
	 * AttractionMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteAttraction(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		attractionIwaseService.deleteAttractionById(id);
		return "redirect:/attractioniwase?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param AttractionSampleSearchForm form
	 * @param AttractionSampleDeleteForm attractionIwaseDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompAttraction(final AttractionIwaseSearchForm form,
			@ModelAttribute final AttractionIwaseDeleteForm attractionIwaseDeleteForm, final Model model) {

		// AttractionMainテーブルから削除フラグが1のレコードを検索する
		final List<AttractionMain> attractionList = attractionIwaseService.getListAttraction(form);

		// Modelに検索結果を格納する
		model.addAttribute(attractionList);
		return "attractioniwase/deletecomp";
	}

	/**
	 * AttractionMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param AttractionIwaseDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompAttraction(@Validated final AttractionIwaseDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			AttractionIwaseSearchForm attractionIwaseSearchForm = new AttractionIwaseSearchForm();
			attractionIwaseSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<AttractionMain> attractionList = attractionIwaseService.getListAttraction(attractionIwaseSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(attractionList);
			return "attractioniwase/deletecomp";
		}

		// データを完全削除する
		attractionIwaseService.deleteAttractionComp(form.getDeleteIds());
		return "redirect:/attractioniwase?result=deletecomp";
	}
}
