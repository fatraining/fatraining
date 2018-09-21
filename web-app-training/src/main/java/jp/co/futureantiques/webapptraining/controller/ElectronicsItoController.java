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

import jp.co.futureantiques.webapptraining.model.Electronics.BrandIto;
import jp.co.futureantiques.webapptraining.model.Electronics.CategoryIto;
import jp.co.futureantiques.webapptraining.model.Electronics.ElectronicsMainIto;
import jp.co.futureantiques.webapptraining.model.form.electronicsIto.ElectronicsDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.electronicsIto.ElectronicsInputForm;
import jp.co.futureantiques.webapptraining.model.form.electronicsIto.ElectronicsSearchForm;
import jp.co.futureantiques.webapptraining.service.ElectronicsItoService;

/**
 * Electronicsのコントローラークラス
 *
 * @author AIRI ITO
 */
@Controller
@RequestMapping(value = "/electronics")
public class ElectronicsItoController {

	/** 電化製品のサービス */
	private final ElectronicsItoService electronicsItoService;

	/**
	 * コンストラクタ
	 *
	 * @param ElectronicsItoService electronicsItoService
	 */
	@Autowired
	public ElectronicsItoController(final ElectronicsItoService electronicsItoService) {
		this.electronicsItoService = electronicsItoService;
	}

	/**
	 * カテゴリーエンティティのリストを取得する
	 *
	 * @return CategoryEntityのリスト
	 */
	@ModelAttribute
	public List<CategoryIto> getListCategory() {
		return electronicsItoService.getListCategory();
	}

	/**
	 * ブランドエンティティのリストを取得する
	 *
	 * @return BrandEntityのリスト
	 */
	@ModelAttribute
	public List<BrandIto> getListBrand() {
		return electronicsItoService.getListBrand();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param electronicsSearchForm electronicsSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchProcduct(@ModelAttribute final ElectronicsSearchForm electronicsSearchForm) {
		return "electronicsito/search";
	}

	/**
	 *検索結果を取得して検索画面に遷移する
	 *
	 *@param ElectronicsSearchForm form
	 *@param Model model
	 *@param Pageable pageable
	 *@return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchProduct(final ElectronicsSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<ElectronicsMainIto> productList = electronicsItoService.getPageProduct(form, pageable);
		if (productList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", productList);
			model.addAttribute("productList", productList.getContent());
			model.addAttribute("url", "search");
		}
		return "electronicsito/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param ElectronicsInputForm electronicsInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertProduct(@ModelAttribute final ElectronicsInputForm electronisInputForm) {
		return "electronicsito/insert";
	}

	/**
	 * ElectronicsMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param ElectronicsInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertProduct(@ModelAttribute @Validated final ElectronicsInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合次画面に戻る
			return "electronicsito/insert";
		}

		//データを登録する
		final ElectronicsMainIto electronicsMainIto = electronicsItoService.insertProduct(form);
		return "redirect:/electronics?result=insert&id=" + electronicsMainIto.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param ElectronicsInputForm electronicsInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateProduct(@RequestParam(name = "id") final long id,
			@ModelAttribute final ElectronicsInputForm electronicsIputForm) {

		//IDをキーにElectronicsMainテーブルを検索する
		ElectronicsMainIto electronicsMainIto = electronicsItoService.getProduct(id);

		//フォームにレコードの値をセットする
		electronicsIputForm.initWithElectronicsMain(electronicsMainIto);
		return "electronicsito/update";
	}

	/**
	 * ElectronicsMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param ElectronicsInputForm form
	 * @param BindingResult bindingResult
	 * @param 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateProduct(@Validated final ElectronicsInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合次画面に戻る
			return "electronicsito/update";
		}

		//データを更新する
		ElectronicsMainIto electronicsMainIto = electronicsItoService.updateProduct(form);
		if (electronicsMainIto == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/electronics?result=updatefailed";
		}
		return "redirect:/electronics?result=update&id=" + electronicsMainIto.getId();
	}

	/**
	 * ElectronicsMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteProduct(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		electronicsItoService.deleteProductById(id);
		return "redirect:/electronics?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param ElectronicsSearchForm form
	 * @para ElectronicsDeleteForm electronicsDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompProduct(final ElectronicsSearchForm form,
			@ModelAttribute final ElectronicsDeleteForm electronicsDeleteForm, final Model model) {

		//Electronicsテーブルから削除フラグが1のレコードを検索する
		final List<ElectronicsMainIto> productList = electronicsItoService.getListProduct(form);

		//Modelに検索結果を格納する
		model.addAttribute(productList);
		return "electronicsito/deletecomp";
	}

	/**
	 * Electronicsテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param ElectroncisDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面に遷移
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompProduct(@Validated final ElectronicsDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合、再検索して自画面に戻る
			ElectronicsSearchForm electronicsSearchForm = new ElectronicsSearchForm();
			electronicsSearchForm.setIsDelete(1);
			final List<ElectronicsMainIto> productList = electronicsItoService.getListProduct(electronicsSearchForm);

			//Modelに検索結果を格納する
			model.addAllAttributes(productList);
			return "electronicsito/deletecomp";
		}

		//データを完全削除する
		electronicsItoService.deleteProductComp(form.getDeleteIds());
		return "redirect:/electronics?result=deletecomp";

	}
}
