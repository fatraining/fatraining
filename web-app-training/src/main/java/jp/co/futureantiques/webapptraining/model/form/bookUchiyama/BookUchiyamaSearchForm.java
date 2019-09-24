package jp.co.futureantiques.webapptraining.model.form.bookUchiyama;

import jp.co.futureantiques.webapptraining.model.bookUchiyama.BookMainUchiyama;
import lombok.Data;

@Data

public class BookUchiyamaSearchForm{
	private Integer id;
	private String bookTitle;
	private Integer genreId;
	private Integer writerId;
	private int isDelete;

	public void setValues(BookMainUchiyama bookMainUchiyama) {
		this.setId((int)bookMainUchiyama.getId());
		this.setBookTitle(bookMainUchiyama.getBookTitle());
		this.setGenreId(bookMainUchiyama.getGenreId());
		this.setWriterId(bookMainUchiyama.getWriterId());
	}


}