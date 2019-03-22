package jp.co.futureantiques.webapptraining.model.form.catNihonyanagi;


import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.catNihonyanagi.CatMainNihonyanagi;
import lombok.Data;

/**
 * ネコ登録・更新画面用のFormクラス
 * @author Nihonyanagi
 *
 */
@Data
public class CatInputForm {

	/** ID */
	private int id;

	/** ネコ名前 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String catName;

	/** 被毛ID */
	private Integer hairId;

	/** 大きさID */
	private Integer sizeId;

	/** 性格ID */
	private Integer characterId;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時(排他制御用) */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 * @param CatMain
	 */
	public void initWithCatMainNihonyanagi(CatMainNihonyanagi catMainNihonyanagi) {
		this.setId((int)catMainNihonyanagi.getId());
		this.setCatName(catMainNihonyanagi.getCatName());
		this.setHairId(catMainNihonyanagi.getHairId());
		this.setSizeId(catMainNihonyanagi.getSizeId());
		this.setCharacterId(catMainNihonyanagi.getCharacterId());
		this.setComment(catMainNihonyanagi.getComment());
		this.setUpdateDate(String.valueOf(catMainNihonyanagi.getUpdateDate()));
	}

	/**
	 * CatMainエンティティに登録地を入れる
	 *
	 * @return CatMain
	 */
	public CatMainNihonyanagi convertToCatMainNihonyanagiForInsert() {
		CatMainNihonyanagi catMainNihonyanagi = new CatMainNihonyanagi();
		catMainNihonyanagi = convertToCatMainNihonyanagi(catMainNihonyanagi);
		catMainNihonyanagi.setCreateDate(new Timestamp(new Date().getTime()));
		catMainNihonyanagi.setUpdateDate(catMainNihonyanagi.getCreateDate());
		return catMainNihonyanagi;
	}

	/**
	 * CatMainエンティティに更新値を入れる
	 * @param CatMainNihonyanagi catMainNihonyanagi
	 * @return CaMainNihonyanagi
	 */
	public CatMainNihonyanagi convertToCatMainNihonyanagiForUpdate(CatMainNihonyanagi catMainNihonyanagi) {
		catMainNihonyanagi = convertToCatMainNihonyanagi(catMainNihonyanagi);
		catMainNihonyanagi.setUpdateDate(catMainNihonyanagi.getUpdateDate());
		//new Timestamp(new Date().getTime())
		return catMainNihonyanagi;
	}

	/**
	 * CatMainエンティティに入力値を入れる
	 *
	 * @param CatMainNihonyanagi catMainNihonyanagi
	 * @return CatMainNihonyanagi
	 */
	private CatMainNihonyanagi convertToCatMainNihonyanagi(CatMainNihonyanagi catMainNihonyanagi) {
		catMainNihonyanagi.setCatName(this.catName);
		catMainNihonyanagi.setHairId(this.hairId);
		catMainNihonyanagi.setSizeId(this.sizeId);
		catMainNihonyanagi.setCharacterId(this.characterId);
		catMainNihonyanagi.setComment(this.comment);
		catMainNihonyanagi.setDelFlg("0");
		return catMainNihonyanagi;
	}

}
