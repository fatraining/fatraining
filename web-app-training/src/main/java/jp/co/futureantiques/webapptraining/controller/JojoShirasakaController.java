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

import jp.co.futureantiques.webapptraining.model.form.jojoShirasaka.JojoStandSearchForm;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoAppearanceShirasaka;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoMainShirasaka;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoSexShirasaka;
import jp.co.futureantiques.webapptraining.service.JojoShirasakaService;



/**
 * Jojoのコントローラークラス
 * @author user
 *
 */
@Controller
@RequestMapping(value = "/jojoshirasaka")
public class JojoShirasakaController {

	/** ジョジョ検索のサービス */
	private final JojoShirasakaService jojoShirasakaService;

	/** コンストラクタ */
	/**
	 * @param jojoShirasakaService
	 */
	@Autowired
	public JojoShirasakaController(final JojoShirasakaService jojoShirasakaService) {
		this.jojoShirasakaService = jojoShirasakaService;
	}

	/** 性別エンティティのリストを取得する */
	@ModelAttribute
	public List<JojoSexShirasaka> getListGenre() {
		return jojoShirasakaService.getListJojoSex();
	}

	/** 登場部エンティティのリストを取得する */
	@ModelAttribute
	public List<JojoAppearanceShirasaka> getListMovieActor() {
		return jojoShirasakaService.getListJojoAppearance();
	}

	/** 検索画面に遷移する
	 * @param jojoStandSearchForm
	 * @return String
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchJojo(@ModelAttribute final JojoStandSearchForm jojoStandSearchForm) {
		return "jojoshirasaka/search";
	}

	/** 検索結果を取得して検索画面に遷移する */
	/**
	 * @param form
	 * @param model
	 * @param pageable
	 * @return String
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchJojo(final JojoStandSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<JojoMainShirasaka> jojoList = jojoShirasakaService.getPageJojo(form, pageable);
		if (jojoList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", jojoList);
			model.addAttribute("jojoList", jojoList.getContent());
			model.addAttribute("url", "search");
		}
		return "jojoshirasaka/search";
	}
}
