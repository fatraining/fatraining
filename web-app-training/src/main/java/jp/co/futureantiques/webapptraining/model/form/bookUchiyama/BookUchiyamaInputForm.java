package jp.co.futureantiques.webapptraining.model.form.bookUchiyama;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.bookUchiyama.BookMainUchiyama;
import lombok.Data;;

@Data
public class BookUchiyamaInputForm {
	private int id;

	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String bookTitle;
	private Integer genreId;
	private Integer writerId;

	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;
	private Integer releaseYear;

	@Size(max = 255)
	private String comment;
	private String updateDate;

	public void initWithBookMainUchiyama(BookMainUchiyama bookMainUchiyama) {
		releaseYear = bookMainUchiyama.getReleaseYear();
		this.setId((int) bookMainUchiyama.getId());
		this.setBookTitle(bookMainUchiyama.getBookTitle());
		this.setGenreId(bookMainUchiyama.getGenreId());
		this.setWriterId(bookMainUchiyama.getWriterId());
		if (releaseYear != null) {
			this.setReleaseYearStr(String.valueOf(bookMainUchiyama.getReleaseYear()));
		}
		this.setComment(bookMainUchiyama.getComment());
		this.setUpdateDate(String.valueOf(bookMainUchiyama.getUpdateDate()));
	}

	public BookMainUchiyama convertToBookMainUchiyamaForInsert() {
		BookMainUchiyama bookMainUchiyama = new BookMainUchiyama();
		bookMainUchiyama = convertToBookMainUchiyama(bookMainUchiyama);
		bookMainUchiyama.setCreateDate(new Timestamp(new Date().getTime()));
		bookMainUchiyama.setUpdateDate(bookMainUchiyama.getCreateDate());
		return bookMainUchiyama;
	}

	public BookMainUchiyama convertToBookMainUchiyamaForUpdate(BookMainUchiyama bookMainUchiyama) {
		bookMainUchiyama = convertToBookMainUchiyama(bookMainUchiyama);
		bookMainUchiyama.setUpdateDate(new Timestamp(new Date().getTime()));
		return bookMainUchiyama;
	}

	private BookMainUchiyama convertToBookMainUchiyama(BookMainUchiyama bookMainUchiyama) {
		bookMainUchiyama.setBookTitle(this.bookTitle);
		bookMainUchiyama.setGenreId(this.genreId);
		bookMainUchiyama.setWriterId(this.writerId);
		bookMainUchiyama.setReleaseYear(this.getReleaseYear());
		bookMainUchiyama.setComment(this.comment);
		bookMainUchiyama.setDelFlg("0");
		return bookMainUchiyama;
	}

}
