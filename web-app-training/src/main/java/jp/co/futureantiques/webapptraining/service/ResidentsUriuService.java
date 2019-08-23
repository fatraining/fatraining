package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.residentsUriu.ResidentsUriuInputForm;
import jp.co.futureantiques.webapptraining.model.form.residentsUriu.ResidentsUriuSearchForm;
import jp.co.futureantiques.webapptraining.model.residentsUriu.AnimalUriu;
import jp.co.futureantiques.webapptraining.model.residentsUriu.ResidentsMainUriu;
import jp.co.futureantiques.webapptraining.model.residentsUriu.TypeUriu;

/**
 * ResidentsUriuのサービスインターフェース
 *
 */

public interface ResidentsUriuService {

	/**
	 * 性格タイプエンティティのリストを取得する
	 *
	 * @return TypeUriuEntityのリスト
	 */
	List<TypeUriu> getListTypeUriu();

	/**
	 * どうぶつエンティティのリストを取得する
	 *
	 * @return AnimalUriuEntityのリスト
	 */
	List<AnimalUriu> getListAnimalUriu();

	/**
	 * 検索条件をもとにResidentsMainUriuのレコードリストを取得（paging）
	 *
	 * @param ResidentsUriuSearchForm form
	 * @param pageable pageable
	 * @return ResidentsMainUriuのリスト
	 */
	Page<ResidentsMainUriu> getPageResidentsUriu(final ResidentsUriuSearchForm form,final Pageable pageable);

	/**
	 * 検索条件をもとにResidentsMainUriuのレコードのリストを取得する
	 *
	 * @param long id
	 * @return ResidentsMainのレコード
	 */
	List<ResidentsMainUriu> getListResidentsUriu(final ResidentsUriuSearchForm form);

	/**
	 * IDをキーにResidentsMainUriuのレコードを取得する
	 *
	 * @param long id
	 * @return ResidentsMainUriuのレコード
	 */
	ResidentsMainUriu getResidentsUriu(final long id);

	/**
	 * ResidentsMainUriuにレコードを新規登録する
	 *
	 * @param ResidentsUriuInputForm form
	 * @return ResidentsMainUriu
	 */
	ResidentsMainUriu insertResidentsUriu(final ResidentsUriuInputForm form);

	/**
	 * ResidentsMainUriuのレコードを削除する
	 *
	 * @param ResidentsUriuInputForm form
	 * @return ResidentdMainUriu
	 */
	ResidentsMainUriu updateResidentsUriu(final ResidentsUriuInputForm form);

	/**
	 * ResidentsUriuのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteResidentsUriuById(final long id);

	/**
	 * ResidentsMainUriuのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteResidentsUriuComp(final ArrayList<Long> ids);

}
