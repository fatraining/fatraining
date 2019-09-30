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
import jp.co.futureantiques.webapptraining.model.animeNagatake.AnimeMainNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.GenreNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.SourceNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.StudioNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.VoiceactorNagatake;
import jp.co.futureantiques.webapptraining.model.form.animeNagatake.AnimeNagatakeDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.animeNagatake.AnimeNagatakeInputForm;
import jp.co.futureantiques.webapptraining.model.form.animeNagatake.AnimeNagatakeSearchForm;
import jp.co.futureantiques.webapptraining.service.AnimeNagatakeService;

/**
 * AnimeNagatakeのコントローラークラス
 * @author future
 *
 */

@Controller
@RequestMapping(value = "/animenagatake")
public class AnimeNagatakeController {

	/** アニメのサービス */
	private final AnimeNagatakeService animeNagatakeService;

	/**
	 * コンストラクタ
	 * @param AnimeNagatakeService animeNagatakeService
	 * */
	@Autowired
	public AnimeNagatakeController(final AnimeNagatakeService animeNagatakeService) {
		this.animeNagatakeService = animeNagatakeService;
	}

	/** ジャンルのエンティティのリストを取得する。
	 *
	 *@param GenreEntityのリスト
	 * */
	@ModelAttribute
	public List<GenreNagatake> getListGenre() {
		return animeNagatakeService.getListGenre();
	}

	/**スタジオのエンティティを取得する。
	 *
	 * @param StudioEntityのリスト
	 * */
	@ModelAttribute
	public List<StudioNagatake> getListStudio() {
		return animeNagatakeService.getListStudio();
	}

	/**声優のエンティティを取得する。
	 *
	 * @param VoiceactorEntityのリスト
	 * */
	@ModelAttribute
	public List<VoiceactorNagatake> getListVoiceactor(){
		return animeNagatakeService.getListVoiceactor();
	}

	/**出典のエンティティを取得する。
	 *
	 *@param SourceEntityのリスト
	 * */
	@ModelAttribute
	public List<SourceNagatake> getListSource() {
		return animeNagatakeService.getListSource();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param AnimeNagatakeSearchForm AnimeNagatakeSearchForm
	 * @return 検索画面のパス
	 */

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchAnime(@ModelAttribute final AnimeNagatakeSearchForm animeNagatakeSearchForm) {
		return "animenagatake/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @oaram AnimeNagatakeSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchAnime(final AnimeNagatakeSearchForm form, final Model model, final Pageable pageable) {

		//入力された検索条件を元にレコードを取得
		final Page<AnimeMainNagatake> animeList = animeNagatakeService.getPageAnime(form, pageable);
		if (animeList.getTotalElements() != 0) {

			// 検索結果がある場合Modelに結果をセットする
			model.addAttribute("page", animeList);
			model.addAttribute("animeList", animeList.getContent());
			model.addAttribute("url", "search");
		}
		return "animenagatake/search";
	}
	/**
	 * 追加画面に遷移する
	 *
	 * @param AnimeNagatakeInputForm AnimeNagatakeInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertAnime(@ModelAttribute final AnimeNagatakeInputForm animeNagatakeInputForm) {
		return "animenagatake/insert";
	}

	/**
	 * AnimeMainNagatakeテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param AnimeNagatakeInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertAnime(@ModelAttribute @Validated final AnimeNagatakeInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーが有る場合自画面に戻る
			return "animenagatake/insert";
		}

		// データを登録する
		final AnimeMainNagatake animeMainNagatake = animeNagatakeService.insertAnime(form);
		return "redirect:/animenagatake?result=insert&id=" + animeMainNagatake.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param AnimeNagatakeInputForm AnimeNagatakeInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateAnime(@RequestParam(name = "id") final long id,
			@ModelAttribute final AnimeNagatakeInputForm AnimeNagatakeInputForm) {

		// IDをキーにanimeMainTaneichiテーブルを検索する
		AnimeMainNagatake animeMainNagatake = animeNagatakeService.getAnime(id);

		// フォームにレコードの値をセットする
		AnimeNagatakeInputForm.initWithAnimeMainNagatake(animeMainNagatake);
		return "animeNagatake/update";
	}

	/**
	 * AnimeMainNagatakeテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param AnimeNagatakeInputForm form
	 * @param Bindingresult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updaeAnime(@Validated final AnimeNagatakeInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			//  入力エラーが有る場合自画面に戻る
			return "animeNagatake/update";
		}

		// データを更新する
		AnimeMainNagatake animeMainNagatake = animeNagatakeService.updateAnime(form);
		if (animeMainNagatake == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/animenagatake?result=updatefailed";
		}
		return "redirect:/animenagatake?result=update&id=" + animeMainNagatake.getId();
	}

	/**
	 * AnimeMainNagatakeテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param log id
	 * @return 検索画面のパス
	 */


	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteAnime(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		animeNagatakeService.deleteAnimeById(id);
		return "redirect:/animenagatake?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param AnimeNagatakeSearchForm form
	 * @param AnimeNagatakeDeleteForm AnimeNagatakeDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompAnime(final AnimeNagatakeSearchForm form,
			@ModelAttribute final AnimeNagatakeDeleteForm animeNagatakeDeleteForm, final Model model) {

		// animeMainTaneichiテーブルから削除フラグが１のレコードを検索する
		final List<AnimeMainNagatake> animeList = animeNagatakeService.getListAnime(form);

		// Modelに検索結果を格納する
		model.addAttribute(animeList);
		return "animenagatake/deletecomp";
	}

	/**
	 * animeMainNagatakeテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param AnimeNagatakeDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompAnime(@Validated final AnimeNagatakeDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーが有る場合、再検索して自画面に戻る
			AnimeNagatakeSearchForm AnimeNagatakeSearchForm = new AnimeNagatakeSearchForm();
			AnimeNagatakeSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<AnimeMainNagatake> AnimeList = animeNagatakeService.getListAnime(AnimeNagatakeSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(AnimeList);
			return "animenagatake/deletecomp";
		}

		// データを完全削除する
		animeNagatakeService.deleteAnimeComp(form.getDeleteIds());
		return "redirect:/animenagatake?result=deletecomp";
	}
}
