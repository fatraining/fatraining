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
import jp.co.futureantiques.webapptraining.model.form.novelmiyamoto.NovelDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.novelmiyamoto.NovelInputForm;
import jp.co.futureantiques.webapptraining.model.form.novelmiyamoto.NovelSearchForm;
import jp.co.futureantiques.webapptraining.model.novelmiyamoto.AuthorMiyamoto;
import jp.co.futureantiques.webapptraining.model.novelmiyamoto.BookMainMiyamoto;
import jp.co.futureantiques.webapptraining.model.novelmiyamoto.GenreMiyamoto;
import jp.co.futureantiques.webapptraining.service.NovelMiyamotoService;

@Controller
/* URL　*/
@RequestMapping(value = "/novelmiyamoto")
public class NovelController {
	/** 映画のサービス */
	private final NovelMiyamotoService novelMiyamotoService;
	/**
	 * コンストラクタ
	 */
	@Autowired
	public NovelController(final NovelMiyamotoService novelMiyamotoService) {
		this.novelMiyamotoService = novelMiyamotoService;
	}
	/**
	 * ジャンルエンティティのリストを取得する
	 */
	@ModelAttribute
	public List<GenreMiyamoto> getListGenreMiyamoto() {
		return novelMiyamotoService.getListGenreMiyamoto();
	}
	/**
	 * 俳優エンティティのリストを取得する
	 */
	@ModelAttribute
	public List<AuthorMiyamoto> getListNovelAuthor() {
		return novelMiyamotoService.getListNovelAuthor();
	}
	/**
	 * 検索画面に遷移する
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchNovel(@ModelAttribute final NovelSearchForm novelSearchForm) {
		return "novelmiyamoto/search";
	}
	/**
	 * 検索結果を取得して検索画面に遷移する
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchNovel(final NovelSearchForm form, final Model model, final Pageable pageable) {
		// 入力された検索条件を元にレコードを取得する
		final Page<BookMainMiyamoto> bookList = novelMiyamotoService.getPageNovel(form, pageable);
		if (bookList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", bookList);
			model.addAttribute("bookList", bookList.getContent());
			model.addAttribute("url", "search");
		}
		return "novelmiyamoto/search";
	}
	/**
	 * 追加画面に遷移する
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertBook(@ModelAttribute final NovelInputForm novelInputForm) {
		return "novelmiyamoto/insert";
	}
	/**
	 * BookMainMiyamotoテーブルにデータを登録して検索画面に遷移する
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertBook(@ModelAttribute @Validated final NovelInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			// 入力エラーがある場合自画面に戻る
			return "novelmiyamoto/insert";
		}
		// データを登録する
		final BookMainMiyamoto bookMainMiyamoto = novelMiyamotoService.insertNovel(form);
		return "redirect:/novelmiyamoto?result=insert&id=" + bookMainMiyamoto.getId();
	}
	/**
	 * 更新画面に遷移する
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateBook(@RequestParam(name = "id") final long id,
			@ModelAttribute final NovelInputForm novelInputForm) {
		// IDをキーにBookMainMiyamotoテーブルを検索する
		BookMainMiyamoto bookMainMiyamoto = novelMiyamotoService.getNovel(id);
		// フォームにレコードの値をセットする
		novelInputForm.initWithBookMainMiyamoto(bookMainMiyamoto);
		return "novelmiyamoto/update";
	}
	/**
	 * BookMainMiyamotoテーブルのデータを更新して検索画面に遷移する
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateNovel(@Validated final NovelInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			// 入力エラーがある場合自画面に戻る
			return "novelmiyamoto/update";
		}
		// データを更新する
		BookMainMiyamoto bookMainMiyamoto = novelMiyamotoService.updateNovel(form);
		if (bookMainMiyamoto == null) {
			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/novelmiyamoto?result=updatefailed";
		}
		return "redirect:/novelmiyamoto?result=update&id=" + bookMainMiyamoto.getId();
	}
	/**
	 * BookMainMiyamotoテーブルのレコードを論理削除して検索画面に遷移する
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteNovel(@RequestParam(name = "id") final long id) {
		// IDをキーにレコードを論理削除する
		novelMiyamotoService.deleteNovelById(id);
		return "redirect:/novelmiyamoto?result=delete&id=" + id;
	}
	/**
	 * 完全削除画面に遷移する
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompNovel(final NovelSearchForm form,
			@ModelAttribute final NovelDeleteForm novelDeleteForm, final Model model) {
		// BookMainMiyamotoテーブルから削除フラグが1のレコードを検索する
		final List<BookMainMiyamoto> bookList = novelMiyamotoService.getListNovel(form);
		// Modelに検索結果を格納する
		model.addAttribute(bookList);
		return "novelmiyamoto/deletecomp";
	}
	/**
	 * BookMainMiyamotoテーブルのデータを完全削除して検索画面に遷移する
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompNovel(@Validated final NovelDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {
			// 入力エラーがある場合、再検索して自画面に戻る
			NovelSearchForm novelSearchForm = new NovelSearchForm();
			novelSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<BookMainMiyamoto> bookList = novelMiyamotoService.getListNovel(novelSearchForm);
			// Modelに検索結果を格納する
			model.addAttribute(bookList);
			return "novelmiyamoto/deletecomp";
		}
		// データを完全削除する
		novelMiyamotoService.deleteNovelComp(form.getDeleteIds());
		return "redirect:/novelmiyamoto?result=deletecomp";
	}
}