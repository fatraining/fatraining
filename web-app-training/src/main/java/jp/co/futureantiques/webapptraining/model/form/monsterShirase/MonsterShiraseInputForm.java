package jp.co.futureantiques.webapptraining.model.form.monsterShirase;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.monsterShirase.MonsterMainShirase;
import lombok.Data;

/**
 * モンスター追加・更新用のフォームクラス
 *
 * @author Shirase
 */

@Data
public class MonsterShiraseInputForm {

	/** モンスターID */
	private int id;

	/** モンスター名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256, message = "monster.text.error.invalid.name")
	private String name;

	/** モンスター名（英語）*/
//	@NotBlank(message = "common.text.error.require")
	@Size(max = 256, message = "monster.text.error.invalid.name")
	private String nameEn;

	/** 素材名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256, message = "monster.text.error.invalid.name")
	private String material;

	/** ジャンルID */
	private Integer genreId;

	/** 弱点属性ID */
	private Integer elementId;

	/** 初登場作品ID */
	private Integer titleId;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param monsterMainShirase
	 */
	public void initWithMonsterMainShirase(MonsterMainShirase monsterMainShirase) {
		this.setId((int) monsterMainShirase.getId());
		this.setName(monsterMainShirase.getName());
		this.setNameEn(monsterMainShirase.getNameEn());
		this.setMaterial(monsterMainShirase.getMaterial());
		this.setGenreId(monsterMainShirase.getGenreId());
		this.setElementId(monsterMainShirase.getElementId());
		this.setTitleId(monsterMainShirase.getTitleId());
		this.setUpdateDate(String.valueOf(monsterMainShirase.getUpdateDate()));
	}

	/**
	 * MonsterMainShiraseエンティティに登録値を入れる
	 *
	 * @return MonsterMainShirase
	 */
	public MonsterMainShirase convertToMonsterMainShiraseForInsert() {
		MonsterMainShirase monsterMainShirase = new MonsterMainShirase();
		monsterMainShirase = convertToMonsterMainShirase(monsterMainShirase);
		monsterMainShirase.setCreateDate(new Timestamp(new Date().getTime()));
		monsterMainShirase.setUpdateDate(monsterMainShirase.getCreateDate());
		return monsterMainShirase;
	}

	/**
	 * MonsterMainShiraseエンティティに更新値を入れる
	 *
	 * @param MonsterMainShirase monsterMainShirase
	 * @return MonsterMainShirase
	 */
	public MonsterMainShirase convertToMonsterMainShiraseForUpdate(MonsterMainShirase monsterMainShirase) {
		monsterMainShirase = convertToMonsterMainShirase(monsterMainShirase);
		monsterMainShirase.setUpdateDate(new Timestamp(new Date().getTime()));
		return monsterMainShirase;
	}

	/**
	 * MonsterMainShiraseエンティティに入力値を入れる
	 *
	 * @param MonsterMainShirase monsterMainShirase
	 * @return MonsterMainShirase
	 */
	private MonsterMainShirase convertToMonsterMainShirase(MonsterMainShirase monsterMainShirase) {
		monsterMainShirase.setName(this.name);
		monsterMainShirase.setNameEn(this.nameEn);
		monsterMainShirase.setMaterial(this.material);

		if (this.nameEn.isEmpty()) {
			// ジャンルが入力されていなかった場合
			monsterMainShirase.setGenreId(null);
		} else {
			// ジャンルが入力されていた場合
			monsterMainShirase.setGenreId(this.genreId);
		}

		if (this.genreId == CommonConst.NOT_ENTERD) {
			// ジャンルが入力されていなかった場合
			monsterMainShirase.setGenreId(null);
		} else {
			// ジャンルが入力されていた場合
			monsterMainShirase.setGenreId(this.genreId);
		}

		if (this.elementId == CommonConst.NOT_ENTERD) {
			// 弱点属性が入力されていなかった場合
			monsterMainShirase.setElementId(null);
		} else {
			// 弱点属性が入力されていた場合
			monsterMainShirase.setElementId(this.elementId);
		}

		if (this.titleId == CommonConst.NOT_ENTERD) {
			// 初登場作品が入力されていなかった場合
			monsterMainShirase.setTitleId(null);
		} else {
			// 初登場作品が入力されていた場合
			monsterMainShirase.setTitleId(this.titleId);
		}
		monsterMainShirase.setDelFlg(0);
		return monsterMainShirase;
	}
}

