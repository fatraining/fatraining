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
import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.AmmoHagiwara;
import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.ApexMainHagiwara;
import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.WeaponKindHagiwara;
import jp.co.futureantiques.webapptraining.model.form.apexWeaponHagiwara.ApexDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.apexWeaponHagiwara.ApexInputForm;
import jp.co.futureantiques.webapptraining.model.form.apexWeaponHagiwara.ApexSearchForm;
import jp.co.futureantiques.webapptraining.service.ApexHagiwaraService;

/**
 * ApexweaponHagiwaraのコントローラークラス
 *
 * @author Hagiwara
 */
@Controller
@RequestMapping(value = "/apexHagiwara")
public class ApexHagiwaraController {

	/** Apex武器のサービス */
	private final ApexHagiwaraService apexHagiwaraService;

	/**
	 * コンストラクタ
	 *
	 * @param ApexHagiwaraService apexHagiwaraService
	 */
	@Autowired
	public ApexHagiwaraController(final ApexHagiwaraService apexHagiwaraService) {
		this.apexHagiwaraService = apexHagiwaraService;
	}

	/**
	 * 武器種エンティティのリストを取得する
	 *
	 * @return WeaponKindHagiwaraEntityのリスト
	 */
	@ModelAttribute
	public List<WeaponKindHagiwara> getListWeaponKindHagiwara() {
		return apexHagiwaraService.getListWeaponKindHagiwara();
	}

	/**
	 * 使用アモエンティティのリストを取得する
	 *
	 * @return AmmoHagiwaraEntityのリスト
	 */
	@ModelAttribute
	public List<AmmoHagiwara> getListAmmoHagiwara() {
		return apexHagiwaraService.getListAmmoHagiwara();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param ApexHagiwaraSearchForm apexHagiwaraSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchApex(@ModelAttribute final ApexSearchForm apexSearchForm) {
		return "apexHagiwara/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param ApexSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchApex(final ApexSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<ApexMainHagiwara> apexList = apexHagiwaraService.getPageApex(form, pageable);
		if (apexList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", apexList);
			model.addAttribute("apexList", apexList.getContent());
			model.addAttribute("url", "search");
		}
		return "apexHagiwara/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param ApexInputForm apexInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertApex(@ModelAttribute final ApexInputForm apexInputForm) {
		return "apexHagiwara/insert";
	}

	/**
	 * MovieMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param ApexInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertApex(@ModelAttribute @Validated final ApexInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "apexHagiwara/insert";
		}

		// データを登録する
		final ApexMainHagiwara apexMainHagiwara = apexHagiwaraService.insertApex(form);
		return "redirect:/apexHagiwara?result=insert&id=" + apexMainHagiwara.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param ApexInputForm apexInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateApex(@RequestParam(name = "id") final long id,
			@ModelAttribute final ApexInputForm apexInputForm) {

		// IDをキーにApexMainHagiwaraテーブルを検索する
		ApexMainHagiwara apexMainHagiwara = apexHagiwaraService.getApex(id);

		// フォームにレコードの値をセットする
		apexInputForm.initWithApexMainHagiwara(apexMainHagiwara);
		return "apexHagiwara/update";
	}

	/**
	 * apexMainHagiwaraテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param ApexInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateApex(@Validated final ApexInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "apexHagiwara/update";
		}

		// データを更新する
		ApexMainHagiwara apexMainHagiwara = apexHagiwaraService.updateApex(form);
		if (apexMainHagiwara == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/apexHagiwara?result=updatefailed";
		}
		return "redirect:/apexHagiwara?result=update&id=" + apexMainHagiwara.getId();
	}

	/**
	 * apexMainHagiwaraテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteApex(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		apexHagiwaraService.deleteApexById(id);
		return "redirect:/apexHagiwara?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param ApexSearchForm form
	 * @param ApexDeleteForm apexDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompApex(final ApexSearchForm form,
			@ModelAttribute final ApexDeleteForm apexDeleteForm, final Model model) {

		// ApexMainHagiwaraテーブルから削除フラグが1のレコードを検索する
		final List<ApexMainHagiwara> apexList = apexHagiwaraService.getListApex(form);

		// Modelに検索結果を格納する
		model.addAttribute(apexList);
		return "apexHagiwara/deletecomp";
	}

	/**
	 * MovieMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param ApexDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompApex(@Validated final ApexDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			ApexSearchForm apexSearchForm = new ApexSearchForm();
			apexSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<ApexMainHagiwara> apexList = apexHagiwaraService.getListApex(apexSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(apexList);
			return "apexHagiwara/deletecomp";
		}

		// データを完全削除する
		apexHagiwaraService.deleteApexComp(form.getDeleteIds());
		return "redirect:/apexHagiwara?result=deletecomp";
	}
}
