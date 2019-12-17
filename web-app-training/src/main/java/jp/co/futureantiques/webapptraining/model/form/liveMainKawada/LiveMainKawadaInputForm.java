package jp.co.futureantiques.webapptraining.model.form.liveMainKawada;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.LiveMainKawada;
import lombok.Data;

/**
 * ライブ定番曲登録・更新画面用のFormクラス
 * @author future
 *
 */
@Data
public class LiveMainKawadaInputForm {

	/**曲名ID */
	private int id;

	/** 収録アルバム曲 */
	@NotNull(message = "common.text.error.require")
	@Min(value = 1, message = "common.text.error.require")
	private Integer albumId;

	/** 曲名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String songTitle;

	/** 演奏率 */
	@Size(max = 3, message = "live.text.error.size.max.three")
	@Pattern(regexp =  "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "live.text.error.numeric")
	private String percent;

	/**ライブスタイル */
	@NotNull(message = "common.text.error.require")
	@Min(value = 1, message = "common.text.error.require")
	private Integer styleId;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/**
	 * 更新日時（排他制御用）
	 */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 * @param liveMainKawada
	 */
	public void initWithLiveMainKawada(LiveMainKawada liveMainKawada) {
		this.setId((int) liveMainKawada.getId());
		this.setSongTitle(liveMainKawada.getSongTitle());
		this.setAlbumId(liveMainKawada.getAlbumId());
		if (liveMainKawada.getPercent() != null) {
			this.setPercent(String.valueOf(liveMainKawada.getPercent()));
		}
		this.setStyleId(liveMainKawada.getStyleId());
		this.setComment(liveMainKawada.getComment());
		this.setUpdateDate(String.valueOf(liveMainKawada.getUpdateDate()));
	}

	/**
	 * LiveMainKawadanエンティティに登録値を入れる
	 *
	 * @return LiveMainKawada
	 */
	public LiveMainKawada convertToLiveMainKawadaForInsert() {
		LiveMainKawada liveMainKawada = new LiveMainKawada();
		liveMainKawada = convertToLiveMainKawada(liveMainKawada);
		liveMainKawada.setCreateDate(new Timestamp(new Date().getTime()));
		liveMainKawada.setUpdateDate(liveMainKawada.getCreateDate());
		return liveMainKawada;
	}

	/**
	 * LiveMainKawadaエンティティに更新値を入れる
	 * @param LiveMainKawada liveMainKawada
	 * @return LiveMainKawada
	 */
	public LiveMainKawada convertToLiveMainKawadaForUpdate(LiveMainKawada liveMainKawada) {
		liveMainKawada = convertToLiveMainKawada(liveMainKawada);
		liveMainKawada.setUpdateDate(new Timestamp(new Date().getTime()));
		return liveMainKawada;
	}

	/**
	 * LiveMainKawadaエンティティに入力値を入れる
	 *
	 * @param LiveMainKawada liveMainKawada
	 * @return LiveMainKawada
	 */
	private LiveMainKawada convertToLiveMainKawada(LiveMainKawada liveMainKawada) {
		liveMainKawada.setSongTitle(this.songTitle);
		if (this.albumId == CommonConst.NOT_ENTERD) {

			//収録アルバムが入力されていなかった場合
			liveMainKawada.setAlbumId(null);
		} else {

			//収録アルバムが入力されていた場合
			liveMainKawada.setAlbumId(this.albumId);
		}

		if (this.styleId == CommonConst.NOT_ENTERD) {

			//ライブスタイルが入力されていなかった場合
			liveMainKawada.setStyleId(null);
		} else {

			//ライブスタイルが入力されている場合
			liveMainKawada.setStyleId(this.styleId);
		}
		if (!this.percent.isEmpty()) {

			// 演奏率が入力されていた場合
			liveMainKawada.setPercent(Integer.parseInt(this.percent));
		} else {

			// 演奏率が入力されていなかった場合
			liveMainKawada.setPercent(null);
		}
		liveMainKawada.setComment(this.comment);
		liveMainKawada.setDelFlg("0");
		return liveMainKawada;
	}
}
