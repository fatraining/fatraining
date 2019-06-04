package jp.co.futureantiques.webapptraining.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.ClassTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.CountryTiba;
import jp.co.futureantiques.webapptraining.model.form.championTiba.ChampionTibaSearchForm;
import jp.co.futureantiques.webapptraining.repository.championTiba.ChampionMainTibaRepository;
import jp.co.futureantiques.webapptraining.repository.championTiba.ClassTibaRepository;
import jp.co.futureantiques.webapptraining.repository.championTiba.CountryTibaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ChampionTibaSpecification;
import jp.co.futureantiques.webapptraining.service.ChampionTibaService;

/** ChampionTibaのサービス実装クラス */

@Service
public class ChampionTibaServiceImpl implements ChampionTibaService {

	/** ChampionMaiリポジトリ */
	private final ChampionMainTibaRepository championMainTibaRepository;

	/** Classリポジトリ */
	private final ClassTibaRepository classTibaRepository;

	/** Countryリポジトリ */
	private final CountryTibaRepository countryTibaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param ChampionMainTibaRepository championMainTibaRepository
	 * @param ClassRepository leagueRepository
	 * @param CountryRepository districtRepository
	 */
	@Autowired
	public ChampionTibaServiceImpl(ChampionMainTibaRepository championMainTibaRepository,
			ClassTibaRepository classTibaRepository,
			CountryTibaRepository countryTibaRepository) {
		this.championMainTibaRepository = championMainTibaRepository;
		this.classTibaRepository = classTibaRepository;
		this.countryTibaRepository = countryTibaRepository;
	}

	@Override
	public List<ClassTiba> getListClass() {

		// ClassテーブルのレコードをID順に取得する
		return classTibaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<CountryTiba> getListCountry() {

		// CountryテーブルのレコードをID順に取得する
		return countryTibaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}


	@Override
	public Page<ChampionMainTiba> getPageChampion(final ChampionTibaSearchForm form, final Pageable pageable) {

		// 検索条件を生成しChampionMainTibaテーブルのレコードを取得する
		return championMainTibaRepository.findAll(ChampionTibaSpecification.generateChampionSpecification(form), pageable);
	}

	@Override
	public List<ChampionMainTiba> getListChampion(final ChampionTibaSearchForm form) {

		// ChampionMainTibaテーブルを主キー検索する
		return championMainTibaRepository.findAll(ChampionTibaSpecification.generateChampionSpecification(form));
	}

	//未作成↓(削除フラグの更新部分のみ作成済み)
	/**
	@Override
	public ChampionMainTiba getChampion(final long id) {
		return championMainTibaRepository.findOne(id);
	}
	Override
	public ChampionMainTiba updateChampion(final ChampionTibaInputForm form) {
		ChampionMainTiba championMainTiba = championMainTibaRepository.findOne((long) form.getId());
		if (championMainTiba != null) {
			if (form.getUpdateDate().equals(String.valueOf(championMainTiba.getUpdateDate()))) {
				championMainTiba = form.convertToChampionMainTibaForUpdate(championMainTiba);
				if (form.getPhoto().isEmpty()) {

					return championMainTibaRepository.saveAndFlush(championMainTiba);
				}
				ファイルをアップロードする
				uploadFile(championMainTiba, form.getPhoto());
				return championMainTibaRepository.saveAndFlush(championMainTiba);
			}
		}
		return null;
	}
    */
	//未作成↑

	@Override
	public void deleteChampionById(final long id) {

		// 更新対象のレコードを取得する
		ChampionMainTiba championMainTiba = championMainTibaRepository.findOne(id);
		if (championMainTiba != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			championMainTibaRepository.delete(id);
		}
	}

	@Override
	public ChampionMainTiba getChampion(long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	//未作成↓
	/**
	@Override
	public void deleteChampionComp(final ArrayList<Long> ids) {
		championMainTibaRepository.deleteComp(ids);
	}
	*/
}
