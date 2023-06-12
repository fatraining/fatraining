package jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.LegendMainTanamachi;
import lombok.Data;

/**
 * レジェンド登録・更新画面用のフォームクラス
 *
 * @author future
 */
@Data
public class LegendInputForm {

	/** レジェンドID */
	private int legendId;

	/** レジェンド名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256, message = "legend.text.error.invalid.name")
	private String legendName;

	/** 本名 */
	@Size(max = 256, message = "legend.text.error.invalid.name")
	private String realName;

	/** 年齢 */
	@Range(min = 0, max = 999, message = "legend.text.error.invalid.number")
	private Integer age;

	/** 出身地ID */
	@NotNull(message = "common.text.error.require")
	private Integer fromId;

	/** クラスID */
	@NotNull(message = "common.text.error.require")
	private Integer classId;

	/** アルティメットアビリティ */
	@Size(max = 256, message = "legend.text.error.invalid.name")
	private String ultimateAbility;

	/** 更新日時(排他制御用) */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param legendMainTanamachi
	 */
	public void initWithLegendMainTanamachi(LegendMainTanamachi legendMainTanamachi) {
		this.setLegendId((int) legendMainTanamachi.getId());
		this.setLegendName(legendMainTanamachi.getLegendName());
		this.setRealName(legendMainTanamachi.getRealName());
		this.setAge(legendMainTanamachi.getAge());
		this.setFromId(legendMainTanamachi.getFromId());
		this.setClassId(legendMainTanamachi.getClassId());
		this.setUltimateAbility(legendMainTanamachi.getUltimateAbility());
		this.setUpdateDate(String.valueOf(legendMainTanamachi.getUpdateDate()));
	}

	/** LegendMainTanamachiエンティティに登録値を入れる
	 *
	 * @return LegendMainTanamachi
	 */
	public LegendMainTanamachi convertToLegendMainTanamachiForInsert() {
		LegendMainTanamachi legendMainTanamachi = new LegendMainTanamachi();
		legendMainTanamachi = convertToLegendMainTanamachi(legendMainTanamachi);
		legendMainTanamachi.setCreateDate(new Timestamp(new Date().getTime()));
		legendMainTanamachi.setUpdateDate(legendMainTanamachi.getCreateDate());
		return legendMainTanamachi;
	}

	/**
	 * LegendMainTanamachiエンティティに更新値を入れる
	 *
	 * @param LegendMainTanamachi legendMainTanamachi
	 * @return LegendMainTanamachi
	 */
	public LegendMainTanamachi convertToLegendMainTanamachiForUpdate(LegendMainTanamachi legendMainTanamachi) {
		legendMainTanamachi = convertToLegendMainTanamachi(legendMainTanamachi);
		legendMainTanamachi.setUpdateDate(new Timestamp(new Date().getTime()));
		return legendMainTanamachi;

	}

	/**
	 * LegendMainTanamachiエンティティに入力値を入れる
	 *
	 * @param LegendMainTanamachi legendMainTanamachi
	 * @return LegendMainTanamachi
	 */
	private LegendMainTanamachi convertToLegendMainTanamachi(LegendMainTanamachi legendMainTanamachi) {
		legendMainTanamachi.setLegendName(this.legendName);
		legendMainTanamachi.setRealName(this.realName);
		legendMainTanamachi.setAge(this.age);
		legendMainTanamachi.setFromId(this.fromId);
		legendMainTanamachi.setClassId(this.classId);
		legendMainTanamachi.setUltimateAbility(this.ultimateAbility);
		legendMainTanamachi.setDelFlg(0);
		return legendMainTanamachi;
	}
}
