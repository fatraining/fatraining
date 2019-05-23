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
import jp.co.futureantiques.webapptraining.model.RuinsKurihara.AreaKurihara;
import jp.co.futureantiques.webapptraining.model.RuinsKurihara.GenreKurihara;
import jp.co.futureantiques.webapptraining.model.RuinsKurihara.RuinsMainKurihara;
import jp.co.futureantiques.webapptraining.model.form.RuinsKurihara.RuinsKuriharaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.RuinsKurihara.RuinsKuriharaInputForm;
import jp.co.futureantiques.webapptraining.model.form.RuinsKurihara.RuinsKuriharaSearchForm;
import jp.co.futureantiques.webapptraining.service.RuinsKuriharaService;

/**
 * RuinsKuriharaのコントローラークラス
 *
 * @author m.kurihara
 */
@Controller
@RequestMapping(value = "/ruinskurihara")
public class RuinsKuriharaController {

	/** 廃墟のサービス */
	private final RuinsKuriharaService ruinsKuriharaService;

	/**
	 * コンストラクタ
	 *
	 * @param RuinsKuriharaService ruinsKuriharaService
	 */
	@Autowired
	public RuinsKuriharaController(final RuinsKuriharaService ruinsKuriharaService) {
		this.ruinsKuriharaService = ruinsKuriharaService;
	}

	/**
	 * 種別エンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<GenreKurihara> getListGenre() {
		return ruinsKuriharaService.getListGenre();
	}

	/**
	 * 地域エンティティのリストを取得する
	 *
	 * @return AreaEntityのリスト
	 */
	@ModelAttribute
	public List<AreaKurihara> getListArea() {
		return ruinsKuriharaService.getListArea();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param RuinsKuriharaSearchForm ruinsKuriharaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchRuins(@ModelAttribute final RuinsKuriharaSearchForm ruinsKuriharaSearchForm) {
		return "ruinskurihara/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param RuinsKuriharaSearchForm form
	 * @param AreaKuriahara area
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchRuins(final RuinsKuriharaSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<RuinsMainKurihara> ruinsList = ruinsKuriharaService.getPageRuins(form, pageable);
		if (ruinsList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", ruinsList);
			model.addAttribute("ruinsList", ruinsList.getContent());
			model.addAttribute("url", "search");
		}
		return "ruinskurihara/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param RuinsKuriharaInputForm ruinsKuriharaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertRuins(@ModelAttribute final RuinsKuriharaInputForm ruinsKuriharaInputForm) {
		return "ruinskurihara/insert";
	}

	/**
	 * RuinsMainKuriharaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param RuinsKuriharaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertRuins(@ModelAttribute @Validated final RuinsKuriharaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "ruinskurihara/insert";
		}

		// データを登録する
		final RuinsMainKurihara ruinsMain = ruinsKuriharaService.insertRuins(form);
		return "redirect:/ruinskurihara?result=insert&id=" + ruinsMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param RuinsKuriharaInputForm ruinsKuriharaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateRuins(@RequestParam(name = "id") final long id,
			@ModelAttribute final RuinsKuriharaInputForm ruinsKuriharaInputForm) {

		// IDをキーにRuinsMainテーブルを検索する
		RuinsMainKurihara ruinsMain = ruinsKuriharaService.getRuins(id);

		// フォームにレコードの値をセットする
		ruinsKuriharaInputForm.initWithRuinsMain(ruinsMain);
		return "ruinskurihara/update";
	}

	/**
	 * RuinsMainKuriharaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param RuinsKuriharaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateRuins(@Validated final RuinsKuriharaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "ruinskurihara/update";
		}

		// データを更新する
		RuinsMainKurihara ruinsMain = ruinsKuriharaService.updateRuins(form);
		if (ruinsMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/ruinskurihara?result=updatefailed";
		}
		return "redirect:/ruinskurihara?result=update&id=" + ruinsMain.getId();
	}

	/**
	 * RuinsMainKuriharaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteRuins(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		ruinsKuriharaService.deleteRuinsById(id);
		return "redirect:/ruinskurihara?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param RuinsKuriharaSearchForm form
	 * @param RuinsDeleteForm ruinsKuriharaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompRuins(final RuinsKuriharaSearchForm form,
			@ModelAttribute final RuinsKuriharaDeleteForm ruinsKurihraDeleteForm, final Model model) {

		// RuinsMainテーブルから削除フラグが1のレコードを検索する
		final List<RuinsMainKurihara> ruinsList = ruinsKuriharaService.getListRuins(form);

		// Modelに検索結果を格納する
		model.addAttribute(ruinsList);
		return "ruinskurihara/deletecomp";
	}

	/**
	 * RuinsMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param RuinsDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompRuins(@Validated final RuinsKuriharaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			RuinsKuriharaSearchForm ruinsKuriharaSearchForm = new RuinsKuriharaSearchForm();
			ruinsKuriharaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<RuinsMainKurihara> ruinsList = ruinsKuriharaService.getListRuins(ruinsKuriharaSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(ruinsList);
			return "ruinskurihara/deletecomp";
		}

		// データを完全削除する
		ruinsKuriharaService.deleteRuinsComp(form.getDeleteIds());
		return "redirect:/ruinskurihara?result=deletecomp";
	}
}
