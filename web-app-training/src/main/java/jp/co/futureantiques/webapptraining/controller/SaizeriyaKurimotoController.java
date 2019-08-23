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
import jp.co.futureantiques.webapptraining.model.form.saizeriyaKurimoto.SaizeriyaKurimotoDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.saizeriyaKurimoto.SaizeriyaKurimotoInputForm;
import jp.co.futureantiques.webapptraining.model.form.saizeriyaKurimoto.SaizeriyaKurimotoSearchForm;
import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.CategoryKurimoto;
import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.PriceKurimoto;
import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.SaizeriyaMenuMainKurimoto;
import jp.co.futureantiques.webapptraining.service.SaizeriyaKurimotoService;


//SaizeriyaKurimotoのコントローラークラス
//↓作者を示すアノテーション
//@author kurimoto


//↓画面遷移の制御、Serviceを呼び出すアノテーション
@Controller
//↓URLへアクセスするとコントローラーが呼び出されるアノテーション
@RequestMapping(value = "/saizeriyaKurimoto")
public class SaizeriyaKurimotoController {
	//SaizeriyaKurimotoのサービス
	private final SaizeriyaKurimotoService saizeriyaKurimotoService;

	//↓パラメーターに関する説明をするアノテーション
	//@param SaizeriyaKurimotoService saizeriyaKurimotoService
	//↓DIするためのアノテーションとDIしているコンストラクタ
	@Autowired
	public SaizeriyaKurimotoController(final SaizeriyaKurimotoService saizeriyaKurimotoService) {
		//外部からオブジェクトを注入
		this.saizeriyaKurimotoService = saizeriyaKurimotoService;
	}

	//カテゴリエンティティのリストを取得する
	//↓戻り値に関する説明をするアノテーション
	//@return CategoryEntityのリスト

	//↓戻り値は"Model"へ返されるアノテーション
	@ModelAttribute
	public List<CategoryKurimoto> getListCategory() {
		return saizeriyaKurimotoService.getListCategoryKurimoto();
	}

	//価格帯エンティティのリストを取得する
	//@return PriceEntityのリスト

	@ModelAttribute
	public List<PriceKurimoto> getListPrice() {
		return saizeriyaKurimotoService.getListPriceKurimoto();
	}

	//検索画面に遷移する
	//@param SaizeriyaKurimotoSearchForm SaizeriyaKurimotoSearchForm
	//@return 検索画面のパス

	//URLの指定と、GETメソッドorPOSTメソッドを使うかの指定をするアノテーション
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchSaizeriya(@ModelAttribute final SaizeriyaKurimotoSearchForm saizeriyaKurimotoSearchForm) {
		return "saizeriyaKurimoto/search";
	}

	//検索結果を取得して検索画面に遷移する
	//@param SaizeriyaKurimotoSearchForm form
	//@param Model model
	//@param Pageable pageable
	//@return 検索画面のパス

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchSaizeriya(final SaizeriyaKurimotoSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<SaizeriyaMenuMainKurimoto> saizeriyaList = saizeriyaKurimotoService.getPageSaizeriyaKurimoto(form, pageable);
		if (saizeriyaList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", saizeriyaList);
			model.addAttribute("saizeriyaList", saizeriyaList.getContent());
			model.addAttribute("url", "search");
		}
		return "saizeriyaKurimoto/search";
	}

	//追加画面に遷移する
	//@param SaizeriyaKurimotoInputForm saizeriyaKurimotoInputForm
	//@return 追加画面のパス

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertSaizeriya(@ModelAttribute final SaizeriyaKurimotoInputForm saizeriyaKurimotoInputForm) {
		return "saizeriyaKurimoto/insert";
	}

	//menu_main_kurimotoテーブルにデータを登録して検索画面に遷移する
	//@param SaizeriyaKurimotoInputForm form
	//@param BindingResult bindingResult
	//@return 入力エラーがある場合追加画面、ない場合検索画面のパス

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertSaizeriyaKurimoto(@ModelAttribute @Validated final SaizeriyaKurimotoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "saizeriyaKurimoto/insert";
		}

