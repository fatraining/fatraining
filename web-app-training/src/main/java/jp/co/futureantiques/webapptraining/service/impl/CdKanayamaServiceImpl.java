package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.cdKanayama.CdMainKanayama;
import jp.co.futureantiques.webapptraining.model.cdKanayama.GenreKanayama;
import jp.co.futureantiques.webapptraining.model.form.cdKanayama.CdKanayamaInputForm;
import jp.co.futureantiques.webapptraining.model.form.cdKanayama.CdKanayamaSearchForm;
import jp.co.futureantiques.webapptraining.repository.cdKanayama.CdMainKanayamaRepository;
import jp.co.futureantiques.webapptraining.repository.cdKanayama.GenreKanayamaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.CdKanayamaSpecification;
import jp.co.futureantiques.webapptraining.service.CdKanayamaService;

/**
 * CdKanayamaのサービス実装クラス
 *
 * @author future
 */
@Service

public class CdKanayamaServiceImpl implements  CdKanayamaService{

	/** MovieMainリポジトリ */
	private final CdMainKanayamaRepository cdMainRepository;

	/** Genreリポジトリ */
	private final GenreKanayamaRepository genreRepository;

	/**
	 * コンストラクタ
	 *
	 * @param CdMainKanayamaRepository cdMainRepository
	 * @param GenreKanayamaRepository genreRepository
	 */
	@Autowired

	public CdKanayamaServiceImpl(CdMainKanayamaRepository cdMainRepository, GenreKanayamaRepository genreRepository) {
		this.cdMainRepository = cdMainRepository;
		this.genreRepository = genreRepository;
	}

	@Override
	public List<GenreKanayama> getListGenreKanayama() {

		// GenreテーブルのレコードをID順に取得する
		return genreRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public Page<CdMainKanayama> getPageCd(final CdKanayamaSearchForm form, final Pageable pageable) {
		// 検索条件を生成しMovieMainテーブルのレコードを取得する
		return cdMainRepository.findAll(CdKanayamaSpecification.generateCdSpecification(form), pageable);
	}

	@Override
	public List<CdMainKanayama> getListCd(final CdKanayamaSearchForm form) {

		// 検索条件を生成しMovieMainテーブルのレコードを取得する
		return cdMainRepository.findAll(CdKanayamaSpecification.generateCdSpecification(form));
	}

	@Override
	public CdMainKanayama getCd(final long id) {

		// CdMainテーブルを主キー検索する
		return cdMainRepository.findOne(id);
	}

	@Override
	public CdMainKanayama insertCd(final CdKanayamaInputForm form) {

		// CdMainテーブルに新規でデータを登録する
		final CdMainKanayama cdMain = form.convertToCdMainKanayamaForInsert();
		return cdMainRepository.save(cdMain);
	}

	@Override
	public CdMainKanayama updateCd(final CdKanayamaInputForm form) {

		// 更新対象のレコードを取得する
		CdMainKanayama cdMain = cdMainRepository.findOne((long) form.getId());
		if (cdMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(cdMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				cdMain = form.convertToCdMainForUpdate(cdMain);
				return cdMainRepository.saveAndFlush(cdMain);
			}
		}
		return null;
	}

	@Override
	public void deleteCdById(final long id) {

		// 更新対象のレコードを取得する
		CdMainKanayama cdMain = cdMainRepository.findOne(id);
		if (cdMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			cdMainRepository.delete(id);
		}
	}

	@Override
	public void deleteCdComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		cdMainRepository.deleteComp(ids);
	}

}
