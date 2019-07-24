package jp.co.futureantiques.webapptraining.model.form.mobileLegendsSakuma;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.MobileLegendsMainSakuma;
import lombok.Data;

/**
 * キャラクター登録・更新画面用のFormクラス
 *
 * @author Sakuma
 *
 */
@Data
public class MobileLegendsSakumaInputForm {

	/**ID*/
	private int id;

	/**必須：キャラクター名*/
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String mobaleChara;

	/**必須：タイプ1ID*/
	@NotNull(message = "common.text.error.require")
	private Integer type1Id;

	/**タイプ2ID*/
	private Integer type2Id;

	/**必須：特徴1ID*/
	@NotNull(message = "common.text.error.require")
	private Integer feature1Id;

	/**特徴2ID*/
	private Integer feature2Id;

	/**コメント*/
	@Size(max = 255)
	private String comment;

	/**更新日時*/
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param mobileLegendsMainSakuma
	 */

	public void initWithMobileLegendsMainSakuma(MobileLegendsMainSakuma mobileLegendsMainSakuma) {
		this.setId((int) mobileLegendsMainSakuma.getId());
		this.setMobaleChara(mobileLegendsMainSakuma.getMobaleChara());
		this.setType1Id(mobileLegendsMainSakuma.getType1Id());
		this.setType2Id(mobileLegendsMainSakuma.getType2Id());
		this.setFeature1Id(mobileLegendsMainSakuma.getFeature1Id());
		this.setFeature2Id(mobileLegendsMainSakuma.getFeature2Id());
		this.setComment(mobileLegendsMainSakuma.getComment());
		this.setUpdateDate(String.valueOf(mobileLegendsMainSakuma.getUpdateDate()));
	}

	/**
	 * MobileLegendsMainSakumaエンティティに登録値を入れる
	 *
	 * @param MobileLegendsMainSakuma mobileLegendsSakuma
	 * @return mobileLegendsSakuma
	 *
	 */

	public MobileLegendsMainSakuma convertToMobileLegendsMainSakumaForInsert() {
		MobileLegendsMainSakuma mobileLegendsMainSakuma = new MobileLegendsMainSakuma();
		mobileLegendsMainSakuma = convertToMobileLegendsMainSakuma(mobileLegendsMainSakuma);
		mobileLegendsMainSakuma.setCreateDate(new Timestamp(new Date().getTime()));
		mobileLegendsMainSakuma.setUpdateDate(mobileLegendsMainSakuma.getCreateDate());
		return mobileLegendsMainSakuma;
	}

	/**
	 * MobileLegendsMainSakumaエンティティに更新値を入れる
	 *
	 * @param MobileLegendsMainSakuma mobileLegendsMainSakuma
	 * @return MobileLegendsMainSakuma
	 */

	public MobileLegendsMainSakuma convertToMobileLegendsMainSakumaForUpdate(
			MobileLegendsMainSakuma mobileLegendsMainSakuma) {
		mobileLegendsMainSakuma = convertToMobileLegendsMainSakuma(mobileLegendsMainSakuma);
		mobileLegendsMainSakuma.setUpdateDate(new Timestamp(new Date().getTime()));
		return mobileLegendsMainSakuma;
	}

	/**
	 * MobileLegendsMainSakumaエンティティに更新値を入れる
	 *
	 * @param MobileLegendsMainSakuma mobileLegendsMainSakuma
	 * @return MobileLegendsMainSakuma
	 */

	private MobileLegendsMainSakuma convertToMobileLegendsMainSakuma(MobileLegendsMainSakuma mobileLegendsMainSakuma) {
		//必須項目：キャラクター名
		mobileLegendsMainSakuma.setMobaleChara(this.mobaleChara);
		//タイプ1
		mobileLegendsMainSakuma.setType1Id(this.type1Id);

		//タイプ2
		if (this.type2Id != 0) {
			mobileLegendsMainSakuma.setType2Id(this.type2Id);
		} else {
			mobileLegendsMainSakuma.setType2Id(null);
		}

		//特徴1
		mobileLegendsMainSakuma.setFeature1Id(this.feature1Id);

		//特徴2
		if (this.feature2Id != 0) {
			mobileLegendsMainSakuma.setFeature2Id(this.feature2Id);
		} else {
			mobileLegendsMainSakuma.setFeature2Id(null);
		}

		//コメント
		if (!this.comment.isEmpty()) {
			mobileLegendsMainSakuma.setComment(this.comment);
		} else {
			mobileLegendsMainSakuma.setComment(null);
		}

		//削除フラグ
		mobileLegendsMainSakuma.setDelFlg("0");

		return mobileLegendsMainSakuma;
	}
}
