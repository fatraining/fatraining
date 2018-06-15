package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.machoizawa.MuscleInputForm;
import jp.co.futureantiques.webapptraining.model.form.machoizawa.MuscleSearchForm;
import jp.co.futureantiques.webapptraining.model.machoizawa.BodyIzawa;
import jp.co.futureantiques.webapptraining.model.machoizawa.MuscleIzawa;

@Service
public interface MachoIzawaService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return Body_izawaEntityのリスト
	 */
	List<BodyIzawa> getListBody();

	/**
	 * 検索条件を元にMovieMainのレコードのリストを取得する(Paging)
	 *
	 * @param MovieSampleSearchForm form
	 * @param Pageable pageable
	 * @return MovieMainのリスト
	 */
	Page<MuscleIzawa> getPageMuscle(final MuscleSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にMovieMainのレコードのリストを取得する
	 *
	 * @param MovieSampleSearchForm form
	 * @return MovieMainのリスト
	 */
	List<MuscleIzawa> getListMuscle(final MuscleSearchForm form);

	/**
	 * IDをキーにMovieMainのレコードを取得する
	 *
	 * @param long id
	 * @return MovieMainのレコード
	 */
	MuscleIzawa getMuscle(final long id);

	/**
	 * MovieMainにレコードを新規登録する
	 *
	 * @param MovieSampleInputForm form
	 * @return MovieMain
	 */
	MuscleIzawa insertMuscle(final MuscleInputForm form);

	/**
	 * MovieMainのレコードを更新する
	 *
	 * @param MovieSampleInputForm form
	 * @return MovieMain
	 */
	MuscleIzawa updateMuscle(final MuscleInputForm form);

	/**
	 * MovieMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteMuscleById(final long id);

	/**
	 * MovieMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteMuscleComp(final ArrayList<Long> ids);


}
