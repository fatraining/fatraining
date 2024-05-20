package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.booknakano.AuthorNakano;
import com.example.demo.model.booknakano.BookMainNakano;
import com.example.demo.model.booknakano.CharacterOrthographyNakano;
import com.example.demo.model.booknakano.ClassificationNakano;
import com.example.demo.model.form.booknakano.BookNakanoDeleteForm;
import com.example.demo.model.form.booknakano.BookNakanoInputForm;
import com.example.demo.model.form.booknakano.BookNakanoSearchForm;
import com.example.demo.service.BookNakanoService;

/**
 * BookNakanoのコントローラークラス
 *
 * @author future
 */
@Controller
@RequestMapping(value = "/booknakano")
public class BookNakanoController {

	/** 書籍のサービス */
	private final BookNakanoService bookNakanoService;

	/**
	 * コンストラクタ
	 *
	 * @param BookNakanoService bookNakanoService
	 */
	public BookNakanoController(final BookNakanoService bookNakanoService) {
		this.bookNakanoService = bookNakanoService;
	}

	/**
	 * 著者エンティティのリストを取得する
	 *
	 * @return AuthorEntityのリスト
	 */
	@ModelAttribute
	public List<AuthorNakano> getListAuthor() {
		return bookNakanoService.getListAuthor();
	}

	/**
	 * 分類エンティティのリストを取得する
	 *
	 * @return ClassificationEntityのリスト
	 */
	@ModelAttribute
	public List<ClassificationNakano> getListClassification() {
		return bookNakanoService.getListClassification();
	}

	/**
	 * 文字遣い種別エンティティのリストを取得する
	 *
	 * @return ClassificationEntityのリスト
	 */
	@ModelAttribute
	public List<CharacterOrthographyNakano> getListCharacterOrthography() {
		return bookNakanoService.getListCharacterOrthography();
	}

	/**
	 * 検索画面に遷移する
	 *
	 * @param BookNakanoSearchForm bookNakanoSearchForm
	 * @return 検索画面のパス
	 */
	@GetMapping(value = "")
	public String showSearchBook(@ModelAttribute final BookNakanoSearchForm bookNakanoSearchForm) {
		return "booknakano/searchnakano";
	}

	/**
	 * 検索結果を取得して検索画面に遷移する
	 *
	 * @param BookNakanoSearchForm form
	 * @param Model model
	 * @param Pageable pageable
	 * @return 検索画面のパス
	 */
	@PostMapping(value = "search")
	public String searchBook(final BookNakanoSearchForm form, final Model model, final Pageable pageable) {

		// 入力された検索条件を元にレコードを取得する
		final Page<BookMainNakano> bookList = bookNakanoService.getPageBook(form, pageable);
		if (bookList.getTotalElements() != 0) {

			// 検索結果がある場合、Modelに結果をセットする
			model.addAttribute("page", bookList);
			model.addAttribute("bookList", bookList.getContent());
			model.addAttribute("url", "search");
		}
		return "booknakano/searchnakano";
	}

	/**
	 * 追加画面に遷移する
	 *
	 * @param BookNakanoInputForm bookNakanoInputForm
	 * @return 追加画面のパス
	 */
	@GetMapping(value = "insert")
	public String showInsertBook(@ModelAttribute final BookNakanoInputForm bookNakanoInputForm) {
		return "booknakano/insertnakano";
	}

	/**
	 * BookMainテーブルにデータを登録して検索画面に遷移する
	 *
	 * @param BookNakanoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合追加画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "insert")
	public String insertBook(@ModelAttribute @Validated final BookNakanoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "booknakano/insertnakano";
		}

		// データを登録する
		final BookMainNakano bookMain = bookNakanoService.insertBook(form);
		return "redirect:/booknakano?result=insert&id=" + bookMain.getId();
	}

	/**
	 * 更新画面に遷移する
	 *
	 * @param long id
	 * @param BookNakanoInputForm bookNakanoInputForm
	 * @return 更新画面のパス
	 */
	@GetMapping(value = "update")
	public String showUpdateBook(@RequestParam(name = "id") final long id,
			@ModelAttribute final BookNakanoInputForm bookNakanoInputForm) {

		// IDをキーにBookMainテーブルを検索する
		BookMainNakano bookMain = bookNakanoService.getBook(id);

		// フォームにレコードの値をセットする
		bookNakanoInputForm.initWithBookMain(bookMain);
		return "booknakano/updatenakano";
	}

	/**
	 * BookMainテーブルのデータを更新して検索画面に遷移する
	 *
	 * @param BookNakanoInputForm form
	 * @param BindingResult bindingResult
	 * @return 入力エラーがある場合更新画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "update")
	public String updateBook(@Validated final BookNakanoInputForm form,
			final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合自画面に戻る
			return "booknakano/updatenakano";
		}

		// データを更新する
		BookMainNakano bookMain = bookNakanoService.updateBook(form);
		if (bookMain == null) {

			// 更新が失敗した場合、検索画面にメッセージを表示する
			return "redirect:/booknakano?result=updatefailed";
		}
		return "redirect:/booknakano?result=update&id=" + bookMain.getId();
	}

	/**
	 * BookMainテーブルのレコードを論理削除して検索画面に遷移する
	 *
	 * @param long id
	 * @return 検索画面のパス
	 */
	@GetMapping("delete")
	public String deleteBook(@RequestParam(name = "id") final long id) {

		// IDをキーにレコードを論理削除する
		bookNakanoService.deleteBookById(id);
		return "redirect:/booknakano?result=delete&id=" + id;
	}

	/**
	 * 完全削除画面に遷移する
	 *
	 * @param BookNakanoSearchForm form
	 * @param BookNakanoDeleteForm bookNakanoDeleteForm
	 * @param Model model
	 * @return 完全削除画面のパス
	 */
	@GetMapping(value = "deletecomp")
	public String showDeleteCompBook(final BookNakanoSearchForm form,
			@ModelAttribute final BookNakanoDeleteForm bookNakanoDeleteForm, final Model model) {

		// BookMainテーブルから削除フラグが1のレコードを検索する
		final List<BookMainNakano> bookList = bookNakanoService.getListBook(form);

		// Modelに検索結果を格納する
		model.addAttribute(bookList);
		return "booknakano/deletecompnakano";
	}

	/**
	 * BookMainテーブルのデータを完全削除して検索画面に遷移する
	 *
	 * @param BookNakanoDeleteForm form
	 * @param BindingResult bindingResult
	 * @param Model model
	 * @return 入力エラーがある場合完全削除画面、ない場合検索画面のパス
	 */
	@PostMapping(value = "deletecomp")
	public String deleteCompBook(@Validated final BookNakanoDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {

			// 入力エラーがある場合、再検索して自画面に戻る
			BookNakanoSearchForm bookNakanoSearchForm = new BookNakanoSearchForm();
			bookNakanoSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<BookMainNakano> bookList = bookNakanoService.getListBook(bookNakanoSearchForm);

			// Modelに検索結果を格納する
			model.addAttribute(bookList);
			return "booknakano/deletecompnakano";
		}

		// データを完全削除する
		bookNakanoService.deleteBookComp(form.getDeleteIds());
		return "redirect:/booknakano?result=deletecomp";
	}
}
