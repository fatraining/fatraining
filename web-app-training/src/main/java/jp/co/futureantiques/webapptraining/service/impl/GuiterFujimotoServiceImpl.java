package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.CompanyFujimoto;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.GuiterMainFujimoto;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.WoodFujimoto;
import jp.co.futureantiques.webapptraining.model.form.guiterFujimoto.GuiterInputForm;
import jp.co.futureantiques.webapptraining.model.form.guiterFujimoto.GuiterSearchForm;
import jp.co.futureantiques.webapptraining.repository.guiterFujimoto.CompanyFujimotoRepository;
import jp.co.futureantiques.webapptraining.repository.guiterFujimoto.GuiterMainFujimotoRepository;
import jp.co.futureantiques.webapptraining.repository.guiterFujimoto.WoodFujimotoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.GuiterFujimotoSpecification;
import jp.co.futureantiques.webapptraining.service.GuiterFujimotoService;

/**
 * GuiterMainFujimotoのサービス実装クラス
 * @author futureFUJIMOTO
 *
 */
@Service
public class GuiterFujimotoServiceImpl implements GuiterFujimotoService {

	/**GuiterMainFujimotoリポジトリ*/
	private final GuiterMainFujimotoRepository guiterMainFujimotoRepository;

	/**Companyリポジトリ*/
	private final CompanyFujimotoRepository companyFujimotoRepository;

	/**Woodレポジトリ */
	private final WoodFujimotoRepository woodFujimotoRepository;

	/**
	 * コンストラクタ
	 *
	 * @param GuiterMainFujimotoRepository guiter
	 * @param CompanyFujimotoRepository companyFujimotoRepository
	 * @param WoodFujimotoRepository woodFujimotoRepository
	 */
	@Autowired
	public GuiterFujimotoServiceImpl(GuiterMainFujimotoRepository guiterMainFujimotoRepository,
			CompanyFujimotoRepository companyFujimotoRepository, WoodFujimotoRepository woodFujimotoRepository) {
		this.guiterMainFujimotoRepository = guiterMainFujimotoRepository;
		this.companyFujimotoRepository = companyFujimotoRepository;
		this.woodFujimotoRepository = woodFujimotoRepository;
	}

	@Override
	public List<CompanyFujimoto> getListCompanyFujimoto() {
		//company_fujimotoテ－ブルのレコードをID順に取得する。
		return companyFujimotoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<WoodFujimoto> getListWoodFujimoto() {

		//wood_fujimotoテーブルのレコードをID順に取得する
		return woodFujimotoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<GuiterMainFujimoto> getPageGuiter(GuiterSearchForm form, Pageable pageable) {//検索条件を生成しguiter_main_fujimotoテーブルのレコードを取得する。
		return guiterMainFujimotoRepository.findAll(GuiterFujimotoSpecification.generateGuiterSpecification(form),
				(Pageable) pageable);
	}

	@Override
	public List<GuiterMainFujimoto> getListGuiter(final GuiterSearchForm form) {

		//検索条件を生成しguiter_main_fujimotoテーブルのレコードを取得する
		return guiterMainFujimotoRepository.findAll(GuiterFujimotoSpecification.generateGuiterSpecification(form));
	}

	@Override
	public GuiterMainFujimoto getGuiter(long id) {

		//guiter_main_fujimotoテーブルを主キー検索する
		return guiterMainFujimotoRepository.findOne(id);
	}
	@Override
	public GuiterMainFujimoto insertGuiter(final GuiterInputForm form) {

		// GuiterMainテーブルに新規でデータを登録する
		final GuiterMainFujimoto guiterMainFujimoto = form.convertToGuiterMainFujimotoForInsert();
		return guiterMainFujimotoRepository.save(guiterMainFujimoto);
	}

	@Override
	public GuiterMainFujimoto updateGuiter(final GuiterInputForm form) {

		// 更新対象のレコードを取得する
		GuiterMainFujimoto guiterMainFujimoto = guiterMainFujimotoRepository.findOne((long) form.getId());
		if (guiterMainFujimoto != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(guiterMainFujimoto.getUpdateDate()))) {

				// チェックOKの場合、更新
				guiterMainFujimoto = form.convertToGuiterMainFujimotoForUpdate(guiterMainFujimoto);
				return guiterMainFujimotoRepository.saveAndFlush(guiterMainFujimoto);
			}
		}
		return null;
	}

	@Override
	public void deleteGuiterById(final long id) {

		// 更新対象のレコードを取得する
		GuiterMainFujimoto guiterMainFujimoto = guiterMainFujimotoRepository.findOne(id);
		if (guiterMainFujimoto != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			guiterMainFujimotoRepository.delete(id);
		}
	}

	@Override
	public void deleteGuiterComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		guiterMainFujimotoRepository.deleteComp(ids);
	}
}


