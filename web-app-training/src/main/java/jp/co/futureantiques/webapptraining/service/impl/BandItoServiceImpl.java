package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.bandIto.AreaIto;
import jp.co.futureantiques.webapptraining.model.bandIto.BandMainIto;
import jp.co.futureantiques.webapptraining.model.bandIto.SexIto;
import jp.co.futureantiques.webapptraining.model.form.bandIto.BandItoSearchForm;
import jp.co.futureantiques.webapptraining.repository.bandIto.AreaItoRepository;
import jp.co.futureantiques.webapptraining.repository.bandIto.BandMainItoRepository;
import jp.co.futureantiques.webapptraining.repository.bandIto.SexItoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.BandItoSpecification;
import jp.co.futureantiques.webapptraining.service.BandItoService;

/**
 * MovieSampleのサービス実装クラス
 *
 * @author future
 */
@Service
public class BandItoServiceImpl implements BandItoService {

	/** BandMainItoリポジトリ */
	private final BandMainItoRepository bandMainItoRepository;

	/** SexItoリポジトリ */
	private final SexItoRepository sexItoRepository;

	/** AreaItorリポジトリ */
	private final AreaItoRepository areaItoRepository;

	/**
	 * コンストラクタ
	 *
	 * @param BandMainItoRepository bandMainItoRepository
	 * @param SexItoRepository sexItoRepository
	 * @param AreaItoRepository areaItoRepository
	 */
	@Autowired
	public BandItoServiceImpl(BandMainItoRepository bandMainItoRepository, SexItoRepository sexItoRepository,
			AreaItoRepository areaItoRepository) {
		this.bandMainItoRepository = bandMainItoRepository;
		this.sexItoRepository = sexItoRepository;
		this.areaItoRepository = areaItoRepository;
	}

	@Override
	public List<SexIto> getListSex() {

		// SexテーブルのレコードをID順に取得する
		return sexItoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<AreaIto> getListArea() {

		// AreaItoテーブルのレコードをID順に取得する
		return areaItoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<BandMainIto> getPageBand(final BandItoSearchForm form, final Pageable pageable) {

		// 検索条件を生成しBandMainItoテーブルのレコードを取得する
		return bandMainItoRepository.findAll(BandItoSpecification.generateBandSpecification(form), pageable);
	}

	@Override
	public List<BandMainIto> getListBand(final BandItoSearchForm form) {

		// 検索条件を生成しBandMainItoテーブルのレコードを取得する
		return bandMainItoRepository.findAll(BandItoSpecification.generateBandSpecification(form));
	}

	@Override
	public BandMainIto getBand(final long id) {

		// BandMainItoテーブルを主キー検索する
		return bandMainItoRepository.findOne(id);
	}

	/*@Override
	public BandMainIto insertBand(final BandItoInputForm form) {

		// MovieMainテーブルに新規でデータを登録する
		final BandMainIto bandMainIto = form.convertToBandMainItoForInsert();
		return bandMainItoRepository.save(bandMainIto);
	}

	@Override
	public BandMainIto updateBand(final BandItoInputForm form) {

		// 更新対象のレコードを取得する
		BandMainIto bandMainIto = bandMainItoRepository.findOne((long) form.getId());
		if (bandMainIto != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(bandMainIto.getUpdateDate()))) {

				// チェックOKの場合、更新
				bandMainIto = form.convertToBandMainItoForUpdate(bandMainIto);
				return bandMainItoRepository.saveAndFlush(bandMainIto);
			}
		}
		return null;
	}
*/
	@Override
	public void deleteBandById(final long id) {

		// 更新対象のレコードを取得する
		BandMainIto bandMainIto = bandMainItoRepository.findOne(id);
		if (bandMainIto != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			bandMainItoRepository.delete(id);
		}
	}

	@Override
	public void deleteBandComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		bandMainItoRepository.deleteComp(ids);
	}

}
