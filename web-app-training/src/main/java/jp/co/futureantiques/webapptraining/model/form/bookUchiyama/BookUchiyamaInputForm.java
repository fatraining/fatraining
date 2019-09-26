package jp.co.futureantiques.webapptraining.model.form.bookUchiyama;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.bookUchiyama.BookMainUchiyama;
import lombok.Data;;

/**
 * 本登録・更新フォーム
 * @author FutureAntiques
 */
@Data
public class BookUchiyamaInputForm {
	/** 本ID */
	private int id;
	/** 本タイトル */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256, message = "magazine.text.error.invalid.name")
	private String bookTitle;
	/** ジャンルID */
	private Integer genreId;
	/** 作家ID */
	private Integer writerId;
	/** 刊行年(フォーム文字列) */
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;
	/** 刊行年(モデル) */
	private Integer releaseYear;
	/** コメント */
	@Size(max = 256, message = "magazine.text.error.invalid.name")
	private String comment;
	/** 更新日時 */
	private String updateDate;

	/**
	 * フォームのフィールドに引数のエンティティをセット
	 * @param BookMainUchiyama bookMainUchiyama
	 */
	public void initWithBookMainUchiyama(BookMainUchiyama bookMainUchiyama) {
		releaseYear = bookMainUchiyama.getReleaseYear();
		this.setId((int) bookMainUchiyama.getId());
		this.setBookTitle(bookMainUchiyama.getBookTitle());
		this.setGenreId(bookMainUchiyama.getGenreId());
		this.setWriterId(bookMainUchiyama.getWriterId());
		if (releaseYear != null) {
			//刊行年が登録されていれば、フォーム文字列にセット
			this.setReleaseYearStr(String.valueOf(bookMainUchiyama.getReleaseYear()));
		}
		this.setComment(bookMainUchiyama.getComment());
		this.setUpdateDate(String.valueOf(bookMainUchiyama.getUpdateDate()));
	}

	/**
	 * 登録用エンティティにフォームの内容をセット
	 * 登録日、更新日時を生成し登録
	 * @return bookMainUchiyama
	 */
	public BookMainUchiyama convertToBookMainUchiyamaForInsert() {
		BookMainUchiyama bookMainUchiyama = new BookMainUchiyama();
		bookMainUchiyama = convertToBookMainUchiyama(bookMainUchiyama);
		bookMainUchiyama.setCreateDate(new Timestamp(new Date().getTime()));
		bookMainUchiyama.setUpdateDate(bookMainUchiyama.getCreateDate());
		return bookMainUchiyama;
	}

	/**
	 * 更新用エンティティにフォームの内容をセット
	 * @param BookMainUchiyama bookMainUchiyama
	 * @return bookMainUchiyama
	 */
	public BookMainUchiyama convertToBookMainUchiyamaForUpdate(BookMainUchiyama bookMainUchiyama) {
		bookMainUchiyama = convertToBookMainUchiyama(bookMainUchiyama);
		bookMainUchiyama.setUpdateDate(new Timestamp(new Date().getTime()));
		return bookMainUchiyama;
	}

	/**
	 * 引数のエンティティにフォームの内容をセット
	 * @param bookMainUchiyama
	 * @return bookMainUchiyama
	 */
	private BookMainUchiyama convertToBookMainUchiyama(BookMainUchiyama bookMainUchiyama) {
		bookMainUchiyama.setBookTitle(this.bookTitle);
		bookMainUchiyama.setGenreId(this.genreId);
		bookMainUchiyama.setWriterId(this.writerId);
		if (!releaseYearStr.isEmpty()) {
			bookMainUchiyama.setReleaseYear(Integer.parseInt(releaseYearStr));
		}
		bookMainUchiyama.setComment(this.comment);
		bookMainUchiyama.setDelFlg("0");
		return bookMainUchiyama;
	}
}
