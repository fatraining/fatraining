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
import jp.co.futureantiques.webapptraining.model.form.mangaKawada.MangaKawadaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.mangaKawada.MangaKawadaInputForm;
import jp.co.futureantiques.webapptraining.model.form.mangaKawada.MangaKawadaSearchForm;
import jp.co.futureantiques.webapptraining.model.mangaKawada.AnimeKawada;
import jp.co.futureantiques.webapptraining.model.mangaKawada.GenreKawada;
import jp.co.futureantiques.webapptraining.model.mangaKawada.MangaMainKawada;
import jp.co.futureantiques.webapptraining.model.mangaKawada.SituationKawada;
import jp.co.futureantiques.webapptraining.service.MangaKawadaService;

/**
 * MangaKawadaのコントローラークラス
 *
 * @author Kawada
 */
@Controller
@RequestMapping(value = "/mangaKawada")
public class MangaKawadaController {
	/** 漫画のサービス */
	private final MangaKawadaService mangaKawadaService;

	/**
	 * コンストラクタ
	 *
	 * @param MangaKawadaService mangaKawadaService
	 */
	@Autowired
	public MangaKawadaController(final MangaKawadaService mangaKawadaService) {
		this.mangaKawadaService = mangaKawadaService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreKawadaEntityのリスト
	 */
	@ModelAttribute
	public List<GenreKawada> getListGenreKawada() {
		return mangaKawadaService.getListGenreKawada();
	}

	/**
	 * アニメ化エンティティのリストを取得する
	 *
	 * @return AnimeKawadaEntityのリスト
	 */
	@ModelAttribute
	public List<AnimeKawada> getListAnimeKawada() {
		return mangaKawadaService.getListAnimeKawada();
	}

	/**
	 * 連載状況エンティティのリストを取得する
	 *
	 * @return SituationKawadaEntityのリスト
	 */
	@ModelAttribute
	public List<SituationKawada> getListSituationKawada() {
		return mangaKawadaService.getListSituationKawada();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param MangaKawadaSearchForm mangaKawadaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchManga(@ModelAttribute final MangaKawadaSearchForm mangaKawadaSearchForm) {
		return "mangaKawada/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param MangaKawadaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchManga(final MangaKawadaSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<MangaMainKawada> mangaKawadaList = mangaKawadaService.getPageManga(form, pageable);
		if (mangaKawadaList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", mangaKawadaList);
			model.addAttribute("mangaKawadaList", mangaKawadaList.getContent());
			model.addAttribute("url", "search");
		}
		return "mangaKawada/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param MangaKawadaInputForm mangaKawadaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertManga(@ModelAttribute final MangaKawadaInputForm mangaKawadaInputForm) {
		return "mangaKawada/insert";
	}

	/**
	 * MovieMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MangaKawadaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertManga(@ModelAttribute @Validated final MangaKawadaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "mangaKawada/insert";
		}

		// データを登録する
		final MangaMainKawada mangaMainKawada = mangaKawadaService.insertManga(form);
		return "redirect:/mangaKawada?result=insert&id=" + mangaMainKawada.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param MangaKawadaInputForm mangaKawadaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateManga(@RequestParam(name = "id") final long id,
			@ModelAttribute final MangaKawadaInputForm mangaKawadaInputForm) {

		// IDをキーにMovieMainテーブルを検索する
		MangaMainKawada mangaMainKawada = mangaKawadaService.getManga(id);

		// フォームにレコードの値をセットする
		mangaKawadaInputForm.initWithMangaMainKawada(mangaMainKawada);
		return "mangaKawada/update";
	}

	/**
	 * MangaMainKawadaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param MangaKawadaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateManga(@Validated final MangaKawadaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "mangaKawada/update";
		}

		// データを更新する
		MangaMainKawada mangaMainKawada = mangaKawadaService.updateManga(form);
		if (mangaMainKawada == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/mangaKawada?result=updatefailed";
		}
		return "redirect:/mangaKawada?result=update&id=" + mangaMainKawada.getId();
	}

	/**
	 * MangaMainKawadaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteManga(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		mangaKawadaService.deleteMangaKawadaById(id);
		return "redirect:/mangaKawada?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param MangaKawadaSearchForm form
	 * @param MangaKawadaDeleteForm mangaKawadaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompManga(final MangaKawadaSearchForm form,
			@ModelAttribute final MangaKawadaDeleteForm mangaKawadaDeleteForm, final Model model) {

		// MovieMainテーブルから削除フラグが1のレコードを検索する
		final List<MangaMainKawada> mangaKawadaList = mangaKawadaService.getListMangaMainKawada(form);

		// Modelに検索結果を格納する
		model.addAttribute(mangaKawadaList);
		return "mangaKawada/deletecomp";
	}

	/**
	 * MangaMainKawadaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param MangaKawadaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompManga(@Validated final MangaKawadaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			MangaKawadaSearchForm mangaKawadaSearchForm = new MangaKawadaSearchForm();
			mangaKawadaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<MangaMainKawada> mangaKawadaList = mangaKawadaService
					.getListMangaMainKawada(mangaKawadaSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(mangaKawadaList);
			return "mangaKawada/deletecomp";
		}

		// データを完全削除する
		mangaKawadaService.deleteMangaKawadaComp(form.getDeleteIds());
		return "redirect:/mangaKawada?result=deletecomp";
	}
}
