package jp.co.futureantiques.webapptraining.model.form.icecreamSako;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.IcecreamSako.IcecreamMainSako;
import lombok.Data;

/**
 * アイスクリーム登録・更新画面用のFormクラス
 *
 * @author MINAMI SAKO
 */
@Data
public class IcecreamInputForm {

	/** ID */
	private long id;

	/** 名前 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String name;

	/** ジャンルID */
	private Integer genreId;

	/** メーカーID */
	private Integer makerId;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時 */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param icecreamMainSako
	 */
	public void initWithIcecreamMain(IcecreamMainSako icecreamMainSako) {
		this.setId((int) icecreamMainSako.getId());
		this.setName(icecreamMainSako.getName());
		this.setGenreId(icecreamMainSako.getGenreId());
		this.setMakerId(icecreamMainSako.getMakerId());
		this.setComment(icecreamMainSako.getComment());
		this.setUpdateDate(String.valueOf(icecreamMainSako.getUpdateDate()));
	}

	/**
	 * IcecreamMainエンティティに登録値を入れる
	 *
	 * @return IcecreamMain
	 */
	public IcecreamMainSako convertToIcecreamMainForInsert() {
		IcecreamMainSako icecreamMainSako = new IcecreamMainSako();
		icecreamMainSako = convertToIcecreamMain(icecreamMainSako);
		icecreamMainSako.setCreateDate(new Timestamp(new Date().getTime()));
		icecreamMainSako.setUpdateDate(icecreamMainSako.getCreateDate());
		return icecreamMainSako;
	}

	/**
	 * IcecreamMainエンティティに更新値を入れる
	 *
	 * @param IcecreamMainSako icecreamMain
	 * @return IcecreamMain
	 */
	public IcecreamMainSako convertToIcecreamMainForUpdate(IcecreamMainSako icecreamMainSako) {
		icecreamMainSako = convertToIcecreamMain(icecreamMainSako);
		icecreamMainSako.setUpdateDate(new Timestamp(new Date().getTime()));
		return icecreamMainSako;
	}

	/**
	 * icecreamMainエンティティに入力値を入れる
	 *
	 * @param IcecreamMainSako IcecreamMain
	 * @return IcecreamMain
	 */
	private IcecreamMainSako convertToIcecreamMain(IcecreamMainSako icecreamMainSako) {
		icecreamMainSako.setId(this.id);
		icecreamMainSako.setName(this.name);
		icecreamMainSako.setGenreId(this.genreId);
		icecreamMainSako.setMakerId(this.makerId);
		icecreamMainSako.setComment(this.comment);
		icecreamMainSako.setDelFlg("0");
		return icecreamMainSako;
	}
}