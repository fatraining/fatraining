package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.Eggsample.EggActor;
import jp.co.futureantiques.webapptraining.model.eggsekine.EggMain;
import jp.co.futureantiques.webapptraining.model.form.Eggsample.EggSampleInputForm;
import jp.co.futureantiques.webapptraining.model.form.Eggsample.EggSampleSearchForm;
import jp.co.futureantiques.webapptraining.repository.Eggsample.EggActorRepository;
import jp.co.futureantiques.webapptraining.repository.eggSekine.EggMainSekineRepository;
import jp.co.futureantiques.webapptraining.repository.moviesample.GenreRepository;
import jp.co.futureantiques.webapptraining.repository.specification.EggSampleSpecification;

/**
 * EggSampleのサービス実装クラス
 *
 * @author future
 */
@Service
public class EggSekineServiceImpl {

	/** EggMainリポジトリ */
	private final EggMainSekineRepository EggMainRepository;

	/** Genreリポジトリ */
	private final GenreRepository genreRepository;

	/** EggActorリポジトリ */
	private final EggActorRepository EggActorRepository;

	/**
	 * コンストラクタ
	 *
	 * @param EggMainSekineRepository EggMainRepository
	 * @param GenreSekineRepository genreRepository
	 * @param EggActorRepository EggActorRepository
	 */
	@Autowired
	public EggSampleServiceImpl(EggMainSekineRepository EggMainRepository, GenreRepository genreRepository,
			EggActorRepository EggActorRepository) {
		this.eggMainRepository = eggMainRepository;
		this.genreRepository = genreRepository;
		this.eggActorRepository = eggActorRepository;
	}

	@Override
	public List<Genre> getListGenre() {

		// GenreテーブルのレコードをID順に取得する
		return genreRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<EggActor> getListEggActor() {

		// EggActorテーブルのレコードをID順に取得する
		return eggActorRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<EggMain> getPageEgg(final EggSampleSearchForm form, final Pageable pageable) {

		// 検索条件を生成しEggMainテーブルのレコードを取得する
		return eggMainRepository.findAll(EggSampleSpecification.generateEggSpecification(form), pageable);
	}

	@Override
	public List<EggMain> getListEgg(final EggSampleSearchForm form) {

		// 検索条件を生成しEggMainテーブルのレコードを取得する
		return eggMainRepository.findAll(EggSampleSpecification.generateEggSpecification(form));
	}

	@Override
	public eggMain getEgg(final long id) {

		// EggMainテーブルを主キー検索する
		return eggMainRepository.findOne(id);
	}

	@Override
	public EggMain insertEgg(final EggSampleInputForm form) {

		// EggMainテーブルに新規でデータを登録する
		final EggMain EggMain = form.convertToEggMainForInsert();
		return EggMainRepository.save(EggMain);
	}

	@Override
	public EggMain updateEgg(final EggSampleInputForm form) {

		// 更新対象のレコードを取得する
		EggMain EggMain = EggMainRepository.findOne((long) form.getId());
		if (EggMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(EggMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				EggMain = form.convertToEggMainForUpdate(EggMain);
				return eggMainRepository.saveAndFlush(EggMain);
			}
		}
		return null;
	}

	@Override
	public void deleteEggById(final long id) {

		// 更新対象のレコードを取得する
		EggMain EggMain = eggMainRepository.findOne(id);
		if (EggMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			eggMainRepository.delete(id);
		}
	}

	@Override
	public void deleteEggComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		eggMainRepository.deleteComp(ids);
	}

}
