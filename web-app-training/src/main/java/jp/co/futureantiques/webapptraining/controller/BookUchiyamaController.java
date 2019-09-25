package jp.co.futureantiques.webapptraining.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
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
import org.springframework.web.context.WebApplicationContext;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.BookMainUchiyama;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.GenreUchiyama;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.WriterUchiyama;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaInputForm;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaSearchForm;
import jp.co.futureantiques.webapptraining.service.BookUchiyamaService;

/**
 *BookUchiyamaのコントローラークラス
 * @author FutureAntiques
 */
@Controller
@RequestMapping(value = "/bookUchiyama")
public class BookUchiyamaController {
	/**	BookUchiyamaのサービス */
	private final BookUchiyamaService bookUchiyamaService;

	/**
	 * コンストラクタ
	 * @param BookUchiyamaService bookUchiyamaService
	 */
	@Autowired
	public BookUchiyamaController(final BookUchiyamaService bookUchiyamaService) {
		this.bookUchiyamaService = bookUchiyamaService;
	}

	/**
	 * ジャンルのリストを取得する
	 * @return GenreEntityのリスト
	 */
	@ModelAttribute
	public List<GenreUchiyama> getListGenre() {
		return bookUchiyamaService.getListGenre();
	}

	/**
	 * 作家のリストを取得する
	 * @return WriterEntityのリスト
	 */
	@ModelAttribute
	public List<WriterUchiyama> getListWriter() {
		return bookUchiyamaService.getListWriter();
	}

	/**
	 * 検索画面へ遷移する
	 * @param BookUchiyamaSearchForm bookUchiyamaSearchForm
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchBook(@ModelAttribute final BookUchiyamaSearchForm bookUchiyamaSearchForm) {
		return "bookUchiyama/search";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 * @param BookUchiyamaSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String showSearchBook(final BookUchiyamaSearchForm form, final Model model, final Pageable pageable) {

		//検索条件を元にレコードを取得する
		final Page<BookMainUchiyama> bookList = bookUchiyamaService.getPageBook(form, pageable);
		if (bookList.getTotalElements() != 0) {

			//検索結果が存在する場合は取得したレコードをモデルにセットする
			model.addAttribute("page", bookList);
			model.addAttribute("bookList", bookList.getContent());
			model.addAttribute("url", "search");

		}
		return "bookUchiyama/search";
	}

	/**
	 * 追加画面へ遷移する
	 * @param BookUchiyamaInputForm bookUchiyamaInputForm
	 * @return 追加画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String showInsertBook(@ModelAttribute final BookUchiyamaInputForm bookUchiyamaInputForm) {
		return "bookUchiyama/insert";
	}

	@Autowired
	ResourceLoader resourceLoader;
	@Autowired
	ServletContext context;
	@Autowired
	WebApplicationContext wac;

	/**
	 * @param BookUchiyamaInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力にエラーがある場合:追加画面のパス,
	 *  エラーが無い場合:検索画面のパス
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertBook(@ModelAttribute @Validated final BookUchiyamaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			//入力にエラーがある場合は追加画面に遷移する
			return "bookUchiyama/insert";
		}

		//入力フォームを元に項目を追加
		final BookMainUchiyama bookMainUchiyama = bookUchiyamaService.insertBook(form);

		//検索画面に追加したIDを表示する(param.result:insert,param.id:追加した本ID)
		return "redirect:/bookUchiyama?result=insert&id=" + bookMainUchiyama.getId();
	}

	/**
	 * 更新画面に遷移する
	 * @param long id
	 * @param BookUchiyamaInputForm bookUchiyamaInputForm
	 * @return 更新画面のパス
	 */
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateBook(@RequestParam(name = "id") final long id,
			@ModelAttribute final BookUchiyamaInputForm bookUchiyamaInputForm) {
		//更新ボタンを押した本IDを元に検索する
		BookMainUchiyama bookMainUchiyama = bookUchiyamaService.getBook(id);
		//フォームにレコードの値をセットする
		bookUchiyamaInputForm.initWithBookMainUchiyama(bookMainUchiyama);
		return "bookUchiyama/update";
	}

	/**
	 * 更新結果を表示する
	 *
	 * @param BookUchiyamaInputForm form
	 * @param BindingResult bindingResult
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateBook(@Validated final BookUchiyamaInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			//入力フォームにエラーがある場合は更新画面へ遷移する
			return "bookUchiyama/update";
		}

		//入力フォームを元にテーブルを更新する
		BookMainUchiyama bookMainUchiyama = bookUchiyamaService.updateBook(form);

		//更新に失敗した場合に検索画面に更新失敗のメッセージを表示する
		if (bookMainUchiyama == null) {
			return "redirect:/bookUchiyama?result=updatefailed";
		}
		//検索画面に更新結果を表示する(param.result:update,param.id:更新した本ID)
		return "redirect:/bookUchiyama?result=update&id=" + bookMainUchiyama.getId();
	}

	/**
	 * 選択した項目を論理削除し、検索画面に遷移する
	 * @param long id
	 * @return 検索画面のパス(param.result:delete,param.id:削除した本ID)
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteBook(@RequestParam(name = "id") final long id) {
		bookUchiyamaService.deleteBookById(id);
		return "redirect:/bookUchiyama?result=delete&id=" + id;
	}

	/**
	 * 削除画面に遷移する
	 * @param BookUchiyamaSearchForm form
	 * @param BookUchiyamaDeleteForm bookUchiyamaDeleteForm
	 * @param Model model
	 * @return 削除画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompBook(final BookUchiyamaSearchForm form,
			@ModelAttribute final BookUchiyamaDeleteForm bookUchiyamaDeleteForm, final Model model) {
		//検索フォームの条件を元にレコードを取得する
		//search.htmlから呼び出される際は検索フォームの条件がinputタグでisDelete=1として設定されている
		final List<BookMainUchiyama> bookList = bookUchiyamaService.getListBook(form);
		model.addAttribute(bookList);
		return "bookUchiyama/deletecomp";
	}

	/**
	 *完全に削除し、検索画面に遷移する
	 * @param BookUchiyamaDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 検索画面のパス
	 */
	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompBook(@Validated final BookUchiyamaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			//入力にエラーがある場合、再検索する
			BookUchiyamaSearchForm bookUchiyamaSearchForm = new BookUchiyamaSearchForm();
			bookUchiyamaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<BookMainUchiyama> bookList = bookUchiyamaService.getListBook(bookUchiyamaSearchForm);
			//モデルに検索結果を格納する
			model.addAttribute(bookList);
			//削除画面にリダイレクト
			return "bookUchiyama/deletecomp";
		}

		//データを物理削除する
		bookUchiyamaService.deleteBookComp(form.getDeleteIds());
		return "redirect:/bookUchiyama?result=deletecomp";
	}

}
