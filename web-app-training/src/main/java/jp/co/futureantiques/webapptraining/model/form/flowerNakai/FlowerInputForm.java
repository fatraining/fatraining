package jp.co.futureantiques.webapptraining.model.form.flowerNakai;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import jp.co.futureantiques.webapptraining.model.flowerNakai.FlowerMainNakai;
import lombok.Data;

/**
 * 花登録・更新画面用のFormクラス
 * @author Rieko Nakai
 */
@Data
public class FlowerInputForm {

	/** 花ID */
	private int id;

	/** 花の画像 */
	private MultipartFile flowerImage;

	/** 花の名前 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String flowerName;

	/** 月ID */
	private Integer monthId;

	/** 色ID */
	private Integer colorId;

	/** 原産国 */
	@Size(max = 256)
	private String country;

	/** 花言葉 */
	@Size(max = 256)
	private String word;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 * @param FlowerMainNakai flowerMainNakai
	 */
	public void initWithFlowerMainNakai(FlowerMainNakai flowerMainNakai) {
		this.setId((int) flowerMainNakai.getId());
		this.setFlowerName(flowerMainNakai.getFlowerName());
		this.setMonthId(flowerMainNakai.getMonthId());
		this.setColorId(flowerMainNakai.getColorId());
		this.setCountry(flowerMainNakai.getCountry());
		this.setWord(flowerMainNakai.getWord());
		this.setUpdateDate(String.valueOf(flowerMainNakai.getUpdateDate()));
	}

	/**
	 * FlowerMainNakaiエンティティに登録値を入れる
	 * @return FlowerMainNakai
	 */
	public FlowerMainNakai convertToFlowerMainNakaiForInsert() {
		FlowerMainNakai flowerMainNakai = new FlowerMainNakai();
		flowerMainNakai = convertToFlowerMainNakai(flowerMainNakai);
		flowerMainNakai.setCreateDate(new Timestamp(new Date().getTime()));
		flowerMainNakai.setUpdateDate(flowerMainNakai.getCreateDate());
		return flowerMainNakai;
	}

	/**
	 * FlowerMainNakaiエンティティに更新値を入れる
	 * @return flowerMainNakai
	 * @param FlowerMainNakai flowerMainNakai
	 */
	public FlowerMainNakai convertToFlowerMainNakaiForUpdate(FlowerMainNakai flowerMainNakai) {
		flowerMainNakai = convertToFlowerMainNakai(flowerMainNakai);
		flowerMainNakai.setUpdateDate(flowerMainNakai.getUpdateDate());
		return flowerMainNakai;
	}

	/**
	 * FlowerMainNakaiエンティティに入力値を入れる
	 * @return flowerMainNakai
	 * @param FlowerMainNakai flowerMainNakai
	 */
	public FlowerMainNakai convertToFlowerMainNakai(FlowerMainNakai flowerMainNakai) {
		flowerMainNakai.setFlowerName(this.flowerName);
		flowerMainNakai.setMonthId(this.monthId);
		flowerMainNakai.setColorId(this.colorId);
		flowerMainNakai.setCountry(this.country);
		flowerMainNakai.setWord(this.word);
		flowerMainNakai.setDelFlg("0");
		return flowerMainNakai;
	}
}
