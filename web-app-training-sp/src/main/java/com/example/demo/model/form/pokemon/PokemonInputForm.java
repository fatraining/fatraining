package com.example.demo.model.form.pokemon;

import java.sql.Timestamp;
import java.util.Date;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.pokemon.PokemonMainSatoyoshi;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ポケモン登録・更新画面用のFormクラス
 *
 * @author satoyoshi
 */
@Data
public class PokemonInputForm {

	/** ポケモンID */
	private int pokemonId;

	/** ポケモン名 */
	//↓空白のときエラー({}は必須です)
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String pokemonName;

	/** タイプ1ID */
	private Integer type1Id;
	
	/** タイプ2ID */
	private Integer type2Id;

	/** 初登場シリーズID */
	private Integer appearanceId;

	/** 図鑑No. */
	//入力チェックを行うためにStringも入力をできるようにしておく
	//(後で弾かれる)
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String encyclopediaId;

	/** コメント */
	@Size(max = 256)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param pokemonMain
	 */
	public void initWithPokemonMain(PokemonMainSatoyoshi pokemonMain) {
		this.setPokemonId((int) pokemonMain.getPokemonId());
		this.setPokemonName(pokemonMain.getPokemonName());
		this.setType1Id(pokemonMain.getType1Id());
		this.setType2Id(pokemonMain.getType2Id());
		this.setAppearanceId(pokemonMain.getAppearanceId());
		this.setEncyclopediaId(String.valueOf(pokemonMain.getEncyclopediaId()));
		this.setComment(pokemonMain.getComment());
		this.setUpdateDate(String.valueOf(pokemonMain.getUpdateDate()));
	}

	/**
	 * PokemonMainエンティティに登録値を入れる
	 *
	 * @return PokemonMain
	 */

	//`convertToString()`オブジェクトを文字列に変換
	public PokemonMainSatoyoshi convertToPokemonMainForInsert() {
		PokemonMainSatoyoshi pokemonMain = new PokemonMainSatoyoshi();
		pokemonMain = convertToPokemonMain(pokemonMain);
		pokemonMain.setCreateDate(new Timestamp(new Date().getTime()));
		pokemonMain.setUpdateDate(pokemonMain.getCreateDate());
		return pokemonMain;
	}

	/**
	 * PokemonMainエンティティに更新値を入れる
	 *
	 * @param PokemonMainSatoyoshi pokemonMain
	 * @return PokemonMain
	 */
	public PokemonMainSatoyoshi convertToPokemonMainForUpdate(PokemonMainSatoyoshi pokemonMain) {
		pokemonMain = convertToPokemonMain(pokemonMain);
		pokemonMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return pokemonMain;
	}

	/**
	 * PokemonMainエンティティに入力値を入れる
	 *
	 * @param PokemonMainSatoyoshi pokemonMain
	 * @return PokemonMain
	 */
	private PokemonMainSatoyoshi convertToPokemonMain(PokemonMainSatoyoshi pokemonMain) {
		pokemonMain.setPokemonName(this.pokemonName);
		//CommonConst 別ファイルで指定 定数
		if (this.type1Id == CommonConst.NOT_ENTERD) {

			// タイプ1が入力されていなかった場合
			pokemonMain.setType1Id(null);
		} else {

			// タイプ1が入力されていた場合
			pokemonMain.setType1Id(this.type1Id);
		}
		if (this.type2Id == CommonConst.NOT_ENTERD) {

			// タイプ2が入力されていなかった場合
			pokemonMain.setType2Id(null);
		} else {

			//　タイプ2が入力されていた場合
			pokemonMain.setType2Id(this.type2Id);
		}

		if (this.appearanceId == CommonConst.NOT_ENTERD) {

			// 初登場シリーズが入力されていなかった場合
			pokemonMain.setAppearanceId(null);
		} else {

			//初登場シリーズが入力されていた場合
			pokemonMain.setAppearanceId(this.appearanceId);
		}
			// 図鑑No.が入力されていた場合
		if (!this.encyclopediaId.isEmpty()) {
			//入力値(文字列)を整数にして返す
			pokemonMain.setEncyclopediaId(Integer.parseInt(this.encyclopediaId));
		} else {
			// 図鑑No.が入力されていなかった場合
			pokemonMain.setEncyclopediaId(null);
		}

		pokemonMain.setComment(this.comment);
		pokemonMain.setDelFlg("0");
		return pokemonMain;
	}

}
