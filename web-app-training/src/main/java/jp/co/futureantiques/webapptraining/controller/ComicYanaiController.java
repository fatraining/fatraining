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
import jp.co.futureantiques.webapptraining.model.comicYanai.ComicMainYanai;
import jp.co.futureantiques.webapptraining.model.comicYanai.GenreYanai;
import jp.co.futureantiques.webapptraining.model.comicYanai.PubcoYanai;
import jp.co.futureantiques.webapptraining.model.form.comicYanai.ComicYanaiDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.comicYanai.ComicYanaiInputForm;
import jp.co.futureantiques.webapptraining.model.form.comicYanai.ComicYanaiSearchForm;
import jp.co.futureantiques.webapptraining.service.ComicYanaiService;

/**
 * ComicYanaiのコントローラークラス
 *
 * @author yanai
 */
@Controller
@RequestMapping(value = "/comicYanai")
public class ComicYanaiController {

	/** 漫画のサービス */
	private ComicYanaiService comicYanaiService;

	/**DIするためのアノテーションとDIしているコンストラクタ
	 * @param ComicYanai Service comicYanaiService
	 */
	@Autowired
	public ComicYanaiController(ComicYanaiService comicYanaiService) {
		//外部からオブジェクトを注入
		this.comicYanaiService = comicYanaiService;
	}

	/**ジャンルのエンティティリストを取得する
	 * @return GenreYanaiのリスト
	 */
	@ModelAttribute
	public List<GenreYanai> getListGenre() {
		return comicYanaiService.getListGenre();
	}

	/**出版社のエンティティリストを取得
	 * @return PubcoYanaiのリスト
	 */
	@ModelAttribute
	public List<PubcoYanai> getListPubco() {
		return comicYanaiService.getListPubco();
	}

	/**検索結果画面へ遷移する。
	 *
	 * @param ComicSerchForm comicYanaiSerchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchComicYanai(@ModelAttribute final ComicYanaiSearchForm comicYanaiSerchForm) {
		return "comicYanai/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param ComicYaanaiSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchComic(final ComicYanaiSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<ComicMainYanai> comicList = comicYanaiService.getPageComic(form, pageable);
		if (comicList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", comicList);
			model.addAttribute("comicList", comicList.getContent());
			model.addAttribute("url", "search");
		}
		return "comicYanai/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param ComicYanaiInputForm comicYanaiInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertComic(@ModelAttribute final ComicYanaiInputForm comicYanaiInputForm) {
		return "comicYanai/insert";
	}

	/**
	 * ComicMainYanaiテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param ComicYanaiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertComic(@ModelAttribute @Validated final ComicYanaiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "comicYanai/insert";
		}

		// データを登録する
		final ComicMainYanai comicMainYanai = comicYanaiService.insertComic(form);
		return "redirect:/comicYanai?result=insert&id=" + comicMainYanai.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param ComicYanaiInputForm comicYanaiInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateComic(@RequestParam(name = "id") final long id,
			@ModelAttribute final ComicYanaiInputForm comicYanaiInputForm) {

		// IDをキーにComicMainYanaiテーブルを検索する
		ComicMainYanai comicMainYanai = comicYanaiService.getComic(id);

		// フォームにレコードの値をセットする
		comicYanaiInputForm.initWithComicMainYanai(comicMainYanai);
		return "comicYanai/update";
	}

	/**
	 * CiomicMainYanaiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param ComicYanaiInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateComic(@Validated final ComicYanaiInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "comicYanai/update";
		}

		// データを更新する
		ComicMainYanai comicMainYanai = comicYanaiService.updateComic(form);
		if (comicMainYanai == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/comicYanai?result=updatefailed";
		}
		return "redirect:/comicYanai?result=update&id=" + comicMainYanai.getId();
	}

	/**
	 * ComicMainYanaiテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteComic(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		comicYanaiService.deleteComicById(id);
		return "redirect:/comicYanai?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param ComicYanaiSearchForm form
	 * @param comicYanaiDeleteForm comicYanaiDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompComic(final ComicYanaiSearchForm form,
			@ModelAttribute final ComicYanaiDeleteForm comicYanaiDeleteForm, final Model model) {

		// ComicMainYanaiテーブルから削除フラグが1のレコードを検索する
		final List<ComicMainYanai> comicList = comicYanaiService.getListComic(form);

		// Modelに検索結果を格納する
		model.addAttribute(comicList);
		return "comicYanai/deletecomp";
	}

	/**
	 * ComicMainYanaiテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param ComicYanaiDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompComic(@Validated ComicYanaiDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			ComicYanaiSearchForm comicYanaiSearchForm = new ComicYanaiSearchForm();
			comicYanaiSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<ComicMainYanai> comicList = comicYanaiService.getListComic(comicYanaiSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(comicList);
			return "comicYanai/deletecomp";
		}

		// データを完全削除する
		comicYanaiService.deleteComicComp(form.getDeleteIds());
		return "redirect:/comicYanai?result=deletecomp";
	}
}
