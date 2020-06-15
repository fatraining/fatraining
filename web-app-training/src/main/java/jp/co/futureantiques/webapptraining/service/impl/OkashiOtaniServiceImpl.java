package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.okashiotani.OkashiOtaniInputForm;
import jp.co.futureantiques.webapptraining.model.form.okashiotani.OkashiOtaniSearchForm;
import jp.co.futureantiques.webapptraining.model.okashiotani.MakerOtani;
import jp.co.futureantiques.webapptraining.model.okashiotani.OkashiMainOtani;
import jp.co.futureantiques.webapptraining.model.okashiotani.TypeOtani;
import jp.co.futureantiques.webapptraining.repository.okashiotani.MakerRepository;
import jp.co.futureantiques.webapptraining.repository.okashiotani.OkashiMainRepository;
import jp.co.futureantiques.webapptraining.repository.okashiotani.TypeRepository;
import jp.co.futureantiques.webapptraining.repository.specification.OkashiOtaniSpecification;
import jp.co.futureantiques.webapptraining.service.OkashiOtaniService;

/**
 * OkashiOtaniのサービス実装クラス
 *
 * @author future
 */
@Service
public class OkashiOtaniServiceImpl implements OkashiOtaniService {


	/** OkashiMainリポジトリ */
	private final OkashiMainRepository okashiMainRepository;

	/** Typeリポジトリ */
	private final TypeRepository typeRepository;

	/** OkashiMakerリポジトリ */
	private final MakerRepository makerRepository;

	/**
	 * コンストラクタ
	 *
	 * @param OkashiMainRepository okashiMainRepository
	 * @param TypeRepository typeRepository
	 * @param OkashiMakerRepository okashiMakerRepository
	 */
	@Autowired
	public OkashiOtaniServiceImpl(OkashiMainRepository okashiMainRepository, TypeRepository typeRepository,
			MakerRepository makerRepository) {
		this.okashiMainRepository = okashiMainRepository;
		this.typeRepository = typeRepository;
		this.makerRepository = makerRepository;
	}

	@Override
	public List<TypeOtani> getListTypeOtani() {

		// TypeテーブルのレコードをID順に取得する
		return typeRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<MakerOtani> getListMakerOtani() {

		// OkashiMakerテーブルのレコードをID順に取得す
		return makerRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<OkashiMainOtani> getPageOkashiOtani(final OkashiOtaniSearchForm form, final Pageable pageable) {

		// 検索条件を生成しOkashiMainテーブルのレコードを取得する
		return okashiMainRepository.findAll(OkashiOtaniSpecification.generateOkashiOtaniSpecification(form), pageable);
	}

	@Override
	public List<OkashiMainOtani> getListOkashiOtani(final OkashiOtaniSearchForm form) {

		// 検索条件を生成しOkashiMainテーブルのレコードを取得する
		return okashiMainRepository.findAll(OkashiOtaniSpecification.generateOkashiOtaniSpecification(form));
	}

	@Override
	public OkashiMainOtani getOkashiOtani(final long id) {

		// OkashiMainテーブルを主キー検索する
		return okashiMainRepository.findOne(id);
	}

	@Override
	public OkashiMainOtani insertOkashiOtani(final OkashiOtaniInputForm form) {

		// OkashiMainテーブルに新規でデータを登録する
		final OkashiMainOtani okashiMainOtani = form.convertToOkashiMainForInsert();
		return okashiMainRepository.save(okashiMainOtani);
	}

	@Override
	public OkashiMainOtani updateOkashiOtani(final OkashiOtaniInputForm form) {

		// 更新対象のレコードを取得する
		OkashiMainOtani okashiMainOtani = okashiMainRepository.findOne((long) form.getId());
		if (okashiMainOtani != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(okashiMainOtani.getUpdateDate()))) {

				// チェックOKの場合、更新
				okashiMainOtani = form.convertToOkashiMainForUpdate(okashiMainOtani);
				return okashiMainRepository.saveAndFlush(okashiMainOtani);
			}
		}
		return null;
	}

	@Override
	public void deleteOkashiOtaniById(final long id) {

		// 更新対象のレコードを取得する
		OkashiMainOtani okashiMainOtani = okashiMainRepository.findOne(id);
		if (okashiMainOtani != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			okashiMainRepository.delete(id);
		}
	}

	@Override
	public void deleteOkashiOtaniComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		okashiMainRepository.deleteComp(ids);
	}
}


