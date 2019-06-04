package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.ClassTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.CountryTiba;
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
	 * @param BandTaneichiService bandTaneichiService
	 */
	@Autowired
	public ChampionTibaController(final ChampionTibaService championTibaService) {
		this.championTibaService = championTibaService;
	}

	/**
	 * チャンピオン階級エンティティのリストを取得する
	 *
	 * @return BandSexTaneichiEntityのリスト
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



}

