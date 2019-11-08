package jp.co.futureantiques.webapptraining.model.form.novelOkudaira;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.NovelMainOkudaira;
import lombok.Data;

/**
 * 小説登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data
public class NovelOkudairaInputForm {

	/** ID */
	private int id;

	/** 作品名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String novelTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 作者ID */
	private Integer writerId;

	/** 出版年 */
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String publicationYearStr;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param novelMainOkudaira
	 */
	public void initWithNovelMainOkudaira(NovelMainOkudaira novelMainOkudaira) {
		this.setId((int) novelMainOkudaira.getId());
		this.setNovelTitle(novelMainOkudaira.getNovelTitle());
		this.setGenreId(novelMainOkudaira.getGenreId());
		this.setWriterId(novelMainOkudaira.getWriterId());
		this.setPublicationYearStr(String.valueOf(novelMainOkudaira.getPublicationYear()));
		this.setComment(novelMainOkudaira.getComment());
		this.setUpdateDate(String.valueOf(novelMainOkudaira.getUpdateDate()));
	}

	/**
	 * NovelMainOkudairaエンティティに登録値を入れる
	 *
	 * @return NovelMainOkudaira
	 */
	public NovelMainOkudaira convertToNovelMainOkudairaForInsert() {
		NovelMainOkudaira novelMainOkudaira = new NovelMainOkudaira();
		novelMainOkudaira = convertToNovelMainOkudaira(novelMainOkudaira);
		novelMainOkudaira.setCreateDate(new Timestamp(new Date().getTime()));
		novelMainOkudaira.setUpdateDate(novelMainOkudaira.getCreateDate());
		return novelMainOkudaira;
	}

	/**
	 * NovelMainOkudairaエンティティに更新値を入れる
	 *
	 * @param NovelMainOkudaira novelMainOkudaira
	 * @return NovelMainOkudaira
	 */
	public NovelMainOkudaira convertToNovelMainOkudairaForUpdate(NovelMainOkudaira novelMainOkudaira) {
		novelMainOkudaira = convertToNovelMainOkudaira(novelMainOkudaira);
		novelMainOkudaira.setUpdateDate(new Timestamp(new Date().getTime()));
		return novelMainOkudaira;
	}

	/**
	 * NovelMainOkudairaエンティティに入力値を入れる
	 *
	 * @param NovelMainOkudaira novelMainOkudaira
	 * @return NovelMainOkudaira
	 */
	private NovelMainOkudaira convertToNovelMainOkudaira(NovelMainOkudaira novelMainOkudaira) {
		novelMainOkudaira.setNovelTitle(this.novelTitle);
		if(this.genreId == CommonConst.NOT_ENTERD) {

			// ジャンルが入力されていなかった場合
			novelMainOkudaira.setGenreId(null);
		}else {

			// ジャンルが入力されていた場合
			novelMainOkudaira.setGenreId(this.genreId);
		}
		if(this.writerId == CommonConst.NOT_ENTERD) {

			// 作者が入力されていなかった場合
			novelMainOkudaira.setWriterId(null);
		}else {

			// 作者が入力されていた場合
			novelMainOkudaira.setWriterId(this.writerId);
		}
		if (!this.publicationYearStr.isEmpty()) {

			// 出版年が入力されていた場合
			novelMainOkudaira.setPublicationYear(Integer.parseInt(this.publicationYearStr));
		} else {

			// 出版年が入力されていなかった場合
			novelMainOkudaira.setPublicationYear(null);
		}
		novelMainOkudaira.setComment(this.comment);
		novelMainOkudaira.setDelFlg("0");
		return novelMainOkudaira;
	}
}