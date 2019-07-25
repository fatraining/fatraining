package jp.co.futureantiques.webapptraining.model.form.pokemonJsuzuki;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.PokemonMainJsuzuki;
import lombok.Data;

@Data
public class PokemonJsuzukiInputForm {
	/**ID*/
	private int id;

	/**ポケモンネーム*/
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String pokemonName;

	/**登場地方ID*/
	@NotNull(message = "common.text.error.require")
	private Integer areaId;

	/**タイプ1ID*/
	@NotNull(message = "common.text.error.require")
	private Integer type1Id;

	/**タイプ2ID*/
	private Integer type2Id;

	/** HP */
	@Size(max = 4, message = "common.text.error.size.max")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String hp;

	/** 攻撃 */
	@Size(max = 4, message = "common.text.error.size.max")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String attack;

	/** 防御 */
	@Size(max = 4, message = "common.text.error.size.max")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String defense;

	/** 特攻 */
	@Size(max = 4, message = "common.text.error.size.max")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String specialAttack;

	/** 特防 */
	@Size(max = 4, message = "common.text.error.size.max")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String specialDefense;

	/** 素早さ */
	@Size(max = 4, message = "common.text.error.size.max")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String speed;

	/** 合計種族値 */
	@Size(max = 4, message = "common.text.error.size.max")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String parameter;

	/**更新日時(排他制御用)*/
	private String updateDate;

	/**
	 *フィールドにエンティティの中身を入れる
	 *
	 * @param pokemonMainJsuzuki
	 */
	public void initWithPokemonMainJsuzuki(PokemonMainJsuzuki pokemonMainJsuzuki) {
		this.setId((int)pokemonMainJsuzuki.getId());
		this.setPokemonName(pokemonMainJsuzuki.getPokemonName());
		if(pokemonMainJsuzuki.getAreaId() !=null) {
			this.setAreaId(pokemonMainJsuzuki.getAreaId());
		}
		if(pokemonMainJsuzuki.getType1Id() !=null) {
			this.setType1Id(pokemonMainJsuzuki.getType1Id());
		}
		if(pokemonMainJsuzuki.getType2Id() !=null) {
			this.setType2Id(pokemonMainJsuzuki.getType2Id());
		}

		if(pokemonMainJsuzuki.getHp() !=null) {
			this.setHp(String.valueOf(pokemonMainJsuzuki.getHp()));
		}
		if(pokemonMainJsuzuki.getAttack() !=null) {
			this.setAttack(String.valueOf(pokemonMainJsuzuki.getAttack()));
		}
		if(pokemonMainJsuzuki.getDefense() !=null) {
			this.setDefense(String.valueOf(pokemonMainJsuzuki.getDefense()));
		}
		if(pokemonMainJsuzuki.getSpecialAttack() !=null) {
			this.setSpecialAttack(String.valueOf(pokemonMainJsuzuki.getSpecialAttack()));
		}
		if(pokemonMainJsuzuki.getSpecialDefense() !=null) {
			this.setSpecialDefense(String.valueOf(pokemonMainJsuzuki.getSpecialDefense()));
		}
		if(pokemonMainJsuzuki.getSpeed() !=null) {
			this.setSpeed(String.valueOf(pokemonMainJsuzuki.getSpeed()));
		}
		if(pokemonMainJsuzuki.getParameter() !=null) {
			this.setParameter(String.valueOf(pokemonMainJsuzuki.getParameter()));
		}
		//this.setHp(String.valueOf(pokemonMainJsuzuki.getHp()));
		//this.setAttack(String.valueOf(pokemonMainJsuzuki.getAttack()));
		//this.setDefense(String.valueOf(pokemonMainJsuzuki.getDefense()));
		//this.setSpecialAttack(String.valueOf(pokemonMainJsuzuki.getSpecialAttack()));
		//this.setSpecialDefense(String.valueOf(pokemonMainJsuzuki.getSpecialDefense()));
		//this.setSpeed(String.valueOf(pokemonMainJsuzuki.getSpeed()));
		//this.setParameter(String.valueOf(pokemonMainJsuzuki.getParameter()));
		this.setUpdateDate(String.valueOf(pokemonMainJsuzuki.getUpdateDate()));
	}

	/**
	 * PokemonMainエンティティに登録値を入れる
	 *
	 * @param PokemonMainJsuzuki pokemonJsuzuki
	 * @return pokemonJsuzuki
	 */
public 	PokemonMainJsuzuki convertToPokemonMainJsuzukiForInsert() {
		PokemonMainJsuzuki pokemonMainJsuzuki = new PokemonMainJsuzuki();
		pokemonMainJsuzuki = convertToPokemonMainJsuzuki(pokemonMainJsuzuki);
		pokemonMainJsuzuki.setCreateDate(new Timestamp(new Date().getTime()));
		pokemonMainJsuzuki.setUpdateDate(pokemonMainJsuzuki.getCreateDate());
		return pokemonMainJsuzuki;
}


