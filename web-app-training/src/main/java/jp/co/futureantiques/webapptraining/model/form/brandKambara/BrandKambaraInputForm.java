package jp.co.futureantiques.webapptraining.model.form.brandKambara;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.brandkambara.BrandMainKambara;
import lombok.Data;

/**
 * ブランド登録・更新画面用のFormクラス
 * htmlで入力した値を格納
 *
 * @author Yuki Kambara
 */
@Data
public class BrandKambaraInputForm {


	/** ブランドID */
	private int id;

	/** ブランド名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String brandName;

	/** ジャンルID */
	private Integer genreId;

	/** 生産国 */
	private Integer countryId;

	/** デザイナー*/
	@Size(max = 256, message = "common.text.error.size.equal.four")
	private String designer;

	/** 創業年 */
	@Size(max = 4, message = "common.text.error.size.equal.four")
	@Pattern(regexp = "^([1-9][0-9][0-9][0-9])?$", message = "common.text.error.size.equal.four")
	private String releaseYearstr;

	/** コメント*/
	@Size(max = 256)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;






	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param brandMainKambara
	 */
	public void initWithBrandMainKambara(BrandMainKambara brandMainKambara) {
		//GenreIdとcountryIdは入力欄空白の時にはID=0が入るため、nullになることがない。
		//→ifを使わない

		this.setId((int) brandMainKambara.getId());
		this.setBrandName(brandMainKambara.getBrandName());
		this.setCountryId((int)brandMainKambara.getCountryId());
		this.setGenreId((int)brandMainKambara.getGenreId());
	    this.setDesigner(String.valueOf(brandMainKambara.getDesigner()));
	    if (brandMainKambara.getReleaseYear() != null) {
			this.setReleaseYearstr(String.valueOf(brandMainKambara.getReleaseYear()));
		}
	    this.setComment(String.valueOf(brandMainKambara.getComment()));

		this.setUpdateDate(String.valueOf(brandMainKambara.getUpdateDate()));
	}




	/**
	 * BrandMainKambaraエンティティに登録値を入れる
	 *
	 * @return BrandMainKambara
	 */
	public BrandMainKambara convertToBrandMainKambaraForInsert() {
		BrandMainKambara brandMainKambara = new BrandMainKambara();
		brandMainKambara = convertToBrandMainKambara(brandMainKambara);
		brandMainKambara.setCreateDate(new Timestamp(new Date().getTime()));
		brandMainKambara.setUpdateDate(brandMainKambara.getCreateDate());
		return brandMainKambara;
	}

	/**
	 * BrandMainKambaraエンティティに更新値を入れる
	 *
	 * @param BrandMainKambara brandMainKambara
	 * @return BrandMainKambara
	 */
	public BrandMainKambara convertToBrandMainKambaraForUpdate(BrandMainKambara brandMainKambara) {
		brandMainKambara = convertToBrandMainKambara(brandMainKambara);
		brandMainKambara.setUpdateDate(new Timestamp(new Date().getTime()));
		return brandMainKambara;
	}

	/**
	 * BrandMainKambaraエンティティに入力値を入れる
	 *
	 * @param BrandMainKambara brandMainKambara
	 * @return BrandMainKambara
	 */
	private BrandMainKambara convertToBrandMainKambara(BrandMainKambara brandMainKambara) {
		brandMainKambara.setBrandName(this.brandName);
		brandMainKambara.setId(this.id);
		brandMainKambara.setGenreId(this.genreId);
		brandMainKambara.setCountryId(this.countryId);
		brandMainKambara.setDesigner(this.designer);
		if (!this.releaseYearstr.isEmpty()) {

			//リリース年が入力されていた場合
			brandMainKambara.setReleaseYear(Integer.parseInt(this.releaseYearstr));
		} else {

			//入力されていない場合
			brandMainKambara.setReleaseYear(null);
		}
		brandMainKambara.setDelFlg("0");



		return brandMainKambara;
	}


}
