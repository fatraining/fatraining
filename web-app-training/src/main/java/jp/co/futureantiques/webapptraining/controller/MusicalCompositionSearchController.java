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
import jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei.MusicalCompositionDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei.MusicalCompositionInputForm;
import jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei.MusicalCompositionSearchMainForm;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.AlbumTakei;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.GenreTakei;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.MusicalCompositionMainTakei;
import jp.co.futureantiques.webapptraining.service.MusicalCompositionSearchService;

/**
 * musicalpieceSearchのコントローラークラス
 *
 * @author takei
 *
 */
@Controller
@RequestMapping(value = "/musicalComposition")
public class MusicalCompositionSearchController {

	/** 楽曲のサービス */
	private final MusicalCompositionSearchService musicalCompositionSearchService;

	/**
	 * コンストラクタ
	 *
	 * @param MusicalCompositionSearchService musicalCompositionSearchService
	 */
	@Autowired
	public MusicalCompositionSearchController(final MusicalCompositionSearchService musicalCompositionSearchService) {
		this.musicalCompositionSearchService = musicalCompositionSearchService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreTakeiEntityのリスト
	 *
	 */
	@ModelAttribute
	public List<GenreTakei> getListGenreTakei() {
		return musicalCompositionSearchService.getListGenreTakei();
	}

	/**
	 * アルバム名エンティティのリストを取得する
	 *
	 * @return AlbumTakeiEntityのリスト
	 */
	@ModelAttribute
	public List<AlbumTakei> getListAlbumTakei() {
		return musicalCompositionSearchService.getListAlbumTakei();
	}

	/**検索画面に遷移する
	 *
	 * @param MusicalCompositionSearchMainForm musicalCompositionSearchMainForm
	 * @return 検索画面のパス
	 *
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String searchMusicalComposition(
			@ModelAttribute final MusicalCompositionSearchMainForm musicalCompositionSearchMainForm) {
		return "musicalComposition/search";
	}

	/**
	 * MusicalCompositionMainTakeiテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MusicalCompositionSearchMainForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchMusicalComposition(final MusicalCompositionSearchMainForm form, final Model model,
			final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<MusicalCompositionMainTakei> musicalCompositionMainTakeiList = musicalCompositionSearchService
				.getPageMusicalComposition(form, pageable);
		if (musicalCompositionMainTakeiList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", musicalCompositionMainTakeiList);
			model.addAttribute("musicalCompositionMainTakeiList", musicalCompositionMainTakeiList.getContent());
			model.addAttribute("url", "search");
		}
		return "musicalComposition/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param MusicalCompositionInputForm musicalCompositionInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insertMusicalComposition(@ModelAttribute @Validated final MusicalCompositionInputForm form) {
		return "musicalComposition/insert";
	}

	/**
	 * MusicalCompositionMainTakeiテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param MusicalCompositionInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertMusicalcomposition(@ModelAttribute @Validated final MusicalCompositionInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "musicalComposition/insert";
		}

		// データを登録する
		final MusicalCompositionMainTakei musicalCompositionMainTakei = musicalCompositionSearchService
				.insertMusicalComposition(form);
		return "redirect:/musicalComposition?result=insert&id=" + musicalCompositionMainTakei.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param MusicalCompositionInputForm musicalCompositionInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateMusicalComposition(@RequestParam(name = "id") final long id,
			@ModelAttribute final MusicalCompositionInputForm musicalCompositionInputForm) {

		// IDをキーにMusicalCompositionMainTakeiテーブルを検索する
		MusicalCompositionMainTakei musicalCompositionMainTakei = musicalCompositionSearchService
				.getMusicalComposition(id);

		// フォームにレコードの値をセットする
		musicalCompositionInputForm.intiWithmusicalCompositionMainTakei(musicalCompositionMainTakei);
		return "musicalComposition/update";
	}

	/**
	 * MusicalCompositionMainTakeiテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param MusicalCompositionInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String UpdateMusicalComposition(@Validated final MusicalCompositionInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "musicalComposition/update";
		}
		// データを更新する
		MusicalCompositionMainTakei musicalCompositionMainTakei = musicalCompositionSearchService
				.updateMusicalComposition(form);
		if (musicalCompositionMainTakei == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/musicalComposition?result=updatefailed";
		}
		return "redirect:/musicalComposition?result=update&id=" + musicalCompositionMainTakei.getId();
	}

	/**
	 * MusicalCompositionMainTakeiテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteMusicalComposition(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		musicalCompositionSearchService.deleteMusicalCompositionById(id);
		return "redirect:/musicalComposition?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param MusicalCompositionSearchMainForm form
	 * @param MusicalCompositionDeleteForm musicalCompositionDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletcomp", method = RequestMethod.GET)
	public String showDeleteCompMusicalComposition(final MusicalCompositionSearchMainForm form,
			@ModelAttribute final MusicalCompositionDeleteForm musicalCompositionDeleteForm, final Model model) {

		// MusicalCompositionSearchMainテーブルから削除フラグが1のレコードを検索する
		final List<MusicalCompositionMainTakei> musicalCompositionMainTakeiList = musicalCompositionSearchService
				.getListMusicalComposition(form);

		// Modelに検索結果を格納する
		model.addAttribute(musicalCompositionMainTakeiList);
		return "musicalComposition/deletcomp";
	}

	/**
	 * MusicalCompositionMainTakeiテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param MusicalCompositionDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletcomp", method = RequestMethod.POST)
	public String deleteCompMusicalComposition(@Validated final MusicalCompositionDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			MusicalCompositionSearchMainForm musicalCompositionSearchMainForm = new MusicalCompositionSearchMainForm();
			musicalCompositionSearchMainForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<MusicalCompositionMainTakei> musicalCompositionMainTakeiList = musicalCompositionSearchService
					.getListMusicalComposition(musicalCompositionSearchMainForm);

			// Modelに検索結果を格納する
			model.addAttribute(musicalCompositionMainTakeiList);
			return "musicalComposition/deletecomp";
		}

		// データを完全削除する
		musicalCompositionSearchService.deleteMusicalCompositionComp(form.getDeleteIds());
		return "redirect:/musicalComposition?result=deletecomp";
	}
}
