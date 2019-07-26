package jp.co.futureantiques.webapptraining.model.form.dffTatebe;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.dffTatebe.DffMainTatebe;
import lombok.Data;

/**
 * キャラクター登録・更新画面用のFormクラス
 *
 *@author user Tatebe
 */
@Data
public class DffTatebeInputForm {

	/** ID */
	private int id;

	/** キャラクター名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String dffName;

	/** 作品ID */
	private Integer titleId;

	/** デッキID */
	private Integer typeId;

	/** コメント */
	@Size(max= 255)
	private String comment;

	/** 更新日時 */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param dffMainTatebe
	 */
	public void initWithDffMainTatebe(DffMainTatebe dffMainTatebe) {
		this.setId((int)dffMainTatebe.getId());
		this.setDffName(dffMainTatebe.getDffName());
		this.setTitleId(dffMainTatebe.getTitleId());
		this.setTypeId(dffMainTatebe.getTypeId());
		this.setComment(dffMainTatebe.getComment());
		this.setUpdateDate(String.valueOf(dffMainTatebe.getUpdateDate()));
	}

	/**
	 * DffMainTatebe
	 *
	 * @return DffMainTatebe
	 */
	public DffMainTatebe convertToDffMainTatebeForInsert() {
		DffMainTatebe dffMainTatebe = new DffMainTatebe();
		dffMainTatebe = convertToDffMainTatebe(dffMainTatebe);
		dffMainTatebe.setCreateDate(new Timestamp(new Date().getTime()));
		dffMainTatebe.setUpdateDate(dffMainTatebe.getCreateDate());
		return dffMainTatebe;
	}

	/**
	 *DffMainTatebeエンティティに更新値を入れる
	 *
	 * @param DffMainTatebe dffMainTatebe
	 * @return DffMainTatebe
	 */
	public DffMainTatebe convertToDffMainTatebeForUpdate(DffMainTatebe dffMainTatebe) {
		dffMainTatebe = convertToDffMainTatebe(dffMainTatebe);
		dffMainTatebe.setUpdateDate(new Timestamp(new Date().getTime()));
		return dffMainTatebe;
	}

	/**
	 * DffMainTatebeエンティティに更新値を入れる
	 *
	 * @param DffMainTatebe dffMainTatebe
	 * @return DffMainTatebe
	 */
	//private DffMainTatebe convertToDffMainTatebe(DffMainTatebe dffMainTatebe) {
		//dffMainTatebe.setDffName(this.dffName);
		//dffMainTatebe.setTitleId(this.titleId);
		//if(this.typeId != 0) {
			//dffMainTatebe.setTypeId(this.typeId);
		//}else {
			//dffMainTatebe.setTypeId(null);
		//}
		//if(!this.comment.isEmpty()) {
			//dffMainTatebe.setComment(this.comment);
		//}else {
			//dffMainTatebe.setComment(null);
		//}
		//dffMainTatebe.setDelFlg("0");
		//return dffMainTatebe;

	private DffMainTatebe convertToDffMainTatebe(DffMainTatebe dffMainTatebe) {
		dffMainTatebe.setDffName(this.dffName);
		dffMainTatebe.setTitleId(this.titleId);
		dffMainTatebe.setTypeId(this.typeId);
		dffMainTatebe.setComment(this.comment);
		dffMainTatebe.setDelFlg("0");
		return dffMainTatebe;
	}
}
