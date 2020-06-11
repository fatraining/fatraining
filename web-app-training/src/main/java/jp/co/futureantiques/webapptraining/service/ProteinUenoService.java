package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.proteinUeno.ProteinUenoInputForm;
import jp.co.futureantiques.webapptraining.model.form.proteinUeno.ProteinUenoSearchForm;
import jp.co.futureantiques.webapptraining.model.proteinUeno.KindsUeno;
import jp.co.futureantiques.webapptraining.model.proteinUeno.MakerUeno;
import jp.co.futureantiques.webapptraining.model.proteinUeno.ProteinMainUeno;

/**
 * ProteinUenoのサービスインターフェイス
 * @author ueno
 *
 */
public interface ProteinUenoService {

	/**
	 * 種類エンティティのリストを取得する
	 *
	 * @return KindsUenoEntityのリスト
	 */
	List<KindsUeno> getListKindsUeno();

	/**
	 * メーカーエンティティのリストを取得する
	 *
	 *@return MakerUenoEntityのリスト
	 */
	List<MakerUeno> getListMakerUeno();

	/**
	 * 検索条件を元にProteinMainUenoのレコードのリストを取得する
	 *
	 * @param ProteinSearchForm form
	 * @param Pageble pageble
	 * @return ProteinMainUenoのリスト
	 */
	Page<ProteinMainUeno> getPageProtein(final ProteinUenoSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にProteinMainUenoのレコードを取得する
	 *
	 * @param ProteinUenoSearchForm form
	 * @return  ProteinMainUenoのリスト
	 */
	List<ProteinMainUeno> getListProtein(final ProteinUenoSearchForm form);

	/**
	 * IDをキーにProteinMainUenoのレコードを取得する
	 *
	 * @param long id
	 * @return ProteinMainUeno
	 */
	ProteinMainUeno getProtein(final long id);

	/**
	 * ProteinMainUenoにレコードを新規作成する
	 *
	 * @param ProteinUenoInputForm form
	 * @return ProteinMainUeno
	 */
	ProteinMainUeno insertProtein(final ProteinUenoInputForm form);

	/**
	 * ProteinMainUenoのレコードを更新する
	 * @param ProteinUenoInputForm form
	 * @return ProteinMainUeno
	 */
	ProteinMainUeno updateProtein(final ProteinUenoInputForm form);

	/**
	 * ProteinMainUenoのレコードを論理削除する
	 *
	 * @param long
	 */
	void deleteProteinById(final long id);

	/**
	 * ProteinUenoのレコードを物理削除する
	 * @param ArrayList<Long> ids
	 */
	void deleteProteinComp(final ArrayList<Long> ids);

}
