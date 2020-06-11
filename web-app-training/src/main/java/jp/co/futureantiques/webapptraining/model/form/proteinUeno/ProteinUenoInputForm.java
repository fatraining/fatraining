package jp.co.futureantiques.webapptraining.model.form.proteinUeno;


import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.proteinUeno.ProteinMainUeno;
import lombok.Data;

/**
 * プロテイン追加画面のFormクラス
* @author  ueno
*/
@Data
public class ProteinUenoInputForm {

	/**ID**/
	private int id;

	/**フレーバー**/
	@NotNull(message = "common.text.error.require")
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256, message="protein.text.error.size.max")
	private String flavor;

	/** 評価**/
	@Size(max =11 , message="protein.text.error.size.max")
	private Integer review;

	/**種類ID**/
	private Integer kindId;

	/**メーカーID**/
	private Integer makerId;

	/** 評価 */
	private String reviewStr;

	/** コメント**/
	@Size(max = 256, message="protein.text.error.size.max")
	private String comment;

	/**更新日時**/
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 * @param proteinMainUeno
	 * **/
	public void initWithProteinMain(ProteinMainUeno proteinMain) {
		this.setId((int) proteinMain.getId());
		this.setFlavor(proteinMain.getFlavor());
		this.setKindId(proteinMain.getKindId());
		this.setMakerId(proteinMain.getMakerId());
		this.setReviewStr(String.valueOf(proteinMain.getReview()));
		this.setComment(proteinMain.getComment());

		this.setUpdateDate(String.valueOf(proteinMain.getUpdateDate()));
	}

	/**
	 * ProteinMainエンティティに登録値を入れる
	 *
	 * @return ProteinMainUeno
	 */
	public ProteinMainUeno convertToProteinMainUenoForInsert() {
		ProteinMainUeno proteinMain = new ProteinMainUeno();
		proteinMain = convertToProteinMain(proteinMain);
		proteinMain.setCreateDate(new Timestamp(new Date().getTime()));
		proteinMain.setUpdateDate(proteinMain.getCreateDate());
		return proteinMain;
	}

	/**
	 * ProteinMainエンティティに更新値を入れる
	 * @param ProteinMainUeno proteinMainUeno
	 * @return proteinMainUeno
	 */
	public ProteinMainUeno convertToProteinMainForUpdate(ProteinMainUeno proteinMain) {
		proteinMain = convertToProteinMain(proteinMain);
		proteinMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return proteinMain;
	}

	/**
	 * ProteinMainエンティティに入力値を入れる
	 * @param ProteinMainUeno proteinMainUeno
	 * @return ProteinMainUeno
	 */
	private ProteinMainUeno convertToProteinMain(ProteinMainUeno proteinMain) {
		proteinMain.setFlavor(this.flavor);
		if(this.kindId == CommonConst.NOT_ENTERD) {

			// 種類が入力されていなかった場合
			proteinMain.setKindId(null);
		}else {

			// 種類が入力されていた場合
			proteinMain.setKindId(this.kindId);
		}

		if(this.makerId == CommonConst.NOT_ENTERD) {

			// メーカーが入力されていなかった場合
			proteinMain.setMakerId(null);
		}else {

			// メーカーが入力されていた場合
			proteinMain.setMakerId(this.makerId);
		}

		proteinMain.setReview(Integer.parseInt(this.reviewStr));
		proteinMain.setComment(this.comment);
		proteinMain.setDelFlg("0");
		return proteinMain;
	}

}
