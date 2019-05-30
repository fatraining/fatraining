package jp.co.futureantiques.webapptraining.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.mlbUezu.MLBTeamSearchForm;
import jp.co.futureantiques.webapptraining.model.mlbUezu.DistrictUezu;
import jp.co.futureantiques.webapptraining.model.mlbUezu.LeagueUezu;
import jp.co.futureantiques.webapptraining.model.mlbUezu.MlbMainUezu;
import jp.co.futureantiques.webapptraining.repository.mlbUezu.DistrictRepository;
import jp.co.futureantiques.webapptraining.repository.mlbUezu.LeagueRepository;
import jp.co.futureantiques.webapptraining.repository.mlbUezu.MLBMainUezuRepository;
import jp.co.futureantiques.webapptraining.repository.specification.MLBUezuSpecification;
import jp.co.futureantiques.webapptraining.service.MLBUezuService;

/** MLBUezuのサービス実装クラス */

@Service
public class MLBUezuServiceImpl implements MLBUezuService {

	/** MLBMainリポジトリ */
	private final MLBMainUezuRepository mlbMainUezuRepository;

	/** Leagueリポジトリ */
	private final LeagueRepository leagueRepository;

	/** Districtリポジトリ */
	private final DistrictRepository districtRepository;

	/**
	 * コンストラクタ
	 *
	 * @param MLBMainUezuRepository mlbMainUezuRepository
	 * @param LeagueRepository leagueRepository
	 * @param DistrictRepository districtRepository
	 */
	@Autowired
	public MLBUezuServiceImpl(MLBMainUezuRepository mlbMainUezuRepository, LeagueRepository leagueRepository,
			DistrictRepository districtRepository) {
		this.mlbMainUezuRepository = mlbMainUezuRepository;
		this.leagueRepository = leagueRepository;
		this.districtRepository = districtRepository;
	}

	@Override
	public List<LeagueUezu> getListLeague() {

		// LeagueテーブルのレコードをID順に取得する
		return leagueRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<DistrictUezu> getListDistrict() {

		// DistrictテーブルのレコードをID順に取得する
		return districtRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<MlbMainUezu> getPageMLB(final MLBTeamSearchForm form, final Pageable pageable) {

		// 検索条件を生成しMLBMainUezuテーブルのレコードを取得する
		return mlbMainUezuRepository.findAll(MLBUezuSpecification.generateMLBSpecification(form), pageable);
	}

	@Override
	public List<MlbMainUezu> getListMLB(final MLBTeamSearchForm form) {

		// 検索条件を生成しMLBMainUezuテーブルのレコードを取得する
		return mlbMainUezuRepository.findAll(MLBUezuSpecification.generateMLBSpecification(form));
	}

	@Override
	public MlbMainUezu getMLBMain(final long id) {

		// MLBMainUezuテーブルを主キー検索する
		return mlbMainUezuRepository.findOne(id);
	}

	//未作成↓(削除フラグの更新部分のみ作成済み)
	/**
	@Override
	public MLBMaiUezu insertMovie(final MovieSampleInputForm form) {

		// MovieMainテーブルに新規でデータを登録する
		final MLBMaiUezu movieMain = form.convertToMovieMainForInsert();
		return movieMainRepository.save(movieMain);
	}

	@Override
	public MLBMaiUezu updateMovie(final MovieSampleInputForm form) {

		// 更新対象のレコードを取得する
		MLBMaiUezu movieMain = movieMainRepository.findOne((long) form.getId());
		if (movieMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(movieMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				movieMain = form.convertToMovieMainForUpdate(movieMain);
				return movieMainRepository.saveAndFlush(movieMain);
			}
		}
		return null;
	}
	*/
	//未作成↑

	@Override
	public void deleteMlbById(final long id) {

		// 更新対象のレコードを取得する
		MlbMainUezu mlbMainUezu = mlbMainUezuRepository.findOne(id);
		if (mlbMainUezu != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			mlbMainUezuRepository.delete(id);
		}
	}

	//未作成↓
	/**
	@Override
	public void deleteMovieComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		movieMainRepository.deleteComp(ids);
	}
	*/
}