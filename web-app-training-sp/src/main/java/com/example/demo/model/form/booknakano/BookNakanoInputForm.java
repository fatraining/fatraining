package com.example.demo.model.form.booknakano;

import java.sql.Timestamp;
import java.util.Date;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.booknakano.BookMainNakano;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 書籍登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data
public class BookNakanoInputForm {

	/** ID */
	private int id;

	/** 書籍名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String bookTitle;

	/** 著者ID */
	private Integer authorId;

	/** 分類ID */
	@Positive(message = "common.text.error.require")
	private Integer classificationId;

	/** 文字遣い種別ID */
	private Integer characterOrthographyId;

	/** 初出 */
	@Size(max = 255)
	private String firstAppearance;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param bookMain
	 */
	public void initWithBookMain(BookMainNakano bookMain) {
		this.setId((int) bookMain.getId());
		this.setBookTitle(bookMain.getBookTitle());
		this.setAuthorId(bookMain.getAuthorId());
		this.setClassificationId(bookMain.getClassificationId());
		this.setCharacterOrthographyId(bookMain.getCharacterOrthographyId());
		this.setFirstAppearance(bookMain.getFirstAppearance());
		this.setUpdateDate(String.valueOf(bookMain.getUpdateDate()));
	}

	/**
	 * BookMainエンティティに登録値を入れる
	 *
	 * @return BookMain
	 */
	public BookMainNakano convertToBookMainForInsert() {
		BookMainNakano bookMain = new BookMainNakano();
		bookMain = convertToBookMain(bookMain);
		bookMain.setCreateDate(new Timestamp(new Date().getTime()));
		bookMain.setUpdateDate(bookMain.getCreateDate());
		return bookMain;
	}

	/**
	 * BookMainエンティティに更新値を入れる
	 *
	 * @param BookMainNakano bookMain
	 * @return BookMain
	 */
	public BookMainNakano convertToBookMainForUpdate(BookMainNakano bookMain) {
		bookMain = convertToBookMain(bookMain);
		bookMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return bookMain;
	}

	/**
	 * BookMainエンティティに入力値を入れる
	 *
	 * @param BookMainNakano bookMain
	 * @return BookMain
	 */
	private BookMainNakano convertToBookMain(BookMainNakano bookMain) {
		bookMain.setBookTitle(this.bookTitle);
		if (this.authorId == CommonConst.NOT_ENTERD) {

			// 著者が入力されていなかった場合
			bookMain.setAuthorId(null);
		} else {

			// 著者が入力されていた場合
			bookMain.setAuthorId(this.authorId);
		}
		if (this.classificationId == CommonConst.NOT_ENTERD) {

			// 分類が入力されていなかった場合
			bookMain.setClassificationId(null);
		} else {

			// 分類が入力されていた場合
			bookMain.setClassificationId(this.classificationId);
		}
		if (this.characterOrthographyId == CommonConst.NOT_ENTERD) {

			// 文字遣い種別が入力されていなかった場合
			bookMain.setCharacterOrthographyId(null);
		} else {

			// 文字遣い種別が入力されていた場合
			bookMain.setCharacterOrthographyId(this.characterOrthographyId);
		}
		bookMain.setFirstAppearance(this.firstAppearance);
		bookMain.setDelFlg("0");
		return bookMain;
	}
}
