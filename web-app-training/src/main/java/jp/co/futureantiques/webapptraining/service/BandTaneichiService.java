package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.bandTaneichi.BandMainTaneichi;
import jp.co.futureantiques.webapptraining.model.bandTaneichi.BandSexTaneichi;
import jp.co.futureantiques.webapptraining.model.bandTaneichi.GenreTaneichi;
import jp.co.futureantiques.webapptraining.model.form.bandTaneichi.BandTaneichiInputForm;
import jp.co.futureantiques.webapptraining.model.form.bandTaneichi.BandTaneichiSearchForm;

/**
 * BandTaneichiのサービスインターフェース
 * @author future
 *
 */
public interface BandTaneichiService {

	/**
	 * ボーカル性別エンティティのリストを取得
	 * @return BandSexTaneichiEntityのリスト
	 */
	List<BandSexTaneichi> getListBandSex();

	/**
	 * ジャンルのエンティティのリストを取得
	 * @return GenreTaneichiEntityのリスト
	 */
	List<GenreTaneichi> getListGenre();

	/**
	 * 検索条件をもとにBandMainTaneichiのレコードのリストを取得（paging)
	 *
	 * @param BandTaneichiSearchForm form
	 * @param Pageble pageble
	 * @return BandMainTaneichiのリスト
	 */
	Page<BandMainTaneichi> getPageBand(final BandTaneichiSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にBandMainTaneichiのレコードのリストを取得する
	 *
	 * @param BandTaneichiSearchForm form
	 * @return BandMainTaneichiのリスト
	 */
	List<BandMainTaneichi> getListBand(final BandTaneichiSearchForm form);

	/**
	 * IDをキーにBandMainTaneichiのレコードを取得する
	 *
	 * @param long id
	 * @return BandMainのレコード
	 */
	BandMainTaneichi getBand(final long id);

	/**
	 * BandMainTaneichiにレコードを新規登録する
	 *
	 * @param BandTaneichiInputForm form
	 * @return BandMainTaneichi
	 */
	BandMainTaneichi insertBand(final BandTaneichiInputForm form);

	/**
	 * BandMainのレコードを更新する
	 *
	 * @param BandTaneichiInputForm form
	 * @return BandMainTaneichi
	 */
	BandMainTaneichi updateBand(final BandTaneichiInputForm form);

	/**
	 * BandMainTaneichiのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteBandById(final long id);

	/**
	 * BandMainTaneichiのレコードを物理削除する
	 *
	 * @param ArrayList<Long>ids
	 */
	void deleteBandComp(final ArrayList<Long> ids);

}
