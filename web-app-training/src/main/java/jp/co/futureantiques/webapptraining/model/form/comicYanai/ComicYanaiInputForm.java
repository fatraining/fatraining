package jp.co.futureantiques.webapptraining.model.form.comicYanai;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.comicYanai.ComicMainYanai;
import lombok.Data;

/**漫画追加・更新画面のform
 * @author yanai
 *
 */
@Data
public class ComicYanaiInputForm {

	/** ID */
	private int id;

	/**漫画名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String comicTitle;

	/** ジャンルID */
	private Integer genreId;

	/**出版社ID */
	private Integer pubcoId;

	/** 巻数 */
	@NotBlank(message = "common.text.error.require")
	private Integer volume;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param comicMainYanai
	 */
	public void initWithComicMainYanai(ComicMainYanai comicMainYanai) {
		this.setId((int) comicMainYanai.getId());
		this.setComicTitle(comicMainYanai.getComicTitle());
		this.setGenreId(comicMainYanai.getGenreId());
		this.setPubcoId(comicMainYanai.getPubcoId());
		this.setVolume(comicMainYanai.getVolume());
		this.setComment(comicMainYanai.getComment());
		this.setUpdateDate(String.valueOf(comicMainYanai.getUpdateDate()));
	}

	/**
	 * CoomicMainYanaiエンティティに登録値を入れる
	 *
	 * @return ComicmainYanai
	 */
	public ComicMainYanai convertToComicMainYanaiForInsert() {
		ComicMainYanai comicMainYanai = new ComicMainYanai();
		comicMainYanai = convertToComicMainYanai(comicMainYanai);
		comicMainYanai.setCreateDate(new Timestamp(new Date().getTime()));
		comicMainYanai.setUpdateDate(comicMainYanai.getCreateDate());
		return comicMainYanai;
	}

	/**
	 * ComicMainYanaiエンティティに更新値を入れる
	 *
	 * @param ComicMainYanai comicMainYanai
	 * @return ComicMainYanai
	 */
	public ComicMainYanai convertToComicMainYanaiForUpdate(ComicMainYanai comicMainYanai) {
		comicMainYanai = convertToComicMainYanai(comicMainYanai);
		comicMainYanai.setUpdateDate(new Timestamp(new Date().getTime()));
		return comicMainYanai;
	}

	/**
	 * ComicMainYanaiエンティティに入力値を入れる
	 *
	 * @param ComicMainYanai comicMainYanai
	 * @return ComicMainYanai
	 */
	private ComicMainYanai convertToComicMainYanai(ComicMainYanai comicMainYanai) {
		comicMainYanai.setComicTitle(this.comicTitle);
		if (this.genreId == CommonConst.NOT_ENTERD) {

			// ジャンルが入力されていなかった場合
			comicMainYanai.setGenreId(0);
		} else {

			// ジャンルが入力されていた場合
			comicMainYanai.setGenreId(this.genreId);
		}
		if (this.pubcoId == CommonConst.NOT_ENTERD) {

			// 出版社が入力されていなかった場合
			comicMainYanai.setPubcoId(0);
		} else {

			// 出版社が入力されていた場合
			comicMainYanai.setPubcoId(this.pubcoId);
		}
		comicMainYanai.setVolume(this.volume);
		comicMainYanai.setComment(this.comment);
		comicMainYanai.setDelFlg("0");
		return comicMainYanai;
	}
}
