package jp.co.futureantiques.webapptraining.model.form.guiterFujimoto;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.GuiterMainFujimoto;
import lombok.Data;

/**
 * ギター登録・更新画面用のFormクラス
 *
 * @author Fujimoto Yoshihisa
 */
@Data
public class GuiterInputForm {

	/** ID */
	private int id;

	/** アコギ名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String name;

	/** 会社ID */
	private Integer companyId;

	/** 木材ID */
	private Integer woodId;

	/** 価格 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 8, message = "common.text.error.size.max.eight")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String priceInt;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param movieMain
	 */
	public void initWithGuiterMainFujimoto(GuiterMainFujimoto guiterMainFujimoto) {
		this.setId((int) guiterMainFujimoto.getId());
		this.setName(guiterMainFujimoto.getAconame());
		this.setCompanyId(guiterMainFujimoto.getCompanyId());
		this.setWoodId(guiterMainFujimoto.getWoodId());
		this.setPriceInt(String.valueOf(guiterMainFujimoto.getPriceInt()));
		this.setComment(guiterMainFujimoto.getComment());
		this.setUpdateDate(String.valueOf(guiterMainFujimoto.getUpdateDate()));
	}

	/**
	 * GuiterMainFujimotoエンティティに登録値を入れる
	 *
	 * @return GuiterMainFujimoto
	 */
	public GuiterMainFujimoto convertToGuiterMainFujimotoForInsert() {
		GuiterMainFujimoto guiterMainFujimoto = new GuiterMainFujimoto();
		guiterMainFujimoto = convertToGuiterMainFujimoto(guiterMainFujimoto);
		guiterMainFujimoto.setCreateDate(new Timestamp(new Date().getTime()));
		guiterMainFujimoto.setUpdateDate(guiterMainFujimoto.getCreateDate());
		return guiterMainFujimoto;
	}

	/**
	 * MovieMainエンティティに更新値を入れる
	 *
	 * @param MovieMain movieMain
	 * @return MovieMain
	 */
	public GuiterMainFujimoto convertToGuiterMainFujimotoForUpdate(GuiterMainFujimoto guiterMainFujimoto) {
		guiterMainFujimoto = convertToGuiterMainFujimoto(guiterMainFujimoto);
		guiterMainFujimoto.setUpdateDate(new Timestamp(new Date().getTime()));
		return guiterMainFujimoto;
	}

	/**
	 * MovieMainエンティティに入力値を入れる
	 *
	 * @param MovieMain movieMain
	 * @return MovieMain
	 */
	private GuiterMainFujimoto convertToGuiterMainFujimoto(GuiterMainFujimoto guiterMainFujimoto) {
		guiterMainFujimoto.setAconame(this.name);
		guiterMainFujimoto.setCompanyId(this.companyId);
		guiterMainFujimoto.setWoodId(this.woodId);
		guiterMainFujimoto.setPriceInt(Integer.parseInt(this.priceInt));
		if (!this.priceInt.isEmpty()) {

			// 価格が入力されていた場合
			guiterMainFujimoto.setPriceInt(Integer.parseInt(this.priceInt));
		} else {
			// 価格が入力されていなかった場合
			guiterMainFujimoto.setPriceInt(null);
		}
		guiterMainFujimoto.setComment(this.comment);
		guiterMainFujimoto.setDelFlg("0");
		return guiterMainFujimoto;
	}
}