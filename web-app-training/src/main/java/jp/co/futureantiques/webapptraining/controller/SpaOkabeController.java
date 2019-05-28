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

import jp.co.futureantiques.webapptraining.model.form.spaOkabe.SpaOkabeSearchForm;
import jp.co.futureantiques.webapptraining.model.spaOkabe.AreaOkabe;
import jp.co.futureantiques.webapptraining.model.spaOkabe.QualityOkabe;
import jp.co.futureantiques.webapptraining.model.spaOkabe.SpaMainOkabe;
import jp.co.futureantiques.webapptraining.service.SpaOkabeService;

/**
 * SpaOkabeのコントローラークラス
 *
 * @author SEIYA OKABE
 */
@Controller
@RequestMapping(value = "/spaOkabe")

public class SpaOkabeController {

	/** 温泉地のサービス */
	private final SpaOkabeService spaOkabeService;

	/**
	 * コンストラクタ
	 *
	 * @param SpaOkabeService spaOkabeService
	 */
	@Autowired
	public SpaOkabeController(final SpaOkabeService spaOkabeService) {
		this.spaOkabeService = spaOkabeService;
	}

	/**
	 * 都道府県エンティティのリストを取得する
	 *
	 * @return AreaOkabeEntityのリスト
	 */
	@ModelAttribute
	public List<AreaOkabe> getListAreaOkabe() {
		return spaOkabeService.getListAreaOkabe();
	}

	/**
	 * 泉質エンティティのリストを取得する
	 *
	 * @return QualityOkabeEntityのリスト
	 */
	@ModelAttribute
	public List<QualityOkabe> getListQualityOkabe() {
		return spaOkabeService.getListQualityOkabe();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param SpaOkabeSearchForm spaOkabeSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchSpaOkabe(@ModelAttribute final SpaOkabeSearchForm spaOkabeSearchForm) {
		return "spaOkabe/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param SpaOkabeSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchSpaOkabe(final SpaOkabeSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<SpaMainOkabe> spaOkabeList = spaOkabeService.getPageSpa(form, pageable);
		if (spaOkabeList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", spaOkabeList);
			model.addAttribute("spaOkabeList", spaOkabeList.getContent());
			model.addAttribute("url", "search");
		}
		return "spaOkabe/search";

	}
}
