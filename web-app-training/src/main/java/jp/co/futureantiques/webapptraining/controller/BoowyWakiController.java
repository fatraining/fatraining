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
import jp.co.futureantiques.webapptraining.model.boowyWaki.BoowyMainWaki;
import jp.co.futureantiques.webapptraining.model.boowyWaki.GenreWaki;
import jp.co.futureantiques.webapptraining.model.boowyWaki.SongwriterWaki;
import jp.co.futureantiques.webapptraining.model.form.boowyWaki.BoowyWakiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.boowyWaki.BoowyWakiInputForm;
import jp.co.futureantiques.webapptraining.model.form.boowyWaki.BoowyWakiSearchForm;
import jp.co.futureantiques.webapptraining.service.BoowyWakiService;

/**
 * BoowyMainWakiのコントローラークラス
 *
 * @author WAKI
 */
@Controller
@RequestMapping(value = "/boowywaki")
public class BoowyWakiController {

	/** BOØWYの曲のサービス */
	private final BoowyWakiService boowyWakiService;

	/**
	 * コンストラクタ
	 *
	 * @param BoowyWakiService boowyWakiService
	 */
	@Autowired
	public BoowyWakiController(final BoowyWakiService boowyWakiService) {
		this.boowyWakiService = boowyWakiService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<GenreWaki> getListGenreWaki() {
		return boowyWakiService.getListGenreWaki();
	}

	/**
	 * 作詞者エンティティのリストを取得する
	 *
	 * @return SongwriterEntityのリスト
	 */
	@ModelAttribute
	public List<SongwriterWaki> getListSongwriterWaki() {
		return boowyWakiService.getListSongwriterWaki();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param BoowyWakiSearchForm boowyWakiSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchBoowy(@ModelAttribute final BoowyWakiSearchForm boowyWakiSearchForm) {
		return "boowywaki/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param BoowyWakiSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchBoowy(final BoowyWakiSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<BoowyMainWaki> boowyList = boowyWakiService.getPageBoowyMainWaki(form, pageable);
		if (boowyList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", boowyList);
			model.addAttribute("boowyList", boowyList.getContent());
			model.addAttribute("url", "search");
		}
		return "boowywaki/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param BoowyWakiInputForm boowyWakiInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertBoowy(@ModelAttribute final BoowyWakiInputForm boowyWakiInputForm) {
		return "boowywaki/insert";
	}

	/**
	 * BoowyMainWakiテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param BoowyWakiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertBoowy(@ModelAttribute @Validated final BoowyWakiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "boowywaki/insert";
		}

		// データを登録する
		final BoowyMainWaki boowyMainWaki = boowyWakiService.insertBoowyMainWaki(form);
		return "redirect:/boowywaki?result=insert&id=" + boowyMainWaki.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param BoowyWakiInputForm boowyWakiInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateBoowy(@RequestParam(name = "id") final long id,
			@ModelAttribute final BoowyWakiInputForm boowyWakiInputForm) {

		// IDをキーにMovieMainテーブルを検索する
		BoowyMainWaki boowyMainWaki = boowyWakiService.getBoowyMainWaki(id);

		// フォームにレコードの値をセットする
		boowyWakiInputForm.initWithBoowyMainWaki(boowyMainWaki);
		return "boowywaki/update";
	}

	/**
	 * BoowyMainWakiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param BoowyWakiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateBoowy(@Validated final BoowyWakiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "boowywaki/update";
		}

		// データを更新する
		BoowyMainWaki boowyMainWaki = boowyWakiService.updateBoowyMainWaki(form);
		if (boowyMainWaki == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/boowywaki?result=updatefailed";
		}
		return "redirect:/boowywaki?result=update&id=" + boowyMainWaki.getId();
	}

	/**
	 * BoowyMainWakiテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteBoowy(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		boowyWakiService.deleteBoowyMainWakiById(id);
		return "redirect:/boowywaki?result=delete&id" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param BoowyWakiSearchForm form
	 * @param BoowyWakiDeleteForm boowyWakiDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompBoowy(final BoowyWakiSearchForm form,
			@ModelAttribute final BoowyWakiDeleteForm boowyWakiDeleteForm, final Model model) {

		// MovieMainテーブルから削除フラグが1のレコードを検索する
		final List<BoowyMainWaki> boowyWakiList = boowyWakiService.getListBoowyMainWaki(form);

		// Modelに検索結果を格納する
		model.addAttribute(boowyWakiList);
		return "boowywaki/deletecomp";
	}

	/**
	 * BoowyMainWakiテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param BoowyWakiDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompBoowy(@Validated final BoowyWakiDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			BoowyWakiSearchForm boowyWakiSearchForm = new BoowyWakiSearchForm();
			boowyWakiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<BoowyMainWaki> boowyWakiList = boowyWakiService.getListBoowyMainWaki(boowyWakiSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(boowyWakiList);
			return "boowywaki/deletecomp";
		}

		// データを完全削除する
		boowyWakiService.deleteBoowyMainWakiComp(form.getDeleteIds());
		return "redirect:/boowywaki?result=deletecomp";
	}
}
