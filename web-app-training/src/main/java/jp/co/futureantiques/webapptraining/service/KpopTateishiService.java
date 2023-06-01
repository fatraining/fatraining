package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.kpoptateishi.KpopTateishiInputForm;
import jp.co.futureantiques.webapptraining.model.form.kpoptateishi.KpopTateishiSearchForm;
import jp.co.futureantiques.webapptraining.model.kpoptateishi.Idol;
import jp.co.futureantiques.webapptraining.model.kpoptateishi.KpopMain;
import jp.co.futureantiques.webapptraining.model.kpoptateishi.Office;

/**
 * KpopTateishiのサービスインターフェース
 *
 * @author future
 */
public interface KpopTateishiService {

	/**
	 * アイドルエンティティのリストを取得する
	 *
	 * @return IdolEntityのリスト
	 */
	List<Idol> getListIdol();

	/**
	 * 所属事務所エンティティのリストを取得する
	 *
	 * @return OfficeEntityのリスト
	 */
	List<Office> getListOffice();

	/**
	 * 検索条件を元にKpopMainのレコードのリストを取得する(Paging)
	 *
	 * @param KpopTateishiSearchForm form
	 * @param Pageable pageable
	 * @return KpopMainのリスト
	 */
	Page<KpopMain> getPageMusic(final KpopTateishiSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にKpopMainのレコードのリストを取得する
	 *
	 * @param KpopTateishiSearchForm form
	 * @return KpopMainのリスト
	 */
	List<KpopMain> getListMusic(final KpopTateishiSearchForm form);

	/**
	 * IDをキーにKpopMainのレコードを取得する
	 *
	 * @param long id
	 * @return KpopMainのレコード
	 */
	KpopMain getMusic(final long id);

	/**
	 * KpopMainにレコードを新規登録する
	 *
	 * @param KpopTateishiInputForm form
	 * @return KpopMain
	 */
	KpopMain insertMusic(final KpopTateishiInputForm form);

	/**
	 * KpopMainのレコードを更新する
	 *
	 * @param KpopTateishiInputForm form
	 * @return KpopMain
	 */
	KpopMain updateMusic(final KpopTateishiInputForm form);

	/**
	 * KpopMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteMusicById(final long id);

	/**
	 * KpopMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteMusicComp(final ArrayList<Long> ids);

	// 削除画面追加機能
	/**
	 * DramaMainIgeのレコードの削除フラグを0に戻す
	 *
	 * @param long id
	 */
	void restoreById(final long id);
}
