package jp.co.futureantiques.webapptraining.model.form.novelmiyamoto;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.novelmiyamoto.BookMainMiyamoto;
import lombok.Data;

/**
 * 本の登録・更新画面用のFormクラス
 */
@Data
public class NovelInputForm {
	/** ID */
	private int id;
	/** 本名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String bookTitle;
	/** ジャンルID */
	private Integer genreId;
	/** 作者ID */
	private Integer authorId;
	/** 発行年 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String yearStr;
	/** 上映時間 */
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String pageStr;
	/** コメント */
	@Size(max = 255)
	private String comment;
	/** 更新日時（排他制御用） */
	private String updateDate;
	/**
	 * フィールドにエンティティの中身を入れる
	 */
	public void initWithBookMainMiyamoto(BookMainMiyamoto bookMainMiyamoto) {
		this.setId((int) bookMainMiyamoto.getId());
		this.setBookTitle(bookMainMiyamoto.getBookTitle());
		this.setGenreId(bookMainMiyamoto.getGenreId());
		this.setAuthorId(bookMainMiyamoto.getAuthorId());
		this.setYearStr(String.valueOf(bookMainMiyamoto.getYear()));
		if (bookMainMiyamoto.getPage() != null) {
			this.setPageStr(String.valueOf(bookMainMiyamoto.getPage()));
		}
		this.setComment(bookMainMiyamoto.getComment());
		this.setUpdateDate(String.valueOf(bookMainMiyamoto.getUpdateDate()));
	}
	/**
	 * BooKMainMiyamotoエンティティに登録値を入れる
	 */
	public BookMainMiyamoto convertToBookMainMiyamotoForInsert() {
		BookMainMiyamoto bookMainMiyamoto = new BookMainMiyamoto();
		bookMainMiyamoto = convertToBookMainMiyamoto(bookMainMiyamoto);
		bookMainMiyamoto.setCreateDate(new Timestamp(new Date().getTime()));
		bookMainMiyamoto.setUpdateDate(bookMainMiyamoto.getCreateDate());
		return bookMainMiyamoto;
	}
	/**
	 * BooKMainMiyamotoエンティティに更新値を入れる
	 */
	public BookMainMiyamoto convertToBookMainMiyamotoForUpdate(BookMainMiyamoto bookMainMiyamoto) {
		bookMainMiyamoto = convertToBookMainMiyamoto(bookMainMiyamoto);
		bookMainMiyamoto.setUpdateDate(new Timestamp(new Date().getTime()));
		return bookMainMiyamoto;
	}
	/**
	 * BooKMainMiyamotoエンティティに入力値を入れる
	 */
	private BookMainMiyamoto convertToBookMainMiyamoto(BookMainMiyamoto bookMainMiyamoto) {
		bookMainMiyamoto.setBookTitle(this.bookTitle);
		bookMainMiyamoto.setGenreId(this.genreId);
		bookMainMiyamoto.setAuthorId(this.authorId);
		bookMainMiyamoto.setYear(Integer.parseInt(this.yearStr));
		if (!this.pageStr.isEmpty()) {
			// 上映時間が入力されていた場合
			bookMainMiyamoto.setPage(Integer.parseInt(this.pageStr));
		} else {
			// 上映時間が入力されていなかった場合
			bookMainMiyamoto.setPage(null);
		}
		bookMainMiyamoto.setComment(this.comment);
		bookMainMiyamoto.setDelFlg("0");
		return bookMainMiyamoto;
	}
}