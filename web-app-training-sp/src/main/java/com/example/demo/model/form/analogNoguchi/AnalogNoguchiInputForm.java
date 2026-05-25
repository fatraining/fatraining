package com.example.demo.model.form.analogNoguchi;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.analogNoguchi.AnalogMainNoguchi;

import lombok.Data;

/**
 * アナログゲーム登録・更新画面用のFormクラス
 * 
 * @author future
 */

@Data
public class AnalogNoguchiInputForm {

	/**ID */
	private Long id;

	/**ゲーム名 */

	//↓空白のときエラー({}は必須です)
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String analogTitle;

	/**種類ID */
	@NotNull(message = "common.text.error.require")
	private Integer typeId;

	/**対象年齢 */
	@NotNull(message = "common.text.error.require")
	private Integer targetYears;

	/**ジャンル1 */
	private Integer genre1Id;

	/**ジャンル2 */
	private Integer genre2Id;

	/**プレイ人数 */
	@Size(max = 256)
	private String playPerson;

	/**プレイ時間 */
	@Size(max = 256)
	private String playTime;

	/**内容 */
	@Size(max = 256)
	private String content;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param analogMain
	 */
	public void initWithAnalogMainNoguchi(AnalogMainNoguchi analogMainNoguchi) {
		this.setId(analogMainNoguchi.getId());
		this.setAnalogTitle(analogMainNoguchi.getAnalogTitle());
		this.setTypeId(analogMainNoguchi.getTypeId());
		this.setTargetYears(analogMainNoguchi.getTargetYears());
		this.setGenre1Id(analogMainNoguchi.getGenre1Id());
		this.setGenre2Id(analogMainNoguchi.getGenre2Id());
		this.setPlayPerson(analogMainNoguchi.getPlayPerson());
		this.setPlayTime(analogMainNoguchi.getPlayTime());
		this.setContent(analogMainNoguchi.getContent());
		this.setUpdateDate(String.valueOf(analogMainNoguchi.getUpdateDate()));
	}

	/**
	 * AnalogMainエンティティに登録値を入れる
	 *
	 * @return AnalogMain
	 */
	public AnalogMainNoguchi convertToAnalogMainForInsert() {
		AnalogMainNoguchi analogMainNoguchi = new AnalogMainNoguchi();
		analogMainNoguchi = convertToAnalogMain(analogMainNoguchi);
		analogMainNoguchi.setCreateDate(new Timestamp(new Date().getTime()));
		analogMainNoguchi.setUpdateDate(analogMainNoguchi.getCreateDate());
		return analogMainNoguchi;
	}

	/**
	 * AnalogMainエンティティに更新値を入れる
	 *
	 * @param AnalogMainNoguchi analogMainNoguchi
	 * @return AnalogMain
	 */
	public AnalogMainNoguchi convertToAnalogMainForUpdate(AnalogMainNoguchi analogMainNoguchi) {
		analogMainNoguchi = convertToAnalogMain(analogMainNoguchi);
		analogMainNoguchi.setUpdateDate(new Timestamp(new Date().getTime()));
		return analogMainNoguchi;
	}

	/**
	 * AnalogMainエンティティに入力値を入れる
	 *
	 * @param AnalogMain analogMain
	 * @return AnalogMain
	 */
	private AnalogMainNoguchi convertToAnalogMain(AnalogMainNoguchi analogMainNoguchi) {

		analogMainNoguchi.setAnalogTitle(this.analogTitle);

		//CommonConst 別ファイルで指定 定数
		if (this.typeId == CommonConst.NOT_ENTERD) {

			// 種類が入力されていなかった場合
			analogMainNoguchi.setTypeId(null);

		} else {

			// 種類が入力されていた場合
			analogMainNoguchi.setTypeId(this.typeId);

		}

		if (this.targetYears == CommonConst.NOT_ENTERD) {

			// 対象年齢が入力されていなかった場合
			analogMainNoguchi.setTargetYears(null);

		} else {

			// 対象年齢が入力されていた場合
			analogMainNoguchi.setTargetYears(this.targetYears);

		}

		if (this.genre1Id != null) {

			// ジャンル1が入力されていた場合
			analogMainNoguchi.setGenre1Id(this.genre1Id);

		} else {

			// ジャンル1が入力されていなかった場合
			analogMainNoguchi.setGenre1Id(null);

		}

		if (this.genre2Id != null) {

			// ジャンル2が入力されていた場合
			analogMainNoguchi.setGenre2Id(this.genre2Id);

		} else {

			// ジャンル2が入力されていなかった場合
			analogMainNoguchi.setGenre2Id(null);

		}

		if (!this.playPerson.isEmpty()) {

			// プレイ人数が入力されていた場合
			analogMainNoguchi.setPlayPerson(this.playPerson);

		} else {

			// プレイ人数が入力されていなかった場合
			analogMainNoguchi.setPlayPerson(null);

		}

		if (!this.playTime.isEmpty()) {

			// プレイ時間が入力されていた場合
			analogMainNoguchi.setPlayTime(this.playTime);

		} else {

			// プレイ時間が入力されていなかった場合
			analogMainNoguchi.setPlayTime(null);

		}

		analogMainNoguchi.setContent(this.content);
		analogMainNoguchi.setDelFlg("0");
		return analogMainNoguchi;

	}

}
