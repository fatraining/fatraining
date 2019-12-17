package jp.co.futureantiques.webapptraining.model.form.boowyWaki;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.boowyWaki.BoowyMainWaki;
import lombok.Data;

/**
 * BOØWYの曲登録・更新画面用のFormクラス
 *
 * @author WAKI
 * */
@Data
public class BoowyWakiInputForm {

	/** ID */
	private int id;

	/** 曲名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 100)
	private String name;

	/** リリース日 */
	@Size(max = 10, message = "common.text.error.size.max.ten")
	@Pattern(regexp = ("^([0-9]{4}/[0-9]{2}/[0-9]{2})$"), message = "common.text.error.numeric")
	private String releaseDate;

	/** ジャンルID */
	private Integer genreId;

	/** 曲の長さ */
	@Size(max = 5, message = "common.text.error.size.max.five")
	@Pattern(regexp = ("^([0-9]{2}:[0-9]{2})$"), message = "common.text.error.numeric")
	private String length;

	/** 作詞者ID */
	private Integer songwriterId;

	/** コメント */
	@Size(max = 200)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param BoowyMainWaki
	 * */
	public void initWithBoowyMainWaki(BoowyMainWaki boowyMainWaki) {
		this.setId((int) boowyMainWaki.getId());
		this.setName(boowyMainWaki.getName());
		this.setGenreId(boowyMainWaki.getGenreId());
		this.setSongwriterId(boowyMainWaki.getSongwriterId());
		this.setReleaseDate(boowyMainWaki.getReleaseDate());
		this.setLength(boowyMainWaki.getLength());
		this.setComment(boowyMainWaki.getComment());
		this.setUpdateDate(String.valueOf(boowyMainWaki.getUpdateDate()));
		}

	/**
	 * BoowyMainWakiエンティティに登録値を入れる。
	 *
	 * @return BoowyMainWaki
	 * */
	public BoowyMainWaki convertToBoowyMainWakiForInsert() {
		BoowyMainWaki boowyMainWaki = new BoowyMainWaki();
		boowyMainWaki = convertToBoowyMainWaki(boowyMainWaki);
		boowyMainWaki.setCreateDate(new Timestamp(new Date().getTime()));
		boowyMainWaki.setUpdateDate(boowyMainWaki.getCreateDate());
		return boowyMainWaki;
	}

	/**
	 * BoowyMainWakiエンティティに更新値を入れる。
	 *
	 * @param BoowyMainWaki boowyMainWaki
	 * @return BoowyMainWaki
	 * */
	public BoowyMainWaki convertToBoowyMainWakiForUpdate(BoowyMainWaki boowyMainWaki) {
		boowyMainWaki = convertToBoowyMainWaki(boowyMainWaki);
		boowyMainWaki.setUpdateDate(new Timestamp(new Date().getTime()));
		return boowyMainWaki;
	}

	/**
	 * BoowyMainWakiエンティティに入力値を入れる。
	 *
	 * @param BoowyMainWaki boowyMainWaki
	 * @return BoowyMainWaki
	 * */
	private BoowyMainWaki convertToBoowyMainWaki(BoowyMainWaki boowyMainWaki) {
		boowyMainWaki.setName(this.name);
		if(this.genreId == CommonConst.NOT_ENTERD) {

			// ジャンルが入力されていなかった場合
			boowyMainWaki.setGenreId(null);
		}else {

			// ジャンルが入力されていた場合
			boowyMainWaki.setGenreId(this.genreId);

		}
		if(this.songwriterId == CommonConst.NOT_ENTERD) {

			// 作詞者が入力されていなかった場合
			boowyMainWaki.setSongwriterId(null);
		}else {

			// 作詞者が入力されていた場合
			boowyMainWaki.setSongwriterId(this.songwriterId);
		}

		boowyMainWaki.setReleaseDate(this.releaseDate);
		boowyMainWaki.setLength(this.length);
		boowyMainWaki.setComment(this.comment);
		boowyMainWaki.setDelFlg("0");
		return boowyMainWaki;
	}
}