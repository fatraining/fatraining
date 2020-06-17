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
import jp.co.futureantiques.webapptraining.model.alcoholishida.AlcoholMainIshida;
import jp.co.futureantiques.webapptraining.model.alcoholishida.IngredientIshida;
import jp.co.futureantiques.webapptraining.model.alcoholishida.LiqueurIshida;
import jp.co.futureantiques.webapptraining.model.form.alcoholishida.AlcoholIshidaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.alcoholishida.AlcoholIshidaInputForm;
import jp.co.futureantiques.webapptraining.model.form.alcoholishida.AlcoholIshidaSearchForm;
import jp.co.futureantiques.webapptraining.service.AlcoholIshidaService;

/**
 * Alcoholのコントローラークラス
 * @author t.ishida
 */
@Controller
@RequestMapping(value = "/alcoholIshida")
public class AlcoholIshidaController {

	/**お酒のサービス */
	private final AlcoholIshidaService alcoholIshidaService;

	/**コンストラクタ
	 *
	 * @param AlcoholIshidaService alcoholIshidaService
	 */
	@Autowired
	public AlcoholIshidaController(final AlcoholIshidaService alcoholIshidaService) {
		this.alcoholIshidaService = alcoholIshidaService;
	}

	/**
	 * リキュールエンティティのリストを取得する
	 *
	 * @return LiqueurEntityのリスト
	 */
	@ModelAttribute
	public List<LiqueurIshida> getListLiqueur() {
		return alcoholIshidaService.getListLiqueur();
	}

	/**
	 * 材料エンティティのリストを取得する
	 *
	 */
	@ModelAttribute
	public List<IngredientIshida> getListIngredient() {
		return alcoholIshidaService.getListIngredient();
	}

	/**
	 * 検索画面に遷移する
	 *
	 *@param alcoholIshidaSearchForm alcoholIshidaSearchFrom
	 *@param 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearch(@ModelAttribute final AlcoholIshidaSearchForm alcoholIshidaSearchForm) {
		return "alcoholIshida/search";
	}

	/**
	 *検索結果を取得して検索画面に遷移する
	 *
	 *@param AlcoholIshidaSearchForm
	 *@param Model model
	 *@param Pageable pageable
	 *@param 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchAlcohol(final AlcoholIshidaSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<AlcoholMainIshida> alcoholIshidaList = alcoholIshidaService.getPageAlcohol(form, pageable);
		if (alcoholIshidaList.getTotalElements() != 0) {

			//検索結果がある場合はModelに結果をセットする
			model.addAttribute("page", alcoholIshidaList);
			model.addAttribute("alcoholIshidaList", alcoholIshidaList.getContent());
			model.addAttribute("url", "search");
		}
		return "alcoholIshida/search";
	}

	/**
	 * 追加画面に遷移する
	 * @param AlcoholIshidaInputForm alcoholIshidaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertAlcohol(@ModelAttribute final AlcoholIshidaInputForm alcoholIshidaInputForm) {
		return "alcoholIshida/insert";
	}

	/**
	 * @param AlcoholIshidaInputForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合追加画面、ない場合は検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertAlcohol(@ModelAttribute @Validated final AlcoholIshidaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "alcoholIshida/insert";
		}

		//データを登録する
		final AlcoholMainIshida alcoholMainIshida = alcoholIshidaService.insertAlcohol(form);
		return "redirect:/alcoholIshida?result=insert&id=" + alcoholMainIshida.getId();
	}

	/**
	 * 更新画面に遷移する

	 * @param long id
	 * @param AlcoholIshidaInputForm alcoholIshidaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateAlcohol(final AlcoholIshidaSearchForm form, @RequestParam(name = "id") final long id,
			@ModelAttribute final AlcoholIshidaInputForm alcoholIshidaInputForm,
			Model model, final Pageable pageable) {

		//IDをキーにAlcoholMainIshidaテーブルを検索する
		AlcoholMainIshida alcoholMainIshida = alcoholIshidaService.getAlcohol(id);

		//フォームにレコードの値をセットする
		alcoholIshidaInputForm.initWithAlcoholMainIshida(alcoholMainIshida);
		return "alcoholIshida/update";
	}

	/**
	 * AlcoholMainIshidaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param AlcoholIshidaInputFormform
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateAlcohol(@Validated final AlcoholIshidaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "alcoholIshida/update";
		}

		//データを更新する
		AlcoholMainIshida alcoholMainIshida = alcoholIshidaService.updateAlcohol(form);
		if (alcoholMainIshida == null) {

			//更新が失敗した場合、検索画面にメッセージを表示をする
			return "redirect:/alcoholIshida?result=updatefailed";
		}
		return "redirect:/alcoholIshida?result=update&id=" + alcoholMainIshida.getId();
	}

	/**AlcoholMainIshidaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteAlcohol(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		alcoholIshidaService.deleteAlcoholById(id);
		return "redirect:/alcoholIshida?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param AlcoholIshidaSearchForm form
	 * @param AlcoholIshidaDeleteForm alcoholIshidaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompAlcohol(final AlcoholIshidaSearchForm form,
			@ModelAttribute final AlcoholIshidaDeleteForm alcoholIshidaDeleteForm, final Model model) {

		//AlcoholIshidaテーブルから削除フラグが1のレコードを検索する
		final List<AlcoholMainIshida> alcoholList = alcoholIshidaService.getListAlcohol(form);

		//Modelに検索結果を格納する
		model.addAttribute(alcoholList);
		return "alcoholIshida/deletecomp";
	}

	/**
	 * AlcoholMainIshidaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param AlcoholIshidaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompAlcohol(@Validated final AlcoholIshidaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			AlcoholIshidaSearchForm alcoholIshidaSearchForm = new AlcoholIshidaSearchForm();
			alcoholIshidaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<AlcoholMainIshida> alcoholList = alcoholIshidaService.getListAlcohol(alcoholIshidaSearchForm);

			//Modelに検索結果を格納する
			model.addAttribute(alcoholList);
			return "alcoholIshida/deletecomp";
		}

		//データを完全削除する
		alcoholIshidaService.deleteAlcoholComp(form.getDeleteIds());
		return "redirect:/alcoholIshida?result=deletecomp";
	}
}
