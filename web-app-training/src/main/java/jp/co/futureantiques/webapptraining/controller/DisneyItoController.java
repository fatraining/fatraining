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
import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyAreaIto;
import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyMainIto;
import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyParkIto;
import jp.co.futureantiques.webapptraining.model.form.disneyIto.DisneyItoDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.disneyIto.DisneyItoInputForm;
import jp.co.futureantiques.webapptraining.model.form.disneyIto.DisneyItoSearchForm;
import jp.co.futureantiques.webapptraining.service.DisneyItoService;

/**
 * DisneyItoのコントローラークラス
 *
 * @author Ayaka Ito
 */
@Controller
@RequestMapping(value = "/disneyIto")
public class DisneyItoController {

	/** ディズニーアトラクションのサービス */
	private final DisneyItoService disneyItoService;

	/**
	 * コンストラクタ
	 *
	 * @param DisneyItoService disneyItoService
	 */
	@Autowired
	public DisneyItoController(final DisneyItoService disneyItoService) {
		this.disneyItoService = disneyItoService;
	}

	/**
	 * パークエンティティのリストを取得する
	 *
	 * @return ParkItoEntityのリスト
	 */
	@ModelAttribute
	public List<DisneyParkIto> getListDisneyParkIto() {
		return disneyItoService.getListDisneyParkIto();
	}

	/**
	 * エリアエンティティのリストを取得する
	 *
	 * @return AreaItoEntityのリスト
	 */
	@ModelAttribute
	public List<DisneyAreaIto> getListDisneyAreaIto() {
		return disneyItoService.getListDisneyAreaIto();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param DisneyItoSearchForm disneyItoSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchDisney(@ModelAttribute final DisneyItoSearchForm disneyItoSearchForm) {
		return "disneyIto/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param DisneyItoSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchDisney(final DisneyItoSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<DisneyMainIto> disneyList = disneyItoService.getPageDisney(form, pageable);
		if (disneyList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", disneyList);
			model.addAttribute("disneyList", disneyList.getContent());
			model.addAttribute("url", "search");
		}
		return "disneyIto/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param DisneyItoInputForm disneyItoInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertDisney(@ModelAttribute final DisneyItoInputForm disneyItoInputForm) {
		return "disneyIto/insert";
	}

	/**
	 * disney_main_itoテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param DisneyItoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertDisney(@ModelAttribute @Validated final DisneyItoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "disneyIto/insert";
		}

		// データを登録する
		final DisneyMainIto disneyMainIto = disneyItoService.insertDisney(form);
		return "redirect:/disneyIto?result=insert&id=" + disneyMainIto.getId();
	}

	/**
	 * 更新画面に遷移する
	 * @param long id
	 * @param DisneyItoInputForm disneyItoInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateDisney(@RequestParam(name = "id") final long id,
			@ModelAttribute final DisneyItoInputForm disneyItoInputForm) {

		// IDをキーにdisney_main_itoテーブルを検索する
		DisneyMainIto disneyMainIto = disneyItoService.getDisney(id);

		// フォームにレコードの値をセットする
		disneyItoInputForm.initWithDisneyMainIto(disneyMainIto);
		return "disneyIto/update";
	}

	/**
	 * disney_main_itoテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param DisneyItoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateDisney(@Validated final DisneyItoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "disneyIto/update";
		}

		// データを更新する
		DisneyMainIto disneyMainIto = disneyItoService.updateDisney(form);
		if (disneyMainIto == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/disneyIto?result=updatefailed";
		}
		return "redirect:/disneyIto?result=update&id=" + disneyMainIto.getId();
	}

	/**
	 * disney_main_itoテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteDisney(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		disneyItoService.deleteDisneyById(id);
		return "redirect:/disneyIto?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param DisneyItoSearchForm form
	 * @param DisneyItoDeleteForm disneyItoDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompDisney(final DisneyItoSearchForm form,
			@ModelAttribute final DisneyItoDeleteForm disneyItoDeleteForm, final Model model) {

		// disney_main_itoテーブルから削除フラグが1のレコードを検索する
		final List<DisneyMainIto> disneyList = disneyItoService.getListDisney(form);

		// Modelに検索結果を格納する
		model.addAttribute(disneyList);
		return "disneyIto/deletecomp";
	}

	/**
	 * disney_main_itoテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param DisneyItoDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompDisney(@Validated final DisneyItoDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			DisneyItoSearchForm disneyItoSearchForm = new DisneyItoSearchForm();
			disneyItoSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<DisneyMainIto> disneyList = disneyItoService.getListDisney(disneyItoSearchForm);

			//modelに検索結果を格納する
			model.addAttribute(disneyList);
			return "disneyIto/deletecomp";
		}

		// データを完全削除する
		disneyItoService.deleteDisneyComp(form.getDeleteIds());
		return "redirect:/disneyIto?result=deletecomp";
	}

}