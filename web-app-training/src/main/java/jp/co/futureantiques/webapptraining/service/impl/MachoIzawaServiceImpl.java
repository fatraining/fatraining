package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.machoizawa.MuscleInputForm;
import jp.co.futureantiques.webapptraining.model.form.machoizawa.MuscleSearchForm;
import jp.co.futureantiques.webapptraining.model.machoizawa.BodyIzawa;
import jp.co.futureantiques.webapptraining.model.machoizawa.MuscleIzawa;
import jp.co.futureantiques.webapptraining.repository.machoizawa.BodyIzawaRepository;
import jp.co.futureantiques.webapptraining.repository.machoizawa.MuscleIzawaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.MuscleIzawaSpecification;
import jp.co.futureantiques.webapptraining.service.MachoIzawaService;

@Service
public class MachoIzawaServiceImpl implements MachoIzawaService {

	private final MuscleIzawaRepository muscleIzawaRepository;

	private final BodyIzawaRepository bodyIzawaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param MovieMainRepository movieMainRepository
	 * @param GenreRepository genreRepository
	 * @param MovieActorRepository movieActorRepository
	 */
	@Autowired
	public MachoIzawaServiceImpl(MuscleIzawaRepository muscleIzawaRepository, BodyIzawaRepository bodyIzawaRepository) {
		this.muscleIzawaRepository = muscleIzawaRepository;
		this.bodyIzawaRepository = bodyIzawaRepository;

	}

	@Override
	public List<BodyIzawa> getListBody() {

		// BodyテーブルのレコードをID順に取得する
		return bodyIzawaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));

	}

	@Override
	public Page<MuscleIzawa> getPageMuscle(final MuscleSearchForm form, final Pageable pageable) {

		// 検索条件を生成しMuscleIzawaテーブルのレコードを取得する
		return muscleIzawaRepository.findAll(MuscleIzawaSpecification.generateMuscleIzawaSpecification(form), pageable);
	}

	@Override
	public List<MuscleIzawa> getListMuscle(final MuscleSearchForm form) {

		// 検索条件を生成しMuscleIzawaテーブルのレコードを取得する
		return muscleIzawaRepository.findAll(MuscleIzawaSpecification.generateMuscleIzawaSpecification(form));
	}

	@Override
	public MuscleIzawa insertMuscle(final MuscleInputForm form) {

		// MuscleIzawaテーブルに新規でデータを登録する
		final MuscleIzawa muscleIzawa = form.convertToMuscleIzawaForInsert();
		return muscleIzawaRepository.save(muscleIzawa);
	}

	@Override
	public MuscleIzawa updateMuscle(final MuscleInputForm form) {

		// 更新対象のレコードを取得する
		MuscleIzawa muscleIzawa = muscleIzawaRepository.findOne((long) form.getId());
		if (muscleIzawa != null) {
			muscleIzawa = form.convertToMuscleIzawaForUpdate(muscleIzawa);
			return muscleIzawaRepository.saveAndFlush(muscleIzawa);
		}

		return null;
	}

	@Override
	public MuscleIzawa getMuscle(final long id) {

		// MuscleIzawaテーブルを主キー検索する
		return muscleIzawaRepository.findOne(id);
	}

	@Override
	public void deleteMuscleById(final long id) {

		// 更新対象のレコードを取得する
		MuscleIzawa muscleIzawa = muscleIzawaRepository.findOne(id);
		if (muscleIzawa != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			muscleIzawaRepository.delete(id);
		}
	}

	@Override
	public void deleteMuscleComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		muscleIzawaRepository.deleteComp(ids);
	}

}