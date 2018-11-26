package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei.MusicalCompositionInputForm;
import jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei.MusicalCompositionSearchMainForm;
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
	 * @return AlbumTakeEntityのリスト
	 */
	List<AlbumTakei> getListAlbumTakei();

	/**
	 * 検索条件を元にMusicalCompositionMainTakeiのレコードのリストを取得する(Paging)
	 *
	 * @param MusicalCompositionSearchMainForm form
	 * @return MusicalCompositionMainTakeiのリスト
	 */
	Page<MusicalCompositionMainTakei> getPageMusicalComposition(final MusicalCompositionSearchMainForm form,
			final Pageable pageable);

	/**
	 * 検索条件を元にMusicalCompositionMainTakeiのレコードのリストを取得する
	 *
	 * @param MusicalCompositionSearchMainForm form
	 * @return MusicalCompositionMainTakeiのリスト
	 */
	List<MusicalCompositionMainTakei> getListMusicalComposition(MusicalCompositionSearchMainForm form);

	/**
	 * IDをキーにMusicalCompositionMainTakeiのレコードを取得する
	 *
	 * @param long id
	 * @return MusicalCompositionMainTakeiのレコード
	 */
	MusicalCompositionMainTakei getMusicalComposition(final long id);

	/**
	 * MusicalCompositionMainTakeiにレコードを新規登録する
	 *
	 * @param MusicalCompositionInputForm form
	 * @return MusicalCompositionMainTakei
	 */
	MusicalCompositionMainTakei insertMusicalComposition(final MusicalCompositionInputForm form);

	/**
	 * MusicalCompositionMainTakeiのレコードを更新する
	 *
	 * @param MusicalCompositionInputForm form
	 * @return MusicalCompositionMainTakei
	 */
	MusicalCompositionMainTakei updateMusicalComposition(final MusicalCompositionInputForm form);

	/**
	 * MusicalCompositionMainTakeiのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteMusicalCompositionById(final long id);

	/**
	 * MusicalCompositionMainTakeiのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteMusicalCompositionComp(final ArrayList<Long> ids);
}
