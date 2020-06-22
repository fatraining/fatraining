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
import jp.co.futureantiques.webapptraining.model.form.proteinUeno.ProteinUenoDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.proteinUeno.ProteinUenoInputForm;
import jp.co.futureantiques.webapptraining.model.form.proteinUeno.ProteinUenoSearchForm;
import jp.co.futureantiques.webapptraining.model.proteinUeno.KindsUeno;
import jp.co.futureantiques.webapptraining.model.proteinUeno.MakerUeno;
import jp.co.futureantiques.webapptraining.model.proteinUeno.ProteinMainUeno;
import jp.co.futureantiques.webapptraining.service.ProteinUenoService;

/**
 * proteinUenoのコントローラークラス
 *
 * @author ueno
 */
@Controller
@RequestMapping(value = "/proteinueno")

public class ProteinUenoController {

	/** プロテインのサービス */
	private final ProteinUenoService proteinUenoService;

	/**
	 * コンストラクタ
	 *
	 * @param ProteinUenoService proteinUenoService
	 */
	@Autowired
	public ProteinUenoController(final ProteinUenoService proteinUenoService) {
		this.proteinUenoService = proteinUenoService;
	}

	/**
	 * 種類エンティティのリストを取得する
	 *
	 * @return KindEntityのリスト
	 */
	@ModelAttribute
	public List<KindsUeno> getListKindsUeno() {
		return proteinUenoService.getListKindsUeno();
	}


	/**
	 * メーカーエンティティのリストを取得する
	 *
	 * @return MakerEntityのリスト
	 */
	@ModelAttribute
	public List<MakerUeno> getListMakerUeno() {
		return proteinUenoService.getListMakerUeno();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param ProteinUenoSearchForm proteinUenoSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchProtein(@ModelAttribute final ProteinUenoSearchForm proteinUenoSearchForm) {
		return "proteinueno/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param ProteinUenoSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchProtein(final ProteinUenoSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<ProteinMainUeno> proteinMainUenoList = proteinUenoService.getPageProtein(form, pageable);
		if (proteinMainUenoList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", proteinMainUenoList);
			model.addAttribute("proteinMainUenoList", proteinMainUenoList.getContent());
			model.addAttribute("url", "search");
		}
		return "proteinueno/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param ProteinUeno\InputForm proteinUenoInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertProtein(@ModelAttribute final ProteinUenoInputForm proteinUenoInputForm) {
		return "proteinueno/insert";
	}

	/**
	 * ProteinMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param ProteinUenoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertProtein(@ModelAttribute @Validated final ProteinUenoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "proteinueno/insert";
		}

		// データを登録する
		final ProteinMainUeno proteinMain = proteinUenoService.insertProtein(form);
		return "redirect:/proteinueno?result=insert&id=" + proteinMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param ProteinUenoInputForm proteinUenoInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateProtein(@RequestParam(name = "id") final long id,
			@ModelAttribute final ProteinUenoInputForm proteinUenoInputForm) {

		// IDをキーにプロテインMainテーブルを検索する
		ProteinMainUeno proteinMain = proteinUenoService.getProtein(id);

		// フォームにレコードの値をセットする
		proteinUenoInputForm.initWithProteinMain(proteinMain);
		return "proteinueno/update";
	}

	/**
	 * ProteinMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param ProteinUenoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateProtein(@Validated final ProteinUenoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "proteinueno/update";
		}

		// データを更新する
		ProteinMainUeno proteinMain = proteinUenoService.updateProtein(form);
		if (proteinMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/proteinueno?result=updatefailed";
		}
		return "redirect:/proteinueno?result=update&id=" + proteinMain.getId();
	}

	/**
	 * ProteinMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteProtein(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		proteinUenoService.deleteProteinById(id);
		return "redirect:/proteinueno?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param ProteinUenoSearchForm form
	 * @param ProteinUenoDeleteForm proteinUenoDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompProtein(final ProteinUenoSearchForm form,
			@ModelAttribute final ProteinUenoDeleteForm proteinUenoDeleteForm, final Model model) {

		// プロテインMainテーブルから削除フラグが1のレコードを検索する
		final List<ProteinMainUeno> proteinMainUenoList = proteinUenoService.getListProtein(form);

		// Modelに検索結果を格納する
		model.addAttribute(proteinMainUenoList);
		return "proteinueno/deletecomp";
	}

	/**
	 * ProteinMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param ProteinUenoDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompProtein(@Validated final ProteinUenoDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			ProteinUenoSearchForm proteinUenoSearchForm = new ProteinUenoSearchForm();
			proteinUenoSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<ProteinMainUeno> proteinMainUenoList = proteinUenoService.getListProtein(proteinUenoSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(proteinMainUenoList);
			return "proteinueno/deletecomp";
		}

		// データを完全削除する
		proteinUenoService.deleteProteinComp(form.getDeleteIds());
		return "redirect:/proteinueno?result=deletecomp";
	}

}
