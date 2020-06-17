package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.residentsSato.ResidentsSatoInputForm;
import jp.co.futureantiques.webapptraining.model.form.residentsSato.ResidentsSatoSearchForm;
import jp.co.futureantiques.webapptraining.model.residentsSato.AnimalSato;
import jp.co.futureantiques.webapptraining.model.residentsSato.ResidentsMainSato;
import jp.co.futureantiques.webapptraining.model.residentsSato.SexSato;

/**
 * ResidentsSatoのサービスインターフェース
 * @author future
 */
public interface ResidentsSatoService {

	/**
	 * 動物エンティティのリストを取得する
	 *
	 * @return AnimalSatoEntityのリスト
	 */
	List<AnimalSato> getListAnimalSato();

	/**
	 * 性別エンティティのリストを取得する
	 *
	 * @return SexSatoEntityのリスト
	 */
	List<SexSato> getListSexSato();

	/**
	 * 検索条件を元にResidentsMainSatoのレコードのリストを取得する(Paging)
	 *
	 * @param ResidentsSatoSearchForm form
	 * @param Pageable pageable
	 * @return ResidentsSatoのリスト
	 */
	Page<ResidentsMainSato> getPageResidentsSato(final ResidentsSatoSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にResidentsMainSatoのレコードのリストを取得する
	 *
	 * @param ResidentsSatoSearchForm form
	 * @return ResidentsMainSatoのリスト
	 */
	List<ResidentsMainSato> getListResidentsSato(final ResidentsSatoSearchForm form);

	/**
	 * IDをキーにResidentsMainSatoのレコードを取得する
	 * @param long id
	 * @return ResidentsSatoのレコード
	 */
	ResidentsMainSato getResidentsSato(final long id);

	/**
	 * ResidentsMainSatoにレコードを新規登録する
	 * @param ResidentsSatoInputForm form
	 * @return ResidentsSato
	 */
	ResidentsMainSato insertResidentsSato(final ResidentsSatoInputForm form);

	/**
	 *ResidentsSatoのレコードを更新する
	 * @param ResidentsSatoInputForm form
	 * @return ResidentsSato
	 */
	ResidentsMainSato updateResidentsSato(final ResidentsSatoInputForm form);

	/**
	 * ResidentsMainのレコードを論理削除する
	 * @param long id
	 */
	void deleteResidentsSatoById(final long id);

	/**
	 * ResidentsSatoのレコードを物理削除する
	 * @param ArrayList<Long> ids
	 */
	void deleteResidentsSatoComp(final ArrayList<Long> ids);
}