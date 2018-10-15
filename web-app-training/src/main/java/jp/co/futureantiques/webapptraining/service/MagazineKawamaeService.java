package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.magazineKawamae.MagazineKawamaeInputForm;
import jp.co.futureantiques.webapptraining.model.form.magazineKawamae.MagazineKawamaeSearchForm;
import jp.co.futureantiques.webapptraining.model.magazinekawamae.MagazineGenreKawamae;
import jp.co.futureantiques.webapptraining.model.magazinekawamae.MagazineMainKawamae;

/**
 * Magazineのサービスインターフェース
 *
 * @author wataru kawamae
 */
public interface MagazineKawamaeService {
	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return MagazineGenreEntityのリスト
	 */
	List<MagazineGenreKawamae> getListMagazineGenre();


	/**
	 * 検索条件を元にMagazineMainのレコードのリストを取得する(Paging)
	 *
	 * @param MagazineKawamaeSearchForm form
	 * @param Pageable pageable
	 * @return MagazineMainKawamaeのリスト
	 */
	Page<MagazineMainKawamae> getPageMagazine(final MagazineKawamaeSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にMagazineMainのレコードのリストを取得する
	 *
	 * @param MagazineKawamaeSearchForm form
	 * @return MagazineMainKawamaeのリスト
	 */
	List<MagazineMainKawamae> getListMagazine(final MagazineKawamaeSearchForm form);

	/**
	 * IDをキーにMagazineMainKawamaeのレコードを取得する
	 *
	 * @param long id
	 * @return MagazineMainKawamaeのレコード
	 */
	MagazineMainKawamae getMagazine(final long id);

	/**
	 * MagazineMainにレコードを新規登録する
	 *
	 * @param MagazineKawamaeInputForm form
	 * @return MagazineMainKawamae
	 */
	MagazineMainKawamae insertMagazine(final MagazineKawamaeInputForm form);

	/**
	 * MagazineMainのレコードを更新する
	 *
	 * @param MagazineKawamaeInputForm form
	 * @return MagazineMainKawamae
	 */
	MagazineMainKawamae updateMagazine(final MagazineKawamaeInputForm form);

	/**
	 * MagazineMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteMagazineById(final long id);

	/**
	 * MagazineMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteMagazineComp(final ArrayList<Long> ids);
}
