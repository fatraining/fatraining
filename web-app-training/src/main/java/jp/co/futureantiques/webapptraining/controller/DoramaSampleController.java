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

import jp.co.futureantiques.webapptraining.model.doramasample.DoramaGenre;
import jp.co.futureantiques.webapptraining.model.doramasample.DoramaMain;
import jp.co.futureantiques.webapptraining.model.doramasample.TvStation;
import jp.co.futureantiques.webapptraining.model.form.doramasample.DoramaSampleDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.doramasample.DoramaSampleInputForm;
import jp.co.futureantiques.webapptraining.model.form.doramasample.DoramaSampleSearchForm;
import jp.co.futureantiques.webapptraining.service.DoramaSampleService;

/**
 * DoramaSampleのコントローラークラス
 *
 * @author hiraoka
 */
@Controller
@RequestMapping(value = "/doramasample")
public class DoramaSampleController {

	/** ドラマのサービス */
	private final DoramaSampleService doramaSampleService;

	/**
	 * コンストラクタ
	 *
	 * @param DoramaSampleService doramaSampleService
	 */
	@Autowired
	public DoramaSampleController(final DoramaSampleService doramaSampleService) {
		this.doramaSampleService = doramaSampleService;
	}

	/**
	 * ドラマジャンルエンティティのリストを取得する
	 *
	 * @return DoramaGenreEntityのリスト
	 */
	@ModelAttribute
	public List<DoramaGenre> getListGenre() {
		return doramaSampleService.getListDoramaGenre();
	}

	/**
	 * 放送局エンティティのリストを取得する
	 *
	 * @return TvStationEntityのリスト
	 */
	@ModelAttribute
	public List<TvStation> getListTvStation() {
		return doramaSampleService.getListTvStation();
	}


	/**
	 * 検索画面に遷移する
	 *
	 * @param DoramaSampleSearchForm doramaSampleSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchDorama(@ModelAttribute final DoramaSampleSearchForm doramaSampleSearchForm) {
		return "doramasample/search";
	}


	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param DoramaSampleSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchDorama(final DoramaSampleSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<DoramaMain> doramaList = doramaSampleService.getPageDorama(form,  pageable);
		if (doramaList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", doramaList);
			model.addAttribute("doramaList", doramaList.getContent());
			model.addAttribute("url", "search");
		}
		return "doramasample/search";
	}


	/**
	 * 追加画面に遷移する
	 *
	 * @param DoramaSampleInputForm doramaSampleInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertDorama(@ModelAttribute final DoramaSampleInputForm doramaSampleInputForm) {
		return "doramasample/insert";
	}

	/**
	 * DoramaMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param DoramaSampleInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertDorama(@ModelAttribute @Validated final DoramaSampleInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "doramasample/insert";
		}

		// データを登録する
		final DoramaMain doramaMain = doramaSampleService.insertDorama(form);
		return "redirect:/doramasample?result=insert&id=" + doramaMain.getId();
	}


	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param DoramaSampleInputForm doramaSampleInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateDorama(@RequestParam(name = "id") final long id,
			@ModelAttribute final DoramaSampleInputForm doramaSampleInputForm) {

		// IDをキーにDoramaMainテーブルを検索する
		DoramaMain doramaMain = doramaSampleService.getDorama(id);

		// フォームにレコードの値をセットする
		doramaSampleInputForm.initWithdoramaMain(doramaMain);
		return "doramasample/update";
	}

	/**
	 * DoramaMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param DoramaSampleInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateDorama(@Validated final DoramaSampleInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "doramasample/update";
		}

		// データを更新する
		DoramaMain doramaMain = doramaSampleService.updateDorama(form);
		if (doramaMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/doramasample?result=updatefailed";
		}
		return "redirect:/doramasample?result=update&id=" + doramaMain.getId();
	}


	/**
	 * DoramaMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteDorama(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		doramaSampleService.deleteDoramaById(id);
		return "redirect:/doramasample?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param DoramaSampleSearchForm form
	 * @param DoramaSampleDeleteForm doramaSampleDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompDorama(final DoramaSampleSearchForm form,
			@ModelAttribute final DoramaSampleDeleteForm doramaSampleDeleteForm, final Model model) {

		// DoramaMainテーブルから削除フラグが1のレコードを検索する
		final List<DoramaMain> doramaList = doramaSampleService.getListDorama(form);

		// Modelに検索結果を格納する
		model.addAttribute(doramaList);
		return "doramasample/deletecomp";
	}


	/**
	 * DoramaMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param DoramaSampleDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompDorama(@Validated final DoramaSampleDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			DoramaSampleSearchForm doramaSampleSearchForm = new DoramaSampleSearchForm();
			doramaSampleSearchForm.setIsDelete(1);
			final List<DoramaMain> doramaList = doramaSampleService.getListDorama(doramaSampleSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(doramaList);
			return "doramasample/deletecomp";
		}

		// データを完全削除する
		doramaSampleService.deleteDoramaComp(form.getDeleteIds());
		return "redirect:/doramasample?result=deletecomp";
	}

}