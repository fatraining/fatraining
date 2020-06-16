package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.proteinUeno.ProteinUenoInputForm;
import jp.co.futureantiques.webapptraining.model.form.proteinUeno.ProteinUenoSearchForm;
import jp.co.futureantiques.webapptraining.model.proteinUeno.KindsUeno;
import jp.co.futureantiques.webapptraining.model.proteinUeno.MakerUeno;
import jp.co.futureantiques.webapptraining.model.proteinUeno.ProteinMainUeno;
import jp.co.futureantiques.webapptraining.repository.proteinUeno.KindsUenoRepository;
import jp.co.futureantiques.webapptraining.repository.proteinUeno.MakerUenoRepository;
import jp.co.futureantiques.webapptraining.repository.proteinUeno.ProteinMainUenoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ProteinUenoSpecification;
import jp.co.futureantiques.webapptraining.service.ProteinUenoService;

/**
 * ProteinUenoのサービス実装クラス
 * @author ueno
 *
 */
@Service
public class ProteinUenoServiceImpl implements ProteinUenoService {

	/**ProteinMainリポジトリ**/
	private final ProteinMainUenoRepository proteinMainRepository;

	/**kindsリポジトリ**/
	private final KindsUenoRepository kindRepository;

	/**makerリポジトリ**/
	private final MakerUenoRepository makerRepository;

	/**
	 * コンストラクタ
	 *
	 * @param ProteinMainUenoRepository proteinMainRepository
	 * @param KindsUenoRepository kindRepository
	 * @param MakerUenoRepository makerRepository
	 *
	 */
	@Autowired
	public ProteinUenoServiceImpl(ProteinMainUenoRepository proteinMainRepository,
			KindsUenoRepository kindRepository, MakerUenoRepository makerRepository) {
		this.proteinMainRepository = proteinMainRepository;
		this.kindRepository = kindRepository;
		this.makerRepository = makerRepository;

	}

	@Override
	public List<KindsUeno> getListKindsUeno() {
		// KindsテーブルのレコードをID順に取得する
		return kindRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<MakerUeno> getListMakerUeno() {

		// MakerテーブルのレコードをID順に取得する
		return makerRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<ProteinMainUeno> getPageProtein(final ProteinUenoSearchForm form, final Pageable pageable) {
		// 検索条件を生成しProteinMainテーブルのレコードを取得する
		return proteinMainRepository.findAll(ProteinUenoSpecification.generateProteinSpecification(form), pageable);
	}

	@Override
	public List<ProteinMainUeno> getListProtein(final ProteinUenoSearchForm form) {

		// 検索条件を生成しProteinMainテーブルのレコードを取得する
		return proteinMainRepository.findAll(ProteinUenoSpecification.generateProteinSpecification(form));
	}

	@Override
	public ProteinMainUeno getProtein(final long id) {

		// ProteinMainテーブルを主キー検索する
		return proteinMainRepository.findOne(id);
	}

	@Override
	public ProteinMainUeno insertProtein(final ProteinUenoInputForm form) {

		// ProteinMainテーブルに新規でデータを登録する
		final ProteinMainUeno proteinMain = form.convertToProteinMainUenoForInsert();
		return proteinMainRepository.save(proteinMain);
	}

	@Override
	public ProteinMainUeno updateProtein(final ProteinUenoInputForm form) {

		// 更新対象のレコードを取得する
		ProteinMainUeno proteinMain = proteinMainRepository.findOne((long) form.getId());
		if (proteinMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(proteinMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				proteinMain = form.convertToProteinMainForUpdate(proteinMain);
				return proteinMainRepository.saveAndFlush(proteinMain);
			}
		}
		return null;
	}

	@Override
	public void deleteProteinById(final long id) {

		// 更新対象のレコードを取得する
		ProteinMainUeno proteinMain = proteinMainRepository.findOne(id);
		if (proteinMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			proteinMainRepository.delete(id);
		}
	}

	@Override
	public void deleteProteinComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		proteinMainRepository.deleteComp(ids);
	}

}
