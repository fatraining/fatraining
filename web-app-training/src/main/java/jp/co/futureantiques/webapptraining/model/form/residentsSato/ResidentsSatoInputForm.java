package jp.co.futureantiques.webapptraining.model.form.residentsSato;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.residentsSato.ResidentsMainSato;
import lombok.Data;

/**
 * 住民登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data
public class ResidentsSatoInputForm {

	/** ID */
	private int id;

	/** 住民名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256,message ="residents.text.error.invalid.name")
	private String residentsName;

	/** 動物ID */
	private Integer animalId;

	/** 性別ID */
	private Integer sexId;

	/** コメント */
	@Size(max = 256,message ="residents.text.error.invalid.name")
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param residentsMainSato
	 */
	public void initWithResidentsMainSato(ResidentsMainSato residentsMainSato) {
		this.setId((int) residentsMainSato.getId());
		this.setResidentsName(residentsMainSato.getResidentsName());
		this.setAnimalId(residentsMainSato.getAnimalId());
		this.setSexId(residentsMainSato.getSexId());
		this.setComment(residentsMainSato.getComment());
		this.setUpdateDate(String.valueOf(residentsMainSato.getUpdateDate()));
	}

	/**
	 * ResidentsMainエンティティに登録値を入れる
	 *
	 * @return ResidentsMainSato
	 */
	public ResidentsMainSato convertToResidentsMainForInsert() {
		ResidentsMainSato residentsMainSato = new ResidentsMainSato();
		residentsMainSato = convertToResidentsMain(residentsMainSato);
		residentsMainSato.setCreateDate(new Timestamp(new Date().getTime()));
		residentsMainSato.setUpdateDate(residentsMainSato.getCreateDate());
		return residentsMainSato;
	}

	/**
	 * ResidentsMainエンティティに更新値を入れる
	 * @param ResidentsMainSato residentsMainSato
	 * @return ResidentsMainSato
	 */
	public ResidentsMainSato convertToResidentsMainSatoForUpdate(ResidentsMainSato residentsMainSato) {
		residentsMainSato = convertToResidentsMain(residentsMainSato);
		residentsMainSato.setUpdateDate(new Timestamp(new Date().getTime()));
		return residentsMainSato;
	}

	/**
	 * ResidentsMainエンティティに入力値を入れる
	 *
	 * @param ResidentsMainSato residentsMainSato
	 * @return ResidentsMainSato
	 */
	private ResidentsMainSato convertToResidentsMain(ResidentsMainSato residentsMainSato) {
		residentsMainSato.setResidentsName(this.residentsName);
		if (this.animalId == CommonConst.NOT_ENTERD) {

			// 動物が入力されていなかった場合
			residentsMainSato.setAnimalId(null);
		} else {

			// 動物が入力されていた場合
			residentsMainSato.setAnimalId(this.animalId);
		}
		if (this.sexId == CommonConst.NOT_ENTERD) {

			// 性別が入力されていなかった場合
			residentsMainSato.setSexId(null);
		} else {

			// 性別が入力されていた場合
			residentsMainSato.setSexId(this.sexId);
		}

		residentsMainSato.setComment(this.comment);
		residentsMainSato.setDelFlg("0");
		return residentsMainSato;
	}
}
