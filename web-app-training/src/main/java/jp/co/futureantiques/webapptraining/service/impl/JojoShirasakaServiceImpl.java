package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.jojoShirasaka.JojoStandInputForm;
import jp.co.futureantiques.webapptraining.model.form.jojoShirasaka.JojoStandSearchForm;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoAppearanceShirasaka;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoMainShirasaka;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoSexShirasaka;
import jp.co.futureantiques.webapptraining.repository.jojoShirasaka.JojoAppearanceRepository;
import jp.co.futureantiques.webapptraining.repository.jojoShirasaka.JojoMainShirasakaRepository;
import jp.co.futureantiques.webapptraining.repository.jojoShirasaka.JojoSexRepository;
import jp.co.futureantiques.webapptraining.repository.specification.JojoStandSearchSpecification;
import jp.co.futureantiques.webapptraining.service.JojoShirasakaService;

/** JojoShirasakaのサービス実装クラス */

@Service
public class JojoShirasakaServiceImpl implements JojoShirasakaService {

	/** JojoStandMainRepository */
	private final JojoMainShirasakaRepository jojoMainShirasakaRepository;

	/** JojoSexRepository */
	private final JojoSexRepository jojoSexRepository;

	/** JojoAppearanceRepository */
	private final JojoAppearanceRepository jojoAppearanceRepository;

	/**
	 * コンストラクタ
	 *
	 * @param JojoMainShirasakaRepository jojostandMainRepository
	 * @param JojoSexRepository jojoSexRepository
	 * @param JojoAppearanceRepository jojoAppearanceRepository
	 */
	@Autowired
	public JojoShirasakaServiceImpl(JojoMainShirasakaRepository jojostandMainRepository, JojoSexRepository jojoSexRepository,
			JojoAppearanceRepository jojoAppearanceRepository) {
		this.jojoMainShirasakaRepository = jojostandMainRepository;
		this.jojoSexRepository = jojoSexRepository;
		this.jojoAppearanceRepository = jojoAppearanceRepository;
	}

	@Override
	public List<JojoSexShirasaka> getListJojoSex() {

		// JojoSexテーブルのレコードをID順に取得する
		return jojoSexRepository.findAll(new Sort(Sort.Direction.ASC, "sexId"));
	}

	@Override
	public List<JojoAppearanceShirasaka> getListJojoAppearance() {

		// JojoAppearanceテーブルのレコードをID順に取得する
		return jojoAppearanceRepository.findAll(new Sort(Sort.Direction.ASC, "appearanceId"));
	}

	@Override
	public Page<JojoMainShirasaka> getPageJojo(final JojoStandSearchForm form, final Pageable pageable) {

		// 検索条件を生成しJojoMainShirasakaテーブルのレコードを取得する
		return jojoMainShirasakaRepository.findAll(JojoStandSearchSpecification.generateJojoSpecification(form), pageable);
	}

	@Override
	public List<JojoMainShirasaka> getListJojoMain(final JojoStandSearchForm form) {

		// 検索条件を生成しjojoMainShirasakaテーブルのレコードを取得する
		return jojoMainShirasakaRepository.findAll(JojoStandSearchSpecification.generateJojoSpecification(form));
	}

	@Override
	public JojoMainShirasaka getJojoStand(final long id) {

		// jojoMainShirasakaテーブルを主キー検索する
		return jojoMainShirasakaRepository.findOne(id);

	}


	@Override
	public JojoMainShirasaka insertJojo(final JojoStandInputForm form) {

		// JojoMainShirasakaテーブルに新規でデータを登録する
		final JojoMainShirasaka jojoMainShirasaka = form.convertToJojoMainForInsert();
		return jojoMainShirasakaRepository.save(jojoMainShirasaka);
	}

	@Override
	public JojoMainShirasaka updateStand(final JojoStandInputForm form) {

		// 更新対象のレコードを取得する
		JojoMainShirasaka jojoMainShirasaka = jojoMainShirasakaRepository.findOne((long) form.getId());
		if (jojoMainShirasaka != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(jojoMainShirasaka.getUpdateDate()))) {

				// チェックOKの場合、更新
				jojoMainShirasaka = form.convertToJojoMainForUpdate(jojoMainShirasaka);
				return jojoMainShirasakaRepository.saveAndFlush(jojoMainShirasaka);
			}
		}
		return null;
	}

	@Override
	public void deleteStandById(final long id) {

		// 更新対象のレコードを取得する
		JojoMainShirasaka jojoMainShirasaka = jojoMainShirasakaRepository.findOne(id);
		if (jojoMainShirasaka != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			jojoMainShirasakaRepository.delete(id);
		}
	}

	@Override
	public void deleteStandComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		jojoMainShirasakaRepository.deleteComp(ids);
	}

}