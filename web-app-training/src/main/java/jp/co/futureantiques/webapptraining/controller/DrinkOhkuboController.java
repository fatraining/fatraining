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

import jp.co.futureantiques.webapptraining.model.drinkOhkubo.Container_Ohkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.DrinkMain_Ohkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.Maker_Ohkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.Type_Ohkubo;
import jp.co.futureantiques.webapptraining.model.form.drinkOhkubo.DrinkSearch_Ohkubo;
import jp.co.futureantiques.webapptraining.service.DrinkService_Ohkubo;

@Controller
@RequestMapping(value="/drink_ohkubo")
public class DrinkOhkuboController {
	//飲み物のサービス
	private final DrinkService_Ohkubo drinkService;

	/**
	 * コンストラクタ
	 *
	 * @param DrinkService_Ohkubo drinkService
	 */

	@Autowired
	public DrinkOhkuboController(final DrinkService_Ohkubo drinkService) {
		this.drinkService = drinkService;
	}

	/**
	 * メーカーエンティティのリストを取得する
	 *
	 * @return MakerEntityのリスト
	 */
	@ModelAttribute
	public List<Maker_Ohkubo> getListMaker() {
		return drinkService.getListMaker();
	}

	/**
	 * 種類エンティティのリストを取得する
	 *
	 * @return TypeEntityのリスト
	 */
	@ModelAttribute
	public List<Type_Ohkubo> getListType() {
		return drinkService.getListType();
	}

	/**
	 * 容器エンティティのリストを取得する
	 *
	 * @return ContainerEntityのリスト
	 */
	@ModelAttribute
	public List<Container_Ohkubo> getListContainer() {
		return drinkService.getListContainer();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param DrinkSearch_Ohkubo DrinkSearch_Ohkubo
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchDrink(@ModelAttribute final DrinkSearch_Ohkubo drinkSearch_Ohkubo) {
		return "drink/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param DrinkSearch_Ohkubo form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */

	public String searchDrink(final DrinkSearch_Ohkubo form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<DrinkMain_Ohkubo> drinkList = drinkService.getPageDrink(form, pageable);
		if (drinkList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", drinkList);
			model.addAttribute("drinkList", drinkList.getContent());
			model.addAttribute("url", "search");
		}
		return "drink/search";
	}
}
