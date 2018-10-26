package jp.co.futureantiques.webapptraining.model.form.dramaHashiyama;




import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.dramaHashiyama.DramaMainHashiyama;
import lombok.Data;

/**
 * ドラマ登録・更新画面用のFormクラス
 *
 * @author hashiyama
 */
@Data
public class DramaInputForm {

	/** ID */
	private int id;

	/** ドラマ名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 300)
	private String dramaTitle;

	/** 主演ID */
	private Integer actorId;

	/** テレビ局ID */
	private Integer channelId;

	/** 放送年 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** 上映時間 */
	@Size(min = 0, max = 2, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String runTimeStr;



	/** コメント */
	@Size(max = 300)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param dramaMainHashiyama
	 */
	public void initWithDramaMainHashiyama(DramaMainHashiyama dramaMainHashiyama) {
		this.setId((int) dramaMainHashiyama.getId());
		this.setDramaTitle(dramaMainHashiyama.getDramaTitle());
		this.setActorId(dramaMainHashiyama.getActorId());
		this.setChannelId(dramaMainHashiyama.getChannelId());
		this.setReleaseYearStr(String.valueOf(dramaMainHashiyama.getReleaseYear()));
		if (dramaMainHashiyama.getRunTime() != null) {
			this.setRunTimeStr(String.valueOf(dramaMainHashiyama.getRunTime()));
		}
		this.setComment(dramaMainHashiyama.getComment());
		this.setUpdateDate(String.valueOf(dramaMainHashiyama.getUpdateDate()));
	}

	/**
	 * dramaMainHashiyamaエンティティに登録値を入れる
	 *
	 * @return dramaMainHashiyama
	 */
	public DramaMainHashiyama convertToDramaMainaHashiyamaForInsert() {
		DramaMainHashiyama dramaMainHashiyama = new DramaMainHashiyama();
		dramaMainHashiyama = convertToDramaMainHashiyama(dramaMainHashiyama);
		dramaMainHashiyama.setCreateDate(new Timestamp(new Date().getTime()));
		dramaMainHashiyama.setUpdateDate(dramaMainHashiyama.getCreateDate());
		return dramaMainHashiyama;
	}

	/**
	 * DramaMainHashiyamaエンティティに更新値を入れる
	 *
	 * @param DramaMainHashiyama dramaMainHashiyama
	 * @return DramaMainHashiyama
	 */
	public DramaMainHashiyama convertToDramaMainHashiyamaForUpdate(DramaMainHashiyama dramaMainHashiyama) {
		dramaMainHashiyama = convertToDramaMainHashiyama(dramaMainHashiyama);
		dramaMainHashiyama.setUpdateDate(new Timestamp(new Date().getTime()));
		return dramaMainHashiyama;
	}

	/**
	 * DramaMainHashiyamaエンティティに入力値を入れる
	 *
	 * @param DramaMainHashiyama dramaMainHashiyama
	 * @return DramaMainHashiyama
	 */

	private DramaMainHashiyama convertToDramaMainHashiyama(DramaMainHashiyama dramaMainHashiyama) {
		dramaMainHashiyama.setDramaTitle(this.dramaTitle);
		dramaMainHashiyama.setActorId(this.actorId);
		dramaMainHashiyama.setChannelId(this.channelId);
		dramaMainHashiyama.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		if (!this.runTimeStr.isEmpty()) {

			// 上映時間が入力されていた場合
			dramaMainHashiyama.setRunTime(Integer.parseInt(this.runTimeStr));
		} else {

			// 上映時間が入力されていなかった場合
			dramaMainHashiyama.setRunTime(null);
		}
		dramaMainHashiyama.setComment(this.comment);
		dramaMainHashiyama.setDelFlg("0");
		return dramaMainHashiyama;
	}
}