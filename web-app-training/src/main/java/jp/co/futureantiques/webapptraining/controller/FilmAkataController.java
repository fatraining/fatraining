package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.filmAkata.FilmActorAkata;
import jp.co.futureantiques.webapptraining.model.filmAkata.FilmGenreAkata;
import jp.co.futureantiques.webapptraining.model.filmAkata.FilmMainAkata;
import jp.co.futureantiques.webapptraining.model.form.filmAkata.FilmAkataDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.filmAkata.FilmAkataInputForm;
import jp.co.futureantiques.webapptraining.model.form.filmAkata.FilmAkataSearchForm;
import jp.co.futureantiques.webapptraining.service.FilmAkataService;

/**
 * FilmAkataのコントローラークラス
 *
 * @author future
 */

@Controller
@RequestMapping(value = "/filmakata")
public class FilmAkataController {

	/** フィルモグラフィーのサービス */
	private final FilmAkataService filmAkataService;

	/**
	 * コンストラクタ
	 *
	 * @param FilmAkataService movieAkataService
	 */
	@Autowired
	public FilmAkataController (final FilmAkataService filmAkataService) {
		this.filmAkataService = filmAkataService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<FilmGenreAkata> getListFilmGenreAkata() {
		return filmAkataService.getListFilmGenreAkata();
	}

	/**
	 * 主演エンティティのリストを取得する
	 *
	 * @return FilmActorEntityのリスト
	 */
	@ModelAttribute
	public List<FilmActorAkata> getListFilmActorAkata() {
		return filmAkataService.getListFilmActorAkata();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param FilmAkataSearchForm filmAkataSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchFilm(@ModelAttribute final FilmAkataSearchForm filmAkataSearchForm) {
		return "filmakata/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *s
	 * @param FilmAkataSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchFilmAkata(final FilmAkataSearchForm form, final Model model,
				final @PageableDefault(page = 0, value = 1 ) Pageable pageable) {

		//入力された検索条件を元にレコードを取得する
		final Page<FilmMainAkata> filmMainAkata = filmAkataService.getPageFilm(form, pageable);
		if(filmMainAkata.getTotalElements() != 0 ) {

			//検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", filmMainAkata);
			model.addAttribute("filmAkataList", filmMainAkata.getContent());
			model.addAttribute("url", "search" );
		}
		return "filmakata/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param FilmAkataInputForm filmAkataInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertFilm(@ModelAttribute final FilmAkataInputForm filmAkataInputForm) {
		return "filmakata/insert";
	}

	/**
	 * FilmMainAkataテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param FilmAkataInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertFilm(@ModelAttribute @Validated final FilmAkataInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "filmakata/insert";
		}

		//データを登録する
		final FilmMainAkata filmMainAkata = filmAkataService.insertFilm(form);
		return "redirect:/filmakata?result=insert&id=" + filmMainAkata.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param FilmAkataInputForm filmAkataInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping (value = "update", method = RequestMethod.GET)
	public String showUpdateFilm(@RequestParam(name = "id")final long id,
			@ModelAttribute final FilmAkataInputForm filmAkataInputForm) {

		//IDをキーにFilmテーブルを検索する
		FilmMainAkata filmMainAkata = filmAkataService.getFilm(id);

		//フォームにレコードの値をセットする
		filmAkataInputForm.initWithFilmMainAkata(filmMainAkata);
		return "filmakata/update";
	}

	/**
	 * FilmMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param FilmAkataInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateFilm(@Validated final FilmAkataInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//入力エラーがある場合自画面に戻る
			return "filmakata/update";
		}

		//データを更新する
		FilmMainAkata filmMainAkata = filmAkataService.updateFilm(form);
		if (filmMainAkata == null) {

			//更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/filmakata?result=updatefailed";
		}
		return "redirect:/filmakata?result=update&id=" + filmMainAkata.getId();
	}

	/**
	 * FilmMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteFilm(@RequestParam(name = "id") final long id) {

		//IDをキーにレコードを論理削除する
		filmAkataService.deleteFilmById(id);
		return "redirect:/filmakata?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param FilmAkataSerahForm form
	 * @param FilmAkataDeleteForm filmAkataDeketeForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */

	@RequestMapping (value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompFilm(final FilmAkataSearchForm form,
			@ModelAttribute final FilmAkataDeleteForm filmAkataDeleteForm, final Model model) {

		//FilmMainテーブルから削除フラグが1のレコードを検索する
		final List<FilmMainAkata> filmList = filmAkataService.getListFilm(form);

		//Modelに検索結果を格納する
		model.addAttribute(filmList);
		return "filmakata/deletecomp";
	}

	/**
	 * FilmMainAkataテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param FilmAkataDeketeForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompFilm(@Validated final FilmAkataDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {


			//入力エラーがある場合、再検索して自画面に戻る
			FilmAkataSearchForm filmAkataSearchForm = new FilmAkataSearchForm();
			filmAkataSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<FilmMainAkata> filmList = filmAkataService.getListFilm(filmAkataSearchForm);


		//Modelに検索結果を格納する
		model.addAttribute(filmList);
		return "filmakata/deletcomp";
	}

	//データを完全削除する
	filmAkataService.deleteFilmComp(form.getDeleteIds());
	return "redirect:/filmakata?reult=deletecomp";
}
}
