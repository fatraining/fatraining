package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.RuinsKurihara.AreaKurihara;
import jp.co.futureantiques.webapptraining.model.RuinsKurihara.GenreKurihara;
import jp.co.futureantiques.webapptraining.model.RuinsKurihara.RuinsMainKurihara;
import jp.co.futureantiques.webapptraining.model.form.RuinsKurihara.RuinsKuriharaInputForm;
import jp.co.futureantiques.webapptraining.model.form.RuinsKurihara.RuinsKuriharaSearchForm;
import jp.co.futureantiques.webapptraining.repository.ruinskurihara.AreaKuriharaRepository;
import jp.co.futureantiques.webapptraining.repository.ruinskurihara.GenreKuriharaRepository;
import jp.co.futureantiques.webapptraining.repository.ruinskurihara.RuinsMainKuriharaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.RuinsKuriharaSpecification;
import jp.co.futureantiques.webapptraining.service.RuinsKuriharaService;

/**
 * RuinsKuriharaのサービス実装クラス
 *
 * @author m.kurihara
 */
@Service
public class RuinsKuriharaServiceImpl implements RuinsKuriharaService {

	/** RuinsMainKuriharaリポジトリ */
	private final RuinsMainKuriharaRepository ruinsMainKuriharaRepository;

	/** GenreKuriharaリポジトリ */
	private final GenreKuriharaRepository genreKuriharaRepository;

	/** AreaKuriharaリポジトリ */
	private final AreaKuriharaRepository areaKuriharaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param RuinsMainKuriharaRepository ruinsMainKuriharaRepository
	 * @param GenreKuriharaRepository genreKuriharaRepository
	 * @param AreaKuriharaRepository areaKuriharaRepository
	 */
	@Autowired
	public RuinsKuriharaServiceImpl(RuinsMainKuriharaRepository ruinsMainKuriharaRepository, GenreKuriharaRepository genreKuriharaRepository,
			AreaKuriharaRepository areaKuriharaRepository) {
		this.ruinsMainKuriharaRepository = ruinsMainKuriharaRepository;
		this.genreKuriharaRepository = genreKuriharaRepository;
		this.areaKuriharaRepository = areaKuriharaRepository;
	}

	@Override
	public List<GenreKurihara> getListGenre() {

		// GenreテーブルのレコードをID順に取得する
		return genreKuriharaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<AreaKurihara> getListArea() {

		// AreaテーブルのレコードをID順に取得する
		return areaKuriharaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<RuinsMainKurihara> getPageRuins(final RuinsKuriharaSearchForm form, final Pageable pageable) {

		// 検索条件を生成しRuinsMainテーブルのレコードを取得する
		return ruinsMainKuriharaRepository.findAll(RuinsKuriharaSpecification.generateRuinsSpecification(form), pageable);
	}

	@Override
	public List<RuinsMainKurihara> getListRuins(final RuinsKuriharaSearchForm form) {

		// 検索条件を生成しRuinsMainテーブルのレコードを取得する
		return ruinsMainKuriharaRepository.findAll(RuinsKuriharaSpecification.generateRuinsSpecification(form));
	}

	@Override
	public RuinsMainKurihara getRuins(final long id) {

		// RuinsMainテーブルを主キー検索する
		return ruinsMainKuriharaRepository.findOne(id);
	}

	@Override
	public RuinsMainKurihara insertRuins(final RuinsKuriharaInputForm form) {

		// RuinsMainテーブルに新規でデータを登録する
		final RuinsMainKurihara ruinsMain = form.convertToRuinsMainForInsert();
		return ruinsMainKuriharaRepository.save(ruinsMain);
	}

	@Override
	public RuinsMainKurihara updateRuins(final RuinsKuriharaInputForm form) {

		// 更新対象のレコードを取得する
		RuinsMainKurihara ruinsMain = ruinsMainKuriharaRepository.findOne((long) form.getId());
		if (ruinsMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(ruinsMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				ruinsMain = form.convertToRuinsMainForUpdate(ruinsMain);
				return ruinsMainKuriharaRepository.saveAndFlush(ruinsMain);
			}
		}
		return null;
	}

	@Override
	public void deleteRuinsById(final long id) {

		// 更新対象のレコードを取得する
		RuinsMainKurihara ruinsMain = ruinsMainKuriharaRepository.findOne(id);
		if (ruinsMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			ruinsMainKuriharaRepository.delete(id);
		}
	}

	@Override
	public void deleteRuinsComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		ruinsMainKuriharaRepository.deleteComp(ids);
	}
}