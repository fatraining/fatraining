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
import jp.co.futureantiques.webapptraining.model.form.residentsSato.ResidentsSatoDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.residentsSato.ResidentsSatoInputForm;
import jp.co.futureantiques.webapptraining.model.form.residentsSato.ResidentsSatoSearchForm;
import jp.co.futureantiques.webapptraining.model.residentsSato.AnimalSato;
import jp.co.futureantiques.webapptraining.model.residentsSato.ResidentsMainSato;
import jp.co.futureantiques.webapptraining.model.residentsSato.SexSato;
import jp.co.futureantiques.webapptraining.service.ResidentsSatoService;

/**
 * ResidentsSatoのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/residentsSato")
public class ResidentsSatoController {

	/** 住民のサービス */
	private final ResidentsSatoService residentsSatoService;

	/**
	 * コンストラクタ
	 *
	 * @param ResidentsSatoService residentsSatoService
	 */
	@Autowired
	public ResidentsSatoController(final ResidentsSatoService residentsSatoService) {
		this.residentsSatoService = residentsSatoService;
	}

	/**
	 * 動物エンティティのリストを取得する
	 *
	 * @return AnimalEntityのリスト
	 */
	@ModelAttribute
	public List<AnimalSato> getListAnimalSato() {
		return residentsSatoService.getListAnimalSato();
	}

	/**
	 * 性別エンティティのリストを取得する
	 *
	 * @return SexSatoEntityのリスト
	 */
	@ModelAttribute
	public List<SexSato> getListSexSato() {
		return residentsSatoService.getListSexSato();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param ResidentsSatoSearchForm residentsSatoSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchResidents(@ModelAttribute final ResidentsSatoSearchForm residentsSatoSearchForm) {
		return "residentsSato/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param ResidentsSatoSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchResidents(@Validated final ResidentsSatoSearchForm form, BindingResult bindingResult,final Model model, final Pageable pageable) {

		//文字数超えた時
		if (bindingResult.hasFieldErrors()) {
			return "residentsSato/search";

		}

		// 入力された検索条件を元にレコードを取得する
		final Page<ResidentsMainSato> residentsList = residentsSatoService.getPageResidentsSato(form, pageable);
		if (residentsList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", residentsList);
			model.addAttribute("residentsList", residentsList.getContent());
			model.addAttribute("url", "search");
		}
		return "residentsSato/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param ResidentsSatoInputForm residentsSatoInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertResidentsSato(@ModelAttribute final ResidentsSatoInputForm residentsSatoInputForm) {
		return "residentsSato/insert";
	}

	/**
	 * ResidentsMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param ResidentsSatoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertResidentsSato(@ModelAttribute @Validated final ResidentsSatoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "residentsSato/insert";
		}

		// データを登録する
		final ResidentsMainSato residentsMainSato = residentsSatoService.insertResidentsSato(form);
		return "redirect:/residentsSato?result=insert&id=" + residentsMainSato.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param ResidentsSatoInputForm residentsSatoInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateResidents(@RequestParam(name = "id") final long id,
			@ModelAttribute final ResidentsSatoInputForm residentsSatoInputForm) {

		// IDをキーにResidentsMainテーブルを検索する
		ResidentsMainSato residentsMainSato = residentsSatoService.getResidentsSato(id);

		// フォームにレコードの値をセットする
		residentsSatoInputForm.initWithResidentsMainSato(residentsMainSato);
		return "residentsSato/update";
	}

	/**
	 * ResidentsMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param ResidentsSatoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateResidentsSato(@Validated final ResidentsSatoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "residentsSato/update";
		}

		// データを更新する
		ResidentsMainSato residentsMainSato = residentsSatoService.updateResidentsSato(form);
		if (residentsMainSato == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/residentsSato?result=updatefailed";
		}
		return "redirect:/residentsSato?result=update&id=" + residentsMainSato.getId();
	}

	/**
	 * ResidentsMainSatoテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteResidentsSato(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		residentsSatoService.deleteResidentsSatoById(id);
		return "redirect:/residentsSato?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param ResidentsSatoSearchForm form
	 * @param ResidentsSatoDeleteForm residentsSatoDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompResidents(final ResidentsSatoSearchForm form,
			@ModelAttribute final ResidentsSatoDeleteForm residentsSatoDeleteForm, final Model model) {

		// ResidentsMainテーブルから削除フラグが1のレコードを検索する
		final List<ResidentsMainSato> residentsList = residentsSatoService.getListResidentsSato(form);

		// Modelに検索結果を格納する
		model.addAttribute(residentsList);
		return "residentsSato/deletecomp";
	}

	/**
	 * Residentsテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param ResidentsSatoDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompResidents(@Validated final ResidentsSatoDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			ResidentsSatoSearchForm residentsSatoSearchForm = new ResidentsSatoSearchForm();
			residentsSatoSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<ResidentsMainSato> residentsList = residentsSatoService
					.getListResidentsSato(residentsSatoSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(residentsList);
			return "residentsSato/deletecomp";
		}

		// データを完全削除する
		residentsSatoService.deleteResidentsSatoComp(form.getDeleteIds());
		return "redirect:/residentsSato?result=deletecomp";
	}
}
