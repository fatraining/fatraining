package jp.co.futureantiques.webapptraining.model.form.heritageKataoka;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.heritagekataoka.HeritageMainKataoka;
import lombok.Data;

/**
*
* 世界遺産登録・更新画面用のFormクラス
*
* @author MIKI KATAOKA
*/
@Data
public class HeritageInputForm {

	/** 画像*/
	//	後で考える

	/** 世界遺産ID */
	private int id;

	/** 登録名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 49)
	private String heritageName;

	/** ジャンル */
	private Integer genreId;

	/** 更新年 */
	@Size(max = 4, message = "comon.text.error.size.max.four")
	@Pattern(regexp = "^\\d{4}", message = "common.text.error.numeric")
	private String registrationYearStr;

	/** 所在地1 */
	private Integer locationId1;

	/** 所在地2 */
	private Integer locationId2;

	/** 所在地3 */
	private Integer locationId3;

	/** 備考 */
	@Size(max = 199)
	private String remarks;

	/** 更新日時 */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param heritageMainKataoka
	 */
	public void initWithHeritageMain(HeritageMainKataoka heritageMainKataoka) {
		this.setId((int) heritageMainKataoka.getId());
		this.setHeritageName(heritageMainKataoka.getHeritageName());
		this.setGenreId(heritageMainKataoka.getGenreId());
		this.setLocationId1(heritageMainKataoka.getLocationId1());
		this.setRegistrationYearStr(String.valueOf(heritageMainKataoka.getRegistrationYear()));
		/*
		 * Integerで取得したPriceが未入力の場合、DBから"0"という表記が出力される
		 * "null"で返すためには未入力の場合Stringで、入力がある場合はintで値を渡す必要がある
		 */
		//	if (heritageMainKataoka.getPrice() != null) {
		//		this.setPriceStr(String.valueOf(heritageMainKataoka.getPrice()));
		//	}
		this.setRemarks(heritageMainKataoka.getRemarks());
		this.setUpdateDate(String.valueOf(heritageMainKataoka.getUpdateDate()));
	}

	/**
	 * heritageMainエンティティに登録値を入れる
	 *
	 * @return electronicsMain
	 */
	public HeritageMainKataoka convertToHeritageMainForInsert() {
		HeritageMainKataoka heritageMainKataoka = new HeritageMainKataoka();
		heritageMainKataoka = convertToHeritageMain(heritageMainKataoka);
		heritageMainKataoka.setCreateDate(new Timestamp(new Date().getTime()));
		heritageMainKataoka.setUpdateDate(heritageMainKataoka.getCreateDate());
		return heritageMainKataoka;
	}

	/**
	 * heritageMainエンティティに更新値を入れる
	 *
	 * @param HeritageMainKataoka heritageMain
	 * @return HeritageMain
	 */
	public HeritageMainKataoka convertToHeritageMainForUpdate(HeritageMainKataoka heritageMainKataoka) {
		heritageMainKataoka = convertToHeritageMain(heritageMainKataoka);
		heritageMainKataoka.setUpdateDate(new Timestamp(new Date().getTime()));
		return heritageMainKataoka;
	}

/**
 * heritageMainエンティティに入力値を入れる
 *
 * @param HeritageMainKataoka heritageMain
 * @return HeritageMain
 */
private HeritageMainKataoka convertToHeritageMain(HeritageMainKataoka heritageMainKataoka) {
	heritageMainKataoka.setHeritageName(this.heritageName);
	heritageMainKataoka.setGenreId(this.genreId);
	heritageMainKataoka.setLocationId1(this.locationId1);
	heritageMainKataoka.setLocationId2(this.locationId2);
	heritageMainKataoka.setLocationId3(this.locationId3);
	heritageMainKataoka.setRegistrationYear(Integer.parseInt(this.registrationYearStr));
	/*
//	 * Price入力・未入力の分岐によって入力値の型を変える
//	 */
//	if (!this.priceStr.isEmpty()) {
//
//		//価格が入力されていた場合
//		electronicsMainIto.setPrice(Integer.parseInt(this.priceStr));
//	} else {
//		//価格が入力されていなかった場合
//		electronicsMainIto.setPrice(null);
//	}
	heritageMainKataoka.setRemarks(this.remarks);
	heritageMainKataoka.setDelFlg("0");
	return heritageMainKataoka;
}
}

