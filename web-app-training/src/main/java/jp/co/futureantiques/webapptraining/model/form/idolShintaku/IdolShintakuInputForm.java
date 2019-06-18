package jp.co.futureantiques.webapptraining.model.form.idolShintaku;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.idolShintaku.IdolMainShintaku;
import lombok.Data;

/**
 * アイドル登録・更新画面用のFormクラス
 *
 * @author shintaku
 */
@Data
public class IdolShintakuInputForm {

	/** アイドルID */
	private int id;

	/** アイドル名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String name;

	/** 年齢 */
	@Max(value = 99,message ="common.text.error.size.max.two")
	private Integer age;

	/** 属性ID */
	@NotNull(message = "common.text.error.require")
	@Min(value = 1, message = "common.text.error.require")
	private Integer typeId;

	/** ユニットID */
	private Integer unitId;

	/** ソロ曲 */
	@Size(max = 256)
	private String song;

	/** コメント */
	@Size(max = 256)
	private String comment;

	/** 更新日時(排他制御用) */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param idolMainShintaku
	 */
	public void initWithIdolMainShintaku(IdolMainShintaku idolMainShintaku) {
		this.setId((int)idolMainShintaku.getId());
		this.setName(idolMainShintaku.getName());
		this.setAge(idolMainShintaku.getAge());
		this.setTypeId(idolMainShintaku.getTypeId());
		this.setUnitId(idolMainShintaku.getUnitId());
		this.setSong(idolMainShintaku.getSong());
		this.setComment(idolMainShintaku.getComment());
		this.setUpdateDate(String.valueOf(idolMainShintaku.getUpdateDate()));
	}

	/**
	 * idolMainShintakuエンティティに登録値を入れる
	 *
	 * @return idolMainShintaku
	 */
	public IdolMainShintaku convertToIdolMainShintakuForInsert() {
		IdolMainShintaku idolMainShintaku = new IdolMainShintaku();
		idolMainShintaku = convertToIdolMainShintaku(idolMainShintaku);
		idolMainShintaku.setCreateDate(new Timestamp(new Date().getTime()));
		idolMainShintaku.setUpdateDate(idolMainShintaku.getCreateDate());
		return idolMainShintaku;
	}

	/**
	 * IdolMainShintakuエンティティに更新値を入れる
	 *
	 * @param IdolMainShintaku idolMainShintaku
	 * @return IdolMainShintaku
	 */
	public IdolMainShintaku convertToIdolMainShintakuForUpdate(IdolMainShintaku idolMainShintaku) {
		idolMainShintaku = convertToIdolMainShintaku(idolMainShintaku);
		idolMainShintaku.setUpdateDate(new Timestamp(new Date().getTime()));
		return idolMainShintaku;
	}

	/**
	 * IdolMainShintakuエンティティに入力値を入れる
	 *
	 * @param IdolMainShintaku idolMainShintaku
	 * @return IdolMainShintaku
	 */
	private IdolMainShintaku convertToIdolMainShintaku(IdolMainShintaku idolMainShintaku) {
		idolMainShintaku.setId(this.id);
		idolMainShintaku.setName(this.name);
		idolMainShintaku.setAge(this.age);
		idolMainShintaku.setTypeId(this.typeId);
		if(this.unitId != 0) {

			// ユニットが選択されている場合
			idolMainShintaku.setUnitId(this.unitId);
		}else {

			// ユニットが選択されていない場合
			idolMainShintaku.setUnitId(null);
		}
		if(!this.song.isEmpty()) {

			// ソロ曲が入力されている場合
			idolMainShintaku.setSong(this.song);
		}else {

			// ソロ曲が入力されていない場合
			idolMainShintaku.setSong(null);
		}
		if(!this.comment.isEmpty()) {

			// コメントが入力されている場合
			idolMainShintaku.setComment(this.comment);
		}else {

			// コメントが入力されていない場合
			idolMainShintaku.setComment(null);
		}
		idolMainShintaku.setDelFlg("0");
		return idolMainShintaku;
	}
}
