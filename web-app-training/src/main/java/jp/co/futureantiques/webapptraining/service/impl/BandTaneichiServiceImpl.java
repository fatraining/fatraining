package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.bandTaneichi.BandMainTaneichi;
import jp.co.futureantiques.webapptraining.model.bandTaneichi.BandSexTaneichi;
import jp.co.futureantiques.webapptraining.model.bandTaneichi.GenreTaneichi;
import jp.co.futureantiques.webapptraining.model.form.bandTaneichi.BandTaneichiInputForm;
import jp.co.futureantiques.webapptraining.model.form.bandTaneichi.BandTaneichiSearchForm;
import jp.co.futureantiques.webapptraining.repository.bandTaneichi.BandMainTaneichiRepository;
import jp.co.futureantiques.webapptraining.repository.bandTaneichi.BandSexTaneichiRepository;
import jp.co.futureantiques.webapptraining.repository.bandTaneichi.GenreTaneichiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.BandTaneichiSpecification;
import jp.co.futureantiques.webapptraining.service.BandTaneichiService;

/**
 * BandTaneichiのサービス実装クラス
 *
 * @author future
 *
 */
@Service
public class BandTaneichiServiceImpl implements BandTaneichiService {

	/** BandMainTaneichiのリポジトリ*/
	private final BandMainTaneichiRepository bandMainTaneichiRepository;

	/** BandSexTaneichiリポジトリ*/
	private final BandSexTaneichiRepository bandSexTaneichiRepository;

	/**GenreTaneichiのリポジトリ*/
	private final GenreTaneichiRepository genreTaneichiRepository;

	/**
	 * コンストラクタ
	 *
	 * @param BandMainTaneichiRepository bandMainTaneichiReposiory
	 * @param BandSexTaneichiRepository bandSexTaneichiRepository
	 * @param GenreTaneichiRepository bandTaneichiRepository
	 */
	@Autowired
	public BandTaneichiServiceImpl(BandMainTaneichiRepository bandMainTaneichiRepository,
			BandSexTaneichiRepository bandSexTaneichiRepository,
			GenreTaneichiRepository genreTaneichiRepository) {
		this.bandMainTaneichiRepository = bandMainTaneichiRepository;
		this.bandSexTaneichiRepository = bandSexTaneichiRepository;
		this.genreTaneichiRepository = genreTaneichiRepository;
	}

	@Override
	public List<BandSexTaneichi> getListBandSex() {

		// BandSexテーブルのレコードをID順に取得
		return bandSexTaneichiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<GenreTaneichi> getListGenre() {

		// GenreテーブルのレコードをID順に取得
		return genreTaneichiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<BandMainTaneichi> getPageBand(final BandTaneichiSearchForm form, final Pageable pageable) {

		// 検索条件を生成しBandMainTaneichiテーブルのレコードを取得
		return bandMainTaneichiRepository.findAll(BandTaneichiSpecification.generateBandSpecification(form), pageable);
	}

	@Override
	public List<BandMainTaneichi> getListBand(final BandTaneichiSearchForm form) {

		// 検索条件を生成しBandMainTaneichiテーブルのレコードを取得
		return bandMainTaneichiRepository.findAll(BandTaneichiSpecification.generateBandSpecification(form));
	}

	@Override
	public BandMainTaneichi getBand(final long id) {

		// BandMainTaneichiテーブルを主キー検索
		return bandMainTaneichiRepository.findOne(id);
	}

	@Override
	public BandMainTaneichi insertBand(final BandTaneichiInputForm form) {

		// BandMainTaneichiテーブルに新規でデータ登録
		final BandMainTaneichi bandMainTaneichi = form.convertToBandMainTaneichiForInsert();
		return bandMainTaneichiRepository.save(bandMainTaneichi);
	}

	@Override
	public BandMainTaneichi updateBand(final BandTaneichiInputForm form) {

		// 更新対象のレコードを取得する
		BandMainTaneichi bandMainTaneichi = bandMainTaneichiRepository.findOne((long) form.getId());
		if (bandMainTaneichi != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(bandMainTaneichi.getUpdateDate()))) {

				// チェックOKの場合、更新
				bandMainTaneichi = form.convertToBandMainTaneichiForUpdate(bandMainTaneichi);
				return bandMainTaneichiRepository.saveAndFlush(bandMainTaneichi);
			}
		}
		return null;
	}

	@Override
	public void deleteBandById(final long id) {

		//更新対象のレコードを取得
		BandMainTaneichi bandMainTaneichi = bandMainTaneichiRepository.findOne(id);
		if (bandMainTaneichi != null) {

			// 更新対象のレコードが存在する場合、削除フラグを１にする
			bandMainTaneichiRepository.delete(id);
		}
	}

	@Override
	public void deleteBandComp(final ArrayList<Long> ids) {

		// 対象レコードの削除
		bandMainTaneichiRepository.deleteComp(ids);
	}
}
