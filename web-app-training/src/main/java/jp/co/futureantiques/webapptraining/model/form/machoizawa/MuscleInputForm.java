package jp.co.futureantiques.webapptraining.model.form.machoizawa;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.machoizawa.MuscleIzawa;
import lombok.Data;

@Data
public class MuscleInputForm {

	/** ID */
	private int id;

	/** メニュー名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String menu;

	/** 部位ID */
	private Integer body;

	/** コメント */
	@Size(max = 255)
	private String com;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param MuscleIzawa
	 */
	public void initWithMuscleIzawa(MuscleIzawa muscleIzawa) {
		this.setId((int) muscleIzawa.getId());
		this.setMenu(muscleIzawa.getMenu());
		this.setBody(muscleIzawa.getBody());
		this.setCom(muscleIzawa.getCom());
	}

	/**
	 * MuscleIzawaエンティティに登録値を入れる
	 *
	 * @return MuscleIzawa
	 */
	public MuscleIzawa convertToMuscleIzawaForInsert() {
		MuscleIzawa muscleIzawa = new MuscleIzawa();
		muscleIzawa = convertToMuscleIzawa(muscleIzawa);
		return muscleIzawa;
	}

	/**
	 * MuscleIzawaエンティティに更新値を入れる
	 *
	 * @param MuscleIzawa muscleIzawa
	 * @return MuscleIzawa
	 */
	public MuscleIzawa convertToMuscleIzawaForUpdate(MuscleIzawa muscleIzawa) {
		muscleIzawa = convertToMuscleIzawa(muscleIzawa);
		return muscleIzawa;
	}

	/**
	 * MuscleIzawaエンティティに入力値を入れる
	 *
	 * @param MuscleIzawa muscleIzawa
	 * @return MuscleIzawa
	 */
	private MuscleIzawa convertToMuscleIzawa(MuscleIzawa muscleIzawa) {
		muscleIzawa.setMenu(this.menu);
		muscleIzawa.setBody(this.body);
		muscleIzawa.setCom(this.com);
		muscleIzawa.setDelFlg("0");
		return muscleIzawa;
	}
}
