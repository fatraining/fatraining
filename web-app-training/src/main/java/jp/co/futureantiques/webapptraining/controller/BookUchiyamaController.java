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
import org.springframework.web.multipart.MultipartFile;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.BookMainUchiyama;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.GenreUchiyama;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.WriterUchiyama;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaDeleteForm;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaInputForm;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaSearchForm;
import jp.co.futureantiques.webapptraining.service.BookUchiyamaService;

@Controller
@RequestMapping(value = "/bookUchiyama")
public class BookUchiyamaController {
	private final BookUchiyamaService bookUchiyamaService;

	@Autowired
	public BookUchiyamaController(final BookUchiyamaService bookUchiyamaService) {
		this.bookUchiyamaService = bookUchiyamaService;
	}

	@ModelAttribute
	public List<GenreUchiyama> getListGenre() {
		return bookUchiyamaService.getListGenre();
	}

	@ModelAttribute
	public List<WriterUchiyama> getListWriter() {
		return bookUchiyamaService.getListWriter();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showSearchBook(@ModelAttribute final BookUchiyamaSearchForm bookUchiyamaSearchForm) {
		return "bookUchiyama/search";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String showSearchBook(final BookUchiyamaSearchForm form, final Model model, final Pageable pageable) {
		final Page<BookMainUchiyama> bookList = bookUchiyamaService.getPageBook(form, pageable);
		if (bookList.getTotalElements() != 0) {

			model.addAttribute("page", bookList);
			model.addAttribute("bookList", bookList.getContent());
			model.addAttribute("url", "search");

		}
		return "bookUchiyama/search";
	}

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

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insertBook(@ModelAttribute @Validated final BookUchiyamaInputForm form,
		final BindingResult bindingResult) {
		if (bindingResult.hasFieldErrors()) {
			return "bookUchiyama/insert";
		}

		final BookMainUchiyama bookMainUchiyama = bookUchiyamaService.insertBook(form);
		return "redirect:/bookUchiyama?result=insert&id=" + bookMainUchiyama.getId();
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String showUpdateBook(@RequestParam(name = "id") final long id,
			@ModelAttribute final BookUchiyamaInputForm bookUchiyamaInputForm) {
		BookMainUchiyama bookMainUchiyama = bookUchiyamaService.getBook(id);
		bookUchiyamaInputForm.initWithBookMainUchiyama(bookMainUchiyama);
		return "bookUchiyama/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateBook(@Validated final BookUchiyamaInputForm form,
			final BindingResult bindingResult, MultipartFile photo) {
		if (bindingResult.hasFieldErrors()) {
			return "bookUchiyama/update";
		}

		BookMainUchiyama bookMainUchiyama = bookUchiyamaService.updateBook(form);
		if (bookMainUchiyama == null) {
			return "redirect:/bookUchiyama?result=updatefailed";
		}
		return "redirect:/bookUchiyama?result=update&id=" + bookMainUchiyama.getId();
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteBook(@RequestParam(name = "id") final long id) {
		bookUchiyamaService.deleteBookById(id);
		return "redirect:/bookUchiyama?result=delete&id=" + id;
	}

	@RequestMapping(value = "deletecomp", method = RequestMethod.GET)
	public String showDeleteCompBook(final BookUchiyamaSearchForm form,
			@ModelAttribute final BookUchiyamaDeleteForm bookUchiyamaDeleteForm, final Model model) {
		final List<BookMainUchiyama> bookList = bookUchiyamaService.getListBook(form);
		model.addAttribute(bookList);
		return "bookUchiyama/deletecomp";
	}

	@RequestMapping(value = "deletecomp", method = RequestMethod.POST)
	public String deleteCompBook(@Validated final BookUchiyamaDeleteForm form,
			final BindingResult bindingResult, final Model model) {
		if (bindingResult.hasFieldErrors()) {
			BookUchiyamaSearchForm bookUchiyamaSearchForm = new BookUchiyamaSearchForm();
			bookUchiyamaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
			final List<BookMainUchiyama> bookList = bookUchiyamaService.getListBook(bookUchiyamaSearchForm);

			model.addAttribute(bookList);
			return "bookUchiyama/deletecomp";
		}

		bookUchiyamaService.deleteBookComp(form.getDeleteIds());
		return "redirect:/bookUchiyama?result=deletecomp";
	}

}
