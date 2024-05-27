package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.drama.CountryNakaniwa;
import com.example.demo.model.drama.DramaMainNakaniwa;
import com.example.demo.model.drama.GenreNakaniwa;
import com.example.demo.model.form.drama.DramaInputForm;
import com.example.demo.model.form.drama.DramaSearchForm;

/**
 * Dramaのサービスインターフェース
 */
public interface DramaService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreNakaniwaEntityのリスト
	 */
	List<GenreNakaniwa> getListGenreNakaniwa();

	/**
	 * 製作国エンティティのリストを取得する
	 *
	 * @return CountryNakaniwaEntityのリスト
	 */
	List<CountryNakaniwa> getListCountryNakaniwa();

	/**
	 * 検索条件を元にDramaMainNakaniwaのレコードのリストを取得する(Paging)
	 *
	 * @param DramaSearchForm form
	 * @param Pageable pageable
	 * @return DramaMainNakaniwaのリスト
	 */
	Page<DramaMainNakaniwa> getPageDrama(final DramaSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にDramaMainNakaniwaのレコードのリストを取得する
	 *
	 * @param DramaSearchForm form
	 * @return DramaMainNakaniwaのリスト
	 */
	List<DramaMainNakaniwa> getListDrama(final DramaSearchForm form);

	/**
	 * IDをキーにDramaMainNakaniwaのレコードを取得する
	 *
	 * @param long id
	 * @return DramaMainNakaniwaのレコード
	 */
	DramaMainNakaniwa getDrama(final long id);

	/**
	 * DramaMainNakaniwaにレコードを新規登録する
	 *
	 * @param DramaInputForm form
	 * @return DramaMainNakaniwa
	 */
	DramaMainNakaniwa insertDrama(final DramaInputForm form);

	/**
	 * DramaMainNakaniwaのレコードを更新する
	 *
	 * @param DramaInputForm form
	 * @return DramaMainNakaniwa
	 */
	DramaMainNakaniwa updateDrama(final DramaInputForm form);

	/**
	 * DramaMainNakaniwaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteDramaById(final long id);

	/**
	 * DramaMainNakaniwaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteDramaComp(final ArrayList<Long> ids);

}
