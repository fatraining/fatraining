package jp.co.futureantiques.webapptraining.model.form.doramasample;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.doramasample.DoramaMain;
import lombok.Data;

/**
 * ドラマ登録・更新画面用のFormクラス
 *
 * @author hiraoka
 */
@Data
public class DoramaSampleInputForm {

	/** ID */
	private int id;

	/** ドラマタイトル */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String doramaTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 放送局ID */
	private Integer tvStationId;

	/** 公開年 */
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** 主演 */
	@Size(max = 255)
	private String star;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param doramaMain
	 */
	public void initWithdoramaMain(DoramaMain doramaMain) {
		this.setId((int) doramaMain.getId());
		this.setDoramaTitle(doramaMain.getDoramaTitle());
		this.setGenreId(doramaMain.getGenreId());
		this.setTvStationId(doramaMain.getTvStationId());
		this.setReleaseYearStr(String.valueOf(doramaMain.getReleaseYear()));
		this.setStar(doramaMain.getStar());
		this.setUpdateDate(String.valueOf(doramaMain.getUpdateDate()));
	}

	/**
	 * doramaMainエンティティに登録値を入れる
	 *
	 * @return doramaMain
	 */
	public DoramaMain convertTodoramaMainForInsert() {
		DoramaMain doramaMain = new DoramaMain();
		doramaMain = convertTodoramaMain(doramaMain);
		doramaMain.setCreateDate(new Timestamp(new Date().getTime()));
		doramaMain.setUpdateDate(doramaMain.getCreateDate());
		return doramaMain;
	}

	/**
	 * doramaMainエンティティに更新値を入れる
	 *
	 * @param DoramaMain doramaMain
	 * @return doramaMain
	 */
	public DoramaMain convertTodoramaMainForUpdate(DoramaMain doramaMain) {
		doramaMain = convertTodoramaMain(doramaMain);
		doramaMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return doramaMain;
	}

	/**
	 * doramaMainエンティティに入力値を入れる
	 *
	 * @param DoramaMain doramaMain
	 * @return doramaMain
	 */
	DoramaMain convertTodoramaMain(DoramaMain doramaMain) {
		doramaMain.setDoramaTitle(this.doramaTitle);
		doramaMain.setGenreId(this.genreId);
		doramaMain.setTvStationId(this.tvStationId);
		doramaMain.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		doramaMain.setStar(this.star);
		doramaMain.setDelFlg("0");
		return doramaMain;
	}
}