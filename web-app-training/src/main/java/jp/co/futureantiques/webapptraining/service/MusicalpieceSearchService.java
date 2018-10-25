package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.musicalpieceSearch.MusicalpieceSearchMainForm;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.AlbumRuike;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ArianaMainRuike;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ColaboRuike;

/**
 * MusicalpieceSearchのサービスインターフェース
 *
 * @author future
 */
public interface MusicalpieceSearchService {

	/**
	 * アルバムエンティティのリストを取得する
	 *
	 * @return AlbumRuikeのリスト
	 */

	List<AlbumRuike> getListAlbumRuike();

	/**
	 * コラボアーティストエンティティのリストを取得する
	 *
	 * @return ColaboRuikeEntityのリスト
	 */
	List<ColaboRuike> getListColaboRuike();

	/**
	 * 検索条件を元にArianaMainRuikeのレコードのリストを取得する(Paging)
	 *
	 * @param MusicalpieceSearchMainForm form
	 * @param Pageable pageable
	 * @return ArianaMainRuikeのリスト
	 */
	Page<ArianaMainRuike> getPageArianaMainRuike(final MusicalpieceSearchMainForm form, final Pageable pageable);

	/**
	 * 検索条件を元にArianaMainRuikeのレコードのリストを取得する
	 *
	 * @param MusicalpieceSearchMainForm form
	 * @return ArianaMainRuikeのリスト
	 */
	List<ArianaMainRuike> getListAriana(final MusicalpieceSearchMainForm form);

	/**
	 * IDをキーにArianaMainRuikeのレコードを取得する
	 *
	 * @param long single_Id
	 * @return ArianaMainRuikeのレコード
	 */
	ArianaMainRuike getAriana(final long single_Id);

}
