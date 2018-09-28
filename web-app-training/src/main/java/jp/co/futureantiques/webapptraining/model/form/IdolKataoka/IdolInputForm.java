package jp.co.futureantiques.webapptraining.model.form.IdolKataoka;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.IdolKataoka.IdolMainKataoka;
import lombok.Data;

/**
 * アイドル登録・更新画面用のFormクラス
 *
 * @author skataoka
 */
@Data
public class IdolInputForm {

	/** アイドルID */
	private Integer idolId;

	/** アイドルの名前 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String idolName;

	/** メンバーカラーID */
	private Integer colorId;

	/** 写真 */
	private String photo;

	/** 所属グループ */
	private String groupName;

	/** コメント */
	@Size(max = 256)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param idolMainKataoka
	 */
	public void initWithIdolMainKataoka(IdolMainKataoka idolMainKataoka) {
		this.setIdolId((int) idolMainKataoka.getIdolId());
		this.setIdolName(idolMainKataoka.getIdolName());
		this.setColorId(idolMainKataoka.getColorId());
		this.setPhoto(idolMainKataoka.getPhoto());
		this.setGroupName(String.valueOf(this.getGroupName()));
		this.setComment(idolMainKataoka.getComment());
		this.setUpdateDate(String.valueOf(idolMainKataoka.getUpdateDate()));
	}

	/**
	 * IdolMainKataokaエンティティに登録値を入れる
	 *
	 * @return IdolMainKataoka
	 */
	public IdolMainKataoka convertToIdolMainKataokaForInsert() {
		IdolMainKataoka idolMainKataoka = new IdolMainKataoka();
		idolMainKataoka = convertToIdolMainKataoka(idolMainKataoka);
		idolMainKataoka.setCreateDate(new Timestamp(new Date().getTime()));
		idolMainKataoka.setUpdateDate(idolMainKataoka.getCreateDate());
		return idolMainKataoka;
	}

	/**
	 * IdolMainKataokaエンティティに更新値を入れる
	 *
	 * @param IdolMainKataoka idolMainKataoka
	 * @return IdolMainKataoka
	 */
	public IdolMainKataoka convertToIdolMainKataokaForUpdate(IdolMainKataoka idolMainKataoka) {
		idolMainKataoka= convertToIdolMainKataoka(idolMainKataoka);
		idolMainKataoka.setUpdateDate(new Timestamp(new Date().getTime()));
		return idolMainKataoka;
	}

	/**
	 * IdolMainKataokaエンティティに入力値を入れる
	 *
	 * @param IdolMainKataoka idolMainKataoka
	 * @return IdolMainKataoka
	 */

	private IdolMainKataoka convertToIdolMainKataoka(IdolMainKataoka idolMainKataoka) {
		idolMainKataoka.setIdolName(this.idolName);
		idolMainKataoka.setColorId(this.colorId);
		idolMainKataoka.setPhoto(this.photo);
		idolMainKataoka.setGroupId(Integer.parseInt(this.groupName));
		idolMainKataoka.setComment(this.comment);
		idolMainKataoka.setDelFlg("0");
		return idolMainKataoka;
	}
}