		// データを登録する
		final SaizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto = saizeriyaKurimotoService.insertSaizeriyaKurimoto(form);
		return "redirect:/saizeriyaKurimoto?result=insert&id=" + saizeriyaMenuMainKurimoto.getId();
	}

	//更新画面に遷移する
	//@param long id
	//@param SaizeriyaKurimotoInputForm saizeriyaKurimotoInputForm
	//@return 更新画面のパス

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateSaizeriya(@RequestParam(name = "id") final long id,
			@ModelAttribute final SaizeriyaKurimotoInputForm saizeriyaKurimotoInputForm) {

		// IDをキーにMenuMainテーブルを検索する
		SaizeriyaMenuMainKurimoto saizeriyaMain = saizeriyaKurimotoService.getSaizeriyaKurimoto(id);

		// フォームにレコードの値をセットする
		saizeriyaKurimotoInputForm.initWithSaizeriyaMenuMainKurimoto(saizeriyaMain);
		return "saizeriyaKurimoto/update";
	}

	//MenuMainテーブルのデータを更新して検索画面に遷移する
	//@param SaizeriyaKurimotoInputForm form
	//@param BindingResult bindingResult
	//@return 入力エラーがある場合更新画面、ない場合検索画面のパス

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateSaizeriya(@Validated final SaizeriyaKurimotoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "saizeriyaKurimoto/update";
		}

		// データを更新する
		SaizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto = saizeriyaKurimotoService.updateSaizeriyaKurimoto(form);
		if (saizeriyaMenuMainKurimoto == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/saizeriyaKurimoto?result=updatefailed";
		}
		return "redirect:/saizeriyaKurimoto?result=update&id=" + saizeriyaMenuMainKurimoto.getId();
	}

	//MenuMainテーブルのレコードを論理削除して検索画面に遷移する
	//@param long id
	//@return 検索画面のパス

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteSaizeriya(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		saizeriyaKurimotoService.deleteSaizeriyaKurimotoById(id);
		return "redirect:/saizeriyaKurimoto?result=delete&id=" + id;
	}

	//完全削除画面に遷移する
	//@param SaizeriyaKurimotoSearchForm form
	//@param SaizeriyiaKurimotoDeleteForm saizeriyaKurimotoDeleteForm
	//@param Model model
	//@return 完全削除画面のパス

	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompSaizeriya(final SaizeriyaKurimotoSearchForm form,
			@ModelAttribute final SaizeriyaKurimotoDeleteForm saizeriyaKurimotoDeleteForm, final Model model) {

		// MenuMainテーブルから削除フラグが1のレコードを検索する
		final List<SaizeriyaMenuMainKurimoto> saizeriyaList = saizeriyaKurimotoService.getListSaizeriyaKurimoto(form);

		// Modelに検索結果を格納する
		model.addAttribute(saizeriyaList);
		return "saizeriyaKurimoto/deletecomp";
	}

	//MenuMainテーブルのデータを完全削除して検索画面に遷移する
	//@param SaizeriyaKurimotoDeleteForm form
	//@param BindingResult bindingResult
	//@param Model model
	//@return 入力エラーがある場合完全削除画面、ない場合検索画面のパス

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompSaizeriya(@Validated final SaizeriyaKurimotoDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			SaizeriyaKurimotoSearchForm saizeriyaKurimotoSearchForm = new SaizeriyaKurimotoSearchForm();
			saizeriyaKurimotoSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<SaizeriyaMenuMainKurimoto> saizeriyaList = saizeriyaKurimotoService.getListSaizeriyaKurimoto(saizeriyaKurimotoSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(saizeriyaList);
			return "saizeriyaKurimoto/deletecomp";
		}

		// データを完全削除する
		saizeriyaKurimotoService.deleteSaizeriyaKurimotoComp(form.getDeleteIds());
		return "redirect:/saizeriyaKurimoto?result=deletecomp";
	}
}