	/**
	 *PokemonMainJsuzukiエンティティに更新値を入れる
	 *
	 * @param PokemonMainJsuzuki pokemonMainJsuzuki
	 * @return PokemonMainJsuzuki
	 */
	public PokemonMainJsuzuki convertToPokemonMainJsuzukiForUpdate(PokemonMainJsuzuki pokemonMainJsuzuki) {
		pokemonMainJsuzuki = convertToPokemonMainJsuzuki(pokemonMainJsuzuki);
		pokemonMainJsuzuki.setUpdateDate(new Timestamp(new Date().getTime()));

		return pokemonMainJsuzuki;
	}

	/**
	 *PokemonMainJsuzukiエンティティに入力値を入れる
	 *
	 *@param PokemonMainJsuzuki pokemonMainJsuzuki
	 *@param PokemonMainJsuzuki
	 */
	private PokemonMainJsuzuki convertToPokemonMainJsuzuki(PokemonMainJsuzuki pokemonMainJsuzuki) {
		//this.setId((int)pokemonMainJsuzuki.getId());
		// formのpokemonNameをpokemonMainJsuzukiのpokemoNameに入れたい
		//this.setPokemonName(pokemonMainJsuzuki.getPokemonName());
		//this.setAreaId(pokemonMainJsuzuki.getAreaId());
		//this.setType1Id(pokemonMainJsuzuki.getType1Id());
		//this.setType2Id(pokemonMainJsuzuki.getType2Id());
		//this.setHp(String.valueOf(pokemonMainJsuzuki.getHp()));
		//this.setAttack(String.valueOf(pokemonMainJsuzuki.getAttack()));
		//this.setDefense(String.valueOf(pokemonMainJsuzuki.getDefense()));
		//this.setSpecialAttack(String.valueOf(pokemonMainJsuzuki.getSpecialAttack()));
		//this.setSpecialDefense(String.valueOf(pokemonMainJsuzuki.getSpecialDefense()));
		//this.setSpeed(String.valueOf(pokemonMainJsuzuki.getSpeed()));
		//this.setParameter(String.valueOf(pokemonMainJsuzuki.getParameter()));
		//pokemonMainJsuzuki.setId(this.id);
		pokemonMainJsuzuki.setPokemonName(this.pokemonName);
		if(this.areaId !=0) {
			pokemonMainJsuzuki.setAreaId(this.areaId);
		}else {
			pokemonMainJsuzuki.setAreaId(null);
		}
		//pokemonMainJsuzuki.setAreaId(this.areaId);
		if(this.type1Id !=0) {
		pokemonMainJsuzuki.setType1Id(this.type1Id);
		}else {
			pokemonMainJsuzuki.setType1Id(null);
		}
		if(this.type2Id !=0) {
			pokemonMainJsuzuki.setType2Id(this.type2Id);
		}else {
			pokemonMainJsuzuki.setType2Id(null);
		}

		if(!this.hp.isEmpty()) {
			pokemonMainJsuzuki.setHp(Integer.parseInt(this.hp));
		}else {
			pokemonMainJsuzuki.setHp(null);
		}
		if(!this.attack.isEmpty()) {
			pokemonMainJsuzuki.setAttack(Integer.parseInt(this.attack));
		}else {
			pokemonMainJsuzuki.setAttack(null);
		}
		if(!this.defense.isEmpty()) {
			pokemonMainJsuzuki.setDefense(Integer.parseInt(this.defense));
		}else {
			pokemonMainJsuzuki.setDefense(null);
		}
		if(!this.specialAttack.isEmpty()) {
			pokemonMainJsuzuki.setSpecialAttack(Integer.parseInt(this.specialAttack));
		}else {
			pokemonMainJsuzuki.setSpecialAttack(null);
		}
		if(!this.specialDefense.isEmpty()) {
			pokemonMainJsuzuki.setSpecialDefense(Integer.parseInt(this.specialDefense));
		}else {
			pokemonMainJsuzuki.setSpecialDefense(null);
		}
		if(!this.speed.isEmpty()) {
			pokemonMainJsuzuki.setSpeed(Integer.parseInt(this.speed));
		}else {
			pokemonMainJsuzuki.setSpeed(null);
		}
		if(!this.parameter.isEmpty()) {
			pokemonMainJsuzuki.setParameter(Integer.parseInt(this.parameter));
		}else {
			pokemonMainJsuzuki.setParameter(null);
		}
		//pokemonMainJsuzuki.setHp(Integer.parseInt(this.hp));
		//pokemonMainJsuzuki.setAttack(Integer.parseInt(this.attack));
		//pokemonMainJsuzuki.setDefense(Integer.parseInt(this.defense));
		//pokemonMainJsuzuki.setSpecialAttack(Integer.parseInt(this.specialAttack));
		//pokemonMainJsuzuki.setSpecialDefense(Integer.parseInt(this.specialDefense));
		//pokemonMainJsuzuki.setSpeed(Integer.parseInt(this.speed));
		//pokemonMainJsuzuki.setParameter(Integer.parseInt(this.parameter));
		pokemonMainJsuzuki.setDelFlg("0");
		return pokemonMainJsuzuki;
	}

}
