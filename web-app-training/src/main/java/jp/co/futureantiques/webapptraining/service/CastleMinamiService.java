package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.castleMinami.CastleMainMinami;
import jp.co.futureantiques.webapptraining.model.castleMinami.PrefectureMinami;
import jp.co.futureantiques.webapptraining.model.castleMinami.TenshuMinami;
import jp.co.futureantiques.webapptraining.model.form.castleMinami.CastleSearchForm;

/**
 * Castleのサービスインターフェース
 *
 * @author Minami
 */
@Service
public interface CastleMinamiService {

	/**
	 * 所在地エンティティのリストを取得する
	 *
	 * @return PrefectureEntityのリスト
	 */
	List<PrefectureMinami> getListPrefectureMinami();

	/**
	 * 天守エンティティのリストを取得する
	 * @return TenshuEntityのリスト
	 */
	List<TenshuMinami> getListTenshuMinami();


	/**
	 * 検索条件を元にCastleMinamiのレコードのリストを取得する(Paging)
	 *
	 * @param CastleMinamiSearchForm form
	 * @param Pageable pageable
	 * @param CastleMainMinamiのリスト
	 */
	Page<CastleMainMinami> getPageCastle(final CastleSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にCastleMainMinamiのレコードのリストを取得する
	 *
	 * @param CastleSearchForm form
	 * @return CastleMainMinamiのリスト
	 */
	List<CastleMainMinami> getListCastle(final CastleSearchForm form);

	/**
	 * IDをキーにCastleMainMinamiのレコードを取得する
	 *
	 * @param long id
	 * @return CastleMainMinamiのレコード
	 */
	CastleMainMinami getCastle(final long id);

	/**
	 * CastleMainMinamiのレコードを論理削除する
	 * @param long id
	 */
	void deleteCastleById(final long id);
}
