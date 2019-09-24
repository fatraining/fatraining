package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.bookUchiyama.BookMainUchiyama;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.GenreUchiyama;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.WriterUchiyama;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaInputForm;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaSearchForm;

public interface BookUchiyamaService {

	List<GenreUchiyama> getListGenre();
	List<WriterUchiyama> getListWriter();

	Page<BookMainUchiyama> getPageBook(final BookUchiyamaSearchForm form, final Pageable pageable);

	List<BookMainUchiyama> getListBook(final BookUchiyamaSearchForm form);

	BookMainUchiyama getBook(final long id);

	BookMainUchiyama insertBook(final BookUchiyamaInputForm form);

	BookMainUchiyama updateBook(final BookUchiyamaInputForm form);

	void deleteBookById(final long id);

	void deleteBookComp(final ArrayList<Long> ids);
}
