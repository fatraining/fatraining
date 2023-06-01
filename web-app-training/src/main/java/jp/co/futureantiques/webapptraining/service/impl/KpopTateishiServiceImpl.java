package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.kpoptateishi.KpopTateishiInputForm;
import jp.co.futureantiques.webapptraining.model.form.kpoptateishi.KpopTateishiSearchForm;
import jp.co.futureantiques.webapptraining.model.kpoptateishi.Idol;
import jp.co.futureantiques.webapptraining.model.kpoptateishi.KpopMain;
import jp.co.futureantiques.webapptraining.model.kpoptateishi.Office;
import jp.co.futureantiques.webapptraining.repository.kpoptateishi.IdolRepository;
import jp.co.futureantiques.webapptraining.repository.kpoptateishi.KpopMainRepository;
import jp.co.futureantiques.webapptraining.repository.kpoptateishi.OfficeRepository;
import jp.co.futureantiques.webapptraining.repository.specification.KpopTateishiSpecification;
import jp.co.futureantiques.webapptraining.service.KpopTateishiService;

/**
 * KpopTateishiのサービス実装クラス
 *
 * @author future
 */
@Service
public class KpopTateishiServiceImpl implements KpopTateishiService {

	/** KpopMainリポジトリ */
	private final KpopMainRepository kpopMainRepository;

	/** Idolリポジトリ */
	private final IdolRepository idolRepository;

	/** Officeリポジトリ */
	private final OfficeRepository officeRepository;

	/**
	 * コンストラクタ
	 *
	 * @param KpopMainRepository kpopMainRepository
	 * @param IdolRepository idolRepository
	 * @param OfficeRepository officeRepository
	 */
	@Autowired
	public KpopTateishiServiceImpl(KpopMainRepository kpopMainRepository, IdolRepository idolRepository,
			OfficeRepository officeRepository) {
		this.kpopMainRepository = kpopMainRepository;
		this.idolRepository = idolRepository;
		this.officeRepository = officeRepository;
	}

	@Override
	public List<Idol> getListIdol() {

		// IdolテーブルのレコードをID順に取得する
		return idolRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<Office> getListOffice() {

		// OfficeテーブルのレコードをID順に取得する
		return officeRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<KpopMain> getPageMusic(final KpopTateishiSearchForm form, final Pageable pageable) {

		// 検索条件を生成しKpopMainテーブルのレコードを取得する
		return kpopMainRepository.findAll(KpopTateishiSpecification.generateKpopSpecification(form), pageable);
	}

	@Override
	public List<KpopMain> getListMusic(final KpopTateishiSearchForm form) {

		// 検索条件を生成しKpopMainテーブルのレコードを取得する
		return kpopMainRepository.findAll(KpopTateishiSpecification.generateKpopSpecification(form));
	}

	@Override
	public KpopMain getMusic(final long id) {

		// KpopMainテーブルを主キー検索する
		return kpopMainRepository.findOne(id);
	}

	@Override
	public KpopMain insertMusic(final KpopTateishiInputForm form) {

		// KpopMainテーブルに新規でデータを登録する
		final KpopMain kpopMain = form.convertToKpopMainForInsert();
		return kpopMainRepository.save(kpopMain);
	}

	@Override
	public KpopMain updateMusic(final KpopTateishiInputForm form) {

		// 更新対象のレコードを取得する
		KpopMain kpopMain = kpopMainRepository.findOne((long) form.getId());
		if (kpopMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(kpopMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				kpopMain = form.convertToKpopMainForUpdate(kpopMain);
				return kpopMainRepository.saveAndFlush(kpopMain);
			}
		}
		return null;
	}

	@Override
	public void deleteMusicById(final long id) {

		// 更新対象のレコードを取得する
		KpopMain kpopMain = kpopMainRepository.findOne(id);
		if (kpopMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			kpopMainRepository.delete(id);
		}
	}

	@Override
	public void deleteMusicComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		kpopMainRepository.deleteComp(ids);
	}

	@Override
	public void restoreById(long id) {

		// 対象のレコードを取得
		KpopMain kpopMain = kpopMainRepository.findOne(id);
		if(kpopMain !=null) {

			// 対象のレコードの削除フラグを0にする
			kpopMainRepository.restore(id);
		}
	}
}