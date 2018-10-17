package jp.co.futureantiques.webapptraining.model.form.magazineKawamae;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.magazinekawamae.MagazineMainKawamae;
import lombok.Data;


/**
 * 雑誌登録・更新画面用のFormクラス
 *
 * @author wataru kawamae
 */
@Data
public class MagazineKawamaeInputForm {

	/** ID */
	private int id;

	/** 雑誌名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255,message = "magazine.text.error.invalid.name")
	private String magazineName;

	/** ジャンルID */
	private Integer genreId;

	/** 売り上げ部数 */
	@DecimalMin(value = "0", message = "magazine.number.error.invalid.salednumber")
	private Integer saledNumber;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param magazineMain
	 */
	public void initWithMagazineMain(MagazineMainKawamae magazineMain) {
		this.setId((int) magazineMain.getId());
		this.setMagazineName(magazineMain.getMagazineName());
		this.setGenreId(magazineMain.getGenreId());
		this.setSaledNumber(magazineMain.getSaledNumber());
		this.setUpdateDate(String.valueOf(magazineMain.getUpdateDate()));
	}

	/**
	 * MagazineMainエンティティに登録値を入れる
	 *
	 * @return MagazineMain
	 */
	public MagazineMainKawamae convertToMagazineMainForInsert() {
		MagazineMainKawamae magazineMainKawamae = new MagazineMainKawamae();
		magazineMainKawamae = convertToMagazineMain(magazineMainKawamae);
		magazineMainKawamae.setCreateDate(new Timestamp(new Date().getTime()));
		magazineMainKawamae.setUpdateDate(magazineMainKawamae.getCreateDate());
		return magazineMainKawamae;
	}

	/**
	 * MagazineMainエンティティに更新値を入れる
	 *
	 * @param MagazineMainKawamae magazineMain
	 * @return MagazineMain
	 */
	public MagazineMainKawamae convertToMagazineMainForUpdate(MagazineMainKawamae magazineMainKawamae) {
		magazineMainKawamae = convertToMagazineMain(magazineMainKawamae);
		magazineMainKawamae.setUpdateDate(new Timestamp(new Date().getTime()));
		return magazineMainKawamae;
	}

	/**
	 * MagazineMainエンティティに入力値を入れる
	 *
	 * @param MagazineMainKawamae magazineMain
	 * @return MagazineMain
	 */
	private MagazineMainKawamae convertToMagazineMain(MagazineMainKawamae magazineMainKawamae) {
		magazineMainKawamae.setMagazineName(this.magazineName);
		magazineMainKawamae.setGenreId(this.genreId);
		if(this.getSaledNumber()!=null) {
			magazineMainKawamae.setSaledNumber(this.getSaledNumber());
		}

		magazineMainKawamae.setDelFlg("0");
		return magazineMainKawamae;
	}
}