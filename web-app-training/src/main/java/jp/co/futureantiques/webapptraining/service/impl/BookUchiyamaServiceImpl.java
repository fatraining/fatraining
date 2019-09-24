package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.bookUchiyama.BookMainUchiyama;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.GenreUchiyama;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.WriterUchiyama;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaInputForm;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaSearchForm;
import jp.co.futureantiques.webapptraining.repository.bookUchiyama.BookMainUchiyamaRepository;
import jp.co.futureantiques.webapptraining.repository.bookUchiyama.GenreUchiyamaRepository;
import jp.co.futureantiques.webapptraining.repository.bookUchiyama.WriterUchiyamaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.BookUchiyamaSpecification;
import jp.co.futureantiques.webapptraining.service.BookUchiyamaService;

@Service
public class BookUchiyamaServiceImpl implements BookUchiyamaService {
	private final BookMainUchiyamaRepository bookMainUchiyamaRepository;
	private final GenreUchiyamaRepository genreUchiyamaRepository;
	private final WriterUchiyamaRepository writerUchiyamaRepository;

	@Autowired
	public BookUchiyamaServiceImpl(BookMainUchiyamaRepository bookMainUchiyamaRepository,
			GenreUchiyamaRepository genreUchiyamaRepository,
			WriterUchiyamaRepository writerUchiyamaRepository) {
		this.bookMainUchiyamaRepository = bookMainUchiyamaRepository;
		this.genreUchiyamaRepository = genreUchiyamaRepository;
		this.writerUchiyamaRepository = writerUchiyamaRepository;
	}

	@Override
	public List<GenreUchiyama> getListGenre() {
		return genreUchiyamaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<WriterUchiyama> getListWriter() {
		return writerUchiyamaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<BookMainUchiyama> getPageBook(final BookUchiyamaSearchForm form, final Pageable pageable) {
		return bookMainUchiyamaRepository.findAll(BookUchiyamaSpecification.generateBookSpecification(form), pageable);
	}

	@Override
	public List<BookMainUchiyama> getListBook(final BookUchiyamaSearchForm form) {
		return bookMainUchiyamaRepository.findAll(BookUchiyamaSpecification.generateBookSpecification(form));
	}

	@Override
	public BookMainUchiyama getBook(final long id) {
		return bookMainUchiyamaRepository.findOne(id);
	}

	@Override
	public BookMainUchiyama insertBook(final BookUchiyamaInputForm form) {
		final BookMainUchiyama bookMainUchiyama = form.convertToBookMainUchiyamaForInsert();
		return bookMainUchiyamaRepository.save(bookMainUchiyama);
	}

	@Override
	public BookMainUchiyama updateBook(final BookUchiyamaInputForm form) {
		BookMainUchiyama bookMainUchiyama = bookMainUchiyamaRepository.findOne((long) form.getId());
		if (bookMainUchiyama != null) {
			if (form.getUpdateDate().equals(String.valueOf(bookMainUchiyama.getUpdateDate()))) {
				bookMainUchiyama = form.convertToBookMainUchiyamaForUpdate(bookMainUchiyama);
				return bookMainUchiyamaRepository.saveAndFlush(bookMainUchiyama);
			}
		}
		return null;
	}

	@Override
	public void deleteBookById(final long id) {
		BookMainUchiyama bookMainUchiyama = bookMainUchiyamaRepository.findOne(id);
		if (bookMainUchiyama != null) {
			bookMainUchiyamaRepository.delete(id);
		}
	}

	@Override
	public void deleteBookComp(final ArrayList<Long> ids) {
		bookMainUchiyamaRepository.deleteComp(ids);
	}




}

