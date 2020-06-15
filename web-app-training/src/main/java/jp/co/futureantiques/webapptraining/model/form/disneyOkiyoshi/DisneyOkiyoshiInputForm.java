package jp.co.futureantiques.webapptraining.model.form.disneyOkiyoshi;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.DisneyMainOkiyoshi;
import lombok.Data;

/**
 * 映画登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data
public class DisneyOkiyoshiInputForm {

	/** ID */
	private int id;

	/** 店舗名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String restaurantName;

	/** エリアID */
	private Integer ereaId;

	/** ジャンルID */
	private Integer genreId;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param disneyMain
	 */
	public void initWithDisneyMain(DisneyMainOkiyoshi disneyMainOkiyoshi) {
		this.setId((int) disneyMainOkiyoshi.getId());
		this.setRestaurantName(disneyMainOkiyoshi.getRestaurantName());
		this.setGenreId(disneyMainOkiyoshi.getGenreId());
		this.setEreaId(disneyMainOkiyoshi.getEreaId());
		this.setComment(disneyMainOkiyoshi.getComment());
		this.setUpdateDate(String.valueOf(disneyMainOkiyoshi.getUpdateDate()));
	}

	/**
	 * DisneyMainエンティティに登録値を入れる
	 *
	 * @return DisneyMain
	 */
	public DisneyMainOkiyoshi convertToDisneyMainForInsert() {
		DisneyMainOkiyoshi disneyMainOkiyoshi = new DisneyMainOkiyoshi();
		disneyMainOkiyoshi = convertToDisneyMain(disneyMainOkiyoshi);
		disneyMainOkiyoshi.setCreateDate(new Timestamp(new Date().getTime()));
		disneyMainOkiyoshi.setUpdateDate(disneyMainOkiyoshi.getCreateDate());
		return disneyMainOkiyoshi;
	}

	/**
	 * DisneyMainエンティティに更新値を入れる
	 *
	 * @param DisneyMainOkiyoshi disneyMain
	 * @return DisneyMain
	 */
	public DisneyMainOkiyoshi convertToDisneyMainForUpdate(DisneyMainOkiyoshi disneyMain) {
		disneyMain = convertToDisneyMain(disneyMain);
		disneyMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return disneyMain;
	}

	/**
	 * DisneyMainエンティティに入力値を入れる
	 *
	 * @param DisneyMainOkiyoshi disneyMain
	 * @return DisneyMain
	 */
	private DisneyMainOkiyoshi convertToDisneyMain(DisneyMainOkiyoshi disneyMainOkiyoshi) {
		disneyMainOkiyoshi.setRestaurantName(this.restaurantName);
		if (this.ereaId == CommonConst.NOT_ENTERD) {

			// エリアが入力されていなかった場合
			disneyMainOkiyoshi.setEreaId(null);
		} else {

			// エリアが入力されていた場合
			disneyMainOkiyoshi.setEreaId(this.ereaId);
		}
		if (this.genreId == CommonConst.NOT_ENTERD) {

			// ジャンルが入力されていなかった場合
			disneyMainOkiyoshi.setGenreId(null);
		} else {

			// ジャンルが入力されていた場合
			disneyMainOkiyoshi.setGenreId(this.genreId);
		}

		disneyMainOkiyoshi.setComment(this.comment);
		disneyMainOkiyoshi.setDelFlg("0");
		return disneyMainOkiyoshi;
	}
}