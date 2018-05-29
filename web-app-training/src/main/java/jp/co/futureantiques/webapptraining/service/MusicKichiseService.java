package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.musickichise.MusicKichiseSearchForm;
import jp.co.futureantiques.webapptraining.model.musickichise.Artist;
import jp.co.futureantiques.webapptraining.model.musickichise.Janru;
import jp.co.futureantiques.webapptraining.model.musickichise.MusicKichiseMain;

/**
 * MusicKichiseServiceImplのインターフェース
 * @author future
 */
public interface MusicKichiseService {

	/**
	 * ジャンルエンティティのリストを取得する
	 * @return
	 */
	List<Janru> getListJanru();

	/**
	 * アーティストエンティティのリストを取得する
	 * @return
	 */
	List<Artist> getListArtist();

	/**
	 * 検索条件を元にMusicKichiseMainのレコードのリストを取得
	 * @param form
	 * @param pageable
	 * @return
	 */
	Page<MusicKichiseMain> getPageMusic(final MusicKichiseSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にMusicKichiseMainのレコードのリストを取得
	 * @param form
	 * @return
	 */
	List<MusicKichiseMain> getListMusic(MusicKichiseSearchForm form);

	/**
	 * IDをキーにMusicKichiseMainのレコードを取得する
	 * @param id
	 * @return
	 */
	MusicKichiseMain getMusic(final long id);
}
