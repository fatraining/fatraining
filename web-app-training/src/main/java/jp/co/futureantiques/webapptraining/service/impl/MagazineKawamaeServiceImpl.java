package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.magazineKawamae.MagazineKawamaeInputForm;
import jp.co.futureantiques.webapptraining.model.form.magazineKawamae.MagazineKawamaeSearchForm;
import jp.co.futureantiques.webapptraining.model.magazinekawamae.MagazineGenreKawamae;
import jp.co.futureantiques.webapptraining.model.magazinekawamae.MagazineMainKawamae;
import jp.co.futureantiques.webapptraining.repository.magazinekawamae.MagazineGenreKawamaeRepository;
import jp.co.futureantiques.webapptraining.repository.magazinekawamae.MagazineMainKawamaeRepository;
import jp.co.futureantiques.webapptraining.repository.specification.MagazineKawamaeSpecification;
import jp.co.futureantiques.webapptraining.service.MagazineKawamaeService;


/**
 * Magazineのサービス実装クラス
 *
 * @author  wataru kawamae
 */
@Service
public class MagazineKawamaeServiceImpl implements MagazineKawamaeService {

	/** MagazineMainリポジトリ */
	private final MagazineMainKawamaeRepository magazineMainKawamaeRepository;

	/** Genreリポジトリ */
	private final MagazineGenreKawamaeRepository magazineGenreKawamaeRepository;

	/**
	 * コンストラクタ
	 *
	 * @param MagazineMainKawamaeRepository magazineMainRepository
	 * @param GenreRepository genreRepository
	 * @param MagazineActorRepository magazineActorRepository
	 */
	@Autowired
	public MagazineKawamaeServiceImpl(MagazineMainKawamaeRepository magazineMainRepository, MagazineGenreKawamaeRepository magazineGenreRepository) {
		this.magazineMainKawamaeRepository = magazineMainRepository;
		this.magazineGenreKawamaeRepository = magazineGenreRepository;
	}

	@Override
	public List<MagazineGenreKawamae> getListMagazineGenre() {

		// GenreテーブルのレコードをID順に取得する
		return magazineGenreKawamaeRepository.findAll(new Sort(Sort.Direction.ASC, "id"));

	}


	@Override
	public Page<MagazineMainKawamae> getPageMagazine(final MagazineKawamaeSearchForm form, final Pageable pageable) {

		// 検索条件を生成しMagazineMainテーブルのレコードを取得する
		return magazineMainKawamaeRepository.findAll(MagazineKawamaeSpecification.generateMagazineSpecification(form), pageable);
	}

	@Override
	public List<MagazineMainKawamae> getListMagazine(final MagazineKawamaeSearchForm form) {

		// 検索条件を生成しMagazineMainテーブルのレコードを取得する
		return magazineMainKawamaeRepository.findAll(MagazineKawamaeSpecification.generateMagazineSpecification(form));
	}

	@Override
	public MagazineMainKawamae getMagazine(final long id) {

		// MagazineMainテーブルを主キー検索する
		return magazineMainKawamaeRepository.findOne(id);
	}

	@Override
	public MagazineMainKawamae insertMagazine(final MagazineKawamaeInputForm form) {

		// MagazineMainテーブルに新規でデータを登録する
		final MagazineMainKawamae magazineMainKawamae = form.convertToMagazineMainForInsert();
		return magazineMainKawamaeRepository.save(magazineMainKawamae);
	}

	@Override
	public MagazineMainKawamae updateMagazine(final MagazineKawamaeInputForm form) {

		// 更新対象のレコードを取得する
		MagazineMainKawamae magazineMainKawamae = magazineMainKawamaeRepository.findOne((long) form.getId());
		if (magazineMainKawamae != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(magazineMainKawamae.getUpdateDate()))) {

				// チェックOKの場合、更新
				magazineMainKawamae = form.convertToMagazineMainForUpdate(magazineMainKawamae);
				return magazineMainKawamaeRepository.saveAndFlush(magazineMainKawamae);
			}
		}
		return null;
	}

	@Override
	public void deleteMagazineById(final long id) {

		// 更新対象のレコードを取得する
		MagazineMainKawamae magazineMainKawamae = magazineMainKawamaeRepository.findOne(id);
		if (magazineMainKawamae != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			magazineMainKawamaeRepository.delete(id);
		}
	}

	@Override
	public void deleteMagazineComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		magazineMainKawamaeRepository.deleteComp(ids);
	}
}