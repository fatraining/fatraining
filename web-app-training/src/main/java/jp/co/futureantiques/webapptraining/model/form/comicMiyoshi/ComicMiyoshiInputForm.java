package jp.co.futureantiques.webapptraining.model.form.comicMiyoshi;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.comicMiyoshi.ComicMainMiyoshi;
import lombok.Data;

/**
 * 漫画登録・更新画面用のFormクラス
 * @author Miyoshi
 */
@Data
public class ComicMiyoshiInputForm {

	/** 漫画ID */
	private int id;

	/** 漫画タイトル */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256,message = "comic.text.error.limit")
	private String comicTitle;

	/** 連載雑誌ID */
	private Integer magazineId;

	/** 原作者 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256,message = "comic.text.error.limit")
	private String author;

	/** 巻数 */
	@Pattern(regexp ="[0-9]{1,3}?",message = "comic.text.error.volume")
	private String volumeStr;

	/** コメント */
	@Size(max = 256,message = "comic.text.error.comment")
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 * @param comicMainMiyoshi
	 */
	public void initWithComicMainMiyoshi(ComicMainMiyoshi comicMainMiyoshi) {
		this.setId((int)comicMainMiyoshi.getId());
		this.setComicTitle(comicMainMiyoshi.getComicTitle());
		this.setMagazineId(comicMainMiyoshi.getMagazineId());
		this.setAuthor(comicMainMiyoshi.getAuthor());
		this.setVolumeStr(String.valueOf(comicMainMiyoshi.getVolume()));
		this.setComment(comicMainMiyoshi.getComment());
		this.setUpdateDate(String.valueOf(comicMainMiyoshi.getUpdateDate()));
	}

	/**
	 * ComicMainMiyoshiエンティティに登録値を入れる
	 * @return ComicMainMiyoshi
	 */
	public ComicMainMiyoshi convertToComicMainMiyoshiForInsert() {
		ComicMainMiyoshi comicMainMiyoshi = new ComicMainMiyoshi();
		comicMainMiyoshi = convertToComicMainMiyoshi(comicMainMiyoshi);
		comicMainMiyoshi.setCreateDate(new Timestamp(new Date().getTime()));
		comicMainMiyoshi.setUpdateDate(comicMainMiyoshi.getCreateDate());
		return comicMainMiyoshi;
	}

	/**
	 * ComicMainMiyoshiエンティティに更新値を入れる
	 * @param ComicMainMiyoshi comicMainMiyoshi
	 * @return ComicMainMiyoshi
	 */
	public ComicMainMiyoshi convertToComicMainMiyoshiForUpdate(ComicMainMiyoshi comicMainMiyoshi) {
		comicMainMiyoshi = convertToComicMainMiyoshi(comicMainMiyoshi);
		comicMainMiyoshi.setUpdateDate(new Timestamp(new Date().getTime()));
		return comicMainMiyoshi;
	}

	/**
	 * ComicMainMiyoshiエンティティに入力値を入れる
	 * @param ComicMainMiyoshi comicMainMiyoshi
	 * @return ComicMainMiyoshi
	 */
	private ComicMainMiyoshi convertToComicMainMiyoshi(ComicMainMiyoshi comicMainMiyoshi) {
		comicMainMiyoshi.setComicTitle(this.comicTitle);
		if(this.magazineId == CommonConst.NOT_ENTERD) {

			//連載雑誌が入力されていなかった場合
			comicMainMiyoshi.setMagazineId(null);
		}else {

			//連載雑誌が入力されていなかった場合
			comicMainMiyoshi.setMagazineId(this.magazineId);
		}
		comicMainMiyoshi.setAuthor(this.author);
		comicMainMiyoshi.setVolume(Integer.parseInt(this.volumeStr));
		comicMainMiyoshi.setComment(this.comment);
		comicMainMiyoshi.setDelFlg("0");
		return comicMainMiyoshi;
	}
}
