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
import jp.co.futureantiques.webapptraining.model.form.novelOkudaira.NovelOkudairaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.novelOkudaira.NovelOkudairaInputForm;
import jp.co.futureantiques.webapptraining.model.form.novelOkudaira.NovelOkudairaSearchForm;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.GenreOkudaira;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.WriterOkudaira;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.NovelMainOkudaira;
import jp.co.futureantiques.webapptraining.service.NovelOkudairaService;

/**
 * Novelのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/novelOkudaira")
public class NovelOkudairaController {

	/** 小説のサービス */
	private final NovelOkudairaService novelOkudairaService;

	/**
	 * コンストラクタ
	 *
	 * @param NovelOkudairaService novelOkudairaService
	 */
	@Autowired
	public NovelOkudairaController(final NovelOkudairaService novelOkudairaService) {
		this.novelOkudairaService = novelOkudairaService;
	}

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<GenreOkudaira> getListGenreOkudaira() {
		return novelOkudairaService.getListGenreOkudaira();
	}

	/**
	 * 作者エンティティのリストを取得する
	 *
	 * @return WriterEntityのリスト
	 */
	@ModelAttribute
	public List<WriterOkudaira> getListWriterOkudaira() {
		return novelOkudairaService.getListWriterOkudaira();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param NovelOkudairaSearchForm novelOkudairaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchNovel(@ModelAttribute final NovelOkudairaSearchForm novelOkudairaSearchForm) {
		return "novelOkudaira/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param NovelOkudairaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchNovel(final NovelOkudairaSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<NovelMainOkudaira> novelList = novelOkudairaService.getPageNovel(form, pageable);
		if (novelList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", novelList);
			model.addAttribute("novelList", novelList.getContent());
			model.addAttribute("url", "search");
		}
		return "novelOkudaira/search";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param NovelOkudairaInputForm novelOkudairaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertNovel(@ModelAttribute final NovelOkudairaInputForm novelOkudairaInputForm) {
		return "novelOkudaira/insert";
	}

	/**
	 * NovelMainOkudairaテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param NovelOkudairaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertNovel(@ModelAttribute @Validated final NovelOkudairaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "novelOkudaira/insert";
		}

		// データを登録する
		final NovelMainOkudaira novelMainOkudaira = novelOkudairaService.insertNovel(form);
		return "redirect:/novelOkudaira?result=insert&id=" + novelMainOkudaira.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param NovelOkudairaInputForm novelOkudairaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateNovel(@RequestParam(name = "id") final long id,
			@ModelAttribute final NovelOkudairaInputForm novelOkudairaInputForm) {

		// IDをキーにNovelMainOkudairaテーブルを検索する
		NovelMainOkudaira novelMainOkudaira = novelOkudairaService.getNovel(id);

		// フォームにレコードの値をセットする
		novelOkudairaInputForm.initWithNovelMainOkudaira(novelMainOkudaira);
		return "novelOkudaira/update";
	}

	/**
	 * NovelMainOkudairaテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param NovelOkudairaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateNovel(@Validated final NovelOkudairaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "novelOkudaira/update";
		}

		// データを更新する
		NovelMainOkudaira novelMainOkudaira = novelOkudairaService.updateNovel(form);
		if (novelMainOkudaira == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/novelOkudaira?result=updatefailed";
		}
		return "redirect:/novelOkudaira?result=update&id=" + novelMainOkudaira.getId();
	}

	/**
	 * NovelMainOkudairaテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteNovel(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		novelOkudairaService.deleteNovelById(id);
		return "redirect:/novelOkudaira?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param NovelOkudairaSearchForm form
	 * @param NovelOkudairaDeleteForm novelOkudairaDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompNovel(final NovelOkudairaSearchForm form,
			@ModelAttribute final NovelOkudairaDeleteForm novelOkudairaDeleteForm, final Model model) {

		// NovelMainOkudairaテーブルから削除フラグが1のレコードを検索する
		final List<NovelMainOkudaira> novelList = novelOkudairaService.getListNovel(form);

		// Modelに検索結果を格納する
		model.addAttribute(novelList);
		return "novelOkudaira/deletecomp";
	}

	/**
	 * NovelMainOkudairaテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param NovelOkudairaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompNovel(@Validated final NovelOkudairaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			NovelOkudairaSearchForm novelOkudairaSearchForm = new NovelOkudairaSearchForm();
			novelOkudairaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<NovelMainOkudaira> novelList = novelOkudairaService.getListNovel(novelOkudairaSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(novelList);
			return "novelOkudaira/deletecomp";
		}

		// データを完全削除する
		novelOkudairaService.deleteNovelComp(form.getDeleteIds());
		return "redirect:/novelOkudaira?result=deletecomp";
	}
}
