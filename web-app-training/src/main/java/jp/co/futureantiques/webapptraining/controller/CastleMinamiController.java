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

import jp.co.futureantiques.webapptraining.model.castleMinami.CastleMainMinami;
import jp.co.futureantiques.webapptraining.model.castleMinami.PrefectureMinami;
import jp.co.futureantiques.webapptraining.model.castleMinami.TenshuMinami;
import jp.co.futureantiques.webapptraining.model.form.castleMinami.CastleSearchForm;
import jp.co.futureantiques.webapptraining.service.CastleMinamiService;

/**
 * CastleMinamiのコントローラークラス
 *
 * @author  Minami
 *
 */
@Controller
@RequestMapping(value = "/castleminami")
public class CastleMinamiController {

	/** お城のサービス */
	private final CastleMinamiService castleMinamiService;

	/**
	 * コンストラクタ
	 *
	 * @param CastleMinamiService castleMinamiService
	 */
	@Autowired
	public CastleMinamiController(final CastleMinamiService castleMinamiService) {
		this.castleMinamiService = castleMinamiService;
	}

	/**
	 * 所在地エンティティのリストを取得する
	 *
	 * @return PrefectureEntityのリスト
	 */
	@ModelAttribute
	public List<PrefectureMinami> getListPrefectureMinami() {
		return castleMinamiService.getListPrefectureMinami();
	}


	/**
	 * 天守エンティティのリストを取得する
	 *
	 * @return TenshuEntityのリスト
	 */
	@ModelAttribute
	public List<TenshuMinami> getListTenshuMinami(){
		return castleMinamiService.getListTenshuMinami();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param CastleSearchForm castleSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchCastle(@ModelAttribute final CastleSearchForm castleSearchForm) {
		return "castleminami/search";
	}

	/**
	 * 検索画面を取得して検索画面に遷移する
	 *
	 * @param CastleSearchForm form
	 * @param Castle model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchCastle(final CastleSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<CastleMainMinami> castleList = castleMinamiService.getPageCastle(form, pageable);
		if(castleList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", castleList);
			model.addAttribute("castleList", castleList.getContent());
			model.addAttribute("url", "search");
		}
		return "castleminami/search";
	}

	/**
	 * CastleMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCastle(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		castleMinamiService.deleteCastleById(id);
		return "redirect:/castle?result=delete&id" + id;
	}
}
