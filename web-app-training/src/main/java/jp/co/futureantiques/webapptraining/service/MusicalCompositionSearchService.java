package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.from.musicalcomposition.takei.MusicalCompositionInputForm;
import jp.co.futureantiques.webapptraining.model.from.musicalcomposition.takei.MusicalCompositionSearchMainForm;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.AlbumTakei;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.GenreTakei;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.MusicalCompositionMainTakei;

/**
 * musicalcompositionのサービスインターフェース
 *
 * @author takei
 */
public interface MusicalCompositionSearchService {
	/**
	 * 楽曲genreエンティティのリストを取得する
	 *
	 * @return GenreTakeiEntityのリスト
	 */

	List<GenreTakei> getListGenreTakei();

	/**
	 * 楽曲アルバムエンティティのリストを取得する
	 *
	 * @return albumTakeEntityのリスト
	 */
	List<AlbumTakei> getListAlbumTakei();



	/**
	 * 検索条件を元にMusicalCompositionSearchMainのレコードのリストを取得する(Paging)
	 *
	 * @param MusicalCompositionSearchMainForm form
	 * @return MusicalCompositionSearchMainのリスト
	 */

	Page<MusicalCompositionMainTakei> getPageMusicalComposition
	                                   (final MusicalCompositionSearchMainForm form, final Pageable pageable);


	/**
	 * 検索条件を元にMusicalCompositionSearchMainのレコードのリストを取得する
	 *
	 * @param MusicalCompositionSearchMainForm form
	 * @return MusicalCompositionSearchMainのリスト
	 */

	List<MusicalCompositionMainTakei> getListMusicalComposition(MusicalCompositionSearchMainForm form);


	/**
	 * IDをキーにMusicalCompositionSearchMainのレコードを取得する
	 *
	 * @param long id
	 * @return MusicalCompositionSearchMainのレコード
	 */
	MusicalCompositionMainTakei getMusicalComposition(final long id);

	/**
	 * MusicalCompositionSearchMainにレコードを新規登録する
	 *
	 * @param MusicalCompositionInputForm form
	 * @return MusicalCompositionSearchMain
	 */

	MusicalCompositionMainTakei insertMusicalComposition
	                             (final MusicalCompositionInputForm form);

	/**
	 *MusicalCompositionSearchMainのレコードを更新する
	 *
	 * @param MusicalCompositionInputForm form
	 * @return MusicalCompositionSearchMain
	 */


	MusicalCompositionMainTakei updateMusicalComposition
	                             (final MusicalCompositionInputForm form);


	/**
	 * MusicalCompositionSearchMainのレコードを論理削除する
	 *
	 * @param long id
	 */

	void deleteMusicalCompositionById(final long id);

	/**
	 * MusicalCompositionSearchMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */

	void deleteMusicalCompositionComp(final  ArrayList<Long> ids);

}
