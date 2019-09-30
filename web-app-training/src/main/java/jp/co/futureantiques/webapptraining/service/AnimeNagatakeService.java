package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.animeNagatake.AnimeMainNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.GenreNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.SourceNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.StudioNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.VoiceactorNagatake;
import jp.co.futureantiques.webapptraining.model.form.animeNagatake.AnimeNagatakeInputForm;
import jp.co.futureantiques.webapptraining.model.form.animeNagatake.AnimeNagatakeSearchForm;

/**
 * AnimeNagatakeのサービスインターフェース
 *
 * @author future
 *
 * */
public interface AnimeNagatakeService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 * */
	List<GenreNagatake> getListGenre();

	/**
	 * スタジオエンティティのリストを取得する
	 *
	 *@return StudioEntityのリスト
	 * */
	List<StudioNagatake> getListStudio();

	/**
	 * 声優エンティティのリストを取得する
	 *
	 *@return VoiceactorEntityのリストを取得
	 * */
	List<VoiceactorNagatake> getListVoiceactor();

	/**
	 * 出典のリストを取得する
	 *
	 * @return SourceEntityのリストを取得する
	 * */
	List<SourceNagatake> getListSource();

	/**
	 * 検索条件を元にAnimeMainNagatakeのレコードのリスト取得する(paging)
	 *
	 * @param AnimeNagatakeSerchForm
	 * @param Pageable pageable
	 * @return AnimeMainNagatakeのリスト
	 * */
	Page<AnimeMainNagatake> getPageAnime(final AnimeNagatakeSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にAnimeMainNagatakeのレコードのリストを取得する
	 *
	 * @param AnimeNagatakeSerchForm
	 * @param AnimeMainNagatake
	 * */
	List<AnimeMainNagatake> getListAnime(final AnimeNagatakeSearchForm form);

	/** IDをキーにAnimeMainNagatakeのレコードを取得する
	 *
	 *  @param long id
	 *	@return AnimeMainNagatakeのレコード
	 **/
	AnimeMainNagatake getAnime(final long id);

	/** AnimeMainNagatakeにレコードを新規追加する
	 *
	 *@param AnimeNagatakeInputForm
	 *@return AnimeMainNagatake
	 * */
	AnimeMainNagatake insertAnime(final AnimeNagatakeInputForm form);

	/**
	 * AnimeMainNaagatakeをレコードに更新する
	 *
	 * @param AnimeNagatakeInputForm form
	 * @return AnimeMainNagatake
	 * */
	AnimeMainNagatake updateAnime(final AnimeNagatakeInputForm form);

	/**
	 * AnimeMainNagatakeのレコードを論理削除する
	 *
	 * @param long id
	 * */
	void deleteAnimeById(final long id);

	/**
	 * AnimeMainNagatakeのレコードを物理削除する
	 *
	 * @param ArrayList<Long>ids
	 * */
	void deleteAnimeComp(final ArrayList<Long> ids);
}