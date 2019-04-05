package jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi;


import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.TypeKobayashi.HamsterMainKobayashi;
import lombok.Data;

//ハムスター登録、更新画面用Formクラス
@Data
public class HamsterKobayashiInputForm {

	private int id;

	@NotBlank(message = "common.text.error.require")
	@Size(max = 100)
	private String name;

	private Integer typeId;

	private Integer graduateId;

	@NotBlank(message = "common.text.error.require")
	private String lifeSpan;

	@Size(max = 100)
	private String comment;

	private String updateDate;

	//フィールドにエンティティの中身を入れる

	public void initWithHamsterMainKobayashi(HamsterMainKobayashi hamsterMainKobayashi) {
		this.setId((int) hamsterMainKobayashi.getId());
		this.setName(hamsterMainKobayashi.getName());
		this.setTypeId(hamsterMainKobayashi.getTypeId());
		this.setGraduateId(hamsterMainKobayashi.getGraduateId());
		this.setLifeSpan(hamsterMainKobayashi.getLifeSpan());
		this.setComment(hamsterMainKobayashi.getComment());
		this.setUpdateDate(String.valueOf(hamsterMainKobayashi.getUpdateDate()));
	}

	//HamsterMainKobayashiエンティティに登録値を入れる

	public HamsterMainKobayashi convertToHamsterMainKobayashiForInsert() {
		HamsterMainKobayashi hamsterMainKobayashi = new HamsterMainKobayashi();
		hamsterMainKobayashi = convertToHamsterMainKobayashi(hamsterMainKobayashi);
		hamsterMainKobayashi.setCreateDate(new Timestamp(new Date().getTime()));
		hamsterMainKobayashi.setUpdateDate(hamsterMainKobayashi.getCreateDate());
		return hamsterMainKobayashi;
	}


	//HamsterMainKobayashiエンティティに更新値を入れる

	public HamsterMainKobayashi convertToHamsterMainKobayashiForUPdate(HamsterMainKobayashi hamsterMainKobayashi) {
		hamsterMainKobayashi = convertToHamsterMainKobayashi(hamsterMainKobayashi);
		hamsterMainKobayashi.setUpdateDate(new Timestamp(new Date().getTime()));
		return hamsterMainKobayashi;
	}

	//HamsterMainKobayashiエンティティに入力値を入れる

	private HamsterMainKobayashi convertToHamsterMainKobayashi(HamsterMainKobayashi hamsterMainKobayashi) {
		hamsterMainKobayashi.setName(this.name);
		hamsterMainKobayashi.setTypeId(this.typeId);
		hamsterMainKobayashi.setGraduateId(this.graduateId);
		hamsterMainKobayashi.setLifeSpan(this.lifeSpan);
		hamsterMainKobayashi.setComment(this.comment);
		hamsterMainKobayashi.setDelFlg("0");
		return hamsterMainKobayashi;
	}





}
