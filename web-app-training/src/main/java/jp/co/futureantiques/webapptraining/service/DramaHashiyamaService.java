package jp.co.futureantiques.webapptraining.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.dramaHashiyama.ChannelHashiyama;
import jp.co.futureantiques.webapptraining.model.dramaHashiyama.DramaActorHashiyama;
import jp.co.futureantiques.webapptraining.model.dramaHashiyama.DramaMainHashiyama;
import jp.co.futureantiques.webapptraining.model.form.dramaHashiyama.DramaInputForm;
import jp.co.futureantiques.webapptraining.model.form.dramaHashiyama.DramaSearchForm;


/**
 * DramaHashiyamaのサービスインターフェース
 *
 * @author hashiyama
 */

public interface DramaHashiyamaService {

	/**
	 * 主演俳優エンティティのリストを取得する
	 *
	 * @return ActorHashiyamaEntityのリスト
	 */
	List<DramaActorHashiyama> getListDramaActorHashiyama();

	/**
	 * テレビ局エンティティのリストを取得する
	 *
	 * @return ChannelHashiyamaEntityのリスト
	 */
	List<ChannelHashiyama> getListChannelHashiyama();

	/**
	 * 検索条件を元にDramaMainHashiyamaのレコードのリストを取得する(Paging)
	 *
	 * @param dramaSearchForm form
	 * @param Pageable pageable
	 * @return DramaMainHashiyamaのリスト
	 */
	Page<DramaMainHashiyama> getPageDrama(final DramaSearchForm form, final java.awt.print.Pageable pageable);

	/**
	 * 検索条件を元にDramaMainHashiyamaのレコードのリストを取得する
	 *
	 * @param DramaSearchForm form
	 * @return DramaMainHashiyamaのリスト
	 */
	List<DramaMainHashiyama> getListDrama(final DramaSearchForm form);


	/**
	 * IDをキーにDramaMainHashiyamaのレコードを取得する
	 *
	 * @param long idol_id
	 * @return DramaMainHashiyamaのレコード
	 */
	DramaMainHashiyama getDrama(final long id);

	/**
	 * DramaMainHashiyamaにレコードを新規登録する
	 *
	 * @param DramaInputForm form
	 * @return DramaMainHashiyama
	 */
	DramaMainHashiyama insertDrama(final DramaInputForm form);

	/**
	 * DramaMainHashiyamaのレコードを更新する
	 *
	 * @param DramaInputForm form
	 * @return DramaMainHashiyama
	 */
	DramaMainHashiyama updateDrama(final DramaInputForm form);

	/**
	 * DramaMainHashiyamaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteDramaById(final long id);

	/**
	 * DramaMainHashiyamaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteDramaComp(final ArrayList<Long> ids);

	Page<DramaMainHashiyama> getPageDrama(DramaSearchForm form, Pageable pageable);

}

