package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.brandkambara.BrandMainKambara;
import jp.co.futureantiques.webapptraining.model.brandkambara.GenreKambara;
import jp.co.futureantiques.webapptraining.model.brandkambara.MadeCountryKambara;
import jp.co.futureantiques.webapptraining.model.form.brandKambara.BrandKambaraInputForm;
import jp.co.futureantiques.webapptraining.model.form.brandKambara.BrandKambaraSearchForm;
import jp.co.futureantiques.webapptraining.repository.brandKambara.BrandMainKambaraRepository;
import jp.co.futureantiques.webapptraining.repository.brandKambara.GenreKambaraRepository;
import jp.co.futureantiques.webapptraining.repository.brandKambara.MadeCountryKambaraRepository;
import jp.co.futureantiques.webapptraining.repository.specification.BrandKambaraSpecification;
import jp.co.futureantiques.webapptraining.service.BrandKambaraService;

/**
 * BrandKambaraのサービス実装クラス
 *
 * @author Yuki Kambara
 */
@Service
public class BrandKambaraServiceImpl implements BrandKambaraService {

	/** BrandMainKambaraリポジトリ */
	private final BrandMainKambaraRepository brandMainKambaraRepository;

	/** GenreKambaraリポジトリ */
	private final GenreKambaraRepository genreKambaraRepository;

	/** MadeCountryKambaraリポジトリ */
	private final MadeCountryKambaraRepository madeCountryKambaraRepository;

	/**
	 * コンストラクタ
	 *
	 * @param BrandMainKambaraRepository brandMainKambaraRepository
	 * @param GenreKambaraRepository genreKambaraRepository
	 * @param MadeCountryKambaraRepository madeCountryKambaraRepositry
	 */
	@Autowired
	public BrandKambaraServiceImpl(BrandMainKambaraRepository brandMainKambaraRepository, GenreKambaraRepository genreKambaraRepository,
			MadeCountryKambaraRepository madeCountryKambaraRepository) {
		this.brandMainKambaraRepository = brandMainKambaraRepository;
		this.genreKambaraRepository = genreKambaraRepository;
		this.madeCountryKambaraRepository = madeCountryKambaraRepository;
	}

	//サービスの下に変更有
	@Override
	public List<GenreKambara> getListGenreKambara() {

		// GenreKambaraテーブルのレコードをID順に取得する
		return genreKambaraRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//サービスの下の方に変更有
	@Override
	public List<MadeCountryKambara> getListMadeCountryKambara() {

		// MadeCountryKambaraテーブルのレコードをID順に取得する
		return madeCountryKambaraRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<BrandMainKambara> getPageBrand(final BrandKambaraSearchForm form, final Pageable pageable) {

		// 検索条件を生成しBrandMainKambaraテーブルのレコードを取得する
		return brandMainKambaraRepository.findAll(BrandKambaraSpecification.generateBrandKambaraSpecification(form), pageable);
	}

	@Override
	public List<BrandMainKambara> getListBrandMainKambara(final BrandKambaraSearchForm form) {

		// 検索条件を生成しBrandMainKambaraテーブルのレコードを取得する
		return brandMainKambaraRepository.findAll(BrandKambaraSpecification.generateBrandKambaraSpecification(form));
	}

	@Override
	public  BrandMainKambara getBrandMainKambara(final long id) {

		// BrandMainKambaraテーブルを主キー検索する
		return brandMainKambaraRepository.findOne(id);
	}

	@Override
	public BrandMainKambara insertBrand(final BrandKambaraInputForm form) {

		//BrandMainKambaraテーブルに新規でデータを登録する
		final BrandMainKambara brandMainKambara = form.convertToBrandMainKambaraForInsert();
		return brandMainKambaraRepository.save(brandMainKambara);
	}

	@Override
	public BrandMainKambara updateBrand(final BrandKambaraInputForm form) {

		// 更新対象のレコードを取得する
		BrandMainKambara brandMainKambara = brandMainKambaraRepository.findOne((long) form.getId());
		if (brandMainKambara != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(brandMainKambara.getUpdateDate()))) {

				// チェックOKの場合、更新
				brandMainKambara = form.convertToBrandMainKambaraForUpdate(brandMainKambara);
				return brandMainKambaraRepository.saveAndFlush(brandMainKambara);
			}
		}
		return null;
	}

	@Override
	public void deleteBrandById(final long id) {

		// 更新対象のレコードを取得する
		BrandMainKambara brandMainKambara = brandMainKambaraRepository.findOne(id);
		if (brandMainKambara != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			brandMainKambaraRepository.delete(id);
		}
	}

	@Override
	public void deleteBrandComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		brandMainKambaraRepository.deleteComp(ids);
	}


	@Override
	public List<GenreKambara> getGenreKambara() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}



	@Override
	public List<BrandMainKambara> getBrandNameKambara() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}





}
