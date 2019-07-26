package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.dffTatebe.DffMainTatebe;
import jp.co.futureantiques.webapptraining.model.dffTatebe.DffTitleTatebe;
import jp.co.futureantiques.webapptraining.model.dffTatebe.DffTypeTatebe;
import jp.co.futureantiques.webapptraining.model.form.dffTatebe.DffTatebeInputForm;
import jp.co.futureantiques.webapptraining.model.form.dffTatebe.DffTatebeSearchForm;
import jp.co.futureantiques.webapptraining.repository.dffTatebe.DffMainTatebeRepository;
import jp.co.futureantiques.webapptraining.repository.dffTatebe.DffTitleTatebeRepository;
import jp.co.futureantiques.webapptraining.repository.dffTatebe.DffTypeTatebeRepository;
import jp.co.futureantiques.webapptraining.repository.specification.DffTatebeSpecification;
import jp.co.futureantiques.webapptraining.service.DffTatebeService;

/** DffTatebeのサービス実装クラス */

@Service
public class DffTatebeServiceImpl implements DffTatebeService {

	/** DffMainTatebeのリポジトリ*/
	private final DffMainTatebeRepository dffMainTatebeRepository;

	/** TitleTatebeのリポジトリ */
	private final DffTitleTatebeRepository titleTatebeRepository;

	/** TypeTatebeのリポジトリ */
	private final DffTypeTatebeRepository typeTatebeRepository;

	/**
	 * コンストラクタ
	 *
	 * @param DffMainTatebeRepository dffMainTatebeRepository
	 * @param DffTitleTatebeRepository titleTatebe
	 * @param DffTypeTatebe typeTatebe
	 */
	@Autowired
	public DffTatebeServiceImpl(DffMainTatebeRepository dffMainTatebeRepository,
			DffTitleTatebeRepository titleTatebeRepository,
			DffTypeTatebeRepository typeTatebeRepository) {
		this.dffMainTatebeRepository = dffMainTatebeRepository;
		this.titleTatebeRepository = titleTatebeRepository;
		this.typeTatebeRepository = typeTatebeRepository;
	}

	@Override
	public List<DffTitleTatebe> getListTitleTatebe() {

		//TitleテーブルのレコードをID順に取得
		return titleTatebeRepository.findAll(new Sort(Sort.Direction.ASC, "id"));

	}

	@Override
	public List<DffTypeTatebe> getListTypeTatebe() {

		//TypeテーブルのレコードをID順に取得
		return typeTatebeRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<DffMainTatebe> getPageDffTatebe(final DffTatebeSearchForm form, final Pageable pageable) {

		//検索条件を生成し、YugiohMainOkugawaのテーブルのレコードを取得
		return dffMainTatebeRepository.findAll(DffTatebeSpecification.generateDffSpecification(form),
				pageable);
	}

	@Override
	public List<DffMainTatebe> getListDffTatebe(final DffTatebeSearchForm form) {

		//検索条件を生成しYugiohMainOkugawaのテーブルレコードを取得
		return dffMainTatebeRepository.findAll(DffTatebeSpecification.generateDffSpecification(form));
	}

	@Override
	public DffMainTatebe getDffTatebe(final long id) {

		//DffMainTatebeテーブルを主キー検索
		return dffMainTatebeRepository.findOne(id);
	}

	@Override
	public DffMainTatebe insertDffTatebe(final DffTatebeInputForm form) {

		//DffTatebeテーブルで新規でデータを登録する
		final DffMainTatebe dffMainTatebe = form.convertToDffMainTatebeForInsert();
		return dffMainTatebeRepository.save(dffMainTatebe);
	}

	@Override
	public DffMainTatebe updateDffTatebe(final DffTatebeInputForm form) {

		//更新対象のレコードを取得する
		DffMainTatebe dffMainTatebe = dffMainTatebeRepository.findOne((long) form.getId());
		if (dffMainTatebe != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(dffMainTatebe.getUpdateDate()))) {

				//チェックOKの場合、更新
				dffMainTatebe = form.convertToDffMainTatebeForUpdate(dffMainTatebe);
				return dffMainTatebeRepository.saveAndFlush(dffMainTatebe);
			}
		}
		return null;
	}

	@Override
	public void deleteDffTatebeById(final long id) {

		//更新対象のレコードを取得する
		DffMainTatebe dffMainTatebe = dffMainTatebeRepository.findOne(id);
		if (dffMainTatebe != null) {

			//更新対象のレコードが存在する場合削除フラグを1にする
			dffMainTatebeRepository.delete(id);
		}
	}

	@Override
	public void deleteDffTatebeComp(final ArrayList<Long> ids) {
		//対象のレコードを削除する
		dffMainTatebeRepository.deleteComp(ids);
	}
}
