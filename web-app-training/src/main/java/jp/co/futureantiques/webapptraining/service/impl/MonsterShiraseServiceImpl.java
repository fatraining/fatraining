package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.monsterShirase.MonsterShiraseInputForm;
import jp.co.futureantiques.webapptraining.model.form.monsterShirase.MonsterShiraseSearchForm;
import jp.co.futureantiques.webapptraining.model.monsterShirase.ElementShirase;
import jp.co.futureantiques.webapptraining.model.monsterShirase.GenreShirase;
import jp.co.futureantiques.webapptraining.model.monsterShirase.MonsterMainShirase;
import jp.co.futureantiques.webapptraining.model.monsterShirase.TitleShirase;
import jp.co.futureantiques.webapptraining.repository.monsterShirase.ElementShiraseRepository;
import jp.co.futureantiques.webapptraining.repository.monsterShirase.GenreShiraseRepository;
import jp.co.futureantiques.webapptraining.repository.monsterShirase.MonsterMainShiraseRepository;
import jp.co.futureantiques.webapptraining.repository.monsterShirase.TitleShiraseRepository;
import jp.co.futureantiques.webapptraining.repository.specification.MonsterShiraseSpecification;
import jp.co.futureantiques.webapptraining.service.MonsterShiraseService;

/**
 * MonsterShiraseのサービス実装クラス
 *
 * @author Shirase
 */
@Service
public class MonsterShiraseServiceImpl implements MonsterShiraseService {

	/**MonsterMainShiraseリポジトリ**/
	private final MonsterMainShiraseRepository monsterMainShiraseRepository;

	/**GenreShiraseリポジトリ**/
	private final GenreShiraseRepository genreShiraseRepository;

	/**ElementShiraseリポジトリ**/
	private final ElementShiraseRepository elementShiraseRepository;

	/**TitleShiraseリポジトリ**/
	private final TitleShiraseRepository titleShiraseRepository;

	/**
	 * コンストラクタ
	 *
	 * @param MonsterMainShiraseRepository	monsterMainShiraseRepository
	 * @param GenreShiraseRepository		genreShiraseRepository
	 * @param ElementShiraseRepository		elementShiraseRepository
	 * @param TitleShiraseRepository		titleShiraseRepository
	 */
	@Autowired
	public MonsterShiraseServiceImpl(MonsterMainShiraseRepository monsterMainShiraseRepository,
			GenreShiraseRepository genreShiraseRepository,
			ElementShiraseRepository elementShiraseRepository,
			TitleShiraseRepository titleShiraseRepository) {
		this.monsterMainShiraseRepository = monsterMainShiraseRepository;
		this.genreShiraseRepository = genreShiraseRepository;
		this.elementShiraseRepository = elementShiraseRepository;
		this.titleShiraseRepository = titleShiraseRepository;
	}

	@Override
	public List<GenreShirase> getListGenreShirase() {

		//GenreShiraseテーブルのレコードをID順に取得する
		return genreShiraseRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<ElementShirase> getListElementShirase() {

		//ElementShiraseテーブルのレコードをID順に取得する
		return elementShiraseRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<TitleShirase> getListTitleShirase() {

		//TitleShiraseテーブルのレコードをID順に取得する
		return titleShiraseRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<MonsterMainShirase> getPageMonsterShirase(final MonsterShiraseSearchForm form, final Pageable pageable) {

		//検索条件を生成しMonsterMainShiraseテーブルのレコードを取得する
		return monsterMainShiraseRepository.findAll(
				MonsterShiraseSpecification.generateMonsterShiraseSpecification(form), pageable);
	}

	@Override
	public List<MonsterMainShirase> getListMonsterShirase(final MonsterShiraseSearchForm form) {

		//検索条件を生成しMonsterMainShiraseテーブルのレコードを取得する
		return monsterMainShiraseRepository
				.findAll(MonsterShiraseSpecification.generateMonsterShiraseSpecification(form));
	}

	@Override
	public MonsterMainShirase getMonster(final long id) {

		// MonsterMainShiraseテーブルを主キー検索する
		return monsterMainShiraseRepository.findOne(id);
	}

	@Override
	public MonsterMainShirase insertMonster(final MonsterShiraseInputForm form) {

		// MonsterMainShiraseテーブルに新規でデータを登録する
		final MonsterMainShirase monsterMainShirase = form.convertToMonsterMainShiraseForInsert();
		return monsterMainShiraseRepository.save(monsterMainShirase);
	}

	@Override
	public MonsterMainShirase updateMonster(final MonsterShiraseInputForm form) {

		//更新対象のレコードを取得する
		MonsterMainShirase monsterMainShirase = monsterMainShiraseRepository.findOne((long) form.getId());
		if (monsterMainShirase != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(monsterMainShirase.getUpdateDate()))) {

				//チェックOKの場合、更新
				monsterMainShirase = form.convertToMonsterMainShiraseForUpdate(monsterMainShirase);
				return monsterMainShiraseRepository.saveAndFlush(monsterMainShirase);
			}
		}
		return null;
	}

	@Override
	public void deleteMonsterById(final long id) {

		//更新対象レコードを取得する
		MonsterMainShirase monsterMainShirase = monsterMainShiraseRepository.findOne(id);
		if (monsterMainShirase != null) {

			//更新対象のレコードが存在する場所、削除フラグを1にする。
			monsterMainShiraseRepository.delete(id);
		}
	}

	@Override
	public void deleteMonsterComp(final ArrayList<Long> ids) {

		//対象のレコードを削除
		monsterMainShiraseRepository.deleteComp(ids);
	}
}
