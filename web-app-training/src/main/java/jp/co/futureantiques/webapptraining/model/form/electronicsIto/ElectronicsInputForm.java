package jp.co.futureantiques.webapptraining.model.form.electronicsIto;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.Electronics.ElectronicsMainIto;
import lombok.Data;

/**
 *
 * 電化製品登録・更新画面用のFormクラス
 *
 * @author AIRI ITO
 */
@Data
public class ElectronicsInputForm {

	/** 製品ID */
	private int id;

	/** 製品名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String productName;

	/** カテゴリー */
	private Integer categoryId;

	/** ブランド */
	private Integer brandId;

	/** 発売年 */
	@Size(max = 4, message = "comon.text.error.size.max.four")
	@Pattern(regexp = "^\\d{4}", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** 価格 */
	@Size(max = 6)
	@Pattern(regexp = "\\d+", message = "common.text.error.numeric")
	private String priceStr;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時 */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param electronicsMainIto
	 */
	public void initWithElectronicsMain(ElectronicsMainIto electronicsMainIto) {
		this.setId((int) electronicsMainIto.getId());
		this.setProductName(electronicsMainIto.getProductName());
		this.setCategoryId(electronicsMainIto.getCategoryId());
		this.setBrandId(electronicsMainIto.getBrandId());
		this.setReleaseYearStr(String.valueOf(electronicsMainIto.getReleaseYear()));

		if (electronicsMainIto.getPrice() != null) {
			this.setPriceStr(String.valueOf(electronicsMainIto.getPrice()));
		}
		this.setComment(electronicsMainIto.getComment());
		this.setUpdateDate(String.valueOf(electronicsMainIto.getUpdateDate()));
	}

	/**
	 * electricsMainエンティティに登録値を入れる
	 *
	 * @return electronicsMain
	 */
	public ElectronicsMainIto convertToElectronicsMainForInsert() {
		ElectronicsMainIto electronicsMainIto = new ElectronicsMainIto();
		electronicsMainIto = convertToElectronicsMain(electronicsMainIto);
		electronicsMainIto.setCreateDate(new Timestamp(new Date().getTime()));
		electronicsMainIto.setUpdateDate(electronicsMainIto.getCreateDate());
		return electronicsMainIto;
	}

	/**
	 * electricsMainエンティティに更新値を入れる
	 *
	 * @param ElectronicsMainIto electronicsMain
	 * @return ElectronicsMain
	 */
	public ElectronicsMainIto convertToElectronicsMainForUpdate(ElectronicsMainIto electronicsMainIto) {
		electronicsMainIto = convertToElectronicsMain(electronicsMainIto);
		electronicsMainIto.setUpdateDate(new Timestamp(new Date().getTime()));
		return electronicsMainIto;
	}

	/**
	 * electricsMainエンティティに入力値を入れる
	 *
	 * @param ElectronicsMainIto electricsMain
	 * @return ElectricsMain
	 */
	private ElectronicsMainIto convertToElectronicsMain(ElectronicsMainIto electronicsMainIto) {
		electronicsMainIto.setProductName(this.productName);
		electronicsMainIto.setCategoryId(this.categoryId);
		electronicsMainIto.setBrandId(this.brandId);
		electronicsMainIto.setReleaseYear(Integer.parseInt(this.releaseYearStr));

		if (!this.priceStr.isEmpty()) {

			//価格が入力されていた場合
			electronicsMainIto.setPrice(Integer.parseInt(this.priceStr));
		} else {
			//価格が入力されていなかった場合
			electronicsMainIto.setPrice(null);
		}
		electronicsMainIto.setComment(this.comment);
		electronicsMainIto.setDelFlg("0");
		return electronicsMainIto;
	}
}
