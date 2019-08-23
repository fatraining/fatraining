package jp.co.futureantiques.webapptraining.model.form.residentsUriu;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.residentsUriu.ResidentsMainUriu;
import lombok.Data;

/**
 * 住人データ登録・更新画面用のFormクラス
 *
 */

@Data
public class ResidentsUriuInputForm {

	/** ID */
	private int id;

	/** なまえ */
	@NotBlank(message="common.text.error.require")
	@Size(max=256)
	private String name;

	/** 性格ID */
	private Integer typeId;

	/** どうぶつID */
	private Integer animalId;

	/** 口癖 */
	@Size(max=256)
	private String phrase;

	/** 座右の銘 */
	@Size(max=256)
	private String motto;

	/** 誕生日 */
	@Size(max=5, message = "common.text.error.size.max")
	@Pattern(regexp = "^()|([1-9]|1[0-2])/([1-9]|[1-2][0-9]|3[0-1])?$", message = "common.text.error.numeric")
	private String birthday;

	/** 画像 */
	@Size(max=256)
	private String image;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param residentsMainUriu
	 */
	public void initWithResidentsMainUriu(ResidentsMainUriu residentsMainUriu) {
		this.setId((int)residentsMainUriu.getId());
		this.setName(residentsMainUriu.getName());
		this.setTypeId(residentsMainUriu.getTypeId());
		this.setAnimalId(residentsMainUriu.getAnimalId());
		this.setPhrase(residentsMainUriu.getPhrase());
		this.setMotto(residentsMainUriu.getMotto());
		if (residentsMainUriu.getBirthday() != null) {
			this.setBirthday(residentsMainUriu.getBirthday());
		}
		this.setImage(residentsMainUriu.getImage());
		this.setUpdateDate(String.valueOf(residentsMainUriu.getUpdateDate()));
	}

	/**
	 * ResidentsMainUriuエンティティに登録値を入れる
	 *
	 * @return ResidentsMainUriu
	 */
	public ResidentsMainUriu convertToResidentsMainUriuForInsert() {
		ResidentsMainUriu residentsMainUriu = new ResidentsMainUriu();
		residentsMainUriu = convertToResidentsMainUriu(residentsMainUriu);
		residentsMainUriu.setCreateDate(new Timestamp(new Date().getTime()));
		residentsMainUriu.setUpdateDate(residentsMainUriu.getCreateDate());
		return residentsMainUriu;
	}

	/**
	 * ResidentsMainUriuエンティティに更新値を入れる
	 *
	 * @param ResidentsMainUriu residentsMainUriu
	 * @return ResidentsmMainUriu
	 */
	public ResidentsMainUriu convertToResidentsMainUriuForUpdate(ResidentsMainUriu residentsMainUriu) {
		residentsMainUriu = convertToResidentsMainUriu(residentsMainUriu);
		residentsMainUriu.setUpdateDate(new Timestamp(new Date().getTime()));
		return residentsMainUriu;
	}

	/**
	 * ResidentsMainUriuエンティティに入力値を入れる
	 *
	 * @param ResidentsMainUriu residentsMainUriu
	 * @return ResidentsMainUriu
	 */
	private ResidentsMainUriu convertToResidentsMainUriu(ResidentsMainUriu residentsMainUriu) {
		residentsMainUriu.setName(this.name);
		if(this.typeId == CommonConst.NOT_ENTERD) {
			// 性格タイプが入力されていなかった場合
			residentsMainUriu.setTypeId((Integer) null);
		}else {
			// 性格タイプが入力されていた場合
			residentsMainUriu.setTypeId(this.typeId);
		}
		if(this.animalId == CommonConst.NOT_ENTERD) {
			// どうぶつが入力されていなかった場合
			residentsMainUriu.setAnimalId((Integer) null);
		}else {
			// どうぶつが入力されていた場合
			residentsMainUriu.setAnimalId(this.animalId);
		}
		if (!this.phrase.isEmpty()) {
			// 口癖が入力されていた場合
			residentsMainUriu.setPhrase(this.phrase);
		} else {
			//入力されていない場合
			residentsMainUriu.setPhrase(null);
		}
		if (!this.motto.isEmpty()) {
			// 座右の銘が入力されていた場合
			residentsMainUriu.setMotto(this.motto);
		} else {
			//入力されていない場合
			residentsMainUriu.setMotto(null);
		}
		if (!this.birthday.isEmpty()) {
			// 誕生日が入力されていた場合
			residentsMainUriu.setBirthday(this.birthday);
		} else {
			//入力されていない場合
			residentsMainUriu.setBirthday(null);
		}
		if (!this.image.isEmpty()) {
			// 画像が入力されていた場合
			residentsMainUriu.setImage(this.image);
		} else {
			//入力されていない場合
			residentsMainUriu.setImage(null);
		}
		residentsMainUriu.setDelFlg("0");
		return residentsMainUriu;

	}

}
