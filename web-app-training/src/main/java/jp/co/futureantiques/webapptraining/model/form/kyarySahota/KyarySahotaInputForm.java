package jp.co.futureantiques.webapptraining.model.form.kyarySahota;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.kyarySahota.KyaryMainSahota;
import lombok.Data;

/**
 * 曲名登録・更新画面用のFormクラス
 *
 * @author futureantiques
 *
 */
@Data
public class KyarySahotaInputForm {

	/** 曲ID */
	private int id;

	/** 曲名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String songTitle;

	/** CDID */
	private Integer nameId;

	/** CD形態ID */
	private Integer typeId;

	/** リリース */
	@Size(max = 4)
	private String releaseYearStr;

	/** 時間 */
	@Size(max = 5)
	private String songTime;

	/** コメント */
	@Size(max = 256)
	private String comment;

	/** 更新日時（排他制御用）*/
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param kyaryMainSahota
	 */
	public void initWithKyaryMainSahota(KyaryMainSahota kyaryMainSahota) {
		this.setId((int) kyaryMainSahota.getId());
		this.setSongTitle(kyaryMainSahota.getSongTitle());
		this.setNameId(kyaryMainSahota.getNameId());
		this.setTypeId(kyaryMainSahota.getTypeId());
		if(kyaryMainSahota.getReleaseYear() != null) {
			this.setReleaseYearStr(String.valueOf(kyaryMainSahota.getReleaseYear()));
		}
		this.setSongTime(kyaryMainSahota.getSongTime());
		this.setComment(kyaryMainSahota.getComment());
		this.setUpdateDate(String.valueOf(kyaryMainSahota.getUpdateDate()));
	}

	/**
	 * KyaryMainエンティティに登録値を入れる
	 *
	 * @param KyaryMainSahota
	 */
	public KyaryMainSahota convertToKyaryMainSahotaForInsert() {
		KyaryMainSahota kyaryMainSahota = new KyaryMainSahota();
		kyaryMainSahota = convertToKyaryMainSahota(kyaryMainSahota);
		kyaryMainSahota.setCreateDate(new Timestamp(new Date().getTime()));
		kyaryMainSahota.setUpdateDate(kyaryMainSahota.getCreateDate());
		return kyaryMainSahota;
	}

	/**
	 * KyaryMainエンティティに更新値を入れる
	 *
	 * @param KyaryMainSahota
	 */
	public KyaryMainSahota convertToKyaryMainSahotaForUpdate(KyaryMainSahota kyaryMainSahota) {
		kyaryMainSahota = convertToKyaryMainSahota(kyaryMainSahota);
		kyaryMainSahota.setUpdateDate(new Timestamp(new Date().getTime()));
		return kyaryMainSahota;
	}

	/**
	 * KyaryMainエンティティに入力値を入れる
	 *
	 * @param KyaryMainSahota kyaryMain
	 * @return KyaryMain
	 */
	private KyaryMainSahota convertToKyaryMainSahota(KyaryMainSahota kyaryMainSahota) {
		kyaryMainSahota.setSongTitle(this.songTitle);
		kyaryMainSahota.setNameId(this.nameId);
		kyaryMainSahota.setTypeId(this.typeId);
		if(!this.releaseYearStr.isEmpty()){

			//リリースが入力されていた場合
			kyaryMainSahota.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		}else{

			//リリースが入力されていなかった場合
			kyaryMainSahota.setReleaseYear(null);
		}
		kyaryMainSahota.setSongTime(this.songTime);
		kyaryMainSahota.setComment(this.comment);
		kyaryMainSahota.setDelFlg("0");
		return kyaryMainSahota;
	}
}
