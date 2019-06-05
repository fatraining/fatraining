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

import jp.co.futureantiques.webapptraining.model.form.mcuMainHayashi.CharacterSearchForm;
import jp.co.futureantiques.webapptraining.model.mcuHayashi.McuMainHayashi;
import jp.co.futureantiques.webapptraining.model.mcuHayashi.SexHayashi;
import jp.co.futureantiques.webapptraining.model.mcuHayashi.TypeHayashi;
import jp.co.futureantiques.webapptraining.service.McuMainHayashiService;

/**
	 * mcuMainHayashiのコントローラークラス
	 *
	 * @author 林 重樹
	 */
@Controller
@RequestMapping(value = "/mcuHayashi")
public class McuMainHayashiController {

	/** キャラクターのサービス */
	private final McuMainHayashiService mcuMainHayashiService;

	/**
	 * コンストラクタ
	 *
	 * @param mcuMainHayashiService mcuMainHayashiService
	 */
	@Autowired
	public McuMainHayashiController(final McuMainHayashiService mcuMainHayashiService) {
		this.mcuMainHayashiService = mcuMainHayashiService;
	}

	/**
	 * 人種のエンティティのリストを取得する
	 *
	 * @return typeEntityのリスト
	 */
	@ModelAttribute
	public List<TypeHayashi> getListTypeHayashi() {
		return mcuMainHayashiService.getListTypeHayashi();
	}

	/**
	 * 性別のエンティティのリストを取得する。
	 *
	 * @return sexEntityのリスト
	 */
	@ModelAttribute
	public List<SexHayashi> getListSexHayashi() {
		return mcuMainHayashiService.getListSexHayashi();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param CharacterSearchForm characterSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchCharacter(@ModelAttribute final CharacterSearchForm characterSearchForm) {
		return "mcuHayashi/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param CharacterSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchCharacter(final CharacterSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<McuMainHayashi> characterList = mcuMainHayashiService.getPageMcuMainHayashi(form, pageable);
		if (characterList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", characterList);
			model.addAttribute("characterList", characterList.getContent());
			model.addAttribute("url", "search");
		}
		return "mcuHayashi/search";
	}

	/*	/**
		 * 追加画面に遷移する
		 *
		 * @param MovieSampleInputForm movieSampleInputForm
		 * @return 追加画面のパス
		 */
	/*@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertMcuMainHayahsi(@ModelAttribute final characterInputForm characterInputForm) {
		return "mcuMainHayashi/insert";

	*/
	/**
	 * MovieMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MovieSampleInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	/*	@RequestMapping(value = "insert", method = RequestMethod.POST)
		public String insertMovie(@ModelAttribute @Validated final MovieSampleInputForm form,
				final BindingResult bindingResult) {
			if (bindingResult.hasFieldErrors()) {

				// 入力エラーがある場合自画面に戻る
				return "moviesample/insert";
			}

			// データを登録する
			final MovieMain movieMain = mcuMainHayashiService.insertMcuMainHayashi(form);
			return "redirect:/moviesample?result=insert&id=" + movieMain.getId();
		}*/

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param MovieSampleInputForm movieSampleInputForm
	 * @return 更新画面のパス
	 */
	/*	@RequestMapping(value = "update", method = RequestMethod.GET)
		public String showUpdateMovie(@RequestParam(name = "id") final long id,
				@ModelAttribute final MovieSampleInputForm movieSampleInputForm) {

			// IDをキーにMovieMainテーブルを検索する
			mcuMainHayashi McuMainHayashi = mcuMainHayashiService.getcharacterName(id);

			// フォームにレコードの値をセットする
			CharacterInputForm.initWithMcuMainHayashi(McuMainHayashi);
			return "moviesample/update";
	}*/

	/**
	 * McuMainHayashiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param characterInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	/*		@RequestMapping(value = "update", method = RequestMethod.POST)
			public String updateMovie(@Validated final MovieSampleInputForm form,
					final BindingResult bindingResult) {
				if (bindingResult.hasFieldErrors()) {

					// 入力エラーがある場合自画面に戻る
					return "moviesample/update";
				}

				// データを更新する
				McuMainhayashi mcuMainHayashi = McuMainHayashiService.updateCharacterName(form);
				if (mcuMainHayashi == null) {

					// 更新が失敗した場合、検索画面にメッセージを表示する
					return "redirect:/mcumainhayashi?result=updatefailed";
				}
				return "redirect:/mcumainhayashi?result=update&id=" + mcuMainHayashi.getId();
	}	*/

	/**
	 * MovieMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	/*	@RequestMapping(value = "delete", method = RequestMethod.GET)
		public String deleteMovie(@RequestParam(name = "id") final long id) {

			// IDをキーにレコードを論理削除する
			mcuMainHayashiService.deleteCharacterNameById(id);
			return "redirect:/moviesample?result=delete&id=" + id;
	*/

	/*	/**
		 * 完全削除画面に遷移する
		 *
		 * @param MovieSampleSearchForm form
		 * @param MovieSampleDeleteForm movieSampleDeleteForm
		 * @param Model model
		 * @return 完全削除画面のパス
		 */
	/*	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
		public String showDeleteCompMovie(final MovieSampleSearchForm form,
				@ModelAttribute final MovieSampleDeleteForm movieSampleDeleteForm, final Model model) {

			// MovieMainテーブルから削除フラグが1のレコードを検索する
			final List<MovieMain> movieList = movieSampleService.getListMovie(form);

			// Modelに検索結果を格納する
			model.addAttribute(movieList);
			return "moviesample/deletecomp";
		}
	*/
	/*
	/**
	 * MovieMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param MovieSampleDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	/*	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
		public String deleteCompMovie(@Validated final MovieSampleDeleteForm form,
				final BindingResult bindingResult, final Model model) {
			if (bindingResult.hasFieldErrors()) {

				// 入力エラーがある場合、再検索して自画面に戻る
				MovieSampleSearchForm movieSampleSearchForm = new MovieSampleSearchForm();
				movieSampleSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
				final List<MovieMain> movieList = movieSampleService.getListMovie(movieSampleSearchForm);

				// Modelに検索結果を格納する
				model.addAttribute(movieList);
				return "moviesample/deletecomp";
			}

			// データを完全削除する
			movieSampleService.deleteMovieComp(form.getDeleteIds());
			return "redirect:/moviesample?result=deletecomp";
		}
	}
	*/
}
