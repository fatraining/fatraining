package jp.co.futureantiques.webapptraining.model.form.vtuberUmehara;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.vtuberUmehara.VtuberMainUmehara;
import lombok.Data;

@Data
public class VtuberUmeharaInputForm {

	/** ID */
	private Integer id;

	/** Vtuber名 */
	@NotBlank(message = "common.text.error.require")
	private String vtuberName;

	/** 会社ID */
	@NotNull(message = "common.text.error.require")
	private Integer companyId;

	/** 動画形態ID */
	@NotNull(message = "common.text.error.require")
	private Integer formsId;

	/** 動画内容ID */
	@NotNull(message = "common.text.error.require")
	private Integer contentsId;

	/** チャンネルURL */
	@NotBlank(message = "common.text.error.require")
	private String channelUrl;

	/** チャンネル登録者数 */
	private Integer channelFollowers;

	/** チャンネル作成日 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String channelDate;

	/** コメント */
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param VtuberMainUmehara vtuberMainUmehara
	 */
	public void initWithVtuberMainUmehara(VtuberMainUmehara vtuberMainUmehara) {
		this.setId((int) vtuberMainUmehara.getId());
		this.setVtuberName(vtuberMainUmehara.getVtuberName());
		this.setCompanyId(vtuberMainUmehara.getCompanyId());
		this.setFormsId(vtuberMainUmehara.getFormsId());
		this.setContentsId(vtuberMainUmehara.getContentsId());
		this.setChannelUrl(vtuberMainUmehara.getChannelUrl());
		this.setChannelFollowers(vtuberMainUmehara.getChannelFollowers());
		this.setChannelDate(vtuberMainUmehara.getChannelDate().toString());
		this.setComment(vtuberMainUmehara.getComment());
		this.setUpdateDate(String.valueOf(vtuberMainUmehara.getUpdateDate()));
	}

	/**
	 * VtuberMainUmeharaエンティティに登録値を入れる
	 *
	 * @return VtuberMainUmehara
	 */
	public VtuberMainUmehara convertToVtuberMainUmeharaForInsert() {
		VtuberMainUmehara vtuberMainUmehara = new VtuberMainUmehara();
		vtuberMainUmehara = convertToVtuberMainUmehara(vtuberMainUmehara);
		vtuberMainUmehara.setCreateDate(new Timestamp(new Date().getTime()));
		vtuberMainUmehara.setUpdateDate(vtuberMainUmehara.getCreateDate());
		return vtuberMainUmehara;
	}

	/**
	 * VtuberMainUmeharaエンティティに更新値を入れる
	 *
	 * @param VtuberMainUmehara vtuberMainUmehara
	 * @return VtuberMainUmehara
	 */
	public VtuberMainUmehara convertToVtuberMainUmeharaForUpdate(VtuberMainUmehara vtuberMainUmehara) {
		vtuberMainUmehara = convertToVtuberMainUmehara(vtuberMainUmehara);
		vtuberMainUmehara.setUpdateDate(new Timestamp(new Date().getTime()));
		return vtuberMainUmehara;
	}

	/**
	 * VtuberMainUmeharaエンティティに入力値を入れる
	 *
	 * @param VtuberMainUmehara vtuberMainUmehara
	 * @return VtuberMainUmehara
	 */
	private VtuberMainUmehara convertToVtuberMainUmehara(VtuberMainUmehara vtuberMainUmehara) {
		vtuberMainUmehara.setVtuberName(this.vtuberName);
		if (this.getCompanyId() == CommonConst.NOT_ENTERD) {

			// 会社が入力されていなかった場合
			vtuberMainUmehara.setCompanyId(null);
		} else {

			// 会社が入力されていた場合
			vtuberMainUmehara.setCompanyId(this.companyId);
		}
		if (this.formsId == CommonConst.NOT_ENTERD) {

			// 動画形態が入力されていなかった場合
			vtuberMainUmehara.setFormsId(null);
		} else {

			// 動画形態が入力されていた場合
			vtuberMainUmehara.setFormsId(this.formsId);
		}
		if (this.contentsId == CommonConst.NOT_ENTERD) {

			// 動画内容が入力されていなかった場合
			vtuberMainUmehara.setContentsId(null);
		} else {

			// 動画内容が入力されていた場合
			vtuberMainUmehara.setContentsId(this.contentsId);
		}
		vtuberMainUmehara.setChannelUrl(this.channelUrl);
		vtuberMainUmehara.setChannelFollowers(this.channelFollowers);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			vtuberMainUmehara.setChannelDate(sdf.parse(this.channelDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vtuberMainUmehara.setComment(this.comment);
		vtuberMainUmehara.setDelFlg("0");
		return vtuberMainUmehara;
	}
}
