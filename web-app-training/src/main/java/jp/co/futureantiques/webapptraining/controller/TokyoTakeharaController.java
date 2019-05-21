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

import jp.co.futureantiques.webapptraining.model.form.tokyoTakehara.TokyoTakeharaSearchForm;
import jp.co.futureantiques.webapptraining.model.tokyoTakehara.LocationTakehara;
import jp.co.futureantiques.webapptraining.model.tokyoTakehara.TokyoMainTakehara;
import jp.co.futureantiques.webapptraining.service.TokyoTakeharaService;

/**
 * TokyoTakeharaのコントローラークラス
 *
 */
@Controller
@RequestMapping(value = "/tokyotakehara")
public class TokyoTakeharaController {

	/** TokyoTakearaのサービス */
	private final TokyoTakeharaService tokyoTakeharaService;

	/**
	 * コンストラクタ
	 *
	 * @param TokyoTakeharaService tokyoTakeharaService
	 */
	@Autowired
	public TokyoTakeharaController(final TokyoTakeharaService tokyoTakeharaService) {
		this.tokyoTakeharaService = tokyoTakeharaService;
	}

	/**
	 * 所在地域エンティティのリストを取得する
	 *
	 * @return LocationTakehara Entityのリスト
	 */
	@ModelAttribute
	public List<LocationTakehara> getListLocationTakehara() {
		return tokyoTakeharaService.getListLocation();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param TokyoTakeharaSearchForm tokyoTakeharaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchTokyo(@ModelAttribute final TokyoTakeharaSearchForm tokyoTakeharaSearchForm) {
		return "tokyotakehara/searchDisp";
	}
	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param TokyoTakeharaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchWards(final TokyoTakeharaSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<TokyoMainTakehara> wardsList = tokyoTakeharaService.getPageWards(form, pageable);
		if (wardsList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", wardsList);
			model.addAttribute("wardsList", wardsList.getContent());
			model.addAttribute("url", "search");
		}
		return "tokyotakehara/searchDisp";
	}

	/**
	 * TokyoMainTakeharaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param int id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteWard(@RequestParam(name = "id") final int id) {

		// IDをキーにレコードを論理削除する
		tokyoTakeharaService.deleteWardById(id);
		return "redirect:/tokyotakehara?result=delete&id=" + id;
	}

}
