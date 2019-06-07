package jp.co.futureantiques.webapptraining.model.form.mcuMainHayashi;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.mcuHayashi.McuMainHayashi;
import lombok.Data;

/**
 * キャラクター登録・更新画面用のFormクラス
 *
 * @author 林 重樹
 */
@Data
public class CharacterInputForm {

	/** ID */
	private int id;

	/** キャラクター名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String characterName;

	/** 人種ID */
	private Integer typeId;

	/** 性別ID */
	private Integer sexId;

	/** 初登場年 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String appearanceYearStr;

	/** 登場回数 */
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String appearanceTimeStr;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param mcuMainHayashi
	 */
	public void initWithMcuMainHayashi(McuMainHayashi mcuMainHayashi) {
		this.setId((int) mcuMainHayashi.getId());
		this.setCharacterName(mcuMainHayashi.getCharacterName());
		this.setTypeId(mcuMainHayashi.getTypeId());
		this.setSexId(mcuMainHayashi.getSexId());
		this.setAppearanceYearStr(String.valueOf(mcuMainHayashi.getAppearanceYear()));
		if (mcuMainHayashi.getAppearanceTime() != null) {
			this.setAppearanceTimeStr(String.valueOf(mcuMainHayashi.getAppearanceTime()));
		}
		this.setComment(mcuMainHayashi.getComment());
		this.setUpdateDate(String.valueOf(mcuMainHayashi.getUpdateDate()));
	}

	/**
	 * mcuMainHayashiエンティティに登録値を入れる
	 *
	 * @return mcuMainHayashi
	 */
	public McuMainHayashi convertToMcuMainHayashiForInsert() {
		McuMainHayashi mcuMainHayashi = new McuMainHayashi();
		mcuMainHayashi = convertToMcuMainHayashi(mcuMainHayashi);
		mcuMainHayashi.setCreateDate(new Timestamp(new Date().getTime()));
		mcuMainHayashi.setUpdateDate(mcuMainHayashi.getCreateDate());
		return mcuMainHayashi;
	}

	/**
	 * mcuMainHayashiエンティティに更新値を入れる
	 *
	 * @param mcuMainHayashi mcuMainHayashi
	 * @return mcuMainHayashi
	 */
	public McuMainHayashi convertToMcuMainHayashiForUpdate(McuMainHayashi mcuMainHayashi) {
		mcuMainHayashi = convertToMcuMainHayashi(mcuMainHayashi);
		mcuMainHayashi.setUpdateDate(new Timestamp(new Date().getTime()));
		return mcuMainHayashi;
	}

	/**
	 * mcuMainHayashiエンティティに入力値を入れる
	 *
	 * @param mcuMaunHayashi mcuMaunHayashi
	 * @return mcuMaunHayashi
	 */
	private McuMainHayashi convertToMcuMainHayashi(McuMainHayashi mcuMainHayashi) {
		mcuMainHayashi.setCharacterName(this.characterName);
		mcuMainHayashi.setTypeId(this.typeId);
		mcuMainHayashi.setSexId(this.sexId);
		mcuMainHayashi.setAppearanceYear(Integer.parseInt(this.appearanceYearStr));
		if (!this.appearanceTimeStr.isEmpty()) {

			// 登場回数が入力されていた場合
			mcuMainHayashi.setAppearanceTime(Integer.parseInt(this.appearanceTimeStr));
		} else {

			// 登場が入力されていなかった場合
			mcuMainHayashi.setAppearanceTime(null);
		}
		mcuMainHayashi.setComment(this.comment);
		mcuMainHayashi.setDelFlg("0");
		return mcuMainHayashi;
	}

}