package jp.co.futureantiques.webapptraining.model.form.mlbUezu;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * MLB球団登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data
public class MLBTeamInputForm {

	/** ID */
	private int id;

	/** 球団名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String teamName;

	/** 創設年 */
	private Integer foundinguYear;

	/** 加盟年 */
	private Integer membershipYear;

	/** 本拠地 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String headquarters;

	/** リーグID */
	private Integer leagueId;

	/** 地区ID */
	private Integer districtId;

	/** 更新日時（排他制御用） */
	private String updateDate;

	//未作成↓
	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param movieMain
	 *
	public void initWithMovieMain(MLBMaiUezu movieMain) {
		this.setId((int) movieMain.getId());
		this.setMovieTitle(movieMain.getMovieTitle());
		this.setGenreId(movieMain.getGenreId());
		this.setActorId(movieMain.getActorId());
		this.setReleaseYearStr(String.valueOf(movieMain.getReleaseYear()));
		if (movieMain.getRunTime() != null) {
			this.setRunTimeStr(String.valueOf(movieMain.getRunTime()));
		}
		this.setComment(movieMain.getComment());
		this.setUpdateDate(String.valueOf(movieMain.getUpdateDate()));
	}

	/**
	 * MovieMainエンティティに登録値を入れる
	 *
	 * @return MovieMain
	 *
	public MLBMaiUezu convertToMovieMainForInsert() {
		MLBMaiUezu movieMain = new MLBMaiUezu();
		movieMain = convertToMovieMain(movieMain);
		movieMain.setCreateDate(new Timestamp(new Date().getTime()));
		movieMain.setUpdateDate(movieMain.getCreateDate());
		return movieMain;
	}

	/**
	 * MovieMainエンティティに更新値を入れる
	 *
	 * @param MLBMainUezu movieMain
	 * @return MovieMain
	 *
	public MLBMaiUezu convertToMovieMainForUpdate(MLBMaiUezu movieMain) {
		movieMain = convertToMovieMain(movieMain);
		movieMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return movieMain;
	}

	/**
	 * MovieMainエンティティに入力値を入れる
	 *
	 * @param MLBMainUezu movieMain
	 * @return MovieMain
	 *
	private MLBMaiUezu convertToMovieMain(MLBMaiUezu movieMain) {
		movieMain.setMovieTitle(this.movieTitle);
		movieMain.setGenreId(this.genreId);
		movieMain.setActorId(this.actorId);
		movieMain.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		if (!this.runTimeStr.isEmpty()) {

			// 上映時間が入力されていた場合
			movieMain.setRunTime(Integer.parseInt(this.runTimeStr));
		} else {

			// 上映時間が入力されていなかった場合
			movieMain.setRunTime(null);
		}
		movieMain.setComment(this.comment);
		movieMain.setDelFlg("0");
		return movieMain;
	}
	*/
}