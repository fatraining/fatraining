package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.heritageKataoka.HeritageInputForm;
import jp.co.futureantiques.webapptraining.model.form.heritageKataoka.HeritageSearchForm;
import jp.co.futureantiques.webapptraining.model.heritagekataoka.GenreKataoka;
import jp.co.futureantiques.webapptraining.model.heritagekataoka.HeritageMainKataoka;
import jp.co.futureantiques.webapptraining.model.heritagekataoka.LocationKataoka;

/**
 * HeritageMainのサービスインターフェース
 *
 * @author MIKI KATAOKA
 *
 */

@Service
public interface HeritageKataokaService {



		/**
		 * ジャンルエンティティのリストを取得する
		 *
		 * @return Gernreエンティティのリスト
		 */
		List<GenreKataoka> getListGenre();


		/**
		 * 所在地のリストを取得する
		 *
		 * @return Locationエンティティのリスト
		 */
		List<LocationKataoka> getListLocation();


		/**
		 * 検索条件を元にHeritageMainのレコードリストを取得する(Paging)
		 *
		 * @param heritageSearchForm form
		 * @param Pageable pageable
		 * @return HeritageMainのリスト
		 */
		Page<HeritageMainKataoka> getPageHeritage(final HeritageSearchForm form, final Pageable pageable);

		/**
		 * 検索条件を元にheritageMainのレコードのリストを取得する
		 *
		 *@param heritageSearchForm form
		 *@return HeritageMainのレコード
		 */

		List<HeritageMainKataoka> getListHeritage(final HeritageSearchForm form);

		/**
		 * IDをキーにheritageMainのレコードを取得する
		 * @param id
		 * @return
		 */
		HeritageMainKataoka getHeritage(final long id);

		/**
		 * heritageMainにレコードを新規登録する
		 *
		 * @param HeritageInputForm form
		 * @return HeritageMain
		 */
		HeritageMainKataoka insertHeritage(final HeritageInputForm form);

		/**
		 * HeritageMainのレコードを更新する
		 *
		 * @param HeritageInputForm form
		 * @return HeritageMain
		 */
		HeritageMainKataoka updateHeritage(final HeritageInputForm form);

		/**
		 * HeritageMainのレコードを論理削除する
		 *
		 * @param long id
		 */
		void deleteHeritageById(final long id);

		/**
		 * HeritageMainのレコードを物理削除する
		 *
		 * @param ArrayList<long> ids
		 */
		void deleteHeritageComp(final ArrayList<Long> ids);

	}

