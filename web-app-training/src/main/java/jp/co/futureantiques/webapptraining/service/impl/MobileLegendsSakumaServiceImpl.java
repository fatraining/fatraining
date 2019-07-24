package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.mobileLegendsSakuma.MobileLegendsSakumaInputForm;
import jp.co.futureantiques.webapptraining.model.form.mobileLegendsSakuma.MobileLegendsSakumaSearchForm;
import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.FeatureSakuma;
import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.MobileLegendsMainSakuma;
import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.TypeSakuma;
import jp.co.futureantiques.webapptraining.repository.mobileLegendsSakuma.FeatureSakumaRepository;
import jp.co.futureantiques.webapptraining.repository.mobileLegendsSakuma.MobileLegendsMainSakumaRepository;
import jp.co.futureantiques.webapptraining.repository.mobileLegendsSakuma.TypeSakumaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.MobileLegendsSakumaSpecification;
import jp.co.futureantiques.webapptraining.service.MobileLegendsSakumaService;

/**MobileLegendsSakumaのサービス実装クラス*/

@Service
public class MobileLegendsSakumaServiceImpl implements MobileLegendsSakumaService {

	/**MobileLegendsMainSakumaのリポジトリ*/
	private final MobileLegendsMainSakumaRepository mobileLegendsMainSakumaRepository;

	/**TypeSakumaのリポジトリ*/
	private final TypeSakumaRepository typeSakumaRepository;

	/**FeatureSakumaのリポジトリ*/
	private final FeatureSakumaRepository featureSakumaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param MobileLegendsMainSakumaRepository mobileLegendsMainSakumaRepository
	 * @param TypeSakumaRepository typeSakuma
	 * @param FeatureSakumaRepository featureSakuma
	 */
	@Autowired
	public MobileLegendsSakumaServiceImpl(MobileLegendsMainSakumaRepository mobileLegendsMainSakumaRepository,
			TypeSakumaRepository typeSakumaRepository,
			FeatureSakumaRepository featureSakumaRepository) {
		this.mobileLegendsMainSakumaRepository = mobileLegendsMainSakumaRepository;
		this.typeSakumaRepository = typeSakumaRepository;
		this.featureSakumaRepository = featureSakumaRepository;
	}

	@Override
	public List<TypeSakuma> getListTypeSakuma() {

		//TypeテーブルのレコードをID順に取得
		return typeSakumaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));

	}

	@Override
	public List<FeatureSakuma> getListFeatureSakuma() {

		//FeatureテーブルのレコードをID順に取得
		return featureSakumaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));

	}

	@Override
	public Page<MobileLegendsMainSakuma> getPageMobileLegendsSakuma(final MobileLegendsSakumaSearchForm form,
			final Pageable pageable) {

		//検索条件を生成し、MobileLegendsMainSakumaのテーブルのレコードを取得
		return mobileLegendsMainSakumaRepository
				.findAll(MobileLegendsSakumaSpecification.generateMobileLegendsSpecification(form), pageable);
	}

	@Override
	public List<MobileLegendsMainSakuma> getListMobileLegendsSakuma(final MobileLegendsSakumaSearchForm form) {

		//検索条件を生成し、MobileLegendsMainSakumaのテーブルのレコードを取得
		return mobileLegendsMainSakumaRepository
				.findAll(MobileLegendsSakumaSpecification.generateMobileLegendsSpecification(form));
	}

	@Override
	public MobileLegendsMainSakuma getMobileLegendsSakuma(final long id) {

		//MobileLegendsMainSakumaテーブルを主キー検索
		return mobileLegendsMainSakumaRepository.findOne(id);
	}

	@Override
	public MobileLegendsMainSakuma insertMobileLegendsSakuma(final MobileLegendsSakumaInputForm form) {

		//MobileLegendsSakumaテーブルで新規にデータを登録する
		final MobileLegendsMainSakuma mobileLegendsMainSakuma = form.convertToMobileLegendsMainSakumaForInsert();
		return mobileLegendsMainSakumaRepository.save(mobileLegendsMainSakuma);
	}

	@Override
	public MobileLegendsMainSakuma updateMobileLegendsSakuma(final MobileLegendsSakumaInputForm form) {

		//更新対象のレコードを取得する
		MobileLegendsMainSakuma mobileLegendsMainSakuma = mobileLegendsMainSakumaRepository
				.findOne((long) form.getId());

		if (mobileLegendsMainSakuma != null) {

			//更新対象のレコードが存在する場合、排他チェック
			if (form.getUpdateDate().equals(String.valueOf(mobileLegendsMainSakuma.getUpdateDate()))) {

				//チェックOKの場合、更新
				mobileLegendsMainSakuma = form.convertToMobileLegendsMainSakumaForUpdate(mobileLegendsMainSakuma);
				return mobileLegendsMainSakumaRepository.saveAndFlush(mobileLegendsMainSakuma);

			}
		}

		return null;
	}

	@Override
	public void deleteMobileLegendsSakumaById(final long id) {

		//更新対象のレコードを取得する
		MobileLegendsMainSakuma mobileLegendsMainSakuma = mobileLegendsMainSakumaRepository.findOne(id);

		if (mobileLegendsMainSakuma != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			mobileLegendsMainSakumaRepository.delete(id);
		}
	}

	@Override
	public void deleteMobileLegendsSakumaComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		mobileLegendsMainSakumaRepository.deleteComp(ids);
	}
}
