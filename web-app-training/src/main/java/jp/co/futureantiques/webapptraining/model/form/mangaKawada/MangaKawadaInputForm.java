package jp.co.futureantiques.webapptraining.model.form.mangaKawada;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.mangaKawada.MangaMainKawada;
import lombok.Data;

/**
 * 漫画登録・更新画面用のFormクラス
 *
 * @author Kawada
 */
@Data
public class MangaKawadaInputForm {

	/** ID */
	private int id;

	//@Size message修正
	/** 漫画タイトル */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256, message = "magazine.text.error.invalid.name")
	private String mangaTitle;

	/** ジャンルID */
	private Integer genreId;

	/** アニメID */
	private Integer animeId;

	/** 連載状況ID */
	private Integer situationId;

	/** 連載開始年 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String serializationStartStr;

	//@Size message修正
	/** コメント */
	@Size(max = 256,message = "magazine.text.error.invalid.name")
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param mangaMainKawada
	 */
	public void initWithMangaMainKawada(MangaMainKawada mangaMainKawada) {
		this.setId((int) mangaMainKawada.getId());
		this.setMangaTitle(mangaMainKawada.getMangaTitle());
		this.setGenreId(mangaMainKawada.getGenreId());
		this.setAnimeId(mangaMainKawada.getAnimeId());
		this.setSituationId(mangaMainKawada.getSituationId());
		//valueOfでString型にしている
		this.setSerializationStartStr(String.valueOf(mangaMainKawada.getSerializationStart()));
		this.setComment(mangaMainKawada.getComment());
		this.setUpdateDate(String.valueOf(mangaMainKawada.getUpdateDate()));
	}

	/**
	 * MangaMainKawadaエンティティに登録値を入れる
	 *
	 * @return MangaMainKawada
	 */
	public MangaMainKawada convertToMangaMainKawadaForInsert() {
		MangaMainKawada mangaMainKawada = new MangaMainKawada();
		mangaMainKawada = convertToMangaMainKawada(mangaMainKawada);
		mangaMainKawada.setCreateDate(new Timestamp(new Date().getTime()));
		mangaMainKawada.setUpdateDate(mangaMainKawada.getCreateDate());
		return mangaMainKawada;
	}

	/**
	 * MangaMainKawadaエンティティに更新値を入れる
	 *
	 * @param MovieMain movieMain
	 * @return MovieMain
	 */
	public MangaMainKawada convertToMangaMainKawadaForUpdate(MangaMainKawada mangaMainKawada) {
		mangaMainKawada = convertToMangaMainKawada(mangaMainKawada);
		mangaMainKawada.setUpdateDate(new Timestamp(new Date().getTime()));
		return mangaMainKawada;
	}

	/**
	 * MangaMainKawadaエンティティに入力値を入れる
	 *
	 * @param MangaMainKawada mangaMainKawada
	 * @return MangaMainKawada
	 */
	private MangaMainKawada convertToMangaMainKawada(MangaMainKawada mangaMainKawada) {
		mangaMainKawada.setMangaTitle(this.mangaTitle);
		if (this.genreId == CommonConst.NOT_ENTERD) {

			// ジャンルが入力されていなかった場合
			mangaMainKawada.setGenreId(null);
		} else {

			// ジャンルが入力されていた場合
			mangaMainKawada.setGenreId(this.genreId);
		}
		if (this.animeId == CommonConst.NOT_ENTERD) {

			// アニメ化が入力されていなかった場合
			mangaMainKawada.setAnimeId(null);
		} else {

			// アニメ化が入力されていた場合
			mangaMainKawada.setAnimeId(this.animeId);
		}
		if (this.situationId == CommonConst.NOT_ENTERD) {

			// 連載状況が入力されていなかった場合
			mangaMainKawada.setSituationId(null);
		} else {

			// 連載状況が入力されていた場合
			mangaMainKawada.setSituationId(this.situationId);
		}
		mangaMainKawada.setSerializationStart(Integer.parseInt(this.serializationStartStr));
		mangaMainKawada.setComment(this.comment);
		mangaMainKawada.setDelFlg("0");
		return mangaMainKawada;
	}
}
