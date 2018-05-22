package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

//import java.awt.print.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.doramasample.DoramaGenre;
import jp.co.futureantiques.webapptraining.model.doramasample.DoramaMain;
import jp.co.futureantiques.webapptraining.model.doramasample.TvStation;
import jp.co.futureantiques.webapptraining.model.form.doramasample.DoramaSampleInputForm;
import jp.co.futureantiques.webapptraining.model.form.doramasample.DoramaSampleSearchForm;
import jp.co.futureantiques.webapptraining.repository.doramasample.DoramaGenreRepository;
import jp.co.futureantiques.webapptraining.repository.doramasample.DoramaMainRepository;
import jp.co.futureantiques.webapptraining.repository.doramasample.TvStationRepository;
import jp.co.futureantiques.webapptraining.repository.specification.DoramaSampleSpecification;
import jp.co.futureantiques.webapptraining.service.DoramaSampleService;

/**
 * doramaSampleのサービス実装クラス
 *
 * @author hiraoka
 */
@Service
public class DoramaSampleServiceImpl implements DoramaSampleService {

	/** doramaMainリポジトリ */
	private final DoramaMainRepository doramaMainRepository;

	/** DoramaGenreリポジトリ */
	private final DoramaGenreRepository doramaGenreRepository;

	/** TvStationリポジトリ */
	private final TvStationRepository tvStationRepository;

	/**
	 * コンストラクタ
	 *
	 * @param DoramaMainRepository doramaMainRepository
	 * @param DoramaGenreRepository doramaGenreRepository
	 * @param TvStationRepository tvStationRepository
	 */
	@Autowired
	public DoramaSampleServiceImpl(DoramaMainRepository doramaMainRepository, DoramaGenreRepository doramaGenreRepository,
			TvStationRepository tvStationRepository) {
		this.doramaMainRepository = doramaMainRepository;
		this.doramaGenreRepository = doramaGenreRepository;
		this.tvStationRepository = tvStationRepository;
	}

	@Override
	public List<DoramaGenre> getListDoramaGenre() {

		// DoramaGenreテーブルのレコードをID順に取得する
		return doramaGenreRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<TvStation> getListTvStation() {

		// TvStationテーブルのレコードをID順に取得する
		return tvStationRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<DoramaMain> getPageDorama(final DoramaSampleSearchForm form, final Pageable pageable) {

		// 検索条件を生成しDoramaMainテーブルのレコードを取得する
		return doramaMainRepository.findAll(DoramaSampleSpecification.generateDoramaSpecification(form),  pageable);
	}

	@Override
	public List<DoramaMain> getListDorama(final DoramaSampleSearchForm form) {

		// 検索条件を生成しDoramaMainテーブルのレコードを取得する
		return doramaMainRepository.findAll(DoramaSampleSpecification.generateDoramaSpecification(form));
	}

	@Override
	public DoramaMain getDorama(final long id) {

		// DoramaMainテーブルを主キー検索する
		return doramaMainRepository.findOne(id);
	}

	@Override
	public DoramaMain insertDorama(final DoramaSampleInputForm form) {

		// DoramaMainテーブルに新規でデータを登録する
		final DoramaMain doramaMain = form.convertTodoramaMainForInsert();
		return doramaMainRepository.save(doramaMain);
	}

	@Override
	public DoramaMain updateDorama(final DoramaSampleInputForm form) {

		// 更新対象のレコードを取得する
		DoramaMain doramaMain = doramaMainRepository.findOne((long) form.getId());
		if (doramaMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(doramaMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				doramaMain = form.convertTodoramaMainForUpdate(doramaMain);
				return doramaMainRepository.saveAndFlush(doramaMain);
			}
		}
		return null;
	}

	@Override
	public void deleteDoramaById(final long id) {

		// 更新対象のレコードを取得する
		DoramaMain doramaMain = doramaMainRepository.findOne(id);
		if (doramaMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			doramaMainRepository.delete(id);
		}
	}

	@Override
	public void deleteDoramaComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		doramaMainRepository.deleteComp(ids);
	}
}