package jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
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
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
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

	public void intiWithMusicalCompositionSearchMain(MusicalCompositionMainTakei musicalCompositionSearchMain) {
		this.setId((int)musicalCompositionSearchMain.getId());
		this.setTitle(musicalCompositionSearchMain.getTitle());
		this.setGenreId(musicalCompositionSearchMain.getGenreId());
		this.setAlbumId(musicalCompositionSearchMain.getAlbumId());
		this.setTheNumberOfEconds(musicalCompositionSearchMain.getTheNumberOfEconds());
		this.setReleaseDay(musicalCompositionSearchMain.getReleaseDay());
		this.setComment(musicalCompositionSearchMain.getComment());
		this.setUpdateDate(String.valueOf(musicalCompositionSearchMain.getUpdateDate()));
	}

    /**
    * MusicalCompositionSearchMainエンティティに登録値を入れる
    *
    * @return MusicalCompositionSearchMain
    *
    */
    public MusicalCompositionMainTakei convertToMusicalCompositionSearchMainForInsert() {
    	MusicalCompositionMainTakei musicalCompositionSearchMain = new MusicalCompositionMainTakei();
    	musicalCompositionSearchMain =convertToMusicalCompositionSearchMain(musicalCompositionSearchMain);
    	musicalCompositionSearchMain .setCreateDate(new Timestamp(new Date().getTime()));
    	musicalCompositionSearchMain .setUpdateDate(musicalCompositionSearchMain.getCreateDate());
    	return musicalCompositionSearchMain;
    }

    /**
     *  MusicalCompositionSearchMainエンティティに更新値を入れる
     *
     * @param MovieMain movieMain
     * @return MovieMain
     */
    public  MusicalCompositionMainTakei convertToMusicalCompositionSearchMainForUpdate(MusicalCompositionMainTakei musicalCompositionSearchMain) {
    	musicalCompositionSearchMain=convertToMusicalCompositionSearchMain(musicalCompositionSearchMain);
    	musicalCompositionSearchMain.setUpdateDate(new Timestamp(new Date().getTime()));
    	return  musicalCompositionSearchMain;
    }

    /**
     * MusicalCompositionSearchMainエンティティに入力値を入れる
     *
     * @param MusicalCompositionMainTakei musicalCompositionSearchMain
     * @return MusicalCompositionSearchMain
     */
    private MusicalCompositionMainTakei convertToMusicalCompositionSearchMain(MusicalCompositionMainTakei musicalCompositionSearchMain) {
    	musicalCompositionSearchMain.setTitle(this.title);
    	musicalCompositionSearchMain.setGenreId(this.genreId);
    	musicalCompositionSearchMain.setAlbumId(this.albumId);
    	musicalCompositionSearchMain.setTheNumberOfEconds(this.theNumberOfEconds);
    	musicalCompositionSearchMain.setReleaseDay(this.releaseDay);
    	musicalCompositionSearchMain.setComment(this.comment);
    	musicalCompositionSearchMain.setDelFlg("0");
    	return musicalCompositionSearchMain;
	}
}