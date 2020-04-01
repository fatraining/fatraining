package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.bandIto.AreaIto;
import jp.co.futureantiques.webapptraining.model.bandIto.BandMainIto;
import jp.co.futureantiques.webapptraining.model.bandIto.SexIto;
import jp.co.futureantiques.webapptraining.model.form.bandIto.BandItoSearchForm;

/**
 * BandItoのサービスインターフェース
 *
 * @author future
 */
public interface BandItoService {

	/**
	 * ボーカル性別エンティティのリストを取得する
	 *
	 * @return SexItoEntityのリスト
	 */
	List<SexIto> getListSex();

	/**
	 * 出身地エンティティのリストを取得する
	 *
	 * @return AreaItoEntityのリスト
	 */
	List<AreaIto> getListArea();

	/**
	 * 検索条件を元にBandMainItoのレコードのリストを取得する(Paging)
	 *
	 * @param BandItoSearchForm form
	 * @param Pageable pageable
	 * @return BandMainItoのリスト
	 */
	Page<BandMainIto> getPageBand(final BandItoSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にBandMainItoのレコードのリストを取得する
	 *
	 * @param BandItoSearchForm form
	 * @return BandMainItoのリスト
	 */
	List<BandMainIto> getListBand(final BandItoSearchForm form);

	/**
	 * IDをキーにBandMainItoのレコードを取得する
	 *
	 * @param long id
	 * @return BandMainItoのレコード
	 */
	BandMainIto getBand(final long id);
	/*
		/**
		 * BandMainItoにレコードを新規登録する
		 *
		 * @param BandItoInputForm form
		 * @return BandMainIto

		BandMainIto insertBand(final BandItoInputForm form);

		/**
		 * BandItoのレコードを更新する
		 *
		 * @param BandIto form
		 * @return BandMainIto

		BandMainIto update(final BandItoInputForm form);

	*/

	/**
	 * BandMMainItoのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteBandById(final long id);

	/**
	 * BandMainItoIのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteBandComp(final ArrayList<Long> ids);

}
