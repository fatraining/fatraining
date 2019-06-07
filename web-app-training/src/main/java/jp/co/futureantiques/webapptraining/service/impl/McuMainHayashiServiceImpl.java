package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.mcuMainHayashi.CharacterInputForm;
import jp.co.futureantiques.webapptraining.model.form.mcuMainHayashi.CharacterSearchForm;
import jp.co.futureantiques.webapptraining.model.mcuHayashi.McuMainHayashi;
import jp.co.futureantiques.webapptraining.model.mcuHayashi.SexHayashi;
import jp.co.futureantiques.webapptraining.model.mcuHayashi.TypeHayashi;
import jp.co.futureantiques.webapptraining.repository.mcuMainHayashi.McuMainHayashiRepository;
import jp.co.futureantiques.webapptraining.repository.mcuMainHayashi.SexHayashiRepository;
import jp.co.futureantiques.webapptraining.repository.mcuMainHayashi.TypeHayashiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.McuMainHayashiSpecification;
import jp.co.futureantiques.webapptraining.service.McuMainHayashiService;

/**
 * mcuMainHayashiのサービス実装クラス
 * リポジトリの上位
 *
 * @author 林 重樹
 */
@Service
public class McuMainHayashiServiceImpl implements McuMainHayashiService {

	/** mcuMainHayashiリポジトリ */
	private final McuMainHayashiRepository McuMainHayashiRepository;

	/** typeHayashiリポジトリ */
	private final TypeHayashiRepository typeHayashiRepository;

	/** sexHayashiリポジトリ */
	private final SexHayashiRepository sexHayashiRepository;

	/**
	 * コンストラクタ
	 *
	 * @param McuMainHayashiRepository mcuMainHayashiRepository
	 * @param typeHayashiRepository typeHayashiRepository
	 * @param sexHayashiRepository sexHayashiRepository
	 */
	@Autowired
	public McuMainHayashiServiceImpl(McuMainHayashiRepository mcuMainHayashiRepository,
			TypeHayashiRepository typeHayashiRepository,
			SexHayashiRepository sexHayashiRepository) {
		this.McuMainHayashiRepository = mcuMainHayashiRepository;
		this.typeHayashiRepository = typeHayashiRepository;
		this.sexHayashiRepository = sexHayashiRepository;
	}

	@Override
	public List<TypeHayashi> getListTypeHayashi() {

		// 人種テーブルのレコードをID順に取得する
		return typeHayashiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<SexHayashi> getListSexHayashi() {

		// 性別テーブルのレコードをID順に取得する
		return sexHayashiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<McuMainHayashi> getPageMcuMainHayashi(final CharacterSearchForm form, final Pageable pageable) {

		// 検索条件を生成しMcuMainHayashiテーブルのレコードを取得する
		return McuMainHayashiRepository.findAll(McuMainHayashiSpecification.generateCharacterSpecification(form),
				pageable);
	}

	@Override
	public List<McuMainHayashi> getListMcuMainHayashi(final CharacterSearchForm form) {

		// 検索条件を生成しMovieMainテーブルのレコードを取得する
		return McuMainHayashiRepository.findAll(McuMainHayashiSpecification.generateCharacterSpecification(form));
	}

	@Override
	public McuMainHayashi getMcuMainHayashi(final long id) {

		// MovieMainテーブルを主キー検索する
		return McuMainHayashiRepository.findOne(id);
	}

	@Override
	public McuMainHayashi insertMcuMainHayashi(final CharacterInputForm form) {

		// MovieMainテーブルに新規でデータを登録する
		final McuMainHayashi McuMainHayashi = form.convertToMcuMainHayashiForInsert();
		return McuMainHayashiRepository.save(McuMainHayashi);
	}

	@Override
	public McuMainHayashi updateMcuMainHayashi(final CharacterInputForm form) {

		// 更新対象のレコードを取得する
		McuMainHayashi mcuMaiHayashi = McuMainHayashiRepository.findOne((long) form.getId());
		if (mcuMaiHayashi != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(mcuMaiHayashi.getUpdateDate()))) {

				// チェックOKの場合、更新
				mcuMaiHayashi = form.convertToMcuMainHayashiForUpdate(mcuMaiHayashi);
				return McuMainHayashiRepository.saveAndFlush(mcuMaiHayashi);
			}
		}
		return null;
	}

	@Override
	public void deleteMcuMainHayashiById(final long id) {

		// 更新対象のレコードを取得する
		McuMainHayashi mcuMainHayashi = McuMainHayashiRepository.findOne(id);
		if (mcuMainHayashi != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			McuMainHayashiRepository.delete(id);
		}
	}

	@Override
	public void deleteMcuMainHayahiComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		McuMainHayashiRepository.deleteComp(ids);
	}
}