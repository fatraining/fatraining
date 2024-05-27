package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.drama.CountryNakaniwa;
import com.example.demo.model.drama.DramaMainNakaniwa;
import com.example.demo.model.drama.GenreNakaniwa;
import com.example.demo.model.form.drama.DramaInputForm;
import com.example.demo.model.form.drama.DramaSearchForm;
import com.example.demo.repository.drama.CountryNakaniwaRepository;
import com.example.demo.repository.drama.DramaMainNakaniwaRepository;
import com.example.demo.repository.drama.GenreNakaniwaRepository;
import com.example.demo.repository.specification.DramaSpecification;
import com.example.demo.service.DramaService;

/**
 * Dramaのサービス実装クラス
 */
@Service
public class DramaServiceImpl implements DramaService {

	/** DramaMainNakaniwaリポジトリ */
	private final DramaMainNakaniwaRepository dramaMainNakaniwaRepository;

	/** GenreNakaniwaリポジトリ */
	private final GenreNakaniwaRepository genreNakaniwaRepository;

	/** CountryNakaniwaリポジトリ */
	private final CountryNakaniwaRepository countryNakaniwaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param DramaMainNakaniwaRepository dramaMainNakaniwaRepository
	 * @param GenreNakaniwaRepository genreNakaniwaRepository
	 * @param CountryNakaniwaRepository countryNakaniwaRepository
	 */
	public DramaServiceImpl(DramaMainNakaniwaRepository dramaMainNakaniwaRepository,
			GenreNakaniwaRepository genreNakaniwaRepository,
			CountryNakaniwaRepository countryNakaniwaRepository) {
		this.dramaMainNakaniwaRepository = dramaMainNakaniwaRepository;
		this.genreNakaniwaRepository = genreNakaniwaRepository;
		this.countryNakaniwaRepository = countryNakaniwaRepository;

	}

	@Override
	public List<GenreNakaniwa> getListGenreNakaniwa() {

		// GenreNakaniwaテーブルのレコードをID順に取得する TO:DO
		return genreNakaniwaRepository.findAll();
	}

	@Override
	public List<CountryNakaniwa> getListCountryNakaniwa() {

		// CountryNakaniwarテーブルのレコードをID順に取得するTO:DO
		return countryNakaniwaRepository.findAll();
	}

	@Override
	public Page<DramaMainNakaniwa> getPageDrama(final DramaSearchForm form, final Pageable pageable) {

		// 検索条件を生成しDramaMainNakaniwaテーブルのレコードを取得する
		return dramaMainNakaniwaRepository.findAll(DramaSpecification.generateDramaSpecification(form), pageable);
	}

	@Override
	public List<DramaMainNakaniwa> getListDrama(final DramaSearchForm form) {

		// 検索条件を生成しDramaMainNakaniwaテーブルのレコードを取得する
		return dramaMainNakaniwaRepository.findAll(DramaSpecification.generateDramaSpecification(form));

	}

	@Override
	public DramaMainNakaniwa getDrama(final long id) {

		// DramaMainNakaniwaテーブルを主キー検索する
		DramaMainNakaniwa dramaMainNakaniwa = dramaMainNakaniwaRepository.findById(id).get();
		return dramaMainNakaniwa;
	}

	@Override
	public DramaMainNakaniwa insertDrama(final DramaInputForm form) {

		// MovieMainテーブルに新規でデータを登録する
		final DramaMainNakaniwa dramaMainNakaniwa = form.convertToDramaMainNakaniwaForInsert();
		return dramaMainNakaniwaRepository.saveAndFlush(dramaMainNakaniwa);
	}

	@Override
	public DramaMainNakaniwa updateDrama(final DramaInputForm form) {

		// 更新対象のレコードを取得する
		Optional<DramaMainNakaniwa> dramaMainNakaniwaOp = dramaMainNakaniwaRepository.findById((long) form.getId());

		DramaMainNakaniwa dramaMainNakaniwa = dramaMainNakaniwaOp.get();
		if (dramaMainNakaniwa != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(dramaMainNakaniwa.getUpdateDate()))) {

				// チェックOKの場合、更新
				dramaMainNakaniwa = form.convertToDramaMainNakaniwaForUpdate(dramaMainNakaniwa);
				return dramaMainNakaniwaRepository.saveAndFlush(dramaMainNakaniwa);
			}
		}
		return null;
	}

	@Override
	public void deleteDramaById(final long id) {

		// 更新対象のレコードを取得する
		Optional<DramaMainNakaniwa> dramaMainNakaniwaOp = dramaMainNakaniwaRepository.findById(id);
		DramaMainNakaniwa dramaMainNakaniwa = dramaMainNakaniwaOp.get();
		if (dramaMainNakaniwa != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			dramaMainNakaniwaRepository.delete(id);
		}
	}

	@Override
	public void deleteDramaComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		dramaMainNakaniwaRepository.deleteComp(ids);
	}

}
