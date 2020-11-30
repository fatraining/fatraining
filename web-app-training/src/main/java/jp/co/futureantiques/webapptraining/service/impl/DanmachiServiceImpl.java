package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.danmachi.Danmachi;
import jp.co.futureantiques.webapptraining.model.danmachi.Fami;
import jp.co.futureantiques.webapptraining.model.danmachi.Race;
import jp.co.futureantiques.webapptraining.model.form.danmachiWang.DanmachiInputForm;
import jp.co.futureantiques.webapptraining.model.form.danmachiWang.DanmachiSearchForm;
import jp.co.futureantiques.webapptraining.repository.Danmachi.DanmachiRepository;
import jp.co.futureantiques.webapptraining.repository.Danmachi.FamiRepository;
import jp.co.futureantiques.webapptraining.repository.Danmachi.RaceRepository;
import jp.co.futureantiques.webapptraining.repository.specification.DanmachiSpecification;
import jp.co.futureantiques.webapptraining.service.DanmachiService;

/**
 *Danmachiのサービス実装クラス
 *
 * @author Wang
 */
@Service
public class DanmachiServiceImpl implements DanmachiService{

	/**AlcoholMainIshidaリポジトリ*/
	private final DanmachiRepository danmachiRepository;

	/**Ingredientリポジトリ*/
	private final FamiRepository famiRepository;

	/**Liqueurリポジトリ*/
	private final RaceRepository raceRepository;

	/**
	 * コンストラクタ
	 *
	 * @param DanmachiRepository danmachiRepository
	 * @param FamiRepository famiRepository
	 * @param RaceRepository raceRepository
	 */

	@Autowired
	public DanmachiServiceImpl(DanmachiRepository danmachiRepository,
			FamiRepository famiRepository, RaceRepository raceRepository) {
		this.danmachiRepository = danmachiRepository;
		this.famiRepository = famiRepository;
		this.raceRepository = raceRepository;
	}

	@Override
	public List<Fami> getListFami() {

		//FamiテーブルをID順に取得する
		return famiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<Race> getListRace() {

		//RaceテーブルをID順に取得する
		return raceRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<Danmachi> getPageDanmachi(final DanmachiSearchForm form, Pageable pageable) {

		//検索条件を生成しDanmachiテーブルのレコードを取得する
		return danmachiRepository.findAll(DanmachiSpecification.generateDanmachiSpecification(form),
				pageable);
	}

	@Override
	public List<Danmachi> getListDanmachi(final DanmachiSearchForm form) {

		//検索条件を生成しDanmachiテーブルのレコードを取得する
		return danmachiRepository
				.findAll(DanmachiSpecification.generateDanmachiSpecification(form));
	}

	@Override
	public Danmachi getDanmachi(final long id) {

		//Danmachiテーブルを主キー検索する
		return danmachiRepository.findOne(id);
	}

	@Override
	public Danmachi insertDanmachi(final DanmachiInputForm form) {

		//Danmachiテーブルに新規でデータを登録する
		final Danmachi d = form.convertToDanmachiForInsert();
		return danmachiRepository.save(d);
	}

	@Override
	public Danmachi updateDanmachi(final DanmachiInputForm form) {

		//更新対象のレコードを取得する
		Danmachi d = danmachiRepository.findOne((long) form.getId());
		if (d != null) {

			//削除フラグが１だったとき
			if (Integer.parseInt(d.getDelFlg()) == 1) {
				return null;
			}
			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(d.getUpdateDate()))) {

				//チェックOKの場合
				d = form.convertToDanmachiForUpdate(d);

				//更新を実行
				return danmachiRepository.saveAndFlush(d);
			}
		}
		return null;
	}

	@Override
	public void deleteDanmachiById(final long id) {

		//更新対象のレコードを取得する
		Danmachi d = danmachiRepository.findOne(id);
		if (d != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			danmachiRepository.delete(id);
		}
	}

	@Override
	public void deleteDanmachiComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		danmachiRepository.deleteComp(ids);
	}
}
