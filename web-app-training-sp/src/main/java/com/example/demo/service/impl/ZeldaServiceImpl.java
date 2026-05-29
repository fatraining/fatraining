package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.form.zelda.ZeldaDeleteForm;
import com.example.demo.model.form.zelda.ZeldaInputForm;
import com.example.demo.model.form.zelda.ZeldaSearchForm;
import com.example.demo.model.zeldaikeda.CompatibleModelIkeda;
import com.example.demo.model.zeldaikeda.GenreIkeda;
import com.example.demo.model.zeldaikeda.TimeSeriesIkeda;
import com.example.demo.model.zeldaikeda.ZeldaMainIkeda;
import com.example.demo.repository.specification.ZeldaSpecification;
import com.example.demo.repository.zeldaIkeda.CompatibleModelIkedaRepository;
import com.example.demo.repository.zeldaIkeda.GenreIkedaRepository;
import com.example.demo.repository.zeldaIkeda.TimeSeriesIkedaRepository;
import com.example.demo.repository.zeldaIkeda.ZeldaMainIkedaRepository;
import com.example.demo.service.ZeldaIkedaService;

/**
 * ZeldaIkedaServiceのサービス実装クラス
 */
@Service
public class ZeldaServiceImpl implements ZeldaIkedaService {

	/** ZeldaMainIkedaリポジトリ */
	private final ZeldaMainIkedaRepository zeldaMainIkedaRepository;

	/** GenreIkedaリポジトリ */
	private final GenreIkedaRepository genreIkedaRepository;

	/** TimeSeriesIkedaリポジトリ */
	private final TimeSeriesIkedaRepository timeSeriesIkedaRepository;

	/** CompatibleModelIkedaリポジトリ */
	private final CompatibleModelIkedaRepository compatibleModelIkedaRepository;

	/**
	 * コンストラクタ
	 * @param ZeldaMainIkedaRepository zeldaMainIkedaRepository
	 * @param GenreIkedaRepository genreIkedaRepository
	 * @param TiemSeriesIkedaRepository timeSeriesIkedaRepository
	 * @param CompatibleModelIkedaRepository compatibleModelIkedaRepository
	 */
	public ZeldaServiceImpl(ZeldaMainIkedaRepository zeldaMainIkedaRepository, GenreIkedaRepository genreIkedaRepository,
			TimeSeriesIkedaRepository timeSeriesIkedaRepository, CompatibleModelIkedaRepository compatibleModelIkedaRepository) {
		this.zeldaMainIkedaRepository = zeldaMainIkedaRepository;
		this.genreIkedaRepository = genreIkedaRepository;
		this.timeSeriesIkedaRepository = timeSeriesIkedaRepository;
		this.compatibleModelIkedaRepository = compatibleModelIkedaRepository;
	}

	@Override
	public List<GenreIkeda> getListGenreIkeda() {

		// GenreテーブルのレコードをID順に取得する TO:DO
		return genreIkedaRepository.findAll();
	}

	@Override
	public List<TimeSeriesIkeda> getListTimeSeriesIkeda() {

		// TimeSeriesテーブルのレコードをID順に取得する TO:DO
		return timeSeriesIkedaRepository.findAll();
	}

	@Override
	public List<CompatibleModelIkeda> getListCompatibleModelIkeda() {

		// CompatibleModelテーブルのレコードをID順に取得する TO:DO
		return compatibleModelIkedaRepository.findAll();
	}

	@Override
	public Page<ZeldaMainIkeda> getPageZelda(final ZeldaSearchForm form, final Pageable pageable) {

		// 検索条件を生成しZeldaMainIkedaテーブルのレコードを取得する
		return zeldaMainIkedaRepository.findAll(ZeldaSpecification.generateZeldaSpecification(form), pageable);
	}

	@Override
	public List<ZeldaMainIkeda> getListZelda(final ZeldaSearchForm form) {

		// 検索条件を生成しZeldaMainIkedaテーブルのレコードを取得する
		return zeldaMainIkedaRepository.findAll(ZeldaSpecification.generateZeldaSpecification(form));
	}

	@Override
	public ZeldaMainIkeda getZelda(final long id) {

		// ZeldaMainIkedaテーブルを主キー検索する
		ZeldaMainIkeda zeldaMain = zeldaMainIkedaRepository.findById(id).get();
		return zeldaMain;
	}

	@Override
	public ZeldaMainIkeda insertZelda(final ZeldaInputForm form) {

		// ZeldaMainIkedaテーブルに新規でデータを登録する
		final ZeldaMainIkeda zeldaMain = form.convertToZeldaMainIkedaForInsert();
		return zeldaMainIkedaRepository.saveAndFlush(zeldaMain);
	}

	@Override
	public ZeldaMainIkeda updateZelda(final ZeldaInputForm form) {

		// 更新対象のレコードを取得する
		Optional<ZeldaMainIkeda> zeldaMainOp = zeldaMainIkedaRepository.findById((long) form.getZeldaId());

		ZeldaMainIkeda zeldaMain = zeldaMainOp.get();
		if (zeldaMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(zeldaMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				zeldaMain = form.convertToZeldaMainIkedaForUpdate(zeldaMain);
				return zeldaMainIkedaRepository.saveAndFlush(zeldaMain);
			}
		}
		return null;
	}

	@Override
	public void deleteZeldaById(final long id) {

		//更新対象のレコードを取得する
		Optional<ZeldaMainIkeda> zeldaMainOp = zeldaMainIkedaRepository.findById(id);
		ZeldaMainIkeda zeldaMain = zeldaMainOp.get();
		if (zeldaMain != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			zeldaMainIkedaRepository.delete(id);
		}
	}

	@Override
	public void revokeZeldaById(final ArrayList<Long> ids) {

		//対象のレコードを復元する
		zeldaMainIkedaRepository.revoke(ids);
	}

	@Override
	public void deleteZeldaComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		zeldaMainIkedaRepository.deleteComp(ids);
	}

	@Override
	public void erroZelda(final ZeldaDeleteForm form, final Model model) {

		//再検索して自画面に戻る
		ZeldaSearchForm zeldaSearchForm = new ZeldaSearchForm();
		zeldaSearchForm.setIsDelete(CommonConst.DELETE_FLG_ON);
		final List<ZeldaMainIkeda> zeldaMain = zeldaMainIkedaRepository
				.findAll(ZeldaSpecification.generateZeldaSpecification(zeldaSearchForm));

		//Modelに検索結果を格納する
		model.addAttribute(zeldaMain);
	}
}
