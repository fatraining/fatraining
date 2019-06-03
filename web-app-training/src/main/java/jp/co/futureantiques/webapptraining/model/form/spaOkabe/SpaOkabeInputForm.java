package jp.co.futureantiques.webapptraining.model.form.spaOkabe;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.spaOkabe.SpaMainOkabe;
import lombok.Data;

/**
 * 温泉地登録・更新画面用のFormクラス
 *
 * @author SEIYA OKABE
 */
@Data
public class SpaOkabeInputForm {

	/** ID */
	private int id;

	/** 温泉地名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 30)
	private String spaName;

	/** 都道府県ID */
	private Integer areaId;

	/** 泉質ID */
	private Integer qualityId;

	/** 特徴 */
	@Size(max = 50)
	private String features;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param spaMainOkabe
	 */
	public void initWithSpaMainOkabe(SpaMainOkabe spaMainOkabe) {
		this.setId((int) spaMainOkabe.getId());
		this.setSpaName(spaMainOkabe.getSpaName());
		this.setAreaId(spaMainOkabe.getAreaId());
		this.setQualityId(spaMainOkabe.getQualityId());
		this.setFeatures(spaMainOkabe.getFeatures());
		this.setUpdateDate(String.valueOf(spaMainOkabe.getUpdateDate()));
	}

	/**
	 * SpaMainOkabeエンティティに登録値を入れる
	 *
	 * @return SpaMainOkabe
	 */
	public SpaMainOkabe convertToSpaMainOkabeForInsert() {
		SpaMainOkabe spaMainOkabe = new SpaMainOkabe();
		spaMainOkabe = convertToSpaMainOkabe(spaMainOkabe);
		spaMainOkabe.setCreateDate(new Timestamp(new Date().getTime()));
		spaMainOkabe.setUpdateDate(spaMainOkabe.getCreateDate());
		return spaMainOkabe;
	}

	/**
	 * SpaMainOkabeエンティティに更新値を入れる
	 *
	 * @param SpaMainOkabe spaMainOkabe
	 * @return SpaMainOkabe
	 */
	public SpaMainOkabe convertToSpaMainOkabeForUpdate(SpaMainOkabe spaMainOkabe) {
		spaMainOkabe = convertToSpaMainOkabe(spaMainOkabe);
		spaMainOkabe.setUpdateDate(new Timestamp(new Date().getTime()));
		return spaMainOkabe;
	}

	/**
	 * MovieMainエンティティに入力値を入れる
	 *
	 * @param SpaMainOkabe spaMainOkabe
	 * @return SpaMainOkabe
	 */
	private SpaMainOkabe convertToSpaMainOkabe(SpaMainOkabe spaMainOkabe) {
		spaMainOkabe.setSpaName(this.spaName);
		spaMainOkabe.setAreaId(this.areaId);
		spaMainOkabe.setQualityId(this.qualityId);
		spaMainOkabe.setFeatures(this.features);
		spaMainOkabe.setDelFlg("0");
		return spaMainOkabe;
	}

}
