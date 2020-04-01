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
import jp.co.futureantiques.webapptraining.model.bandIto.AreaIto;
import jp.co.futureantiques.webapptraining.model.bandIto.BandMainIto;
import jp.co.futureantiques.webapptraining.model.bandIto.SexIto;
import jp.co.futureantiques.webapptraining.model.form.bandIto.BandItoDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.bandIto.BandItoSearchForm;
import jp.co.futureantiques.webapptraining.service.BandItoService;

/**
 * BandItoのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/bandIto")
public class BandItoController {
	/** バンドのサービス */
	private final BandItoService bandItoService;

	/**
	 * コンストラクタ
	 *
	 * @param BandItoServise bandItoService
	 */
	@Autowired
	public BandItoController(final BandItoService bandItoService) {
		this.bandItoService = bandItoService;
	}

	/**
	 * ボーカル性別のリストを取得する
	 *
	 * @return SexItoEntityのリスト
	 */
	@ModelAttribute
	public List<SexIto> getListSex() {
		return bandItoService.getListSex();
	}

	/**
	 * 出身地のリストを取得する
	 *
	 * @return AreaItoEntityのリスト
	 */
	@ModelAttribute
	public List<AreaIto> getListArea() {
		return bandItoService.getListArea();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param BandItoSearchForm bandItoSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchBand(@ModelAttribute final BandItoSearchForm bandItoSearchForm) {
		System.out.println("test");
		return "bandIto/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param BandItoSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchBand(final BandItoSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<BandMainIto> bandList = bandItoService.getPageBand(form, pageable);
		if (bandList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", bandList);
			model.addAttribute("bandList", bandList.getContent());
			model.addAttribute("url", "search");
		}
		return "bandito/search";
	}

	/**
	 * BandMainItoテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteBand(@RequestParam(name = "id") final long id) {

		// IDをキコードを論理削除する
		bandItoService.deleteBandById(id);
		return "redirect:/bandIto?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param BandItoSearchForm form
	 * @param BandItoDeleteForm bandItoDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompBand(final BandItoSearchForm form,
			@ModelAttribute final BandItoDeleteForm bandItoDeleteForm, final Model model) {

		// BandMainItoテーブルから削除フラグが1のレコードを検索する
		final List<BandMainIto> bandList = bandItoService.getListBand(form);

		// Modelに検索結果を格納する
		model.addAttribute(bandList);
		return "bandIto/deletecomp";
	}

	/**
	 * BandMainItoテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param BandItoDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompBand(@Validated final BandItoDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			BandItoSearchForm bandItoSearchForm = new BandItoSearchForm();
			bandItoSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<BandMainIto> bandList = bandItoService.getListBand(bandItoSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(bandList);
			return "bandIto/deletecomp";
		}

		// データを完全削除する
		bandItoService.deleteBandComp(form.getDeleteIds());
		return "redirect:/bandIto?result=deletecomp";
	}
}

/*
	/**
	 * 追加画面に遷移する
	 *
	 * @param MovieSampleInputForm movieSampleInputForm
	 * @return 追加画面のパス

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertMovie(@ModelAttribute final MovieSampleInputForm movieSampleInputForm) {
		return "moviesample/insert";
	}

	/**
	 * MovieMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MovieSampleInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertMovie(@ModelAttribute @Validated final MovieSampleInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "moviesample/insert";
		}

		// データを登録する
		final MovieMain movieMain = movieSampleService.insertMovie(form);
		return "redirect:/moviesample?result=insert&id=" + movieMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param MovieSampleInputForm movieSampleInputForm
	 * @return 更新画面のパス

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateMovie(@RequestParam(name = "id") final long id,
			@ModelAttribute final MovieSampleInputForm movieSampleInputForm) {

		// IDをキーにMovieMainテーブルを検索する
		MovieMain movieMain = movieSampleService.getMovie(id);

		// フォームにレコードの値をセットする
		movieSampleInputForm.initWithMovieMain(movieMain);
		return "moviesample/update";
	}

	/**
	 * MovieMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param MovieSampleInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMovie(@Validated final MovieSampleInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "moviesample/update";
		}

		// データを更新する
		MovieMain movieMain = movieSampleService.updateMovie(form);
		if (movieMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/moviesample?result=updatefailed";
		}
		return "redirect:/moviesample?result=update&id=" + movieMain.getId();
	}

}*/
