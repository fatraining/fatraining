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

import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.CompanyFujimoto;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.GuiterMainFujimoto;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.WoodFujimoto;
import jp.co.futureantiques.webapptraining.model.form.guiterFujimoto.GuiterSearchForm;
import jp.co.futureantiques.webapptraining.service.GuiterFujimotoService;

/**
 * guiter_main_fujimotoのコントローラークラス
 *
 * @author FUJIMOTO YOSHIHISA
 */
@Controller
@RequestMapping(value = "/guiterfujimoto")
public class GuiterFujimotoController {

	/**名前のサービス
	*/
	private final GuiterFujimotoService guiterFujimotoService;

	/**コンストラクタ
	*
	*@param GuiterFujimotoService guiterFujimotoService
	*/
	@Autowired
	public GuiterFujimotoController(final GuiterFujimotoService guiterFujimotoService) {
		this.guiterFujimotoService = guiterFujimotoService;
	}

	/**
	 * 会社エンティティのリストを取得する
	 *
	 * @return CompanyEntityのリスト
	 */
	@ModelAttribute
	public List<CompanyFujimoto> getListCompanyFujimoto() {
		return guiterFujimotoService.getListCompanyFujimoto();
	}

	/**
	 * 木材エンティティのリストを取得する
	 *
	 * @return WoodEntityのリスト
	 */
	@ModelAttribute
	public List<WoodFujimoto> getLIstWoodFujimoto() {
		return guiterFujimotoService.getListWoodFujimoto();
	}

	/**
	 * 検索画面に遷移する
	 * @param GuiterSearchForm guiterSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchGuiter(@ModelAttribute final GuiterSearchForm guiterSearchForm) {
		return "guiterFujimoto/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 * @param GuiterSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchGuiter(
			final GuiterSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を基にレコードを取得する
		final Page<GuiterMainFujimoto> guiterList = guiterFujimotoService.getPageGuiter(form, pageable);
		if (guiterList.getTotalElements() != 0) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", guiterList);
			model.addAttribute("guiterList", guiterList.getContent());
			model.addAttribute("url", "search");
		}
		return "guiterfujimoto/search";
	}

}
