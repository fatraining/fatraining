package jp.co.futureantiques.webapptraining.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.dramaHashiyama.ChannelHashiyama;
import jp.co.futureantiques.webapptraining.model.dramaHashiyama.DramaActorHashiyama;
import jp.co.futureantiques.webapptraining.model.dramaHashiyama.DramaMainHashiyama;
import jp.co.futureantiques.webapptraining.model.form.dramaHashiyama.DramaInputForm;
import jp.co.futureantiques.webapptraining.model.form.dramaHashiyama.DramaSearchForm;
import jp.co.futureantiques.webapptraining.repository.dramaHashiyama.ChannelHashiyamaRepository;
import jp.co.futureantiques.webapptraining.repository.dramaHashiyama.DramaActorHashiyamaRepository;
import jp.co.futureantiques.webapptraining.repository.dramaHashiyama.DramaMainHashiyamaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.DramaHashiyamaSpecification;
import jp.co.futureantiques.webapptraining.service.DramaHashiyamaService;


/**
 * DramaMainHashiyamaのサービス実装クラス
 *
 * @author hashiyama
 *
 */
@Service
public class DramaHashiyamaServiceImpl implements DramaHashiyamaService{

	/** DramaMainHashiyamaリポジトリ */
	private final DramaMainHashiyamaRepository dramaMainHashiyamaRepository;

	/** Actorレポジトリ */
	private final DramaActorHashiyamaRepository actorHashiyamaReposiory;

	/** Channelレポジトリ */
	private final ChannelHashiyamaRepository channelHashiyamaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param DramaMainHashiyamaRepository dramaMainHashiyamaReopository
	 * @param DramaActorHashiyamaRepository actorHashiyamaRepository
	 * @param ChannelHashiyamaRepository channelHashiyamaRepository
	 */

	@Autowired
	public DramaHashiyamaServiceImpl(DramaMainHashiyamaRepository dramaMainHashiyamaRepository,
			DramaActorHashiyamaRepository dramaactorHashiyamaRepository, ChannelHashiyamaRepository channelHashiyamaRepository) {
		this.dramaMainHashiyamaRepository = dramaMainHashiyamaRepository;
		this.actorHashiyamaReposiory = dramaactorHashiyamaRepository;
		this.channelHashiyamaRepository = channelHashiyamaRepository;
	}

	@Override
	public List<DramaActorHashiyama> getListDramaActorHashiyama(){

		//ActorテーブルのレコードをID順に取得する
		return actorHashiyamaReposiory.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<ChannelHashiyama> getListChannelHashiyama(){

		//ChannelテーブルのレコードをID順に取得する
		return channelHashiyamaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}


	@Override
	public Page<DramaMainHashiyama> getPageDrama(final DramaSearchForm form, final Pageable pageable) {

		//検索条件を生成しDramaMainHashiyamaテーブルのレコードを取得する
		return dramaMainHashiyamaRepository.findAll(DramaHashiyamaSpecification.generateDramaSpecification(form), pageable);
	}

	@Override
	public List<DramaMainHashiyama> getListDrama(final DramaSearchForm form) {

		//検索条件を生成しDramaMainHashiyamaテーブルのレコードを取得する
		return dramaMainHashiyamaRepository.findAll(DramaHashiyamaSpecification.generateDramaSpecification(form));
	}

	@Override
	public Page<DramaMainHashiyama> getPageDrama(DramaSearchForm form, java.awt.print.Pageable pageable) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public DramaMainHashiyama getDrama(long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public DramaMainHashiyama insertDrama(DramaInputForm form) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public DramaMainHashiyama updateDrama(DramaInputForm form) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void deleteDramaById(long id) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteDramaComp(ArrayList<Long> ids) {
		// TODO 自動生成されたメソッド・スタブ

	}

}





