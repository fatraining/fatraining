package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyAreaIto;
import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyMainIto;
import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyParkIto;
import jp.co.futureantiques.webapptraining.model.form.disneyIto.DisneyItoInputForm;
import jp.co.futureantiques.webapptraining.model.form.disneyIto.DisneyItoSearchForm;
import jp.co.futureantiques.webapptraining.repository.disneyIto.DisneyAreaItoRepository;
import jp.co.futureantiques.webapptraining.repository.disneyIto.DisneyMainItoRepository;
import jp.co.futureantiques.webapptraining.repository.disneyIto.DisneyParkItoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.DisneyItoSpecification;
import jp.co.futureantiques.webapptraining.service.DisneyItoService;

/**
 * DisneyItoのサービス実装クラス
 *
 * @author Ayaka Ito
 */
@Service
public class DisneyItoServiceImpl implements DisneyItoService {

	/** DisneyMainItoリポジトリ */
	private final DisneyMainItoRepository disneyMainItoRepository;

	/** DisneyParkItoリポジトリ */
	private final DisneyParkItoRepository disneyParkItoRepository;

	/** DisneyAreaItoリポジトリ */
	private final DisneyAreaItoRepository disneyAreaItoRepository;

	/**
	 * コンストラクタ
	 *
	 * @param DisneyMainItoRepository disneyMainItoRepository
	 * @param DisneyParkItoRepository parkItoRepository
	 * @param DisneyAreaItoRepository areaSecondItoRepository
	 */
	@Autowired
	public DisneyItoServiceImpl(DisneyMainItoRepository disneyMainItoRepository, DisneyParkItoRepository disneyParkItoRepository,
			DisneyAreaItoRepository disneyAreaItoRepository) {
		this.disneyMainItoRepository = disneyMainItoRepository;
		this.disneyParkItoRepository = disneyParkItoRepository;
		this.disneyAreaItoRepository = disneyAreaItoRepository;
	}

	@Override
	public List<DisneyParkIto> getListDisneyParkIto() {

		// ParkItoテーブルのレコードをID順に取得する
		return disneyParkItoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<DisneyAreaIto> getListDisneyAreaIto() {

		// DisneyAreaItoテーブルのレコードをID順に取得する
		return disneyAreaItoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<DisneyMainIto> getPageDisney(final DisneyItoSearchForm form, final Pageable pageable) {

		// 検索条件を生成しDisneyMainItoテーブルのレコードを取得する
		return disneyMainItoRepository.findAll(DisneyItoSpecification.generateDisneyItoSpecification(form), pageable);
	}

	@Override
	public List<DisneyMainIto> getListDisney(final DisneyItoSearchForm form) {

		// 検索条件を生成しDisneyMainItoテーブルのレコードを取得する
		return disneyMainItoRepository.findAll(DisneyItoSpecification.generateDisneyItoSpecification(form));
	}

	@Override
	public DisneyMainIto getDisney(final long id) {

		// DisneyMainItoテーブルを主キー検索する
		return disneyMainItoRepository.findOne(id);
	}

	@Override
	public DisneyMainIto insertDisney(final DisneyItoInputForm form) {

		// DisneyMainItoテーブルに新規でデータを登録する
		final DisneyMainIto disneyMainIto = form.converToDisneyMainItoForInsert();
		return disneyMainItoRepository.save(disneyMainIto);
	}

	@Override
	public DisneyMainIto updateDisney(final DisneyItoInputForm form) {

		// 更新対象のレコードを取得する
		DisneyMainIto disneyMainIto = disneyMainItoRepository.findOne((long) form.getId());
		if (disneyMainIto != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(disneyMainIto.getUpdateDate()))) {

				// チェックOKの場合、更新
				disneyMainIto = form.convertToDisneyMainItoForUpdate(disneyMainIto);
				return disneyMainItoRepository.saveAndFlush(disneyMainIto);
			}
		}
		return null;
	}

	@Override
	public void deleteDisneyById(final long id) {

		// 更新対象のレコードを取得する
		DisneyMainIto disneyMainIto = disneyMainItoRepository.findOne(id);
		if (disneyMainIto != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			disneyMainItoRepository.delete(id);
		}
	}

	@Override
	public void deleteDisneyComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		disneyMainItoRepository.deleteComp(ids);
	}

}
