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

import jp.co.futureantiques.webapptraining.model.form.mlbUezu.MLBTeamSearchForm;
import jp.co.futureantiques.webapptraining.model.mlbUezu.DistrictUezu;
import jp.co.futureantiques.webapptraining.model.mlbUezu.LeagueUezu;
import jp.co.futureantiques.webapptraining.model.mlbUezu.MlbMainUezu;
import jp.co.futureantiques.webapptraining.service.MLBUezuService;

/**
 * MLBUezuのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/mlbuezu")
public class MLBUezuController {

	/** MLB球団検索のサービス */
	private final MLBUezuService mlbUezuService;

	/**
	 * コンストラクタ
	 *
	 * @param MLBUezuService mlbUezuService;
	 */
	@Autowired
	public MLBUezuController(final MLBUezuService mlbUezuService) {
		this.mlbUezuService = mlbUezuService;
	}

	/**
	 * リーグエンティティのリストを取得する
	 *
	 * @return LeagueEntityのリスト
	 */
	@ModelAttribute
	public List<LeagueUezu> getListLeague() {
		return mlbUezuService.getListLeague();
	}

	/**
	 * 地区エンティティのリストを取得する
	 *
	 * @return DistrictEntityのリスト
	 */
	@ModelAttribute
	public List<DistrictUezu> getListDistrict() {
		return mlbUezuService.getListDistrict();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param MLBTeamSearchForm movieSampleSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchMLB(@ModelAttribute final MLBTeamSearchForm mlbTeamSearchForm) {
		return "mlbuezu/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param MLBTeamSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchMLB(final MLBTeamSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<MlbMainUezu> mlbList = mlbUezuService.getPageMLB(form, pageable);
		if (mlbList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", mlbList);
			model.addAttribute("mlbList", mlbList.getContent());
			model.addAttribute("url", "search");
		}
		return "mlbuezu/search";
	}

	//未作成↓(論理削除部分のみ作成済み)
	/**
	 * 追加画面に遷移する
	 *
	 * @param MLBTeamInputForm movieSampleInputForm
	 * @return 追加画面のパス
	 *
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertMovie(@ModelAttribute final MovieSampleInputForm movieSampleInputForm) {
		return "moviesample/insert";
	}

	/**
	 * MovieMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MLBTeamInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 *
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertMovie(@ModelAttribute @Validated final MovieSampleInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "moviesample/insert";
		}

		// データを登録する
		final MovieMain movieMain = mlbUezuService.insertMovie(form);
		return "redirect:/moviesample?result=insert&id=" + movieMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param MLBTeamInputForm movieSampleInputForm
	 * @return 更新画面のパス
	 *
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateMovie(@RequestParam(name = "id") final long id,
			@ModelAttribute final MovieSampleInputForm movieSampleInputForm) {

		// IDをキーにMovieMainテーブルを検索する
		MovieMain movieMain = mlbUezuService.getMovie(id);

		// フォームにレコードの値をセットする
		movieSampleInputForm.initWithMovieMain(movieMain);
		return "moviesample/update";
	}

	/**
	 * MovieMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param MLBTeamInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 *
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMovie(@Validated final MovieSampleInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "moviesample/update";
		}

		// データを更新する
		MovieMain movieMain = mlbUezuService.updateMovie(form);
		if (movieMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/moviesample?result=updatefailed";
		}
		return "redirect:/moviesample?result=update&id=" + movieMain.getId();
	}

	//論理削除↓
	/**
	 * MLBMainUezuテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteMlb(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		mlbUezuService.deleteMlbById(id);
		return "redirect:/mlbuezu?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param MLBTeamSearchForm form
	 * @param MLBTeamDeleteForm movieSampleDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 *
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompMovie(final MovieSampleSearchForm form,
			@ModelAttribute final MovieSampleDeleteForm movieSampleDeleteForm, final Model model) {

		// MovieMainテーブルから削除フラグが1のレコードを検索する
		final List<MovieMain> movieList = mlbUezuService.getListMovie(form);

		// Modelに検索結果を格納する
		model.addAttribute(movieList);
		return "moviesample/deletecomp";
	}

	/**
	 * MovieMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param MLBTeamDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 *
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompMovie(@Validated final MovieSampleDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			MovieSampleSearchForm movieSampleSearchForm = new MovieSampleSearchForm();
			movieSampleSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<MovieMain> movieList = mlbUezuService.getListMovie(movieSampleSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(movieList);
			return "moviesample/deletecomp";
		}

		// データを完全削除する
		mlbUezuService.deleteMovieComp(form.getDeleteIds());
		return "redirect:/moviesample?result=deletecomp";
	}

	*/
}
