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
import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.ClassTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.CountryTiba;
import jp.co.futureantiques.webapptraining.model.form.championTiba.ChampionTibaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.championTiba.ChampionTibaInputForm;
import jp.co.futureantiques.webapptraining.model.form.championTiba.ChampionTibaSearchForm;
import jp.co.futureantiques.webapptraining.service.ChampionTibaService;

/**
 * ChampionTibaのコントローラークラス
 * @author future
 *
 */
@Controller
@RequestMapping(value = "/championtiba")
public class ChampionTibaController {

	/** チャンピオンのサービス*/
	private final ChampionTibaService championTibaService;

	/**
	 * コンストラクタ
	 *
	 * @param ChampiontibaService bandTaneichiService
	 */
	@Autowired
	public ChampionTibaController(final ChampionTibaService championTibaService) {
		this.championTibaService = championTibaService;
	}

	/**
	 * チャンピオン階級エンティティのリストを取得する
	 *
	 * @return ClassTibaEntityのリスト
	 */
	@ModelAttribute
	public List<ClassTiba> getListClass() {
		return championTibaService.getListClass();
	}

	/**
	 * 国名エンティティのリストを取得
	 *
	 * @return CountryTibaEntityのリスト
	 */
	@ModelAttribute
	public List<CountryTiba> getListCountry() {
		return championTibaService.getListCountry();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param ChampionTibaSearchForm bandTaneichiSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchChampion(@ModelAttribute final ChampionTibaSearchForm championTibaSearchForm) {
		return "championtiba/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param ChampionTibaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String showSearchTiba(final ChampionTibaSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<ChampionMainTiba> championList = championTibaService.getPageChampion(form, pageable);
		if (championList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", championList);
			model.addAttribute("championList", championList.getContent());
			model.addAttribute("url", "search");
		}
		return "championtiba/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param ChampionTibaInputForm championTibaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertChampion(@ModelAttribute final ChampionTibaInputForm championTibaInputForm) {
		return "championtiba/insert";
	}

	/**
	 * ChampionMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param ChampionTibaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertChampion(@ModelAttribute @Validated final ChampionTibaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーが有る場合自画面に戻る
			return "championTiba/insert";
		}

		// データを登録する
		final ChampionMainTiba championMainTiba = championTibaService.insertChampion(form);
		return "redirect:/championtiba?result=insert&id=" + championMainTiba.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param ChampionTibaInputForm championTibaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateChampion(@RequestParam(name = "id") final long id,
			@ModelAttribute final ChampionTibaInputForm championTibaInputForm) {

		// IDをキーにBandMainTaneichiテーブルを検索する
		ChampionMainTiba championMainTiba = championTibaService.getChampion(id);

		// フォームにレコードの値をセットする
		championTibaInputForm.initWithChampionMainTiba(championMainTiba);
		return "championTiba/update";
	}

	/**
	 * ChampionMainTibaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param ChampionTibaInputForm form
	 * @param Bindingresult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateChampion(@Validated final ChampionTibaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//  入力エラーが有る場合自画面に戻る
			return "championtiba/update";
		}

		// データを更新する
		ChampionMainTiba championMainTiba = championTibaService.updatePlayerChampion(form);
		if (championMainTiba == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/championtiba?result=updatefailed";
		}
		return "redirect:/championtiba?result=update&id=" + championMainTiba.getId();

	}
	//論理削除↓
	/**
	 * ChampionMainTibaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteChampion(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		championTibaService.deleteChampionById(id);
		return "redirect:/championtiba?result=delete&id=" + id;
	}
	/**
	 * 完全削除画面に遷移する
	 *
	 * @param ChampionTibaSearchForm form
	 * @param ChamopionTibaDeleteForm bandTaneichiDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompChampion(final ChampionTibaSearchForm form,
			@ModelAttribute final ChampionTibaDeleteForm chamopionTibaDeleteForm, final Model model) {

		// ChampionMainTibaテーブルから削除フラグが１のレコードを検索する
		final List<ChampionMainTiba> championList = championTibaService.getListChampion(form);

		// Modelに検索結果を格納する
		model.addAttribute(championList);
		return "championtiba/deletecomp";
	}

	/**
	 * ChampionMainTibaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param ChampionTibaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompChampion(@Validated final ChampionTibaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーが有る場合、再検索して自画面に戻る
			ChampionTibaSearchForm championTibaSearchForm = new ChampionTibaSearchForm();
			championTibaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<ChampionMainTiba> championList = championTibaService.getListChampion(championTibaSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(championList);
			return "championTiba/deletecomp";
		}

		// データを完全削除する
		championTibaService.deleteComp(form.getDeleteIds());
		return "redirect:/championtibai?result=deletecomp";
	}
}



