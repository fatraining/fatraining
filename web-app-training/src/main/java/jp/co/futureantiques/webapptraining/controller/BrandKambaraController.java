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
import jp.co.futureantiques.webapptraining.model.brandkambara.BrandMainKambara;
import jp.co.futureantiques.webapptraining.model.brandkambara.GenreKambara;
import jp.co.futureantiques.webapptraining.model.brandkambara.MadeCountryKambara;
import jp.co.futureantiques.webapptraining.model.form.brandKambara.BrandKambaraDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.brandKambara.BrandKambaraInputForm;
import jp.co.futureantiques.webapptraining.model.form.brandKambara.BrandKambaraSearchForm;
import jp.co.futureantiques.webapptraining.service.BrandKambaraService;

/**
 * BrandKambaraのコントローラークラス
 *
 * @author Yuki Kambara
 */
@Controller
@RequestMapping(value = "/brandKambara")

public class BrandKambaraController {
	private final BrandKambaraService brandKambaraService;

	/**
	 * コンストラクタ
	 *上の定義を使えるようにした
	 * @param BrandKambaraService brandKambaraService
	 */
	@Autowired
	public BrandKambaraController(final BrandKambaraService brandKambaraService) {
		this.brandKambaraService = brandKambaraService;
	}





	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreKambaraEntityのリスト
	 *
	 * ModelAttribute…@ModelAttribute アノテーションは、コントローラのメソッドか引数につけて使う。
	 * いずれの場合も、ハンドラメソッドが動く前にアノテーションが検出され、
	 * メソッドについているか、引数についているかに応じて、Spring によって処理される。
	 *詳細…https://kazkn.com/post/2017/use-model-attribute/
	 */
	@ModelAttribute
	public List<GenreKambara> getListGenreKambara() {

		return brandKambaraService.getListGenreKambara();
	}

	/**
	 * 生産国エンティティのリストを取得する
	 *
	 * @return MadeCountryKambaraEntityのリスト
	 */
	@ModelAttribute
	public List<MadeCountryKambara> getListMadeCountryKambara() {
		return brandKambaraService.getListMadeCountryKambara();
	}




	/**
	 * 上のModelAttributeの
	 * ・ brandKambaraService.getListGenreKambara();
	 * ・brandKambaraService.getListMadeCountryKambara
	 * については、以下のメソッドを使うときにも対応する
	 */

	/**
	 * 検索画面に遷移する
	 *
	 * @param BrandKambaraSearchForm brandKambaraSearchForm
	 * @return 検索画面のパス
	 * (@ModelAttribute 引数)
//	 *return "ringoTakizawa/search"=templates.ringoTakizawaのsearch.html?
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchBrandKambara(@ModelAttribute final BrandKambaraSearchForm brandKambaraSearchForm) {
		return "brandKambara/search";
	}


	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param  BrandKambaraSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス　　 brandKambara/searchがsearch.htmlのactionに対応している？
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchBrandKambara(final BrandKambaraSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<BrandMainKambara> brandKambaraList = brandKambaraService.getPageBrand(form, pageable);
		if (brandKambaraList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", brandKambaraList);
			model.addAttribute("brandKambaraList", brandKambaraList.getContent());
			model.addAttribute("url", "search");
		}
		return "brandKambara/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param BrandKambaraInput brandKambaraInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertBrand(@ModelAttribute final BrandKambaraInputForm brandKambaraInputForm) {
		return "brandKambara/insert";
	}

	/**
	 * BrandMainKambaraテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param  BrandKambaraInput form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertBrand(@ModelAttribute @Validated final BrandKambaraInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "brandKambara/insert";
		}

		// データを登録する　search.html
		final BrandMainKambara brandMainKambara = brandKambaraService.insertBrand(form);
		return "redirect:/brandKambara?result=insert&id=" + brandMainKambara.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param BrandKambaraInput BrandKambaraInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateBrand(@RequestParam(name = "id") final long id,
			@ModelAttribute final BrandKambaraInputForm brandKambaraInputForm) {

		// IDをキーにBrandMainKambaraテーブルを検索する
		BrandMainKambara brandMainKambara = brandKambaraService.getBrandMainKambara(id);

		// フォームにレコードの値をセットする
		brandKambaraInputForm.initWithBrandMainKambara(brandMainKambara);
		return "brandKambara/update";
	}

	/**
	 * BrandMainKambaraテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param BrandKambaraInput form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateBrand(@Validated final BrandKambaraInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "brandKambara/update";
		}

		// データを更新する
		BrandMainKambara brandMainKambara = brandKambaraService.updateBrand(form);
		if (brandMainKambara == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/brandKambara?result=updatefailed";
		}
		//更新が成功した場合、検索画面にメッセージとIDの表記
		return "redirect:/brandKambara?result=update&id=" + brandMainKambara.getId();
	}

	/**
	 * BrandMainKambaraテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteBrand(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		brandKambaraService.deleteBrandById(id);
		return "redirect:/brandKambara?result=delete&id=" + id;
	}


	/**
	 * 完全削除画面に遷移する
	 *
	 * @param BrandKambaraSearchForm form
	 * @param BrandKambaraDeleteForm brandKambaraDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompBrand(final BrandKambaraSearchForm form,
			@ModelAttribute final BrandKambaraDeleteForm brandKambaraDeleteForm, final Model model) {

		// MovieMainテーブルから削除フラグが1のレコードを検索する
		final List<BrandMainKambara> brandKambaraList = brandKambaraService.getListBrandMainKambara(form);

		// Modelに検索結果を格納する
		model.addAttribute(brandKambaraList);
		return "brandKambara/deletecomp";
	}
	/**
	 * BrandMainKambaraテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param BrandKambaraDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompBrand(@Validated final BrandKambaraDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			BrandKambaraSearchForm brandKambaraSearchForm = new BrandKambaraSearchForm();
			brandKambaraSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<BrandMainKambara> brandKambaraList = brandKambaraService.getListBrandMainKambara(brandKambaraSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(brandKambaraList);
			return "brandKambara/deletecomp";
		}

		// データを完全削除する
		brandKambaraService.deleteBrandComp(form.getDeleteIds());
		return "redirect:/brandKambara?result=deletecomp";
	}

}
