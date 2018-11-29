package jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.MusicalCompositionMainTakei;
import lombok.Data;

/**
 * 楽曲登録・更新画面用のFormクラス
 *
 * @author takei
 */
@Data
public class MusicalCompositionInputForm {

	/** 楽曲ID */
	private int id;

	/** 楽曲名 */
	@Size(max = 255)
	private String title;

	/** ジャンルID */
	private Integer genreId;

	/** 収録アルバム */
	private Integer albumId;

	/** 時間 */
	@Size(min = 0, max = 4)
	private String theNumberOfEconds;

	/** 発売日 */
	@Size(max = 30)
	private String releaseDay;

	/** コメント */
	@Size(max = 256)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param MusicalCompositionMainTakei
	 */
	public void intiWithmusicalCompositionMainTakei(MusicalCompositionMainTakei musicalCompositionMainTakei) {
		this.setId((int) musicalCompositionMainTakei.getId());
		this.setTitle(musicalCompositionMainTakei.getTitle());
		this.setGenreId(musicalCompositionMainTakei.getGenreId());
		this.setAlbumId(musicalCompositionMainTakei.getAlbumId());
		this.setTheNumberOfEconds(musicalCompositionMainTakei.getTheNumberOfEconds());
		this.setReleaseDay(musicalCompositionMainTakei.getReleaseDay());
		this.setComment(musicalCompositionMainTakei.getComment());
		this.setUpdateDate(String.valueOf(musicalCompositionMainTakei.getUpdateDate()));
	}

	/**
	 * MusicalCompositionMainTakeiエンティティに登録値を入れる
	 *
	 * @return MusicalCompositionMainTakei
	 *
	 */
	public MusicalCompositionMainTakei convertToMusicalCompositionSearchMainForInsert() {
		MusicalCompositionMainTakei musicalCompositionMainTakei = new MusicalCompositionMainTakei();
		musicalCompositionMainTakei = convertTomusicalCompositionMainTakei(musicalCompositionMainTakei);
		musicalCompositionMainTakei.setCreateDate(new Timestamp(new Date().getTime()));
		musicalCompositionMainTakei.setUpdateDate(musicalCompositionMainTakei.getCreateDate());
		return musicalCompositionMainTakei;
	}

	/**
	 *  MusicalCompositionMainTakeiエンティティに更新値を入れる
	 *
	 * @param MusicalCompositionMainTakei musicalCompositionMainTakei
	 * @return MusicalCompositionMainTakei
	 */
	public MusicalCompositionMainTakei convertTomusicalCompositionMainTakeiForUpdate(
			MusicalCompositionMainTakei musicalCompositionMainTakei) {
		musicalCompositionMainTakei = convertTomusicalCompositionMainTakei(musicalCompositionMainTakei);
		musicalCompositionMainTakei.setUpdateDate(new Timestamp(new Date().getTime()));
		return musicalCompositionMainTakei;
	}

	/**
	 * MusicalCompositionMainTakeiエンティティに入力値を入れる
	 *
	 * @param MusicalCompositionMainTakei musicalCompositionMainTakei
	 * @return MusicalCompositionMainTakei
	 */
	private MusicalCompositionMainTakei convertTomusicalCompositionMainTakei(
			MusicalCompositionMainTakei musicalCompositionMainTakei) {
		musicalCompositionMainTakei.setTitle(this.title);
		musicalCompositionMainTakei.setGenreId(this.genreId);
		musicalCompositionMainTakei.setAlbumId(this.albumId);
		musicalCompositionMainTakei.setTheNumberOfEconds(this.theNumberOfEconds);
		musicalCompositionMainTakei.setReleaseDay(this.releaseDay);
		musicalCompositionMainTakei.setComment(this.comment);
		musicalCompositionMainTakei.setDelFlg("0");
		return musicalCompositionMainTakei;
	}
}